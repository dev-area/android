#include <linux/module.h>
#include <linux/kernel.h>
#include <linux/moduleparam.h>
#include <asm/uaccess.h>
#include <linux/fs.h>
#include <linux/ion.h>
#include <linux/gfp.h>
#include <linux/cdev.h>
#include <linux/sched.h>
#include <linux/kdev_t.h>
#include <linux/proc_fs.h>
#include <linux/ioctl.h>
#include <linux/slab.h>
#include <linux/mempool.h>
#include <linux/mm.h>
#include <asm/io.h>
#include <linux/device.h>
#include <linux/interrupt.h>

#define PHY_IO_ADD 0xff007000
#define PHY_MAP_ADD 0xff008000
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


DECLARE_WAIT_QUEUE_HEAD(hq);
static int flag=0;

static int acme_count = 1;
static dev_t acme_dev;
static int *dev_id;
static struct cdev *acme_cdev;
static int int_counter = 0;

static int *regs;
struct ion_client *client;

static int device_ioctl(struct file*file,unsigned int num,
        unsigned long param)
{
    unsigned int r;
    int (*fptr)(int);
    int fr;
    switch(num)
    {
        case GETVAL:
		 return regs[0];
        case GETSTART:
                return regs[1];
        case GETSTOP:
		return regs[2];
	case GETINTVAL:
		return regs[3];
	case GETINTCOUNT:
		return regs[4];
	case SETSTART:
		regs[1] = param;
                break;
	case SETSTOP:
		regs[2] = param;
                break;
	case SETINTVAL:
		regs[3] = param;
                break;
	case CLRINTCOUNT:
		regs[5] = 1;
		break;
	case WAITFORINT:
		wait_event(hq,flag);
		flag=0;
		break;
    }
    return 0;
}

static int device_mmap(struct file *file,struct vm_area_struct* vma)
{
    int size;
    size=vma->vm_end - vma->vm_start;
    if(remap_pfn_range(vma,vma->vm_start,PHY_MAP_ADD>>PAGE_SHIFT,size,vma->vm_page_prot))
        return -EAGAIN;
    return 0;
}

static struct file_operations acme_fops =
{
    .owner = THIS_MODULE,
    .unlocked_ioctl = device_ioctl,
    .mmap = device_mmap
};


static irqreturn_t *irq_handle(void * dev_id)
{

    printk(KERN_DEBUG "fpga Interrupt\n");
    regs[4]=1;
    flag = 1;
    wake_up(&hq);
    return 0;
}


static int
hello_init (void)
{
    int req_irq = request_irq(6, irq_handle, 0, "myfpga", &dev_id);
    regs = ioremap(PHY_IO_ADD,0x1000);

    
    acme_dev = MKDEV(237,0);
    register_chrdev_region(acme_dev,1,"myfpga");

    device_create(class_create(THIS_MODULE,"myclass"),NULL,acme_dev,NULL,"myfpga");
    acme_cdev=cdev_alloc();
    if(!acme_cdev)
    {
        printk (KERN_INFO "cdev alloc error.\n");
         return -1;
    }
    acme_cdev->ops = &acme_fops;
    acme_cdev->owner = THIS_MODULE;

    if(cdev_add(acme_cdev,acme_dev,acme_count))
    {
        printk (KERN_INFO "cdev add error.\n");
         return -1;
    }

  return 0;

}

static void
hello_cleanup (void)
{
    cdev_del(acme_cdev);
    unregister_chrdev_region(acme_dev, acme_count);
}

late_initcall(hello_init);
module_exit (hello_cleanup);
MODULE_LICENSE("GPL");
