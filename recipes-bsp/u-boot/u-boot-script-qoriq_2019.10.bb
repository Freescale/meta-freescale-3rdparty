DESCRIPTION = "Boot script for launching images with U-Boot distro boot"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

INHIBIT_DEFAULT_DEPS = "1"
DEPENDS = "u-boot-mkimage-native"

SRC_URI = "\
    file://boot.cmd.in \
"

KERNEL_BOOTCMD ?= "booti"

inherit deploy

do_configure[noexec] = "1"

do_compile() {
    kernel_devicetree_spc=""
    kernel_devicetree_tmp=""
    for kdt in ${KERNEL_DEVICETREE}
    do
	kernel_devicetree_tmp="${kernel_devicetree_tmp}${kernel_devicetree_spc}$(basename ${kdt})"
	kernel_devicetree_spc=" "
    done
    kernel_devicetree="${kernel_devicetree_tmp}"
    sed -e 's/@KERNEL_BOOTCMD[@]/${KERNEL_BOOTCMD}/' -e "s,@KERNEL_IMAGETYPE[@],${KERNEL_IMAGETYPE},g" \
	-e "s,@KERNEL_DEVICETREE[@],${kernel_devicetree},g" \
        "${WORKDIR}/boot.cmd.in" > ${B}/boot.cmd
    target_arch="${TARGET_ARCH}"
    test "${TARGET_ARCH}" = "aarch64" && target_arch="arm64"
    mkimage -A ${target_arch} -T script -C none -n "Distro boot script" -d ${B}/boot.cmd ${B}/boot.scr
}

do_install() {
    install -Dm 0644 ${B}/boot.scr ${D}/boot/boot.scr
}

do_deploy() {
    install -Dm 0644 ${D}/boot/boot.scr ${DEPLOYDIR}/boot.scr-${MACHINE}-${PV}-${PR}
    cd ${DEPLOYDIR}
    rm -f boot.scr-${MACHINE}
    ln -sf boot.scr-${MACHINE}-${PV}-${PR} boot.scr-${MACHINE}
}

addtask deploy after do_install before do_build

PROVIDES += "u-boot-default-script"

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "(qoriq)"

FILES:${PN} = "/boot"
