#include <iostream>
#include <vector>

#define ll long long

using namespace std;

ll productsAfterSecs(vector<ll> &v, ll secs){
  ll products = 0;
  for(ll i=0; i<v.size(); ++i){
    products += (secs/v.at(i));
    if (products > 1e18) products = 1e18;
  }
  return products;
}

ll binarySearch(ll startTime, ll target, vector<ll> &v){
  ll mid, low = 0;
  ll high = 1e18;
  ll ans;
  // ok(x) tells me if x is big enough
  // for (int j = 63; j >= 0; --j) while (ok(x - (1<<j))) x -= (1<<j);
  while(low < high){
    mid = (low+high)/2;
    ll prods = productsAfterSecs(v, mid);
    //if(prods == target) return mid;
    if(prods < target){
      low = mid+1;
    }else{
      ans = mid;
      high = mid-1;
    }
  }
  if (productsAfterSecs(v, high) >= target) ans = high;
  return ans;
}

int main(){
int i = 5;
int& ref_i = i;
int j = 10;
int& ref_j = j;
ref_i = ref_j;
  ll len, t;
  cin >> len >> t;
  vector<ll> machineTimes;
  ll temp;
  for(ll i=0; i<len; ++i){
    cin >> temp;
    machineTimes.push_back(temp);
  }
  cout << binarySearch(1e9, t, machineTimes) << endl;
  return 0;
}
