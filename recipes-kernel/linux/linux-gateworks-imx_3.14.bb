# Copyright (C) 2015 Gateworks Corporation
# Released under the MIT license (see COPYING.MIT for the terms)

include recipes-kernel/linux/linux-imx.inc
include recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCREV = "1032ddf66a1488b47f3ff72f944b4ceadcdd2e4e"
LOCALVERSION = "-1.0.x-ga+yocto"
SRC_URI = "git://github.com/Gateworks/linux-imx6.git;protocol=git;branch=gateworks_fslc_3.14_1.0.x_ga \
           file://defconfig"

COMPATIBLE_MACHINE = "(ventana)"
