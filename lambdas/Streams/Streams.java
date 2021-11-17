package lambdas.Streams;

import java.util.*;
import java.util.stream.*;

public class Streams {
    
    public static void main(String[] args) {
        List<String> bingo = Arrays.asList(
            "N40", "N36",
            "B12", "B6",
            "G53", "G49", "G60", "G50", "g56",
            "I26", "I27", "I29",
            "O71"
        );

        bingo.forEach(System.out::println);
        List<String> gBingo = new ArrayList<>();

        bingo.forEach(str -> {
            if(str.toUpperCase().startsWith("G")){
                gBingo.add(str);
            }
        });
        gBingo.sort((i, j) -> i.compareTo(j));
        gBingo.forEach(s -> System.out.println(s));
        System.out.println();

        // Using Streams to do the above 19-25 lines code process
        bingo //Collection source from which stream is created 
            .stream()
            .map(String::toUpperCase)
            .filter(s -> s.startsWith("G"))
            .sorted()
            .forEach(System.out::println);

            
        System.out.println("\n");
        Stream<String> iNumbers = Stream.of("I26", "I17", "I29", "I71");
        Stream<String> nNumbers = Stream.of("N40", "N36", "I26", "I17", "I29", "I71");
        Stream<String> concatStream = Stream.concat(iNumbers, nNumbers);
        
        System.out.println("\n");
        System.out.println(concatStream
                                       .distinct()
                                       .peek(System.out::println)
                                       .count());

        List<String> sortedGNumbers = gBingo
            .stream()
            .map(String::toUpperCase)
            .filter(i -> i.startsWith("G"))
            .sorted()
            .collect(Collectors.toList()); 
            /* Difference is this line of code puts all the elements in the list
            sortedGNumbers which we can continue to work with  */
        
        for (String string : sortedGNumbers) {
          System.out.print( string+ " ");                                  
        }

        Stream.of("ABC", "AAA", "AA0", "XYC", "CCCC", "JKL")
            .filter(s -> {
                System.out.println(s);
                return s.length() == 3;
            });

        Stream.of("ABC", "AAA", "AA0", "XYC", "CCCC", "JKL")
            .filter(s -> {
                System.out.println(s);
                return s.length() == 3;
            }).count();
    }
}
