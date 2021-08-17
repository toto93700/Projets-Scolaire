#include <stdlib.h>
#include <stdio.h>
#include <memory.h> 
#include <unistd.h>
#include <sys/wait.h>
// louail karim 11806111
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>




void main(){
printf("0 1 2 3 4 5 6 7 8 9 \n");

pid_t p1,p2;

 p1 = fork();
if (p1 == -1)
perror("fils non crée!\n");
if (p1 == 0) {
sleep(1);
printf("10 11 12 13 14 15 19 \n");

exit(EXIT_SUCCESS);
}
sleep(1);
p2=fork();
if (p2 == -1)
perror("fils non crée!\n");
if (p2 == 0) {
sleep(1);
printf("20 21 22 23 24 25 26 27 28 29 \n");

exit(EXIT_SUCCESS);
}
sleep(2);
printf("30 31 32 33 34 35 36 37 38 39 \n");




}
