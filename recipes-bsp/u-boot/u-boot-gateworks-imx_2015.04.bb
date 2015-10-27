require recipes-bsp/u-boot/u-boot.inc

DESCRIPTION = "U-Boot for Gateworks Ventana Family SBC's"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=c7383a594871c03da76b3707929d2919"
DEPENDS = "u-boot-mkimage-native"

PV = "v2015.04+git${SRCPV}"

SRCREV = "1399f2225965bfc8f1d288cd57e677ca21a7a591"
SRC_URI = "git://github.com/Gateworks/u-boot-imx6.git;branch=gateworks_v2015.04"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(ventana)"
