; program1.tm
;
; Accepts strings with an even number of 1's
;
; Language alphabet: S={0,1}
;
; Author: Pedro Bucho
;
; Changelog:
; |
; + 2016-03-04: First release
;

IS: q0

q0 _ _ R Accept
q0 0 0 R q0
q0 1 1 R q1

q1 _ _ R Reject
q1 0 0 R q1
q1 1 1 R q0
