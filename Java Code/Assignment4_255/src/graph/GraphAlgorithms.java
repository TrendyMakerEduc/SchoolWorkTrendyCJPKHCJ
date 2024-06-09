package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class GraphAlgorithms{

    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    //Topological sort
    public void main(String[] args) throws FileNotFoundException {
    topSort();


    }

    public void topSort() throws FileNotFoundException {
        Scanner readTxt = new Scanner(new File("C:\\Users\\danny\\IdeaProjects\\Graph\\resources\\GraphAlgorithms.txt")); // Be sure to give the full path to the console.
        ListGraph graph = new ListGraph(7, true);
        graph.loadEdgesFromFile(readTxt);
        Queue<Integer> q;
        int counter = 0;
        for(int i = 0; i < graph.getNumV(); i++){
            Edge e = graph.getEdge(i, counter);
            if(e != null){
                map.put(e.getSource(), e.getDest());
            }else{
                System.out.println("There is no available edge.");
            }
            if(counter < graph.getNumV()){
                counter ++;
                i--;
            }


        }
        System.out.println(map.toString());
    }

    public void BFS(Graph graph, int source){
        Queue<Integer> q = new ArrayQueue<>();
        q.enqueue(source);
        while(q.isEmpty() != true){
            int u = q.dequeue();
            Edge e = graph.getEdge(source, u);
            map.put(e.getSource(),e.getDest());


        }
    }


}
