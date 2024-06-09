//Implements Runnable for the Thread interface. Producer creates a random int
class Pusher implements Runnable {
    private Stack stack;
    private int repeats;

    public Pusher(int repeats, Stack stack) {
        this.stack = stack;
        this.repeats = repeats;
    }

    @Override
    public void run() {
        int start = 0;
        try {
            while (start < repeats) {
                int data = (int) (Math.random() * 100);
                stack.push(data);
                Thread.sleep(3000);
                start++;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
