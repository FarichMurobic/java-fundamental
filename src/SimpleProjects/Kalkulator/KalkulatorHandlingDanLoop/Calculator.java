package SimpleProjects.Kalkulator.KalkulatorHandlingDanLoop;

public class Calculator {

    public double calculate(double a, double b, char operator) throws InvalidOperatorException {

        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Tidak bisa dibagi dengan nol.");
                } return a / b;
            default:
                throw new InvalidOperatorException("Operator nya salah beghok.");
        }
    }
}
