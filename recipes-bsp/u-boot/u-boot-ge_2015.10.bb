require recipes-bsp/u-boot/u-boot.inc

DESCRIPTION = "U-Boot for GE i.MX6 BA16 based platforms"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=0507cd7da8e7ad6d6701926ec9b84c95"
DEPENDS = "u-boot-mkimage-native"

PROVIDES = "u-boot"

SRCREV = "1b6aee73e60023ae4ba16b11ce7bc23e0e8552f7"
SRC_URI = "git://github.com/Freescale/u-boot-fslc.git;branch=2015.10+fslc \
           file://0001-arm-imx-Add-support-for-GE-Bx50v3-boards.patch \
           file://0002-board-ge-bx50v3-Update-display-setup.patch \
           file://0003-ge_bx50v3-Add-support-for-FSL-Community-Yocto-images.patch \
           file://0004-board-ge-bx50v3-Add-support-for-ELO-board.patch \
           file://0005-board-ge-bx50v3-Fix-bootargs-for-ELO-board.patch \
           file://0006-mx6q_ba16-Add-1G-DDR-support.patch \
           file://0007-board-ge-bx50v3-Add-correct-SATA-settings.patch \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(imx6q-elo)"
