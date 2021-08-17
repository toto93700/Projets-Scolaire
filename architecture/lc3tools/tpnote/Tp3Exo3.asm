;louail karim 11806111
;et bensafia 11608196
	.ORIG x3000
	 LEA  R6,T1	 ;initialisation de valeurs pour test si le programe fonctionne
         ADD  R3,R3,4    ;/////////////////////////////////////////////////////////////
         STR  R3,R6,0    ;/////////////////////////////////////////////////////////////
	 LEA  R0,T1	 ; R0=adresse de T1
	 LEA  R1,T2	 ; R1=adresse de T2
	 LD   R5,Taille
	 ADD  R1,R1,R5   ; R5=Taille
	 ADD  R1,R1,-1	 ; R1=adresse de (T2)+taille-1
	 AND  R3,R3,0
	 AND  R5,R5,R5
	 BRp  loop       ; Si R5>=0 on loop
         RET

loop:	 LDR  R4,R0,0    ; R4=*R0
	 STR  R4,R1,0	 ; *R1=R4=*R0
	 ADD  R0,R0,1    ; incrementation du pointeur de T1
	 ADD  R1,R1,-1   ; décrementation du pointeur de T2
	 ADD  R5,R5,-1   ; décrementation de R5
	 BRzp loop       ; Tant que R5>=0 on loop




T1:	.BLKW 10
T2:	.BLKW 10
Taille: .fill 10
	.END
