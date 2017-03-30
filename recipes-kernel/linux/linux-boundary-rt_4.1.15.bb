# Adapted from linux-imx.inc, copyright (C) 2013, 2014 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux kernel for Boundary Devices boards"

SRC_URI = "git://github.com/boundarydevices/linux-imx6.git;branch=${SRCBRANCH} \
           https://www.kernel.org/pub/linux/kernel/projects/rt/4.1/older/patch-4.1.15-rt18.patch.gz;name=rt-patch \
           file://0001-fix-build.patch \
           file://0002-no-split-ptlocks.patch \
           file://0003-Work-around-CPU-stalls-in-the-imx-sdma-driver.patch \
           file://0004-export-swait-locked-functions.patch \
           file://defconfig \
"

SRC_URI[rt-patch.md5sum] = "4763c22c4dcf49ba07cdf60984732fe4"
SRC_URI[rt-patch.sha256sum] = "a317242e5e79fccc204f170328469e79d1aa663501dc4ec5e425199fb0ac9605"

LOCALVERSION = "-2.0.0_ga+yocto"
SRCBRANCH = "boundary-imx_4.1.15_2.0.0_ga"
SRCREV = "ff4e28b95115d7021c3ea6209b7c2b0b849874e1"
DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(nitrogen6x|nitrogen6x-lite|nitrogen6sx|nitrogen7)"
