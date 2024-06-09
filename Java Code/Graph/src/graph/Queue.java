package graph;

public interface Queue<T> {
    boolean enqueue(T element); //This adds an element to the back of the line
    T dequeue(); //Removes the element from the front of the structure
    T first(); //Checks which element is at the head of the line
    boolean isEmpty(); //Checks the queue to see if it is empty
    int size(); //Checks how many elements are inside of the queue
}
