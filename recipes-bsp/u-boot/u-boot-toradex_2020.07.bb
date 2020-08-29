SUMMARY = "U-Boot bootloader with support for Toradex Computer on Modules"
HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"

require recipes-bsp/u-boot/u-boot.inc

DEPENDS += "bc-native dtc-native flex-native bison-native"

PV = "2020.07+git${SRCPV}"
SRC_URI = " \
    git://git.toradex.com/u-boot-toradex.git;branch=${SRCBRANCH} \
    file://fw_env.config \
"
SRCBRANCH = "toradex_2020.07"
SRCREV = "7c9c42e93b9fda8c0bc27d5b8c81c4c289921c4b"

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "(mx6|mx7|vf|use-mainline-bsp)"

PROVIDES += "u-boot"

B = "${WORKDIR}/build"
S = "${WORKDIR}/git"
do_configure[cleandirs] = "${B}"

inherit fsl-u-boot-localversion

# U-Boot is flashed 1k into a NAND block, create a binary which prepends
# U-boot with 1k of zeros to ease flashing
nand_padding () {
    dd bs=1024 count=1 if=/dev/zero | cat - u-boot.imx > u-boot-nand.imx
}

do_compile:append:colibri-imx6ull () {
    nand_padding
}

do_compile:append:colibri-imx7 () {
    nand_padding
}

do_compile:append:colibri-vf () {
    nand_padding
}
