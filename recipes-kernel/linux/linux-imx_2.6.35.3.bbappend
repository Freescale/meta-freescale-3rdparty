FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

PRINC := "${@int(PRINC) + 2}"

# Generic patches
SRC_URI_append = " file://smsc95xx-randomize-mac-once.patch"

# Board specific patches
SRC_URI_append_imx233-olinuxino-maxi = " file://imx233-olinuxino.patch"

