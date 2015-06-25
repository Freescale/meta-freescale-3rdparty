# adapted from linux-imx.inc, copyright (C) 2012-2014 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

include linux-wandboard.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

# Wandboard branch - based on 3.14.28_1.0.0_ga from Freescale git

SRCBRANCH = "wandboard_imx_3.14.28_1.0.0_ga"
SRCREV = "08f5291c18379a90cd1706e89cdb16288a4cdfe2"
LOCALVERSION = "_1.0.0_ga-wandboard"

COMPATIBLE_MACHINE = "(wandboard)"
