
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

void main(int arg, char *argv[]){


//mode_t mode = S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH;


int fd,x;
int *b;

char buf[128];
fd=creat("test",0660);
fd=open("test",O_RDWR,S_IRWXU);

while(x<=5){
printf("quelle nbr ajouté Au fichier?\n");
scanf("%d",&b);


write(fd, (char)b, sizeof(char));

printf("le fichier contien : \n");
read(fd,buf,127);
 printf("%s",buf);
x++;
printf("///////////////////////////////\n");
}
}
