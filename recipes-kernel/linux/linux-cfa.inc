SUMMARY = "Linux kernel for Crystalfontz boards"
SECTION = "kernel"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel
require recipes-kernel/linux/linux-dtb.inc

SRC_URI = "git://github.com/crystalfontz/cfa_10036_kernel;branch=${SRCBRANCH} \
           file://defconfig"

S = "${WORKDIR}/git"

# create symlinks that are the defaults of barebox
pkg_postinst_kernel-devicetree_append () {
	for DTB_FILE in ${KERNEL_DEVICETREE}
	do
		DTB_BASE_NAME=`basename ${DTB_FILE} | awk -F "." '{print $1}'`
		DTB_BOARD_NAME=`echo ${DTB_BASE_NAME} | awk -F "-" '{print $2}'`
		DTB_SYMLINK_NAME=`echo ${KERNEL_IMAGE_SYMLINK_NAME} | sed "s/${MACHINE}/${DTB_BASE_NAME}/g"`
		update-alternatives --install /${KERNEL_IMAGEDEST}/oftree-${DTB_BOARD_NAME} oftree-${DTB_BOARD_NAME} devicetree-${DTB_SYMLINK_NAME}.dtb ${KERNEL_PRIORITY} || true
	done
}

pkg_postinst_kernel-image_append () {
	update-alternatives --install /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-cfa10036 ${KERNEL_IMAGETYPE}-cfa10036 ${KERNEL_IMAGETYPE}-${KERNEL_VERSION} ${KERNEL_PRIORITY} || true
}

