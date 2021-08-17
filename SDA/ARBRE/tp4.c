#include <stdio.h>
#include <stdlib.h>



typedef struct st_node
{
int key;
struct st_node *left;
struct st_node *right;
}node;

node* build (int v,node*L,node* R) {
node *nw = (node*) malloc(sizeof(node));
nw->key = v;
nw->left = L;
nw->right = R;
return nw;
}


int search (int v,node*A) {

  if(A==NULL){
    return;
  }
  if(A->key==v){
    return 1;
  }
  if(A->key<v){
    search(v,A->right);
  }
  if(A->key>v){
    search(v,A->left);
  }
  return(0);

}


int max(int a,int b){
  if(a>=b){
    return a;
  }
  else{
    return b;
  }
}




 void impression( node *A){
   if(A==NULL)return;
   impression(A->left);
   printf("%d ", A->key );
   impression(A->right);
 }
int height(node *A){

  if(A==NULL){
    return;
  }
  return(max(height(A->left)+1,height(A->right)+1));
}

int number_node(node *A){

  if(A==NULL){
    return;
  }
  return(1+number_node(A->left)+number_node(A->right));



}


int minimum(node *A){
  int m;
  node *p=A;
  while(A->key!=NULL){
    m=A->key;
    p=A->left;
  }
  return(m);

}
int maximum(node *A){
  int m;
  node *p=A;
  while(A->key!=NULL){
    m=A->key;
    p=A->right;
  }
return(m);
}



void insert (int v, node** A) {

  //node *B=build(v,NULL,NULL);

  node *p=*A;
  node *pere;
  while((*A)->key!=NULL){
    pere=*A;
    if(v>(*A)->key){
      p=(*A)->right;
    }
    else{
      p=(*A)->left;
    }
  }
  *A=pere;

  if((*A)->key<v /*&& pere->right==NULL*/){
    (*A)->right=build(v,NULL,NULL);
  }
  if((*A)->key>v /*&& pere->left==NULL*/){
    (
      *A)->left=build(v,NULL,NULL);
  }

}







 int estSomme(node * A){

  if(A==NULL) return 0;


  estSomme(A->left);
estSomme(A->right);
  if((int)(A->left->key+ A->right->key)!=A->key){
    return -1;
  }

    return 1;
 }


















void main(int argc, char const *argv[]) {

 node *A=build(48,build(15,build(8,NULL,NULL),build(7,NULL,NULL)),build(9,NULL,build(9,NULL,NULL)));
printf("%d",estSomme(A));
printf("%d\n",search(16,A));

impression(A);

}
