import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Queue<T> {
    // A node that is at the front
    private Node<T> front;
    //A node that is at the rear
    private Node<T> rear;
    // An integer to keep track of size
    private int size;
    // Constructor for a linked Queue with no parameters
    public LinkedQueue(){
        front = null;
        rear = null;
        size = 0;
    }

    //Adding an object to a linked Queue
    public boolean enqueue(T element){
        //First start by creating a node, since it is a linked queue
        Node<T> toEnqueue = new Node<>(element);

        //If nothing, front equals toEnqueue
        // This is one of the edge cases, if empty
        if (isEmpty()){
            front = toEnqueue;
        } else {
            rear.setNext(toEnqueue);
        }
        //Either way,the rear will always equal toEnqueue
        rear = toEnqueue;
        size++;
        return true;
    }

    //Deleting an element (node)
    @Override
    public T dequeue(){
        //First, check if it is empty
        if(isEmpty()){
            throw new NoSuchElementException("The queue is empty!");

        }
        //You want to return the data, not the container
        T returnElement = front.getData();
        //Front gets up updated
        front = front.getNext();
        //Size decrements
        size--;
        //We must check if it is empty again, if it is, then rear is null
        if (isEmpty()){
            rear = null;
        }
        //Return the data
        return returnElement;
    }

    @Override
    //Checking for the first element in the queue
    public T first(){
        //Check if the queue is empty
        if(isEmpty()){
            throw new NoSuchElementException("The queue is empty!");
        }
        //Returning the data from the front
        return front.getData();
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int size(){
        return size;
    }

}
