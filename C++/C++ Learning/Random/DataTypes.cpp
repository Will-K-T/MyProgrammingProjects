#include <iostream>
#include <climits>
using std::cout;
using std::cin;

int main(){
    //short <= int <= long <= long long
    //The size of the data types is different on each maching
    //Each data type stores a min number of bits
    char x = 'A';
    short a;
    int b;
    long c;
    long long d;

    unsigned short aa; //Unsigned data types can only be positive
    unsigned int bb; //Unsigned values can be larger since the two's compliment bit is gone
    unsigned long cc;
    unsigned long long dd;

    cout << SHRT_MAX << "\n"; //Max value of signed short
    cout << USHRT_MAX << "\n"; //Max value of unsigned short
    cout << LLONG_MAX << "\n"; //Max value of signed long long
}