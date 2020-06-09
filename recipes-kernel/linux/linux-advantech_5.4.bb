# Copyright (C) 2018 Advantech Corporation
# Released under the MIT license (see COPYING.MIT for the terms)

include recipes-kernel/linux/linux-imx.inc
DEPENDS += "lzop-native bc-native"

SRCBRANCH = "imx_5.4.3_2.0.0"
SRCREV = "6ea635c2f9b08dc75ffef7d6262a2c6df7afa4e1"
LOCALVERSION = "-${SRCBRANCH}-dms-ba16"

SRC_URI = "git://github.com/Freescale/linux-fslc.git;branch=${SRCBRANCH} \
           file://0001-Add-support-for-the-Advantech-DMS-BA16-Board.patch \
           file://0002-mfd-da9063-Add-wakeup-source-support.patch \
           file://0003-da9063-Add-a-PMIC-qurk-to-support-system-suspend-res.patch \
           file://defconfig \
	  "

COMPATIBLE_MACHINE = "(imx6q-dms-ba16)"
