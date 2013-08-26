FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PRINC := "${@int(PRINC) + 2}"

# Board specific patches
SRC_URI_append_imx233-olinuxino = " file://imx233-olinuxino.patch"

SRC_URI_append_cfa10036 = " file://cfa10036-support.patch"

