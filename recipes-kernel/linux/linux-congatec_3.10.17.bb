# Congatec QMX6 Linux/kernel

LICENSE = "GPLv2"

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "cgt_imx_3.10.17_1.0.0"

SRC_URI = "git://git.congatec.com/arm/qmx6_kernel.git;protocol=http;branch=${SRCBRANCH} \
           file://defconfig \
"

SRCREV = "9a3e94917d94b901b674cece0a3576b427a63b12"
LOCALVERSION = "-1.0.0_qmx6"

COMPATIBLE_MACHINE = "(cgtqmx6)"
