DESCRIPTION = "U-Boot for Boundary Devices boards"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"

PV = "v2017.03.imx8m+git${SRCPV}"

SRCREV = "962210405277c99520aa4c5185c5aa2d589fbd1d"
SRCBRANCH = "boundary-imx_v2017.03_4.9.51_imx8m_ga"
SRC_URI = "git://github.com/boundarydevices/u-boot-imx6.git;branch=${SRCBRANCH}"

DEPENDS += "dtc-native"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
