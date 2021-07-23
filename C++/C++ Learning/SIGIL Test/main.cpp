#include <iostream>
#include "sl.h"

using std::cout, std::cin, std::endl;

// void slWindow(int one, int two, const char *title, int fullScreen){
//   return;
// }

int main(int argc, char const *argv[]) {
  slWindow(400, 400, "Simple SIGIL Example", false);
  cout << "hello, world!" << endl;
  return 0;
}
