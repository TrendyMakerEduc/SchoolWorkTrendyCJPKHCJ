public interface IndexedBag<T> extends Bag<T> {

    @Override
    boolean add(T element); //Adds
    boolean add(int index, T element); //Adds the element at the index
    T set(int index, T element); //Sets the index and puts the element there
    T get(int index); //Gets the item at that index
    T remove(int index);    // Different signature from the inherited remove
    int indexOf(T element); //Gets the index of the element
}
