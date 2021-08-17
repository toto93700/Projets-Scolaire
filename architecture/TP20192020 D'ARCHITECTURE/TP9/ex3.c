#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
 //louail karim 11806111  
//imcomplet


void main(int arg, char *argv[]){
int fd;
int fdp[2]; // p->f
int fdp2[2]; //f->p
char buf[100];
int n;
pid_t F;
pipe(fdp);
pipe(fdp2);
//fd=open(argv[1],O_RDONLY);

//printf("%c",i);
//read(fd,(char) i,sizeof(int));

while(buf[n]!='0'){
printf("nombre a entré ?  \n");
scanf("%c",buf[n]);
n++;
}
close(fdp[0]);
write(fdp[1],buf,5);

if (F=fork()==-1) {
 printf("erreur de creation du filston");
 exit(EXIT_FAILURE);

}
if (F==0){
 char monbuf[5];
 read(fdp[0],buf,5);
  printf("%s",monbuf);
}
//close(fdp[0]); //fermeture sortie 
//dup2(fdp[1],0); // switch entré standar vers entré du pipe


//code pere 





}
