#include <bits/stdc++.h>

using namespace std;

int main(){
  int cases, n;
  cin >> cases;
  for(int i=0; i<cases; ++i){
    cin >> n;
    int count = 1;
    int currHigh = 0;
    cin >> currHigh;
    for(int j=1; j<n; ++j){
      int currNum;
      cin >> currNum;
      if(currNum >= currHigh){
        count++;
        if(currNum == currHigh){
          currHigh = currNum+1;
        }else{
          currHigh = currNum;
        }
      }
    }
    cout << count << endl;
  }
}
