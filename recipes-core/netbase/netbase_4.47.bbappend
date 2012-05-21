FILESEXTRAPATHS_prepend := "${THISDIR}/netbase:"

PRINC := "${@int(PRINC) + 1}"

SRC_URI_append_imx233-olinuxino-maxi = " file://00-persistent-mac"

do_install_append_imx233-olinuxino-maxi () {
    install -m 0755 ${WORKDIR}/00-persistent-mac ${D}${sysconfdir}/network/if-pre-up.d
}
