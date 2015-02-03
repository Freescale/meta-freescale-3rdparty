# Congatec QMX6 Linux/kernel

LICENSE = "GPLv2"

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "cgt_imx_3.10.17_1.0.2"

SRC_URI = "git://git.congatec.com/arm/qmx6_kernel.git;protocol=http;branch=${SRCBRANCH} \
           file://defconfig \
"

SRCREV = "c0f226dccf6e89eacb7174b40fdf54e55cef59f9"
LOCALVERSION = "-1.0.2_qmx6"

COMPATIBLE_MACHINE = "(cgtqmx6)"
