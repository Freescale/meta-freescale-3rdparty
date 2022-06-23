# Copyright (C) 2015 Toradex AG
# Copyright (C) 2013 Timesys Corporation
SUMMARY = "Multicore communication kernel module for linux-toradex kernel"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c8959abcbbe4d6676c58eab9354019e6"

PROVIDES = "virtual/kernel-module-mcc"
RPROVIDES:${PN} = "virtual/kernel-module-mcc"
RPROVIDES:${PN}-dev = "virtual/kernel-module-mcc-dev"

inherit module

export DESTDIR = "${D}"

SRC_URI = "git://github.com/toradex/mcc-kmod.git;protocol=https;branch=${SRCBRANCH}"

SRCBRANCH = "master"
SRCREV = "083388fa5cce79c239988d61543322d91996aa8d"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "(vf-generic-bsp)"
