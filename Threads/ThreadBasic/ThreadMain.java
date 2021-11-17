package Threads.ThreadBasic;

class ThreadMain {

    public static void main(String[] args) {
        Thread runnableThread = new Thread(new SubThread());
        runnableThread.start();

        Thread current = new Thread(new Runnable(){
           @Override
            public void run(){
               System.out.println("Hi from anonymous inner type Runnable class");
               try {
                   Thread.sleep(5000);
               } catch (Exception e) {
                   System.out.println("Why am I being interrupted?");
               }
               System.out.print("I slept for 5 secs and Woke up");
               
               try {
                runnableThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } 
        });
        current.start();

    }

}
