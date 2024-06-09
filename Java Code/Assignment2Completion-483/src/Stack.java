import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Stack {
    //Decided to use a synchronized keyword while using the wait() and notifyAll() functions
    //To create a synchronized producer consumer model. It implements a basic ArrayList stack
    private static Lock lock = new ReentrantLock();
    private static Condition newPush = lock.newCondition();

    private List<Integer> data = new ArrayList<>();
    private int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public void push(int item) throws InterruptedException {
       lock.lock();

        try {
           while (data.size() >= capacity) {
               newPush.await(); // Wait if the stack is full
           }
           data.add(item);
           System.out.println("Produced: " + item);
           newPush.signalAll();
        } catch(InterruptedException ex){
           ex.printStackTrace();
       }
        finally {
        lock.unlock();
        }
    }

    public void pop() throws InterruptedException {
        lock.lock();
        try {
            while (data.isEmpty()) {
                newPush.await(); // Wait if the stack is empty
            }
            int item = data.remove(data.size() - 1);
            System.out.println("Consumed: " + item);
            newPush.signalAll(); // Notify waiting producers
        } catch(InterruptedException ex){
            ex.printStackTrace();
        } finally {
        lock.unlock();
        }
    }
}
