require recipes-bsp/u-boot/u-boot.inc

SUMMARY = "U-Boot for Variscite i.MX6Q/DL VAR-SOM-MX6"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"
COMPATIBLE_MACHINE = "(imx6qdl-variscite-som)"

PROVIDES += "u-boot"

SPL_BINARY = "SPL"

SRCREV = "3b5f889cb501c9fbe44c750c657dcd9ea4875176"
SRCBRANCH = "imx_v2017.03_4.9.11_1.0.0_ga_var01"

SRC_URI = "\
    git://github.com/varigit/uboot-imx.git;protocol=git;branch=${SRCBRANCH} \
"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
