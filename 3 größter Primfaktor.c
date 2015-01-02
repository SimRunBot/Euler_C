#include <stdio.h>
/*	Project Euler
	Problem 3
	hier mit double da zahl n die Grenzen von int überschreitet
	statt %,was nur auf int funktioniert, fmod() verwendet
*/

double prim_zerlegung_biggest(double n){
	double i;
	double res=0;
	
	
		
			for(i=2;i<=n;i++){
				if(fmod(n,i) == 0){
					
					if(i>res){res = i;}
					n = n/i;
					i = 2;
					
					}
				}
			
		
	return res;
}
int main() {
	
	double res1 ;
	
	res1 = prim_zerlegung_biggest(600851475143);
	
	
	printf("%f",res1);
	

return 0;
}
