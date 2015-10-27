# Copyright (C) 2013 Timesys Corporation
SUMMARY = "Multicore communication Library"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c49712341497d0b5f2e40c30dff2af9d"

DEPENDS = "virtual/kernel-module-mcc"

SRC_URI = "http://repository.timesys.com/buildsources/l/libmcc2/libmcc2-${PV}/libmcc2-${PV}.tar.bz2"

SRC_URI[md5sum] = "ad6048217445bfa3b66ba0e3903a0bb0"
SRC_URI[sha256sum] = "16b504e9d1dd6bdc7297a0e5c8cb911c0986584c42c6017eff8c9b353e937a29"

S = "${WORKDIR}/libmcc2-${PV}"

CFLAGS += "-I${STAGING_KERNEL_DIR}/include/uapi"

RDEPENDS_${PN} = "virtual/kernel-module-mcc"

COMPATIBLE_MACHINE = "(vf60)"

do_install() {
    oe_runmake 'DESTDIR=${D}' install
}

RDEPENDS_${PN}-dev += "virtual/kernel-module-mcc-dev"
