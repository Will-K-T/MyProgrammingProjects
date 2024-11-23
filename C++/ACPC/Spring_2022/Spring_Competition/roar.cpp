#include <bits/stdc++.h>
#include <regex>
using namespace std;

int main(){
    string in;
    cin >> in;
    if(regex_match(in, regex("ro+ar"))){
        cout << "YES" << endl;
    }else{
        cout << "NO" << endl;
    }
    return 0;
}