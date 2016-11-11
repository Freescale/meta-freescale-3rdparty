# Congatec QMX6 Linux/kernel

LICENSE = "GPLv2"

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "cgt_qmx6_3.14-1.0.x-mx6_1.0.0"

SRC_URI = "git://git.congatec.com/arm/imx6_kernel_3.14.git;protocol=http;branch=${SRCBRANCH} \
           file://Fix-the-compile-issue-under-gcc6.patch \
           file://defconfig"

SRCREV = "311e836f22da59ba682f05973f2a138cd9eececa"
LOCALVERSION = "-1.0.x-mx6-qmx6"


COMPATIBLE_MACHINE = "(cgtqmx6)"
