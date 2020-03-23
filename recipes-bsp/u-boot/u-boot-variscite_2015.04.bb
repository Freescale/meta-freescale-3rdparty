require recipes-bsp/u-boot/u-boot.inc

SUMMARY = "U-Boot for Variscite i.MX6Q/DL VAR-SOM-MX6"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=c7383a594871c03da76b3707929d2919"
COMPATIBLE_MACHINE = "(mxs|mx6)"

PROVIDES += "u-boot"

SPL_BINARY = "SPL"

SRCREV = "2d1855ccbf780293405ade91894011708531f443"
SRCBRANCH = "imx_v2015.04_4.1.15_1.1.0_ga_var01"

SRC_URI = "\
    git://github.com/varigit/uboot-imx.git;protocol=git;branch=${SRCBRANCH} \
    file://kernel-gcc7.patch \
"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
