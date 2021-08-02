FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}-${PV}:"
require recipes-kernel/linux/linux-imx.inc

SUMMARY = "Linux kernel for Toradex Colibri VFxx Computer on Modules"

SRC_URI = "git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH} \
           file://defconfig"

KERNEL_MODULE_AUTOLOAD += "${@bb.utils.contains('COMBINED_FEATURES', 'usbgadget', ' libcomposite', '',d)}"

LOCALVERSION = "-0.0.0"
PV:append = "+git${SRCPV}"

LINUX_VERSION = "4.4.274"

SRCBRANCH = "toradex_vf_4.4"
SRCREV = "d900385139e5aa8d584dee92c87bb85d0226253e"

DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(vf)"
