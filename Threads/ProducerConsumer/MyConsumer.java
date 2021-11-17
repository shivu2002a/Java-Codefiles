package Threads.ProducerConsumer;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class MyConsumer implements Runnable {
    private List<String> buffer;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run(){
        int counter = 0;
        while(true){
            if(bufferLock.tryLock()){
                try{
                    if(buffer.isEmpty()){
                        // bufferLock.unlock();
                        continue;
                    }
                    System.out.println("Counter = "+counter);
                    counter = 0;
                    if(buffer.get(0).equals("EOF")){
                        System.out.println("Exiting");
                        // bufferLock.unlock();
                        break;
                    } else {
                        System.out.println("Removed "+buffer.remove(0));
                    }
                } finally {
                    bufferLock.unlock();
                }
            } else {
                counter++;
            }
            
        }
    }




}
