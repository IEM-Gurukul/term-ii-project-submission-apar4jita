```java id="timer001"
package service;

public class TimerService implements Runnable {

    private int timeLimit; // in seconds
    private boolean timeUp;

    public TimerService(int timeLimit) {
        this.timeLimit = timeLimit;
        this.timeUp = false;
    }

    @Override
    public void run() {
        try {
            while (timeLimit > 0) {
                System.out.println("Time Remaining: " + timeLimit + " seconds");
                Thread.sleep(1000);
                timeLimit--;
            }
            timeUp = true;
            System.out.println("\n⏰ Time's up! Auto-submitting quiz...");
        } catch (InterruptedException e) {
            System.out.println("Timer interrupted.");
        }
    }

    public boolean isTimeUp() {
        return timeUp;
    }
}
```
