#include <iostream>
#include <stdlib.h>

using namespace std;

int main()
{
    int amt;
    cin >> amt;
    int nums[amt];
    int min = INT8_MAX;
    int max = INT8_MIN;
    for (int i = 0; i < amt; i++)
    {
        cin >> nums[i];
        if (nums[i] < min)
            min = nums[i];
        if (nums[i] > max)
            max = nums[i];
    }
    int convertTo = nums[0];
    int lowestcost = -1;
    for (int i = min; i < max; i++)
    {
        int sum = 0;
        for (int j = 0; j < amt; j++)
        {
            sum += (nums[j] - i) * (nums[j] - i);
        }
        if (sum <= lowestcost || lowestcost == -1)
        {
            lowestcost = sum;
            convertTo = i;
        }
    }
    cout << lowestcost << endl;
}