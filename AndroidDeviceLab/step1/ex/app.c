#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>
#include<sys/ioctl.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <sys/mman.h>

#define GETVAL		10
#define GETSTART	20
#define GETSTOP		30
#define GETINTVAL	40
#define GETINTCOUNT	50
#define SETSTART	60
#define SETSTOP		70
#define SETINTVAL	80
#define CLRINTCOUNT	90
#define WAITFORINT	100

int main(int argc,char *argv[])
{
    int fd=open("/dev/myfpga",O_RDWR);
    int cmd=atoi(argv[1]);
    switch(cmd)
    {
	case 1: // get value
		break;
	case 2: // set start
		break;
	case 3: // set end
		break;
	case 4: // set int
		break;
        case 5:
		break;
    }
    return 0;
}
