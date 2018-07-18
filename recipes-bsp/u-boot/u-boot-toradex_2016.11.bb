require recipes-bsp/u-boot/u-boot-toradex.inc

LOCALVERSION = "-2.8.3"
PV_append = "+git${SRCPV}"

SRCREV = "aca804c9ddadbf34a8ff82779e5598ec5e319f23"
SRCBRANCH = "2016.11-toradex"
COMPATIBLE_MACHINE = "(mx6|mx7|vf|use-mainline-bsp)"
