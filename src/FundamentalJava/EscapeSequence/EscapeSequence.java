package FundamentalJava.EscapeSequence;

/**
 * ESCAPE SEQUENCE
 * ------------------------------------------------------------
 *
 * Escape Sequence adalah kombinasi karakter khusus yang diawali
 * dengan tanda backslash (\).
 *
 * Escape sequence digunakan untuk menampilkan karakter yang tidak
 * bisa ditulis secara langsung atau memiliki arti khusus di dalam
 * String maupun character literal.
 *
 * Contoh:
 *
 * System.out.println("Hello\nWorld");
 *
 * Output:
 *
 * Hello
 * World
 *
 * Pada contoh di atas:
 *
 * \n bukan dianggap sebagai dua karakter (\ dan n),
 * melainkan sebagai instruksi khusus untuk membuat baris baru.
 *
 * ------------------------------------------------------------
 * MENGAPA ESCAPE SEQUENCE DIPERLUKAN?
 * ------------------------------------------------------------
 *
 * Beberapa karakter memiliki fungsi khusus dalam Java.
 *
 * Contoh:
 *
 * "
 *
 * digunakan untuk membuka dan menutup String.
 *
 * Jika ingin mencetak tanda kutip ke layar:
 *
 * System.out.println("\"Java\"");
 *
 * Output:
 *
 * "Java"
 *
 * Tanpa escape sequence:
 *
 * System.out.println(""Java"");
 *
 * akan menyebabkan error karena compiler menganggap String
 * berakhir lebih awal.
 *
 * ------------------------------------------------------------
 * ESCAPE SEQUENCE YANG PALING SERING DIGUNAKAN
 * ------------------------------------------------------------
 *
 * Escape
 * Sequence      Nama
 * ------------------------------------------------------------
 * \n            New Line
 * \t            Tab
 * \"            Double Quote
 * \'            Single Quote
 * \\            Backslash
 *
 * Ini adalah escape sequence yang paling sering digunakan dalam
 * program Java sehari-hari.
 *
 * ------------------------------------------------------------
 * \n (NEW LINE)
 * ------------------------------------------------------------
 *
 * Fungsi:
 *
 * Memindahkan kursor ke baris berikutnya.
 *
 * Contoh:
 *
 * System.out.println("Java\nProgramming");
 *
 * Output:
 *
 * Java
 * Programming
 *
 * Flow:
 *
 * Cetak "Java"
 *      ↓
 * Pindah Baris
 *      ↓
 * Cetak "Programming"
 *
 * ------------------------------------------------------------
 * \t (TAB)
 * ------------------------------------------------------------
 *
 * Fungsi:
 *
 * Memasukkan karakter tab horizontal.
 *
 * Contoh:
 *
 * System.out.println("Nama\tUmur");
 *
 * Output:
 *
 * Nama    Umur
 *
 * Cocok digunakan untuk:
 *
 * - Membuat tabel sederhana
 * - Merapikan output console
 *
 * ------------------------------------------------------------
 * \r (CARRIAGE RETURN)
 * ------------------------------------------------------------
 *
 * Fungsi:
 *
 * Memindahkan kursor ke awal baris saat ini.
 *
 * Contoh:
 *
 * System.out.print("ABCDE");
 * System.out.print("\r123");
 *
 * Hasil konsep:
 *
 * 123DE
 *
 * Karena:
 *
 * Kursor kembali ke awal baris lalu menimpa karakter sebelumnya.
 *
 * Escape sequence ini jarang digunakan dalam aplikasi Java modern.
 *
 * ------------------------------------------------------------
 * \f (FORM FEED)
 * ------------------------------------------------------------
 *
 * Fungsi:
 *
 * Memindahkan kursor ke halaman berikutnya.
 *
 * Escape sequence ini berasal dari era printer lama.
 *
 * Saat ini sangat jarang digunakan.
 *
 * Contoh:
 *
 * System.out.println("Hello\fWorld");
 *
 * Pada sebagian besar terminal modern efeknya hampir tidak
 * terlihat.
 *
 * ------------------------------------------------------------
 * \b (BACKSPACE)
 * ------------------------------------------------------------
 *
 * Fungsi:
 *
 * Menghapus satu karakter ke kiri.
 *
 * Contoh:
 *
 * System.out.print("ABCDE\b");
 *
 * Secara konsep:
 *
 * Karakter terakhir dihapus.
 *
 * Namun perilakunya dapat berbeda tergantung terminal yang
 * digunakan.
 *
 * ------------------------------------------------------------
 * \\ (BACKSLASH)
 * ------------------------------------------------------------
 *
 * Fungsi:
 *
 * Menampilkan karakter backslash (\).
 *
 * Contoh:
 *
 * System.out.println("C:\\Users\\Farich");
 *
 * Output:
 *
 * C:\Users\Farich
 *
 * Karena:
 *
 * Satu backslash digunakan sebagai escape character,
 * maka untuk mencetak satu backslash diperlukan dua backslash.
 *
 * ------------------------------------------------------------
 * \' (SINGLE QUOTE)
 * ------------------------------------------------------------
 *
 * Fungsi:
 *
 * Menampilkan karakter kutip tunggal.
 *
 * Contoh:
 *
 * System.out.println("It's Java");
 *
 * atau:
 *
 * System.out.println("It\'s Java");
 *
 * Output:
 *
 * It's Java
 *
 * Umumnya lebih sering digunakan pada tipe char.
 *
 * Contoh:
 *
 * char ch = '\'';
 *
 * ------------------------------------------------------------
 * \" (DOUBLE QUOTE)
 * ------------------------------------------------------------
 *
 * Fungsi:
 *
 * Menampilkan karakter kutip ganda.
 *
 * Contoh:
 *
 * System.out.println("\"Java\"");
 *
 * Output:
 *
 * "Java"
 *
 * Sangat sering digunakan ketika ingin mencetak teks yang
 * mengandung tanda kutip.
 *
 * ------------------------------------------------------------
 * UNICODE ESCAPE
 * ------------------------------------------------------------
 *
 * Format:
 *
 * -(\)(u)
 * -XXXX
 *
 * XXXX adalah kode Unicode dalam format hexadecimal.
 *
 * Contoh:
 *
 * System.out.println("\u0041");
 *
 * Output:
 *
 * A
 *
 * Karena:
 *
 * Unicode 0041 = karakter A
 *
 * Contoh lain:
 *
 * System.out.println("\u2764");
 *
 * Output:
 *
 * ❤
 *
 * Digunakan untuk:
 *
 * - Simbol khusus
 * - Karakter internasional
 * - Karakter yang sulit diketik langsung
 *
 * ------------------------------------------------------------
 * OCTAL ESCAPE
 * ------------------------------------------------------------
 *
 * Format:
 *
 * \0XXX
 *
 * atau:
 *
 * \XXX
 *
 * XXX adalah angka oktal.
 *
 * Contoh:
 *
 * System.out.println("\101");
 *
 * Output:
 *
 * A
 *
 * Karena:
 *
 * Oktal 101 = ASCII 65 = A
 *
 * Saat ini sangat jarang digunakan karena Unicode jauh lebih
 * populer dan lebih mudah dipahami.
 *
 * ------------------------------------------------------------
 * TABEL RINGKAS ESCAPE SEQUENCE
 * ------------------------------------------------------------
 *
 * Escape      Fungsi
 * ------------------------------------------------------------
 * \n          Pindah ke baris baru
 * \t          Tab horizontal
 * \r          Kembali ke awal baris
 * \f          Form feed / halaman baru
 * \b          Backspace
 * \\          Menampilkan backslash
 * \'          Menampilkan kutip tunggal
 * \"          Menampilkan kutip ganda
 * (\)(u)XXXX      Karakter Unicode
 * \XXX        Karakter oktal
 *
 * ------------------------------------------------------------
 * CONTOH GABUNGAN
 * ------------------------------------------------------------
 *
 * System.out.println("Nama\t: Farich");
 * System.out.println("Bahasa\t: Java");
 * System.out.println("Folder\t: C:\\Project\\Java");
 * System.out.println("\"Belajar Java\"");
 *
 * Output:
 *
 * Nama    : Farich
 * Bahasa  : Java
 * Folder  : C:\Project\Java
 * "Belajar Java"
 *
 * ------------------------------------------------------------
 * KESIMPULAN
 * ------------------------------------------------------------
 *
 * Escape Sequence adalah kombinasi karakter khusus yang diawali
 * dengan backslash (\) dan digunakan untuk menampilkan karakter
 * yang memiliki arti khusus atau sulit ditulis secara langsung.
 *
 * Escape sequence yang paling sering digunakan adalah:
 *
 * - \n  (New Line)
 * - \t  (Tab)
 * - \\  (Backslash)
 * - \"  (Double Quote)
 * - \'  (Single Quote)
 *
 * Escape sequence sangat penting untuk:
 *
 * - Memformat output
 * - Menampilkan karakter khusus
 * - Menulis path file Windows
 * - Menampilkan simbol Unicode
 */

public class EscapeSequence {
    public static void main(String[] args) {
        
        System.out.println("-- Escape Sequence ---");
        System.out.println("A return\r<- character");
        System.out.println("A newline\n<- character");
        System.out.println("A tab stop\t<- character");
        System.out.println("A backspace\b<- character");
        System.out.println("A backslash\\<- character");
        System.out.println("A single quotation\'<- character");
        System.out.println("A double quotation\"<- character");

        // Unicode
        System.out.println("\u00A9 Kita Belajar");
        System.out.println("Emoji Wajah Senyum: \uD83D\uDE00");

        System.out.println("----------");

        System.out.println("Ini baris pertama.\nIni baris kedua.");

        /**
         * \n (Newline): Memindahkan kursor ke baris baru.
         * Analoginya: Tekan tombol ENTER.
         */

        System.out.println("Kolom1\tKolom2\tKolom3");

        /**
         * \t (Tab): Menambahkan spasi horizontal (tab).
         * Analoginya: Tekan tombol TAB.
         */

        System.out.println("Path file: C:\\FolderKu\\dokumen.txt");

        /**
         * \\ (Backslash): Mencetak karakter backslash itu sendiri.
         * Analoginya: Kamu mau cetak simbol \ , tapi karena \ itu spesial, harus pakai dua kali.
         */

        System.out.println("Dia bilang, \"Halo Dunia!\"");

        /**
         * \" (Double Quotation): Mencetak karakter kutip ganda di dalam String.
         * Analoginya: Kalau kutip ganda itu pembungkus String, kalau mau cetak pembungkusnya, harus "dibungkus lagi".
         */

        System.out.println("Itu adalah karakter tunggal: \'A\'");

        /**
         * \' (Single Quotation): Mencetak karakter kutip tunggal di dalam String.
         * Analoginya: Mirip dengan \" tapi untuk kutip tunggal.
         */

        System.out.println("Proses ini akan mundur: ABCDE\b\b\bFGHI");

        /**
         * \b (Backspace): Menghapus satu karakter ke belakang (menimpa).
         * Analoginya: Tekan tombol BACKSPACE di keyboard.
         */

        System.out.println("Mulai dari sini, lalu \rKembali ke awal.");

        /**
         * \r (Carriage Return): Memindahkan kursor ke awal baris saat ini, menimpa teks.
         * Analoginya: Seperti mesin ketik yang head-nya balik ke awal baris tanpa pindah baris.
         */

        System.out.println("Simbol Copyright: \u00A9");

        /**
         * (Unicode Escape): Mencetak karakter berdasarkan kode Unicode-nya.
         * Analoginya: Memanggil karakter dari "kamus" karakter dunia.
         */

        System.out.println("Simbol Euro: \u20AC");

        /**
         * Contoh lain Unicode Escape.
         */

        System.out.println("Emoji Wajah Senyum: \uD83D\uDE00");
        
        /**
         * Contoh Unicode untuk emoji (beberapa emoji butuh dua kode unicode).
         */
    }
}
