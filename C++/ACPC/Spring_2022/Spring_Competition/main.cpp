#include <iostream>
#include <string>
#include <sstream>
#include <unordered_map>
#include <vector>

using namespace std;

bool fnd(vector<int>& arr, int val){
    //cout << "Size: " << arr.size() << endl;
    for (int i= 0; i<arr.size(); ++i){
        if (arr[i] == val) return true;
    }return false;
}

int check(int a, int b, unordered_map<int, vector<int>> & map2){
    if (fnd(map2[a], b)||fnd(map2[b], a)){
        return 1;
    }return 0;
}

int main(){
    int x, y, n, m, k;
    cin >> n >> m >> k;
    cin >> x >> y;

    //unordered_map<int, int> map;
    vector<int> seats;
    int ran;
    for (int i = 0; i< n; ++i){
        cin>>ran;
        seats.push_back(ran); 
    }
    
    unordered_map<int, vector<int>> map2;
    int ans = 0;
    int q;
    int w;
    for (int i = 0; i<k; ++i){
        cin>>q>>w;
        map2[q].push_back(w);
        map2[w].push_back(q);
    }
    //ans += check(x, y, map2);
    for (int i=0; i<m; ++i){
        ans += check(x, y, map2);
        x = seats.at(x-1);
        y = seats.at(y-1);
    }
    cout<<ans<<endl;
}

/*

6 20 5
1 2
2 3 6 1 4 5
1 2
2 3
3 4
4 5
5 6

*/