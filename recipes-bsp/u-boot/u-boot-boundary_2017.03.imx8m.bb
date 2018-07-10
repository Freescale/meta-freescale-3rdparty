require recipes-bsp/u-boot/u-boot.inc
require recipes-bsp/u-boot/u-boot-boundary-common_${PV}.inc

PROVIDES += "u-boot"

COMPATIBLE_MACHINE = "(nitrogen8m)"
