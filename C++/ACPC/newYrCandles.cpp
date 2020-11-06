#include <iostream>

using namespace std;

int main(){
	int a, b;
	cin >> a >> b;
	long hrs = a;
	int extra = 0;
	while(a >= b){
		if(b <= 0){
			break;
		}
		hrs += a/b;
		extra += a>b? a%b : 0;
		//cout << extra;
		a /= b;
	}
	hrs += extra;
	cout << hrs << "\n";
}
