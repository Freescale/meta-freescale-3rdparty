# Copyright (C) 2019 Digi International Inc.

SUMMARY = "Firmware files for Qualcomm's QCA6564 wireless chip"
SECTION = "base"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENCE.atheros_firmware;md5=30a14c7823beedac9fa39c64fdd01a13"

SRC_URI = "ftp://ftp1.digi.com/support/digiembeddedyocto/source/${BPN}-${PV}.tar.gz"
SRC_URI[md5sum] = "7400b74881ac499517b6ad761a54f8fc"
SRC_URI[sha256sum] = "be3a56334764e21ee297260b6648075b7fada6f55e24a287a24e7c7d128e27ef"

S = "${WORKDIR}/linux-firmware-qca6564/"

do_install() {
    install -d ${D}${base_libdir}/firmware/qca
    install -m 0644 nvm_tlv_3.2.bin ${D}${base_libdir}/firmware/qca
    install -m 0644 rampatch_tlv_3.2.tlv ${D}${base_libdir}/firmware/qca
    install -m 0644 bdwlan30_US.bin ${D}${base_libdir}/firmware
    install -m 0644 LICENCE.atheros_firmware ${D}${base_libdir}/firmware
    install -m 0644 otp30.bin ${D}${base_libdir}/firmware
    install -m 0644 qwlan30.bin ${D}${base_libdir}/firmware
    install -m 0644 utf30.bin ${D}${base_libdir}/firmware
}

PACKAGES = "${PN}-bt ${PN}-wifi"

FILES_${PN}-bt = "/lib/firmware/qca"
FILES_${PN}-wifi = "/lib/firmware"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(ccimx6ul)"
