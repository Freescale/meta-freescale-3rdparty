require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux kernel for Toradex Colibri VFxx Computer on Modules"

SRC_URI = "git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH} \
           file://defconfig"

LOCALVERSION = "-v2.5b2"
SRCBRANCH = "toradex_vf_4.1"
SRCREV = "559570ccdc6555d2228a4e4e9e589e3145d7c2e4"
DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(vf)"
