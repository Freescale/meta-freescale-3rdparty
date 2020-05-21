# Copyright (C) 2012-2019 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

inherit fsl-u-boot-localversion

require recipes-bsp/u-boot/u-boot.inc

SUMMARY = "U-Boot for Kontron based boards"
DEPENDS += "bison-native bc-native dtc-native lzop-native"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"

SRC_URI = "git://git.kontron-electronics.de/linux/u-boot.git;protocol=https;branch=${SRCBRANCH} \
           file://fw_env.config \
           \
           file://0001-kontron_mx6ul-Sync-configuration-using-savedefconfig.patch \
           file://0002-kontron_mx6ul-Enable-boot-count-support.patch \
           file://0003-kontron_mx6ul-Enable-UUID-command-support.patch \
           \
           file://Remove-redundant-YYLOC-global-declaration.patch"
SRCREV = "438e0ad034813d38228ace8f1d311459933d1125"
SRCBRANCH = "v2020.01-ktn"
LOCALVERSION = "-ktn"

PROVIDES += "u-boot"

PV .= "+git${SRCPV}"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

# FIXME: Allow linking of 'tools' binaries with native libraries
#        used for generating the boot logo and other tools used
#        during the build process.
EXTRA_OEMAKE += 'HOSTCC="${BUILD_CC} ${BUILD_CPPFLAGS}" \
                 HOSTLDFLAGS="${BUILD_LDFLAGS}" \
                 HOSTSTRIP=true'

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(imx6ul-kontron)"

