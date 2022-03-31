#include<stdio.h>

int main(){
	char word[100];
	char resu[100];
	int len = 0;
	printf("Enter a word: ");
	scanf("%s", word);
	for(int c=0; word[c] != '\0'; c++){
		if(word[c]>='a' && word[c]<='z'){
			printf("%c", word[c]-32);
			resu[c] = word[c]-32;
		}
		else if(word[c]>='A' && word[c]<='Z'){
			printf("%c", word[c]+32);
			resu[c] = word[c]+32;
		}
		else{
			printf("%c", word[c]);
			resu[c] = word[c];
		}
		len++;
	}
	printf("\n");
	resu[len] = '\0';
	printf("\nResult: %s\n\nReverse: ", resu);
	for(int c=len; c>=0; c--){
		printf("%c", resu[c]);
	}
	printf("\n");
}
