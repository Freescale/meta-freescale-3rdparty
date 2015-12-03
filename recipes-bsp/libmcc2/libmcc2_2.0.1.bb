# Copyright (C) 2013 Timesys Corporation
SUMMARY = "Multicore communication Library"
LICENSE = "GPL-2.0 | BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c49712341497d0b5f2e40c30dff2af9d \
                    file://BSD_LICENSE;md5=10695b8f86532e5e44640acf4d92a2ef"

DEPENDS = "virtual/kernel-module-mcc"

SRC_URI = "http://repository.timesys.com/buildsources/l/libmcc2/libmcc2-${PV}/libmcc2-${PV}.tar.bz2"

SRC_URI[md5sum] = "bd47714eb44ad67915ed51994e3af096"
SRC_URI[sha256sum] = "3bcbd9f3092c3be6edc6ab725346e822f05f303ce1dc5482fb320f4a1754f52d"

S = "${WORKDIR}/libmcc2-${PV}"

CFLAGS += "-I${STAGING_KERNEL_DIR}/include/uapi"

RDEPENDS_${PN} = "virtual/kernel-module-mcc"

COMPATIBLE_MACHINE = "(vf60)"

do_install() {
    oe_runmake 'DESTDIR=${D}' install
}

RDEPENDS_${PN}-dev += "virtual/kernel-module-mcc-dev"
