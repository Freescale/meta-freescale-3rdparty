DESCRIPTION = "U-Boot for Boundary Devices boards"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=5a7450c57ffe5ae63fd732446b988025"

PV = "v2022.04+git${SRCPV}"

SRCREV = "3693c9d6e557cce02b5570a5f72afbc1641ad3c4"
SRCBRANCH = "boundary-v2022.04"
SRC_URI = "git://github.com/boundarydevices/u-boot.git;branch=${SRCBRANCH};protocol=https"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"
PACKAGE_ARCH = "${MACHINE_ARCH}"
