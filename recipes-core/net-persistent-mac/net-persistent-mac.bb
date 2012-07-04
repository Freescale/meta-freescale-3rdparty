SUMMARY = "Network device MAC persistency"
DESCRIPTION = "Provides support to store/restore the MAC of a specific network device"
SECTION = "base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

inherit update-rc.d

INITSCRIPT_NAME = "net-persistent-mac"
INITSCRIPT_PARAMS = "start 39 S ."

SRC_URI = "file://init \
           file://default"

do_install () {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/${PN}

	install -d ${D}${sysconfdir}/default
	install -m 0644 ${WORKDIR}/default ${D}${sysconfdir}/default/${PN}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
