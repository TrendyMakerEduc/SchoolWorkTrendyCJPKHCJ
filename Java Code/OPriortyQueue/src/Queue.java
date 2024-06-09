
    public interface Queue<E> {

        // Javadoc comments within Queue.java file
        boolean enqueue(E element);
        E dequeue();
        E first();
        boolean isEmpty();
        int size();
    }

