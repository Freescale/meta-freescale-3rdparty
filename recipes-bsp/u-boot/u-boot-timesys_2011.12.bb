# Copyright (C) 2013-2014 Timesys Corporation
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "bootloader for Vybrid platforms"
require recipes-bsp/u-boot/u-boot.inc

PROVIDES += "u-boot"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

SRCBRANCH = "2011.12-pcl052"
SRC_URI = "git://github.com/Timesys/u-boot-timesys.git;protocol=git;branch=${SRCBRANCH}"
SRCREV = "dca5026484c69628be9b9618e5795c635cefe110"

SRCBRANCH_quartz = "2011.12-quartz"
SRCREV_quartz = "2dc3859b8274b45fb6336d9713b4b07e42dfb4cb"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(vf60)"

PV = "v2011.12"
