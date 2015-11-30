require linux-cfa.inc

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=${SRCBRANCH} \
           file://defconfig"

SRCBRANCH = "linux-4.1.y"
SRCREV = "v4.1.13"

COMPATIBLE_MACHINE = "cfa10036"
