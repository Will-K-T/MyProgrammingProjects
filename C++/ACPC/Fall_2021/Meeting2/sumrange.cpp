#include <iostream>

using namespace std;

#define ll long long

int main(){
  ll n, q;
  cin >> n >> q;
  ll nums[n];
  ll sums[n];
  for(ll i=0; i<n; ++i){
    cin >> nums[i];
    if(i == 0) sums[i] = nums[i];
    else sums[i] = sums[i-1] + nums[i];
  }
  ll l, r;
  for(ll i=0; i<q; ++i){
    cin >> l >> r;
    --l; --r;
    if(l - 1 >= 0) cout << (sums[r] - sums[l-1]) << endl;
    else cout << sums[r] << endl;
  }

  return 0;
}
