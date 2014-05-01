require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=025bf9f768cbcb1a165dbe1a110babfb"
COMPATIBLE_MACHINE = "(imx6qsabrelite|nitrogen6x)"

PROVIDES = "u-boot"

PV = "v2014.04+git${SRCPV}"

SRCREV = "6d00ef4bba6fdfa7897cba631df6c0781992b847"
SRCBRANCH = "v2014.04-20140419"
SRC_URI = "git://github.com/boundarydevices/u-boot-imx6.git;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
