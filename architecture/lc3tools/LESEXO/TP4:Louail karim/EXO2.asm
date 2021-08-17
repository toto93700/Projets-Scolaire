		;LOUAIL KARIM 11806111

		.ORIG x3000
		LD R1,Z
		ADD R1,R1,0
		BRzp opos  ;SI Z>=0 on fait le cas 1
		LD   R2,x  ;Sinn on fait el cas 2 dans lequel on double x
		ADD  R2,R2,R2
		BRnzp suite



;CAS 1: inititialise nos valeur et effectue les operation necessaire ainsi que les test afin de 
;savoir si x est >=0 ou non


opos:		LD   R2,x
		ADD  R2,R2,0
		BRzp suite
		NOT  R2,R2  ;cas x<0 on inverse x afin d'obtenir la val absolue 
		ADD  R2,R2,1
		BRnzp suite
	

	




;suite-> met R2 DANS Y

suite:		ST R2,y
		HALT









x:.fill 10
y:.fill 5
z:.fill -1
.END
