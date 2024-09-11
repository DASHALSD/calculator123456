import java.util.Scanner;

public class Calculator12345 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите операцию в формате: a оператор b");

        try {
            // Читаем строку ввода
            String input = scanner.nextLine();

            // Разделяем строку по пробелам
            String[] parts = input.split(" ");

            // Проверяем, что строка состоит из трех частей
            if (parts.length != 3) {
                throw new IllegalArgumentException("Неверный формат ввода. Ожидалось: a оператор b");
            }

            // Извлекаем числа и оператор
            int a = Integer.parseInt(parts[0]);
            String operator = parts[1];
            int b = Integer.parseInt(parts[2]);

            // Проверяем, что числа находятся в пределах от 1 до 10 включительно
            if (a < 1 || a > 10 || b < 1 || b > 10) {
                throw new IllegalArgumentException("Числа должны быть в диапазоне от 1 до 10 включительно");
            }

            // Выполняем арифметическую операцию в зависимости от оператора
            int result;
            switch (operator) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    if (b == 0) {
                        throw new ArithmeticException("Деление на ноль");
                    }
                    result = a / b;
                    break;
                default:
                    throw new IllegalArgumentException("Неизвестный оператор. Используйте +, -, * или /");
            }

            // Выводим результат
            System.out.println("Результат: " + result);

        } catch (NumberFormatException e) {
            System.err.println("Ошибка: Введите корректные целые числа.");
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}