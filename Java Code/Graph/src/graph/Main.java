package graph;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
//        Scanner readTxt = new Scanner(new File("C:\\Users\\danny\\IdeaProjects\\Graph\\resources\\test.txt")); // Be sure to give the full path to the console.
//        ListGraph graph = new ListGraph(7, false);
//        graph.loadEdgesFromFile(readTxt);
//        System.out.println(graph.getEdge(1,2 ));
//        System.out.println(graph.isEdge(1,2));
//        System.out.println(graph.getNumV());
//        System.out.println(graph.isDirected());
//        Iterator<Edge> edges = graph.edgeIterator(0);
//        while(edges.hasNext()) {
//            System.out.println(edges.next());
//        }

    }

    public static void topSort() throws FileNotFoundException {
        ArrayList map = new ArrayList();
        Scanner readTxt = new Scanner(new File("C:\\Users\\danny\\IdeaProjects\\Graph\\resources\\GraphAlgorithms.txt")); // Be sure to give the full path to the console.
        ListGraph graph = new ListGraph(8, true);
        graph.loadEdgesFromFile(readTxt);
        Queue<Integer> q;
        int counter = 0;
        for(int i= 0; i < graph.getNumV(); i++){
            if(i == counter){
                q.enqueue(i);
            }
            while(q.isEmpty() != true){
                Integer v = q.dequeue();
                v = counter++;
                //This needs to grab the edges and returns the neighbours to this edge, via the map
                for(int j = 0; j < graph.getNumV(); j++){

                }
            }
        }

    }

    public static void BFSStart() throws FileNotFoundException {
        ArrayList map = new ArrayList();
        Scanner readTxt = new Scanner(new File("C:\\Users\\danny\\IdeaProjects\\Graph\\resources\\GraphAlgorithms.txt")); // Be sure to give the full path to the console.
        ListGraph graph = new ListGraph(8, true);
        graph.loadEdgesFromFile(readTxt);
        Queue<Integer> q;
        int counter = 0;
        for(int i = 0; i < graph.getNumV(); i++){
            counter = 0;
            ArrayList arr = new ArrayList();
            map.add(i, arr);
            for(int j = 0; j < graph.getNumV(); j++){
            Edge e = graph.getEdge(i, j );
            if(e != null){
                arr.add(counter, j);
                counter++;
            }else{
                System.out.println("There is no available edge.");
            }
            //This is a BFS type of search. When the counter hits 0 in topological order, it grabs the nodes before
                //the ones entering the node. Then adds to a list.



        }
    }
        System.out.println(map.toString());
}}