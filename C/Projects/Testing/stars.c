#include <stdio.h>

int funcb(int stars){
	if(stars==0){
		return 0;
	}
	printf("X");
	return funcb(stars-1);
}


int funca(int r, int d){
	if(d<0){
		return 0;
	}
	funcb(r-d);
	printf("\n");
	return funca(r, d-1);
}

int main(void){
	int num1 = 5;
	int num2 = 4;
	funca(num1, num2);
}
