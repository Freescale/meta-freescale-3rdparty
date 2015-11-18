SUMMARY = "Linux Kernel for Ka-Ro electronics TX Computer-On-Modules"

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "karo-tx6"
LOCALVERSION = "-2015-09-18"
SRCREV = "5340e6663c3b575808a5be437a25d8a7f85cb658"
KERNEL_SRC = "git://git.karo-electronics.de/karo-tx-linux.git;protocol=git"
SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH} \
           file://defconfig \
"

KERNEL_IMAGETYPE="uImage"

COMPATIBLE_MACHINE  = "(tx6[qsu]-.*)"
