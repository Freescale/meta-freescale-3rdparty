SUMMARY = "TI WiLink8 Bluetooth init script TIInit_11.8.32.bts"
DESCRIPTION = "Bluetooth init script (BTS) loaded by the kernel's TI WiLink8 \
               Bluetooth driver. linux-firmware ships only older TIInit versions, \
               so this one comes from TI's service-packs repository."
HOMEPAGE = "https://git.ti.com/cgit/ti-bt/service-packs/"
SECTION = "kernel"
LICENSE = "LicenseRef-TI-Text-File"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f39eac9f4573be5b012e8313831e72a9"
NO_GENERIC_LICENSE[TI-Text-File] = "LICENSE"

SRC_URI = "git://git.ti.com/git/ti-bt/service-packs.git;protocol=https;branch=master"
SRCREV = "5f73abe7c03631bb2596af27e41a94abcc70b009"

inherit allarch

# The Makefile has only an install target, which copies every init script
do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -Dm 0644 ${S}/initscripts/TIInit_11.8.32.bts \
        ${D}${nonarch_base_libdir}/firmware/ti-connectivity/TIInit_11.8.32.bts
}

FILES:${PN} += "${nonarch_base_libdir}/firmware/ti-connectivity/TIInit_11.8.32.bts"
