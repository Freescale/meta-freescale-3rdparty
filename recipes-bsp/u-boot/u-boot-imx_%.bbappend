FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append:olimex-imx8mp-evb = " file://0001-Add-Olimex-iMX8MP-SOM-EVB-IND.patch"
