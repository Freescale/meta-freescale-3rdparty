# Copyright (C) 2015 Gateworks Corporation
# Released under the MIT license (see COPYING.MIT for the terms)

include recipes-kernel/linux/linux-imx.inc
include recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCREV = "daca48d0edd5e850a956e68facf190b567be9434"
LOCALVERSION = "-1.1.0_ga+yocto"
SRC_URI = "git://github.com/Gateworks/linux-imx6.git;protocol=git;branch=gateworks_3.10.53_1.1.0_ga \
           file://defconfig"

COMPATIBLE_MACHINE = "(ventana)"
