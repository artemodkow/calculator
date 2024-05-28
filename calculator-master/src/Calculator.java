import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int base;
            int operationChoice;
            String firstNumberStr;
            String operationSymbol;
            String secondNumberStr;

            String errorMessage = "Неверный ввод! Пожалуйста, введите число от 1 до 4.";
            boolean firstSystemChoice = true;
            while (true) {
                if (firstSystemChoice) {
                    System.out.println("Выберите систему счисления:");
                    System.out.println("1. HEX");
                    System.out.println("2. DEC");
                    System.out.println("3. OCT");
                    System.out.println("4. BIN");
                }

                try {
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            base = 16;
                            break;
                        case 2:
                            base = 10;
                            break;
                        case 3:
                            base = 8;
                            break;
                        case 4:
                            base = 2;
                            break;
                        default:
                            System.out.println(errorMessage);
                            firstSystemChoice = false;
                            continue;
                    }
                    break;
                } catch (java.util.InputMismatchException e) {
                    System.out.println(errorMessage);
                    firstSystemChoice = false;
                    scanner.next();
                }
            }

            boolean isFirstFirstNumberInput = true;
            do {
                if (isFirstFirstNumberInput) {
                    System.out.println("Введите первое число:");
                }
                firstNumberStr = scanner.next();
                isFirstFirstNumberInput = NumberSystem.isValidNumber(firstNumberStr, base);
            } while (!isFirstFirstNumberInput);

            boolean firstOperationChoice = true;
            do {
                if (firstOperationChoice) {
                    System.out.println("Выберите операцию:");
                    System.out.println("1. Добавление (+)");
                    System.out.println("2. Вычитание (-)");
                    System.out.println("3. Умножение (*)");
                    System.out.println("4. Деление (/)");
                }

                while (!scanner.hasNextInt()) {
                    System.out.println(errorMessage);
                    scanner.next();
                }
                operationChoice = scanner.nextInt();

                if (operationChoice < 1 || operationChoice > 4) {
                    System.out.println(errorMessage);
                    firstOperationChoice = false;
                } else {
                    firstOperationChoice = true;
                }
            } while (operationChoice < 1 || operationChoice > 4);

            switch (operationChoice) {
                case 1: operationSymbol = "+"; break;
                case 2: operationSymbol = "-"; break;
                case 3: operationSymbol = "*"; break;
                case 4: operationSymbol = "/"; break;
                default: operationSymbol = ""; break;
            };

            boolean isFirstSecondNumberInput = true;
            do {
                if (isFirstSecondNumberInput) {
                    System.out.println("Введите второе число:");
                }
                secondNumberStr = scanner.next();
                isFirstSecondNumberInput = NumberSystem.isValidNumber(secondNumberStr, base);
            } while (!isFirstSecondNumberInput);

            try {
                int firstNumber = NumberSystem.convertToDecimal(firstNumberStr, base);
                int secondNumber = NumberSystem.convertToDecimal(secondNumberStr, base);

                Operation operation;
                switch (operationSymbol) {
                    case "+":
                        operation = new Addition();
                        break;
                    case "-":
                        operation = new Subtraction();
                        break;
                    case "*":
                        operation = new Multiplication();
                        break;
                    case "/":
                        operation = new Division();
                        break;
                    default:
                        return;
                }

                int result = operation.operate(firstNumber, secondNumber);

                System.out.println("Результат в HEX: " + NumberSystem.convertFromDecimal(result, 16));
                System.out.println("Результат в DEC: " + NumberSystem.convertFromDecimal(result, 10));
                System.out.println("Результат в OCT: " + NumberSystem.convertFromDecimal(result, 8));
                System.out.println("Результат в BIN: " + NumberSystem.convertFromDecimal(result, 2));
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
            System.out.println();
        }
    }
}
