;louail karim 11806111
;et bensafia 11608196
;@param R0,R1,R2
	.ORIG x3000
	

	 JSR inverser 

inverser: 
	 ADD  R2,R2,R0
	 ADD  R2,R2,-1	 ; R2=adresse de (T2)+taille-1
	 AND  R0,R0,R0
	 BRp  loop       ; Si R0>=0 on loop
         RET

loop:	 LDR  R4,R1,0    ; R4=*R1
	 STR  R4,R2,0	 ; *R2=R4=*R1
	 ADD  R1,R1,1    ; incrementation du pointeur de T1
	 ADD  R2,R2,-1   ; décrementation du pointeur de T2
	 ADD  R0,R0,-1   ; décrementation de R0
	 BRzp loop       ; Tant que R0>=0 on loop

fin : RET 

	.END
