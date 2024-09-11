package threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadMaker extends Thread {
    private final long minTime;
    private final List<Character> availableLetters;

    public ThreadMaker(long minTime, String name) {
        this.minTime = minTime;
        this.availableLetters = new ArrayList<>();
        for (char c : name.toCharArray()) {
            this.availableLetters.add(c);
        }
    }

    public void run() {
        while (!availableLetters.isEmpty()) {
            try {
                Collections.shuffle(availableLetters);
                char selectedChar = availableLetters.removeFirst();
                System.out.print(selectedChar + " ");
                Thread.sleep(minTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
