import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedStack<T> implements Stack<T> {
    private Node<T> top; // The top of the linked stack
    private int size; //This is to keep track of how many objects are in the collection


    //We nest the node class in the LinkedStructure so that we can only use this certain
    //Node in this class

    /**
     * A node class for a singly linked structure. Each node contains a nullable reference to data of type T, and a
     * reference to the next/subsequent/successor singly linked node, which may be a null reference.
     *
     * @param <T> Type of the data being stored in the node.
     */
    private static class Node<T> {

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
    //Creating an empty Linked Stack
    public LinkedStack(){
        top = null;
        size = 0;
    }

    //A push method that adds an element to the stack.
    @Override
    public boolean push(T element){
        Node<T> toPush = new Node<T>(element); //This creates the element to push, contained in a Node
        toPush.setNext(top); //We are setting the next element to push on top of the stack;
        top = toPush; //We are setting the top to equal the Node
        size++; //Increment the size of the linked structure
        return true; //If it is successful. return true
        //Notice that this is just adding to the front of a linked structure
    }

    //Pop and peek are still similar, with the top.getData function
    @Override
    public T pop(){
        if(isEmpty()){ //If the stack is empty, throw an exception
            throw new NoSuchElementException("Empty stack!");
        }
        T returnElement = top.getData(); //Return the data of the top, so we know what to delete.
        top = top.getNext(); //Return the next node from top, removing the node in the garbage collection.
        size--; //size of stack decrements
        return returnElement; //Return the data that was deleted
    }

    @Override
    public T peek(){
        //very similar, except we only call the data from the top.
        if(isEmpty()){ //If the stack is empty, throw an exception
            throw new NoSuchElementException("Empty Stack!");
        }
        return top.getData(); //We just return the data from the top of the linked structure
    }

    //Size and isEmpty are the same as an ArrayStack
    @Override
    public boolean isEmpty(){
        return size() == 0; //Return true if size is 0
    }

    @Override
    public int size(){
        return size; //Notice we use the int size, instead of top's number on an arrayStack
    }

    //toString still uses a stringbuilder, but must initiate the top.
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder(); //Initialize the StringBuilder
        Node<T> currentNode = top; //Set the current node to top
        while(currentNode != null){ //While the current node is null
            builder.append(currentNode.getData()); //Append the data from the current node
            builder.append(", "); //Insert commas for readability
            currentNode = currentNode.getNext(); //Get the next node
        }
        return builder.toString(); //return the builder to string.
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


}
