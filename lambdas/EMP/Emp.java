package lambdas.EMP;

import java.util.ArrayList;
import java.util.Collections;
// import java.util.Comparator;
import java.util.*;

public class Emp {

    public static void main(String[] args) {
        
        Employee john = new Employee("John", 20);
        Employee chandler = new Employee("Chandler", 30);
        Employee mark = new Employee("Mark", 40);
        Employee drake = new Employee("Drake", 20);

        List<Employee> list = new ArrayList<>();
        list.add(john);
        list.add(chandler);
        list.add(mark);
        list.add(drake);

        //  Comparator is a functional interface, and has only compare method.
        //  So we can use lambda experessions. 
        //  Using an anonymous class

        // Collections.sort(list, new Comparator<Employee>(){
        //     @Override
        //     public int compare(Employee emp1, Employee emp2){
        //         return emp1.getName().compareTo(emp2.getName());
        //     }
        // });

        //  Using lambda Expresssion
        Collections.sort(list, (Employee e1, Employee e2) -> 
            e1.getName().compareTo(e2.getName()));

        Collections.sort(list, (e1, e2) -> 
            e1.getName().compareTo(e2.getName()));


        for (Employee employee : list) {
            System.out.println(employee.getName());
        }

        list.forEach(e1 ->{
            System.out.println(e1.getName());
            System.out.println(e1.getAge());
        });
        System.out.println("\n\n");

        for (Employee employee : list) {
            System.out.println(employee.getName());
            new Thread(() -> {
                System.out.println(employee.getAge());
            }).start();;
        }

        // Return value case
        // String uAndC = doStringStuff(new upperConcat(){
        //     @Override
        //     public String upperAndConcat(String s1, String s2){
        //         return s1.toUpperCase()+s2.toUpperCase();
        //     }
        // }, list.get(0).getName(), list.get(1).getName());
        // System.out.println(uAndC);

        // Same case, using Lanbda 

        upperConcat uc = (s1,s2) ->  s1.toUpperCase()+s2.toUpperCase();
        String uAndC = doStringStuff(uc, list.get(0).getName(), list.get(1).getName());
        System.out.println((uAndC));
    }

    public final static String doStringStuff(upperConcat uc, String s1, String s2){
        return uc.upperAndConcat(s1, s2);
    }    
}
