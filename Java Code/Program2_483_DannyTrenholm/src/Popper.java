//Implements Runnable for the Thread interface. Consumer uses the loaded stack and pops the stack for data
class Popper implements Runnable {
    private Stack stack;
    private int repeats;

    public Popper(int repeats, Stack stack) {
        this.stack = stack;
        this.repeats = repeats;
    }

    @Override
    public void run() {
        int start = 0;
        try {
            while (start < repeats) {
                stack.pop();
                Thread.sleep(3000);
                start++;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
