//public class GraphAlgorithms {
// Breadth first depth search with nodes
//    function BFS(Graph, source):
//
//    Create a queue Q.
//            Q.insert(s).
//
//            while Q not empty:
//    u = Q.pop()
//    visit(u)
//        for all v adjacent to u:
//            if v not marked or visited:
//    Mark v
//                Q.insert(v)
//} O(V**2), we can improve it.

//Dijsktra’s algorithm is a single source shortest-path algorithm for weighted graph.
//
//        It is also a greedy algorithm, meaning that we always take the closest node not already visited.
//
//        To work we need a few assumptions:
//
//        There is a path between the source (or start) and every other node in the graph.
//
//        All edges have a positive weight


//We consider two sets of nodes, S, and V-S
//S = set of nodes with shortest distance
//V-S = set of nodes remaining
//We also need two arrays d and p
//d[v] : the shortest distance from s to v
//p[v] : the predecessor of v in the path from s to v
//We initialize S with 0.
//We place every nodes remaining in V - S
//For each adjacent v of s, we set d[v] equal to w(s,v) where w is weight
//The predecessor is 0 for every v
//Now we find the vertex (node) uEV - S that has the smallest d[v]
//For every node v adjacent to u:
//if d[u] + w(u,v) < d[v], we update d[v]
//and we set p[v] to u
//
//function Dijkstra(Graph, source):
//        create empty list L
//        for all vertex v in G:
//        d[v] = infinity
//        p[v] = null
//        L.insert(v)
//        d[source] = 0
//        while L is not empty:
//        u = vertex in L with smallest d value
//        L.remove(u)
//        for each neighbor v of u:
//        alt = dist[u] + w(u, v)
//        if alt < dist[v]:
//        d[v] = alt
//        p[v] = u

//We can improve with a binary heap
//        function Dijkstra(Graph, source):
//        create empty priority queue Q
//        dist[source] = 0
//        for each vertex v in Graph:
//        if v != source:
//        dist[v] = infinity
//        p[v] = null
//        Q.insert(v, dist[v])
//        Q.insert(source, 0)
//        while Q is not empty:
//        u = Q.extract_min()
//        for each neighbor v of u:
//        alt = dist[u] + w(u, v)
//        if alt < dist[v]:
//        dist[v] = alt
//        p[v] = u
//        Q.decrease_key(v, alt)
//        return dist

//This is the A* method
//        Initialize V–S with all vertices except the starting vertex s.
//        for all v in V–S:
//        p[v] = s
//        if there is an edge (s, v):
//        d[v] = w(s, v)
//        f[v] = d[v] + h(v)
//        else:
//        d[v] = inf
//        f[v] = inf
//
//        while V–S is not empty:
//        u = find the smallest f[u]
//        if u == destination:
//        break
//        Remove u from V–S
//        Add u to S
//        for all v adjacent to u in V–S:
//        if d[u] + w(u, v) < d[v]:
//        d[v] = d[u] + w(u, v)
//        f[v] = d[v] + h(v)
//        p[v] = u