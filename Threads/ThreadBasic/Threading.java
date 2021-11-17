package Threads.ThreadBasic;

import Threads.AnotherThread;

public class Threading {

    public static void main(String[] args) {
        
        System.out.println("Hi from main");
        Thread anotherThread = new Thread(new AnotherThread());
        anotherThread.start();

        new Thread(){
            public void run() {
                System.out.println("Hi from anonymous thread");
            }
        }.start();

        try {
            anotherThread.join();
            System.out.println("Outer class joined");
        } catch (InterruptedException e) {
            System.out.println("Everything's wrong");
        }

    }
    
}
