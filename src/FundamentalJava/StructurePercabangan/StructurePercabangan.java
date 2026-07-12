package FundamentalJava.StructurePercabangan;

/**
 * ------------------------------------------------------------------------
 * STRUKTUR SELEKSI DI JAVA
 * ------------------------------------------------------------------------
 * 
 * Di Java ada 3 cara utama untuk mengambil keputusan atau menyeleksi sebuah aksi:
 * 
 * 1. if          → Jalur satu arah
 * 2. if-else     → Jalur dua arah
 * 3. switch      → Banyak jalur
 * 
 * ------------------------------------------------------------------------
 * IF STATEMENT
 * ------------------------------------------------------------------------
 * 
 * if adalah pernyataan percabangan kondisional.
 * 
 * Kamu memberi syarat:
 * - Jika syaratnya tembus (bernilai true) → Java menjalankan perintahnya
 * - Jika tidak tembus (false) → Java menjalankan perintah di bagian else
 * 
 * Bentuk umum:
 * 
 *     if (kondisi) {
 *         // dijalankan jika kondisi true
 *     } else {
 *         // dijalankan jika kondisi false
 *     }
 * 
 * Penjelasan:
 * - kondisi → ekspresi yang menghasilkan nilai boolean (true/false)
 * - statement1 → dijalankan jika kondisi true
 * - statement2 → dijalankan jika kondisi false
 * - else bersifat OPSIONAL (boleh ada, boleh tidak)
 * 
 * Yang penting:
 * TIDAK MUNGKIN dua statement dijalankan sekaligus.
 * Hanya satu jalur yang akan dieksekusi.
 * 
 * ------------------------------------------------------------------------
 * CONTOH IF STATEMENT
 * ------------------------------------------------------------------------
 * 
 *     int umur = 18;
 * 
 *     if (umur >= 17) {
 *         System.out.println("Kamu sudah cukup umur");
 *     } else {
 *         System.out.println("Kamu belum cukup umur");
 *     }
 * 
 *     // Output: Kamu sudah cukup umur
 * 
 * ------------------------------------------------------------------------
 * IF TANPA ELSE (SATU JALUR)
 * ------------------------------------------------------------------------
 * 
 *     int nilai = 85;
 * 
 *     if (nilai >= 75) {
 *         System.out.println("Lulus");
 *     }
 * 
 *     // Jika nilai >= 75, tampilkan "Lulus"
 *     // Jika tidak, tidak ada yang terjadi
 * 
 * ------------------------------------------------------------------------
 * KESALAHAN UMUM DALAM IF STATEMENT
 * ------------------------------------------------------------------------
 * 
 * 1. = vs == (Assignment vs Equality)
 * 
 *     // SALAH
 *     if (x = 5) {     // ERROR! = adalah assignment, bukan perbandingan
 *         // ...
 *     }
 * 
 *     // BENAR
 *     if (x == 5) {    // == adalah perbandingan
 *         // ...
 *     }
 * 
 * 2. Tidak Ada Tanda Kurung ()
 * 
 *     // SALAH
 *     if x > 5 {       // ERROR! Kondisi harus dalam ()
 *         // ...
 *     }
 * 
 *     // BENAR
 *     if (x > 5) {     // Kondisi dalam ()
 *         // ...
 *     }
 * 
 * 3. Semicolon (;) Setelah if
 * 
 *     // SALAH
 *     if (x > 5); {    // ; mengakhiri if, blok di bawah selalu dijalankan
 *         System.out.println("x lebih dari 5"); // SELALU dijalankan!
 *     }
 * 
 *     // BENAR
 *     if (x > 5) {
 *         System.out.println("x lebih dari 5");
 *     }
 * 
 * 4. Tidak Ada Kurung Kurawal {}
 * 
 *     // HATI-HATI! Tanpa {}, hanya 1 baris yang dianggap bagian dari if
 *     if (x > 5)
 *         System.out.println("x lebih dari 5");
 *         System.out.println("Ini selalu dijalankan!"); // BUKAN bagian dari if!
 * 
 *     // BENAR
 *     if (x > 5) {
 *         System.out.println("x lebih dari 5");
 *         System.out.println("Ini juga bagian dari if");
 *     }
 * 
 * ------------------------------------------------------------------------
 * TIPS MENGHINDARI KESALAHAN
 * ------------------------------------------------------------------------
 * 
 * 1. SELALU gunakan kurung kurawal {} meskipun hanya satu baris
 * 2. SELALU gunakan () untuk kondisi if
 * 3. SELALU gunakan == untuk perbandingan, = untuk assignment
 * 4. JANGAN taruh ; setelah if
 * 5. Indentasi kode dengan rapi agar mudah dibaca
 * 
 * ------------------------------------------------------------------------
 * RINGKASAN SUPER PADAT
 * ------------------------------------------------------------------------
 * 
 * - if       = jalur satu arah (opsional else)
 * - if-else  = jalur dua arah (pasti salah satu jalan)
 * - switch   = banyak jalur (lebih dari 2 pilihan)
 * 
 * Kesalahan umum:
 * - = (assignment) vs == (perbandingan)
 * - Lupa ()
 * - Semicolon setelah if
 * - Lupa {} untuk multiple statements
 * 
 * ------------------------------------------------------------------------
 */

public class StructurePercabangan {
    public static void main(String[] args) {

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
