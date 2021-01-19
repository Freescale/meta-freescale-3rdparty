# Booting OE Linux on the reMarkable2

The [reMarkable2](https://remarkable.com/) is an e-ink reader using the iMX7
SoC.

This layer adds support for building the official kernel source and u-boot
source for the rM2.

In order to build the images for the rM2 setup this layer and all dependencies
and then run:

```shell
MACHINE = "imx7d-remarkable2" bitbake core-image-minimal -k
```

### Booting the images

All of the steps here and in this repo aim for a temporary boot on the rM2.
That is nothing should make any lasting changes to your rM2 and a simple
reboot should restore any changes. That said, this could still break things,
be careful.

To boot the images you first need to enter recovery mode.

There are steps for doing that available here:
https://github.com/ddvk/remarkable2-recovery

In short you need to put a ~10K resistor between pin B8 and B12 on the USB-C
breakout. You also want to connect the pogo pins to a USB break out board.
As well as that you need to connect a FDTI UART receiver to the IN pin on the
pogo pins.

Then power up the device. At which point you should see somthing like
`hiddev0,hidraw5: USB HID v1.10 Device [Freescale SemiConductor Inc  SE Blank ULT1] on usb-0000:00:14.0-9/input0`
in dmeag.

Then you have to unplug the resistor and you can use
[imx_usb](https://github.com/boundarydevices/imx_usb_loader)
to download the images. Note that uuu should also work, but I haven't yet
figured out how to load the images (not flash them)

Then add the following lines to the `mx7_usb_work.conf` file in imx_usb_loader, under `hid,1024,0x910000,0x80000000,1G,0x00900000,0x20000`

```shell
build/tmp/deploy/images/imx7d-remarkable2/zImage:load 0x80800000
build/tmp/deploy/images/imx7d-remarkable2/zero-sugar.dtb:load 0x83000000
build/tmp/deploy/images/imx7d-remarkable2/core-image-minimal-imx7d-remarkable2.ext4.gz.u-boot:load 0x83800000
build/tmp/deploy/images/imx7d-remarkable2/u-boot-dtb.imx:clear_dcd,plug,jump header
```

You can then run `sudo ./imx_usb`

You should see u-boot and Linux automatically boot on the rM2.
