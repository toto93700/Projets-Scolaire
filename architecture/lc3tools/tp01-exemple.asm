	.ORIG x3000

	LD  R0,VAL1
  	NOT R1,R0
	ADD R1,R1,1
        ADD R2,R1,0
	ADD R3,R0,R1
	ADD R4,R0,R2
	HALT
VAL1:	.FILL 1
	.BLKW 3
VAL2:	.FILL -1
	.END
