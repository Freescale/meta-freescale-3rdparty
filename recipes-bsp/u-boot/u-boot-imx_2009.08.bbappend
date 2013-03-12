FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}"

PRINC := "${@int(PRINC) + 1}"

# Wandboard-specific patches
SRC_URI_append_wandboard-dual = " \
   file://wandboard-dual/0001-u-boot-2009.08-Add-Wandboard-Dual-support.patch \
"

# Revision of imx_3.0.35_1.1.0 branch
SRCREV_cgtqmx6 = "98a5299c945cb7e440e3c3d9c572f017e5a02ede"
SRC_URI_append_cgtqmx6 = " \
   file://cgtqmx6/uboot-support-for-cgtqmx6.patch \
"

UBOOT_MACHINE_cgtqmx6 = "cgt_qmx6_config"
