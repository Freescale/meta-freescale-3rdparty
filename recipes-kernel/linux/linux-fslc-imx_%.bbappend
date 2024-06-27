FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append:olimex-imx8mp-evb = " file://0001-imx8mp-olimex.dts-Olimex-iMX8MP-SOM-EVB-IND.patch"
