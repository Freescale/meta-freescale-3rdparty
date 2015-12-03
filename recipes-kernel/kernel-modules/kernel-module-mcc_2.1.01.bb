# Copyright (C) 2013 Timesys Corporation
SUMMARY = "Multicore communication kernel module"
LICENSE = "GPL-2.0 | BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c8959abcbbe4d6676c58eab9354019e6 \
                    file://BSD_LICENSE;md5=10695b8f86532e5e44640acf4d92a2ef"

PROVIDES = "virtual/kernel-module-mcc"
RPROVIDES_${PN} = "virtual/kernel-module-mcc"
RPROVIDES_${PN}-dev = "virtual/kernel-module-mcc-dev"

inherit module

SRC_URI = "http://repository.timesys.com/buildsources/m/mcc-kmod/mcc-kmod-${PV}/mcc-kmod-${PV}.tar.bz2"

SRC_URI[md5sum] = "849dfdc34e08c7c82a5e8b452a95f1b3"
SRC_URI[sha256sum] = "ece0c9ccbfb5d2771b115f750361184bb80b2ae5fe82d97d38be2bfee3eeb87e"

S = "${WORKDIR}/mcc-kmod-${PV}"

COMPATIBLE_MACHINE = "(vf60)"
