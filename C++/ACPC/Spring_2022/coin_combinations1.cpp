#include <bits/stdc++.h>

using namespace std;
using ll = long long;

const int MOD = 1e9 + 7;

// ll dp[(int)1e6 + 10];
// vector<int> coins; // 2 3 5
//
// // x = 9, 7, 5, 3, 1, -1
// ll calc(int x){
//   if(x < 0){
//     return 0;
//   }
//   if(dp[x] != -1){
//     return dp[x];
//   }
//   if(x == 0){
//     return 1;
//   }
//   ll ans = 0;
//   for(int c : coins){
//     ans = (ans + calc(x - c)) % MOD;
//   }
//   dp[x] = ans;
//   return ans;
// }
//
// int main(){
//   int n,x;
//   cin >> n >> x;
//   memset(dp, -1, sizeof(dp));
//   for(int i=0; i<n; ++i){
//     int c; cin >> c;
//     coins.push_back(c);
//   }
//   cout << calc(x) << endl;
//
// }

//ex coins = 2,3,5 and sum to 9

// []

int main(){
  int n, x;
  cin >> n >> x;
  vector<int> coins;
  for(int i=0; i<n; ++i){
    int c; cin >> c;
    coins.push_back(c);
  }

  vector<int> f(x+1, 0);
  f[0] = 1;
  for(int y=1; y <= x; ++y){
    for(int i=0; i<n; ++i){
      if(y-coins[i] >= 0){
        f[y] += f[y-coins[i]];
      }
    }
  }
  cout << f[x] << endl;
}
