require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=025bf9f768cbcb1a165dbe1a110babfb"
COMPATIBLE_MACHINE = "(imx6qsabrelite|nitrogen6x)"

PROVIDES = "u-boot"

PV = "v2014.07+git${SRCPV}"

SRCREV = "f870252376c47011a78cd8c35fdf904001d6c41e"
SRCBRANCH = "v2014.07-20140914"
SRC_URI = "git://github.com/boundarydevices/u-boot-imx6.git;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
