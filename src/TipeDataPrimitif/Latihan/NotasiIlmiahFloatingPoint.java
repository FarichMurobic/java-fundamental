package TipeDataPrimitif.Latihan;

public class NotasiIlmiahFloatingPoint {
    public static void main(String[] args) {

        // Contoh angka besar menggunakan notasi E
        double jarakBintang = 1.23E+5; // Artinya 1.23 * 10^5 = 123000.0
        System.out.println("Jarak bintang (1.23E+5): " + jarakBintang);

        // Contoh angka kecil menggunakan notasi E
        double ukuranAtom = 1.23e-2; // Artinya 1.23 * 10^-2 = 0.0123
        System.out.println("Ukuran atom (1.23e-2): " + ukuranAtom);

        // Angka yang sama, tapi ditulis berbeda
        double limaPoinNol = 5E+0; // Artinya 5 * 10^0 = 5.0
        System.out.println("Lima poin nol (5E+0): " + limaPoinNol);

        double setengah = 5.0E-1; // Artinya 5.0 * 10^-1 = 0.5
        System.out.println("Setengah (5.0E-1): " + setengah);

        // Menggunakan float dengan notasi ilmiah (ingat, pakai F)
        float angkaFloatIlmiah = 3.4F + 38; // Contoh angka float besar
        System.out.println("Angka float ilmiah (3.4F+38): " + angkaFloatIlmiah);

        System.out.println("\n--- Perbandingan Presisi float vs double ---");

        // Perhatikan bagaimana presisi ditampilkan
        float floatPresisi = 0.123456789123456789F; // Batas float sekitar 6-7 digit signifikan
        double doublePresisi = 0.123456789123456789; // double bisa sampai 15 digit signifikan

        System.out.println("Angka float (0.123456789123456789F): " + floatPresisi);
        System.out.println("Angka double (0.123456789123456789): " + doublePresisi);

        /**
         * Kamu bisa lihat sendiri perbedaannya di output.
         * float akan 'memotong' digit setelah batas presisinya.
         *
         * Output
         * Angka float (0.123456789123456789F): 0.12345679
         * Angka double (0.123456789123456789): 0.12345678912345678
         */

    }
}
