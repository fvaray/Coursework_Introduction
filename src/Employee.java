import java.util.Objects;

public class Employee {
    private String fullName;
    private int salary;
    private int departament;
    private int id = 0;
    private static int counter = 1;

    public Employee(String fullName, int salary, int departament) {
        id = counter++;
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

    public int getDepartament() {
        return departament;
    }

    public void setDepartament(int departament) {
        this.departament = departament;
    }

    public int getId(){
        return this.id;
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

    @Override
    public String toString() {
        return "id=" + id +
                ", fullName=" + fullName +
                ", salary=" + salary +
                ", departament=" + departament +
                '}';
    }

    static void resetEmployee(Object o, String fullName, int salary, int departament) {
        Employee employee = (Employee) o;
        employee.fullName = fullName;
        employee.salary = salary;
        employee.departament = departament;
    }

    static int getCounter()
    {
        return counter;
    }
}