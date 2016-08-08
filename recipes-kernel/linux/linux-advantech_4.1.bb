# Copyright (C) 2016 Timesys Corporation
# Copyright (C) 2016 Advantech Corporation
# Released under the MIT license (see COPYING.MIT for the terms)

include recipes-kernel/linux/linux-imx.inc
include recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "4.1-1.0.x-imx"
SRCREV = "8eaed11bf59476b24c46a41036b34e969c40d165"
LOCALVERSION = "-${SRCBRANCH}-dms-ba16"

SRC_URI = "git://github.com/Freescale/linux-fslc.git;branch=${SRCBRANCH} \
           file://0001-rtc-rx8010-Add-driver-to-kernel.patch \
           file://0002-ahci_imx-Make-receive-DPLL-mode-configurable.patch \
           file://0003-PCI-imx6-Add-DT-bindings-to-configure-PHY-Tx-driver-.patch \
           file://0004-input-da9063_onkey-Add-driver.patch \
           file://0005-mfd-da9063-Add-support-for-OnKey-driver.patch \
           file://0006-add-usb-hub_test-suport.patch \
           file://0007-ARM-dts-imx-Add-support-for-Advantech-DMS-BA16.patch \
           file://0008-da9063-Add-a-PMIC-qurk-to-support-system-suspend-res.patch \
           file://0009-mfd-da9063-Add-wakeup-source-support.patch \
           file://0010-ARM-dts-imx-Add-Q7-SUS_S3_OUT-control-support-during.patch \
           file://defconfig"

COMPATIBLE_MACHINE = "(imx6q-dms-ba16)"
