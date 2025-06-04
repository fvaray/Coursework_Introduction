//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Employee[] employees = new Employee[4];
    public static void main(String[] args) {
        System.out.println("Курсовая работа «Введение в профессию и синтаксис языка» Автор - Фролов В.А.");

        employees[0] = new Employee("Иванов Иван Иванович", 50, 1);
        employees[1] = new Employee("Петров Петр Петрович", 60, 2);
        employees[2] = new Employee("Лукьин Лука Лукьич", 30, 3);
        employees[3] = new Employee("Севастьянова Анна Макрковна", 80, 4);

        System.out.println("Cписок всех сотрудников со всеми имеющимися по ним данными:");
        getListEmployees();
        System.out.println("Сумма трат за месяц составила " + spendingAmountPerMonth() + " рублей");
        searchEmploeeMinSalary();
        searchEmploeeMaxSalary();
        System.out.println("Среднее значение зарплат " + (int)spendingAmountPerMonth()/employees.length + " рублей");
        printFullNamesEmploees();
    }

    static void getListEmployees() {
        for (Employee employee: employees) {
            System.out.println(employee);
        }
    }

    static int spendingAmountPerMonth() {
        int sum = 0;
        for (Employee employee: employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    static void searchEmploeeMinSalary() {
        int min = employees[0].getSalary();
        int i = 0, j = 0;
        for (Employee employee: employees) {
            if (employee.getSalary() < min) {
                min = employee.getSalary();
                j = i;
            }
            i++;
        }
        System.out.println("Cотрудник с минимальной ЗП - " + employees[j].toString());
    }

    static void searchEmploeeMaxSalary() {
        int max = employees[0].getSalary();
        int i = 0, j = 0;
        for (Employee employee: employees) {
            if (employee.getSalary() > max)
            {
                max = employee.getSalary();
                j = i;
            }
            i++;
        }
        System.out.println("Cотрудник с максималной ЗП - " + employees[j].toString());
    }

    static void printFullNamesEmploees() {
        for (Employee employee: employees) {
            System.out.println(employee.getFullName());
        }
    }
}