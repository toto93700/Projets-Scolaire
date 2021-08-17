;louail karim 11806111
;et bensafia 11608196
;@param  R0 valeur de X

	.ORIG x3000
	 LD  R0,X 	 ; charge la valeur de x dans R0
	 ADD R0,R0,0	 
	 BRn suite	 ; test si R0<0 saute a suite 
         ST R0,Y	 ; Y=R0
	 RET
suite:	 NOT R0,R0	 
	 ADD R0,R0,1 	 ; R0=-R0
	 ST  R0,Y	 ; Y=R0
	 RET
X:.fill -5
Y:.fill  0
	 .END
