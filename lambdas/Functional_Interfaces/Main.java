package lambdas.Functional_Interfaces;

import java.util.*;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

import lambdas.EMP.Employee;

public class Main {
    
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
        
        System.out.print("list : ");
        list.forEach(e1 -> {
            System.out.print( "\t" + e1.getName() +" >> "+e1.getAge()+ "\n");
        });
        System.out.println();
        
        System.out.print("> 30: ");
        for (Employee employee : list) {
            if(employee.getAge() > 30 ) System.out.print("\t" + employee.getAge()+ "\n");
        }
        System.out.print("\n Using lambdas \n > 30:");

        // Above by using lambda expression
        list.forEach(e1 -> {
            if (e1.getAge() > 30) System.out.println("\t"+e1.getAge());
        });

        System.out.println("< 30:");
        list.forEach(e1 -> {
            if(e1.getAge() <= 30){
                System.out.println( "\t"+ e1.getAge());
            }
        });

        // Using Predicate
        byAge(list, e1 -> e1.getAge() > 30);
        byAge(list, e1 -> e1.getAge() < 30);
        byAge(list, new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee){
                return employee.getAge() < 25;
            }
        });

        IntPredicate greaterThan15 = i -> i > 15;
        System.out.println(greaterThan15.test(29));
        int a = 30;
        a += 30;
        System.out.println(greaterThan15.test(a+3));

        // Chaining Predicates
        IntPredicate lessThan100 = i -> i < 100;
        System.out.println(greaterThan15.and(lessThan100).test(300));

        Random r = new Random();
        // for(int i = 0; i < 10; i++){
        //     System.out.println(r.nextInt());
        // }

        // USing Supplier Interface
        Supplier<Integer> rSupplier = () -> r.nextInt(10);
        for(int i = 0; i < 10; i++){
            System.out.println(rSupplier.get());
        }
        
    }

    public static void byAge(List<Employee> list, Predicate<Employee> condition){
        for (Employee employee : list) {
            if(condition.test(employee)){
                System.out.println(employee.getAge());
            }
        }
        System.out.println("\n");
    }
}
