package Threads;

import java.util.concurrent.locks.ReentrantLock;

public class Fairlock {

    final static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {

        Thread t1 = new Thread(new Worker("Priority-10"));
        Thread t2 = new Thread(new Worker("Priority-8"));
        Thread t3 = new Thread(new Worker("Priority-6"));
        Thread t4 = new Thread(new Worker("Priority-4"));
        Thread t5 = new Thread(new Worker("Priority-1"));

        t1.setPriority(10);
        t2.setPriority(8);
        t3.setPriority(6);
        t4.setPriority(4);
        t5.setPriority(1);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }

    public static class Worker implements Runnable {
        
        private int count = 1;
        private String name;

        public Worker(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    System.out.println(this.name + " : " + count++);
                } catch (Exception e) {
                    System.out.println("I was interrupted");
                } finally {
                    lock.unlock();
                }
            }
            System.out.println();
        }

    }

}
