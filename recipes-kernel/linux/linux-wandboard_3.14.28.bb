# adapted from linux-imx.inc, copyright (C) 2012-2014 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

include linux-wandboard.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

# Wandboard branch - based on 3.14.28_1.0.0_ga from Freescale git

SRCBRANCH = "wandboard_imx_3.14.28_1.0.0_ga"
SRCREV = "99d36d8335ec27b8d8ed518ca0d3f840b59fea0e"
LOCALVERSION = "_1.0.0_ga-wandboard"

COMPATIBLE_MACHINE = "(wandboard)"
