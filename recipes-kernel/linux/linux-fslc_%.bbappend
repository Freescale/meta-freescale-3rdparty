FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

COMPATIBLE_MACHINE_imx6sl-warp = "(.)"
COMPATIBLE_MACHINE_imx6dl-riotboard = "(.)"

SRC_URI_append_imx6qdl-variscite-som_use-mainline-bsp = " \
    file://imx6qdl-var-som.dtsi \
    file://imx6q-var-som-vsc.dts \
"

SRC_URI_append_ccimx6ul = " \
    file://0001-MLK-11719-4-mtd-gpmi-change-the-BCH-layout-setting-f.patch \
    ${@bb.utils.contains('MACHINE_FEATURES', 'wifi', 'file://0002-ARM-dts-imx6ul-ccimx6ulsom-Add-empty-wireless-and-bl.patch', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'wifi', 'file://0003-net-wireless-Export-regulatory_hint_user.patch', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'wifi', 'file://0004-net-wireless-Allow-for-firmware-to-handle-DFS.patch', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'wifi', 'file://0005-net-wireless-Add-cfg80211_is_gratuitous_arp_unsolici.patch', '', d)} \
    file://0006-linux-crypto-caam-set-hwrng-quality.patch \
"

do_configure_prepend_ccimx6ul() {
    if ${@bb.utils.contains('MACHINE_FEATURES', 'wifi', 'true', 'false', d)}; then
        kernel_conf_variable HOSTAP m
        kernel_conf_variable PROVE_LOCKING n
        sed -e "${CONF_SED_SCRIPT}" < '${WORKDIR}/defconfig' >> '${B}/.config'
    fi
    if ${@bb.utils.contains('MACHINE_FEATURES', 'bluetooth', 'true', 'false', d)}; then
        kernel_conf_variable BT_RFCOMM y
        sed -e "${CONF_SED_SCRIPT}" < '${WORKDIR}/defconfig' >> '${B}/.config'
    fi
}

do_configure_prepend_imx6qdl-variscite-som() {
    cp ${WORKDIR}/imx6*-var*.dts* ${S}/arch/arm/boot/dts
}
