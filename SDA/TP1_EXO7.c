

#include <stdio.h>


 #include <stdlib.h>





 typedef struct  code_Barre 
  {

   int taille;
   int *code;

  }codeBarre;


codeBarre *genereCodeBarre(int t){
  int i;
  codeBarre *cb = malloc(sizeof(codeBarre));
  cb->taille=t;
  cb->code=malloc(sizeof(int)*cb->taille);

   for(i=0;i<t-1;i++){
    cb->code=rand()%5+1;
    printf("code %d = %d \n",i,cb->code);
    cb->code++;
    
   }
   return(cb);
}
detruitCodeBarre(codeBarre t) {
free(t);

}
void main(){





  
free(genereCodeBarre(13));
    
}



