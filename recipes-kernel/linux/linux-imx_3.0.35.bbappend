FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

PRINC := "${@int(PRINC) + 4}"

# Wandboard-specific patches
SRC_URI_append_wandboard-dual = " \
   file://wandboard-dual/0001-Linux-3.0.35-Add-wandboard-dual-support.patch \
   file://wandboard-dual/0002-wandboard-dual-fix-sdhc-platform-data.patch \
   file://wandboard-dual/0003-linux-imx-3.0.35-Add-brcm80211-driver-backported-fro.patch \
   file://wandboard-dual/0003-linux-imx-3.0.35-remove-brcm80211-staging-driver.patch \
   file://wandboard-dual/0004-modifications-for-fsl-3.0.0-and-add-header.patch \
"
# Add support for the Congatec qmx6 board
SRC_URI_append_cgtqmx6 = " file://cgtqmx6/cgtqmx6.patch"
