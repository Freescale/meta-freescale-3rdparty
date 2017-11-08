require recipes-bsp/u-boot/u-boot-toradex.inc

LOCALVERSION = "-2.7.4"
PV_append = "+git${SRCPV}"

SRCREV = "1b121c6ab548a9af0a27876e9eaa0c654c1dc3e1"
SRCBRANCH = "2016.11-toradex"
COMPATIBLE_MACHINE = "(mx6|mx7|vf|use-mainline-bsp)"
