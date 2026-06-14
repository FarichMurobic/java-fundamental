package SimpleProjects.Kalkulator.KalkulatorImplementsRunnable;

public class Kalkulator {

    public double calculate(double a, double b, char op) throws ValidationException {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) {
                    throw new ValidationException("Tidak bisa dibagi nol!");
                }
                return a / b;
            default:
                throw new ValidationException("Operator tidak valid.");
        }
    }
}
