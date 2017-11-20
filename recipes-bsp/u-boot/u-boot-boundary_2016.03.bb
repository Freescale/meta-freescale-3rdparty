require recipes-bsp/u-boot/u-boot.inc
require recipes-bsp/u-boot/u-boot-boundary-common_${PV}.inc

PROVIDES += "u-boot"

COMPATIBLE_MACHINE = "(imx6qsabrelite|nitrogen6x|nitrogen6sx|nitrogen7)"
