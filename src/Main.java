//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Курсовая работа «Введение в профессию и синтаксис языка» Автор - Фролов В.А.");
        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Иванов Иван Иванович", 50, 1);
        employees[1] = new Employee("Петров Петр Петрович", 60, 2);
        employees[2] = new Employee("Лукьин Лука Лукьич", 30, 3);
        employees[3] = new Employee("Севастьянова Анна Макрковна", 80, 4);

        System.out.println("Количество сотрудников = " + Employee.id);
        System.out.println("Cписок всех сотрудников со всеми имеющимися по ним данными:");
        Employee.getListEmployees(employees);
        System.out.println("Сумма трат за месяц составила " + Employee.spendingAmountPerMonth(employees) + " рублей");
        Employee.searchEmploeeMinSalary(employees);
        Employee.searchEmploeeMaxSalary(employees);
        System.out.println("Среднее значение зарплат " + (int)Employee.spendingAmountPerMonth(employees)/Employee.id + " рублей");
        Employee.printAllNamaEmploees(employees);
    }
}