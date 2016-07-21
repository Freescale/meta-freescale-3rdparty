require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux kernel for Toradex Freescale i.MX based modules"

SRC_URI = "git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH} \
           file://defconfig"

LOCALVERSION = "-v2.6b2.1"
SRCBRANCH = "toradex_imx_3.14.52_1.1.0_ga"
SRCREV = "9f2723e14bab4fb558b4a4eb3e941876e2c55e2a"
DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(mx6)"
