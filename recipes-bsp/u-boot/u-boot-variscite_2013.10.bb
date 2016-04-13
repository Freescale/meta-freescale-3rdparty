require recipes-bsp/u-boot/u-boot.inc

SUMMARY = "U-Boot for Variscite i.MX6Q/DL VAR-SOM-MX6"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=025bf9f768cbcb1a165dbe1a110babfb"
COMPATIBLE_MACHINE = "(mxs|mx6)"

PROVIDES += "u-boot"

SPL_BINARY = "SPL"

SRCREV = "a2bb081c08f8e18cee3ffbf577adb9bdb7d5a6f9"
SRCBRANCH = "imx_v2013.10_var4"

SRC_URI = "\
    git://github.com/varigit/uboot-imx.git;protocol=git;branch=${SRCBRANCH} \
    file://u-boot-002-gcc5-use_gcc_inline_version_instead_c99.patch \
    file://0001-Add-linux-compiler-gcc5.h-to-fix-builds-with-gcc5.patch \
    file://0002-ARM-asm-io.h-use-static-inline.patch \
    file://0003-gcc5-no-unalligned-access.patch \
"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
