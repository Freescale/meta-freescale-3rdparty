# adapted from linux-imx.inc, copyright (C) 2012-2014 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

include linux-wandboard.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

# Wandboard branch - based on 3.14.28_1.0.0_ga from Freescale git

SRCBRANCH = "wandboard_imx_4.1.15_1.1.0_ga"
SRCREV = "8b015473d34019c3e093c257861e9c6f4930400b"
LOCALVERSION = "-1.1.0-ga-wandboard"

SRC_URI += "\
    file://Fix-the-compile-issue-under-gcc6.patch \
    file://Fix-gcc6-build-error-in-Vivante-driver.patch \
"

COMPATIBLE_MACHINE = "(wandboard)"
