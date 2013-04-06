# Common definitions to all iMX233-OlinuXino variants

include conf/machine/include/mxs-base.inc

# Add a override for all iMX233-OLinuXino variants
SOC_FAMILY = "imx233-olinuxino:mx23:mxs"

IMXBOOTLETS_MACHINE = "stmp378x_dev"

KERNEL_IMAGETYPE = "zImage"
KERNEL_DEVICETREE = "${S}/arch/arm/boot/dts/imx23-olinuxino.dts"

IMAGE_BOOTLOADER = "imx-bootlets"

SDCARD_ROOTFS ?= "${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.ext3"
IMAGE_FSTYPES ?= "tar.bz2 ext3 linux.sb sdcard"

MACHINE_FEATURES = "apm usbgadget usbhost vfat alsa"
