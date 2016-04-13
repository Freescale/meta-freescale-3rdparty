# Copyright (C) 2013-14 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

COMPATIBLE_MACHINE = "(mx6)"

SRC_URI = "\
    git://github.com/varigit/linux-2.6-imx.git;protocol=git;branch=imx_3.14.28-r0_var3 \
    file://0001-ARM-LLVMLinux-Change-extern-inline-to-static-inline.patch \
    file://0001-ARM-8158-LLVMLinux-use-static-inline-in-ARM-ftrace.patch \
    \
    file://upstream-backport/wifi/0001-wlcore-memset-wl-rx_filter_enabled-to-zero-after-rec.patch \
    file://upstream-backport/wifi/0002-wlcore-cancel-Tx-watchdog-on-suspend-and-rearm-on-fi.patch \
    file://upstream-backport/wifi/0003-wlcore-block-read-writes-to-FW-during-ELP.patch \
    file://upstream-backport/wifi/0004-wlcore-AP-don-t-start-mac80211-PS-on-non-peer-HLIDs.patch \
    file://upstream-backport/wifi/0005-wlcore-wl12xx-wl18xx-simplify-fw_status-handling.patch \
    file://upstream-backport/wifi/0006-wlcore-wl12xx-wl18xx-configure-num_links-per-hw.patch \
    file://upstream-backport/wifi/0007-wlcore-wl12xx-wl18xx-configure-max_stations-per-hw.patch \
    file://upstream-backport/wifi/0008-wlcore-wl12xx-wl18xx-configure-iface_combinations-pe.patch \
    file://upstream-backport/wifi/0009-wl18xx-move-to-new-firmware-wl18xx-fw-3.bin.patch \
    file://upstream-backport/wifi/0010-wlcore-send-EAPOL-frames-with-voice-priority.patch \
    file://upstream-backport/wifi/0011-wlcore-don-t-stop-sched_scan-on-interface-removal.patch \
    file://upstream-backport/wifi/0012-wlcore-wl18xx-allow-CCK-rates-for-AP-mode.patch \
    file://upstream-backport/wifi/0013-wlcore-don-t-handle-unsetting-of-default-wep-key.patch \
    file://upstream-backport/wifi/0014-wlcore-consider-multiple-APs-when-checking-active_li.patch \
    file://upstream-backport/wifi/0015-wlcore-decrease-warning-verbosity-during-recovery.patch \
    file://upstream-backport/wifi/0016-wlcore-increase-timeout-to-5000-msecs.patch \
    file://upstream-backport/wifi/0017-wlcore-enable-beacon-filtering-only-after-receiving-.patch \
    file://upstream-backport/wifi/0018-wlcore-add-support-for-STA-CSA-with-chan-contexts.patch \
    file://upstream-backport/wifi/0019-wlcore-use-correct-LAA-bit.patch \
    file://upstream-backport/wifi/0020-wlcore-fix-copy-paste-bug-assign-from-src-struct-not.patch \
    file://boundarydevices/0002-wlcore-add-initial-device-tree-support-to-the-sdio-m.patch \
    file://boundarydevices/0003-wlcore-add-mac-override-parameter.patch \
    \
    file://arm-Export-cache-flush-management-symbols-when-multi-cache.patch \
    file://Set-dr_mode-to-otg.patch \
    \
    file://defconfig \
"

SRCREV = "52373bf29aac80cacc519f4cb8aed22af2a2370d"
LOCALVERSION = "-1.1.0"
