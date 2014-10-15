# adapted from linux-imx.inc, copyright (C) 2012-2014 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

include linux-wandboard.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

# Wandboard branch - based on 3.10.17_1.0.1_ga from Freescale git
SRCBRANCH = "wandboard_imx_3.10.17_1.0.1_ga"
SRCREV = "a6e7fc58e6912986d003598ed79bb6a391a2113c"
LOCALVERSION = "-1.0.1-wandboard"

COMPATIBLE_MACHINE = "(wandboard)"
