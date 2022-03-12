#include <iostream>

using namespace std;

int main()
{
    int ds = 0;
    bool inrow = false;
    int nums;
    int n1;
    int n2;
    cin >> nums;
    for (int i = 0; i < nums; i++)
    {
        if (ds >= 3)
        {
            break;
        }
        cin >> n1;
        cin >> n2;
        if (n1 == n2)
        {
            inrow = true;
            ds++;
        }
        else if (inrow)
        {
            inrow = false;
            ds = 0;
        }
    }
    if (ds >= 3)
    {
        cout << "Yes\n";
    }
    else
    {
        cout << "No\n";
    }
}
