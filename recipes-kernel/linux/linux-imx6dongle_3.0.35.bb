# Adapted from linux-imx.inc, copyright (C) 2013 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc

DESCRIPTION = "Linux kernel for i.MX6 HDMI dongle"

SRC_URI = "git://github.com/imx6-dongle/linux-imx.git \
           file://defconfig \
"

LOCALVERSION = "-1.1.0-hdmidongle"
SRCREV = "899792c5fa2f1fe6919366d5ccc4d33f419012bf"

COMPATIBLE_MACHINE = "(mx6)"

