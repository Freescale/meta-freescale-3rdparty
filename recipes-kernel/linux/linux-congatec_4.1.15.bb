# Congatec QMX6 Linux/kernel

LICENSE = "GPLv2"

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "cgt_imx6_4.1.15_1.2.0"

SRC_URI = "git://git.congatec.com/arm/imx6_kernel_4.1.git;protocol=http;branch=${SRCBRANCH} \
           file://defconfig \
	   file://Fix-the-compile-issue-under-gcc6.patch  \
	   file://gpu-viv_gcc6_indent_warning_error_fix.patch \
"

SRCREV = "d83cc3c81cb13212c62822822e08c7e6da75eec6"
#LOCALVERSION = "-1.2.0_cgt-imx6"

COMPATIBLE_MACHINE = "(cgtqmx6|cgtumx6|cgtimx6)"
