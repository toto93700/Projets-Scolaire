	
;; LOUAIL KARIM 11806111
	.ORIG x3000
	;;charge nos valeur 
	LD R0,n 
	LD R1,k
	AND R3,R3,0;initiliase le registe 3 a 0
	ADD R1,R1,0
	BRn fini  ;test si k<0 jump a fini
	NOT R1,R1
	ADD R1,R1,1    ;R1=-R1 afin de pouvoir faire nos operation plus tard

	AND R2,R2,0 ; compteur final

	
	

;loop est notre iterateur 
loop:	ADD R3,R0,R1  ;R3=N-K
	ADD R2,R2,R3  ;R2=R2+R3
	ADD R1,R1,1   ;incremnte notre k de 1
	BRp fini ;SI r1>0 on fini
	BRnzp loop ; tant que R1<=0 on loop 





fini: HALT




n:.fill 10
k:.fill 5
	.end
