package Threads;

public class Deadlock {
    
    public static void main(String[] args) {

        final PolitePerson jane = new PolitePerson("Jane");
        final PolitePerson john = new PolitePerson("John");
        
        new Thread( new Runnable(){
           @Override
           public void run() {
               jane.sayHello(john);
           }
        }).start();

        new Thread(new Runnable(){
            @Override
            public void run(){
                john.sayHello(jane);
            }
        }).start();
    }
/* Thread1 acquires the lock on the jane object and enters the sayHello and after printing it to the console, suspends.
   Thread2 acquires the lock on the john object and enters the sayHello and after printing it to the console, suspends.
   Thread1 runs again and wants to say HelloBack to john object. It tries to call sayHelloBack() that was passed into the sayHello()
   method but thread2 is holding the john lock, so thread1 suspends.
   Thread2 runs again and wants to say HelloBack to jane object. It tries to call sayHelloBack() that was passed into the sayHello()
   method but thread1 is holding the jane lock, so thread2 suspends. 
*/ 
    public static class PolitePerson{
        public final String name;
        
        public PolitePerson(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void sayHello(PolitePerson person){
            System.out.format("%s: %s" + " has said hello to me!%n", this.name, person.getName());
            person.sayHelloBack(this);
        }

        public synchronized void sayHelloBack(PolitePerson person){
            System.out.format("%s: %s" + " has said hello back to me!%n", this.name, person.getName());
        }

    }
}
