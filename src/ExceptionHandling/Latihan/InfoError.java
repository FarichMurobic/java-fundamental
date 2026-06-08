package ExceptionHandling.Latihan;

public class InfoError {

    // Unchecked Exception
    static void infoErrorUnchecked() {

        NullPointerException e = new NullPointerException("Top layer");
        e.initCause(new ArithmeticException("cause"));
        throw e; // Lempar error
    }

    // Checked Exception
    // Harus ditambah throws
    static void infoErrorChecked() throws NoSuchMethodException {

        NoSuchMethodException e = new NoSuchMethodException("Top Layer");
        e.initCause(new NegativeArraySizeException("cause"));
        throw e; // Lempar error
    }

    public static void main(String[] args) {
        
        try {
            infoErrorUnchecked();
        } catch (NullPointerException e) {
            System.out.println(e);
            System.out.println(e.getCause());
        }

        System.out.println();

        try {
            infoErrorChecked();
        } catch (NoSuchMethodException exception) {
            System.out.println(exception);
            System.out.println(exception.getCause());
        }
    }
}
