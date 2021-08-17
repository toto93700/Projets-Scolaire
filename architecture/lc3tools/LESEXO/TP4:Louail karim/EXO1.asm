	
	;;EXO1 TP4 LOUAIL KARIM 11806111
	.ORIG x3000	
	AND R1,R1,0 ;R1=0
	LD  R2,E39  ;R2=E39=39
	ADD R3,R2,0 ;r3=r2
	LD  R4,X   ;r4=x
	LEA R5,Y   ;R5=&Y
	ST  R5,Z   ;Z=R5
	IN         ;lit un  carac et le place dans R0
	ADD R5,R5,1;incremente R5 qui est notre pointeur sur le "tableau"
	STR R0,R5,0 ;PLACE La valeur de R0 dans la dresse contenue dans R5
	ADD R0,R2,0
	OUT 
	HALT
X:.fill 100
Y: .BLKW 2
Z:.fill 0
E39:.fill 39
	.END





















		
