package SimpleProjects.Kalkulator.KalkulatorExceptionHandling;

// custom exception
// buat sendiri jenis error
public class InvalidOperatorException extends Exception {

    // Konstruktor
    public InvalidOperatorException(String message) {
        super(message);
    }
}
