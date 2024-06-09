
    //Queues are used for the first element in will be the first element deleted.
    // A priority Queue is an ADT that has the two following methods
    // Insertion: Inserts a new element, and Delete: Find, return and remove the minimum element
    // As in many ADT you can add more operations
    //First we create a list
    //We have two cases. when we are just adding an element, it would O(1)
    // But to find the highest priorty it is O(N)
    //If the list is sorted, then when we are inserting it is O(N)
    //If finding the highest priorty it is O(1)

    //We want to have something way better, called a Binary Heap
    //Binary Heap is the most popular implementation of this ADT

    //A heap is a binary tree that is completely filled with the possible exception of the bottom level

    //Usually we call priority queues heaps

    //THIS IS THE MAIN PROPERTY OF BINARY HEAPS
    //The left child is always 2 * i, and right child is 2 * i + 1 (for example, A's left child is B, right child is C
    //The parent is in position i / 2, and you always round down if halves
    //It is not a list, it is an Array



    import java.util.ArrayList;



    /**
     * The OPriorityQueue implements the Queue interface by building a heap in an ArrayList.
     * The heap is structured so that the “smallest” item is at the top.
     * @param <E> Type of element stored in the queue.
     */
    public class PriorityQueues<E extends Comparable<E>> extends AbstractQueue<E> implements Queue<E>{

        //Data Fields
        /** The ArrayList to hold the data */
        private ArrayList<E> theData;

        /**
         * Construct the class without any capacity.
         */
        public PriorityQueues(){
            theData = new ArrayList<>();
        }

        /**
         * Construct the queue.
         * @param cap is the capacity of the queue.
         */
        public PriorityQueues(int cap){
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
            //Add the line to the heap.
            theData.add(e);
            //child is the newly inserted line
            int child = theData.size() - 1;
            int parent = (child - 1) / 2;
            while (parent >= 0 && theData.get(parent).compareTo(theData.get(child) > 0){
                swap(parent, child);
                child = parent;
                parent = (child - 1) / 2;
            }
            return false;
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
    }

// The Heap-Order property allows operations to be performed quickly
    //To find the minimum element quickly, it needs to be at the root (parent)
    //The heap order property- for every node X, the key in the parent of X is smaller than (or equal to) the key in X,
    //with the exception of the root. this is applied PER LAYER, for ex: root is 13, left child is 21, and right child is 16

    //deleting is getting the element so we can use it.

    //REMEMBER EVERY TREE NEEDS TO BE COMPLETE WITH LEFT AND RIGHT CHILDS

    //TO insert an element X:
    //Create a hole in the next available location
    //If placing X in the hole violates the heap-order condition
         // Put the parent's hole in the hole, and X at the parent's position.
        // Otherwise place X in the hole
    // It continues until X can be place in a hole.


    // The time complexity of the insertion in the worst-case O(log N)
    //deleteMin
    //Finding the minimum is easy, but removing it is hard
    //When a minimum is removed, a hole is created
    //We should place the last element in the heap X in the hole
    //If we can place it, we're done otherwise
    //We slide the smaller children in the hole
    //We continue until X can be placed in the hole

    //We just add the element into the array just to make sure we have it in memory, if it doesn't violate we leave
    //it there