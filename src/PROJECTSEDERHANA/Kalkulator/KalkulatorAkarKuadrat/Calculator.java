package PROJECTSEDERHANA.Kalkulator.KalkulatorAkarKuadrat;

public class Calculator {

    public double calculate(double a, double b, char op) throws ValidationException {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': if (b == 0) throw  new ValidationException("Tidak bisa dibagi dengan nol!");
            return a / b;
            case '^': return Math.pow(a, b); // pangkat
            default: throw new ValidationException("Operator tidak valid!.");
        }
    }

    public double sqrt(double a) throws ValidationException {
        if (a < 0) {
            throw new ValidationException("Tidak bisa akar dari negatif!.");
        } return Math.sqrt(a);
    }
}
