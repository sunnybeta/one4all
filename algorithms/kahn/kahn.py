from collections import deque, defaultdict

class Graph:

    def __init__(self, vertices):
        self.graph = defaultdict(list)
        self.vertices = vertices

    def add_edge(self, u, v):
        self.graph[u].append(v)

    def sort(self):
        q = deque()
        
        in_edges = [0 for _ in range(self.vertices)]

        for u in self.graph:
            for v in self.graph[u]:
                in_edges[v] += 1

        for vertex, in_degree in enumerate(in_edges):
            if in_degree == 0:
                q.append(vertex)

        count = 0
        ans = []

        while q:
            u = q.popleft()
            ans.append(u)
            for vertex, in_degree in enumerate(self.graph[u]):
                in_edges[vertex] -= 1
                if in_edges[vertex] == 0:
                    q.append(vertex)

        if count != self.vertices:
            print("Cycle Detected")
            return []
        else:
            return ans
