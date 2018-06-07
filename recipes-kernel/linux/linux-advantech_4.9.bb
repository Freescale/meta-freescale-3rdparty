# Copyright (C) 2018 Advantech Corporation
# Released under the MIT license (see COPYING.MIT for the terms)

include recipes-kernel/linux/linux-imx.inc
DEPENDS += "lzop-native bc-native"

SRCBRANCH = "4.9-1.0.x-imx"
SRCREV = "0e674a64b86e2bb00ab43f56104d3ea85dda0066"
LOCALVERSION = "-${SRCBRANCH}-dms-ba16"

SRC_URI = "git://github.com/Freescale/linux-fslc.git;branch=${SRCBRANCH} \
           file://0001-Add-support-for-the-Advantech-DMS-BA16-Board.patch \
           file://0002-mfd-da9063-Add-wakeup-source-support.patch \
           file://0003-da9063-Add-a-PMIC-qurk-to-support-system-suspend-res.patch \
           file://defconfig \
	  "

COMPATIBLE_MACHINE = "(imx6q-dms-ba16)"
