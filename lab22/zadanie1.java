package lab22;

import java.util.Scanner;
import java.util.Stack;
public class zadanie1 {
    public static double RPNcount(String expression) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            }
            else {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid form!");
                }

                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result;

                switch (token) {
                    case "+" -> result = operand1 + operand2;
                    case "-" -> result = operand1 - operand2;
                    case "*" -> result = operand1 * operand2;
                    case "/" -> {
                        if (operand2 == 0) {
                            throw new ArithmeticException("Division by zero");
                        }
                        result = operand1 / operand2;
                    }
                    default -> throw new IllegalArgumentException("Error " + token);
                }
                stack.push(result);
            }
        }
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid form!");
        }
        return stack.pop();
    }

    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        try {
            double result = RPNcount(expression);
            System.out.println("Result: " + result);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}