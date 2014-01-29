require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=bc069111b5e5b1ed8bed98ae73b596ec"

PROVIDES += "u-boot"

PV = "v2013.10+git${SRCPV}"

SRCREV = "920ea0f20276614e11961924b1990b6c922c8d0e"
SRC_URI = " \
    git://github.com/rabeeh/u-boot-imx6.git;branch=imx6 \
    file://uEnv.txt \
    "

S = "${WORKDIR}/git"

UENV_FILENAME ?= "uEnv-${MACHINE}.txt"

deploy_uenv () {
    install ${WORKDIR}/uEnv.txt ${DEPLOYDIR}/${UENV_FILENAME}
}

do_deploy[postfuncs] += "deploy_uenv"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "cubox-i"
