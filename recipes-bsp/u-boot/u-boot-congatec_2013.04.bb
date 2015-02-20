# Congatec QMX6 u-boot

require recipes-bsp/u-boot/u-boot.inc

DESCRIPTION = "u-boot which includes support for Congatec Boards."
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"


PROVIDES += "u-boot"

PV = "2013.04"

SRCREV = "da45c17308845960330a5f24c77cbe86e1bb3177"
SRCBRANCH = "cgt_imx_v2013.04_3.10.17_1.0.2"

SRC_URI = "git://git.congatec.com/arm/qmx6_uboot.git;protocol=http;branch=${SRCBRANCH} \
	   file://u-boot-congatec-Change_environment_variables.patch \
"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(cgtqmx6)"
