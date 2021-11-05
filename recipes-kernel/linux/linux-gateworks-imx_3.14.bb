# Copyright (C) 2015 Gateworks Corporation
# Released under the MIT license (see COPYING.MIT for the terms)

include recipes-kernel/linux/linux-imx.inc

DEPENDS += "lzop-native bc-native"

SRCREV = "d9991ca465921e5ed120dd321e06a2d64eaa5099"
LOCALVERSION = "-1.0.x-ga+yocto"
SRC_URI = "git://github.com/Gateworks/linux-imx6.git;protocol=https;branch=gateworks_fslc_3.14_1.0.x_ga \
           file://defconfig"

LINUX_VERSION = "3.14"

COMPATIBLE_MACHINE = "(ventana)"
