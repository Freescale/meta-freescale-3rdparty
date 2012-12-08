require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"
COMPATIBLE_MACHINE = "(imx6qsabrelite|nitrogen6x)"

PROVIDES = "u-boot"

PV = "v2013.01+git${SRCPV}"

SRCREV = "d6b05d35b8b29392e71fdd8fa43d5cb8bd4fe276"
SRC_URI = "git://github.com/boundarydevices/u-boot-imx6.git"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
