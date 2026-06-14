package FundamentalJava.Abstract.Latihan;

public abstract class Kalkulator {

    double a;
    double b;

    Kalkulator(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public abstract double operasiMatematika();

}

class Pertambahan extends Kalkulator {

    Pertambahan(double a, double b) {
        super(a, b);
    }

    @Override
    public double operasiMatematika() {
        return a + b;
    }
}

class Pengurangan extends Kalkulator {

    Pengurangan(double a, double b) {
        super(a, b);
    }

    @Override
    public double operasiMatematika() {
        return a - b;
    }
}

class Perkalian extends Kalkulator {

    Perkalian(double a, double b) {
        super(a, b);
    }

    @Override
    public double operasiMatematika() {
        return a * b;
    }
}

class Pembagian extends Kalkulator {

    Pembagian(double a, double b) {
        super(a, b);
    }

    @Override
    public double operasiMatematika() {
        if (b == 0) {
            System.out.println("Tidak bisa dibagi dengan 0!");
        }

        return a / b;
    }
}

class MainApp {
    public static void main(String[] args) {

        Pertambahan pertambahan = new Pertambahan(10.0, 10.0);
        double hasilPertambahan = pertambahan.operasiMatematika();
        System.out.println(hasilPertambahan);

        Pengurangan pengurangan = new Pengurangan(100.0, 50.0);
        double hasilPengurangan = pengurangan.operasiMatematika();
        System.out.println(hasilPengurangan);

        Perkalian perkalian = new Perkalian(10.0, 10.0);
        double hasilPerkalian = perkalian.operasiMatematika();
        System.out.println(hasilPerkalian);

        Pembagian pembagian = new Pembagian(100.0, 10.0);
        double hasilPembagian = pembagian.operasiMatematika();
        System.out.println(hasilPembagian);

    }
}