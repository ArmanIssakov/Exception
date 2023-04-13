import java.util.InputMismatchException;
import java.util.Scanner;

public class Homework02 {
    public static void main(String[] args) {
        // Первое задание
        System.out.println("Первое задание:\n"+task01());

        // Второе задание:
        System.out.println("Второе задание:");
        try {
            int d = 0;
            int[] intArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
            if (d == 0) {
                throw new ArithmeticException();
            }
            double catchedRes1 = (double) intArray[8] / d; //
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }

        // Третье задание:
        System.out.println("Третье задание");
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2};
            abc[3] = 9;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Exception ex) {
            System.out.println(ex);
        }

        System.out.println("Четвертое задание:");
        try {
            task02();
        } catch (Exception e) {
            System.out.println("Пустые строки вводить нельзя");
        }

    }

    public static void printSum(int a, int b) {
        System.out.println(a + b);
    }


    /* Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
     и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
      вместо этого, необходимо повторно запросить у пользователя ввод данных. */

    /**
     * Метод для запроса и возврата дробного числа
     *
     * @return дробное число
     */
    public static float task01() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите дробное число (разделитель запятая): ");
            return scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println(e);
            System.out.println("Введенное значение не является дробным числом.");
            return task01();
        }
    }

    /*Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
    Пользователю должно показаться сообщение, что пустые строки вводить нельзя.*/

    /**
     * @throws Exception
     */
    public static void task02() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите что нибудь:");
        String str = scanner.nextLine();
        if (str.isEmpty()) {
            throw new Exception();
        } else {
            System.out.println("Программа сработала отлично");
        }
    }
}
