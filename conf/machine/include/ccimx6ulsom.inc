#@TYPE: Machine
#@NAME: ConnecCore 6UL SOM
#@SOC: i.MX6UL
#@DESCRIPTION: Machine configuration for ConnectCore 6UL System-On-Module.
#@MAINTAINER: Alex Gonzalez <alex.gonzalez@digi.com>

MACHINEOVERRIDES =. "mx6:mx6ul:ccimx6ul:use-mainline-bsp:"

include conf/machine/include/imx-base.inc
include conf/machine/include/tune-cortexa7.inc

PREFERRED_PROVIDER_virtual/bootloader = "u-boot-digi"
PREFERRED_PROVIDER_u-boot = "u-boot-digi"

UBOOT_BOOTSCRIPT = "boot.scr"

UBOOT_CONFIG ??= "ccimx6ulstarter1GB ccimx6ulstarter"
UBOOT_CONFIG[ccimx6ulstarter1GB] = "ccimx6ulstarter1GB_defconfig"
UBOOT_CONFIG[ccimx6ulstarter] = "ccimx6ulstarter_defconfig"

MACHINE_EXTRA_RDEPENDS += " \
    mtd-utils-ubifs \
"

MACHINE_FEATURES += " wifi bluetooth"

MACHINE_EXTRA_RRECOMMENDS += " \
    ${@bb.utils.contains('MACHINE_FEATURES', 'wifi', 'kernel-module-qca6564 linux-firmware-qca6564-wifi', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'bluetooth', 'linux-firmware-qca6564-bt', '', d)} \
"

# mkfs.ubifs parameters for boot partition (the one holding kernel and device tree files)
# Max LEB count (-c 255) calculated for a partition of up to 32 MiB considering 128 KiB erase-block size.
MKUBIFS_BOOT_ARGS ?= "-m 2048 -e 126976 -c 255"

# mkfs.ubifs parameters for rootfs partition
# Max LEB count (-c 8191) calculated for a partition of up to 1 GiB considering 128 KiB erase-block size.
MKUBIFS_ARGS ?= "-m 2048 -e 126976 -c 8191"

IMAGE_CLASSES += "image_types_digi"
# Overwrite the defaults in imx-base not to include wic images
IMAGE_FSTYPES = "tar.bz2 ubifs boot.ubifs"
