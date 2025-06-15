import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println("Курсовая работа «Введение в профессию и синтаксис языка» Автор - Фролов В.А.");
        System.out.println("Уровень - очень сложно");
        EmployeeBook book = new EmployeeBook();
        System.out.println("Cписок всех сотрудников со всеми имеющимися по ним данными:");
        book.getListEmployees();
        if(!book.addNewEmployee("Маркова Анна Вадимовна", 100, 5)){
            System.out.println("Свободные места закончились!");
        }
        book.getListEmployees();
        book.delEmployee(2);
        if(!book.addNewEmployee("Машкова Алла Валерьевна", 100, 5)){
            System.out.println("Свободные места закончились!");
        }
        book.getListEmployees();
        System.out.println(book.findEmployee(10));
        book.getListEmployeesLessAmount(70);
        book.getListEmployeesMoreOrEqualAmount(70);
        book.indexAllSalary(10);
        book.getListEmployees();
        book.searchEmploeeMaxSalary(3);
        book.printFullNamesEmploees();
    }
}