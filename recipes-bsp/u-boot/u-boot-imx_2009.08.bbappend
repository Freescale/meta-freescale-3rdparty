FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_cgtqmx6 = " \
   file://cgtqmx6/0001-Add-uboot-support-for-congatec-qmx6-board.patch \
"

UBOOT_MACHINE_cgtqmx6 = "cgt_qmx6_config"
