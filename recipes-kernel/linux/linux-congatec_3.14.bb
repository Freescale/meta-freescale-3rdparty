# Congatec QMX6 Linux/kernel

LICENSE = "GPLv2"

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "cgt_qmx6_3.14-1.0.x-mx6_1.0.0"

SRC_URI = "git://git.congatec.com/arm/imx6_kernel_3.14.git;protocol=http;branch=${SRCBRANCH} \
           file://defconfig"

SRCREV = "f5eee0b0b67b3021676dc9fd47cf95e1dd88b749"
LOCALVERSION = "-1.0.x-mx6-qmx6"


COMPATIBLE_MACHINE = "(cgtqmx6)"
