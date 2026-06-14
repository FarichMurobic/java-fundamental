package SimpleProjects.Kalkulator.KalkulatorSederhana;

public class KalkulatorCanggih extends KalkulatorDasar {

    public KalkulatorCanggih(int a, int b) {
        super(a, b); // panggil konstruktor parent
    }

    public int kali() {
        return a * b;
    }

    public double bagi() {
        if (b == 0) {
            System.out.println("Tidak bisa dibagi nol!");
            return 0;
        }
        return (double) a / b;
    }

    public double modulus() {
        if (b == 0) {
            System.out.println("Tidak bisa dibagi nol!");
            return 0;
        }
        return a % b;

    }

}
