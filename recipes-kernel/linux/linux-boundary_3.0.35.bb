# Adapted from linux-imx.inc, copyright (C) 2013 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc

DESCRIPTION = "Linux kernel for Boundary Devices boards"

INC_PR = "r1"

SRC_URI = "git://github.com/boundarydevices/linux-imx6.git \
           file://defconfig"

LOCALVERSION = "-1.1.0"
SRCREV = "2dc5560fddb82b26c7010978361c28aad42fc023"

COMPATIBLE_MACHINE = "(mx6)"
