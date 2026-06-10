package Methods.MethodOverriding.Latihan;

public class Segitiga extends BangunDatar {

    // konstruktor
    Segitiga(double alas, double tinggi) {
        super(alas, tinggi); // panggil construktor parent
    }

    // override method hitung luas
    @Override
    double hitungLuas() {
        System.out.println("Menghitung luas segitiga...");
        return (dim1 * dim2) / 2; // (alas * tinggi) / 2
    }

}
