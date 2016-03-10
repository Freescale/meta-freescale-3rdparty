require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux kernel for Toradex Colibri VFxx Computer on Modules"

SRC_URI = "git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH} \
           file://defconfig"

LOCALVERSION = "-v2.5b3"
SRCBRANCH = "toradex_vf_4.1"
SRCREV = "e6d111cd909551cec5902358db1e25dcaa8c86bb"
DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(vf)"
