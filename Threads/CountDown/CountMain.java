package Threads.CountDown;

public class CountMain {

    public static void main(String[] args) {
        Countdown countdown1 = new Countdown();
        CountdownThread countdownA = new CountdownThread(countdown1);
        CountdownThread countdownB = new CountdownThread(countdown1);
        countdownA.start();
        countdownB.start();

        
    }
    
}
