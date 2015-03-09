require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux kernel for Toradex Colibri VFxx Computer on Modules"

SRC_URI = "git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH} \
           file://defconfig"

LOCALVERSION = "-v2.3b7"
SRCBRANCH = "toradex_vf_3.18"
SRCREV = "c78b5ae472e69452d5fe44c261d57c8083c59f74"
DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(vf)"
