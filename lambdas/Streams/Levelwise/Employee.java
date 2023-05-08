package lambdas.Streams.Levelwise;

public class Employee {
    
    int empId;
    String name;
    int age;
    String gender;
    String department;
    int joiningYear;
    double salary;

    public Employee(int empId, String name, int age, String gender, String department, int joiningYear, double salary) {
        this.empId = empId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.joiningYear = joiningYear;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getJoiningYear() {
        return joiningYear;
    }

    public void setJoiningYear(int joiningYear) {
        this.joiningYear = joiningYear;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
}
