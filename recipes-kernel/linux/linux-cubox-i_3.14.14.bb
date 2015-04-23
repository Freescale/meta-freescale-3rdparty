include recipes-kernel/linux/linux-imx.inc
include recipes-kernel/linux/linux-dtb.inc

SUMMARY = "SolidRun 3.14.14 kernel based on Linaro 3.14"
DESCRIPTION = "Linux kernel that is based on Linaro's 3.14 releases, \
with full support for the i.MX6 features."

DEPENDS += "lzop-native bc-native"

SRCBRANCH ?= "linux-linaro-lsk-v3.14-mx6"
SRCREV = "ea83bda1b403d745c67fbf6ea307d05ca138577f"
LOCALVERSION ?= "-${SRCBRANCH}"

SRC_URI = "git://github.com/SolidRun/linux-imx6-3.14.git;branch=${SRCBRANCH} \
           file://defconfig"

COMPATIBLE_MACHINE = "(cubox-i)"
