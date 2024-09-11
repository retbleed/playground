package threads;

import java.util.Random;

public class ThreadWrapper {
    private final String fullName;

    public ThreadWrapper(String fullName) {
        this.fullName = fullName;
    }

    public void run() {
        String[] nameParts = this.fullName.split(" ");
        Random random = new Random();
        long initialMinTime;

        System.out.print(fullName + "\n");
        for (int i = 0; i < nameParts.length; i++) {
            initialMinTime = Math.abs(random.nextLong() % 100);
            ThreadMaker thread = new ThreadMaker(initialMinTime + (i * 50L), nameParts[i]);
            thread.start();
        }
    }

    public static void main(String[] args) {
        ThreadWrapper wrapper = new ThreadWrapper("John Doe Jane Mick");
        wrapper.run();
    }
}
