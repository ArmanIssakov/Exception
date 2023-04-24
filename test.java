import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String test = scanner.nextLine();
        if (test.equals("1")){
            System.out.println("Вы ввели 1");
        } else {
            System.out.println("Вы ввели другое число");
        }
    }


}
