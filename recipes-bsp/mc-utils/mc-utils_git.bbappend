FILESEXTRAPATHS_append_lx2160acex7 := "${THISDIR}/${PN}-lx2160acex7:"

SRC_URI_append_lx2160acex7 = "\
	file://0001-lx2160acex7-add-8x10G-dual-40G-and-dual-100G-DPL-DPC.patch \
"

MC_FLAVOUR_lx2160acex7 = "CEX7"
