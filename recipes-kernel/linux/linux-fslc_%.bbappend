FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

COMPATIBLE_MACHINE:imx6sl-warp = "(.)"
COMPATIBLE_MACHINE:imx6dl-riotboard = "(.)"

SRC_URI:append:imx6qdl-variscite-som:use-mainline-bsp = " \
    file://imx6qdl-var-som.dtsi \
    file://imx6q-var-som-vsc.dts \
"

do_configure:prepend:imx6qdl-variscite-som() {
    cp ${WORKDIR}/imx6*-var*.dts* ${S}/arch/arm/boot/dts
}
