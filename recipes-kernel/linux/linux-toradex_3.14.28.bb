require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux kernel for Toradex Freescale i.MX based modules"

SRC_URI = "git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH} \
           file://defconfig"

LOCALVERSION = "-v2.5b2"
SRCBRANCH = "toradex_imx_3.14.28_1.0.0_ga"
SRCREV = "8f237ebe42f2cb911245369276a6b3043c2815f2"
DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(mx6)"
