require recipes-bsp/u-boot/u-boot.inc
require recipes-bsp/u-boot/u-boot-toradex-common.inc

DEPENDS += "bc-native dtc-native"

PROVIDES += "u-boot"

B = "${WORKDIR}/build"
do_configure[cleandirs] = "${B}"

inherit fsl-u-boot-localversion
