require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux kernel for Toradex Colibri VFxx Computer on Modules"

SRC_URI = "git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH} \
           file://defconfig"

LOCALVERSION = "-v2.4b1.1"
SRCBRANCH = "toradex_vf_4.0"
SRCREV = "85f663301364d015738e9cc7c77bd8c550262df0"
DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(vf)"
