# adapted from linux-wandboard_3.14.28.bb

include linux-wandboard.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux kernel for Wandboard, with added real-time capabilities."

DEPENDS += "lzop-native bc-native"

# Wandboard branch - based on 3.14.28_1.0.0_ga from Freescale git

SRCBRANCH = "wandboard_imx_4.1.15_1.1.0_ga"
SRCREV = "8b015473d34019c3e093c257861e9c6f4930400b"
LOCALVERSION = "_1.1.0_ga-wandboard"

SRC_URI += "\
    file://Fix-the-compile-issue-under-gcc6.patch \
    file://Fix-gcc6-build-error-in-Vivante-driver.patch \
"
SRC_URI += "\
    https://www.kernel.org/pub/linux/kernel/projects/rt/4.1/older/patch-4.1.15-rt18.patch.gz;name=rt-patch \
    file://0001-fix-build.patch \
    file://0002-no-split-ptlocks.patch \
    file://0003-Work-around-CPU-stalls-in-the-imx-sdma-driver.patch \
"

SRC_URI[rt-patch.md5sum] = "4763c22c4dcf49ba07cdf60984732fe4"
SRC_URI[rt-patch.sha256sum] = "a317242e5e79fccc204f170328469e79d1aa663501dc4ec5e425199fb0ac9605"

COMPATIBLE_MACHINE = "(wandboard)"
