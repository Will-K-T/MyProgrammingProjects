#include <iostream>

using namespace std;

int main(){
    int numStars;
    cin >> numStars;
    int cords[numStars][2];
    for(int i=0; i<numStars; i++){
        for(int j=0; j<2; j++){
            cin >> cords[i][j];
        }
    }
    int lvls[numStars] = {0};
    for(int i=0; i<numStars; i++){
        int cnt = 0;
        int cx = cords[i][0];
        int cy = cords[i][1];
        //cout << "cx: " << cx << endl;
        //cout << "cy: " << cy << endl;
        for(int j=0; j<numStars; j++){
            if(j==i) continue;
            int nx = cords[j][0];
            int ny = cords[j][1];
            if(cx >= nx && cy >= ny){
                cnt++;
            }
        }
        //cout << i << " " << cnt << endl;
        lvls[cnt] = lvls[cnt]+1;
    }
    for(int i=0; i<numStars; i++){
        cout << lvls[i] << "\n";
    }
}