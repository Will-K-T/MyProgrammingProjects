#include <bits/stdc++.h>

using namespace std;
using ll = long long;

int main(){
  ll n;
  cin >> n;
  while(n != 1){
    cout << n << " ";
    if(!(n%2)){
      n /= 2;
    }else{
      n *= 3;
      ++n;
    }
  }
  cout << "1\n";
}
