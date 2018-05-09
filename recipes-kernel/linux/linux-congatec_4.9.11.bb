# Congatec QMX6 Linux/kernel

LICENSE = "GPLv2"

require recipes-kernel/linux/linux-imx.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "cgt_imx_4.9.11_1.0.0"

SRC_URI = "git://git.congatec.com/arm/imx6_kernel_4.9.git;protocol=http;branch=${SRCBRANCH} \
           file://defconfig \
	   "
SRCREV = "da3c7d59e10b8c83087c9bd40de49a4fec1247f7"

COMPATIBLE_MACHINE = "(cgtqmx6|cgtumx6|cgtimx6)"
