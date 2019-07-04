# Copyright (C) 2019 Digi International Inc.

SUMMARY = "Qualcomm QCA6564 wireless driver module"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/ISC;md5=f3b90e78ea0cffb20bf5cca7947a896d"

# Reference Qualcomm tag/version
PV = "v4.2.89.63+${SRCPV}"

SRCBRANCH = "qca6564/master"
SRCREV = "fef49841fd1b4f3fee3b2193f9927c09d59df7de"

SRC_URI = "\
    git://github.com/digi-embedded/qcacld-2.0.git;protocol=git;branch=${SRCBRANCH} \
    file://modprobe-qca6564.conf \
"

S = "${WORKDIR}/git"

inherit module

EXTRA_OEMAKE += "CONFIG_LINUX_QCMBR=y WLAN_OPEN_SOURCE=1"
# Explicity state it is not a QC platform, if not the driver will try to remap
# memory that is not allowed in ARMv6
EXTRA_OEMAKE += "CONFIG_NON_QC_PLATFORM=y"
# Flag to compile the debug version (1 - enabled, rest of values - disabled)
EXTRA_OEMAKE += "BUILD_DEBUG_VERSION=0"
# Flags for SDIO interface
EXTRA_OEMAKE += "CONFIG_CLD_HL_SDIO_CORE=y"

do_compile_prepend() {
    export BUILD_VER=${PV}
}

do_install_prepend() {
    sed -i -e "s/gVhtTxMCS=2/gVhtTxMCS=0/g" ${WORKDIR}/git/firmware_bin/WCNSS_qcom_cfg.ini
}

do_install_append() {
    install -d ${D}${sysconfdir}/modprobe.d
    install -m 0644 ${WORKDIR}/modprobe-qca6564.conf ${D}${sysconfdir}/modprobe.d/qca6564.conf

    install -d ${D}${base_libdir}/firmware/wlan/
    install -m 0644 ${WORKDIR}/git/firmware_bin/WCNSS_cfg.dat ${D}${base_libdir}/firmware/wlan/cfg.dat
    install -m 0644 ${WORKDIR}/git/firmware_bin/WCNSS_qcom_cfg.ini ${D}${base_libdir}/firmware/wlan/qcom_cfg.ini
    sed -i -e "s/gVhtTxMCS=2/gVhtTxMCS=0/g" ${D}${base_libdir}/firmware/wlan/qcom_cfg.ini
}

FILES_${PN} += " \
    ${sysconfdir}/modprobe.d/qca6564.conf \
    ${base_libdir}/firmware/wlan/cfg.dat \
    ${base_libdir}/firmware/wlan/qcom_cfg.ini \
"

RRECOMMENDS_${PN} = "hostapd iw crda wireless-regdb udev-rules-digi"

COMPATIBLE_MACHINE = "(ccimx6ul)"
