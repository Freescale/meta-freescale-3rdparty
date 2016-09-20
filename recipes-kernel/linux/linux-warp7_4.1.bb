# Copyright (C) 2016 NXP Semiconductors
# Released under the MIT license (see COPYING.MIT for the terms)

include recipes-kernel/linux/linux-fslc.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "4.1-1.0.x-imx"
SRCREV = "511f37a20970db04ae3e1aff5e48ca4626e9197b"
LOCALVERSION = "-${SRCBRANCH}-warp7"

SRC_URI = "git://github.com/warp7/linux-fslc.git;branch=${SRCBRANCH} \
           file://defconfig"

COMPATIBLE_MACHINE = "(imx7s-warp)"
