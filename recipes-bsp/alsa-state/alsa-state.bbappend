do_install_append_cubox-i() {
	sed -i -e 's/0,0/2,0/g' ${D}${sysconfdir}/asound.conf
	sed -i -e 's/card 0/card 2/g' ${D}${sysconfdir}/asound.conf
}
