package FundamentalJava.Methods.MethodOverriding.Latihan;

public class MainApp {
    public static void main(String[] args) {

        // Membuat objek
        BangunDatar bd = new BangunDatar(10,10);
        PersegiPanjang pp = new PersegiPanjang(9,5);
        Segitiga sg = new Segitiga(10,8);

        // Reference umum polymorfisme
        BangunDatar referensi;

        // Kasus 1: Mengarah ke Persegi Panjang
        referensi = pp;
        System.out.println("Luas = " + referensi.hitungLuas());
        System.out.println();

        // Kasus 2: Mengarah ke Segitiga
        referensi = sg;
        System.out.println("Luas = " + referensi.hitungLuas());
        System.out.println();

        // Kasus 3: Mengarah ke BangunDatar biasa
        referensi = bd;
        System.out.println("Luas = " + referensi.hitungLuas());

        /**
         * Output
         * Menghitung luas Persegi Panjang...
         * Luas = 45
         *
         * Menghitung luas Segitiga...
         * Luas = 40
         *
         * Luas BangunDatar belum didefinisikan.
         * Luas = 0
         *
         * Penjelasan Singkat (Biar Nempel)
         * 1. Struktur
         * BangunDatar → class umum
         * PersegiPanjang, Segitiga → class spesifik
         *
         * 2. Override Terjadi Di Sini
         * double hitungLuas()
         * tiap subclass punya rumus sendiri
         *
         * 3. Ini Kunci Polymorphism
         * BangunDatar referensi;
         * satu variabel bisa menunjuk ke banyak object
         *
         * 4. Dynamic Dispatch
         * referensi = pp;
         * referensi.hitungLuas();
         *
         * yang jalan = versi PersegiPanjang
         *
         * =================================
         * 
         * Insight Penting
         * Lu cukup panggil:
         * referensi.hitungLuas();
         *
         * Java otomatis:
         * milih method yang benar
         * berdasarkan object
         */

    }
}
