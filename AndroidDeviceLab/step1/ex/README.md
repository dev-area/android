Steps:

1. Complete the fpga driver - implement the mmap callback and complete the init function
2. Add the file to the kernel source:

    ~/kernel3.4/goldfish/drivers/mfd

3. Update the KConfig, Makefile to include the driver
4. Build the kernel:

      $ cd ~/kernel3.4/goldfish

      $ make

5. Test your work:

      $ cd ~/aosp

      $ source build/envsetup.sh

      $ lunch 1

      $ emulator -kernel ~/kernel3.4/goldfish/arch/arm/boot/zImage

6. Add a test app to android image (~/aosp/device/gereric/goldfish) 
