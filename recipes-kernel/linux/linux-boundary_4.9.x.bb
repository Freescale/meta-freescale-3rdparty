# Adapted from linux-imx.inc, copyright (C) 2013, 2014 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc

SUMMARY = "Linux kernel for Boundary Devices boards"

FILESEXTRAPATHS_prepend_mx6 := "${THISDIR}/${PN}-${PV}/arm:"
FILESEXTRAPATHS_prepend_mx7 := "${THISDIR}/${PN}-${PV}/arm:"
FILESEXTRAPATHS_prepend_mx8 := "${THISDIR}/${PN}-${PV}/arm64:"

SRC_URI = "git://github.com/boundarydevices/linux-imx6.git;branch=${SRCBRANCH} \
           file://defconfig \
"

LOCALVERSION = "-2.0.0-ga+yocto"
SRCBRANCH = "boundary-imx_4.9.x_2.0.0_ga"
SRCREV = "a141bcc882fbba6c2d80d467fa54ac07b37b6f04"
DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(nitrogen6x|nitrogen6x-lite|nitrogen6sx|nitrogen7|nitrogen8m)"
