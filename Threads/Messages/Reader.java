package Threads.Messages;

import java.util.Random;

public class Reader implements Runnable {
    private Message message;

    public Reader(Message message){
        this.message = message;
    }

    public void run(){
        Random random = new Random();
        for(String s = message.read(); !s.equals("Finish"); s = message.read()){
            System.out.println(s);
            try {
                Thread.sleep(random.nextInt(4000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        message.write("Finish");
    }
    
}
