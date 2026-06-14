package SimpleProjects.Kalkulator.KalkulatorLevelMenengah;

public class KalkulatorDasar {
    protected double a,b;

    public KalkulatorDasar(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double pertambahan() {
        return a + b;
    }

    public double pengurangan() {
        return a - b;
    }

    public void info() {
        System.out.println("Angka 1: " + a);
        System.out.println("Angka 2: " + b);
    }
}
