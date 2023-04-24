/*Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
Фамилия Имя Отчество датарождения номертелефона пол
Форматы данных:
фамилия, имя, отчество - строки
дата_рождения - строка формата dd.mm.yyyy
номер_телефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.
Приложение должно проверить введенные данные по количеству.
Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои.
Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида
<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
Не забудьте закрыть соединение с файлом.
При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.*/
package Homework03;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Homework03 {

    public static void main(String[] args) {
        try {
            getData();

        } catch (EmptyStringException e) {
            System.out.println(e.getMessage());
        } catch (ArrayCountElementException e) {
            System.out.println(e.getMessage());
        } catch (IncorrectValueException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void getData() throws EmptyStringException, ArrayCountElementException, IncorrectValueException, IOException{

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в порядке указанном ниже:\n" +
                " <Фамилия> <Имя> <Отчество> <Дата рождения> <Телефон> <Пол>\n " +
                "Пример:\n" +
                "Иванов Иван Иванович 01.01.1000 7775552211 m");
        String inputData;
        inputData = scanner.nextLine();
        if (inputData.isEmpty()){
            throw new EmptyStringException("Строка является пустой");
        }

        inputData = inputData.replaceAll("\\s+", " ");
        inputData = inputData.trim();
        String[] bufferArray = inputData.split(" ");
        if (bufferArray.length == 6){
            checkDateFormat(bufferArray[3]);
            checkPhoneNumberFormat(bufferArray[4]);
            checkGenderFormat(bufferArray[5]);
            createFile(bufferArray);

            //Метод toCharArray() создает из строки массив чаров (от англ. - char).
        } else {
            throw new ArrayCountElementException("Введены не все данные пользователя или\n" +
                    "Вы пропустили пробел");
        }




    }

    /**
     * Метод проверяет корректность ввода даты пользователем.
     * @throws IncorrectValueException это исключение генерируется, если
     * пользователь ввёл значение даты, которое не соответствует формату
     * dd.mm.yyyy
     * */
    public static void checkDateFormat(String date) throws IncorrectValueException{

        char[] checkData = date.toCharArray();
        if (checkData.length == 10 && (checkData[2] == '.' && checkData[5] == '.')){

        } else {
            throw new IncorrectValueException("Формат даты введен не правильно. Правильный формат ввода данных dd.mm.yyyy");
        }
    }

    /**
     * Метод проверяет корректность ввода телефона пользователя.
     * @throws IncorrectValueException это исключение генерируется, если
     *пользователь ввёл значение телефона, которое не соответствует формату
     *1112224455
     * */
    public static void checkPhoneNumberFormat(String phoneNumber) throws IncorrectValueException{
        try {
            long check = Long.parseLong(phoneNumber); // ошибка приведения вида
        } catch (IncorrectValueException e){
            throw new IncorrectValueException("Формат телефона пользователя введен не правильно. " +
                    "Правильный формат ввода данных 111222334455, без знака перед номером");
        }
    }

    /**
     * Метод проверяет корректность ввода пола пользователя.
     * @throws IncorrectValueException это исключение генерируется, если
     * пользователь ввёл значение пола, кторое не соответсвует формату
     * 'm' или 'f'
     * */
    public static void checkGenderFormat(String gender) throws IncorrectValueException{
        if (gender.length() == 1){
            gender = gender.toLowerCase();
            if (gender.equals("m") || gender.equals("f")) {
                char[] charArray = gender.toCharArray();
                char convertedGender = charArray[0];
            } else {
                throw new IncorrectValueException("Вы непрвльно указали пол !\n" +
                        "Правильный формат ввода данных, если вы мужчина пропишите 'm', если женщина 'f'.");
            }
        } else {
            throw new IncorrectValueException("Вы неправильно указали пол!\n" +
                    "Пол указывается одним символом, если мужчина 'm', если женщина 'f'.\n" +
                    "Правильный формат ввода данных, если вы мужчина пропишите 'm', если женщина 'f'.");
        }
    }
    /**
     * Метод создает файл формата 'txt', с наименованием которое равно фамилии пользователя
     * и записывает туда данные введенные пользователем. Если фаил с таким именем существует,
     * то данные дозаписываются в этот файл.
     * @throws IOException это исключение генерируется если во время записи или создания файла
     * произошла ошибка.
     * */
    public static void createFile(String[] bufferArray) throws IOException {
        String fileName = bufferArray[0] + ".txt";
        try {
            File path = new File(fileName);

            if (!path.exists()){
                path.createNewFile();
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));

            String writeString = String.join(" ", bufferArray);

            bw.write(writeString);
            bw.newLine();
            bw.close();


        } catch (IOException e){
            throw new IOException("Произошла ошибка во время создания или записи файла");
        }

    }
}

class IncorrectValueException extends RuntimeException{
    public IncorrectValueException(String message) {
        super(message);
    }
}
class EmptyStringException extends RuntimeException{
    public EmptyStringException(String message) {
        super(message);
    }
}

class ArrayCountElementException extends RuntimeException{
    public ArrayCountElementException(String message) {
        super(message);
    }
}
