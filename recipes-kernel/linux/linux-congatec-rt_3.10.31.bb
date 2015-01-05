# Congatec QMX6 Linux/kernel PREEMPT_RT, based on linux-imx-rt_3.10.31.bb

SUMMARY = "Linux real-time kernel based on linux-congatec"
DESCRIPTION = "Linux kernel that is based on Congatec's Linux, \
with added real-time capabilities."

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "cgt_imx_3.10.31_1.1.0_beta2"

SRCREV = "d18ae52fb37b2ca391cb50434f14bee28ff94144"
SRC_URI = "git://git.congatec.com/arm/qmx6_kernel.git;protocol=http;branch=${SRCBRANCH} \
           file://0001-ARM-clk-imx6q-fix-video-divider-for-revision-1.0-of-.patch \
           file://defconfig \
           https://www.kernel.org/pub/linux/kernel/projects/rt/3.10/older/patch-3.10.27-rt25.patch.gz;name=rt-patch1 \
           file://0001-fix-build.patch \
           file://0002-fix-build-with-rt-enabled.patch \
           file://0003-no-split-ptlocks.patch \
"
SRC_URI[rt-patch1.md5sum] = "aa231425f2a43220b5e8dbb057c7e5f9"
SRC_URI[rt-patch1.sha256sum] = "5fbee5cdf260db9b7751651ab141fb59f46d68c7aecfc32e81a2b5d702f47aac"

LOCALVERSION = "-1.1.0_beta2"

COMPATIBLE_MACHINE = "(cgtqmx6)"
