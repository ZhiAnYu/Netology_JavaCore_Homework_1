import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.one.get();
        try {
            int a = calc.plus.apply(1, 2);
            int b = calc.minus.apply(1, 1);
            int c = calc.devide.apply(a, b);
            calc.println.accept(c);
        } catch (ArithmeticException e) {
            System.out.println("На ноль делить нельзя!");
        }


        // при заданных числах при вызове метода devide происходит деление на ноль.
        // В случае переменной типа int при делении на ноль программа завершается с ошибкой.
        // Такую ситуацию можно учесть, добавив блок try-catch
    }
}

class Calculator {
    static Supplier<Calculator> one = Calculator::new;
    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> devide = (x, y) -> x / y;

    UnaryOperator<Integer> square = x -> x * x;
    UnaryOperator<Integer> modul = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;
}