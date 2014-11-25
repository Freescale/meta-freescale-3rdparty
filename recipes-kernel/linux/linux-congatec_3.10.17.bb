# Congatec QMX6 Linux/kernel

LICENSE = "GPLv2"

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "cgt_imx_3.10.17_1.0.2"

SRC_URI = "git://git.congatec.com/arm/qmx6_kernel.git;protocol=http;branch=${SRCBRANCH} \
           file://defconfig \
"

SRCREV = "c5c5cfafde65a58d8af3785a16d2173eb53f7b1f"
LOCALVERSION = "-1.0.2_qmx6"

COMPATIBLE_MACHINE = "(cgtqmx6)"
