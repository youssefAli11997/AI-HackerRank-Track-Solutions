#include <iostream>
#include <vector>
using namespace std;

void displayPathtoPrincess(int n, vector <string> grid){
    int px,py;
    for(int i=0; i<n; i++) for(int j=0; j<n; j++) if(grid[i][j] == 'p'){
        px = i;
        py = j;
    }

    if(px == 0 && py == 0){
        for(int k=0; k<n/2; k++)
            cout<<"LEFT\n";
        for(int k=0; k<n/2; k++)
            cout<<"UP\n";
    }

    if(px == 0 && py == n-1){
        for(int k=0; k<n/2; k++)
            cout<<"RIGHT\n";
        for(int k=0; k<n/2; k++)
            cout<<"UP\n";
    }

    if(px == n-1 && py == 0){
        for(int k=0; k<n/2; k++)
            cout<<"LEFT\n";
        for(int k=0; k<n/2; k++)
            cout<<"DOWN\n";
    }

    if(px == n-1 && py == n-1){
        for(int k=0; k<n/2; k++)
            cout<<"RIGHT\n";
        for(int k=0; k<n/2; k++)
            cout<<"DOWN\n";
    }
}
int main(void) {

    int m;
    vector <string> grid;

    cin >> m;

    for(int i=0; i<m; i++) {
        string s; cin >> s;
        grid.push_back(s);
    }

    displayPathtoPrincess(m,grid);

    return 0;
}
