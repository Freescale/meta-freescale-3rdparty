FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_cubox-i = "\
    file://0001-mx6cuboxi.h-Fix-finduuid.patch \
"

COMPATIBLE_MACHINE_imx6sl-warp = "(.)"
COMPATIBLE_MACHINE_imx6dl-riotboard = "(.)"
