public class Main {
    public static void main(String[] args) {
            //Create a stack of size 10
           Stack stack = new Stack(10);
           //Perform 4 repeats using the pusher and popper thread
           Popper popper = new Popper(4, stack);
           Pusher pusher = new Pusher(4, stack);
           //Creating Threads
           Thread popperThread = new Thread(popper);
           Thread pusherThread = new Thread(pusher);
           //Start the threads
           pusherThread.start();
           popperThread.start();


    }
}