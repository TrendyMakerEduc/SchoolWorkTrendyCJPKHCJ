import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ArrayStack<T> implements Stack<T> {
    //Update to T

    private static final int DEFAULT_CAPACITY = 100;

    private T[] stack;
    private int top = 0;

    public ArrayStack(){
        this(DEFAULT_CAPACITY);
    }
@SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity){
        top = 0;
        stack = (T[]) new Object[initialCapacity];
    }
    public boolean push(T element){
        if(size() == stack.length){
            expandCapacity();
        }
        stack[top] = element;
        top++;
        return true;

    }

    public void expandCapacity(){
        T[] newStack = (T[]) new Object[stack.length * 2];
        for(int i = 0; i < stack.length; i++){
            newStack[i] = stack[i];
        }
        stack = newStack;
    }

    @Override
    public T pop(){
        if(isEmpty()){
            throw new NoSuchElementException("This is an empty stack");
        }
        T returnElement = stack[top - 1];
        stack[top-1] = null;
        top--;
        return returnElement;
    }

    @Override
    public T peek(){
        if(isEmpty()){
            throw new NoSuchElementException("This is an empty stack");
        }
        return stack[top-1];
    }

    public int size(){
        return top;
    }

    public boolean isEmpty(){
        return size() == 0;
    }
@Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        if(isEmpty()) {
        return builder.toString();
        }
        for(int i = 0; i < size(); i++){
            builder.insert(0, ", ");
            builder.insert(0, stack[i]);
        }
        return builder.toString();
    }

    public static String reverseString(String original){
        Stack<Character> characterStack = new ArrayStack<>();
        StringBuilder stringBuilder = new StringBuilder();

        //Add code here
        for(int i = 0; i < original.length(); i++){
            characterStack.push(original.charAt(i));
        }

        System.out.println(characterStack);
    return characterStack.toString();}

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ArrayStack<?> that = (ArrayStack<?>) o;
        return Arrays.equals(this.stack, 0, this.size(), that.stack, 0, that.size());
    }

    @Override
    public final int hashCode() {
        int result = Objects.hash(top);
        for (int i = 0; i < size(); i++) {
            result = result * 97 + Objects.hashCode(stack[i]);
        }
        return result;
    }


    public static void main(String[] args) {
        reverseString("hello");
    }

}
