#include <iostream>

using namespace std;

int main()
{
    int nums;
    cin >> nums;
    int big = -1;
    int numbers[nums];
    for (int i = 0; i < nums; i++)
    {
        cin >> numbers[i];
        if (numbers[i] > big)
        {
            big = numbers[i];
        }
    }
    while ()
}