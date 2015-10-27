# Copyright (C) 2013 Timesys Corporation
SUMMARY = "MQX Image loader - starts an MQX image on the M4"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c49712341497d0b5f2e40c30dff2af9d"

DEPENDS = "virtual/kernel-module-mcc"

SRC_URI = "http://repository.timesys.com/buildsources/m/mqxboot/mqxboot-${PV}/mqxboot-${PV}.tar.bz2"

SRC_URI[md5sum] = "8f8e2f20485c41b4760b9685fe4abf1f"
SRC_URI[sha256sum] = "5a4013047ef099414fd40e45c9f4d8fd5a364816a526c304cc3e9759695d87ae"

S = "${WORKDIR}/mqxboot-${PV}"

CFLAGS += "-I${STAGING_KERNEL_DIR}/include/uapi"

RDEPENDS_${PN} = "virtual/kernel-module-mcc"

COMPATIBLE_MACHINE = "(vf60)"

do_install() {
    oe_runmake 'DESTDIR=${D}' install
}
