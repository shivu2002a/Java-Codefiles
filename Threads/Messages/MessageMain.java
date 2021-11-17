package Threads.Messages;

public class MessageMain {

    public static void main( String[] Args) {
        
        Message message = new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();

    }
}
