#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main()
{
    int n, l;
    cin >> n >> l;
    string ans = "";
    string test = "";
    for (int i = 0; i < l; i++)
    {
        test += "a";
    }
    cout << test + "\n";
    //test = "cxx";
    cout << test.compare("axx") << "\n";
    cout << test.compare("bxx") << "\n";
    vector<string> words;
    string temp;
    for (int i = 0; i < n; i++)
    {
        cin >> temp;
        words.push_back(temp);
    }
    for (int i = 0; i < words.size(); i++)
    {
    }
}