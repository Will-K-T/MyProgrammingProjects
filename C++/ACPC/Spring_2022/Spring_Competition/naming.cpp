#include <bits/stdc++.h>

using namespace std;

int main(){
    int odd = 0;
    vector<int> arr;
    string ans = "";
    for(int i=0; i<26; ++i){
        int curr;
        cin >> curr;
        if(curr % 2 == 0){
            for(int j=0; j<curr/2; ++j){
                ans += (char)(i+97);
                ans = (char)(i+97) + ans;
            }
        }else{
            if(odd > 0){
                cout << "NO" << endl;
                return 0;
            }
            odd++;
            string firstHalf = ans.substr(0, ans.size()/2);
            string seconHalf = ans.substr(ans.size()/2, ans.size()/2);
            string oddStr = "";
            for(int j=0; j<curr; ++j){
                oddStr += (char)(i+97);
            }
            ans = firstHalf + oddStr + seconHalf;
        }
    }
    cout << "YES" << endl;
    cout << ans << endl;
    return 0;
}
