package Threads;

public class AnotherThread implements Runnable {
    
    public void run(){
        
        try {
            Thread.sleep(4000);
            System.out.println("4 seconds passed and I am here.");
        } catch (InterruptedException e) {
            System.out.println("Another woke me up");
        }
    }
}