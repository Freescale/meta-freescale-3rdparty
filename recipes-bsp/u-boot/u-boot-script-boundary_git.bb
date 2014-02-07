LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=025bf9f768cbcb1a165dbe1a110babfb"
DEPENDS = "u-boot-mkimage-native"

PV = "v2013.10+git${SRCPV}"

SRCREV = "30a8005a20e73ef963ba056d8835ab1bb8dcb77a"
SRCBRANCH = "v2013.10-20131119"
SRC_URI = "git://github.com/boundarydevices/u-boot-imx6.git;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

inherit deploy

do_mkimage () {

    boarddir=nitrogen6x;
    if test "${MACHINE}" = "nitrogen6x-lite"; then
            boarddir=nit6xlite;
    fi

    # allow deploy to use the ${MACHINE} name to simplify things
    if [ ! -d board/boundary/${MACHINE} ]; then
        mkdir board/boundary/${MACHINE}
    fi
    bootscript=board/boundary/${boarddir}/6x_bootscript-yocto.txt;
    if ! [ -f $bootscript ]; then
        bootscript=board/boundary/${boarddir}/6x_bootscript-yocto.txt;
    fi
    echo "bootscript == $bootscript"

    upgradescript=board/boundary/${boarddir}/6x_upgrade.txt;
    if ! [ -f $upgradescript ]; then
        upgradescript=board/boundary/nitrogen6x/6x_upgrade.txt;
    fi

    uboot-mkimage  -A arm -O linux -T script -C none -a 0 -e 0 \
                   -n "boot script" -d $bootscript \
                   board/boundary/${MACHINE}/6x_bootscript

    uboot-mkimage  -A arm -O linux -T script -C none -a 0 -e 0 \
                   -n "upgrade script" -d $upgradescript \
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
COMPATIBLE_MACHINE = "(nitrogen6x|nitrogen6x-lite)"
