import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim().replaceAll(" ", "");
        try {
            String result = calc(input);
            System.out.println(result);
        } catch (ExceptionCalc e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();
        }
    }

    public static String calc(String input) throws ExceptionCalc {
        Tasks task = new Tasks();
        task.chekInputString(input);
        int a1 = input.indexOf("/");
        int a2 = input.indexOf("*");
        int a3 = input.indexOf("-");
        int a4 = input.indexOf("+");
        int indexSplit = a1 + a2 + a3 + a4 + 3;
        String substring1 = input.substring(0, indexSplit);
        String substring2 = input.substring(indexSplit + 1);
        int num1, num2;
        boolean rim = substring1.charAt(0) == 'I' || substring1.charAt(0) == 'V' || substring1.charAt(0) == 'X';
        if (rim) {
            num1 = task.convertRimToArab(substring1);
            num2 = task.convertRimToArab(substring2);
        } else {
            num1 = Integer.parseInt(substring1);
            num2 = Integer.parseInt(substring2);
        }
        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new ExceptionCalc("Исключение. Ошибка ввода! Числа должны быть в диапазоне от 1 до 10 включительно!");
        }
        // Деление
        if (a1 > 0) {
            if (rim) {
                if (num2 > num1) {
                    throw new ExceptionCalc("Исключение. Ошибка ввода! Второе римское число больше первого!");
                } else {
                    return task.convertArabToRim(num1 / num2);
                }
            } else {
                return "" + (num1 / num2);
            }
        }
        // Умножение
        if (a2 > 0) {
            if (rim) {
                return task.convertArabToRim(num1 * num2);
            } else {
                return "" + (num1 * num2);
            }
        }
        // Вычитание
        if (a3 > 0) {
            if (rim) {
                if (num2 >= num1) {
                    throw new ExceptionCalc("Исключение. Ошибка ввода! Второе римское число больше первого или равно ему!");
                } else {
                    return task.convertArabToRim(num1 - num2);
                }
            } else {
                return "" + (num1 - num2);
            }
        }
        // Сложение
        if (a4 > 0) {
            if (rim) {
                return task.convertArabToRim(num1 + num2);
            } else {
                return "" + (num1 + num2);
            }
        }
    return "";
    }
}
