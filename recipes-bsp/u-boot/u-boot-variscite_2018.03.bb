require recipes-bsp/u-boot/u-boot.inc

SUMMARY = "U-Boot for Variscite i.MX6Q/DL VAR-SOM-MX6"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"
COMPATIBLE_MACHINE = "(imx6qdl-variscite-som)"

DEPENDS += "bc-native"
UBOOT_INITIAL_ENV = ""

PROVIDES += "u-boot"

SPL_BINARY = "SPL"

SRCREV = "717f29898abe82ffa2d74515806c46094075285a"
SRCBRANCH = "imx_v2018.03_4.14.78_1.0.0_ga_var02"

SRC_URI = "\
    git://github.com/varigit/uboot-imx.git;protocol=https;branch=${SRCBRANCH} \
"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"
