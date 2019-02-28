#!/bin/sh
#===============================================================================
#
#  Copyright (C) 2019 by Digi International Inc.
#  All rights reserved.
#
#  This program is free software; you can redistribute it and/or modify it
#  under the terms of the GNU General Public License version 2 as published by
#  the Free Software Foundation.
#
#
#  !Description: Initialize bluetooth hardware
#
#===============================================================================

# Bluetooth power GPIO
BT_EN_QCA_GPIO_NR="137"

# set_gpio_value <gpio_nr> <value>
set_gpio_value() {
	local SG_GPIONR="${1}"
	local SG_GPIOVAL="${2}"
	local SG_GPIOPATH="/sys/class/gpio/gpio${SG_GPIONR}"

	[ -d "${SG_GPIOPATH}" ] || printf "%s" "${SG_GPIONR}" > /sys/class/gpio/export
	printf out > "${SG_GPIOPATH}/direction" && sleep .2
	printf "${SG_GPIOVAL}" > "${SG_GPIOPATH}/value" && sleep .2
	[ -d "${SG_GPIOPATH}" ] && printf "%s" "${SG_GPIONR}" > /sys/class/gpio/unexport
}

# powercycle_gpio <gpio_nr>
powercycle_gpio() {
	set_gpio_value "${1}" 0
	set_gpio_value "${1}" 1
}

set_mac_address() {
	# Get MAC address from the device tree. Use a default value if it has not been set.
	BT_MACADDR="$(hexdump -ve '1/1 "%02X" ":"' /proc/device-tree/bluetooth/mac-address 2>/dev/null | sed 's/:$//g')"
	if [ -z "${BT_MACADDR}" ] || [ "${BT_MACADDR}" = "00:00:00:00:00:00" ]; then
		BT_MACADDR="00:04:F3:FF:FF:BB"
	fi

	# Convert the BT address to the hcitool command format.
	#   Example:  "00:04:F3:11:22:33" coverted to "33 22 11 F3 04 00"
	HCI_BT_ADDR="$(echo ${BT_MACADDR} | sed -e 's,^\(..\):\(..\):\(..\):\(..\):\(..\):\(..\)$,\6 \5 \4 \3 \2 \1,g')"

	# Up the interface to be able to send hci commands
	hciconfig hci0 up ||  echo "Cannot bring up bluetooth interface after initial attach" || exit 1

	# Set the MAC address
	hcitool -i hci0 cmd 3F 000B 01 02 06 ${HCI_BT_ADDR} > /dev/null || echo "Unable to set BT MAC Address" || exit 1

	# Bring the interface down/up to apply the MAC change
	hciconfig hci0 down ||  echo "Cannot bring down bluetooth interface after setting MAC" || exit 1
	hciconfig hci0 up ||  echo "Cannot bring up bluetooth interface after setting MAC" || exit 1

}

bluetooth_init() {
	# Start the Bluetooth driver and bring up the interface
	killproc hciattach
	powercycle_gpio "${BT_EN_QCA_GPIO_NR}"
	hciattach ttymxc0 qualcomm 115200 -t3 flow unused > /dev/null 2>&1 || BT_ERROR="FAIL (hciattach)"
	set_mac_address || BT_ERROR="Unable to set MAC address"
}

# Source function library
. /etc/init.d/functions

case "$1" in
	start)
		if [ -d "/proc/device-tree/bluetooth" ]; then
			echo -n "Starting bluetooth hardware: "
			bluetooth_init
			echo "${BT_ERROR:-done.}"
		fi
		;;
	stop)
		if [ -d "/sys/class/bluetooth/hci0" ]; then
			echo -n "Stopping bluetooth hardware: "
			killproc hciattach
			# Power down bluetooth
			set_gpio_value "${BT_EN_QCA_GPIO_NR}" 0
			echo "done."
		fi
		;;
	restart)
		$0 stop
		sleep 1
		$0 start
		;;
	*)
		echo "Usage: $0 {start|stop|restart}"
		exit 1
		;;
esac
