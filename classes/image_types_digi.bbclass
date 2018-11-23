inherit image_types

do_image_boot_ubifs[depends] += " \
    mtd-utils-native:do_populate_sysroot \
    u-boot:do_deploy \
    virtual/kernel:do_deploy \
"

IMAGE_CMD_boot.ubifs() {
	BOOTIMG_FILES_SYMLINK="${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${MACHINE}.bin"
	if [ -n "${KERNEL_DEVICETREE}" ]; then
		for DTB in ${KERNEL_DEVICETREE}; do
			# Remove potential sub-folders
			DTB="$(basename ${DTB})"
			if [ -e "${DEPLOY_DIR_IMAGE}/${DTB}" ]; then
				BOOTIMG_FILES_SYMLINK="${BOOTIMG_FILES_SYMLINK} ${DEPLOY_DIR_IMAGE}/${DTB}"
			fi
		done
	fi

	# Create temporary folder
	TMP_BOOTDIR="$(mktemp -d ${IMGDEPLOYDIR}/boot.XXXXXX)"

	# Hard-link BOOTIMG_FILES into the temporary folder with the symlink filename
	for item in ${BOOTIMG_FILES_SYMLINK}; do
		orig="$(readlink -e ${item})"
		ln "${orig}" "${TMP_BOOTDIR}/$(basename ${item})"
	done

	# Hard-link extlinux.conf file if available
	if [ "${UBOOT_EXTLINUX}" = "1" ]; then
		mkdir -p ${TMP_BOOTDIR}/${UBOOT_EXTLINUX_INSTALL_DIR}
		orig="$(readlink -e ${DEPLOY_DIR_IMAGE}/${UBOOT_EXTLINUX_CONF_NAME})"
		ln "${orig}" "${TMP_BOOTDIR}${UBOOT_EXTLINUX_INSTALL_DIR}/${UBOOT_EXTLINUX_CONF_NAME}"
	fi

	# Hard-link boot script if available
	if [ -n "${UBOOT_BOOTSCRIPT}" ]; then
		orig="$(readlink -e ${DEPLOY_DIR_IMAGE}/${UBOOT_BOOTSCRIPT})"
		ln "${orig}" "${TMP_BOOTDIR}/${UBOOT_BOOTSCRIPT}"
	fi

	# Build UBIFS boot image out of temp folder
	mkfs.ubifs -r "${TMP_BOOTDIR}" -o "${IMGDEPLOYDIR}/${IMAGE_NAME}.boot.ubifs" ${MKUBIFS_BOOT_ARGS}

	# Remove the temporary folder
	rm -rf ${TMP_BOOTDIR}
}

# Remove the default ".rootfs." suffix for 'boot.ubifs' images
do_image_boot_ubifs[imgsuffix] = "."
