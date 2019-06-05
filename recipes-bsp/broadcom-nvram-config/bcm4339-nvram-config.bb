DESCRIPTION = "Nvram support for Broadcom BCM4339 wifi/bt device"
SECTION = "kernel"

include broadcom-nvram-config.inc

CHIP_MODEL = "4339"

COMPATIBLE_MACHINE = "(imx7d-pico|imx6ul-pico|imx6qdl-pico)"
