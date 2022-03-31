/*
ID: 21willd1
TASK: ride
LANG: C++
*/

#include <iostream>
#include <fstream>

using namespace std;

void doTheWhat(string comet, string group){
    int com = 1, gro = 1;
    for (int i = 0; i < comet.length(); ++i) {
        com *= (comet[i]-64);
    }
    for (int j = 0; j < group.length(); ++j) {
        gro *= (group[j]-64);
    }
    ofstream file("ride.out");
    string result = com%47 == gro%47?"GO":"STAY";
    file << result << endl;
    file.close();
    //return com%47 == gro%47?"GO":"STAY";
}

int main() {
    string comet;
    string group;
    ifstream file("ride.in");
    if(file.is_open()){
        file >> comet;
        file >> group;
        doTheWhat(comet, group);
        file.close();
    }
    else{
        cout << "I hate u";
    }
    return 0;
}
