# Breadth-First Search (BFS)

Given a graph like structure for traversal, we can perform a BFS on the structure as follows

1. Start at initial node; We have now visited this node;
2. Push the neighbors of this node in a queue; 
3. Now process the first element which was pushed in the queue;
4. Repeat steps 2 and 3 until the queue is empty;
5. If there are any more nodes remaining which we have visited, we can start from step 1 with a new initial point.

## Standard Implementation

```cpp
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
```

## Number of Components

```python
from collections import defaultdict, deque

graph = defaultdict(set)

edges = [
    (0,1),
    (2,3),
    (3,1),
    (4,5),
    (5,6),
    (7,9),
    (9,8),
]

for u,v in edges:
    graph[u].add(v)
    graph[v].add(u)

components = 0

q = deque()

viz = set()

for vertex in graph:
    if vertex not in viz:
        components += 1
        viz.add(vertex)
        q.insert(0, vertex)
        while q:
            neighbour = q.popleft()
            for nv in graph[neighbour]:
                if nv not in viz:
                    q.insert(0, nv)
                    viz.add(nv)

print(f"Number of Components is {components}.")
```
