# Copyright (C) 2013-16 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc

SECTION = "kernel"

# linux-imx.inc pins the COPYING of newer kernels; 4.14 predates that
# rewrite and still ships the classic text (same GPL-2.0-only licence).
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

DEPENDS += "bc-native lzop-native"

LINUX_VERSION = "4.14.78"

SRCBRANCH = "imx_4.14.78_1.0.0_ga_var01"
SRC_URI = "\
    git://github.com/varigit/linux-imx.git;protocol=https;branch=${SRCBRANCH} \
    file://defconfig \
"
SRCREV = "0b8118cd4d7b802748ff1a5de17a31a2990cdefd"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

COMPATIBLE_MACHINE = "(mx6-nxp-bsp)"
