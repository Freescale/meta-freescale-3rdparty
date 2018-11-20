require recipes-bsp/u-boot/u-boot-toradex_${PV}.inc

SUMMARY = "U-Boot bootloader fw_printenv/setenv utilities"

SRC_URI += "file://0001-tools-fix-cross-compiling-tools-when-HOSTCC-is-overr.patch \
            file://fw_env.config \
"

DEPENDS += "mtd-utils"

INSANE_SKIP_${PN} = "already-stripped"
EXTRA_OEMAKE_class-target = 'CROSS_COMPILE=${TARGET_PREFIX} CC="${CC} ${CFLAGS} ${LDFLAGS}" HOSTCC="${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS}" V=1'
EXTRA_OEMAKE_class-cross = 'ARCH=${TARGET_ARCH} CC="${CC} ${CFLAGS} ${LDFLAGS}" V=1'

inherit uboot-config

do_compile () {
    oe_runmake ${UBOOT_MACHINE}
    oe_runmake env
}

do_install () {
    install -d ${D}${base_sbindir}
    install -d ${D}${sysconfdir}
    install -m 755 ${S}/tools/env/fw_printenv ${D}${base_sbindir}/fw_printenv
    install -m 755 ${S}/tools/env/fw_printenv ${D}${base_sbindir}/fw_setenv
    install -m 0644 ${WORKDIR}/fw_env.config ${D}${sysconfdir}/fw_env.config
}

do_install_class-cross () {
    install -d ${D}${bindir_cross}
    install -m 755 ${S}/tools/env/fw_printenv ${D}${bindir_cross}/fw_printenv
    install -m 755 ${S}/tools/env/fw_printenv ${D}${bindir_cross}/fw_setenv
}

SYSROOT_DIRS_append_class-cross = " ${bindir_cross}"

PROVIDES += "u-boot-fw-utils"
RPROVIDES_${PN} += "u-boot-fw-utils"

PACKAGE_ARCH = "${MACHINE_ARCH}"
BBCLASSEXTEND = "cross"
