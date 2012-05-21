FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PRINC := "${@int(PRINC) + 1}"

# Board specific patches
SRC_URI_append_imx233-olinuxino-maxi = " file://imx233-olinuxino-maxi.patch"
