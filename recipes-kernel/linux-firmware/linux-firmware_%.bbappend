# Support additional firmware for WiLink8 modules
# TIInit_11.8.32.bts is required for bluetooth support but this particular
# version is not available in the linux-firmware repository.
# TI has published several different files under this name, so the
# download name carries the service-packs revision.
#
SRC_URI:append:imx6qdl-variscite-som = " \
    https://git.ti.com/ti-bt/service-packs/blobs/raw/5f73abe7c03631bb2596af27e41a94abcc70b009/initscripts/TIInit_11.8.32.bts;name=TIInit_11.8.32;downloadfilename=TIInit_11.8.32-5f73abe7-${PV}.bts \
"
SRC_URI[TIInit_11.8.32.sha256sum] = "26ab0608e39fab95a6a55070c2f8364c92aad34442e8349abda71cee4da3277a"

do_install:append:imx6qdl-variscite-som() {
    install -m 0644 ${UNPACKDIR}/TIInit_11.8.32-5f73abe7-${PV}.bts \
        ${D}${nonarch_base_libdir}/firmware/ti-connectivity/TIInit_11.8.32.bts
}

PACKAGE_ARCH:imx6qdl-variscite-som = "${MACHINE_ARCH}"
