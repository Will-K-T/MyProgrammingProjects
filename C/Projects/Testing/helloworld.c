#include <stdio.h>

int max(int one, int two){
	return (one > two) ? one : two;
}

int main(void){
	int x=3, y=5, z=10;
	printf("%d\n\n", max(x, max(y, z)));
	printf("%d", 0&&10);
}
