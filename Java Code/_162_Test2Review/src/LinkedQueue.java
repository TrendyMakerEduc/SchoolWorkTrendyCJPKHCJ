import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Queue<T> {
    private Node<T> front; //the front of the line
    private Node<T> rear; //the back of the line
    private int size; //Keeps track of how many objects are in the queue

    //Creating an empty LinkedQueue, which sets front rear to null and size to 0.
    public LinkedQueue(){
        front = null;
        rear = null;
        size = 0;
    }

    //Enqueue is a method for adding to the back of the line
    @Override
    public boolean enqueue(T element){
        Node<T> toEnqueue = new Node<>(element); //Start by creating an empty Node passing the data.
        //This is very simple. If it is empty, add to the front, if not, add the next node to the rear, and set rear = toEnqueue
        if(isEmpty()){
            front = toEnqueue; //Our front node becomes the new node if it is empty
        } else{
            rear.setNext(toEnqueue); //Rear sets the next node toEnqueue
        }
        //Either way, we must set a new rear. So that gets set toEnqueue
        rear = toEnqueue;
        size++; //Keeping track of the linked structure, size increments
        return true; //return true if added correctly
    }
  //Dequeue and first are one and the same, but in dequeue, we need to do a double check to isEmpty, since we are removing
  @Override
  public T dequeue(){
        if(isEmpty()){ //If the structure is empty, throw an exception
            throw new NoSuchElementException("Empty queue!");
        }
        T returnElement = front.getData(); //We create a copy of front's data
        front = front.getNext(); //This effectively deletes the previous node
        size--; //Size is reduced by one
        //Now we check if it is empty again, because if it is, rear must be set to null
        if(isEmpty()){
            rear = null; //rear becomes nothing
        }
        return returnElement; //We then return the data that we just deleted to show what is gone
  }

  //Peek just returns the front's data
    public T first(){
        if(isEmpty()){//If it is empty, throw an exception
            throw new NoSuchElementException("Empty queue!");
        }
        return front.getData(); //We return the front's data
    }

    //Is empty and size are just the same as before


    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
