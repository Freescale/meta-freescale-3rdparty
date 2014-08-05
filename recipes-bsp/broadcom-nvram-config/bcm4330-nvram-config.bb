DESCRIPTION = "Nvram support for Broadcom BCM4330 wifi/bt device"
SECTION = "kernel"

include broadcom-nvram-config.inc

CHIP_MODEL = "4330"

COMPATIBLE_MACHINE = "(nitrogen6x-lite|wandboard-dual|wandboard-quad)"
