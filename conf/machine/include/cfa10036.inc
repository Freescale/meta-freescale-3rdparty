# Common definitions for cfa-10036 boards

MACHINEOVERRIDES =. "mxs:mx28:cfa10036:"

include conf/machine/include/imx-base.inc
include conf/machine/include/tune-arm926ejs.inc

PREFERRED_PROVIDER_virtual/kernel ?= "linux-cfa"
PREFERRED_PROVIDER_virtual/bootloader ?= "barebox"

IMAGE_BOOTLOADER = "barebox"
BAREBOX_BINARY = "barebox"
IMAGE_FSTYPES_mxs = "tar.bz2 barebox.mxsboot-sdcard sdcard.gz"

IMXBOOTLETS_MACHINE = "cfa10036"

KERNEL_IMAGETYPE = "zImage"
KERNEL_DEVICETREE = "imx28-cfa10036.dtb"

# we need the kernel to be installed in the final image
IMAGE_INSTALL_append = " kernel-image kernel-devicetree"

SDCARD_ROOTFS ?= "${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.ext3"

SERIAL_CONSOLE = "115200 ttyAMA0"

MACHINE_FEATURES = "usbgadget usbhost vfat"

# Overrides due use of non-FSL kernel
PREFERRED_VERSION_imx-test = "00.00.00"
MACHINE_GSTREAMER_PLUGIN_cfa10036 = ""
