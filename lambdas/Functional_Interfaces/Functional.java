package lambdas.Functional_Interfaces;

import lambdas.EMP.*;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;

public class Functional {
    
    public static void main(String[] args) {
        Employee ishwar = new Employee("Ishwar R", 20);
        Employee pranav = new Employee("Pranav N", 19);
        Employee chetan = new Employee("Chetan H", 34);
        Employee nagraj = new Employee("Nagraj K", 32);
        Employee arun = new Employee("Arun S", 25);
        Employee nihal = new Employee("Nihal G", 29);
        Employee prajwal = new Employee("Prajwal B", 35);
        Employee muttu = new Employee("Muttu C", 30);
        Employee bheema = new Employee("Bheemsen L", 40);

        List<Employee> list = new ArrayList<>();
        list.add(ishwar);
        list.add(pranav);
        list.add(chetan);
        list.add(nagraj);
        list.add(nihal);
        list.add(muttu);
        list.add(arun);
        list.add(prajwal);
        list.add(bheema);

        list.forEach(employee -> {
            System.out.println(employee.getName().substring(employee.getName().indexOf(' ')+1));
        }); 

        // Using function interface, which takes one parameter and return a value
        // Has a method called apply
        // Printing last Names
        Function<Employee, String> getLastName = (e) -> {
            return e.getName().substring(e.getName().indexOf(' ')+1);
        };
        String lastName = getLastName.apply(list.get(0));
        System.out.println(lastName);

        // Printing first Names
        Function<Employee, String> getFirstName = (e) -> {
            return e.getName().substring(0, e.getName().indexOf(' '));
        };
        System.out.println(getFirstName.apply(ishwar) + "\n\n");

        // Printing either first or last based on the parameter we pass 
        Random r = new Random();
        for (Employee e : list) {
            if(r.nextBoolean()){
                System.out.println(getAName(getFirstName, e));
            } else {
                System.out.println(getAName(getLastName, e));
            }
        }

        // Chaining Functions using andThen method to upperCase and the concat
        Function<Employee, String> upperCase = (e) -> e.getName().toUpperCase();

        Function<String, String> firstName = (e) -> e.substring(0, e.indexOf(' '));

        Function<Employee, String> chained = upperCase.andThen(firstName);
        System.out.println(chained.apply(chetan));

        // BiFunction Interface which accepts two arguments
        BiFunction<String, Employee, String> concat = (name, e) -> {
            return name.concat(": " +e.getAge());
        };

        String name = upperCase.apply(nihal);
        System.out.println(concat.apply(name, nihal));

        // Unary Operator Interface
        IntUnaryOperator by5 = i -> i+5;
        System.out.println(by5.applyAsInt(34));

        // Chaining Consumer interfaces even though they don't have any return value, but on the single value passed to accept method
        Consumer<String> c1 = str -> System.out.println(str.toUpperCase());
        Consumer<String> c2 = nameNow -> System.out.println(nameNow);
        c1.andThen(c2).accept("hi there");
    }   
    
    public static String getAName (Function<Employee, String> getName, Employee e){
        return getName.apply(e);
    }
}
