# adapted from linux-imx.inc, copyright (C) 2012-2013 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

include linux-wandboard.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

# Wandboard branch - based on 3.10.17_1.0.0_beta from Freescale git
SRCBRANCH = "wandboard_imx_3.10.17_1.0.0_beta"
SRCREV = "4a8ad4e16bbc17be82e95ffcd4241e21d441efbd"
LOCALVERSION = "-1.0.0-wandboard"


COMPATIBLE_MACHINE = "(wandboard)"
