package graph;

import java.util.NoSuchElementException;
import java.util.Objects;

public class ArrayQueue<T> implements Queue<T> {
    //The idea

    //Use an array for the container. While doing this keep track of the
    //front index and rear index, while still keeping track of the size.
    //If there are empty indicies before the front, wrap the rear back to
    // 0 when the end of the array is hit. So a circular array

    //The key, is the modulo operator. It is the way to get the remainder of a
    //division.

    //First, we initialize the array container
    private T[] queue;

    //keeping track of the queue rear and front
    private int rear;
    private int front;

    //and keeping track of size
    private int size;
    private static final int DEFAULT_CAPACITY = 100; // This is a default size of the stack


    //constructor for no parameters
    public ArrayQueue(){
        this(DEFAULT_CAPACITY);
        rear = 0;
        front = 0;
        size = 0;
    }

    public ArrayQueue(int initialCapacity){
        size = 0; //first we set size to 0
        rear = 0;
        front = 0;
        queue = (T[]) new Object[initialCapacity]; //Then remember, we must specifiy the generic, then set to Object

    }


    //Enqueue is just the same as a linked structure, but we will be calling
    //a new function called nextIndex()

    @Override
    public boolean enqueue(T element){
        if(size == queue.length){ //If the size is equeue to the length of the queue
            expandCapacity(); //We expandCapacity, which is the copying of the array, doubling the size on another array and copying to the other
        }
        queue[rear] = element; //The end of the line is set to the element
        rear = nextIndex(rear); //A special function for getting the next index after the rear
        size++; // Size increases
        return true; //We return true to show it was successful
    }

    //nextIndex is a private helper that returns the currentIndex and adds +1 to it
    private int nextIndex(int currentIndex){
        return (currentIndex + 1) % queue.length; //Remember to get the remainder
    }

    //expandCapacity has the same idea, while we keep calling the front to be the nextIndex
    @SuppressWarnings("unchecked")
    private void expandCapacity() {
        T[] newQueue = (T[]) new Object[queue.length * 2]; //doubling the queue size
        for (int i = 0; i < queue.length; i++) {
            newQueue[i] = queue[front]; //We keep calling the queue front
            front = nextIndex(front); //And we keep incrementing the front's index
        }
        front = 0; //regardless, we must return front to 0
        rear = size(); //The rear equals the size of the array.
        queue = newQueue; //then our queue object becomes the copy with the doubled size
    }

//Dequeue is the exact same as the linked structure
    @Override
    public T dequeue(){
        if(isEmpty()){ //If the array is empty, throw an exception
            throw new NoSuchElementException("No queue");

        }
        T returnElement = queue[front]; //Create a copy of the data from the front
        front = nextIndex(front); //The next index becomes the new front
        size--; //size decrements
        return returnElement; //Return the data that was deleted
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    //Peek just returns the front's data
    public T first(){
        if(isEmpty()){//If it is empty, throw an exception
            throw new NoSuchElementException("Empty queue!");
        }
        return queue[front]; //We return the front's data
    }

    //Equals
    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ArrayQueue<?> that = (ArrayQueue<?>) o;
        if (this.size() != that.size()) {
            return false;
        }
        int thisCurrentIndex = this.front;
        int thatCurrentIndex = that.front;
        // Since this and that are the same size, this.size() can be used safely in the for loop
        for (int i = 0; i < this.size(); i++) {
            if (!Objects.equals(this.queue[thisCurrentIndex], that.queue[thatCurrentIndex])) {
                return false;
            }
            thisCurrentIndex = this.nextIndex(thisCurrentIndex);
            thatCurrentIndex = that.nextIndex(thatCurrentIndex);
        }
        return true;
    }

}
