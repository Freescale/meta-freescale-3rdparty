# adapted from linux-imx.inc, copyright (C) 2012-2013 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

include linux-wandboard.inc

# Wandboard branch
SRCREV = "86429847b5152f040f190015faedcac49b243328"
LOCALVERSION = "-wandboard+yocto"

SRC_URI += "file://0001-ENGR00251005-gpu-4.6.9p11-kernel-code-integration.patch"

COMPATIBLE_MACHINE = "(wandboard)"
