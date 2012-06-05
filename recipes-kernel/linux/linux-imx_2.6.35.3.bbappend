FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

PRINC := "${@int(PRINC) + 4}"

# Board specific patches
SRC_URI_append_imx233-olinuxino-maxi = " file://imx233-olinuxino.patch"
SRC_URI_append_imx233-olinuxino-micro = " file://imx233-olinuxino.patch"

