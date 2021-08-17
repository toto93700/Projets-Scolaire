	;exo1
;louail karim 11806111
;et bensafia 11608196
	.ORIG x3000
	 AND R5,R5,0	;R5=0
	 ADD R2,R0,0	;R2=R0
	 LD R1,X	;R1=X
	 ST R1,Y	;Y=R1
	 LEA R5,X	;R5=adresse De(X)
	 ST R5,Z	;Z=R5
	
X:.fill 5
Y:.fill 10
Z:.fill 20
        .END
