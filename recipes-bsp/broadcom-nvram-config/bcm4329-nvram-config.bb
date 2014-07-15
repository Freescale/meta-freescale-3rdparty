DESCRIPTION = "Nvram support for Broadcom BCM4329 wifi/bt device"
SECTION = "kernel"

include broadcom-nvram-config.inc

CHIP_MODEL = "4329"

COMPATIBLE_MACHINE = "(wandboard-dual|wandboard-quad)"
