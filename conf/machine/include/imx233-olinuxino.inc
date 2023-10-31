# Common definitions to all iMX233-OlinuXino variants

# Add a override for all iMX233-OLinuXino variants
MACHINEOVERRIDES =. "mxs:mx23:imx233-olinuxino:"

include conf/machine/include/imx-base.inc
include conf/machine/include/arm/armv5/tune-arm926ejs.inc

# This machine is not supported by u-boot-imx as it is not tested by NXP on this
# board. So we force it to use u-boot-fslc which is based on mainline here.
IMX_DEFAULT_BOOTLOADER = "u-boot-fslc"

UBOOT_MAKE_TARGET = "u-boot.sb"
UBOOT_SUFFIX = "sb"

IMXBOOTLETS_MACHINE = "stmp378x_dev"
UBOOT_MACHINE = "mx23_olinuxino_config"

KERNEL_IMAGETYPE = "uImage"
KERNEL_DEVICETREE = "nxp/mxs/imx23-olinuxino.dtb"

MACHINE_FEATURES = "usbgadget usbhost vfat"
