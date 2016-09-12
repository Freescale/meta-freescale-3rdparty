require recipes-bsp/u-boot/u-boot.inc

SUMMARY = "U-Boot for Variscite i.MX6Q/DL VAR-SOM-MX6"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=c7383a594871c03da76b3707929d2919"
COMPATIBLE_MACHINE = "(mxs|mx6)"

PROVIDES += "u-boot"

SPL_BINARY = "SPL"

SRCREV = "d4b69fe88b20223acf36e4c36ea464cd5a866ab2"
SRCBRANCH = "imx_v2015.04_4.1.15_1.1.0_ga_var01"

SRC_URI = "\
    git://github.com/varigit/uboot-imx.git;protocol=git;branch=${SRCBRANCH} \
    file://Fix-the-compile-issue-under-gcc6.patch \
"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
