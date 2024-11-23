#include <iostream>

using namespace std;

char classify(int num){
  if(num < 10){
    return 'N';
  }

  int previousDigit = num%10;
  num /= 10;
  bool previousUp = false;
  bool currentUp = false;

  if(num%10 > previousDigit){
    previousUp = true;
  }else if(num%10 < previousDigit){
    previousUp = false;
  }else{
    return 'N';
  }

  previousDigit = num%10;
  num /= 10;

  while(num > 0){
    int currentDigit = num % 10;
    if((currentDigit > previousDigit) && (previousUp == false)){
      // we went up
      currentUp = true;
    }else if((currentDigit < previousDigit) && (previousUp == true)){
      // we went down
      currentUp = false;
    }else{
      // bad
      return 'N';
    }
    previousDigit = currentDigit;
    previousUp = currentUp;
    num /= 10;
  }

  if(previousUp == false){
    return 'M';
  }else{
    return 'V';
  }


}

int main(){
  int number;
  int bottom = 1234;
  int top = 4321;

  int numberOfMountains = 0;
  int numberOfVallies = 0;

  for(int i=bottom; i<=top; i++){
    char type = classify(i);
    if(type == 'M'){
      numberOfMountains++;
    }else if(type == 'V'){
      numberOfVallies++;
    }
  }

  cout << "# of M: " << numberOfMountains << endl;
  cout << "# of V: " << numberOfVallies << endl;

  // while(true){
  //   cout << "Enter a number: ";
  //   cin >> number;
  //   char type = classify(number);
  //   cout << "That was a " << type << endl;
  // }


}
