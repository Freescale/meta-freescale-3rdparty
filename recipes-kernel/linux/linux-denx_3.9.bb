# Copyright (C) 2013 Marek Vasut <marex@denx.de>
# Released under the MIT license (see COPYING.MIT for the terms)

include linux-denx.inc

# m53evk
SRCREV_m53evk = "7c75b82904fa555ce7988b97619b85a436a8ed12"
SRC_URI_append_m53evk = "file://defconfig "

COMPATIBLE_MACHINE = "(mx5)"
