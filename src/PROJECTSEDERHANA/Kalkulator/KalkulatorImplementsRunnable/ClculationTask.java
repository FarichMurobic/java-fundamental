package PROJECTSEDERHANA.Kalkulator.KalkulatorImplementsRunnable;

public class ClculationTask implements Runnable {

    private double a, b;
    private char op;
    private Kalkulator calc;

    public ClculationTask(double a, double b, char op, Kalkulator calc) {
        this.a = a;
        this.b = b;
        this.op = op;
        this.calc = calc;
    }

    @Override
    public void run() {
        try {
            double result = calc.calculate(a, b, op);
            System.out.println("Hasil (" + a + " " + op + " " + b + ") = " + result);
        } catch (ValidationException e) {
            System.out.println("Error di thread: " + e.getMessage());
        }
    }
}
// unreported exception ProjectSederhana.Kalkulator.KalkulatorAkarKuadrat.ValidationException; must be caught or declared to be thrown
// exception ProjectSederhana.Kalkulator.KalkulatorImplementsRunnable.ValidationException is never thrown in body of corresponding try statement