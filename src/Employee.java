import java.util.Objects;

public class Employee {
    private String fullName;
    private int salary;
    private int departament;
    static int id = 0;

    public Employee(String fullName, int salary, int departament) {
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

    public int getDepartament() {
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

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
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

    static void getListEmployees(Object[] objects) {
        Employee[] employee = (Employee[]) objects;
        for (int i = 0; i < Employee.id; i++) {
            System.out.println(employee[i].toString());
        }
    }

    static int spendingAmountPerMonth(Object[] objects) {
        Employee[] employee = (Employee[]) objects;
        int sum = 0;
        for (int i = 0; i < Employee.id; i++) {
            sum += employee[i].getSalary();
        }

        return sum;
    }

    static void searchEmploeeMinSalary(Object[] objects) {
        Employee[] employee = (Employee[]) objects;
        int min = employee[0].getSalary();
        int j = 0;
        for (int i = 0; i < Employee.id; i++) {
            if (employee[i].getSalary() < min) {
                min = employee[i].getSalary();
                j = i;
            }
        }
        System.out.println("Cотрудник с минимальной ЗП - " + employee[j].toString());
    }

    static void searchEmploeeMaxSalary(Object[] objects) {
        Employee[] employee = (Employee[]) objects;
        int max = employee[0].getSalary();
        int j = 0;
        for (int i = 0; i < Employee.id; i++) {
            if (employee[i].getSalary() > max)
            {
                max = employee[i].getSalary();
                j = i;
            }
        }
        System.out.println("Cотрудник с максималной ЗП - " + employee[j].toString());
    }

    static void printAllNamaEmploees(Object[] objects) {
        Employee[] employee = (Employee[]) objects;
        for (int i = 0; i < Employee.id; i++) {
            System.out.println(employee[i].getFullName());
        }
    }
}