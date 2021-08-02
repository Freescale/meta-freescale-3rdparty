FILESEXTRAPATHS:append:lx2160acex7 := "${THISDIR}/${PN}-lx2160acex7:"

SRC_URI:append:lx2160acex7 = "\
	file://0001-plat-nxp-Add-lx2160acex7-module-support.patch \
	file://0002-plat-nxp-lx2160a-auto-boot.patch \
"
