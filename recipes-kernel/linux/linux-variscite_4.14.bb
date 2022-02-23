# Copyright (C) 2013-16 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc

DEPENDS += "lzop-native bc-native"

LINUX_VERSION = "4.14.78"

SRCBRANCH = "imx_4.14.78_1.0.0_ga_var01"
SRCREV = "0b8118cd4d7b802748ff1a5de17a31a2990cdefd"
SRC_URI = "\
    git://github.com/varigit/linux-imx.git;protocol=https;branch=${SRCBRANCH} \
    file://defconfig \
"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

COMPATIBLE_MACHINE = "(mx6-nxp-bsp)"
