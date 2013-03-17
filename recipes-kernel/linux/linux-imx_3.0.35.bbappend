FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

PRINC := "${@int(PRINC) + 3}"

# Wandboard-specific patches
SRC_URI_append_wandboard-dual = " \
   file://wandboard-dual/0001-Linux-3.0.35-Add-wandboard-dual-support.patch \
   file://wandboard-dual/0002-wandboard-dual-fix-sdhc-platform-data.patch \
   file://wandboard-dual/0003-linux-imx-3.0.35-Add-brcm80211-driver-backported-fro.patch \
   file://wandboard-dual/0003-linux-imx-3.0.35-remove-brcm80211-staging-driver.patch \
"
# Add support for the Congatec qmx6 board
SRC_URI_append_cgtqmx6 = " file://cgtqmx6/cgtqmx6.patch"
