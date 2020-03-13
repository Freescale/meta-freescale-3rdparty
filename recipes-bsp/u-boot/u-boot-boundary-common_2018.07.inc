DESCRIPTION = "U-Boot for Boundary Devices boards"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"

PV = "v2018.07+git${SRCPV}"

SRCREV = "f45f2571cecb47799fd3a3d8b428f7e56a2fa824"
SRCBRANCH = "boundary-v2018.07"
SRC_URI = "git://github.com/boundarydevices/u-boot-imx6.git;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
