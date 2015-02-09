# adapted from linux-imx.inc, copyright (C) 2012-2014 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

include linux-wandboard.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

# Wandboard branch - based on 3.10.53_1.1.0_ga from Freescale git

SRCBRANCH = "wandboard_imx_3.10.53_1.1.0_ga"
SRCREV = "13bb18444208d5065f0e6345c7743e9662bc97d2"
LOCALVERSION = "_1.1.0_ga-wandboard"

COMPATIBLE_MACHINE = "(wandboard)"
