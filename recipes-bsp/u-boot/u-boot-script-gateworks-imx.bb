LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"
DEPENDS = "u-boot-mkimage-native"

SRC_URI = "file://6x_bootscript-yocto.txt"

DESTDIR = "/boot"
S = "${WORKDIR}"

do_compile() {
    bootscript="${THISDIR}/u-boot-script-gateworks-imx/6x_bootscript-yocto.txt"
    echo "bootscript == $bootscript"

    uboot-mkimage  -A arm -O linux -T script -C none -a 0 -e 0 \
        -n "boot script" -d $bootscript \
        6x_bootscript
}

do_install() {
    install -d ${D}/${DESTDIR}
    install ${S}/6x_bootscript ${D}${DESTDIR}/6x_bootscript-${MACHINE}-${PV}-${PR}

    cd ${D}${DESTDIR}
    ln -sf 6x_bootscript-${MACHINE}-${PV}-${PR} 6x_bootscript-${MACHINE}
}

FILES_${PN} = "${DESTDIR}/*"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(ventana)"
