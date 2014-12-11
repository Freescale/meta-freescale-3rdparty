# adapted from linux-imx.inc, copyright (C) 2012-2014 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

include linux-wandboard.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

# Wandboard branch - based on 3.10.31_1.1.0_beta2 from Freescale git

SRCBRANCH = "wandboard_imx_3.10.31_1.1.0_beta2"
SRCREV = "a63c7c073c385bdc9d041c9795a18754f4544dba"
LOCALVERSION = "_1.1.0_beta2-wandboard"

COMPATIBLE_MACHINE = "(wandboard)"
