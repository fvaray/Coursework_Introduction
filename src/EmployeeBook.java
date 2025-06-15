import java.util.Random;

public class EmployeeBook {
    private final static Random RANDOM = new Random();
    private final static String[] NAMES = {"Иван", "Сидор", "Михаил", "Елисей", "Геракл", "Марк", "Рагнар", "Карп", "Семен", "Максим"};
    private final static String[] SURNAME = {"Иванов", "Сидоров", "Михайлов", "Елисеев", "Гераклов", "Марков", "Рагнаров", "Семенов", "Максимов"};
    private final static String[] PATRONYC = {"Иванович", "Сидорович", "Михайлович", "Елисеевич", "Гераклич", "Маркович", "Рагнарович", "Семенович", "Максимович"};
    private final static Employee[] employees = new Employee[10];

    private static void initEmploees() {
        for (int i = 0; i < 9; i++) {
            String fullName = SURNAME[RANDOM.nextInt(0, SURNAME.length)] +
                    " " + NAMES[RANDOM.nextInt(0, NAMES.length)] +
                    " " + PATRONYC[RANDOM.nextInt(0, PATRONYC.length)];
            employees[i] = new Employee(fullName, RANDOM.nextInt(50, 100), RANDOM.nextInt(1, 6));
        }
    }

    public EmployeeBook() {
        initEmploees();
    }

    public void getListEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public boolean addNewEmployee(String fullName, int salary, int departament) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(fullName, salary, departament);
                return true;
            }
        }
        return false;
    }

    public void delEmployee(int id){
            employees[id-1] = null;
    }

    public Employee findEmployee(int id){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        return null;
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

    public void getListEmployeesLessAmount(int amount) {
        System.out.println("Список сотрудников, ЗП которых ниже " + amount + " рублей:");
        for (Employee employee : employees) {
            if (employee.getSalary() < amount) {
                System.out.println(employee.toStringWithoutDep());
            }
        }
    }

    public void getListEmployeesMoreOrEqualAmount(int amount) {
        System.out.println("Список сотрудников, ЗП которых больше или равно " + amount + " рублей:");
        for (Employee employee : employees) {
            if (employee.getSalary() >= amount) {
                System.out.println(employee.toStringWithoutDep());
            }
        }
    }

    public int spendingAmountPerMonth(int departament) {
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

    public int spendingAverageAmountPerMonth(int departament) {
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

    public void searchEmploeeMinSalary(int departament) {
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

    public void searchEmploeeMaxSalary(int departament) {
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

    public void printFullNamesEmploees() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }

    public void indexAllSalary(int percent) {
        float index = 1.0f + percent / 100.0f;
        int iSalary = 0;
        for (Employee employee : employees) {
            iSalary = (int) (index * employee.getSalary());
            employee.setSalary(iSalary);
        }
    }

    public void indexDepAllSalary(int departament, int percent) {
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
