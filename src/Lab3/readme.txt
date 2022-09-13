/**********************************************************************
 *  M�nsterigenk�nning readme.txt
 **********************************************************************/

 Ungef�rligt antal timmar spenderade p� labben (valfritt):

/**********************************************************************
 *  Empirisk    Fyll i tabellen nedan med riktiga k�rtider i sekunder
 *  analys      n�r det k�nns vettigt att v�nta p� hela ber�kningen.
 *              Ge uppskattningar av k�rtiden i �vriga fall.
 *
 **********************************************************************/
    
      N       brute       sortering
 ----------------------------------
    150       0.022         0.007
    200       0.036         0.011
    300       0.066         0.020
    400       0.092         0.030
    800       0.410         0.078
   1600       3.538         0.209
   3200       26.651        0.594
   6400       17562?        2.402
  12800                     10.243


/**********************************************************************
 *  Teoretisk   Ge ordo-uttryck f�r v�rstafallstiden f�r programmen som
 *  analys      en funktion av N. Ge en kort motivering.
 *
 **********************************************************************/

Brute: n^   För att det finns fyra nestlade for loopar

Sortering: (n^2)log(n) Det finns en stor loop som går igenom alla punkter
           en collection sort som har en tidskomplexitet på n log(n) vilket
           ger oss en kombinerad tidskomplexitet på n^2log(n). Vi behöver inte
           räkna på sort i den andra loopen då den endast sorterar fyra punkter
           varje gång.ss
