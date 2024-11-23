#include <bits/stdc++.h>

using namespace std;

int main(){
    int n, e, d;
    cin >> n >> e >> d;

    vector<int> p(n);

    for(int i=0; i<n; ++i){
        cin >> p[i];
    }

    int currIdx = 0;
    int origP = e;
    long long count = 0;
    int prevD = d;
    bool sameDay = true;
    while(d > 0){
        e -= p[currIdx];
        ++count;
        cout << "bruh: " << e << " " << count << " " << currIdx << endl;
        if(e < 0){--count; --currIdx;}
        if(e <= 0){
            sameDay = false;
            --d;
            prevD = d;
            e = origP;
        }else if(currIdx == p.size()-1 && sameDay){
            cout << d * p.size() << endl;
            return 0;
        }
        ++currIdx %= p.size();
    }

    cout << count << endl;

    return 0;
}