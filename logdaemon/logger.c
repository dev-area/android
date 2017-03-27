#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

int main() {
    int fd=open("data1",O_RDWR|O_CREAT,0660);
    char buffer[100];
    struct sockaddr_in addr = {0};
    size_t addrlen, n;
    int sockfd = socket(AF_INET, SOCK_DGRAM, 0);

    addr.sin_family = AF_INET;
    addr.sin_port = htons(2000);
    addr.sin_addr.s_addr = INADDR_ANY;
    bind(sockfd, (struct sockaddr*)&addr, sizeof(addr));

    addrlen = sizeof(addr);
    while(1)
    {
        n = recvfrom(sockfd, (void*)buffer, 100, 0,
				(struct sockaddr*)&addr, (unsigned int *) &addrlen);
        buffer[n] = '\n';
        write(fd,buffer,n+1);
    }
	close(fd);
	return 0;
}
