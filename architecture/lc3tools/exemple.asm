	.ORIG x3000
	LD      R0, VAL1
	ADD     R0, R0, R0
	LD      R7, VAL2
	ADD     R7, R7, R7
	ADD     R2, R0, R7
	HALT
VAL1:	.FILL 1
	.BLKW 3
VAL2:	.FILL -1
	.END
