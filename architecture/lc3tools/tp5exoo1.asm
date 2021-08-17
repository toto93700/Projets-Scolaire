
		.ORIG x3000	
		AND R1,R1,0
		ADD R1,R1,5
		JSR fonct
		OUT
		HALT

	

fonct:
		ADD R0,R1,0
test:		ADD R1,R1,0
		BRnz fin
		ADD R1,R1,-1
		ADD R0,R0,R1
		BR test


fin:		RET



.END
