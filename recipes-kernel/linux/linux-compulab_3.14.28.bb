require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "CompuLab 3.14.28 kernel"
DESCRIPTION = "Linux kernel for CompuLab cm-fx6 boards."

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "imx_3.14.28_1.0.0_ga"
SRCREV = "91cf351a2afc17ac4a260e4d2ad1e32d00925a1b"
LOCALVERSION = "-cm-fx6"

SRC_URI += "file://defconfig \
	file://0001-ARM-i.MX6-dts-Add-initial-support-for-cm-fx6.patch \
	file://0002-ARM-i.MX6-cm-fx6-Add-defconfig.patch \
	file://0003-igb-Enable-random-mac-address.patch \
	file://0004-ARM-i.MX6-cm-fx6-update-defconfig.patch \
	file://0005-ARM-i.MX6-dts-add-HDMI-and-DVI-support.patch \
	file://0006-ARM-i.MX6-dts-add-HDMI-Audio-support.patch \
	file://0007-ARM-i.MX6-dts-add-SPDIF-support.patch \
	file://0008-ARM-i.MX6-dts-add-Power-Button.patch \
	file://0009-ARM-i.MX6-dts-Enable-uart2-as-a-serial-console.patch \
	file://0010-ARM-i.MX6-dts-add-pcie-power-reset-gpio-definition.patch \
	file://0011-ARM-i.MX6-dts-add-onboard-SSD-pin-configuration.patch \
	file://0012-ARM-i.MX6-dts-add-onboard-SSD-power-up-sequence.patch \
	file://0013-ARM-i.MX6-dts-add-audio-mux-pinmux-configuration.patch \
	file://0014-ARM-i.MX6-dts-add-analog-audio-support.patch \
	file://0015-ARM-i.MX6-ASoC-add-imx-wm8731-machine-driver.patch \
	file://0016-ARM-i.MX6-ASoC-add-imx-wm8731-master-mode-support.patch \
	file://0017-ARM-i.MX6-dts-enable-v4l2-output.patch \
	file://0018-ARM-i.MX6-dts-some-small-changes-in-the-dts-file.patch \
	file://0019-igb-Define-the-device-mac-address-in-device-tree.patch \
	file://0020-ARM-i.MX6-cm-fx6-update-defconfig.patch \
	file://0021-ARM-i.MX6-dts-refactoring-the-cm-fx6-device-tree-fil.patch \
	file://0022-ARM-i.MX6-dts-refactoring-of-the-cm-fx6-device-tree-.patch \
	file://0023-ARM-i.MX6-dts-pcie-power-on-gpio-to-a-fixed-regulato.patch \
	file://0024-ARM-i.MX6-dts-add-i2c1-status-okay.patch \
	file://0025-ARM-i.MX6-dts-add-local-mac-address-field-for-fec.patch \
	file://0026-ARM-mxs-change-usb-phy-test-clock-gating.patch \
	file://0027-ARM-i.MX6-dts-fix-the-cm-fx6-operation-points.patch \
	file://0028-ARM-i.MX6-ASoC-fix-build-warnings-and-update-include.patch \
	file://0029-ARM-i.MX6-dts-change-issd-gpio-order.patch \
	file://0030-ARM-i.MX6-dts-add-missing-WiFi-BT-pinmuxes.patch \
	file://0031-ARM-i.MX6-cm-fx6-enable-i2cmux-in-defconfig.patch \
	file://0032-ARM-i.MX6-sb-fx6m-Fix-uart1-rts-cts-flow-control.patch \
	file://0033-ARM-i.MX6-dts-add-i2cmux-support-for-SBC-FX6-boards.patch \
	file://0034-ARM-i.MX6-dts-add-dvi-edid-GPIOs.patch \
	file://0035-video-mxc-IPUv3-fb-restore-sync-bits.patch \
	file://0036-ARM-i.MX6-dts-add-backlight-support-for-SBC-FX6-boar.patch \
	file://0037-ARM-i.MX6-dts-rearrangement-of-the-frame-buffers-def.patch \
	file://0038-ARM-i.MX6-iomux-raise-DSE-for-display-signals.patch \
	file://0039-ARM-i.MX6-cm-fx6-add-video-mode-for-KD050C-WVGA.patch \
	file://0040-ARM-i.MX6-cm-fx6-refactor-the-cm-fx6-iomux.patch \
	file://0041-ARM-i.MX6-dts-gpmi-separate-kernel-and-rootfs.patch \
	file://0042-ARM-dts-cm-fx6-enable-can-bus.patch \
	file://0043-ARM-dts-cm-fx6-add-tsc2046-touchscreen-support.patch \
	file://0044-ARM-i.MX6-sb-fx6x-refactoring-of-the-usdhc3-definiti.patch \
	file://0045-ARM-i.MX6-cm-fx6-fix-up-incorrect-compatibilities.patch \
	file://0046-ARM-i.MX6-dts-fix-include-file-order.patch \
	file://0047-ARM-i.MX6-dts-rename-the-sb-fx6-board-files.patch \
	file://0048-ARM-i.MX6-dts-refactor-the-sbc-fx6-target-files.patch \
	file://0049-ARM-i.MX6-cm-fx6-separate-DL-and-Quad-stuff.patch \
	file://0050-ARM-i.MX6-dts-add-initial-support-for-cm-fx6-DL-S.patch \
	file://0051-ARM-i.MX6-dts-add-board-files-for-sbc-fx6-DL-S.patch \
	file://0052-ARM-dts-cm-fx6-add-build-targets-for-cm-fx6-flavour-.patch \
	file://0053-ARM-dts-cm-fx6-change-the-hdmi_core-ipu-connection.patch \
	file://0054-ARM-i.MX6-dts-add-ldb-support-for-SBC-FX6-boards.patch \
	file://0055-ARM-dts-cm-fx6-IOMUXC_GPR1-6-7-to-set-correct-values.patch \
	file://0056-i2c-fix-i2c_of-include.patch \
	file://0057-ARM-dts-cm-fx6-fix-missing-defines.patch \
	file://0058-imx6-hdmi-add-missing-definition.patch \
	file://0059-ARM-i.MX6-cm-fx6-update-defconfig.patch \
"

COMPATIBLE_MACHINE = "(cm-fx6)"
