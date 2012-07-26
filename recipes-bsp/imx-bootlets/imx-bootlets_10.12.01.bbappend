FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PRINC := "${@int(PRINC) + 2}"

# Board specific patches
SRC_URI_append_imx233-olinuxino = " file://imx233-olinuxino.patch"
