BRCM_FWDIR = "/lib/firmware/brcm"

do_install_append () {
	# rename downloaded files so that we can create alternative
	# links

	cd ${D}${BRCM_FWDIR}

	mv brcmfmac4329-sdio.bin brcmfmac4329-sta-sdio.bin
	mv brcmfmac4330-sdio.bin brcmfmac4330-sta-sdio.bin

	# Create original file links, so that the base recipe sees the installed files
	ln -sf brcmfmac4329-sta-sdio.bin brcmfmac4329-sdio.bin
	ln -sf brcmfmac4330-sta-sdio.bin brcmfmac4330-sdio.bin
}

FILES_${PN}-bcm4329 += " \
  ${BRCM_FWDIR}/brcmfmac4329-sta-sdio.bin \
"

FILES_${PN}-bcm4330 += " \
  ${BRCM_FWDIR}/brcmfmac4330-sta-sdio.bin \
"

ALTERNATIVE_linux-firmware-bcm4329 += " brcmfmac4329-sdio.bin"
ALTERNATIVE_LINK_NAME[brcmfmac4329-sdio.bin] = "${BRCM_FWDIR}/brcmfmac4329-sdio.bin"
ALTERNATIVE_TARGET_linux-firmware-bcm4329[brcmfmac4329-sdio.bin] = "${BRCM_FWDIR}/brcmfmac4329-sta-sdio.bin"

ALTERNATIVE_linux-firmware-bcm4330 += " brcmfmac4330-sdio.bin"
ALTERNATIVE_LINK_NAME[brcmfmac4330-sdio.bin] = "${BRCM_FWDIR}/brcmfmac4330-sdio.bin"
ALTERNATIVE_TARGET_linux-firmware-bcm4330[brcmfmac4330-sdio.bin] = "${BRCM_FWDIR}/brcmfmac4330-sta-sdio.bin"

