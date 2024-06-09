public class ArrayStack<E> implements Stack<E> {

    private static final int DEFAULT_CAPACITY = 100;
    private E[] stack;
    private int top;

    public ArrayStack(){
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int capacity){
        stack = stack[capacity];
    }




}
