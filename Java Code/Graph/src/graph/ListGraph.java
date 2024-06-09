package graph;

import java.util.*;

/** A ListGraph implements the Graph interface using an
 array of lists to represent the edges.
 */
public class ListGraph implements Graph {

    // Data Fields
    /** The number of vertices */
    private final int numV;
    /** An indicator of whether the graph is directed (true) or not (false)
     */
    private final boolean directed;
    /** An array of Lists to contain the edges that
     originate with each vertex.
     */
    private LinkedList<Edge>[] edges;


    /** Construct a graph with the specified number of vertices and directionality.
     @param numV The number of vertices
     @param directed The directionality flag
     */
    public ListGraph(int numV, boolean directed) {
        this.numV = numV;
        this.directed = directed;
        edges = new LinkedList[numV];
        for (int i = 0; i < numV; i++) {
            edges[i] = new LinkedList<Edge>();
        }
    }

    /**
     * Insert a new edge into the graph.
     *
     * @param edge The new edge
     */
    @Override
    public void insert(Edge edge) {
        edges[edge.getSource()].push(edge);
        if(!directed){
            edges[edge.getDest()].push(edge);
        }
        }

    /**
     * Get the edge between two vertices.
     *
     * @param source The source vertex
     * @param dest   The destination vertex
     * @return The edge between these two vertices
     * or null if there is no edge
     */
    public Edge getEdge(int source, int dest) {
    Edge edge = new Edge(source, dest);
    for(Edge e : edges[source]){
        if(e.equals(edge)){
            return e;
        }
    }
    return null;
    }

    public boolean isEdge(int source, int dest){
        Edge e = new Edge(source, dest);
        for(Edge edge : edges[source]) {
            if (edge.equals(e)) {
                return true;
            }
        }
        return false;
        }

 public int getNumV(){
    return numV;
 }

 public boolean isDirected(){
      return directed;
 }

 public Iterator<Edge> edgeIterator(int source){
       return edges[source].iterator();
 }



        }


