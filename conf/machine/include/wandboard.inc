# Common settings for wandboard boards

include conf/machine/include/imx-base.inc
include conf/machine/include/tune-cortexa9.inc

PREFERRED_PROVIDER_virtual/kernel ?= "linux-wandboard"

SERIAL_CONSOLE = "115200 ttymxc0"

MACHINE_FEATURES += "pci touchscreen"
