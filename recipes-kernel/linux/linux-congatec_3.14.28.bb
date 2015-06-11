# Congatec QMX6 Linux/kernel

LICENSE = "GPLv2"

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "cgt_qmx6_3.14.28_1.0.0"

SRC_URI = "git://git.congatec.com/arm/imx6_kernel_3.14.git;protocol=http;branch=${SRCBRANCH} \
           file://defconfig \
	   file://0001-ARM-imx6q-drop-unnecessary-semicolon.patch \
	   file://0002-ARM-clk-imx6q-fix-video-divider-for-rev-T0-1.0.patch \
	   file://0003-ARM-imx6sl-Disable-imx6sl-specific-code-when-imx6sl-.patch \
"

SRCREV = "644b0355a3f6324a1a24dd55bcdb4ead0d587d82"
LOCALVERSION = "-1.0.0_qmx6"


COMPATIBLE_MACHINE = "(cgtqmx6)"
