require recipes-bsp/u-boot/u-boot.inc
require recipes-bsp/u-boot/u-boot-boundary-common_${PV}.inc

FILESEXTRAPATHS:prepend:mx6 := "${THISDIR}/${PN}/arm:"
FILESEXTRAPATHS:prepend:mx7 := "${THISDIR}/${PN}/arm:"
FILESEXTRAPATHS:prepend:mx8 := "${THISDIR}/${PN}/aarch64:"

DEPENDS += "bison-native"

SRC_URI += "file://fw_env.config"

PROVIDES += "u-boot"

BOOT_TOOLS = "imx-boot-tools"

do_deploy:append:mx8 () {
	install -d ${DEPLOYDIR}/${BOOT_TOOLS}
	install -m 0777 ${B}/${config}/arch/arm/dts/${UBOOT_DTB_NAME}  ${DEPLOYDIR}/${BOOT_TOOLS}
	install -m 0777 ${B}/${config}/u-boot-nodtb.bin  ${DEPLOYDIR}/${BOOT_TOOLS}/u-boot-nodtb.bin-${MACHINE}-${UBOOT_CONFIG}
}

COMPATIBLE_MACHINE = "(nitrogen6x-lite|nitrogen6x|nitrogen6sx|nitrogen7|nitrogen8m|nitrogen8mm|nitrogen8mn|nitrogen8mp)"
