# Congatec QMX6 Linux/kernel

LICENSE = "GPLv2"

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "cgt_imx_3.10.31_1.1.0_beta2"

SRC_URI = "git://git.congatec.com/arm/qmx6_kernel.git;protocol=http;branch=${SRCBRANCH} \
           file://defconfig \
"

SRCREV = "4571a1748729add12c191d3717e26e1c3a915404"
LOCALVERSION = "-1.1.0-beta2_qmx6"

COMPATIBLE_MACHINE = "(cgtqmx6)"
