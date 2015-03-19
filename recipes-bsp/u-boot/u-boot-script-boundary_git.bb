LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=025bf9f768cbcb1a165dbe1a110babfb"
DEPENDS = "u-boot-mkimage-native"

PV = "v2014.07+git${SRCPV}"

SRCREV = "fcb04d6103e2a1f62d3ae197432559aee5621765"
SRCBRANCH = "v2014.07-20140914"
SRC_URI = "git://github.com/boundarydevices/u-boot-imx6.git;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

inherit deploy

BOOTSCRIPT ?= "${S}/board/boundary/${MACHINE}/6x_bootscript-yocto.txt"
BOOTSCRIPT_imx6qsabrelite ?= "${S}/board/boundary/nitrogen6x/6x_bootscript-yocto.txt"
BOOTSCRIPT_nitrogen6x-lite ?= "${S}/board/boundary/nit6xlite/6x_bootscript-yocto.txt"

UPGRADESCRIPT = "${S}/board/boundary/nitrogen6x/6x_upgrade.txt"

do_mkimage () {
    # allow deploy to use the ${MACHINE} name to simplify things
    if [ ! -d board/boundary/${MACHINE} ]; then
        mkdir board/boundary/${MACHINE}
    fi

    uboot-mkimage -A arm -O linux -T script -C none -a 0 -e 0 \
                  -n "boot script" -d ${BOOTSCRIPT} \
                  board/boundary/${MACHINE}/6x_bootscript

    uboot-mkimage -A arm -O linux -T script -C none -a 0 -e 0 \
                  -n "upgrade script" -d ${UPGRADESCRIPT} \
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
