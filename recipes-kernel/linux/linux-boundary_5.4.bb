# Adapted from linux-imx.inc, copyright (C) 2013, 2014 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc

SUMMARY = "Linux kernel for Boundary Devices boards"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

LINUX_VERSION = "5.4.100"

SRC_URI = "git://github.com/boundarydevices/linux-imx6.git;branch=${SRCBRANCH} \
"

LOCALVERSION = "-2.2.0+yocto"
SRCBRANCH = "boundary-imx_5.4.x_2.2.0"
SRCREV = "308e5c5d64bae27028be98036a7b21ce1b89c6e8"
DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(nitrogen6x|nitrogen6x-lite|nitrogen6sx|nitrogen7|nitrogen8m|nitrogen8mm|nitrogen8mn)"

KBUILD_DEFCONFIG ?= "boundary_defconfig"

S = "${WORKDIR}/git"
