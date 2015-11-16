# Adapted from linux-imx.inc, copyright (C) 2013, 2014 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux kernel for Boundary Devices boards"

SRC_URI = "git://github.com/boundarydevices/linux-imx6.git;branch=${SRCBRANCH} \
           file://defconfig"

LOCALVERSION = "-6qp_ga+yocto"
SRCBRANCH = "boundary-imx_3.14.38_6qp_ga-pass1"
SRCREV = "68f21f260d2ebe65d1a749c050e8f6ac330abd6f"
DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(nitrogen6x)"

# should only be used for 6QP platforms
DEFAULT_PREFERENCE = "-1"
