//Student Name: Daniel Trenholm
//Student Number: 201202966

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RegularQueue<E extends Comparable<E>> extends AbstractQueue<E> implements Queue<E> {

    public int size = 0;

    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < theData.size() && theData.get(currentIndex) != null;
            }

            @Override
            public E next() {
                return theData.get(currentIndex++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }



    public boolean enqueue(E customer){
        return offer(customer);
    }
    //Data Fields
    /**
     * The ArrayList to hold the data
     */
    public ArrayList<E> theData;

    /**
     * Construct the class without any capacity.
     */
    public RegularQueue() {
        theData = new ArrayList<>();
    }


public E get(int index){
        if(theData.isEmpty()){
            return null;
        }
        return theData.get(index);
}

    public int size() {
        return size;
    }

    /**
     * Construct the queue.
     *
     * @param cap is the capacity of the queue.
     */
    public RegularQueue(int cap) {
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

    public int getSize(){
        return size;
    }
    @Override
    public boolean offer(E e) {
        // Add the item to the heap.
        theData.add(theData.size(), e);
        size++;
        System.out.println(theData);
        return true;
    }


    @Override
    public E poll() {
        if (theData.isEmpty())
            return null;
        //Save the top of the heap
        E result = theData.get(0);
        //If only one item the remove it
        if (theData.size() == 1) {
            theData.remove(0);
            System.out.println(result);
            return result;
        }
        theData.remove(0);
        System.out.println(theData);
        size--;
        return result;


    }

    @Override
    public E peek() {
        return null;
    }

    /**
     * Retrieves and removes the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */

    private void swap(int i, int j) {
        E root = theData.get(i);
        theData.set(i, theData.get(j));
        theData.set(j, root);

    }

//    public static void main(String[] args) {
//        RegularQueue q = new RegularQueue();
//        q.offer(10);
//        q.offer(12);
//        q.poll();
//        q.offer(222);
//        q.offer(324);
//        q.poll();
//    }

}
