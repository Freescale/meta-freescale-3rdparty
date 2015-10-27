# Copyright (C) 2013-2014 Timesys Corporation
# Released under the MIT license (see COPYING.MIT for the terms)
require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux Kernel with added drivers and board support for Vybrid-based platforms"

# Revision of 3.13_vybrid branch
SRC_URI = "git://github.com/Timesys/linux-timesys.git;protocol=git;branch=${SRCBRANCH} \
           file://defconfig \
           file://0001-arm-dts-vf610-phycore-rdk.dts-rename-to-vf610-pcm052.patch \
"

SRCBRANCH = "3.13_vybrid"
SRCREV = "a8caf227b68beff7b3e6a2b69a37272c6fc7d4ac"
LOCALVERSION ?= "-${SRCBRANCH}"

COMPATIBLE_MACHINE = "(vf60)"
