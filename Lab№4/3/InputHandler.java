import java.util.InputMismatchException;
import java.util.Scanner;

class CustomInputMismatchException extends Exception {
    public CustomInputMismatchException(String message) {
        super(message);
    }
}

public class InputHandler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число: ");

        try {
            int number = readInteger(scanner);
            System.out.println("Вы ввели: " + number);
        } catch (CustomInputMismatchException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static int readInteger(Scanner scanner) throws CustomInputMismatchException {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new CustomInputMismatchException("Введено не целое число.");
        }
    }
}