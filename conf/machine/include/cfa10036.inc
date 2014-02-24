# Common definitions for cfa-10036 boards

include conf/machine/include/mxs-base.inc

SOC_FAMILY = "mxs:mx28:cfa10036"

PREFERRED_PROVIDER_virtual/kernel ?= "linux-cfa"

IMAGE_BOOTLOADER = "barebox"
BAREBOX_BINARY = "barebox"

IMXBOOTLETS_MACHINE = "cfa10036"

KERNEL_IMAGETYPE = "zImage"
KERNEL_DEVICETREE = "imx28-cfa10036.dtb"

# we need the kernel to be installed in the final image
IMAGE_INSTALL_append = " kernel-image kernel-devicetree"

SDCARD_ROOTFS ?= "${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.ext3"
IMAGE_FSTYPES ?= "tar.bz2 ext3 barebox.mxsboot-sdcard sdcard"

SERIAL_CONSOLE = "115200 ttyAMA0"

MACHINE_FEATURES = "usbgadget usbhost vfat"

# Overrides due use of non-FSL kernel
PREFERRED_VERSION_imx-test = "00.00.00"
MACHINE_GSTREAMER_PLUGIN_cfa10036 = ""
