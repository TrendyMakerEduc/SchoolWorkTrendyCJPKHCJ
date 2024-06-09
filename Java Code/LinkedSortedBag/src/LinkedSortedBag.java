import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedSortedBag<T extends Comparable<? super T>> implements SortedBag<T> {
    private static final int DEFAULT_CAPACITY = 100;
    private static final int NOT_FOUND = -1;
    private T[] bag;
    private int rear;
    private Node<T> head;


    public LinkedSortedBag() {
        this(DEFAULT_CAPACITY);
    }


    @SuppressWarnings("unchecked")
    public LinkedSortedBag(int initialCapacity) {
        bag = (T[]) new Comparable[initialCapacity];
        rear = 0;
    }




    private Node<T> find(T element) {
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (element.compareTo(currentNode.getData()) <= 0) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }


    private Node<T> findInsertIndex(T element) {
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (element.compareTo(currentNode.getData()) <= 0) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }

        // Element must not belong
        return null;
    }

    @Override
    public boolean add(T element) {
        Node<T> newNode = new Node<>(element);
        Node<T> currentNode = head;
        while (currentNode != null) {
            if(head == null){
                head = newNode;
                return true;
            }
            else if (element.compareTo(currentNode.getData()) < 0) {
                currentNode = currentNode.getNext();
                  currentNode.setNext(currentNode);
                currentNode = newNode;
                return true;}
            else {
                //glitch here
                currentNode = currentNode.getNext();
            currentNode.setNext(newNode);
            return true;
        }

        }

        return false;
    }


    @Override
    public boolean remove(T element) {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty bag");
        }
        Node<T> index = find(element);
        if (index == null) {
            throw new NoSuchElementException(Objects.toString(element));
        }
        index = null;
        return true;
    }



    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty bag");
        }
        T returnElement = head.getData();
        Node<T> newHead = head.getNext();
        head = null;
        head = newHead;

        return returnElement;
    }

    @Override
    public T removeLast() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            if(head == null){
                return null;
            }
            else if (currentNode.getData().compareTo(currentNode.getNext().getData()) < 0) {
                currentNode = currentNode.getNext();}
            else {
                T returnElement = currentNode.getData();
                remove(currentNode.getData());
                return returnElement;
            }

    }return null;
    }

    @Override
    public T first() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty bag");
        }
        return head.getData();
    }

    @Override
    public T last() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            if(currentNode.getNext() == null){
                return currentNode.getData();
            }
        } return null;
    }

    @Override
    public boolean contains(T element) {
        return find(element) != null;
    }

    @Override
    public int count(T element) {
        int count = 0;
        for (T bagElement : this) {
            if (bagElement.compareTo(element) == 0) {
                count++;
            } else if (bagElement.compareTo(element) > 0) {
                return count;
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
    public Iterator<T> iterator() {
        Node<T> currentNode = head;
        int increment = 0;
        while(head != null){
            bag[increment] = currentNode.getData();
          currentNode = currentNode.getNext();

        }
        return bag;
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

class Node<T> {

    private T data;
    private Node<T> next;

    public Node() {
        this(null);
    }

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
