#include <bits/stdc++.h>

using namespace std;

bool findGreat(unordered_map<string, vector<string>> m, string curr, unordered_set<string> words){
    words.insert(curr);
    auto got = m.find(curr);
    if(curr == "great"){
        return true;
    }
    if(got == m.end()){
        return false;
    }else{
        vector<string> currVec = got->second;
        for(string s: currVec){
            if (words.find(s) == words.end()){
                if(findGreat(m, s, words)){
                    return true;
                }
            }
        }
    }
    return false;
}

int main(){
    int lines = 0;
    cin >> lines;
    string temp;
    getline(cin, temp);
    unordered_map<string, vector<string>> map;
    unordered_map<string, vector<string>> map2;
    for(int i=0; i<lines; ++i){
        string line = "";
        getline(cin, line);
        string word1 = line.substr(0, line.find(" "));
        int space = line.find_last_of(" ");
        string word2 = line.substr(space+1, line.size()-space-1);
        //cout << "w " << word1 << " " << word2 << endl;
        map[word1].push_back(word2);

        map2[word2].push_back(word1);

        auto got = map2.find(word1);
        auto got2 = map.find(word2);// animals -> cats

        if(got != map2.end()){
            //cout << "hehe" << endl;
            vector<string> idk = map2[word1];
            for(string c: idk){
                //cout << "STR: " << c << endl;
                map[c].push_back(word2);
                map2[word2].push_back(c);
            }
            //map[word1] = map2[word1];
        }
        if(got2 != map.end()){
            //cout << "haha" << endl;
            vector<string> idk = map[word2];
            for(string c: idk){
                //cout << "STR: " << c << endl;
                map[word1].push_back(c);
                map2[c].push_back(word1);
            }
            //map[word1].push_back(word1);
        }
    }


    vector<string> ans = map["cats"];
    for(string s: ans){
        if(s == "great"){
            cout << "Cats are great! :D" << endl;
            return 0;
        }
    }
    cout << "Cats are not great :(" << endl;
    // unordered_set<string> w;
    // if(findGreat(map, "cats", w)){
    //     cout << "Cats are great! :D" << endl;
    // }else{
    //     cout << "Cats are not great :(" << endl;
    // }
}

/*

5
dumb is lame
animals are great
cats are animals
cats are dumb
dogs are animals
dumb is lame
animals are great

animals -> cool
cats -> animals -> cool

3
animals are cool
cats are animals
cool is great

*/
