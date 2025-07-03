import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.one.get();
        try {
            int a = calc.plus.apply(1, 2);
            int b = calc.minus.apply(1, 1);
            int c = calc.devide.apply(a, b);
            int d = calc.multiply.apply(a, b);
            boolean f = calc.isPositive.test(-90);

            calc.println.accept(c);
            calc.println1.accept(f);
        } catch (ArithmeticException e) {
            System.out.println("На ноль делить нельзя!");
        }


        // при заданных числах при вызове метода devide происходит деление на ноль.
        // В случае переменной типа int при делении на ноль программа завершается с ошибкой.
        // Такую ситуацию можно учесть, добавив блок try-catch или поставив условие в определнии метода divide
    }
}

class Calculator {
    //    static Supplier<Calculator> one = Calculator::new;
    static Supplier<Calculator> one = () -> {
        return new Calculator();
    };


    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> devide = (x, y) -> (y != 0) ? x / y : 0;

    UnaryOperator<Integer> square = x -> x * x;
    UnaryOperator<Integer> modul = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;
    Consumer<Boolean> println1 = System.out::println;
}