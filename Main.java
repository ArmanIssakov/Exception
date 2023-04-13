import java.util.Random;
import java.util.StringJoiner;

// ********************************************************************************************************************
// Первое дз по исключениям
/**
 Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
 каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке. Если длины массивов не равны,
 необходимо как-то оповестить пользователя.
 */
public class Main {

    public static void main(String[] args) {

        int[] example = differenceArrays(generateArr(), generateArr());
    }

    /**
     * Метод генерации одномерного целочисленного массива
     * @return одномерный целочисленный массив
     */
    static int[] generateArr(){
        Random random = new Random();
        int[] arr = new int[random.nextInt(2) + 4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10);
//            System.out.print(arr[i] + " ");
        }
        return arr;
    }

    /**
     *
     * @param arr1 целочисленный массив
     * @param arr2 целочисленный массив
     * @return целочисленный массив
     */
    static int[] differenceArrays(int[] arr1, int[] arr2) {
        showArray(arr1);
        showArray(arr2);
        if (arr1.length == arr2.length) {
            int[] arrResult = new int[arr1.length];
            for (int i = 0; i < arr1.length; i++) {
                arrResult[i] = arr1[i] - arr2[i];
            }
            showArray(arrResult);
            return arrResult;
        } else {
            System.out.println("Длины массивов не совпадают");
            return null;

        }
    }

    /**
     * Метод для вывода в консоль одномерного массива
     * @param arr целочисленный массив
     */
    static void showArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    //*****************************************************************************************************************

    // -----------Второй семинар по Исключениям------------

    public static String[][] generateArray(){
        Random random = new Random();
        int add = random.nextInt(2);
        String[][] arr = new String[4 + add][4 + add];

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; i < arr.length; j++){
                if (random.nextInt(11) < 2){
                    arr[i][j] = "abc";
                } else {
                    arr[i][j] = Integer.toString(random.nextInt(100));
                }
                System.out.printf("%s ", arr[i][j]);
            }
            System.out.println();
        }
        return arr;
    }
}

abstract class MyException extends Exception{
    private final int x;
    private final int y;

    public MyException(String message, int x, int y){
        super(message);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class MyArraySizeException extends MyException{
    public MyArraySizeException(String message, int x, int y){
        super(message, x, y);
    }
}

class MyArrayDataException extends MyException{
    public MyArrayDataException(String message, int x, int y){
        super(message, x, y);
    }
}
