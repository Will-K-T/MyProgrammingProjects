#include <bits/stdc++.h>

using namespace std;

int main(){
    long long max = INT32_MAX;
    long long min = INT32_MIN;
    // long long max = 20;
    // long long min = -21;

    long long start = 10, end = 5;
    long long clicks = 0;

    for(int i=1; i<10e9; ++i){
    end = i;
    start = end*2;
    clicks = 0;
    if(i % 2 != 0 || i % 16 != 0 || i % 32 != 0 || i % 64 != 0 || i % 128 != 0 || i % 256 != 0
        || i % 512 != 0 || i % 1024 != 0 || i % 2048 != 0 || i % 4096 != 0 || i % 8192 != 0 || i % 16384 != 0
            || i % 32764 != 0 || i % 65528 != 0) continue;
    while(start != end){
        clicks++;
        //cout << start << endl;
        start += end;
        if(start > max){
            start = min + (start - max)-1;
        }
    }

    cout << i << " " << clicks << endl;
    }

    return 0;
}