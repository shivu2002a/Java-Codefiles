package Threads.ThreadBasic;

public class SubThread implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            System.out.println("Another thread woke me up");
        }
        System.out.println("I slept for 4sec and I am awake");
    }
}
