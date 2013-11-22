FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

PRINC := "${@int(PRINC) + 5}"

# FIXME: Congatec qmx6 support is based on 3.0.35-4.0.0
SRCREV_cgtqmx6 = "535af2fbee4d90ef1e5e75ffb25d8229d7480b32"
SRC_URI_cgtqmx6 = "git://git.freescale.com/imx/linux-2.6-imx.git \
                   file://defconfig \
                   file://0001-ENGR00255688-4.6.9p11.1-gpu-GPU-Kernel-driver-integr.patch \
                   file://0002-ENGR00265465-gpu-Add-global-value-for-minimum-3D-clo.patch \
                   file://0003-ENGR00261814-4-gpu-use-new-PU-power-on-off-interface.patch \
                   file://0004-ENGR00264288-1-GPU-Integrate-4.6.9p12-release-kernel.patch \
                   file://0005-ENGR00264275-GPU-Correct-suspend-resume-calling-afte.patch \
                   file://0006-ENGR00265130-gpu-Correct-section-mismatch-in-gpu-ker.patch \
                   file://drm-vivante-Add-00-sufix-in-returned-bus-Id.patch \
                   file://cgtqmx6/0001-Add-linux-support-for-congatec-evaluation-board-qmx6q.patch"
