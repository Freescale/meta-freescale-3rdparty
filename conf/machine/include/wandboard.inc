# Common settings for wandboard boards

include conf/machine/include/imx-base.inc
include conf/machine/include/tune-cortexa9.inc

PREFERRED_PROVIDER_virtual/kernel ?= "linux-wandboard"
PREFERRED_VERSION_linux-wandboard ?= "3.10.17"

SERIAL_CONSOLE = "115200 ttymxc0"

MACHINE_FEATURES += "pci touchscreen"

KERNEL_IMAGETYPE = "zImage"
