package SimpleProjects.Kalkulator.KalkulatorLevelMenengah;

import java.util.ArrayList;

public class KalkulatorLanjutan extends KalkulatorDasar {

    ArrayList<String> history = new ArrayList<>();

    public KalkulatorLanjutan(double a, double b) {
        super(a, b); // ambil dari parent
    }

    public double perkalian() {
        double hasil = a * b;
        history.add(a + " x " + b + " = " + hasil);
        return hasil;
    }

    public double pembagian() {
        if (b == 0) {
            System.out.println("Error tidak bisa dibagi Nol!.");
            return 0;
        }
        double hasil = a / b;
        history.add(a + " / " + b + " = " + hasil);
        return hasil;
    }

    // override + super
    @Override
    public double pertambahan() {
        double hasil = super.pertambahan(); // pakai parent
        history.add(a + " + " + b + " = " + hasil);
        return hasil;
    }

    @Override
    public double pengurangan() {
        double hasil = super.pengurangan(); // pakai parent
        history.add(a + " - " + b + " = " + hasil);
        return hasil;
    }

    public void tampilkanHistory() {
        System.out.println("----- History -----");
        for (String h : history) {
            System.out.println(h);
        }
    }
}
