package graph;

/**
 * An Edge represents a relationship between two
 * vertices.
 */
public class Edge {
    //There is always only 1 edge between each node, with the consideration of undirected where they swap places
    // Data Fields
    /** The source vertex */
    private final int source;
    /** The destination vertex */
    private final int dest;
    /** The weight */
    private final double weight;

    // Constructor
    /** Construct an Edge with a source of from
     * and a destination of to. Set the weight to 1.0.
     * @param source - The source vertex
     * @param dest - The destination vertex
     */
    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
        this.weight = 1;
    }
    /** Construct a weighted edge with a source
     * of from and a destination of to. Set the
     * weight to w.
     * @param source - The source vertex
     * @param dest - The destination vertex
     * @param w - The weight
     */
    public Edge(int source, int dest, double w) {
        this.source = source;
        this.dest = dest;
        this.weight = w;
    }
    // Methods
    /** Get the source
     * @return The value of source
     */
    public int getSource() {
    return source;}
    /** Get the destination
     * @return The value of dest
     */
    public int getDest() {
    return dest;}
    /** Get the weight
     * @return the value of weight
     */
    public double getWeight() {
    return weight;}
    /** Return a String representation of the edge
     * @return A String representation of the edge
     */
    @Override
    public String toString() {
    return String.format("Source: %s, Destination: %s, weight: %s", source, dest, weight);}
    /** Return true if two edges are equal. Edges
     * are equal if the source and destination
     * are equal. Weight is not considered.
     * @param obj The object to compare to
     * @return true if the edges have the same source
     * and destination
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Edge) {
            Edge edge = (Edge) obj;
            return (source == edge.source && dest == edge.dest);
        } else {
            return false;
        }
    }
    /** Return a hash code for an edge. The hash
     * code is the source shifted left 16 bits
     * exclusive or with the dest
     * @return a hash code for an edge
     */
    @Override
    public int hashCode() {
        return (source << 16) ^ dest;
    }}
