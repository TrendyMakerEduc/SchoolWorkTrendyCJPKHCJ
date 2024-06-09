import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedStack<T> implements Stack<T> {

    private Node<T> top;
    private int size;

    public LinkedStack(){
        top = null;
        size = 0;
    }

    @Override
    public boolean push(T element) {
        Node<T> toPush = new Node<T>(element);
        toPush.setNext(top);
        top = toPush;
        size++;
        return true;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty stack");
        }
        T returnElement = top.getData();
        top = top.getNext();
        size--;
        return returnElement;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<T> currentNode = top;
        while (currentNode != null) {
            builder.append(currentNode.getData());
            builder.append(", ");
            currentNode = currentNode.getNext();
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LinkedStack<?> that = (LinkedStack<?>) o;
        if (this.size() != that.size()) {
            return false;
        }
        Node<?> thisCurrent = this.top;
        Node<?> thatCurrent = that.top;
        while (thisCurrent != null && thatCurrent != null) {
            if (!Objects.equals(thisCurrent.getData(), thatCurrent.getData())) {
                return false;
            }
            thisCurrent = thisCurrent.getNext();
            thatCurrent = thatCurrent.getNext();
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(size);
        Node<?> current = top;
        while (current != null) {
            result = result * 97 + Objects.hashCode(current.getData());
            current = current.getNext();
        }
        return result;
    }



    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty stack");
        }
        return top.getData();
    }
}
