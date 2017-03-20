# Congatec QMX6 Linux/kernel

LICENSE = "GPLv2"

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "cgt_imx6_4.1.15_2.0.0"

SRC_URI = "git://git.congatec.com/arm/imx6_kernel_4.1.git;protocol=http;branch=${SRCBRANCH} \
           file://defconfig \
	   file://0001-imx6qdl-qmx6-Change-bit-color-depth-and-pix-format.patch \
"

SRCREV = "bdea10a64bdbc411e4a2ed4d6b9578919a148083"
#LOCALVERSION = "-2.0.0_cgt-imx6"

COMPATIBLE_MACHINE = "(cgtqmx6|cgtumx6|cgtimx6)"
