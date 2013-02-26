FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}"

PRINC := "${@int(PRINC) + 1}"

# Wandboard-specific patches
SRC_URI_append_wandboard-dual = " \
   file://wandboard-dual/0001-u-boot-2009.08-Add-Wandboard-Dual-support.patch \
"
