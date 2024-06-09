//package graph;
//
//public class GraphingExercise {
//
//    Exercise 1: Find a topological ordering for the graph
//            Answer: To find the topological ordering we start at s.
//        We go to the next node that is not entering, in this case G
//        Then D as it works with no entering edges, while s connects to D, then A as there is no entering edges after D to A.
//        So far it is S, G, D, A.
//            Then B. Then H as it connects to G
//            Then E, I, F, C, t
//So it goes S, G, D, A, B, H, E, I, F, C, t
//
//
//    Exercise 2: Considering the following graph, find the shortest path from A to E using Breadth First Depth Search Algorithm. Consider an unweighted graph
//    Answer:
//            S = {A}
//            V-S = {B,C}
//            marked = {B,C}
//
//    S = {A, B}
//    V-S = {C, G, E }
//    marked {B,C,G,E}
//
//
//    S = {A, B, C}
//    V-S = {G, E, D }
//    marked {B,C,G,E, D}
//
//    S = {A, B, C, G}
//    V-S = { E, D }
//    marked {B,C,G,E, D}
//
//    S = {A, B, C, G, E}
//    V-S = {  D, F }
//    marked {B,C,G,E, D, F}
//
//    S = {A, B, C, G, E, D}
//    V-S = { F }
//    marked {B,C,G,E, D, F}
//
//    S = {A, B, C, G, E, D, F}
//    V-S = { }
//    marked {B,C,G,E, D, F}
//
//    Shortest path is ACE, ABE if you consider how it was implemented in the queue.
//
//
//
//
//
//    2) Repeat the process with Dijkstra's algrorithm
//    MAKE SURE TO ALWAYS DO THE SHORTEST IN THE V-S path, so A becomes visited, and we update the graph below. For simplicity, i will not copy it, and it can be done later
//             Cost           Predecessor
//    B          5                A
//    C          3                A
//    D
//    E
//    F
//    G
//
//Exercise 3: Find the maximum flow in the first graph.
//Make three copies of the graph. Call one G, then the other G(F), and the other G(R)
//G(R) S A B C t, and the G(f) is marked down. and make the lines go both ways on the G(r). where it is 1
//Another path, S,D,E,F,t, we modify and make the arrows go the other way and make it 3
//Another path S, G, H, I, t, and the maximum is 4
//LOOK THIS QUESTION OVER
//S,D,A,B,C,t
//
