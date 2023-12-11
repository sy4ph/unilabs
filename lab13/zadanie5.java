package lab13;

import java.util.Scanner;

public class zadanie5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;

        do {
            System.out.print("Введите номер телефона в виде +<Код страны><Номер 10 цифр> или 8<Номер 10 цифр>: ");
            String phoneNumber = scanner.next();

            if (isValidPhoneNumber(phoneNumber)) {
                isValid = true;
                String formattedPhoneNumber = formatPhoneNumber(phoneNumber);
                System.out.println("Ваш номер в правильном формате: " + formattedPhoneNumber);
            } else {
                System.out.println("Неправильно введен номер телефона. Попробуйте снова.");
            }
        } while (!isValid);
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        int length = phoneNumber.length();
        if (length == 12 && phoneNumber.charAt(0) == '+' || (length == 11 && phoneNumber.charAt(0) == '8')) {
            for (int i = 1; i < length; i++) {
                if (!Character.isDigit(phoneNumber.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static String formatPhoneNumber(String phoneNumber) {
        if (phoneNumber.charAt(0) == '8') {
            phoneNumber = "+7" + phoneNumber.substring(1);
        }
        return phoneNumber.replaceAll("\\+(\\d{1})(\\d{3})(\\d{3})(\\d{4})$", "$1$2-$3-$4");
    }
}

