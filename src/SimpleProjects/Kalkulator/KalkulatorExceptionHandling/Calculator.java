package SimpleProjects.Kalkulator.KalkulatorExceptionHandling;

// class kalkulator
// logika aritmatika
public class Calculator {

    // buat methode logika aritmatika, dengan throws kontrak error dengan pemanggil methode.
    public double calculate(double a, double b, char operator) throws InvalidOperatorException {

        // menggunakan switch untuk kasus ini.
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    // lempar error. karena error pembagian maka ArithmeticException cocok.
                    throw new ArithmeticException("Tidak bisa dibagi dengan nol.");
                }
                return a / b;
            default:
                // lempar error, jenis error buatan sendiri untuk mendemonstrasikan error operator.
                throw new InvalidOperatorException("operator tidak valid.");
        }
    }
}
