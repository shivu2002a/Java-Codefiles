package lambdas.Streams.Levelwise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

/* 
 * Reference : Amar Balu (https://medium.com/thefreshwrites/most-commonly-asked-java8-stream-based-interview-question-part-1-85cfea21e3f5) 
 */

public class Stream_Lev_1 {

    public static List<Employee> empList = new ArrayList<Employee>();

    public static void main(String[] args) {
        empList.add(new Employee(111, "Jeya", 30, "Female", "HR", 2011, 25000.0));
        empList.add(new Employee(122, "Polish", 29, "Male", "Sales", 2015, 18500.0));
        empList.add(new Employee(133, "Thomas", 26, "Male", "Administartion", 2012, 18700.0));
        empList.add(new Employee(144, "Gowthami", 29, "Female", "Development", 2014, 33500.0));
        empList.add(new Employee(155, "Nisha", 25, "Female", "HR", 2013, 22000.0));
        empList.add(new Employee(166, "Issac", 40, "Male", "Maintenance", 2016, 12000.0));
        empList.add(new Employee(177, "Sharmila", 30, "Female", "Finance", 2010, 29000.0));
        empList.add(new Employee(188, "Linga", 33, "Male", "Development", 2015, 35000.0));
        empList.add(new Employee(199, "John", 34, "Male", "Sales", 2016, 14500.0));
        empList.add(new Employee(200, "Jeyam", 36, "Male", "Maintenance", 2015, 17000.0));
        empList.add(new Employee(211, "kumar", 37, "Male", "Administartion", 2014, 18700.0));
        empList.add(new Employee(222, "Joshi", 25, "Male", "Development", 2016, 29000.0));
        empList.add(new Employee(233, "Reddy", 29, "Male", "Finance", 2013, 27000.0));
        empList.add(new Employee(244, "Denwer", 28, "Male", "Sales", 2017, 18000.));
        empList.add(new Employee(255, "Alia", 26, "Female", "Administartion", 2018, 13000.0));
        empList.add(new Employee(266, "Sangavi", 36, "Female", "Development", 2015, 29000.0));
        empList.add(new Employee(277, "Anuja", 32, "Female", "Development", 2012, 38000.0));

        countMaleAndFemaleEmps();
        printEveryDept();
        avgAgeOfEmpsBasedOnGender();
        highestPaidEmp();
        listEmpNamesJoinedAfter2014();
        empBasedOnDept();

    }

    private static void countMaleAndFemaleEmps() {
        Map<String, Long> empCountBasedOnGender = empList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("EmpCountBasedOnGender: " + empCountBasedOnGender + "\n");
    }

    private static void printEveryDept() {
        System.out.println("Every Department: ");
        empList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
        System.out.println();
    }

    public static void avgAgeOfEmpsBasedOnGender() {
        Map<String, Double> res = empList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println("AvgAgeOfEmpsBasedOnGender: " + res + "\n");
    }

    private static void highestPaidEmp() {
        Optional<Employee> highestPaid = empList.stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println("Highest Paid emp: " + highestPaid.get().name + "\n");
    }

    private static void listEmpNamesJoinedAfter2014() {
        System.out.println("Employees Joined After 2014: ");
        empList.stream().filter(emp -> emp.joiningYear > 2014).map(Employee::getName).forEach(System.out::println);
    }

    private static void empBasedOnDept() {
        Map<String, List<Employee>> employeeListByDepartment = empList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        for (Entry<String, List<Employee>> entry : employeeListByDepartment.entrySet()) {
            System.out.println("Department Name is " + entry.getKey());
            List<Employee> list = entry.getValue();
            for (Employee e : list) {
                System.out.println(e.getName());
            }
        }
    }
}
