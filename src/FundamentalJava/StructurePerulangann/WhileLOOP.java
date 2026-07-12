package FundamentalJava.StructurePerulangann;

/**
 * ------------------------------------------------------------------------
 * WHILE LOOP
 * ------------------------------------------------------------------------
 * 
 * while adalah loop paling dasar di Java.
 * Loop ini akan mengulang sebuah statement atau blok kode
 * selama kondisi bernilai true.
 * 
 * Bayangkan while seperti ini:
 * "Selama kondisi benar, lakukan sesuatu."
 * 
 * ------------------------------------------------------------------------
 * BENTUK UMUM WHILE
 * ------------------------------------------------------------------------
 * 
 *     while (kondisi) {
 *         // isi loop (dijalankan selama kondisi true)
 *     }
 * 
 * Penjelasan:
 * - kondisi → ekspresi boolean (true atau false)
 * - Selama kondisi true → kode di dalam loop terus dijalankan
 * - Jika kondisi false → program langsung lanjut ke kode setelah loop
 * - Jika hanya 1 baris statement, { } TIDAK wajib
 * 
 * ------------------------------------------------------------------------
 * CARA KERJA WHILE
 * ------------------------------------------------------------------------
 * 
 * while mengecek kondisi di AWAL.
 * 
 * Urutan eksekusi:
 * 
 *     1. Cek kondisi
 *        ↓
 *     2. Jika true → jalankan body
 *        ↓
 *     3. Kembali ke langkah 1 (cek kondisi lagi)
 *        ↓
 *     4. Jika false → keluar dari loop
 * 
 * ------------------------------------------------------------------------
 * CONTOH SEDERHANA
 * ------------------------------------------------------------------------
 * 
 *     // Menampilkan angka 1 sampai 5
 *     int i = 1;
 * 
 *     while (i <= 5) {
 *         System.out.println("Angka: " + i);
 *         i++;   // Jangan lupa increment!
 *     }
 * 
 *     // Output:
 *     // Angka: 1
 *     // Angka: 2
 *     // Angka: 3
 *     // Angka: 4
 *     // Angka: 5
 * 
 * ------------------------------------------------------------------------
 * PERHATIAN! JANGAN LUPA INCREMENT
 * ------------------------------------------------------------------------
 * 
 * Kesalahan paling umum di while adalah lupa mengubah variabel kondisi.
 * 
 *     // SALAH! Infinite loop
 *     int i = 0;
 *     while (i < 5) {
 *         System.out.println(i);
 *         // Tidak ada i++ !!!
 *     }
 * 
 *     // BENAR
 *     int i = 0;
 *     while (i < 5) {
 *         System.out.println(i);
 *         i++;   // WAJIB! agar loop berhenti
 *     }
 * 
 * ------------------------------------------------------------------------
 * CONTOH WHILE DENGAN KONDISI KOMPLEKS
 * ------------------------------------------------------------------------
 * 
 *     // Menampilkan angka genap dari 0 sampai 10
 *     int i = 0;
 *     while (i <= 10 && i % 2 == 0) {
 *         System.out.print(i + " ");
 *         i += 2;
 *     }
 * 
 *     // Output: 0 2 4 6 8 10
 * 
 * ------------------------------------------------------------------------
 * KONSEP MENARIK: LOOP TANPA BODY
 * ------------------------------------------------------------------------
 * 
 * Di Java, loop boleh kosong (tanpa body).
 * 
 *     // Loop tanpa body
 *     while (++i < --j);
 * 
 * Perhatikan:
 * ;   ← ini body kosong
 * 
 * Artinya loop tidak menjalankan kode apa pun.
 * Semua kerja terjadi di bagian kondisi.
 * 
 * Contoh lengkap:
 * 
 *     int i = 0;
 *     int j = 10;
 * 
 *     while (++i < --j);  // Body kosong
 * 
 *     System.out.println("i = " + i + ", j = " + j);
 *     // Output: i = 5, j = 5
 * 
 * Penjelasan:
 * - i terus bertambah (++i)
 * - j terus berkurang (--j)
 * - Loop berhenti ketika i >= j
 * 
 * ------------------------------------------------------------------------
 * INFINITE LOOP (LOOP TAK TERHINGGA)
 * ------------------------------------------------------------------------
 * 
 * Jika kondisi selalu true, loop tidak akan pernah berhenti.
 * 
 *     // Infinite loop (jangan dilakukan!)
 *     while (true) {
 *         System.out.println("Ini akan terus jalan...");
 *     }
 * 
 * Cara menghentikan:
 * - Ctrl + C (di terminal)
 * - Menggunakan break
 * - Mengubah kondisi di dalam loop
 * 
 *     // Infinite loop dengan break
 *     int i = 0;
 *     while (true) {
 *         System.out.println(i);
 *         i++;
 *         if (i == 5) {
 *             break;   // Keluar dari loop
 *         }
 *     }
 * 
 * ------------------------------------------------------------------------
 * CONTOH KASUS NYATA
 * ------------------------------------------------------------------------
 * 
 * 1. Membaca file sampai habis
 * 
 *     BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
 *     String line;
 * 
 *     while ((line = reader.readLine()) != null) {
 *         System.out.println(line);
 *     }
 * 
 * 2. Validasi input user
 * 
 *     Scanner scanner = new Scanner(System.in);
 *     int umur;
 * 
 *     System.out.print("Masukkan umur: ");
 *     umur = scanner.nextInt();
 * 
 *     while (umur < 0 || umur > 150) {
 *         System.out.println("Umur tidak valid! Ulangi.");
 *         System.out.print("Masukkan umur: ");
 *         umur = scanner.nextInt();
 *     }
 * 
 *     System.out.println("Umur valid: " + umur);
 * 
 * 3. Login attempt
 * 
 *     int percobaan = 0;
 *     boolean loginSukses = false;
 * 
 *     while (!loginSukses && percobaan < 3) {
 *         percobaan++;
 *         System.out.print("Username: ");
 *         String user = scanner.nextLine();
 *         System.out.print("Password: ");
 *         String pass = scanner.nextLine();
 * 
 *         if (user.equals("admin") && pass.equals("12345")) {
 *             loginSukses = true;
 *             System.out.println("Login berhasil!");
 *         } else {
 *             System.out.println("Login gagal! Percobaan ke-" + percobaan);
 *         }
 *     }
 * 
 * ------------------------------------------------------------------------
 * PERBANDINGAN WHILE DENGAN LOOP LAIN
 * ------------------------------------------------------------------------
 * 
 * while        | do-while           | for
 * -------------|--------------------|--------------------------
 * Cek di AWAL  | Cek di AKHIR       | Cek di AWAL
 * Bisa 0 kali  | Minimal 1 kali     | Bisa 0 kali
 *              |                    | Ada counter bawaan
 * 
 * ------------------------------------------------------------------------
 * KAPAN MENGGUNAKAN WHILE?
 * ------------------------------------------------------------------------
 * 
 * Gunakan while jika:
 * - Jumlah iterasi TIDAK PASTI
 * - Kondisi berdasarkan input/event eksternal
 * - Membaca data sampai habis
 * - Menunggu kondisi tertentu terjadi
 * 
 * Gunakan for jika:
 * - Jumlah iterasi PASTI (misal: loop array)
 * - Ada counter yang jelas
 * 
 * ------------------------------------------------------------------------
 * RINGKASAN SUPER PADAT
 * ------------------------------------------------------------------------
 * 
 * - while = loop paling dasar
 * - Cek kondisi di AWAL (bisa 0 kali eksekusi)
 * - Bentuk: while (kondisi) { ... }
 * - JANGAN LUPA ubah variabel di dalam loop!
 * - Tanpa perubahan → infinite loop
 * - Body bisa kosong (berguna untuk kasus tertentu)
 * - Cocok untuk: jumlah iterasi tidak pasti
 * 
 * ------------------------------------------------------------------------
 */

public class WhileLOOP {
    public static void main(String[] args) {

        // Contoh sederhana
        int n = 10;
        while (n > 0) {
            System.out.println("tick" + n);
            n--;
        }

        /**
         * Output
         * 
         * tick10
         * tick9
         * tick8
         * tick7
         * tick6
         * tick5
         * tick4
         * tick3
         * tick2
         * tick1
         *
         * Cara kerjanya:
         * Awalnya
         * n = 10
         * Loop berjalan selama
         * n > 0
         * Setiap loop:
         * print "tick"
         * nilai n dikurangi 1
         */

        // while mengecek kondisi di AWAL
        int a = 10, b = 20;
        while (a > b) { // kondisi false
            System.out.println("Ini tidak akan di proses, karena kondisi false.");
        }

        /**
         * Cek kondisi:
         * 10 > 20 ?
         * false
         * Karena langsung false, loop tidak pernah dijalankan.
         * Output:
         * (tidak ada)
         */

        // Konsep Menarik: Loop Tanpa Body
        int i = 100;
        int j = 200;

        while (++i < --j);
        System.out.println("Midpoint is " + i);

        /**
         * Tujuannya mencari titik tengah antara 100 dan 200.
         *
         * Prosesnya:
         * i naik terus
         * j turun terus
         * Sampai:
         * i = 150
         * j = 150
         *
         * Output:
         * Midpoint is 150
         */

    }
}
