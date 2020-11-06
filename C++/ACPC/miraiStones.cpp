#include <algorithm>
#include <iostream>
#include <string>
#include <iterator>

using namespace std;

int qOne(int l, int r, int nums[], int length){
	int sum = 0;
	for(int i=l-1; i<r; i++){
		sum += nums[i];
		// cout << "n: " + nums[i] << "s: " << sum;
	}
	return sum;
}

int qTwo(int l, int r, int nums[], int size){
	int sum = 0;
	// sort(nums, nums + size);
	for(int i=l-1; i<r; i++){
		sum += nums[i];
	}
	return sum;
}

int main(){
	int n;
	cin >> n;
	int costs[n];
	for(int i=0; i<n; i++){
		cin >> costs[i];
	}
	int costs2[n];
	copy(costs, n + costs, costs2);
	int size = sizeof(costs) / sizeof(costs[0]);
	sort(costs2, size + costs2);
	int m;
	cin >> m;
	string result = "";
	for(int i=0; i<m; i++){
		int qType, l, r;
		cin >> qType >> l >> r;
		if(qType == 1){
			result += to_string(qOne(l, r, costs, n)) + "\n";
		}else{
			result += to_string(qTwo(l, r, costs2, size)) + "\n";
		}
	}
	cout << result;
}
