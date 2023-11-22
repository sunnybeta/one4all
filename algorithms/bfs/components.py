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
