SUMMARY = "Broadcom BCM${CHIP_MODEL} NVRAM configuration"
HOMEPAGE = "https://www.broadcom.com/products/wireless"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENCE.broadcom_bcm43xx;md5=3160c14df7228891b868060e1951dfbc"

SRC_URI = "\
    file://LICENCE.broadcom_bcm43xx \
    file://brcmfmac${CHIP_MODEL}-sdio.txt \
"

S = "${UNPACKDIR}"
BRCM_FWDIR = "${nonarch_base_libdir}/firmware/brcm"
CHIP_MODEL ?= "Invalid"

do_install() {
    install -d  ${D}${BRCM_FWDIR}

    cp -r ${UNPACKDIR}/brcmfmac${CHIP_MODEL}-sdio.txt \
        ${D}${BRCM_FWDIR}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES:${PN} = "\
    ${BRCM_FWDIR}/brcmfmac${CHIP_MODEL}-sdio.txt \
"

RDEPENDS:${PN} = "\
    linux-firmware-bcm${CHIP_MODEL} \
"
