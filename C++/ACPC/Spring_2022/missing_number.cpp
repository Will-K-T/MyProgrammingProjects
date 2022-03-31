#include <bits/stdc++.h>

using namespace std;

using ll = long long;

int main(){
  ll n, sum;
  cin >> n;
  sum = (n*(n+1))/2;
  for(int i=0; i<n-1; ++i){
    int curr; cin >> curr;
    sum -= curr;
  }
  cout << sum << endl;
}
