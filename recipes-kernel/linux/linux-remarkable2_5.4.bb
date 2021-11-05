require recipes-kernel/linux/linux-imx.inc

SUMMARY = "Linux kernel for the reMarkable2"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

SRC_URI = "git://github.com/alistair23/linux.git;protocol=https;branch=${KBRANCH}"
KBRANCH = "5.4-rM2-2.2.x-imx"
SRCREV = "d8cb1f6be94cd94fd72c3d5637143f7042dd8147"

LINUX_VERSION = "5.4.94"
PV = "${LINUX_VERSION}"

DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(imx7d-remarkable2)"
