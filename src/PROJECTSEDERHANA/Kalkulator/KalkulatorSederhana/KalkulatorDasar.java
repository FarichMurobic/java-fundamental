package PROJECTSEDERHANA.Kalkulator.KalkulatorSederhana;

public class KalkulatorDasar {
    int a, b;

    public KalkulatorDasar(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int tambah() {
        return a + b;
    }

    public int kurang() {
        return a - b;
    }
}
