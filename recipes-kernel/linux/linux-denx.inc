# Copyright (C) 2013 Marek Vasut <marex@denx.de>
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "DENX mainline based Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
DEPENDS += "lzop-native"
PROVIDES = "virtual/kernel linux-mainline"

inherit kernel

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

# Avoid imx-test installation hacks
IMX_TEST_SUPPORT = "n"

SRCBRANCH ?= "master"
SRC_URI = "git://git.denx.de/linux-denx.git;branch=${SRCBRANCH} \
           file://defconfig"

LOCALVERSION = "-master"
