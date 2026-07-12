package FundamentalJava.Variable;

public class InisialisasiDinamis {
    public static void main(String[] args) {

        /**
         * Inisialisasi Dinamis
         * 
         * Meskipun contoh-contoh sebelumnya hanya menggunakan konstanta (angka tetap) sebagai
         * pengisi nilai awal, Java sebenarnya mengizinkan variabel untuk diinisialisasi secara dinamis.
         * Artinya, lo bisa pakai ekspresi apa pun yang valid pada saat variabel itu dideklarasikan.
         *
         * Contohnya, program singkat ini menghitung panjang sisi miring (hipotenusa) dari segitiga siku-
         * siku berdasarkan panjang dua sisi lainnya:
         */

        // a dan b diinisialisasi statis
        double a = 3.0, b = 4.0;

        // c diinisialisasi secara dinamis
        double c = Math.sqrt(a * a + b * b);

        System.out.println("Sisi miringnya adalah " + c);

        /**
         * Di sini, tiga variabel lokal—a, b, dan c—dideklarasikan. Dua yang pertama, a dan b, diisi
         * dengan angka tetap (konstanta). Namun, c diinisialisasi secara dinamis menggunakan
         * rumus Pythagoras. Program ini menggunakan metode bawaan Java, Math.sqrt(), untuk
         * menghitung akar kuadrat.
         *
         * Poin utamanya: Ekspresi pengisian nilai boleh menggunakan elemen apa pun yang tersedia saat
         * itu, termasuk memanggil method (fungsi), variabel lain, atau angka mentah.
         */

    }
}
