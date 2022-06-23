require recipes-kernel/linux/linux-imx.inc

SUMMARY = "Linux kernel for Toradex Colibri VFxx Computer on Modules"

SRC_URI = "git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH}"

KBUILD_DEFCONFIG ?= "colibri_vf_defconfig"

KERNEL_MODULE_AUTOLOAD += "${@bb.utils.contains('COMBINED_FEATURES', 'usbgadget', ' libcomposite', '',d)}"

LOCALVERSION = "-0.0.0"
PV:append = "+git${SRCPV}"

LINUX_VERSION = "4.4.291"

SRCBRANCH = "toradex_vf_4.4"
SRCREV = "4a0abd7dd466276ee3fdf79b54f05f845f7d8844"

DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(vf-generic-bsp)"
