FILESEXTRAPATHS:append:lx2160acex7 := "${THISDIR}/linux-fslc-qoriq-lx2160acex7:"

SRC_URI:append:lx2160acex7 = "\
    file://0001-arm64-dts-lx2160a-add-lx2160acex7-device-tree-build.patch \
    file://0002-arm64-dts-lx2160a-add-lx2160acex7-device-tree.patch \
    file://0005-arm64-dts-lx2160a-cex7-add-ltc3882-support.patch \
    file://0006-arm64-dts-lx2160a-cex7-add-on-module-eeproms.patch \
    file://0009-lx2160a-dwc3-dts-disable-usb3-parkmode.patch \
    file://0010-arm64-dts-lx2160a-cex7-add-power-button-support.patch \
    file://0011-aarm64-dts-lx2160a-cex7-add-secondary-spi-flash-supp.patch \
"
