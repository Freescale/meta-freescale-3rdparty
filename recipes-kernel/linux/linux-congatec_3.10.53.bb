# Congatec QMX6 Linux/kernel

LICENSE = "GPLv2"

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "cgt_imx_3.10.53_1.1.1"

SRC_URI = "git://git.congatec.com/arm/qmx6_kernel.git;protocol=http;branch=${SRCBRANCH} \
           file://defconfig \
	   file://0001-ARM-clk-imx6q-fix-video-divider-for-revision-1.0-of-.patch \
"

SRCREV = "9f56bf91efd1e1b286a09264a34da1b6abb58959"
LOCALVERSION = "-1.1.1_qmx6"


COMPATIBLE_MACHINE = "(cgtqmx6)"
