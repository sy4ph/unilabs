package lab11;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class zadanie2 {
    public static void main(String[] args) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        Scanner scanner = new Scanner(System.in);
        LocalDateTime userDateTime = null;

        do {
            System.out.print("Введите дату и время в формате дд.мм.гггг чч:мм:сс -> ");
            String userInput = scanner.nextLine();
            try {
                userDateTime = LocalDateTime.parse(userInput, formatter);
            } catch (java.time.format.DateTimeParseException e) {
                System.out.println("Формат ввода не соответствует dd.MM.yyyy HH:mm:ss.");
            }
        } while (userDateTime == null);

        if (currentDateTime.isBefore(userDateTime)) {
            System.out.println("Будущее");
        } else if (currentDateTime.isAfter(userDateTime)) {
            System.out.println("Прошлое");
        } else {
            System.out.println("Настоящее");
        }
    }
}
