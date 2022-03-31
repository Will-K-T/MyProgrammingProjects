#include <iostream>
#include <cmath>

// using namespace std; //Lets me use all of the stuff in std without std::
using std::cout; //Only lets me use cout with std::
using std::cin;

int testFunction(int, int); //Declares a function with 2 int paratypeOne

int main(){
    int slices;
    cout << "How many slices of pizza did you eat? ";
    cin >> slices;
    cout << "You ate " << slices << " slices of pizza!\n";

    cout << pow(10, 5) << "\n";

    // printf("%d", slices); //Can use printf just like in C!
}

int testFunction(int x, int y){
    return x*y;
}