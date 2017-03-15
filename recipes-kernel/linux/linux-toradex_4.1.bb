require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux kernel for Toradex Colibri VFxx Computer on Modules"

SRC_URI = "git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH} \
           file://defconfig"

LOCALVERSION = "-v2.5.1"
SRCBRANCH = "toradex_vf_4.1"
SRCREV = "39ac0033f2345ce7b5d8ca4439192407dacb2355"
DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(vf)"
