#include <iostream>
#include <vector>
#include <queue>

#define H 100
#define W 100

int main() {

    /* Grid */
    int grid[H][W];
    int newCol, newRow;

    /* Visit Data */
    vector<vector<bool>> vis(H, vector<bool> (W, false));
    
    /* Directions */
    vector<pair<int,int>> directions = {{0,1},{1,0},{-1,0},{0,-1}};

    /* Bounded */
    auto bounded = [&](int row, int col) {
        return 0<=row && row<=H && 0<=col && col<=W;
    };

    /* Iterate over every coodtinate */
    for (int row = 0; row < H; row++) {
        for (int col = 0; col < W; col++) {
            if (!vis[row][col]) {
                /* This begins a new component */
                /* Process ... */
                queue<pair<int,int>> q;
                q.push({row,col});
                vis[row][col] = true;
                /* Process all the nodes which enter the queue until queue is empty */
                while(!queue.empty()) {
                    pair<int,int> p = q.front();
                    q.pop();
                    /* process this / current coordinate */
                    for (pair<int,int> dir: directions) {
                        newRow = row + dir.first;
                        newCol = col + dir.second;
                        if (!vis[newRow][newCol] && bounded(newRow, newCol) && true) { /* add more conditions as necessary */
                            q.push({newRow,newCol});
                            vis[newRow][newCol] = true;
                        }
                    }
                }
            }
        }
    }
}
