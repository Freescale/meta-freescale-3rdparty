require recipes-bsp/u-boot/u-boot.inc

DESCRIPTION = "U-Boot for Gateworks Ventana Family SBC's"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=025bf9f768cbcb1a165dbe1a110babfb"
DEPENDS = "u-boot-mkimage-native"

PV = "v2014.04+git${SRCPV}"

SRCREV = "f2a73003969ef178e4734a3658d8295dde63901e"
SRC_URI = "git://github.com/Gateworks/u-boot-imx6.git;branch=gateworks_v2014.04"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(ventana)"
