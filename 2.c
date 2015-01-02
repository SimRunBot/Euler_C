#include <stdio.h>
/*	Project Euler
	Problem 2
*/

int fibo(int n){
	if(n==0){return 0;}
	else if(n==1){return 1;}
	else{ return (fibo(n-1)+fibo(n-2));}
}
int main() {
	int i= 0;
	int res;
	
	while(fibo(i)<4000000){
		if(fibo(i)%2==0){res+=fibo(i);}
		i+=1;
	}
	
	
	printf("%i",res);
	

return 0;
}
