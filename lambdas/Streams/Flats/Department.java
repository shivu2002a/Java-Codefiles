package lambdas.Streams.Flats;

import lambdas.EMP.Employee;

import java.util.*;

public class Department {
    private List<Employee> employees;
    
    public Department(String dept){
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee emp){
        employees.add(emp);
    }

    public List<Employee> gEmployees(){
        return new ArrayList<>(employees);
    } 

}
