package TipeDataPrimitif.Latihan;

public class HitungLuasLingkaran {
    public static void main(String[] args) {

        /**
         * Contoh program Area.java Program ini menggunakan tipe double
         * untuk menghitung luas lingkaran, karena double bisa menyimpan nilai desimal seperti pi dan r.
         */

        double pi, r, a;
        r = 10.8; // jari-jari lingkaran.
        pi = 3.1416; // pi kira-kira
        a = pi * r * r; // rumus menghitung luas.

        System.out.println("Luas lingkaran adalah " + a);

    }
}
