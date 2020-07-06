/*
ID: 21willd1
TASK: gift1
LANG: C++
*/

#include <iostream>
#include <fstream>
#include <vector>
#include <string>

using namespace std;

vector<string> names;
vector<int> bal;
vector<string> rec;

void doTheWhat(string giver, int amt, int nPpl, vector<string> ppl){
    int individualAmt = amt/nPpl;
    int giverAmt = amt%nPpl;
    for (int i = 0; i < names.size(); ++i) {
        if(names.at(i)==giver){
            bal.at(i) -= amt;
            bal.at(i) += giverAmt;
        }
        for (int j = 0; j < ppl.size(); ++j) {
            if(names.at(i)==ppl.at(j)){
                bal.at(i) += individualAmt;
            }
        }
    }
}

int main() {
    int numberOfNames;
    ifstream file("gift1.in");
    if(file.is_open()){
        file >> numberOfNames;
        string temp;
        names.clear();
        bal.clear();
        for (int i = 0; i < numberOfNames; ++i){
            file >> temp;
            names.push_back(temp);
            bal.push_back(0);
        }
        while(!file.eof()){
            int amt;
            string giver;
            int ppl;
            file >> giver;
            file >> amt;
            file >> ppl;
            rec.clear();
            if(ppl>0) {
                for (int i = 0; i < ppl; ++i) {
                    string name;
                    file >> name;
                    rec.push_back(name);
                }
                doTheWhat(giver, amt, ppl, rec);
            }
        }
        file.close();
        ofstream output("gift1.out");
        for (int j = 0; j < names.size(); ++j) {
            output << names.at(j) << " " << bal.at(j) << endl;
        }
        output.close();
    }
    else{
        cout << "oh no";
    }
    return 0;
}
