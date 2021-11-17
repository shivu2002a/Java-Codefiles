package Threads.CountDown;

public class CountdownThread extends Thread {

    public Countdown countdown;

    public CountdownThread(Countdown countdown) {
        this.countdown = countdown;
    }
    
    @Override
    public void run() {
        countdown.count();
    }

}