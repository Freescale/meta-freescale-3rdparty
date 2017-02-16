# Congatec QMX6 u-boot

require recipes-bsp/u-boot/u-boot.inc

DESCRIPTION = "u-boot which includes support for Congatec Boards."
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://README;md5=587d8d939ae351bb11910921b1eafd42"

PROVIDES = "u-boot"

PV = "2016.01"

SRCREV = "cf874aa44c41f7e637bb606a8150343433bf4a19"
SRCBRANCH = "cgt_imx_v2016.01_1.0.0"

SRC_URI = "git://git.congatec.com/arm/qmx6_uboot.git;protocol=http;branch=${SRCBRANCH} \
	   file://Fix-the-compile-issue-under-gcc6.patch \
	   file://0001-uboot-congatec-Change-environment-variables.patch \
"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(cgtumx6|cgtqmx6|cgtimx6)"
