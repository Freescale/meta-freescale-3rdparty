include recipes-kernel/linux/linux-imx.inc
include recipes-kernel/linux/linux-dtb.inc

SUMMARY = "SolidRun 3.14.14 kernel based on Linaro 3.14"
DESCRIPTION = "Linux kernel that is based on Linaro's 3.14 releases, \
with full support for the i.MX6 features."

DEPENDS += "lzop-native bc-native"

SRCBRANCH ?= "linux-linaro-lsk-v3.14-mx6"
SRCREV = "4a2f77e014b8cdd10af1aac0db40f582be027f51"
LOCALVERSION ?= "-${SRCBRANCH}"

SRC_URI = "git://github.com/SolidRun/linux-imx6-3.14.git;branch=${SRCBRANCH} \
           file://defconfig"

COMPATIBLE_MACHINE = "(cubox-i)"
