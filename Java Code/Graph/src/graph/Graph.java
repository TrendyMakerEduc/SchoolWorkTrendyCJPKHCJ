package graph;

import java.util.*;

/** Interface to specify a Graph ADT.
 * A graph is a set of vertices and a set of edges.
 * Vertices are represented by integers from 0 to n − 1.
 * Edges are ordered pairs of vertices.
 * Each implementation of the Graph interface should
 * provide a constructor that specifies the number of
 * vertices and whether the graph is directed.
 */
public interface Graph {

    // Accessor Methods
    /** Return the number of vertices.
     @return The number of vertices
     */
    int getNumV();

    /** Determine whether this is a directed graph.
     @return true if this is a directed graph
     */
    boolean isDirected();

    /** Insert a new edge into the graph.
     @param edge The new edge
     */
    void insert(Edge edge);

    /** Determine whether an edge exists.
     @param source The source vertex
     @param dest The destination vertex
     @return true if there is an edge from source to dest
     */
    boolean isEdge(int source, int dest);

    /** Get the edge between two vertices.
     @param source The source vertex
     @param dest The destination vertex
     @return The edge between these two vertices or null if there is no edge
     */
    Edge getEdge(int source, int dest);

    /** Return an iterator to the edges connected to a given vertex.
     @param source The source vertex
     @return An Iterator<Edge> to the vertices connected to source
     */
    Iterator<Edge> edgeIterator(int source);

    /** Read source and destination vertices and weight (optional) for each edge from a file
     @param scan The Scanner associated with the file
     */
    default void loadEdgesFromFile(Scanner scan) {
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine();
            if (!line.isBlank()) {
                String[] tokens = line.split(",");
                int source = Integer.parseInt(tokens[0]);
                int dest = Integer.parseInt(tokens[1]);
                double weight = 1.0;
                if (tokens.length == 3) {
                    weight = Double.parseDouble(tokens[2]);
                }
                insert(new Edge(source, dest, weight));
            }
        }
    }
}