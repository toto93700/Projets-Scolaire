	
 ;louail karim 11806111

	.ORIG x3000
	
	LD  R0,valchercher
	NOT R0,R0
	ADD R0,R0,1 ;ça nous servirera plus tard afin de tester si on match r0 et le pointeur *tab 							

	AND R5,R5,0  ;compteur d'occurence

	;CHarge notre taille du tab dans R1 & l'adresse du tableau Dans R2
	LD  R1,taille
	LEA R2,tab
	;notre loop charge dans r3 la valeur pointer par r2 qui est notre pointeur sur notre tableau
loop:	LDR R3,R2,0
	ADD R3,R3,R0
	BRz match 	; si loperation juste avant = 0 alors la valeur pointer par notre pointeur=R0
	ADD R1,R1,-1
	ADD R2,R2,1	;incremente notre pointeur et decremente notre compteur de taille 
	BRnzp loop	;JUMP a loop 


; MATCH incremente notre pointeur et decrementt le nombre delement a  parcourir dans le tableau
match:	ADD R5,R5,1
	ADD R1,R1,-1
	BRZ FINI

	ADD R2,R2,1
	BRnzp loop


	FINI: HALT	
	





tab:	.BLKW 10
taille: .fill 10
valchercher: .fill 0
	.END
