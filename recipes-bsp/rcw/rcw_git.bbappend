FILESEXTRAPATHS:append:lx2160acex7 := "${THISDIR}/${PN}-lx2160acex7:"

SRC_URI:append:lx2160acex7 = "\
	file://0001-lx2160acex7-misc-RCW-files.patch \
	file://0002-Set-io-pads-as-GPIO.patch \
	file://0003-S2-enable-gen3-xspi-increase-divisor-to-28.patch \
	file://0004-refactor-a009531-a008851-and-a011270.patch \
	file://0006-lx2160a-add-SVR-check-for-a050234-to-apply-only-on-r.patch \
	file://0007-lx2160acex7-pcie-workarounds-and-fan-full-speed.patch \
	file://0008-lx2160a-add-generic-bootloc-section.patch \
	file://0009-lx2160acex7-remove-all-predefined-RCW-files.patch \
"

do_configure:prepend:lx2160acex7 () {
    for BT in ${BOARD_TARGETS}
    do
	mkdir -p ${S}/${BOARD_TARGETS}/${SERDES}
	cat <<EOF >${S}/${BOARD_TARGETS}/README
The RCW directories for lx2160acex7 are created based on existing SERDES
configuration. Currently created automatically - later maybe by building
cross product of serdes & ddr speeds in a final commit.
EOF
	cat <<EOF >${S}/${BOARD_TARGETS}/${SERDES}/${SPEED}.rcw
#include <configs/lx2160a_defaults.rcwi>
#include <configs/lx2160a_${SPEED}.rcwi>
#include <configs/lx2160a_${SERDES}.rcwi>
EOF
    done
}
