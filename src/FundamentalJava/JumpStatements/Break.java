package FundamentalJava.JumpStatements;

/* ==========================================================
 *                           BREAK
 * ==========================================================
 *
 * break adalah salah satu jump statement di Java yang digunakan
 * untuk menghentikan eksekusi suatu blok program secara langsung
 * dan memindahkan alur program ke statement berikutnya..
 *
 * Pada Java modern, statement break memiliki tiga kegunaan utama:
 *
 * 1. Mengakhiri eksekusi pada switch statement atau switch expression.
 * 2. Keluar lebih awal dari sebuah loop.
 * 3. Keluar dari blok berlabel (labeled statement), yang merupakan
 *    alternatif yang lebih aman dan terstruktur dibanding konsep
 *    goto pada bahasa pemrograman lain.
 *
 * ==========================================================
 *                    APA ITU JUMP STATEMENT?
 * ==========================================================
 *
 * Jump statement adalah perintah yang mengubah alur normal
 * eksekusi program.
 *
 * Secara default, Java mengeksekusi statement secara berurutan
 * dari atas ke bawah.
 *
 * Dengan jump statement, alur program dapat berpindah ke lokasi
 * lain tanpa harus menyelesaikan seluruh statement yang sedang
 * dijalankan.
 *
 * Contoh penggunaan jump statement:
 *
 * - Keluar lebih awal dari loop.
 * - Melewati sisa statement dalam suatu blok.
 * - Keluar dari method menggunakan return.
 * - Keluar dari blok berlabel menggunakan break.
 *
 * Java menyediakan beberapa jump statement, yaitu:
 *
 * - break
 * - continue
 * - return
 *
 * ==========================================================
 *                 BREAK UNTUK KELUAR DARI LOOP
 * ==========================================================
 *
 * Statement break memungkinkan sebuah loop dihentikan sebelum
 * kondisi perulangannya bernilai false.
 *
 * Ketika break dieksekusi:
 *
 * - Eksekusi loop langsung dihentikan.
 * - Kondisi loop tidak diperiksa lagi.
 * - Seluruh statement yang tersisa di dalam iterasi saat itu
 *   dilewati.
 * - Program dilanjutkan pada statement pertama setelah loop.
 *
 * Dengan demikian, break sering digunakan ketika tujuan
 * perulangan telah tercapai sehingga tidak perlu melanjutkan
 * iterasi berikutnya.
 *
 * ==========================================================
 *              BREAK PADA SWITCH STATEMENT
 * ==========================================================
 *
 * Pada switch statement, break digunakan untuk mengakhiri
 * eksekusi suatu case.
 *
 * Tanpa break, eksekusi akan berlanjut ke case berikutnya
 * (fall-through).
 *
 * Contoh:
 *
 *     switch (day) {
 *         case 1:
 *             System.out.println("Senin");
 *             break;
 *
 *         case 2:
 *             System.out.println("Selasa");
 *             break;
 *     }
 *
 * Catatan:
 * Pada switch expression (Java 14+), penggunaan break untuk
 * menghasilkan nilai umumnya digantikan dengan keyword yield.
 *
 * ==========================================================
 *                  LABELED BREAK
 * ==========================================================
 *
 * Java juga mendukung labeled break, yaitu break yang digunakan
 * untuk keluar dari blok atau nested loop tertentu.
 *
 * Contoh:
 *
 *     outer:
 *     for (...) {
 *         for (...) {
 *             break outer;
 *         }
 *     }
 *
 * Saat break outer dijalankan, program langsung keluar dari
 * loop yang memiliki label outer.
 *
 * Fitur ini menjadi alternatif yang lebih aman dibanding
 * penggunaan goto yang terdapat pada beberapa bahasa
 * pemrograman lain.
 *
 * ==========================================================
 *                KAPAN BREAK DIGUNAKAN?
 * ==========================================================
 *
 * break umum digunakan ketika:
 *
 * - Data yang dicari sudah ditemukan.
 * - Kondisi tertentu telah terpenuhi.
 * - Tidak diperlukan iterasi berikutnya.
 * - Ingin menghentikan proses lebih awal untuk meningkatkan
 *   efisiensi program.
 *
 * ==========================================================
 *                        KESIMPULAN
 * ==========================================================
 *
 * break adalah jump statement yang menghentikan eksekusi suatu
 * blok program secara langsung.
 *
 * Fungsi utamanya meliputi:
 *
 * - Mengakhiri case pada switch statement.
 * - Menghentikan loop sebelum kondisi selesai.
 * - Keluar dari blok berlabel (labeled statement).
 *
 * Penggunaan break membuat alur program menjadi lebih efisien
 * ketika proses tidak perlu dilanjutkan hingga akhir.
 *
 * ==========================================================
 */

public class Break {
    public static void main(String[] args) {
        
        // Contoh sederhana
        for (int i = 0; i < 100; i++) {
            if (i == 10)
                break; // hentikan loop jika i = 10
            System.out.println("i: " + i);
        }

        System.out.println("Loop complete.");

        /**
         * Output:
         *
         * i: 0
         * i: 1
         * i: 2
         * i: 3
         * i: 4
         * i: 5
         * i: 6
         * i: 7
         * i: 8
         * i: 9
         * Loop complete.
         *
         * Walaupun loop dibuat sampai 99, tetapi karena ada break, loop berhenti saat i == 10.
         *
         * break bisa dipakai di semua jenis loop Java:
         * for
         * while
         * do-while
         * bahkan loop tak terbatas (infinite loop).
         */

        System.out.println();

        int i = 0;

        while (i < 100) {
            if (i == 10)
                break; // hentikan loop jika i = 10
            System.out.println("i is: " + i);
            i++;
        }

        /**
         * Bayangin loop seperti mesin yang terus muter.
         *
         * Contoh:
         * for loop → muter 100 kali
         * Tetapi break itu seperti tombol STOP darurat.
         * loop berjalan
         * loop berjalan
         * loop berjalan
         * STOP (break)
         *
         * Jadi walaupun seharusnya:
         * 0 → 99
         * Dengan break jadi:
         * 0 → 9 → STOP
         */

        // Contoh break didalam Nested Loop (Loop di dalam Loop)
        i = 0; // reset nilai
        int j = 0; // inisialisasi j

        for (i = 0; i < 3; i++) {
            System.out.print("Pass " + i + ":");
            for (j = 0; j < 100; j++) {
                if (j == 10) {
                    break;
                }
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println(i); // nilai i sekarang 3
        System.out.println(j); // nilai j sekarang 10

        /**
         * Output:
         * Pass 0: 0 1 2 3 4 5 6 7 8 9
         * Pass 1: 0 1 2 3 4 5 6 7 8 9
         * Pass 2: 0 1 2 3 4 5 6 7 8 9
         * Cara berpikir programnya
         *
         * Loop luar:
         * i = 0
         * i = 1
         * i = 2
         *
         * Loop dalam:
         * j = 0 sampai 9
         * Karena saat j == 10 → break.
         *
         * Visualnya
         * Loop i
         *  ├─ Loop j
         *  │   0 1 2 3 4 5 6 7 8 9 STOP
         *  │
         *  ├─ Loop j
         *  │   0 1 2 3 4 5 6 7 8 9 STOP
         *  │
         *  ├─ Loop j
         *  │   0 1 2 3 4 5 6 7 8 9 STOP
         *
         * Yang berhenti hanya loop dalam.
         *
         * break hanya menghentikan loop TERDEKAT
         *
         * Contoh:
         *
         * for i
         *    for j
         *        break
         *
         * Yang berhenti hanya:
         * loop j
         * bukan loop i.
         */
    }
}
