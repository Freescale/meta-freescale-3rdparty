# Copyright (C) 2015 Toradex AG
# Copyright (C) 2013 Timesys Corporation
SUMMARY = "Multicore communication kernel module for linux-toradex kernel"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c8959abcbbe4d6676c58eab9354019e6"

PROVIDES = "virtual/kernel-module-mcc"
RPROVIDES_${PN} = "virtual/kernel-module-mcc"
RPROVIDES_${PN}-dev = "virtual/kernel-module-mcc-dev"

inherit module

SRC_URI = "git://github.com/toradex/mcc-kmod.git;protocol=git;branch=${SRCBRANCH}"

SRCBRANCH = "master"
SRCREV = "6a089386787e0540c30cc12fe774f3481c82051c"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "(vf60)"
