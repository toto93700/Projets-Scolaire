#include <stdlib.h>
#include <stdio.h>
#include <memory.h> 
#include <unistd.h>
#include <sys/wait.h>

#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

void main(int arg, char *argv[]){
pid_t f1;

if((f1=fork()==-1)){
///////
perror("erreur");
exit(1);
}




else if (f1==0){
 int fd = open(argv[1],O_WRONLY); //ouverture du fichieer en ecriture seulment
//if(fd==-1){
//perror("erreur");
//exit(1);
//}


 dup2(fd,1);
 execl("/bin/ls","ls",NULL);
 
}
else{

wait(NULL);
int size;
char buf[150];
int fd;

  fd = open(argv[1],O_RDONLY);  //LECTURE  seulement DU FICHIER OUVERT
  
  size=read(fd,buf,149);
   
  write(1,buf, size);  

  
  close(fd);
  }
}

