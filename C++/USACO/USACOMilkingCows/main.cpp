#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

int main(){
	ifstream input("milk2.in");
	int numOfLines;
	input >> numOfLines;
	int times[numOfLines][2];
	int time;
	for(int i=0; i<numOfLines; ++i){
		for(int j=0; j<2; ++j){
			input >> time;
			times[i][j] = time;
		}
	}
	for(int i=0; i<numOfLines; ++i){
		cout << times[i][0] << " " << times[i][1] << "\n";
	}
	return 0;
}
