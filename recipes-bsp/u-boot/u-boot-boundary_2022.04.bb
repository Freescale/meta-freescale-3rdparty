# nooelint: oelint.var.mandatoryvar.SUMMARY
# SUMMARY comes from oe-core's u-boot.inc, required below; oelint cannot
# follow a require into another layer.
require recipes-bsp/u-boot/u-boot.inc
require recipes-bsp/u-boot/u-boot-boundary-common_${PV}.inc

HOMEPAGE = "https://github.com/boundarydevices/u-boot"

inherit ${@oe.utils.ifelse(d.getVar('UBOOT_PROVIDES_BOOT_CONTAINER') == '1', 'imx-boot-container', '')} deploy

DEPENDS += "bison-native dtc-native python3-setuptools-native"
PROVIDES += "u-boot"

SRC_URI += "file://fw_env.config"

COMPATIBLE_MACHINE = "(nitrogen6x-lite|nitrogen6x|nitrogen6sx|nitrogen7|nitrogen8m|nitrogen8mm|nitrogen8mn|nitrogen8mp)"
