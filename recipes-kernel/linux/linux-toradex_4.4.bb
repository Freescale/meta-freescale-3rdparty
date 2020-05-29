FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"
require recipes-kernel/linux/linux-imx.inc

SUMMARY = "Linux kernel for Toradex Colibri VFxx Computer on Modules"

SRC_URI = "git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH} \
           file://defconfig"

KERNEL_MODULE_AUTOLOAD += "${@bb.utils.contains('COMBINED_FEATURES', 'usbgadget', ' libcomposite', '',d)}"

LOCALVERSION = "-2.8.3"
PV_append = "+git${SRCPV}"

LINUX_VERSION = "4.4.217"

SRCBRANCH = "toradex_vf_4.4"
SRCREV = "4a31b8a3519d5dde0eacbb088b0d45c83732535b"

DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(vf)"
