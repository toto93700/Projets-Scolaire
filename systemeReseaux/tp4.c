
#include <string.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/time.h>
#include <sys/resource.h>

void main(){
struct rlimit rlim;
rlim.rlim_cur=rlim.rlim_max=getpagesize();
setrlimit(RLIMIT_DATA,&rlim);
printf("%d\n",rlim.rlim_cur);

}
