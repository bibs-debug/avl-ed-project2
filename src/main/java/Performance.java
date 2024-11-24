package main.java;

public class Performance {
    private long startTime;
    private long endTime;

    public void start() {
        startTime = System.nanoTime();
    }

    public long stop() {
        endTime = System.nanoTime();
        return endTime - startTime;
    }

    public void displayTime(String operation, long time) {
        System.out.println(operation + " levou " + time / 1000000 + " ms.");
    }
}
