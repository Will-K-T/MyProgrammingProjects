#include <iostream>
#include <vector>
#include <sstream>

//89CFF0 - comments
using namespace std;


class Node{
private:
    int x;
    int y;
public:
    Node(){
        x = 0;
        y = 0;
    }
    Node(int x, int y){
        this->x = x;
        this->y = y;
    }
    string toString(){
        return to_string(x)+" "+to_string(y);
    }
};

class TestClass{
private:
    int num;
    string dog;
    double dec;
    vector<Node> nodes;
public:
    TestClass(){
        num = 0;
        dog = "";
        dec = 0;
    }
    TestClass(int num, string dog, double dec){
        this->num = num;
        this->dog = dog;
        this->dec = dec;
    }
    int getNum(){
        return this->num;
    }
    void getNodes(){
        for (int i = 0; i < nodes.size(); ++i) {
            cout << nodes.at(i).toString() << endl;
        }
    }
    void makeNodes(int numOfNodes){
        for (int i = 0; i < numOfNodes; ++i) {
            nodes.emplace_back(i, i+rand()%10+1);
        }
        cout << nodes.size() << endl;
    }
};

int main() {
    TestClass myClass(10, "joe", 3.4);
    myClass.makeNodes(10);
    myClass.getNodes();
    return 0;
}
