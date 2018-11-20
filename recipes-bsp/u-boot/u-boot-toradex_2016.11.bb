require recipes-bsp/u-boot/u-boot.inc
require recipes-bsp/u-boot/u-boot-toradex_${PV}.inc

LOCALVERSION = "-2.8.3"

PROVIDES += "u-boot"

inherit fsl-u-boot-localversion dtc-145
