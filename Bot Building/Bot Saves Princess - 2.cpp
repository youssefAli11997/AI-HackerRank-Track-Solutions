#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int dist(int x1, int y1, int x2, int y2){
    return abs(x1-x2) + abs(y1-y2);
}

int valid(int n, int i, int j){
    return i>=0 && i<n && j>=0 && j<n;
}

void nextMove(int n, int r, int c, vector <string> grid){
    int px,py,mn = 1000, dx[] = {0,0,-1,1}, dy[] = {-1,1,0,0};
    string ans;
    for(int i=0; i<n; i++) for(int j=0; j<n; j++) if(grid[i][j] == 'p'){
        px = i;
        py = j;
    }
    
    for(int k=0; k<4; k++) {
        int toX = r + dx[k];
        int toY = c + dy[k];
        
        if(valid(n,toX,toY) && dist(toX,toY,px,py) < mn){
            mn = dist(toX,toY,px,py);
            if(k == 0) ans = "LEFT";
            if(k == 1) ans = "RIGHT";
            if(k == 2) ans = "UP";
            if(k == 3) ans = "DOWN";
        }
    }
    cout<<ans;
}

int main(void) {

    int n, r, c;
    vector <string> grid;

    cin >> n;
    cin >> r;
    cin >> c;

    for(int i=0; i<n; i++) {
        string s; cin >> s;
        grid.push_back(s);
    }

    nextMove(n, r, c, grid);
    return 0;
}