require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"
COMPATIBLE_MACHINE = "(gk802)"

PROVIDES = "u-boot"

SRCREV = "7a2d0586f5c3bc07dae8cc87f12c95118a02a7a5"
SRC_URI = "git://github.com/imx6-dongle/uboot-imx6dongle.git \
           file://0001-gk802-Change-default-environment-to-work-with-OE.patch \
"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
