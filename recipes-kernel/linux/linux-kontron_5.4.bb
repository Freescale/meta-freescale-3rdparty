# Copyright (C) 2012-2020 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)
#
# SPDX-License-Identifier: MIT
#

require recipes-kernel/linux/linux-imx.inc

SUMMARY = "Kontron Linux mainline based kernel with backported features and fixes"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

DEPENDS += "lzop-native bc-native"

SRC_URI = "git://git.kontron-electronics.de/linux/linux.git;protocol=https;branch=${SRCBRANCH} \
           file://defconfig"
LOCALVERSION = "-ktn"


# PV is defined in the base in linux-imx.inc file and uses the LINUX_VERSION definition
# required by kernel-yocto.bbclass.
#
# LINUX_VERSION define should match to the kernel version referenced by SRC_URI and
# should be updated once patchlevel is merged.
LINUX_VERSION = "5.4.36"

SRCBRANCH = "v5.4-ktn"
SRCREV = "fbb3adb523bebab289c7cb283ff8cbfebe477a23"

COMPATIBLE_MACHINE = "(imx6ul-kontron)"
