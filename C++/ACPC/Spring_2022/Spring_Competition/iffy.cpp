#include <bits/stdc++.h>
#include <unordered_set>

using namespace std;
#define RANGE_MIN -1000
#define RANGE_MAX 1000

int hasher(int x, int y)
{
    return (x * (RANGE_MAX - RANGE_MIN + 1)) + y;
}

void changeDir(int& x, int& y, string d){
    if(d=="NORTH"){
        y++;
    }else if(d=="SOUTH"){
        y--;
    }else if(d=="WEST"){
        x--;
    }else if(d=="EAST"){
        x++;
    }
}

int main(){
    int n;
    cin >> n;
    int x = 0;
    int y = 0;
    int cnt = 1;
    vector<string> dirs;
    for(int i=0; i<n; ++i){
        string dir;
        cin >> dir;
        dirs.push_back(dir);
    }
    unordered_set<int> map;
    for(int i=0; i<n; ++i){
        string dir;
        dir = dirs[i];
        //cin >> dir;
        changeDir(x, y, dir);
        if(x == 0 && y == 0) continue;
        int h = hasher(x,y);
        //cout << x << " " << y << " " << h << endl;
        if(map.find(h) == map.end()){
            map.insert(h);
            //cout << "here" << endl;
            cnt++;
        }
    }
    cout << cnt << endl;
    return 0;
}