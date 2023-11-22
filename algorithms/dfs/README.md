# Depth-First Search

Given a graph like structure for traversal, we can perform a DFS on the structure as follows

1. Start at initial node;
2. Pick a neighbour of this node; Mark it as visited;
3. Now process this element;
4. Repeat steps 2 and 3 until the queue is empty;
5. If there are any more nodes remaining which we have visited, we can start from step 1 with a new initial point.

## [Cycle Detection in a Graph](../cycledetection)

```python
from collections import defaultdict

graph= defaultdict(set)

edges = [
    (0, 1),
    (1, 2),
    (2, 3),
    (4, 3),
    (5, 4),
    (5, 2),
]


for u,v in edges:
    graph[u].add(v)
    graph[v].add(u)


cycle = []

def dfs(vertex, viz, parent):
    viz.add(vertex)
    cycle.append(vertex)
    for v in graph[vertex]:
        if v not in viz:
            if (dfs(v, viz, vertex)):
                return True
        elif parent != v:
            cycle.append(v)
            return True
    return False


viz = set()

start = 0

ans = dfs(start, viz, -1)

if ans:
    print(cycle)
    print("Cycle Detected")
else:
    print("Tree Detected")
```

