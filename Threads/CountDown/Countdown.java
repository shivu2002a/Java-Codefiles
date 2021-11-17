package Threads.CountDown;

public class Countdown {
    public int i;
    // public synchronized void count() {
    //     for (i = 10; i > 0; i--) {
    //         System.out.print(i+ " ");
    //     }
    //     System.out.println();
    // }

    public void count() {
        synchronized (this) {
            for (i = 10; i > 0; i--) {
                System.out.print(i+ " ");
            }
            System.out.println();
        }
    }
}
