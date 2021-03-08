# Copyright (C) 2017-2019 NXP

DESCRIPTION = "i.MX ARM Trusted Firmware"
SECTION = "BSP"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

PROVIDES = "imx-atf"

PV .= "+git${SRCPV}"

SRCBRANCH = "boundary-imx_5.4.47_2.2.0"
SRC_URI = "git://github.com/boundarydevices/imx-atf.git;branch=${SRCBRANCH} \
"
SRCREV = "515fb041a3876b698b9f8e72bdfeb135d8a98623"

S = "${WORKDIR}/git"

inherit deploy

BOOT_TOOLS = "imx-boot-tools"

ATF_PLATFORM        ?= "INVALID"
ATF_PLATFORM_mx8mq   = "imx8mq"
ATF_PLATFORM_mx8mm   = "imx8mm"
ATF_PLATFORM_mx8mn   = "imx8mn"
ATF_PLATFORM_mx8mp   = "imx8mp"

EXTRA_OEMAKE += " \
    CROSS_COMPILE="${TARGET_PREFIX}" \
    PLAT=${ATF_PLATFORM} \
"

BUILD_OPTEE = "${@bb.utils.contains('MACHINE_FEATURES', 'optee', 'true', 'false', d)}"

do_compile() {
    # Clear LDFLAGS to avoid the option -Wl recognize issue
    unset LDFLAGS
    oe_runmake bl31
    if ${BUILD_OPTEE}; then
       oe_runmake clean BUILD_BASE=build-optee
       oe_runmake BUILD_BASE=build-optee SPD=opteed bl31
    fi
}

do_install[noexec] = "1"

do_deploy() {
    install -Dm 0644 ${S}/build/${ATF_PLATFORM}/release/bl31.bin ${DEPLOYDIR}/${BOOT_TOOLS}/bl31-${ATF_PLATFORM}.bin
    if ${BUILD_OPTEE}; then
       install -m 0644 ${S}/build-optee/${ATF_PLATFORM}/release/bl31.bin ${DEPLOYDIR}/${BOOT_TOOLS}/bl31-${ATF_PLATFORM}.bin-optee
    fi
}
addtask deploy after do_compile

PACKAGE_ARCH = "${MACHINE_SOCARCH}"
COMPATIBLE_MACHINE = "(nitrogen8m|nitrogen8mm|nitrogen8mn|nitrogen8mp)"
