# Copyright (C) 2018 Digi International
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Bootloader for Digi platforms"
SECTION = "bootloaders"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"

require recipes-bsp/u-boot/u-boot.inc

DEPENDS = "u-boot-mkimage-native"

PROVIDES += "u-boot"

SRCBRANCH = "v2017.03/maint"
SRCREV = "8d60f536d2063ac6a0676bdf34c4c8c8807371c5"

SRC_URI = "\
    git://github.com/digi-embedded/u-boot.git;protocol=git;nobranch=1 \
    file://bootscript.txt \
"

LOCALVERSION ?= "-${SRCBRANCH}"

S = "${WORKDIR}/git"

inherit dtc-145 fsl-u-boot-localversion

UBOOT_ENV = "boot"
UBOOT_ENV_SUFFIX = "scr"

do_compile_append () {
    sed -i -e 's/\${platform}/${MACHINE}/g' ${WORKDIR}/bootscript.txt
    uboot-mkimage -A arm -O linux -T script -C none -a 0 -e 0 \
        -n "boot script" -d ${WORKDIR}/bootscript.txt \
        ${WORKDIR}/${UBOOT_ENV_BINARY}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "(ccimx6ul)"
