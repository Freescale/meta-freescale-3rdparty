# Copyright (C) 2019 Digi International.

DESCRIPTION = "udev rules for Digi International SOMs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI_ccimx6ul = " \
	file://81-qcom-wifi.rules \
	file://qca6564-init-wifi.sh \
	file://81-qcom-bt.rules \
	file://qca6564-attach.sh \
"

S = "${WORKDIR}"

do_install_ccimx6ul () {
	install -d ${D}${sysconfdir}/udev/rules.d
	install -m 0644 ${WORKDIR}/81-qcom-wifi.rules ${D}${sysconfdir}/udev/rules.d/
	install -m 0644 ${WORKDIR}/81-qcom-bt.rules ${D}${sysconfdir}/udev/rules.d/
	install -d ${D}${sysconfdir}/udev/scripts/
	install -m 0755 ${WORKDIR}/qca6564-init-wifi.sh ${D}${sysconfdir}/udev/scripts/
	install -m 0755 ${WORKDIR}/qca6564-attach.sh ${D}${sysconfdir}/udev/scripts/
}

COMPATIBLE_MACHINE = "(ccimx6ul)"
