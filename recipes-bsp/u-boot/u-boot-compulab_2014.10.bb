require recipes-bsp/u-boot/u-boot.inc

DESCRIPTION = "u-boot which includes support for CompuLab boards."
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://configs/cm_fx6_defconfig;md5=549452418e9e099e5fe19ef1ac65e892"

PROVIDES += "u-boot"

SRCBRANCH = "utilite/master"
SRCREV = "6803a75f3d40bee3b53f56e7b49c70465819b7ca"
SRC_URI = "git://github.com/utilite-computer/u-boot.git;branch=${SRCBRANCH}"
SRC_URI[md5sum] = "fd8234c5b3a460430689848c1f16acef"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "cm-fx6"
