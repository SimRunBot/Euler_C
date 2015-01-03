int main() {
	int i, sum1, sum2, res;
	for(i=1;i<=100;i++){
		sum1+= i*i;
		sum2 += i;
	}
	
	sum2 *= sum2;
	res = sum2 - sum1;
	printf("%i",res);
	
return 0;
}            
