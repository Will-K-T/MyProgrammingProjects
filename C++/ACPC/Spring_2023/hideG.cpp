#include <bits/stdc++.h>

using namespace std;

int main(){
    int n, m;
    cin >> n >> m;

    unordered_map<int, list<int> > graph;

    bool hasStart = false;

    for(int i=0; i<m; ++i){
        int a, b;
        cin >> a >> b;

        if(graph.find(a) == graph.end()){
            graph[a] = {};
        }
        if(graph.find(b) == graph.end()){
            graph[b] = {};
        }

        if(a == 0) hasStart = true;

        graph[a].push_back(b);
        graph[b].push_back(a);
    }

    queue<pair<int, int>> q;
    
    if(!hasStart){
        cout << 0 << endl << endl;
        return 0;
    }

    q.push(make_pair(0, 0));
    unordered_set<int> visited;

    vector<int> ans;

    while(!q.empty()){
        auto c = q.front();
        q.pop();

        visited.insert(c.first);
        ans.push_back(c.first);

        for(auto n: graph[c.first]){
            if(visited.find(n) == visited.end() && c.second+3 <= 9){
                q.push(make_pair(n, c.second+3));
                visited.insert(n);
            }
        }
    }

    cout << ans.size()-1 << endl;
    for(int i=1; i<ans.size()-1; ++i){
        cout << ans[i] << " ";
    }
    cout << ans[ans.size()-1] << endl;
}