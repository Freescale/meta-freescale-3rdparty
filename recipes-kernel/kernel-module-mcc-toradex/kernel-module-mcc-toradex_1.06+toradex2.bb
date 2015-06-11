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
SRCREV = "d68c842ff871c7930c59366cf76b54c52a045a90"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "(vf60)"
