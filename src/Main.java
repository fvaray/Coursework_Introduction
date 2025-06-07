import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Random;

public class Main {
    private final static Random RANDOM = new Random();
    private final static String[] NAMES = {"Иван", "Сидор", "Михаил", "Елисей", "Геракл", "Марк", "Рагнар", "Карп", "Семен", "Максим"};
    private final static String[] SURNAME = {"Иванов", "Сидоров", "Михайлов", "Елисеев", "Гераклов", "Марков", "Рагнаров", "Семенов", "Максимов"};
    private final static String[] PATRONYC = {"Иванович", "Сидорович", "Михайлович", "Елисеевич", "Гераклич", "Маркович", "Рагнарович", "Семенович", "Максимович"};
    private final static Employee[] employees = new Employee[10];

    private static void initEmploees() {
        for (int i = 0; i < employees.length; i++) {
            String fullName = SURNAME[RANDOM.nextInt(0, SURNAME.length)] +
                    " " + NAMES[RANDOM.nextInt(0, NAMES.length)] +
                    " " + PATRONYC[RANDOM.nextInt(0, PATRONYC.length)] + " ";
            employees[i] = new Employee(fullName, RANDOM.nextInt(50, 100), RANDOM.nextInt(1, 6));
        }
    }

    public static void main(String[] args) {
        System.out.println("Курсовая работа «Введение в профессию и синтаксис языка» Автор - Фролов В.А.");
        System.out.println("Повышенная сложность");
        initEmploees();
        System.out.println("Cписок всех сотрудников со всеми имеющимися по ним данными:");
        getListEmployees();

        printFullNamesEmploees();

        indexAllSalary(20);
        getListEmployees();

        int numDep = 3;
        searchEmploeeMinSalary(numDep);
        searchEmploeeMaxSalary(numDep);

        System.out.println("В департаменте " + numDep + " cумма трат за месяц составила " + spendingAmountPerMonth(numDep) + " рублей");
        System.out.println("В департаменте " + numDep + " cреднее значение зарплат " + spendingAverageAmountPerMonth(numDep) + " рублей");
        indexDepAllSalary(numDep, 20);
        System.out.println("Список сотрудников из " + numDep + " отдела после индексации:");
        getListDepEmployees(numDep);
        getListEmployeesLessAmount(70);
        getListEmployeesMoreOrEqualAmount(70);

    }

    static void getListEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    static void getListDepEmployees(int departament) {
        if (departament < 1 || departament > 5) {
            System.out.println("Введен департамент не в диапазоне 1..5");
            return;
        }
        for (Employee employee : employees) {
            if (employee.getDepartament() == departament) {
                System.out.println(employee.toStringWithoutDep());
            }
        }
    }

    static void getListEmployeesLessAmount(int amount) {
        System.out.println("Список сотрудников, ЗП которых ниже " + amount + " рублей:");
        for (Employee employee : employees) {
            if (employee.getSalary() < amount) {
                System.out.println(employee.toStringWithoutDep());
            }
        }
    }

    static void getListEmployeesMoreOrEqualAmount(int amount) {
        System.out.println("Список сотрудников, ЗП которых больше или равно " + amount + " рублей:");
        for (Employee employee : employees) {
            if (employee.getSalary() >= amount) {
                System.out.println(employee.toStringWithoutDep());
            }
        }
    }

    static int spendingAmountPerMonth(int departament) {
        if (departament < 1 || departament > 5) {
            System.out.println("Введен департамент не в диапазоне 1..5");
            return 0;
        }
        int sum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartament() == departament) {
            sum += employee.getSalary();
            }
        }
        return sum;
    }

    static int spendingAverageAmountPerMonth(int departament) {
        if (departament < 1 || departament > 5) {
            System.out.println("Введен департамент не в диапазоне 1..5");
            return 0;
        }
        int i = 0, sum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartament() == departament) {
                sum += employee.getSalary();
                i++;
            }
        }
        if(i == 0){
            System.out.println("Департамент " + departament + " отсутствует");
            return 0;
        }
        return sum/i;
    }

    static void searchEmploeeMinSalary(int departament) {
        if (departament < 1 || departament > 5) {
            System.out.println("Введен департамент не в диапазоне 1..5");
            return;
        }

        int min = Integer.MAX_VALUE;
        int i = 0, j = 0, k = 0;
        for (Employee employee : employees) {
            if (employee.getDepartament() == departament) {
                if (employee.getSalary() < min) {
                    min = employee.getSalary();
                    j = i;
                }
                k++;
            }
            i++;
        }
        if(k == 0)
            System.out.println("Отдела с номером " + departament + " нет");
        else
            System.out.println("Cотрудник с минимальной ЗП в департаменте " + departament + " " + employees[j].toString());
    }

    static void searchEmploeeMaxSalary(int departament) {
        if (departament < 1 || departament > 5) {
            System.out.println("Введен департамент не в диапазоне 1..5");
            return;
        }
        int max = Integer.MIN_VALUE;
        int i = 0, j = 0, k = 0;
        for (Employee employee : employees) {
            if (employee.getDepartament() == departament) {
                if (employee.getSalary() > max) {
                    max = employee.getSalary();
                    j = i;
                }
                k++;
            }
            i++;
        }

        if(k == 0)
            System.out.println("Отдела с номером " + departament + " нет");
        else
            System.out.println("Cотрудник с максимальной ЗП в департаменте " + departament + " " + employees[j].toString());
    }

    static void printFullNamesEmploees() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }

    static void indexAllSalary(int percent) {
        float index = 1.0f + percent / 100.0f;
        int iSalary = 0;
        for (Employee employee : employees) {
            iSalary = (int) (index * employee.getSalary());
            employee.setSalary(iSalary);
        }
    }

    static void indexDepAllSalary(int departament, int percent) {
        if (departament < 1 || departament > 5) {
            System.out.println("Введен департамент не в диапазоне 1..5");
            return;
        }
        float index = 1.0f + percent / 100.0f;
        int iSalary = 0;
        for (Employee employee : employees) {
            if (employee.getDepartament() == departament) {
                iSalary = (int) (index * employee.getSalary());
                employee.setSalary(iSalary);
            }
        }
    }
}