DESCRIPTION = "U-Boot for Boundary Devices boards"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=5a7450c57ffe5ae63fd732446b988025"

PV = "v2022.04+git${SRCPV}"

SRCREV = "1c69998957efb2a9dcde024f33e9b73b84226560"
SRCBRANCH = "boundary-v2022.04"
SRC_URI = "git://github.com/boundarydevices/u-boot.git;branch=${SRCBRANCH};protocol=https"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"
PACKAGE_ARCH = "${MACHINE_ARCH}"
