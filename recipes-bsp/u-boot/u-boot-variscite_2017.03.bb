require recipes-bsp/u-boot/u-boot.inc

SUMMARY = "U-Boot for Variscite i.MX6Q/DL VAR-SOM-MX6"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"
COMPATIBLE_MACHINE = "(imx6qdl-variscite-som)"

DEPENDS += "bc-native"
UBOOT_INITIAL_ENV = ""

PROVIDES += "u-boot"

SPL_BINARY = "SPL"

SRCREV = "a7869c2cde98e5f5b1886d8f54dff321a7aa0597"
SRCBRANCH = "imx_v2017.03_4.9.11_1.0.0_ga_var01"

SRC_URI = "\
    git://github.com/varigit/uboot-imx.git;protocol=git;branch=${SRCBRANCH} \
    file://0001-Fix-build-with-recent-layers.patch \
"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
