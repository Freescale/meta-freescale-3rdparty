# nooelint: oelint.var.mandatoryvar.LICENSE
# LICENSE is set by meta-freescale's linux-imx.inc, required below; oelint
# cannot follow a require into another layer.
# Copyright (C) 2012-2020 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)
#
# SPDX-License-Identifier: MIT
#

require recipes-kernel/linux/linux-imx.inc

SUMMARY = "Kontron Linux mainline based kernel with backported features and fixes"
DESCRIPTION = "Linux kernel for Kontron Electronics i.MX6UL/ULL boards, mainline based with vendor backports"
HOMEPAGE = "https://git.kontron-electronics.de/linux/linux"
SECTION = "kernel"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

DEPENDS += "bc-native lzop-native"

SRC_URI = "git://git.kontron-electronics.de/linux/linux.git;protocol=https;branch=${SRCBRANCH} \
           file://defconfig"
LOCALVERSION = "-ktn"


# PV is defined in the base in linux-imx.inc file and uses the LINUX_VERSION definition
# required by kernel-yocto.bbclass.
#
# LINUX_VERSION define should match to the kernel version referenced by SRC_URI and
# should be updated once patchlevel is merged.
LINUX_VERSION = "5.10.95"

SRCBRANCH = "v5.10-ktn"
SRCREV = "546dec2e2d46f9050f6b5484d909e9d7a1f14747"

COMPATIBLE_MACHINE = "(imx6ul-kontron)"
