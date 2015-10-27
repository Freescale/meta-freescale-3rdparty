# Copyright (C) 2013 Timesys Corporation
SUMMARY = "Multicore communication kernel module"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c8959abcbbe4d6676c58eab9354019e6"

PROVIDES = "virtual/kernel-module-mcc"
RPROVIDES_${PN} = "virtual/kernel-module-mcc"
RPROVIDES_${PN}-dev = "virtual/kernel-module-mcc-dev"

inherit module

SRC_URI = "http://repository.timesys.com/buildsources/m/mcc-kmod/mcc-kmod-${PV}/mcc-kmod-${PV}.tar.bz2"

SRC_URI[md5sum] = "c53d18e7668dacc09dd675110ce33331"
SRC_URI[sha256sum] = "fc0abfc41724e6e73ffe8cdcf721035ff31b07816d41409ca37547596ecdb212"

S = "${WORKDIR}/mcc-kmod-${PV}"

COMPATIBLE_MACHINE = "(vf60)"
