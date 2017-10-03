# adapted from linux-imx.inc, copyright (C) 2012-2014, 2017 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

include linux-wandboard.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "4.1-2.0.x-imx"
SRCREV = "18945fa6f63c4c5d2df14998c5e74bf799e6f65e"

COMPATIBLE_MACHINE = "(wandboard)"
