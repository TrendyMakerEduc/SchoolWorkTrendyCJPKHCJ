import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ArrayIndexedBag<T> implements IndexedBag<T>{
    private static final int DEFAULT_CAPACITY = 100; //The default capacity is set to 100
    private static final int NOT_FOUND = -1; //Returns -1 if the item is not found
    private T[] bag; //Just an array of the generic type T
    private int rear; //Keeps track of the end of the bag

    //The constructor is the same as before, using this
    public ArrayIndexedBag(){
        this(DEFAULT_CAPACITY);
    }

    //We also create a constructor for the indexed bag to define the capacity

    @SuppressWarnings("unchecked")
    public ArrayIndexedBag(int initalCapacity){
        bag = (T[]) new Object[initalCapacity]; //We create an array of the type generic with this line of code
        rear = 0; //We set the rear equal to 0
    }

    //For an array indexed bag, we have private methods, called shiftLeft, and shiftRight.
    //Shift left shifts an array down towards index 0.
    //Shift right shifts an array towards the rear

    private void shiftLeft(int start){
        for(int i = start; i < rear - 1; i++){ //We do this with a for loop, where i < rear
            //And then we simply set bag at the end to be the bag at the index + 1
            bag[i] = bag[i + 1];
        }
        bag[rear - 1] = null; //Then from the start to rear, it has been shifted down one, this means the rear, has become null
    }

    //Shift right is the complete opposite, where we decrement, since we are moving everything to the right 1
    private void shiftRight(int start){
        for(int i = rear; i > start - 1; i++){ //We do this with a for loop, where i > start
            //And then we simply set bag at the start to be the bag at the index - 1
            bag[i] = bag[i - 1];
        }
        bag[start] = null; //Then from the start to rear, it has been shifted down one, this means the rear, has become null
    }
    //Iterators are important, as the iterate through the elements in the array
    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(bag, size());
    }

    //Adding is very simple, we just make sure the index is in bounds, check if the size is the bag.length, to make a copy, and then shiftRight on the index.
    //It has two methods, and the other method will return and factor that same function into a function which takes our program, which keeps
    //track of rear, and adds element to it. First, the major method
    @Override
    public boolean add(int index, T element){
        if(index < 0 || index > size()){ //If the index is less then 0 or greater then size, throw an exception
            throw new IndexOutOfBoundsException(index);
        }
        if(size() == bag.length){ //If the size is the bag.length, we want to make bag have a capacity doubled, through this simple function
            bag = Arrays.copyOf(bag, bag.length * 2);
        }
        shiftRight(index); //We shift the index right
        bag[index] = element; //This new position becomes the element
        rear++; //rear keeps track of this shift
        return true; //Returns the operation as true signifying its success
    }
    //And then we simply call this function
    @Override
    public boolean add(T element){
        return add(rear, element); //The index will always be rear
    }

    //Removing follows the same strategy, with two methods
    @Override
    public T remove(int index){
        if(index < 0 || index >= size()){ // Throws an exception
            throw new IndexOutOfBoundsException(index);
        }
        T returnElement = bag[index]; //We take the info and return it as deleted
        shiftLeft(index); //We shift the whole index to left before the index
        rear--; //The rear decrements by 1
        return returnElement; //We return the return element
    }

    //And for the second remove, we want the element's information instead
  @Override
    public boolean remove(T element){
        if (isEmpty()){ //if it is an empty bag, throw an exception
            throw new NoSuchElementException("Empty bag!");
        }
        //If indexOf throws an exception, this method propagates it
      int removeIndex = indexOf(element); //We grab the index of the element
      remove(removeIndex); //We remove the element at the index with the other remove method
      return true; //returns true if successful
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException(index);
        }
        T toReturn = bag[index];
        bag[index] = element;
        return toReturn;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException(index);
        }
        return bag[index];
    }

    private int find(T element) {
        int searchIndex = 0;
        for (T bagElement : this) {
            if (Objects.equals(bagElement, element)) {
                return searchIndex;
            }
            searchIndex++;
        }
        return NOT_FOUND;
    }

    @Override
    public int indexOf(T element) {
        if (!contains(element)) {
            throw new NoSuchElementException(Objects.toString(element));
        }
        return find(element);
    }

    @Override
    public boolean contains(T element) {
        return find(element) != NOT_FOUND;
    }

    @Override
    public int count(T element) {
        int count = 0;
        for (T bagElement : this) {
            if (bagElement.equals(element)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return rear;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T bagElement : this) {
            builder.append(bagElement);
            builder.append(", ");
        }
        return builder.toString();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Bag)) {
            return false;
        }
        Bag<T> that = (Bag<T>) o;
        if (this.size() != that.size()) {
            return false;
        }
        for (T element : this) {
            if (this.count(element) != that.count(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(rear);
        for (T element : this) {
            result += Objects.hashCode(element);
        }
        return result;
    }
}
