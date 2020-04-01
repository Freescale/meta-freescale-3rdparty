DESCRIPTION = "Boot script for launching images with U-Boot distro boot"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

INHIBIT_DEFAULT_DEPS = "1"
DEPENDS = "u-boot-mkimage-native"

SRC_URI = "\
    file://boot.cmd.in \
"

KERNEL_BOOTCMD ??= "bootz"
KERNEL_BOOTCMD_aarch64 ?= "booti"

inherit deploy nopackages

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_mkimage() {
    sed -e 's/@@KERNEL_BOOTCMD@@/${KERNEL_BOOTCMD}/' \
        "${WORKDIR}/boot.cmd.in" > ${B}/boot.cmd
    mkimage -T script -C none -n "Distro boot script" -d ${B}/boot.cmd ${B}/boot.scr
}

addtask mkimage after do_compile before do_install

do_install() {
    install -Dm 0644 ${B}/boot.scr ${D}/boot.scr
}

do_deploy() {
    install -Dm 0644 ${D}/boot.scr ${DEPLOYDIR}/boot.scr-${MACHINE}-${PV}-${PR}
    cd ${DEPLOYDIR}
    rm -f boot.scr-${MACHINE}
    ln -sf boot.scr-${MACHINE}-${PV}-${PR} boot.scr-${MACHINE}
}

addtask deploy after do_install before do_build

PROVIDES += "u-boot-default-script"

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "(apalis-imx6|colibri-imx6|colibri-imx6ull|colibri-imx7-emmc|colibri-imx7-nand|colibri-vf)"
