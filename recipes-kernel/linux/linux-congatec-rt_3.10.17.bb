# Congatec QMX6 Linux/kernel PREEMPT_RT, based on linux-imx-rt_3.10.17.bb

SUMMARY = "Linux real-time kernel based on linux-congatec"
DESCRIPTION = "Linux kernel that is based on Congatec's Linux, \
with added real-time capabilities."

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "cgt_imx_3.10.17_1.0.2"

SRCREV = "c5c5cfafde65a58d8af3785a16d2173eb53f7b1f"
SRC_URI = "git://git.congatec.com/arm/qmx6_kernel.git;protocol=http;branch=${SRCBRANCH} \
           file://defconfig \
           https://www.kernel.org/pub/linux/kernel/projects/rt/3.10/older/patch-3.10.17-rt12.patch.bz2;name=rt-patch1 \
           file://0001-fix-build.patch \
           file://0002-fix-build-with-rt-enabled.patch \
           file://0003-no-split-ptlocks.patch \
"

SRC_URI[rt-patch1.md5sum] = "77a28c8b20b01f280dcd860e606a6edd"
SRC_URI[rt-patch1.sha256sum] = "ce219268f08eecccb39ff2b5be83657d53ca67cb1c6b81021494075197190351"

LOCALVERSION = "-1.0.2"

COMPATIBLE_MACHINE = "(cgtqmx6)"
