package Threads.Messages;

import java.util.Random;

class Writer implements Runnable {
    private Message message;

    public Writer(Message message){
        this.message = message;
    }

    public void run() {
        String[] messages = {
            "Humpty Dumpty sat on a wall, ",
            "Humpty Dumpty had a great fall ",
            "All the King's horses and king's men",
            "Couldn't put HUmpty together again."
        };

        Random random = new Random();
        for (int i = 0; i < messages.length; i++) {
            message.write(messages[i]);
        }
        try {
            Thread.sleep(random.nextInt(4000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        message.write("Finish");
    }


}
