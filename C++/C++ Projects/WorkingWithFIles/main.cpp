#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main() {
    ifstream myStream;
    ofstream myOStream;
    myStream.open("C:\\Users\\thompson_898340\\Documents\\thisneedstowork\\C++ Projects\\WorkingWithFiles\\Text.txt");
    if(myStream.is_open()){
        string output;
        while(!myStream.eof()){
            getline(myStream, output);
            //myStream >> output;
            cout << output << endl;
        }

    }
    else{
        cout << "No file found";
    }
    myStream.close();
    myOStream.open("C:\\Users\\thompson_898340\\Documents\\thisneedstowork\\C++ Projects\\WorkingWithFiles\\Text.txt", ios_base::app);
    myOStream << "I added this new line.\n";
    return 0;
}
