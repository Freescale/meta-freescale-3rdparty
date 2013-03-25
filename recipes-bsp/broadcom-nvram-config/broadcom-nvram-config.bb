DESCRIPTION = "Nvram support for Broadcom wifi chips"
SECTION = "kernel"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENCE.broadcom_bcm43xx;md5=3160c14df7228891b868060e1951dfbc"

SRC_URI = " \
   file://nvram.txt \
   file://LICENCE.broadcom_bcm43xx \
"

S="${WORKDIR}"

do_install() {
    install -d  ${D}/lib/firmware/brcm

    cp -r ${WORKDIR}/nvram.txt \
        ${D}/lib/firmware/brcm/brcmfmac-sdio.txt
}

FILES_${PN} = " \
  /lib/firmware/brcm/brcmfmac-sdio.txt \
"
BROADCOM_FIRMWARE = "INVALID"
BROADCOM_FIRMWARE_wandboard-dual = "bcm4329"

RDEPENDS_${PN} = "linux-firmware-${BROADCOM_FIRMWARE}"

COMPATIBLE_MACHINE = "(wandboard-dual)"
