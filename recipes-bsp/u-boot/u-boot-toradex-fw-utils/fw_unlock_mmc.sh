# Give fw_setenv mmcblk0boot0 write permissions
fw_setenv() {
    echo 0 > /sys/block/mmcblk0boot0/force_ro
    /sbin/fw_setenv "$@"
    echo 1 > /sys/block/mmcblk0boot0/force_ro
}
