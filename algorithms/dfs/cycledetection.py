from collections import defaultdict

graph= defaultdict(set)

edges = [
    (0, 1),
    (1, 2),
    (2, 3),
    (4, 3),
    (4, 5),
    (2, 5),
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
