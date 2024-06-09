public class StackADT {
    //We are seperating the what from the how. what it does and how to do it.
    //!! The stack is the interface !!

    //Solving a maze
    //Depth first search algorithm
    //Pick a path that is not visited yet, and keep going til we hit a dead end, until we find a valid
    //unvisited path.

    //The backtracking is handled by a stack. (same as undo in computers for example)
//    Add the start of the maze to the stack
//
//    While the stack is not empty
//    Get the top of the stack with a peek (current cell)
//    If the top is the end
//    done
//
//    If an unvisited neighbour of the current cell exists
//    Push the neighbour onto the stack
//
//    Otherwise, if no admissible neighbour exists
//    Pop from the stack
//
//    If the loop ever exists because of an empty stack, there is no solution


//    7.3. Interface
//    There are many possible ways one could implement a stack data structure
//
//    But, all implementations must be a stack
//
//    They must follow definition of what a stack ADT is
//
//    In Java, one can create an interface that defines what the operations of the stack ADT are
//
//            However, the interface only defines the what
//
//            Interfaces do not define the how
//
//    If someone wants to implement the how of a stack ADT, they implement the interface
//
//    The interface dictates what must be implemented
//
//            If the implementation does not implement the interface completely, a compile time error will occur
//
//            Ultimately, an interface is simply a list of abstract methods and relevant constants
//
//    Abstract methods are the method signature with no actual body
//
//    int someMethod(int a, int b);
//
//    No visibility modifier is included as it must be public
//
//    Relevant constants will be static final

//    7.4. Generics
//    The use of <T> is something new and not an idea discussed yet
//
//    This is probably best explained with an example
//
//    Imagine someone wanted to have a stack of type Integer
//
//    public boolean push(Integer element);
//
//    public Integer pop();
//
//…
//
//    Then, maybe someone else wants to make a stack of String objects
//
//    public boolean push(String element);
//
//    public String pop();
//
//…
//
//    Then maybe a stack of Friend objects
//
//    public boolean push(Friend element);
//
//    public Friend pop();
//
//…
//7.4.1. There has to be a Better Way!
//    There is — generics
//
//    <T> is a stand-in for a specific type that can be specified later when the stack is created
//
//    It can be thought of like a variable, but for a type
//
//    Although jumping ahead a little, consider the following example
//
//    ArrayStack is discussed in the following topic
//    This would require three unique interfaces (and implementations) for the stack

//    public class SomeClass {
//        public static void main(String[] args) {
//            Stack<Integer> myIntegerStack = new ArrayStack<Integer>();
//            Stack<String> myStringStack = new ArrayStack<String>();
//            Stack<Friend> myFriendStack = new ArrayStack<Friend>();
//        }
//    }
//    When creating an instance of the stack, the type is specified within the < and > symbols
//
//    This will be discussed more in the following topic
//
//    In the above example, with the use of generics
//
//    Three different stacks are created, each with a different type of object as its contents
//
//    Only one interface (and implementation) is needed for all three
//The inclusion of <Type> on the instantiation side is not actually needed as Java can infer the type. Going forward, for simplicity, Java’s diamond operator (<>) will be used, like so:
//
//    Stack<Integer> myIntegerStack = new ArrayStack<>();
//    Stack<String> myStringStack = new ArrayStack<>();
//    Stack<Friend> myFriendStack = new ArrayStack<>();
//    Warning
//
//    It is not possible to use primitive types (int, double, boolean, etc.) in generics. Instead, use the object version of the primitive type (Integer, Double, Boolean, etc).}

//8. ArrayStack
//    Having seen what a stack can do
//
//    It is time to start discussing how
//
//    There are a few implementation issues to consider
//
//    How is the data going to be stored?
//
//    How will the top of the stack be managed?
//
//            8.1. Implementing a Stack with an Array
//    Arrays are great for storing contiguous data
//
//            ../../_images/array.png
//    An array of size 10 storing references to six elements. The references to the six elements are stored within the array indices 0 – 5.
//
//    If an array is used for storing the data in the stack, how should the top of the stack be kept track of?
//
//    One way would be to have the top of the stack always be index 0
//
//    Pro — Always know where the top is
//
//    Con — Every push and pop requires all elements within the stack to be moved
//
//    If there are
//    elements in the stack, all must be moved
//
//    Another option is to have the top be the other end
//
//    Pro — No need to move anything for a push or pop
//
//    If there are
//    elements in the stack, none need to move
//
//    Con — Must keep track of which index the top currently is
//
//    Although both strategies work, the latter will be used since the push and pop operations require less work
//
//8.1.1. Implementation Issues
//    An array will be used to hold the data
//
//    The top will always refer to the next available spot in the array
//
//    Due to zero based indexing, the value of top will also correspond to the number of elements in the stack
//
//    All push operations will happen at the top index and require an update to top
//
//    All pop operations will happen at the top - 1 index and require an update to top
//
//            ../../_images/arraystack0.png
//    An example ArrayStack containing four elements. Note the value stored in top refers to the next available spot in the array — where the next pushed element would go. Also notice that the value in top corresponds to the number of elements currently in the stack.
//8.1.1. Implementation Issues
//    An array will be used to hold the data
//
//    The top will always refer to the next available spot in the array
//
//    Due to zero based indexing, the value of top will also correspond to the number of elements in the stack
//
//    All push operations will happen at the top index and require an update to top
//
//    All pop operations will happen at the top - 1 index and require an update to top
//
//            ../../_images/arraystack0.png
//    An example ArrayStack containing four elements. Note the value stored in top refers to the next available spot in the array — where the next pushed element would go. Also notice that the value in top corresponds to the number of elements currently in the stack.
//
//            ../../_images/arraystack1.png
//    The state of the ArrayStack after an element was pushed. Note that the value of top was increased by one such that it refers to the next available spot in the array.
//
//            ../../_images/arraystack2.png
//    The state of the ArrayStack after an element was popped. Note that the value of top was decreased by one.
//
//            ../../_images/arraystack3.png
//    The state of the ArrayStack after another element was popped. Note that, again, the value of top was decreased by one such that it refers to the next available spot in the array.
//
//            8.2. Implementation
//    The ArrayStack class will implement the Stack interface
//
//    This ensures that the ArrayStack implementation actually implements the operations required to make it a Stack
//
//                    The ArrayStack is a Stack
//
//                    Anything expecting a Stack will be happy getting an ArrayStack since it is a stack
//
//                    Note line 10 in the below example where it specifies that the ArrayStack<T> implements Stack<T>
//
//    The fields are
//
//    An integer top to keep track of where the top of the stack is
//
//    The stack array to hold the elements in the stack
//
//    Since the ArrayStack is generic its type is T
//
//    public class ArrayStack<T> implements Stack<T> {
//
//        private static final int DEFAULT_CAPACITY = 100;
//        private T[] stack;
//        private int top;
//        Warning
//
//        When starting to implement an interface, the IDE may produce a error saying that the interface is not implemented. This is because Java is expecting all abstract methods from the interface to be implemented. This error will go away once all abstract methods are implemented.
//
//../../_images/warning_implement.png
//        Example of the error IntelliJ will produce if not all abstract methods from the Stack interface are implemented.
//
//                8.2.1. Constructors
//        Like the ContactList example, there will be two constructors
//
//        One making use of the default value
//
//        The other to create an array of a specified starting capacity
//
//        /**
//         * Create an empty ArrayStack of the default capacity.
//         */
//        public ArrayStack() {
//            this(DEFAULT_CAPACITY);
//        }
//
//        /**
//         * Create an empty ArrayStack with the specified capacity.
//         *
//         * @param initialCapacity Starting capacity of the fixed length array.
//         */
//        @SuppressWarnings("unchecked")
//        public ArrayStack(int initialCapacity) {
//            top = 0;
//             Generic types cannot be instantiated, so an array of type "Object" is created that is then cast to type T.
//             This does generate a compile time warning that is being suppressed with the @ annotation.
//            stack = (T[]) new Object[initialCapacity];
//        }
//        This is making use of constructor chaining
//
//        Notice that the array being created is an array of type Object that is cast to the generic type T
//
//        Java forbids creating a generic array
//
//        Details are outside the scope of this topic and likely class
//
//        When doing this, Java will warn that there is now an unchecked type conversion
//
//        Java can’t guarantee that the cast will work right
//
//        This can be ignored, however, the warning may be suppressed by adding the following before the constructor
//
//        @SuppressWarnings("unchecked")
//
//        Creating an instance Stack<Integer> s = new ArrayStack<>(5);
//
//../../_images/arraystack_empty.png
//        A visualization of an ArrayStack created with a starting capacity of 5. The instance s could have been created with Stack<Integer> s = new ArrayStack<>(5);. Although the type Integer is specified in the declaration, there is nothing within the figure to indicate that the elements within the stack would be of type Integer.
//
//                8.2.2. Push
//        @Override
//        public boolean push(T element) {
//            if (size() == stack.length) {
//                expandCapacity();
//            }
//            stack[top] = element;
//            top++;
//            return true;
//        }
//
//        /**
//         * Doubles the size of the stack array container and copy the contents from the old array to the new array.
//         */
//        @SuppressWarnings("unchecked")
//        private void expandCapacity() {
//            T[] newStack = (T[]) new Object[stack.length * 2];
//            for (int i = 0; i < stack.length; i++) {
//                newStack[i] = stack[i];
//            }
//            stack = newStack;
//        }
//        Notice the @Override annotation before the push method
//
//        This tells the compiler that the method push from the interface is being overridden
//
//                It is not required to include this annotation, but it can help eliminate errors
//
//        Like the ContactList example, a private expandCapacity method is included
//
//        If trying to push to a stack that has a full stack array, expandCapacity is called
//
//        The private expandCapacity method will
//
//        Make a new and larger array
//
//        Copy the contents of the old stack array to the new array
//
//        Set the field stack to reference the new larger array
//
//8.2.3. Pop and Peek
//        The pop and peek methods will be similar, except peek leaves the stack unchanged
//
//        @Override
//        public T pop() {
//            if (isEmpty()) {
//                throw new NoSuchElementException("Empty stack");
//            }
//            T returnElement = stack[top - 1];
//            stack[top - 1] = null;
//            top--;
//            return returnElement;
//        }
//
//        @Override
//        public T peek() {
//            if (isEmpty()) {
//                throw new NoSuchElementException("Empty stack");
//            }
//            return stack[top - 1];
//        }
//8.2.3.1. Exceptional Situations
//        What should happen if someone tries to pop or peek from an empty stack?
//
//        Ignore it and do nothing?
//
//        Crash the program?
//
//        Something else?
//
//        What should be done in this situation is not up to those implementing the stack
//
//        As a rule, one should follow the principal of least surprise
//
//        Consider someone using the ArrayStack class — should they ever expect to get nothing back when requesting the top?
//
//        No — the pop and peek methods explicitly say they return a value
//
//        Perhaps it’s more reasonable to assume that the request was invalid in the first place
//
//        An exceptional thing happened
//
//        Remember, the ArrayStack is designed to be general purpose and can be used in many situations
//
//        What should be done when calling pop or peek on an empty stack will depend on the specific situation
//
//        The point is, when implementing the ArrayStack, it is not possible to know what should be done in the exceptional situation
//
//        What can be done, however, is to throw an exception to inform the user that something exceptional happened
//
//        Then it is up to the user to deal with the exceptional situation as they see fit
//
//8.2.4. size and isEmpty
//        @Override
//        public int size() {
//            return top;
//        }
//
//        @Override
//        public boolean isEmpty() {
//            return size() == 0;
//        }
//        Notice how, because of zero based indexing, top is both
//
//        The index of the next available spot in the stack array
//
//        The number of elements in the stack
//
//8.2.5. toString
//        @Override
//        public String toString() {
//            StringBuilder builder = new StringBuilder();
//            for (int i = 0; i < size(); i++) {
//                builder.insert(0, ", ");
//                builder.insert(0, stack[i]);
//            }
//            return builder.toString();
//        }
//        Ideally the top element in the stack would be the left most element in the string representation of a stack
//
//        However, index 0 in the stack array is the bottom of the stack
//
//        For this reason, each element is inserted to the front of the string builder
//
//8.2.6. equals and hashCode
//        @Override
//        public final boolean equals(Object o) {
//            if (this == o) {
//                return true;
//            }
//            if (o == null || getClass() != o.getClass()) {
//                return false;
//            }
//            ArrayStack<?> that = (ArrayStack<?>) o;
//            return Arrays.equals(this.stack, 0, this.top, that.stack, 0, that.top);
//        }
//
//        @Override
//        public final int hashCode() {
//            int result = Objects.hash(top);
//            for (int i = 0; i < size(); i++) {
//                result = result * 97 + Objects.hashCode(stack[i]);
//            }
//            return result;
//        }
//        Two ArrayStack objects are considered equal if the contents of the stack arrays are equal
//
//        Note
//
//        Like the other methods in the class, the @Override annotation on the toString, equals, and hashCode methods tell the compiler that the method is overriding one in another class. However, unlike push, pop, peek, size, and isEmpty methods, the overridden methods are not from the Stack interface, but the Object class. All classes inherit from the Object class which has implementations of the toString, equals, and hashCode methods.
//
}