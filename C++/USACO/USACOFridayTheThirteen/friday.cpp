/*
ID: 21willd1
TASK: friday
LANG: C++
*/

#include <iostream>
#include <fstream>

using namespace std;

bool isLeap(int yr){
	if(yr % 100 == 0){
		if(yr % 400 == 0){
			return true;
		}
		else{
			return false;
		}
	}
	else if(yr % 4 == 0){
		return true;
	}
	return false;
}

void doTheWhat(int yrs){
	int currYr = 0, currDay = 6, oneYr = 12;
	bool leapYr = false;
	int monthDays[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	int monthDaysLeap[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	int dayCount[] = {0, 0, 0, 0, 0, 0, 0};
	if(yrs == 1){
		oneYr = 11;
	}
	dayCount[currDay]++;
	while(currYr < yrs){
		leapYr = isLeap(1900 + currYr);
		for(int i=0; i<oneYr; i++){
			if(!leapYr){
				dayCount[((monthDays[i]%7)+currDay)%7]++;
				currDay = ((monthDays[i]%7)+currDay)%7;
			}
			else{
				dayCount[((monthDaysLeap[i]%7)+currDay)%7]++;
				currDay = ((monthDaysLeap[i]%7)+currDay)%7;
			}
		}
		currYr++;
		if(currYr == yrs-1){
			oneYr--;
		}
	}
	ofstream output("friday.out");
	output << dayCount[6] << " ";
	for(int i=0; i<6; i++){
		if(i!=5){
			output << dayCount[i] << " ";
		}
		else{
			output << dayCount[i] << "\n";
		}
	}
}

int main(){
	ifstream input("friday.in");
	int numOfYears = 0;
	input >> numOfYears;
	doTheWhat(numOfYears);
	return 0;
}
