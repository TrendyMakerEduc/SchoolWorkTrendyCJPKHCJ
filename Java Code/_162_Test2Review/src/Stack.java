public interface Stack<T> {
    boolean push(T element); // This is for placing an item on the stack
    T pop(); // This is for removing an item on a stack
    T peek(); // This is for checking what is on the top of the stack
    boolean isEmpty(); // A simple function for checking if the stack is empty based on size
    int size(); //This returns how many total items are in the stack

}
