# adapted from linux-imx.inc, copyright (C) 2012-2014, 2017 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

include linux-wandboard.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "4.1-2.0.x-imx"
SRCREV = "0d698de42426a92e3ba47071f11960aeb91eb349"

COMPATIBLE_MACHINE = "(wandboard)"
