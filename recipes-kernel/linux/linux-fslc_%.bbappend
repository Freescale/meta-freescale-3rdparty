FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

COMPATIBLE_MACHINE_imx6sl-warp = "(.)"
COMPATIBLE_MACHINE_imx6dl-riotboard = "(.)"

SRC_URI_append_imx6qdl-variscite-som_use-mainline-bsp = " \
    file://imx6qdl-var-som.dtsi \
    file://imx6q-var-som-vsc.dts \
"

do_configure_prepend_imx6qdl-variscite-som() {
    cp ${WORKDIR}/imx6*-var*.dts* ${S}/arch/arm/boot/dts
}
