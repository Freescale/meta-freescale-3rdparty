# Common definitions to all iMX233-OlinuXino variants

# Add a override for all iMX233-OLinuXino variants
MACHINEOVERRIDES =. "mxs:mx23:imx233-olinuxino:"

include conf/machine/include/imx-base.inc
include conf/machine/include/tune-arm926ejs.inc

IMXBOOTLETS_MACHINE = "stmp378x_dev"
UBOOT_MACHINE = "mx23_olinuxino_config"

KERNEL_IMAGETYPE = "uImage"
KERNEL_DEVICETREE = "imx23-olinuxino.dtb"

MACHINE_FEATURES = "usbgadget usbhost vfat"
