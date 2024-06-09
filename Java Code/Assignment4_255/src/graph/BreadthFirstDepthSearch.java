//NAME: Danny Trenholm
//ID: 201202966
//Email: x2012cml@stfx.ca

package graph;

import java.util.Iterator;

public class BreadthFirstDepthSearch {
    public static void bfs(ListGraph graph, int start) {
        Queue<Integer> queue = new ArrayQueue<Integer>(); //Initialize the queue
        boolean[] visited = new boolean[graph.getNumV()]; //Create a graph of the size of the vertexes


        visited[start] = true; //Mark the starting spot as visited
        queue.enqueue(start); //Add starting spot to the queue

        while (!queue.isEmpty()) { //While the queue is not empty
            int current = queue.dequeue(); //The current becomes the element at the front of the queue
            System.out.print(current + " "); //Print out the current nodes throughout the first depth search


            Iterator<Edge> edgeIterator = graph.edgeIterator(current); //Create the edge iterator
            while (edgeIterator.hasNext()) { //while the iterator has another edge
                int neighbor = edgeIterator.next().getDest(); //The neighbour  is the assigned destination
                if (!visited[neighbor]) { //If the neighbour is not visited
                    visited[neighbor] = true; //The neighbour becomes visited
                    queue.enqueue(neighbor); //The queue adds the neighbour.
                }
            }
        }
    }
}








