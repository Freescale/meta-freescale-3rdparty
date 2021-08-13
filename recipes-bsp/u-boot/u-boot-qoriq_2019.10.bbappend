FILESEXTRAPATHS:append:lx2160acex7 := "${THISDIR}/${PN}-lx2160acex7:"

SRC_URI:append:lx2160acex7 = "\
    file://0001-armv8-add-lx2160acex7-build-inclusion.patch \
    file://0002-armv8-lx2160acex-misc-hacks-to-get-the-sources-built.patch \
    file://0003-armv8-lx2160acex7-defconfig-and-main-platform-includ.patch \
    file://0004-armv8-lx2160acex7-common-files-for-platform-support.patch \
    file://0005-armv8-lx2160acex7-lx2160acex-device-tree.patch \
    file://0006-armv8-lx2160acex7-board-support-files.patch \
    file://0007-lx2160a-load-dpl-into-0x80001000-instead-of-0x80d000.patch \
    file://0008-uboot-add-nvme-commands-and-for-distroboot.patch \
    file://0009-armv8-lx2160acex7-Fix-booting-from-NVMe-drives.patch \
    file://0010-nvme-add-accessor-to-namespace-id-and-eui64.patch \
    file://0011-nvme-flush-dcache-on-both-r-w-and-the-prp-list.patch \
    file://0012-nvme-use-page-aligned-buffer-for-identify-command.patch \
    file://0013-lx2160a-cex7-move-from-lsdk-19.06-to-lsdk-19.09.patch \
    file://0014-lx2160acex7-pcie-fixup-and-boot-from-eMMC-print.patch \
    file://0015-lx2160a-cex7-set-mmc-dev-to-0-when-attempting-sd_boo.patch \
    file://0016-lx2160acex7-Misc-fixes-to-support-LSDK-20.04.patch \
    file://0017-lx2160acex7-misc-fixes-to-get-booting-from-eMMC-func.patch \
"

