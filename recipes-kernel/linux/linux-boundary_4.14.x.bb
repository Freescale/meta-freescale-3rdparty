# Adapted from linux-imx.inc, copyright (C) 2013, 2014 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc

SUMMARY = "Linux kernel for Boundary Devices boards"

SRC_URI = "git://github.com/boundarydevices/linux-imx6.git;branch=${SRCBRANCH} \
"

LOCALVERSION = "-2.0.0-ga+yocto"
SRCBRANCH = "boundary-imx_4.14.x_2.0.0_ga"
SRCREV = "a43570ced29f21cfbd5eff12b843f9214271aaf3"
DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(nitrogen6x|nitrogen6x-lite|nitrogen6sx|nitrogen7|nitrogen8m|nitrogen8mm|nitrogen8mn)"

KERNEL_DEFCONFIG ?= "boundary_defconfig"

S = "${WORKDIR}/git"

#Copy boundary_defconfig from git
do_copy_default_config() {
    if [ ! -f  ${WORKDIR}/defconfig ]; then
        if [ -f ${S}/arch/${ARCH}/configs/${KERNEL_DEFCONFIG} ]; then
            cp ${S}/arch/${ARCH}/configs/${KERNEL_DEFCONFIG} ${WORKDIR}/defconfig
        else
	    bberror "KERNEL_DEFCONFIG does not exist! Please set a valid KERNEL_DEFCONFIG"
	fi
    fi
}

addtask copy_default_config before do_preconfigure after do_patch
