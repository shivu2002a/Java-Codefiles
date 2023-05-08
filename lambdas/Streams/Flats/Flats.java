package lambdas.Streams.Flats;

import java.util.*;

import lambdas.EMP.Employee;

public class Flats{
    
    public static void main(String[] args) {
        Employee ishwar = new Employee("Ishwar R", 20);
        Employee pranav = new Employee("Pranav N", 19);
        Employee chetan = new Employee("Chetan H", 34);
        Employee nagraj = new Employee("Nagraj K", 32);

        Department hr = new Department("Human Resource");
        hr.addEmployee(ishwar);
        hr.addEmployee(chetan);
        hr.addEmployee(nagraj);
        Department accounting = new Department("Accounting");
        accounting.addEmployee(pranav);

        List<Department> depts = new ArrayList<Department>();
        depts.add(hr);
        depts.add(accounting);

        depts
            .stream()
            .flatMap(Department -> Department.gEmployees().stream())
            .forEach(System.out::println);

        depts
            .stream()
            .flatMap(Department -> Department.gEmployees().stream())
            .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
            .ifPresent(System.out::println);
    }
}
