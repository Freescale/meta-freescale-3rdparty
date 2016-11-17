# Copyright (C) 2013-16 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

COMPATIBLE_MACHINE = "(mx6)"

SRCBRANCH = "imx-rel_imx_4.1.15_1.1.0_ga-var02"
SRCREV = "1e7785b94784f23703dabeff3072a0a89e2bc90d"
SRC_URI = " \
    git://github.com/varigit/linux-2.6-imx.git;protocol=git;branch=${SRCBRANCH} \
    file://Fix-the-compile-issue-under-gcc6.patch \
    file://0001-mxc_hdmi-mxc_hdmi-allow-EDID-to-select-non-CEA-modes.patch \
    file://imx6qdl-var-som-Enable-wl12xx.patch \
    file://defconfig \
"

LOCALVERSION = "-1.1.0"

KERNEL_IMAGETYPE = "uImage"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

