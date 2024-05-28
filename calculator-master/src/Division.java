public class Division extends Operation {
    @Override
    int operate(int operand1, int operand2) {
        if (operand2 == 0) {
            throw new ArithmeticException("Деление на ноль!");
        }
        return operand1 / operand2;
    }
}
