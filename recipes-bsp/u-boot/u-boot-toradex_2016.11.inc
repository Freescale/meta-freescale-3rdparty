# Copyright (C) 2015 Toradex AG
# Based on u-boot-fslc.inc Copyright (C) 2012-2014 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "U-Boot bootloader with support for Toradex Computer on Modules"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"

SRC_URI = "git://git.toradex.com/u-boot-toradex.git;branch=${SRCBRANCH}"

SRCREV ?= "aca804c9ddadbf34a8ff82779e5598ec5e319f23"
SRCBRANCH ?= "2016.11-toradex"

S = "${WORKDIR}/git"

PV = "2016.11+git${SRCPV}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "(mx6|mx7|vf|use-mainline-bsp)"
