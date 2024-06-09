//Name  : Daniel Trenholm
//ID    : 201202966
//Email : x2012cml@stfx.ca

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.NoSuchElementException;

/**
 * Linked Priority Queue. This implementation will:
 * 1. Do the linear search on the enqueue; constant time dequeue
 * 2. Ties in priority are added after all equal priorities.
 *
 * @param <T> Type of elements in the priority queue.
 */
public class LinkedPriorityQueue<T> implements PriorityQueue<T> {

    /**
     * Two LinkedPriorityQueues are considered equal if all elements/data in the two queues are considered equal, along
     * with their corresponding priorities.
     *
     * @param o The thing to check if this is equal to
     * @return True if they are equal, false otherwise.
     */


        private PriorityNode<T> front; //the front of the line
        private PriorityNode<T> rear; //the back of the line
        private int size; //Keeps track of how many objects are in the queue

        //Creating an empty LinkedQueue, which sets front rear to null and size to 0.
        public LinkedPriorityQueue(){
            front = null;
            rear = null;
            size = 0;
        }

    @Override
    public boolean enqueue(T element, int priority){
        PriorityNode<T> current; //Current node
        PriorityNode<T> toEnqueue = new PriorityNode<>(element, priority, null);//Start by creating an empty Node passing the data.
        //This is very simple. If it is empty, add to the front, if not, add the next node to the current node, and set rear = greatestNode
        PriorityNode<T> greatestNode = toEnqueue; //greatest Node is measured as toEnqueue
        if(isEmpty() || front == null){ // if front is null or is empty
            front = toEnqueue; //front equals toEnqueue
        }
        if(front != null && priority < front.getPriority()){ //If front is not null and priority is less then front's priority
            toEnqueue.setNext(front); //To Enqueue sets its next node as front
            front = toEnqueue; //toEnqueue is the new front
        }
        else{ // else

current = front; //for iterating
        while(current != null){


       if(greatestNode.getPriority() > current.getPriority()){ //This method is for pushing the bigger nodes down
          PriorityNode<T> copy = greatestNode; //We make a copy of greatest node
          greatestNode = current; //greatest node is current so we can create a feedback loop
            current.setNext(copy); //We set the next node for current to be greatestNode
       }
            current = current.getNext(); //Iterate to next current linked element

        }}


        //Either way, we must set a new rear. So that gets set toEnqueue
        rear = greatestNode;
        size++; //Keeping track of the linked structure, size increments
        return true; //return true if added correctly
    }


    public PriorityNode<T> find(T element){
        PriorityNode<T> current = front;
        while(current != null){
            if(current.getData() == element){
                return current;
            }
            else{
                current.getNext();
            }
        }
        return null;
    }
    public boolean contains(T element){
            return find(element) != null;
    }

        //Enqueue is a method for adding to the back of the line
        @Override
        public boolean enqueue(T element){
            PriorityNode<T> toEnqueue = new PriorityNode<>(element, 0, front); //Start by creating an empty Node passing the data. Priority 0 = a non check. still runs the dequeue the same, unless priority is higher
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LinkedPriorityQueue<?> that = (LinkedPriorityQueue<?>) o;
        if (this.size != that.size) {
            return false;
        }
        PriorityNode<T> thisCurrent = (PriorityNode<T>) this.front;
        PriorityNode<T> thatCurrent = (PriorityNode<T>) that.front;
        while (thisCurrent != null) {
            if (thisCurrent.getPriority() != thatCurrent.getPriority() ||
                    !thisCurrent.getData().equals(thatCurrent.getData())) {
                return false;
            }
            thisCurrent = thisCurrent.getNext();
            thatCurrent = thatCurrent.getNext();
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(size);
        PriorityNode<T> current = front;
        while (current != null) {
            result = result * 97 + Objects.hash(current.getPriority(), current.getData());
            current = current.getNext();
        }
        return result;
    }
    @Override
    public String toString(){
            StringBuilder builder = new StringBuilder();
            PriorityNode<T> current = front;
            while(current != null){
                builder.append("(");
                builder.append(current.getData());
                builder.append(", ");
                builder.append(current.toString());
                builder.append(")  ");
                current = current.getNext();

            }
            return builder.toString();
    }

    private static class PriorityNode<T> {

        private final T data;
        private final int priority;
        private PriorityNode<T> next;

        private PriorityNode(T data, int priority, PriorityNode<T> next) {
            this.data = data;
            this.priority = priority;
            this.next = next;
        }

        private T getData() {
            return data;
        }

        private int getPriority() {
            return priority;
        }

        private PriorityNode<T> getNext() {
            return next;
        }

        private void setNext(PriorityNode<T> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "(p:" + String.valueOf(priority) + ", d:" + data.toString() + ")";
        }
    }
}