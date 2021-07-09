# Copyright (C) 2015 Toradex AG
# Based on u-boot-fslc.inc Copyright (C) 2012-2020 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "U-Boot bootloader with support for Toradex Computer on Modules"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"

DEPENDS += "flex-native bison-native"

SRC_URI = "git://git.toradex.com/u-boot-toradex.git;branch=${SRCBRANCH}"

SRCREV = "7c9c42e93b9fda8c0bc27d5b8c81c4c289921c4b"
SRCBRANCH = "toradex_2020.07"

S = "${WORKDIR}/git"

PV = "2020.07+git${SRCPV}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "(mx6|mx7|vf|use-mainline-bsp)"
