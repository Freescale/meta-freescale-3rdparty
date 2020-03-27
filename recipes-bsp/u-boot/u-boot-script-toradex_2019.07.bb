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

do_deploy() {
    sed -e 's/@@KERNEL_BOOTCMD@@/${KERNEL_BOOTCMD}/' \
        "${WORKDIR}/boot.cmd.in" > boot.cmd
    mkimage -T script -C none -n "Distro boot script" -d boot.cmd boot.scr
    install -m 0644 boot.scr ${DEPLOYDIR}
}

addtask deploy after do_install before do_build

PACKAGE_ARCH = "${MACHINE_ARCH}"
