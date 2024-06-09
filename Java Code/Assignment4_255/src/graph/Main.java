//NAME: Danny Trenholm
//ID: 201202966
//Email: x2012cml@stfx.ca

package graph;

import static graph.Dijkstra.dijkstra; //importing a static instance of Dijkstra method
import static graph.BreadthFirstDepthSearch.bfs; //importing a static instance of the Breadth First Depth Search
public class Main {
    public static void main(String[] args) {
        //Dijkstra Method
        System.out.println("The Dijkstra Method returns this..." + "\n");
        // create a graph with 6 vertices
        ListGraph graph = new ListGraph(6, true);

        // add edges to the graph
        graph.insert(new Edge(0, 1, 7));
        graph.insert(new Edge(0, 2, 9));
        graph.insert(new Edge(0, 5, 11));
        graph.insert(new Edge(1, 2, 15));
        graph.insert(new Edge(1, 3, 10));
        graph.insert(new Edge(2, 3, 15));
        graph.insert(new Edge(2, 5, 20));
        graph.insert(new Edge(3, 4, 6));
        graph.insert(new Edge(4, 5, 9));

        // get the shortest paths from vertex 0 to all other vertices
        double[] distances = dijkstra(graph, 0);


            System.out.println("The shortest path from 0 to " + 5 + " is " + distances[5] + "\n");

        // create a graph with 6 vertices
        ListGraph graph2 = new ListGraph(6, false);

        // add edges to the graph
        graph2.insert(new Edge(0, 1, 1));
        graph2.insert(new Edge(0, 2, 2));
        graph2.insert(new Edge(0, 5, 3));
        graph2.insert(new Edge(1, 2, 4));
        graph2.insert(new Edge(1, 3, 5));
        graph2.insert(new Edge(2, 3, 6));
        graph2.insert(new Edge(2, 5, 7));
        graph2.insert(new Edge(3, 4, 8));
        graph2.insert(new Edge(4, 5, 9));

        System.out.println("The BFS Search gives this from node 3" + "\n");
        bfs(graph2, 3);
    }
    }

