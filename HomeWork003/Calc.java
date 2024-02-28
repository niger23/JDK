package HomeWork003;

public class Calc {

    public static <T extends Number> double sum(T num1, T num2) {
        if (num1 instanceof Integer && num2 instanceof Integer) {
            return Integer.valueOf(num1.intValue() + num2.intValue());
        } else if (num1 instanceof Double || num2 instanceof Double) {
            return Double.valueOf(num1.doubleValue() + num2.doubleValue());
        } else {
            throw new IllegalArgumentException("Данный тип не поддерживается");
        }
    }

    public static <T extends Number> double multiply(T num1, T num2) {
        if (num1 instanceof Integer && num2 instanceof Integer) {
            return Integer.valueOf(num1.intValue() * num2.intValue());
        } else if (num1 instanceof Double || num2 instanceof Double) {
            return Double.valueOf(num1.doubleValue() * num2.doubleValue());
        } else {
            throw new IllegalArgumentException("Данный тип не поддерживается");
        }
    }

    public static <T extends Number> double divide(T num1, T num2) {
        if (num2.doubleValue() != 0) {
            if (num1 instanceof Integer && num2 instanceof Integer) {
                return Double.valueOf(num1.intValue() / num2.intValue());
            } else if (num1 instanceof Double || num2 instanceof Double) {
                return Double.valueOf(num1.doubleValue() / num2.doubleValue());
            } else {
                throw new IllegalArgumentException("Данный тип не поддерживается");
            }
        } else {
            throw new IllegalArgumentException("Деление на ноль недопустимо");
        }
    }

    public static <T extends Number> double subtract(T num1, T num2) {
        if (num1 instanceof Integer && num2 instanceof Integer) {
            return Integer.valueOf(num1.intValue() - num2.intValue());
        } else if (num1 instanceof Double || num2 instanceof Double) {
            return Double.valueOf(num1.doubleValue() - num2.doubleValue());
        } else {
            throw new IllegalArgumentException("Данный тип не поддерживается");
        }
    }

    public static void main(String[] args) {

        System.out.println("51 + 3.2 = " + Calc.sum(51, 3.2));
        System.out.println("100 / 0.0001 = " + Calc.divide(100, 0.0001));
        System.out.println("10.1 - 5 = " + Calc.subtract(10.1, 5));
        System.out.println("8 * 2.0 = " + Calc.multiply(8, 2.0));
    }
}
