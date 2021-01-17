require recipes-kernel/linux/linux-imx.inc

SUMMARY = "Linux kernel for the reMarkable2"

PV_append = "4.14.78+git${SRCPV}"
LINUX_VERSION = "4.14.78"

SRC_URI = "git://github.com/reMarkable/linux.git;protocol=git;branch=${SRCBRANCH} \
           file://0001-zero-sugar-Print-output-on-UART6.patch \
          "
SRCBRANCH = "zero-sugar"
SRCREV = "d4e7e07a390f8b2544ca09d69142d18114149004"

KBUILD_DEFCONFIG = "zero-sugar_defconfig"

DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(imx7d-remarkable2)"
