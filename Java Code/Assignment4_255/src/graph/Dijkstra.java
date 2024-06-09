//NAME: Danny Trenholm
//ID: 201202966
//Email: x2012cml@stfx.ca

package graph;

import java.util.*;

public class Dijkstra {

    public static double[] dijkstra(ListGraph graph, int source) {
        int n = graph.getNumV(); //The number of vertexes are given
        double[] dist = new double[n]; //A new double array of distance is created
        Arrays.fill(dist, Integer.MAX_VALUE); //Fills in max value that a value can have
        dist[source] = 0; //distance at the source is 0
        //Creating a comparable PriorityQueue which compares distances
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingDouble(i -> dist[i]));
        queue.offer(source); //Offer the source vertex

        while (!queue.isEmpty()) { //While the queue is not empty
            int Vertex = queue.poll(); //grabbing the vertex.
            Iterator<Edge> edgeIterator = graph.edgeIterator(Vertex); //Create the edge iterator

            while (edgeIterator.hasNext()) { //While the edge iterator has a next edge
                Edge edge = edgeIterator.next(); //Grabbing the edge from the iterator
                int neighbor = edge.getDest(); //Grabbing the destination
                double weight = edge.getWeight(); //Grabbing the weight
                double newDist = dist[Vertex] + weight; //The new distance is created
                if (newDist < dist[neighbor]) { //If the new distance is less then the neighbours
                    dist[neighbor] = newDist; //The old distance becomes the new distance
                    queue.offer(neighbor); //We give the queue the new neighbour
                }
            }
        }

        return dist; //returns distance array
    }
}