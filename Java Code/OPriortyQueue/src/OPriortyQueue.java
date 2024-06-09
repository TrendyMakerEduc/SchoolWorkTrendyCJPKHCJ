import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * The OPriorityQueue implements the Queue interface by building a heap in an ArrayList.
 * The heap is structured so that the “smallest” item is at the top.
 * @param <E> Type of element stored in the queue.
 */
public class OPriorityQueue<E extends Comparable<E>> extends AbstractQueue<E> implements Queue<E>{

    //Data Fields
    /** The ArrayList to hold the data */
    private ArrayList<E> theData;

    /**
     * Construct the class without any capacity.
     */
    public OPriorityQueue(){
        theData = new ArrayList<>();
    }

    /**
     * Construct the queue.
     * @param cap is the capacity of the queue.
     */
    public OPriorityQueue(int cap){
        if (cap < 1)
            throw new IllegalArgumentException();
        theData = new ArrayList<>(cap + 1);
    }
    /**
     * Inserts the specified element into this queue if it is possible to do
     * so immediately without violating capacity restrictions.
     * When using a capacity-restricted queue, this method is generally
     * preferable to {@link #add}, which can fail to insert an element only
     * by throwing an exception.
     *
     * @param e the element to add
     * @return {@code true} if the element was added to this queue, else
     * {@code false}
     * @throws ClassCastException       if the class of the specified element
     *                                  prevents it from being added to this queue
     * @throws NullPointerException     if the specified element is null and
     *                                  this queue does not permit null elements
     * @throws IllegalArgumentException if some property of this element
     *                                  prevents it from being added to this queue
     */
    @Override
    public boolean offer(E e) {


    }
// Need to work on this one
    private E offer(E QueueInsertion, E item){

        if(QueueInsertion.compareTo(item) < item.compareTo(QueueInsertion) && theData.get(i - 1) != null){


        }

    }
    /**
     * Retrieves and removes the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    @Override
    public E poll() {
    }

    public int size(){
        return theData.size();
    }

    public E element(E item){

    }

    public E peek(){
        if(isEmpty()) {
            throw new NoSuchElementException("There is no elements in this queue")
        }

        return theData.get(0);
    }

    public E getNext(int index){
        if(theData.get(index + 1) != null){
            return theData.get(index + 1);
        }
    }






}