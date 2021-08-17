

#include <stdlib.h>
#include <stdio.h>
#include <memory.h> 
#include <unistd.h>
#include <sys/wait.h>

#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>




int main(int argc, char*argv[]) {
int w;
pid_t F= fork();
if(F!=0){
printf("padre mon pid = %d  \n jai un fiston son pid est %d \n",getpid(),F);
w=wait(NULL);
}
  if(F==0){
printf(" fils mon pid est  %d  mon pere est %d \n",getpid(),getppid());
  pid_t PF1,PF2;
 PF1=fork();
if(PF1==0){
printf(" c pf1 mon pid est = %d  mon padre est %d %d \n",getpid(),getppid());
exit(0);
}
if(F==0){
 PF2=fork();
if(PF2==0){
printf(" c pf2 mon pid est = %d  mon padre est %d %d \n",getpid(),getppid());
exit(0);
}
if(F==0){
printf(" FILS jai cree deux fils  pf1=%d et pf2=%d \n",PF1,PF2);
exit(0);
}
}

}
}
