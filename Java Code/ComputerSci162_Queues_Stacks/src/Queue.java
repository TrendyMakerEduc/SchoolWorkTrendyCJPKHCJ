interface Queue<T>{
    //Add something
    boolean enqueue(T element);
// Delete something
    T dequeue();
    //Check the front
    T first();
    //Check if empty
    boolean isEmpty();
    //Check size
    int size();

}
