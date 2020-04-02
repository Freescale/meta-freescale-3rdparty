require recipes-bsp/u-boot/u-boot.inc
require recipes-bsp/u-boot/u-boot-toradex-common.inc

DEPENDS += "bc-native dtc-native"

SRC_URI += "file://fw_env.config"

PROVIDES += "u-boot"

B = "${WORKDIR}/build"
do_configure[cleandirs] = "${B}"

inherit fsl-u-boot-localversion

# U-Boot is flashed 1k into a NAND block, create a binary which prepends
# U-boot with 1k of zeros to ease flashing
nand_padding () {
    dd bs=1024 count=1 if=/dev/zero | cat - u-boot.imx > u-boot-nand.imx
}

do_compile_append_colibri-imx6ull () {
    nand_padding
}

do_compile_append_colibri-imx7 () {
    nand_padding
}

do_compile_append_colibri-vf () {
    nand_padding
}
