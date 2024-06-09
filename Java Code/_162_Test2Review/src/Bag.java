import java.util.Iterator;

public interface Bag<T> extends Iterable<T> {

    boolean add(T element); //Adding an element
    boolean remove(T element); //Removing an element
    boolean contains(T target); //Seeing if it contains the object
    int count(T target); //getting a count of the object that is in there
    boolean isEmpty(); //Checks if it is empty
    int size(); //Returns the size
    Iterator<T> iterator(); // Iterates through the bag
}