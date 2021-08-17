	.ORIG X3000
	AND R0,R0,0	
	IN	
	NOT R1,R0
	ADD R1,R1,1     ;R1=-R0
	LD R4,a
	LD R5,AA
	LD R6,z
	ADD R2,R0,R4
	BRPZ suite 

suite0:	LD R3,a
	NOT R3,R3
	ADD R3,R3,1	
	ADD R0,R0,R4
	ADD R0,R0,R5
	OUT
	HALT
	
suite:	
	ADD R2,R1,R6
	BRNP  suite2
	BR suite0
	
suite2:	
	OUT
	HALT
	

a: .fill 94
z: .fill 118
AA: .fill 61
ZZ: .fill 86

	.END

