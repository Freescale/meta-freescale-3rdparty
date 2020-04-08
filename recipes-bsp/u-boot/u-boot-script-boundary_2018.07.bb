require recipes-bsp/u-boot/u-boot-boundary-common_${PV}.inc

DEPENDS = "u-boot-mkimage-native"

inherit deploy

BOOTSCRIPT ??= "${S}/board/boundary/bootscripts/bootscript-yocto.txt"
BOOTSCRIPT_use-mainline-bsp ??= "${S}/board/boundary/bootscripts/bootscript-mainline.txt"

UPGRADESCRIPT = "${S}/board/boundary/bootscripts/upgrade.txt"

do_mkimage () {
    uboot-mkimage -A arm -O linux -T script -C none -a 0 -e 0 \
                  -n "boot script" -d ${BOOTSCRIPT} ${S}/boot.scr

    uboot-mkimage -A arm -O linux -T script -C none -a 0 -e 0 \
                  -n "upgrade script" -d ${UPGRADESCRIPT} ${S}/upgrade.scr
}

addtask mkimage after do_compile before do_install

do_compile[noexec] = "1"

do_install () {
    install -D -m 644 ${S}/boot.scr ${D}/boot.scr
    install -D -m 644 ${S}/upgrade.scr ${D}/upgrade.scr
}

do_deploy () {
    install -D -m 644 ${D}/boot.scr \
                      ${DEPLOYDIR}/boot.scr-${MACHINE}-${PV}-${PR}
    install -D -m 644 ${D}/upgrade.scr \
                      ${DEPLOYDIR}/upgrade.scr-${MACHINE}-${PV}-${PR}

    cd ${DEPLOYDIR}
    rm -f boot.scr-${MACHINE} upgrade.scr-${MACHINE}
    ln -sf boot.scr-${MACHINE}-${PV}-${PR} boot.scr-${MACHINE}
    ln -sf upgrade.scr-${MACHINE}-${PV}-${PR} upgrade.scr-${MACHINE}
}

addtask deploy after do_install before do_build

FILES_${PN} += "/"

COMPATIBLE_MACHINE = "(nitrogen6x-lite|nitrogen6x|nitrogen6sx|nitrogen7|nitrogen8m|nitrogen8mm|nitrogen8mn)"
