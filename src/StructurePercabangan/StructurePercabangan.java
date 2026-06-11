package StructurePercabangan;

public class StructurePercabangan {
    public static void main(String[] args) {

        /**
         * Struktur seleksi
         * di java ada 3 cara utama untuk mengambil keputusan atau menyeleksi seuah aksi.
         * 1, if - jalur satu arah
         * 2, if else - jalur dua arah
         * 3, switch - banyak jalur
         *
         * Kesalahan umum dalam pemtograman if statement
         * = vs ==              - operator = adalah untuk memberi nilai (assignment),
         *                        bukan membandingkan. menggunakannya di if akan menghasilkan error
         * Tidak ada ()         - Kondisi if harus selalu berada di dalam tanda kurung (),
         *                        ini adalah aturan wajib
         * Semicolon setelah if - Menambahkan ; setelah if akan mengakhiri pernyataan if tersebut,
         *                        aksi yg seharusnya dieksekusi akan menjadi aksi kosong dan blok kode dibawahnya selalu dijalankan.
         * Tidak ada {}         - Tanpa kurung kurawal, if hanya akan menganggap satu baris kode dibawahnya sebagai aksi.
         *                        jika butuh lebih dari 1 aksi, harus pakai {}.
         */

        /**
         * if adalah pernyataan percabangan kondisional. Lo ngasih syarat, kalau syaratnya tembus
         * (bernilai true), Java jalanin perintahnya. Kalau nggak tembus (false), Java jalanin perintah di
         * bagian else.
         *
         * if (condition) {
         *     // dijalankan jika kondisi true
         * } else {
         *     // dijalankan jika kondisi false
         * }
         */

        /**
         * IF Statement
         * if adalah percabangan kondisi di Java.
         * Dia memungkinkan program memilih dua jalur eksekusi yang berbeda.
         * Bentuk umum:
         *
         * if (kondisi)
         *    statement1;
         * else
         *    statement2;
         *
         * Penjelasan:
         * condition → ekspresi yang menghasilkan boolean
         * statement1 → dijalankan jika kondisi true
         * statement2 → dijalankan jika kondisi false
         * else bersifat opsiona
         *
         * Yang penting:
         * Tidak mungkin dua statement dijalankan sekaligus.
         */

        int a, b;
        a = 5;
        b = 5;

        if (a < b)
            a = 10;
        else
            b = 10;

        // b sekarang bernilai 10
        System.out.println(b); // 10

        /**
         * IF Tidak harus pakai operator perbandingan
         * biasanya if menggunakan relational operator seperti:
         * <
         * >
         * <=
         * >=
         * ==
         * !=
         *
         * Tapi sebenernya tidak wajib.
         * karena if hanya membutuhkan nilai boolean
         */

        boolean data;
        data = true;

        if (data)
            data = !data;
        else
            data = false;

        System.out.println(data); // false

        // Pakai block kode {} artinya kita bisa membuat lebih dari 1 statement
        a = 50; // reset nilai
        b = 20; // reset nilai

        if (a > b) { // block kode
            System.out.println("a lebih besar dari b"); // statement 1
            a += 50; // statement 2
        } else {
            System.out.println("a lebih kecil dari b"); // statement 1
            b += 80; // statement 2
        }

        // Semua statement selama dalam block kode akan dieksekusi oleh if ketika pake block kode.
        System.out.println(a); // 100

        // jangan gunakan if statement yang panjang hanya untuk mengsisi variabel boolean
        char charOne = 'q';
        boolean isLowerCaseLetter;

        // ini cara yang buruk dan bertele-tele
        if ('a' <= charOne && charOne <= 'z')
            isLowerCaseLetter = true;
        else
            isLowerCaseLetter = false;

        System.out.println(isLowerCaseLetter);

        // cara yang baik (ringkas dan langsung)
        isLowerCaseLetter = ('a' <= charOne && charOne <= 'z'); // cukup pakai 1 baris kode.
        System.out.println(isLowerCaseLetter);

        // Tanpa block kode
        double ongkir = 50000.0;
        double saldo = 100000.0;

        if (saldo >= ongkir)
            saldo -= ongkir; // Java bilang: "Oke, ini bagian IF."
            // System.out.println();. Tanpa block kode ini akan error karena ada else, Java bilang: "Ini baris biasa, jalanin aja."
        else // ERROR! Java teriak: "Woi, 'else' ini nggak punya pasangan 'if' di atasnya!"
            System.out.println("Saldo kurang bro!.");
        System.out.println(saldo);

        System.out.println();

        /**
         * Kenapa Kode Itu Error? (The "Else Without If" Problem)
         * Di Java, sebuah else WAJIB menempel langsung tepat setelah pernyataan if selesai.
         * - Kalau lo nggak pake block { }, Java cuma nganggep satu baris pertama setelah if
         *   sebagai bagian dari kondisi tersebut.
         *
         * - Baris kedua (System.out.println();) dianggap sebagai baris kode biasa yang mandiri (nggak ikut if).
         * - Nah, pas Java sampai ke baris else, dia bingung: "Lho, ini 'else' punya siapa? Di atas gue
         *   ada perintah cetak biasa, bukan akhir dari sebuah 'if'."
         *
         * Secara teknis, baris System.out.println(); itu memutus hubungan asmara antara if
         * dan else. Di Java, else itu setia banget, dia nggak mau dipisahin sama baris kode lain dari if-nya.
         */

        // Dengan block kode sang pemersatu hubungan asmara if dan else
        if (saldo > ongkir) {
            saldo -= ongkir;
            System.out.println(saldo);
        } else {
            System.out.println("Saldo kurang bro!.");
            System.out.println("Coba isi lagi saldonya!.");
        }

    }
}
