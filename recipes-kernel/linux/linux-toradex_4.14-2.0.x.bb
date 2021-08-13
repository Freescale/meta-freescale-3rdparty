FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}-${PV}:"

require recipes-kernel/linux/linux-imx.inc

DEPENDS += "lzop-native bc-native"

SUMMARY = "Linux kernel for Toradex Freescale i.MX based modules"

SRC_URI = "git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH} \
           file://defconfig"

# Load USB functions configurable through configfs (CONFIG_USB_CONFIGFS)
KERNEL_MODULE_AUTOLOAD += "${@bb.utils.contains('COMBINED_FEATURES', 'usbgadget', ' libcomposite', '',d)}"

PV:append = "+git${SRCPV}"

LINUX_VERSION = "4.14.159"

SRCREV = "1f43bce17a57a29d180ab0facb83a88b1fb9c797"
SRCBRANCH = "toradex_4.14-2.0.x-imx"

COMPATIBLE_MACHINE = "(mx6|mx7)"
