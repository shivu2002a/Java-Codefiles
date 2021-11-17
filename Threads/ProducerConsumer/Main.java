package Threads.ProducerConsumer;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {    
    
    public static void main ( String[] args) {
        List<String> buffer = new ArrayList<>(); 
        ReentrantLock bufferLock = new ReentrantLock();
        MyProducer producer = new MyProducer(buffer, bufferLock); 
        MyConsumer consumer1 = new MyConsumer(buffer, bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer, bufferLock);
        // Thread prod = new Thread(producer);
        // prod.start();
        (new Thread(producer)).start();
        (new Thread(consumer1)).start();
        (new Thread(consumer2)).start();
    }
    
}
