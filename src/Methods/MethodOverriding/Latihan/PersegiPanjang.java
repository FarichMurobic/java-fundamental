package Methods.MethodOverriding.Latihan;

public class PersegiPanjang extends BangunDatar {

    // konstruktor
    PersegiPanjang(double panjang, double lebar) {
        super(panjang, lebar); // panggil construktor parent
    }

    // Override method hitungLuas()
    @Override
    double hitungLuas() {
        System.out.println("Menghitung luas persegi panjang...");
        return dim1 * dim2; // panjang x lebar
    }
}
