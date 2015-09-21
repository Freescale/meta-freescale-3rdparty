# Common definitions to all iMX233-OlinuXino variants

include conf/machine/include/imx-base.inc
include conf/machine/include/tune-arm926ejs.inc

IMXBOOTLETS_MACHINE = "stmp378x_dev"
UBOOT_MACHINE = "mx23_olinuxino_config"

# Add a override for all iMX233-OLinuXino variants
SOC_FAMILY = "mxs:mx23:imx233-olinuxino"

KERNEL_IMAGETYPE = "uImage"
KERNEL_DEVICETREE = "imx23-olinuxino.dtb"

MACHINE_FEATURES = "apm usbgadget usbhost vfat"
