#include <iostream>

using namespace std;

int main()
{
    int num;
    cin >> num;
    int lastdigit = num % 10;
    if (lastdigit == 2 || lastdigit == 4 || lastdigit == 5 || lastdigit == 7 || lastdigit == 9)
    {
        cout << "hon\n";
    }
    else if (lastdigit == 0 || lastdigit == 1 || lastdigit == 6 || lastdigit == 8)
    {
        cout << "pon\n";
    }
    else
    {
        cout << "bon";
    }
    return 0;
}