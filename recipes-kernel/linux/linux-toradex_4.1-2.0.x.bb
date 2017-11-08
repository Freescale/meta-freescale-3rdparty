FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"
require recipes-kernel/linux/linux-imx.inc

SUMMARY = "Linux kernel for Toradex Freescale i.MX based modules"

SRC_URI = "git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH} \
           file://defconfig"

# Load USB functions configurable through configfs (CONFIG_USB_CONFIGFS)
KERNEL_MODULE_AUTOLOAD += "${@bb.utils.contains('COMBINED_FEATURES', 'usbgadget', ' libcomposite', '',d)}"

LOCALVERSION = "-2.7.4"
PV_append = "+git${SRCPV}"

SRCBRANCH = "toradex_4.1-2.0.x-imx"
SRCREV = "b1555bfbf38818bc6fed8d921b55b7b207249c53"

DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(mx6|mx7)"
