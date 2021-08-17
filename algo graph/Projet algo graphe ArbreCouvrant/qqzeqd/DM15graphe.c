#include "graph_mat-2.h"
#include "graph_mat-2.c"
#include "liste.h"


#include <stdlib.h>
#include <stdio.h>


struct m_astruct{
	graph_mat *mongraph;
	graph_mat *mongraph2;
	liste *l1;
	liste *l2;
};
typedef struct m_astruct mastruct;


mastruct *ini_struct(int n){

	mastruct *mb=malloc(sizeof(mastruct));


	mb->mongraph=gm_init(n);
	mb->mongraph2=gm_init(n);
	mb->l1=liste_construire(n);
	mb->l2=liste_construire(n);
return mb;

}

// cree une struct avec un graphe sur lequel on va travailler
mastruct *ini2_struct(int n ,graph_mat* g){


	mastruct *mb=malloc(sizeof(mastruct));


	mb->mongraph=g;
	mb->mongraph2=gm_init(g->n);
	mb->l1=liste_construire(g->n);
	mb->l2=liste_construire(g->n);
return mb;

}


//cette fonction prend en argument une struct de type mastruct correctement initialise il faut que l1 l2 sois vide et mastruct->mongraph contienne le graphe a exploré pour cela
// utiliser la fonction ini2_struct !
// la fonction renvois une struct de type mastruct utilisé pour lexo 1-3  !!!!!!
mastruct *parcoursProfondeur(graph_mat *graph){
int w=0;
int boul=1;

graph_mat *a=gm_init(graph->n);

liste * mylist=liste_construire(graph->n);


liste * mylist2=liste_construire(graph->n);

liste *mylist3=liste_construire(graph->n);
//bloc0-------------------------------------------------------------------------------------------------------------------------------------------------

liste_ajouter_debut(mylist,0);       // temps o=1
liste_ajouter_debut(mylist3,0);     // temps o=1
					// o(bloc0)=2
//bloc0-------------------------------------------------------------------------------------------------------------------------------------------------




        while(liste_est_vide(mylist)==0){

            int k=*(liste_get_fin(mylist));	// temps o=1
//bloc1-------------------------------------------------------------------------------------------------------------------------------------------------
             for(w=0; w<(graph->n);w++){

               if(liste_contient_element(mylist,w)==0 && liste_contient_element(mylist2,w)==0){              //// temps  2*temps(liste_contient_element)= 2*o(1) = 2

                if((int)gm_mult_edge(graph,k,w)>0){						// temps constant o(1) operation pour obtenir l'informations detre lié ou non a une arrete


                    liste_ajouter_fin(mylist,w);           // o(1)

                    liste_ajouter_fin(mylist3,w);         // o(1)


                    a->adj[k*a->n+w]=1;                  //o(1)
                    a->m++;															//o(1)



                    w=100;															//o(1)

                }
               }

              }

																		//finalement pour ce bloc1 : o(bloc1)= 8n
//bloc1fin-------------------------------------------------------------------------------------------------------------------------------------------------
//bloc2-------------------------------------------------------------------------------------------------------------------------------------------------
              k=*liste_get_fin(mylist);								//o(1)


              boul=1;									//o(1)

//bloc2fin----------------------------------/finalement pour ce bloc2 : o(bloc2)= 2----------------------------------------------------------------------------------------------------------------




//bloc3-------------------------------------------------------------------------------------------------------------------------------------------------
							for(int l=0;l<(graph->n);l++){

                if(gm_mult_edge(graph,k,l)>0){      //o(1)


                  if(liste_contient_element(mylist,l)==0 && liste_contient_element(mylist2,l)==0){        //o(2)

                      boul=0;																															//o(1)
                      break;
                 }
                }
              }
              if(boul==1){													//o(1)


                liste_ajouter_fin(mylist2,k);					//o(1)
                int *c;
                c=malloc(sizeof(int));
                liste_supprimer_fin(mylist,c);						//o(1)
              }
            }
//bloc3fin--------------------------------finalement pour ce bloc3 : o(bloc3)= 7*n-----------------------------------------------------------------------------------------------------------------
						printf("affichage des info pour le parcours de manier itératife");
            // liste suffixe  (n) du cours
						printf("\n");
             liste_afficher(mylist2);
             printf("\n");
             //liste prefixe (m) du cours
             liste_afficher(mylist3);
             printf("\n");
             // foret orienté
						 printf("foret \n");
             gm_disp(a);

             mastruct *ma=malloc(sizeof(mastruct));
             ma->l1=mylist2;
             ma->l2=mylist3;
             ma->mongraph=a;

             return ma;


        }
//-------------------------------------------------------------------------------------------------------------------------------------------------



 //fonction qui affiche les info sur le graphe (prefixe suffixe et foret) // prend en argument une struct mastruct considere  mastruct->mongraph comme etant le graph surlequel on explore en profondeur !
		void 		exo3(mastruct *ma){
			printf("affichage des info pour le parcours de manier itératife");
			int k;
			printf("\n \n \n ");
			for(int i =0;i<ma->mongraph->n;i++) {

   	   int a=1;
				if(i==0) {
					 k=-1;
				}
				else {
					for(int h=0;h<ma->mongraph->n;h++){

					 if(ma->mongraph->adj[(i)*h+ma->mongraph->n]==1 ) {
						 k=i;
						 a=0;
					 }
					 if(ma->mongraph->adj[(i-1)*ma->mongraph->n+h]==1  && a==1){
							 k=h;	//|| )

							 a=0;
				 }
				}


				}

   		printf(" %d    %d    %d  %d \n",i,ma->l2->tab[i]+1,ma->l1->pos[i]+1,k);


			}

		}





			//necessite que masctruct sois defini, cette fonction prend en argument une struct correctmeent initilialisé et une racine sur laquelle on va commencer a iterer
		 void parcoursProfondeurrecursive(mastruct *g,int racine){
   //l1 == la liste des visité
	 //l2== la liste dexploration



			liste_ajouter_fin(g->l1, racine);

		for(int w=0;w<g->mongraph->n;w++){

 		if(gm_mult_edge(g->mongraph, racine, w)>0 && liste_contient_element(g->l1,w)==0 ){

												g->mongraph2->adj[racine*g->mongraph2->n+w]=1;
												g->mongraph2->m++;
			parcoursProfondeurrecursive(g,w);
		}
	}	liste_ajouter_fin(g->l2,racine);

	if(liste_est_pleine(g->l2)==1) {
		printf(" \naffichage des resultat de la focntion recursive");
					 liste_afficher(g->l2); printf("\n");
					 liste_afficher(g->l1);	printf("\n foret \n");
					 gm_disp(g->mongraph2); printf("\n");

					 ///////////////////////////////////////////////////////////////
					 int k;
					 printf("\n \n \n ");
					 for(int i =0;i<g->mongraph2->n;i++) {

							int a=1;
						 if(i==0) {
								k=-1;
						 }
						 else {
							 for(int h=0;h<g->mongraph2->n;h++){

								if(g->mongraph2->adj[(i)*h+g->mongraph2->n]==1 ) {
									k=i;
									a=0;
								}
								if(g->mongraph2->adj[(i-1)*g->mongraph2->n+h]==1  && a==1){
										k=h;	//|| )

										a=0;
							}
						 }


						 }

						 printf(" %d    %d    %d  %d \n",i,g->l1->pos[i]+1,g->l2->tab[i]+1,k);


					 }


	}

	 return;
}
