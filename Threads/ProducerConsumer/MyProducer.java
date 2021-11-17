package Threads.ProducerConsumer;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class MyProducer implements Runnable{
    private List<String> buffer;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, ReentrantLock bufferLock){
        this.buffer = buffer;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        Random r = new Random();
        String[] nums = {"1", "2", "3", "4", "5", "6", "7"};
        for(String num : nums){
            try {
                System.out.println(num+" ");
                bufferLock.lock();
                try {
                    buffer.add(num);
                } finally {
                    bufferLock.unlock();
                }
                Thread.sleep(r.nextInt(2000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }
        System.out.println("Adding EOF and Exiting");
        bufferLock.lock();
        buffer.add("EOF");
        bufferLock.unlock();
        
    }
    
}
