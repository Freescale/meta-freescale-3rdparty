require recipes-bsp/u-boot/u-boot.inc

DESCRIPTION = "u-boot for Boundary Devices boards."
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=025bf9f768cbcb1a165dbe1a110babfb"
COMPATIBLE_MACHINE = "(imx6qsabrelite|nitrogen6x)"

PROVIDES = "u-boot"

PV = "v2014.07+git${SRCPV}"

SRCREV = "fcb04d6103e2a1f62d3ae197432559aee5621765"
SRCBRANCH = "v2014.07-20140914"
SRC_URI = "git://github.com/boundarydevices/u-boot-imx6.git;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
