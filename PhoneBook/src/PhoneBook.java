import java.util.Scanner;
import java.util.Arrays;

public class PhoneBook {

    public static void main(String[] args) {
        String[][] book = new String[0][2];
        String name = "";
        String phoneNumber = "";
        Scanner scanner = new Scanner(System.in);
        boolean isCorrectName = false;
        boolean isCorrectPhone = false;
        book = arrayLengthChange(book, book.length+1);
        while (!isCorrectName) {
            System.out.print("Введите Фамилию, Имя, Отчество (через пробел): ");
            name = scanner.nextLine();
            isCorrectName = checkName(name);
            if (!isCorrectName) {
                System.out.println("Введите корректное имя!");
            }
        }
        while (!isCorrectPhone) {
            System.out.print("Введите номер телефона в формате X XXX XXX XX XX: ");
            phoneNumber = scanner.nextLine();
            isCorrectPhone = checkPhoneNumber(phoneNumber);
            if (!isCorrectPhone) {
                System.out.println("Введите корректный номер телефона!");
            }
        }
        add(book, formatName(name), formatPhoneNumber(phoneNumber));
        list(book);
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        String cleanNumber = phoneNumber.trim().replaceAll("[^0-9]", "");
        return cleanNumber.length() == 11;
    }

    public static boolean checkName(String name) {
        String[] words = name.trim().split(" ");
        return words.length == 3;
    }


    public static String formatName(String name) {
        String[] words = name.trim().split(" ");
        String formattedName = "";
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            char firstChar = str.charAt(0);
            if (!Character.isUpperCase(firstChar)) {
                formattedName += Character.toUpperCase(firstChar) + words[i].substring(1) + " ";
            } else {
                formattedName = name;
            }

        }
        return formattedName;
    }

    public static String formatPhoneNumber(String number) {
        String cleanNumber = number.replaceAll("[^0-9]", "");
        return String.format("+7 %s %s %s %s", cleanNumber.substring(1, 4), cleanNumber.substring(4, 7), cleanNumber.substring(7, 9), cleanNumber.substring(9));
    }

    public static void add(String[][] book, String name, String number) {
        book[0][0] = name;
        book[0][1] = number;
    }

    public static void list(String[][] book) {

        for (int i = 0; i < book.length; i++) {
            System.out.println(Arrays.deepToString(book));
            System.out.printf("%s: %s", book[0][0], book[0][1]);
        }
    }

    public static String[][] arrayLengthChange(String[][] arr, int newLength) {
        String[][] arrNew = new String[newLength][2];
        System.arraycopy(arr, 0, arrNew, 0, arr.length);
        return arrNew;
    }
}
