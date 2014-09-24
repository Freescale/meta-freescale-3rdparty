# Congatec QMX6 Linux/kernel

LICENSE = "GPLv2"

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "cgt_imx_3.10.17_1.0.0"

SRC_URI = "git://git.congatec.com/arm/qmx6_kernel.git;protocol=http;branch=${SRCBRANCH} \
           file://defconfig \
"

SRCREV = "9bafbcba67f7bb2a48a5e05998cecb1165aa444f"
LOCALVERSION = "-1.0.0_qmx6"

COMPATIBLE_MACHINE = "(cgtqmx6)"
