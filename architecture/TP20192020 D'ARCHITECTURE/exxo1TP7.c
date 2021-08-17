

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

void main(int arg, char *argv[]){


int size;
char buf[128];
int fd;
int x=1;


while(argv[x]!=NULL){
  fd = open(argv[x],O_RDWR,S_IRWXU);
  size=read(fd,buf,127);
  printf("%s",buf);
  close(fd);
  x++;
}

}



