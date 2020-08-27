DESCRIPTION = "U-Boot for Boundary Devices boards"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"

PV = "v2018.07+git${SRCPV}"

SRCREV = "eae0188ff8e835fcb2351324af88998f0e4213db"
SRCBRANCH = "boundary-v2018.07"
SRC_URI = "git://github.com/boundarydevices/u-boot-imx6.git;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"
PACKAGE_ARCH = "${MACHINE_ARCH}"
