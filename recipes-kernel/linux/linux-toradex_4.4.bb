FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"
require recipes-kernel/linux/linux-imx.inc

SUMMARY = "Linux kernel for Toradex Colibri VFxx Computer on Modules"

SRC_URI = "git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH} \
           file://defconfig"

KERNEL_MODULE_AUTOLOAD += "${@bb.utils.contains('COMBINED_FEATURES', 'usbgadget', ' libcomposite', '',d)}"

LOCALVERSION = "-2.8.3"
PV_append = "+git${SRCPV}"

SRCBRANCH = "toradex_vf_4.4-next"
SRCREV = "166cb6f4a4aff202d98914fe0c5530d26ce671a5"

DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(vf)"
