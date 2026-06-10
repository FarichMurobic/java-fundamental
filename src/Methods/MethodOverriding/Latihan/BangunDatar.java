package Methods.MethodOverriding.Latihan;

// SUPERCLASS
public class BangunDatar {

    double dim1; // bisa jadi panjang atau alas
    double dim2; // bisa jadi lebar / tinggi

    // konstruktor
    BangunDatar(double a, double b) {
        dim1 = a;
        dim2 = b;
    }

    // Method untuk menghitung luas (versi umum / belum jelas)
    double hitungLuas() {
        System.out.println("Luas Bangundatar belum didefinisikan.");
        return 0;
    }

}
