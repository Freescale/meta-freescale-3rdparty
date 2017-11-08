# Copyright (C) 2015 Toradex AG
# Based on u-boot-fslc.inc Copyright (C) 2012-2014 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-bsp/u-boot/u-boot.inc

inherit fsl-u-boot-localversion

SUMMARY = "U-Boot bootloader with support for Toradex Computer on Modules"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"

DEPENDS += "dtc-native"

PROVIDES += "u-boot"

SRC_URI = "git://git.toradex.com/u-boot-toradex.git;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
