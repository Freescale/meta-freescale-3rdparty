require recipes-bsp/u-boot/u-boot.inc

DESCRIPTION = "u-boot for Boundary Devices boards."
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=0507cd7da8e7ad6d6701926ec9b84c95"
COMPATIBLE_MACHINE = "(imx6qsabrelite|nitrogen6x|nitrogen6sx)"

PROVIDES = "u-boot"

PV = "v2015.07+git${SRCPV}"

SRCREV = "6f020cc6fb24f3c5c5287a7b630fc3bd6e09aa6e"
SRCBRANCH = "boundary-v2015.07"
SRC_URI = "git://github.com/boundarydevices/u-boot-imx6.git;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
