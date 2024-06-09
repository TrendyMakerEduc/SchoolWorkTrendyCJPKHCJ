//Student Name: Daniel Trenholm
//Student Number: 201202966

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Iterator;

public class PriortyMin<E extends Comparable<E>> extends AbstractQueue<E> implements Queue<E>
{

    /**
     * The OPriorityQueue implements the Queue interface by building a heap in an ArrayList.
     * The heap is structured so that the “smallest” item is at the top.
     * @param //<E> Type of element stored in the queue.
     */


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
    private int size = 0;

    /**
     * Construct the class without any capacity.
     */
    public PriortyMin() {
        theData = new ArrayList<>();
    }



    @Override
    public int size() {
        return size;
    }

    /**
     * Construct the queue.
     *
     * @param cap is the capacity of the queue.
     */
    public PriortyMin(int cap) {
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
        // Add the item to the heap.
        theData.add(e);
        //child is the newly inserted item.
        int child = theData.size() - 1;
        int parent = (child - 1) / 2;
        while (parent >= 0 && theData.get(parent).compareTo(theData.get(child)) > 0) {
            swap(parent, child);
            child = parent;
            parent = (child - 1) / 2;
        }
        return false;
    }
    public E get(int index){
        if(theData.isEmpty()){
            return null;
        }
        return theData.get(index);
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
        //Return the last item from the ArrayList and place it into the first position
        theData.set(0, theData.remove(theData.size() - 1));
        //The parent starts at the top
        int parent = 0;
        while (true) {
            int leftChild = 2 * parent + 1;
            if (leftChild >= theData.size())
                break; //out of heap
            int rightChild = leftChild + 1;
            int minChild = leftChild; //assume leftChild is smaller
            //see whether rightChild is smaller
            if (rightChild < theData.size() && theData.get(leftChild).compareTo(theData.get(rightChild)) > 0) {
                minChild = rightChild;
            }
            //assert: minChild is the index of the smaller child
            //move smaller child if necessary
            if (theData.get(parent).compareTo(theData.get(minChild)) > 0) {
                swap(parent, minChild);
                parent = minChild;
            } else { //heap property restored
                break;
            }
        }
        System.out.println(result);
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

    // To heapify a subtree rooted with node i which is
    // an index in arr[].Nn is size of heap
//    public void heapify(Customer Customer[], int i) {
//
//        int largest = i; // Initialize largest as root
//        int left_child = 2 * i + 1; // left child = 2*i + 1
//        int right_child = 2 * i + 2; // right child = 2*i + 2
//         Left Child is larger than root
//        if (left_child > theData.size() && theData.get(largest).compareTo(theData.get(left_child)) > 0)
//            largest = left_child;
//        Right child is larger than root
//        if (right_child > theData.size() && theData.get(largest).compareTo(theData.get(right_child)) > 0)
//            largest = right_child;
//         If the largest is not the root
//        if (theData.get(largest).compareTo(theData.get(i)) <= i) {
//             Recursively heapify the affected sub-tree
//            heapify(Customer, largest);
//        }



        public static void main(String[] args) {
            PriortyMin max = new PriortyMin();
            max.offer(16);
            max.offer(25);
            max.offer(26);
            max.offer(27);
            max.offer(15);
            max.offer(14);
            max.offer(13);
            max.offer(12);
            max.poll();
            max.poll();
            max.poll();
            System.out.println(max);
        }
}



