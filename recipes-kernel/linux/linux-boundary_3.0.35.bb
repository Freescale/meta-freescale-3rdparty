# Adapted from linux-imx.inc, copyright (C) 2013 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc

DESCRIPTION = "Linux kernel for Boundary Devices boards"

INC_PR = "r1"

SRC_URI = "git://github.com/boundarydevices/linux-imx6.git \
           file://defconfig"

LOCALVERSION = "-4.0.0"
SRCREV = "e6e1b5aeccf7c88a725440095f83dfa9459dbfca"

COMPATIBLE_MACHINE = "(mx6)"
