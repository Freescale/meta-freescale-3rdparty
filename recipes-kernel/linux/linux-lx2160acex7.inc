FILESEXTRAPATHS_append_lx2160acex7 := "${THISDIR}/linux-fslc-qoriq-lx2160acex7:"

SRC_URI_append_lx2160acex7 = "\
    file://0001-arm64-dts-lx2160a-add-lx2160acex7-device-tree-build.patch \
    file://0002-arm64-dts-lx2160a-add-lx2160acex7-device-tree.patch \
    file://0005-arm64-dts-lx2160a-cex7-add-ltc3882-support.patch \
    file://0006-arm64-dts-lx2160a-cex7-add-on-module-eeproms.patch \
    file://0007-pci-hotplug-declare-IDT-bridge-as-hotpluggabl-bridge.patch \
    file://0008-pci-spr2803-quirk-to-fix-class-ID.patch \
"
