DESCRIPTION = "U-Boot for reMarkble2"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"

require recipes-bsp/u-boot/u-boot.inc

PV = "2018.03+git${SRCPV}"

SRCREV = "47c91918aa7724c16b6eaf87cf5dfbf4548eafc1"
SRCBRANCH = "zero-sugar"
SRC_URI = "git://github.com/reMarkable/uboot.git;branch=${SRCBRANCH} \
           file://0001-Remove-redundant-YYLOC-global-declaration.patch \
           file://0002-dtc-lexer.lex.c_shipped-Remove-redundant-YYLOC-globa.patch \
           file://0003-reMarkable-Print-output-to-pogo-pins.patch \
           file://0004-reMarkable-Change-kernel-arg-to-use-UART6.patch \
           file://0005-reMarkable-Hard-code-boot-addresses.patch \
           file://0006-reMarkable-Don-t-load-data-from-uboot.env.patch \
           file://0007-HACK-Always-autoboot.patch \
           file://0008-HACK-autoboot-Don-t-boot-from-USB.patch \
           file://0009-HACK-reMarkable-Use-initramfs.patch \
          "

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"
PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS += "bison-native"

PROVIDES += "u-boot"

BOOT_TOOLS = "imx-boot-tools"

COMPATIBLE_MACHINE = "(imx7d-remarkable2)"
