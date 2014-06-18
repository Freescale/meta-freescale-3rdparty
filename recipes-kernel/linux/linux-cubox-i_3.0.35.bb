include recipes-kernel/linux/linux-imx.inc

SUMMARY = "Freescale Kernel 3.0.35 supported by SolidRun with additional machine specific patches"
SRCREV = "6fc170bb7bba5917a1515bfa3dc78c091dfbcde3"
LOCALVERSION = "-4.1.0-cubox-i+yocto"
SRCBRANCH ?= "imx_3.0.35_4.1.0"

# The added patches are the ones from linux-imx 3.0.35 , with exception of these which
# are already included in the kernel repository:
#   drm-vivante-Add-00-sufix-in-returned-bus-Id.patch
#   0001-perf-tools-Fix-getrusage-related-build-failure-on-gl.patch
#   0002-ARM-7668-1-fix-memset-related-crashes-caused-by-rece.patch
#   0003-ARM-7670-1-fix-the-memset-fix.patch
SRC_URI = "git://github.com/SolidRun/linux-imx6.git;branch=${SRCBRANCH} \
           file://defconfig \
           file://epdc-Rename-mxcfb_epdc_kernel.h-to-mxc_epdc.h.patch \
           file://0004-ENGR00271136-Fix-build-break-when-CONFIG_CLK_DEBUG-i.patch \
           file://0005-ENGR00271359-Add-Multi-touch-support.patch \
           file://0006-Add-support-for-DVI-monitors.patch \
           file://0007-ARM-mach-mx6-board-mx6q_sabresd-Register-SDHC3-first.patch \
           file://mxc_hdmi-dont-require-cea-mode.patch \
           file://fix-install-breakage-for-fw-images.patch \
           file://ENGR00278350-gpu-viante-4.6.9p13-kernel-part-integra.patch"

COMPATIBLE_MACHINE = "(cubox-i)"
