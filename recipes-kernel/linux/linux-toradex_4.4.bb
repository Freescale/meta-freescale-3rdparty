FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"
require recipes-kernel/linux/linux-imx.inc

SUMMARY = "Linux kernel for Toradex Colibri VFxx Computer on Modules"

SRC_URI = "git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH} \
           file://defconfig"

KERNEL_MODULE_AUTOLOAD += "${@bb.utils.contains('COMBINED_FEATURES', 'usbgadget', ' libcomposite', '',d)}"

LOCALVERSION = "-2.7.4"
PV_append = "+git${SRCPV}"

SRCBRANCH = "toradex_vf_4.4"
SRCREV = "e0f2806138a4eeb3c31abe0e0e767d0f6d9a13a3"

DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(vf)"
