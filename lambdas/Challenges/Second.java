package lambdas.Challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Second {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Amelia", "Olivia", "emily", "isla", "ava", "oliver", "Jack", "Charlie", "harry", "Jacob");
        List<String> upperCase = new ArrayList<>();
        
        names.forEach(name -> {
            upperCase.add(name.substring(0, 1).toUpperCase() + name.substring(1));
        });

        upperCase.sort((s1, s2) -> {
            return s1.compareTo(s2);
        });
        System.out.println(upperCase);
        
        names.stream()
            .map(s -> s.substring(0,1).toUpperCase()+s.substring(1))
            .peek(s -> System.out.println(s))
            .sorted(String::compareTo)
            .filter(name -> name.startsWith("A"))
            .forEach(System.out::println);




    }
}