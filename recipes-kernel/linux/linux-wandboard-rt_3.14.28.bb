# adapted from linux-wandboard_3.14.28.bb

include linux-wandboard.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux kernel for Wandboard, with added real-time capabilities."

DEPENDS += "lzop-native bc-native"

# Wandboard branch - based on 3.14.28_1.0.0_ga from Freescale git

SRCBRANCH = "wandboard_imx_3.14.28_1.0.0_ga"
SRCREV = "e2df0421a0a73fa2effb1e866bc3b2d8cb1b5acf"
LOCALVERSION = "_1.0.0_ga-wandboard"

SRC_URI += "\
    https://www.kernel.org/pub/linux/kernel/projects/rt/3.14/older/patch-3.14.28-rt25.patch.gz;name=rt-patch1 \
    file://0001-fix-build.patch \
    file://0002-fix-build-with-rt-enabled.patch \
    file://0003-no-split-ptlocks.patch \
    file://0004-imx-sdma-channel-use-raw-spinlock.patch \
"

SRC_URI[rt-patch1.md5sum] = "28bfd1e14ccab1ea1fb48f56f982d80c"
SRC_URI[rt-patch1.sha256sum] = "4c9bd426cf559a99e169208df5535fcb18ec98daec73f148c88859a7c3333e52"

COMPATIBLE_MACHINE = "(wandboard)"
