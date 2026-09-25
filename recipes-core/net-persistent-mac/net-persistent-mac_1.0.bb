# nooelint: oelint.var.mandatoryvar.HOMEPAGE
# The init script and its config live only in this layer and serve no
# particular board, so there is no upstream project or vendor page to name.
SUMMARY = "Network device MAC persistency"
DESCRIPTION = "Provides support to store/restore the MAC of a specific network device"
SECTION = "base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://init;beginline=2;endline=2;md5=b2dccaa94b3629a08bfb4f983cad6f89"

inherit update-rc.d

INITSCRIPT_NAME = "net-persistent-mac"
INITSCRIPT_PARAMS = "start 39 S ."

SRC_URI = "file://init \
           file://default"

S = "${UNPACKDIR}"

do_install () {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${UNPACKDIR}/init ${D}${sysconfdir}/init.d/${PN}

    install -d ${D}${sysconfdir}/default
    install -m 0644 ${UNPACKDIR}/default ${D}${sysconfdir}/default/${PN}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
