require recipes-bsp/u-boot/u-boot.inc

DESCRIPTION = "u-boot which includes support for SolidRun boards such as Cubox-i."
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=bc069111b5e5b1ed8bed98ae73b596ec"

PROVIDES += "u-boot"

PV = "v2013.10+git${SRCPV}"

SRCREV = "a06fada55acffacfc9ea174a6980b5bce76a2aeb"
SRC_URI = " \
    git://github.com/SolidRun/u-boot-imx6.git;branch=imx6 \
    file://0001-imx6-Fix-SD-offset-to-align-with-mainline-value.patch \
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
