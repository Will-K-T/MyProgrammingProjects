#include <iostream>
#include <vector>

using namespace std;

int binarySearch(vector<int> &v, int target){
  int mid, low = 0;
  int high = v.size()-1;
  while(low < high){
    mid = (low+high)/2;
    if(v.at(mid) == target) return mid+1;
    if(target > v.at(mid)){
      low = mid+1;
    }else{
      high = mid-1;
    }
  }
  if(v.at(low) == target) return low+1;
  return -1;
}

int main(){
  vector<int> array;
  cout << "How many numbers? ";
  int len;
  cin >> len;
  int temp;
  for(int i=0; i<len; ++i){
    cin >> temp;
    array.push_back(temp);
  }
  cout << "What is the target? ";
  int target;
  cin >> target;
  cout << "Index (starting at 1): " << binarySearch(array, target) << endl;
  return 0;
}
