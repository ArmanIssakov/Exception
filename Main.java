import java.util.Random;

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
}
