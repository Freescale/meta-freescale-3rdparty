require u-boot-boundary-common_${PV}.inc

SUMMARY = "U-Boot bootloader fw_printenv/setenv utilities"
DEPENDS += "mtd-utils bison-native"

FILESEXTRAPATHS_prepend_mx6 := "${THISDIR}/${PN}/arm:"
FILESEXTRAPATHS_prepend_mx7 := "${THISDIR}/${PN}/arm:"
FILESEXTRAPATHS_prepend_mx8 := "${THISDIR}/${PN}/aarch64:"

SRC_URI += " \
   file://fw_env.config \
"

INSANE_SKIP_${PN} = "already-stripped"
EXTRA_OEMAKE_class-target = 'CROSS_COMPILE=${TARGET_PREFIX} CC="${CC} ${CFLAGS} ${LDFLAGS}" HOSTCC="${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS}" V=1'
EXTRA_OEMAKE_class-cross = 'ARCH=${TARGET_ARCH} CC="${CC} ${CFLAGS} ${LDFLAGS}" V=1'

inherit uboot-config

do_compile () {
    oe_runmake ${UBOOT_MACHINE}
    oe_runmake envtools
}

do_install () {
    install -Dm 0755 ${S}/tools/env/fw_printenv ${D}${base_sbindir}/fw_printenv
    install -Dm 0755 ${S}/tools/env/fw_printenv ${D}${base_sbindir}/fw_setenv
    install -Dm 0644 ${WORKDIR}/fw_env.config   ${D}${sysconfdir}/fw_env.config
}

do_install_class-cross () {
    install -d ${D}${bindir_cross}
    install -m 755 ${S}/tools/env/fw_printenv ${D}${bindir_cross}/fw_printenv
    install -m 755 ${S}/tools/env/fw_printenv ${D}${bindir_cross}/fw_setenv
}

SYSROOT_PREPROCESS_FUNCS_class-cross = "uboot_fw_utils_cross"
uboot_fw_utils_cross() {
    sysroot_stage_dir ${D}${bindir_cross} ${SYSROOT_DESTDIR}${bindir_cross}
}

RPROVIDES_${PN} += "u-boot-fw-utils"

BBCLASSEXTEND = "cross"

COMPATIBLE_MACHINE = "(imx)"
