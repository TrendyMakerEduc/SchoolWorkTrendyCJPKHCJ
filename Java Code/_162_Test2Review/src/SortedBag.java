public interface SortedBag<T extends Comparable<? super T>> extends Bag<T> {

    @Override
    boolean add(T element); //adds an element
    T removeFirst(); //removes the first item
    T removeLast(); //removes the last item
    T first(); //gets the first
    T last(); //gets the last
}