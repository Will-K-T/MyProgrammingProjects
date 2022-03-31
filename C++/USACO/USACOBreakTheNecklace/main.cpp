/*
ID: 21willd1
TASK: beads
LANG: C++
*/

#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

void findSplitPoint(vector<int> redChain, vector<int> blueChain){
    int longestChain = -1;
    int tempLen = 0;
    for (int i = 0; i < redChain.size(); ++i) {
        tempLen = redChain.at(i)+blueChain.at((i+redChain.at(i))%redChain.size());
        if(tempLen>longestChain && tempLen<=redChain.size()){
            longestChain = tempLen;
        }
    }
    for (int i = 0; i < blueChain.size(); ++i) {
        tempLen = blueChain.at(i)+redChain.at((i+blueChain.at(i))%blueChain.size());
        if(tempLen>longestChain && tempLen<=blueChain.size()){
            longestChain = tempLen;
        }
    }
    ofstream output("beads.out");
    output << longestChain << endl;
    output.close();
}

void doTheWhat(vector<char> necklace){
    vector<int> redChain; //redChain.reserve(numOfBeads);
    vector<int> blueChain; //blueChain.reserve(numOfBeads);
    int count;
    for (int i = 0; i < necklace.size(); ++i) {
        int stop = i;
        char bead = necklace.at(i);
        if(bead == 'r') {
            blueChain.push_back(0);
            count = 1;
            for (int j = i + 1; true; ++j) {
                if (j < necklace.size()) {
                    if (necklace.at(j) == 'r' || necklace.at(j) == 'w') {
                        count++;
                    } else {
                        redChain.push_back(count);
                        break;
                    }
                }
                else{
                    if(j%necklace.size()==stop){
                        redChain.push_back(count);
                        break;
                    }
                    if (necklace.at(j%necklace.size()) == 'r' || necklace.at(j%necklace.size()) == 'w') {
                        count++;
                    } else {
                        redChain.push_back(count);
                        break;
                    }
                }
            }
        }
        if(bead == 'b'){
            redChain.push_back(0);
            count = 1;
            for (int j = i + 1; true; ++j) {
                if (j < necklace.size()) {
                    if (necklace.at(j) == 'b' || necklace.at(j) == 'w') {
                        count++;
                    } else {
                        blueChain.push_back(count);
                        break;
                    }
                }
                else{
                    if(j%necklace.size()==stop){
                        blueChain.push_back(count);
                        break;
                    }
                    if (necklace.at(j%necklace.size()) == 'b' || necklace.at(j%necklace.size()) == 'w') {
                        count++;
                    } else {
                        blueChain.push_back(count);
                        break;
                    }
                }
            }
        }
        if(bead == 'w'){
            bool blue = false;
            bool red = false;
            count = 1;
            for (int j = i + 1; true; ++j) {
                if (j < necklace.size()) {
                    if(blue && necklace.at(j) == 'r'){
                        blueChain.push_back(count);
                        redChain.push_back(0);
                        break;
                    }
                    if(red && necklace.at(j) == 'b'){
                        redChain.push_back(count);
                        blueChain.push_back(0);
                        break;
                    }
                    if (necklace.at(j) == 'w' && (!blue && !red)) {
                        count++;
                    }
                    if(necklace.at(j) == 'r'){
                        red = true;
                    }
                    if(necklace.at(j) == 'b'){
                        blue = true;
                    }
                    if(blue && (necklace.at(j) == 'w' || necklace.at(j) == 'b')){
                        count++;
                    }
                    if(red && (necklace.at(j) == 'w' || necklace.at(j) == 'r')){
                        count++;
                    }
                }
                else{
                    if(j%necklace.size()==stop){
                        redChain.push_back(count);
                        blueChain.push_back(0);
                        break;
                    }
                    if(blue && necklace.at(j%necklace.size()) == 'r'){
                        blueChain.push_back(count);
                        redChain.push_back(0);
                        break;
                    }
                    if(red && necklace.at(j%necklace.size()) == 'b'){
                        redChain.push_back(count);
                        blueChain.push_back(0);
                        break;
                    }
                    if (necklace.at(j%necklace.size()) == 'w' && (!blue && !red)) {
                        count++;
                    }
                    if(necklace.at(j%necklace.size()) == 'r'){
                        red = true;
                    }
                    if(necklace.at(j%necklace.size()) == 'b'){
                        blue = true;
                    }
                    if(blue && (necklace.at(j%necklace.size()) == 'w' || necklace.at(j%necklace.size()) == 'b')){
                        count++;
                    }
                    if(red && (necklace.at(j%necklace.size()) == 'w' || necklace.at(j%necklace.size()) == 'r')){
                        count++;
                    }
                }
            }
        }
    }
    for (int k = 0; k < necklace.size(); ++k) {
        cout << redChain.at(k) << "\t" << blueChain.at(k) << necklace.at(k) << endl;
    }
    findSplitPoint(redChain, blueChain);
}

int main() {
    ifstream input("beads.in");
    int numOfBeads; input >> numOfBeads;
    string inputLine; input >> inputLine;
    vector<char> beads; beads.reserve(numOfBeads);
    for (int i = 0; i < numOfBeads; ++i) {
        beads.push_back(inputLine[i]);
    }
    input.close();
    doTheWhat(beads);
    return 0;
}