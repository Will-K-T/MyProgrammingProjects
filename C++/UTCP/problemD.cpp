#include <iostream>
#include <string>
using namespace std;

int monthToNum(string m);

int main ()
{
  int num;
  int yr = 1928;
  int mon = 7;
  int d = 7;
  float score = -1.0;
  string name;
  string empty;
  cin >> num;
  getline(cin, empty);
  name = "Sliced Bread";
  for(int i=0; i<num; i++){
	string newName;
	getline(cin, newName);
	string date;
	getline(cin, date);
	string month = date.substr(0, 3);
	int comma = date.find(",");
	int numLen = comma-4;
	int day = stoi(date.substr(4, numLen));
	int yrInx;
	if(numLen == 2){
		yrInx = 8;
	}else{
		yrInx = 7;
	}
	int year = stoi(date.substr(yrInx, 4));
	float val;
	cin >> val;
	if(year > yr && val > score){
		name = newName;
		score = val;
	}else if(year == yr && monthToNum(month) > mon && val > score){
		name = newName;
		score = val;
	}else if(year == yr && monthToNum(month) == mon && day > d && val > score){
		name = newName;
		score = val;
	}
	getline(cin, empty);
  }
  cout << name << "\n";
  return 0;
 }


int monthToNum(string m){
	if(m == "Jan"){
		return 1;
	}
	if(m == "Feb"){
		return 2;
	}
	if(m == "Mar"){
		return 3;
	}
	if(m == "Apr"){
		return 4;
	}
	if(m == "May"){
		return 5;
	}
	if(m == "Jun"){
		return 6;
	}
	if(m == "Jul"){
		return 7;
	}
	if(m == "Aug"){
		return 8;
	}
	if(m == "Sep"){
		return 9;
	}
	if(m == "Oct"){
		return 10;
	}
	if(m == "Nov"){
		return 11;
	}
	if(m == "Dec"){
		return 12;
	}
}
