public class NumberSystem {
    static int convertToDecimal(String number, int base) {
        return Integer.parseInt(number, base);
    }

    static String convertFromDecimal(int number, int base) {
        return Integer.toString(number, base);
    }

    public static boolean isValidNumber(String number, int base) {
        try {
            convertToDecimal(number, base);
            if(base == 2){
                if(number.startsWith("-0")){
                    throw new NumberFormatException();
                }
                return true;
            }
            if (number.length() > 1) {
                if (number.startsWith("0") && !number.startsWith("0.")) {
                    throw new NumberFormatException();
                }
                else if(number.startsWith("-0")){
                    throw new NumberFormatException();
                }
            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Неверный ввод числа!");
            return false;
        }
    }
}
