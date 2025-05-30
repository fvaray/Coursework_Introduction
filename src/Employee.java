import java.util.Objects;

public class Employee {
    private String fullName;
    private int salary;
    private int departament;
    static int id = 0;

    public Employee(String fullName, int salary, int departament){
        id++;
        this.fullName = fullName;
        this.salary = salary;
        this.departament = departament;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDepartament()
    {
        return departament;
    }

    public void setDepartament(int departament) {
        this.departament = departament;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && departament == employee.departament && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, salary, departament);
    }
}
