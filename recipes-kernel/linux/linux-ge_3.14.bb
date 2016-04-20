# Copyright (C) 2016 Timesys Corporation
# Copyright (C) 2016 General Electric Company
# Released under the MIT license (see COPYING.MIT for the terms)

include recipes-kernel/linux/linux-imx.inc
include recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCREV = "5668cd93fe86889e121142440b42d4615afae984"
LOCALVERSION = "-1.1.x-fslc-imx-elo"
SRC_URI = "git://github.com/Freescale/linux-fslc.git;branch=3.14-1.1.x-imx \
           file://0001-rtc-rx8010-Add-driver-to-kernel.patch \
           file://0002-mfd-da9063-Add-support-for-production-silicon-varian.patch \
           file://0003-mfd-da9063-Upgrade-of-register-definitions-to-suppor.patch \
           file://0004-rtc-da9063-RTC-driver.patch \
           file://0005-mfd-da9063-Add-support-for-AD-silicon-variant.patch \
           file://0006-mfd-da9063-Get-irq-base-dynamically-before-registeri.patch \
           file://0007-mfd-da9063-Add-support-for-OnKey-driver.patch \
           file://0008-ahci_imx-Make-receive-DPLL-mode-configurable.patch \
           file://0009-PCI-imx6-Add-DT-bindings-to-configure-PHY-Tx-driver-.patch \
           file://0010-ARM-dts-imx-Add-support-for-Advantech-GE-ELO.patch \
           file://defconfig"

COMPATIBLE_MACHINE = "(imx6q-elo)"
