# Adapted from linux-imx.inc, copyright (C) 2013 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc

DESCRIPTION = "Linux kernel for Boundary Devices boards"

SRC_URI = "git://github.com/boundarydevices/linux-imx6.git \
           file://defconfig"

LOCALVERSION = "-4.0.0"
SRCREV = "7d8752905c118af9063738a533227de0b2f6ecd4"

COMPATIBLE_MACHINE = "(mx6)"
