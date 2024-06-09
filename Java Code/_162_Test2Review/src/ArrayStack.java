import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ArrayStack<T> implements Stack<T> {
    private static final int DEFAULT_CAPACITY = 100; // This is a default size of the stack
    private T[] stack; // A collection of items for storing the stack.
    private int top; //This keeps track of what number in the array the stack returns, therefore incrementing while adding and decrementing while popping

    //Constructor with no passed parameters, therefor uses default size.
    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    //With this constructor, we create our own capacity size
    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity) {
        top = 0; // We initalize top to be 0, because it is still an empty stack.
        //Generic types cannot be instantiated, so an array of type Object is created with the generic in brackets beforehand
        stack = (T[]) new Object[initialCapacity];
    }

    //Size function which returns the size of the stack
    public int size() {
        return top; //We return the top because the top will always be the last array integer
    }

    //The push function for an array stack
    @Override
    public boolean push(T element) {
        if (size() == stack.length) { //If the returned size is equal to the stacks length...
            expandCapacity(); //We expand the capacity
        }
        stack[top] = element; //The top element will become the element
        top++; //We increment the array to the next available slot
        return true; //Return true that the push function was successful
    }

    // Now we define expandCapacity, which we make a new stack, use a for loop to copy its elements to the new stack, and stack becomes the newStack
    @SuppressWarnings("unchecked")
    private void expandCapacity() {
        T[] newStack = (T[]) new Object[stack.length * 2]; // Remember, since T cannot be instantiated, we must define the new Object array with T
        for (int i = 0; i < stack.length; i++) { //A simple for loop taking in the length of the stack
            newStack[i] = stack[i]; //newStack copies stack
        }
        stack = newStack; //Finally, the stack becomes the new stack.
    }

    //Pop and peek are very similar, except for pop we are setting to null and decrementing top, while returning the copy of the element to show what was deleted
    //Peek just returns the stack top.. (Remember stack top is top - 1 regardless!)

    @Override
    public T pop(){
        if(isEmpty()){ //If the stack is empty, throw a NoSuchElementException
            throw new NoSuchElementException("Empty Stack!");
        }
        T returnElement = stack[top - 1]; //Return element is equal to top
        stack[top - 1] = null; //The stack top becomes null
        top--; //Top is reduced by 1
        return returnElement; //Return a copy to show what was deleted
    }

    @Override
    public T peek(){
        if(isEmpty()){ //If the stack is empty, throw a NoSuchElementException
            throw new NoSuchElementException("Empty Stack!");
        }
        return stack[top - 1]; //Very simply, we just return the stack top (which is top - 1)
    }

    //The is empty method checks if size() == 0
    @Override
    public boolean isEmpty(){
        return size() == 0;
    }

    //ToString requires using StringBuilder, which is very simple
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder(); //We create the StringBuilder object
        for(int i = 0; i < size(); i++){ //Use a for loop to insert a comma and then the stack object for each iteration
            builder.insert(0, ", "); //Inserting comma.
            builder.insert(0, stack[i]); //Inserting stack object
        }
        return builder.toString(); //returns builder.toString to make a string representation
    }

    //Equals is similar to equals, except we change the ending a little bit
    @Override
    public final boolean equals(Object o){
        if(this == o){ //If this == the object, return true
            return true;
        }
        if(o == null || getClass() != o.getClass()){ // If the object is null or the class is not the same, return false
            return false;
        }
        ArrayStack<?> that = (ArrayStack<?>) o; //Arraystack that = Arraystack o
        return Arrays.equals(this.stack, 0, this.size(), that.stack, 0, that.size());//Creates a distinct this and that equals using Arrays
    }

    @Override
    public final int hashCode(){ //Creating the hashCode
        int result = Objects.hash(top); // result = Objects! remember Objects.hash, and hash the top
        for(int i = 0; i < size(); i++){ //A simple for loop using size
            result = result * 97 + Objects.hashCode(stack[i]); //The result is result times a prime number + Objects.hashCode on the stack object
        }
        return result;
    }

}
