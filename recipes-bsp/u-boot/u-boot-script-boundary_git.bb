LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"
COMPATIBLE_MACHINE = "(imx6qsabrelite|nitrogen6x)"
DEPENDS = "u-boot-mkimage-native"

PV = "v2013.01+git${SRCPV}"

SRCREV = "f89bc066db0569008418fac1a0408a9a57f2232f"
SRC_URI = "git://github.com/boundarydevices/u-boot-imx6.git"

S = "${WORKDIR}/git"

inherit deploy

do_mkimage () {
    # workaround the case where MACHINE=imx6qsabrelite
    if [ ! -d board/boundary/${MACHINE} ]; then
        mkdir board/boundary/${MACHINE}
    fi
    uboot-mkimage  -A arm -O linux -T script -C none -a 0 -e 0 \
                   -n "boot script" -d board/boundary/nitrogen6x/6x_bootscript-yocto.txt \
                   board/boundary/${MACHINE}/6x_bootscript

    uboot-mkimage  -A arm -O linux -T script -C none -a 0 -e 0 \
                   -n "upgrade script" -d board/boundary/nitrogen6x/6x_upgrade.txt \
                   board/boundary/${MACHINE}/6x_upgrade
}

addtask mkimage after do_compile before do_install

do_deploy () {
    install -d ${DEPLOYDIR}
    install ${S}/board/boundary/${MACHINE}/6x_bootscript \
            ${DEPLOYDIR}/6x_bootscript-${MACHINE}-${PV}-${PR}
    install ${S}/board/boundary/${MACHINE}/6x_upgrade \
            ${DEPLOYDIR}/6x_upgrade-${MACHINE}-${PV}-${PR}

    cd ${DEPLOYDIR}
    rm -f 6x_bootscript-${MACHINE} 6x_upgrade-${MACHINE}
    ln -sf 6x_bootscript-${MACHINE}-${PV}-${PR} 6x_bootscript-${MACHINE}
    ln -sf 6x_upgrade-${MACHINE}-${PV}-${PR} 6x_upgrade-${MACHINE}
}

addtask deploy after do_install before do_build

do_compile[noexec] = "1"
do_install[noexec] = "1"
do_populate_sysroot[noexec] = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"
