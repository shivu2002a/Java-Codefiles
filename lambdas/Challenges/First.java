package lambdas.Challenges;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class First {
    
    public static void main(String[] args) {
        String[] arr = "I am going to Bangalore on Saturday.".split(" ");
        new Thread(() -> {
            for (String string : arr) {
                System.out.print(string+ " ");
            }
        }).start();

        Supplier<String> java = () -> "I love java";
        System.out.print("\n" + java.get());

        Callable<String> callable = () -> {
            return "String is " + "  concatenated.";
        };
        try{
            System.out.print(callable.call());
        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
