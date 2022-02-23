require recipes-kernel/linux/linux-imx.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

DEPENDS += "lzop-native bc-native"

SUMMARY = "Linux kernel for Toradex Freescale i.MX based modules"

# The recipe by default uses KBUILD_DEFCONFIG from the machine
# configuration. Set KBUILD_DEFCONFIG = "" and add a file 'defconfig' to
# SRC_URI to inject your defconfig in a bbappend.
SRC_URI = "git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH}"

PV:append = "+git${SRCPV}"

LINUX_VERSION = "5.4.129"

SRCREV = "828ec42a6a32004a199f8ee4893fecdc0b15ae92"
SRCBRANCH = "toradex_5.4-2.3.x-imx"

# Deploy symbols to allow for device tree overlays
EXTRA_OEMAKE += "DTC_FLAGS=-@ "

COMPATIBLE_MACHINE = "(mx6-nxp-bsp|mx7-nxp-bsp|mx8-nxp-bsp)"
