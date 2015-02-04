# Common definitions to all iMX233-OlinuXino variants

include conf/machine/include/mxs-base.inc

IMXBOOTLETS_MACHINE = "stmp378x_dev"
UBOOT_MACHINE = "mx23_olinuxino_config"

# Add a override for all iMX233-OLinuXino variants
SOC_FAMILY = "mxs:mx23:imx233-olinuxino"

KERNEL_IMAGETYPE = "uImage"
KERNEL_DEVICETREE = "imx23-olinuxino.dtb"

SDCARD_ROOTFS ?= "${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.ext3"
IMAGE_FSTYPES ?= "tar.bz2 ext3 uboot.mxsboot-sdcard sdcard"

MACHINE_FEATURES = "apm usbgadget usbhost vfat"
