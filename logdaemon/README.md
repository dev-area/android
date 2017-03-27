1. Create a stand alone service
  * Add a new directory in ~/aosp/external
  * Create a makefile – Android.mk (copy from netcat and make changes)
  * Add the c source



2. Compile the rom, run the emulator and start the service using adb:
  * cd ~/aosp
  * source build/envsetup.sh
  * lunch 1
  * make
  * emulator &
  * adb shell
  * cd data
  * applog &



3. Create android application to use it
  * create a simple activity with one button
  * implement click event:
  * create and start a thread to run the java code snippet
  * add internet permissions to the project
  * run the application on the custom device
