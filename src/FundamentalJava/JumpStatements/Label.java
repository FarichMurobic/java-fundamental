package FundamentalJava.JumpStatements;

/* ==========================================================
 *                           LABEL
 * ==========================================================
 *
 * Label adalah sebuah nama yang diberikan kepada suatu statement
 * atau blok kode tertentu..
 *
 * Label digunakan bersama dengan:
 *
 * - break
 * - continue
 *
 * untuk menentukan lokasi tujuan perpindahan alur program.
 *
 * Bentuk umum label:
 *
 *     labelName: {
 *         // kode
 *     }
 *
 * Label biasanya digunakan pada nested loop (loop bersarang)
 * ketika kita perlu mengontrol perpindahan alur program dengan
 * lebih spesifik.
 *
 * ==========================================================
 *              BREAK SEBAGAI BENTUK GOTO TERSTRUKTUR
 * ==========================================================
 *
 * Selain digunakan pada switch dan loop, break juga dapat
 * digunakan bersama label untuk membuat perpindahan alur yang
 * mirip dengan konsep goto.
 *
 * Java sebenarnya memiliki keyword goto, tetapi keyword tersebut
 * tidak digunakan dalam bahasa Java.
 *
 * Alasannya:
 *
 * Goto memungkinkan program berpindah ke lokasi mana saja secara
 * bebas sehingga dapat menyebabkan kode:
 *
 * - Sulit dibaca.
 * - Sulit dipelihara.
 * - Sulit dianalisis oleh compiler.
 *
 * Sebagai gantinya, Java menyediakan labeled break yang memiliki
 * perpindahan alur lebih terbatas dan terstruktur.
 *
 * ==========================================================
 *                    LABELED BREAK
 * ==========================================================
 *
 * Labeled break memungkinkan program keluar dari blok kode atau
 * loop tertentu yang memiliki label.
 *
 * Bentuk umum:
 *
 *     break labelName;
 *
 * Ketika statement tersebut dijalankan:
 *
 * - Program keluar dari statement yang memiliki label tersebut.
 * - Eksekusi dilanjutkan setelah blok label selesai.
 *
 * ==========================================================
 *              CARA KERJA break label
 * ==========================================================
 *
 * Contoh:
 *
 *     outer:
 *     for (int i = 0; i < 5; i++) {
 *
 *         for (int j = 0; j < 5; j++) {
 *
 *             if (j == 3) {
 *                 break outer;
 *             }
 *         }
 *     }
 *
 * Ketika:
 *
 *     break outer;
 *
 * dijalankan, program langsung keluar dari loop yang memiliki
 * label outer.
 *
 * Artinya:
 *
 * - Loop dalam (j) berhenti.
 * - Loop luar (i) juga berhenti.
 * - Program melanjutkan kode setelah loop outer.
 *
 * ==========================================================
 *              PERBEDAAN BREAK BIASA DAN LABEL
 * ==========================================================
 *
 * break biasa:
 *
 * - Hanya keluar dari loop atau switch terdekat.
 *
 * Contoh:
 *
 *     for (i) {
 *         for (j) {
 *             break;
 *         }
 *     }
 *
 * Yang berhenti hanya loop j.
 *
 *
 * break dengan label:
 *
 *     outer:
 *     for (i) {
 *         for (j) {
 *             break outer;
 *         }
 *     }
 *
 * Yang berhenti:
 *
 * - Loop j.
 * - Loop i.
 *
 * Karena target break diarahkan ke label outer.
 *
 * ==========================================================
 *                   ATURAN BREAK LABEL
 * ==========================================================
 *
 * Beberapa aturan penting:
 *
 * - Label harus berada pada statement yang valid.
 * - break label harus berada di dalam cakupan label tersebut.
 * - break dapat digunakan untuk keluar dari loop, switch,
 *   maupun block berlabel.
 *
 * ==========================================================
 *              LABEL PADA CONTINUE
 * ==========================================================
 *
 * continue juga dapat menggunakan label, tetapi memiliki aturan
 * yang lebih ketat dibanding break.
 *
 * continue hanya dapat digunakan pada loop:
 *
 * - for
 * - while
 * - do-while
 *
 * Alasannya:
 *
 * Fungsi continue adalah:
 *
 * "Lewati sisa kode saat ini dan lanjutkan ke iterasi berikutnya."
 *
 * Karena itu, Java harus mengetahui loop mana yang akan
 * dilanjutkan.
 *
 * ==========================================================
 *             CONTOH continue DENGAN LABEL
 * ==========================================================
 *
 * Contoh valid:
 *
 *     outer:
 *     for (int i = 0; i < 5; i++) {
 *
 *         for (int j = 0; j < 5; j++) {
 *
 *             if (j == 3) {
 *                 continue outer;
 *             }
 *
 *             System.out.println(i + " " + j);
 *         }
 *     }
 *
 * Ketika:
 *
 *     continue outer;
 *
 * dijalankan:
 *
 * - Sisa kode pada iterasi sekarang dilewati.
 * - Program kembali ke iterasi berikutnya dari loop i.
 *
 * Karena label outer menunjuk ke loop, penggunaan ini valid.
 *
 * ==========================================================
 *              CONTINUE PADA BLOCK BIASA
 * ==========================================================
 *
 * Contoh tidak valid:
 *
 *     test: {
 *
 *         int x = 10;
 *
 *         continue test;
 *     }
 *
 * Error karena:
 *
 * continue membutuhkan target berupa loop.
 *
 * Block:
 *
 *     test: { }
 *
 * bukan sebuah loop dan tidak memiliki konsep iterasi berikutnya.
 *
 * Java tidak tahu harus melanjutkan ke iterasi yang mana.
 *
 * ==========================================================
 *                  KENAPA BREAK BOLEH?
 * ==========================================================
 *
 * Perbedaan konsepnya:
 *
 * break:
 *
 * "Keluar dari statement."
 *
 * continue:
 *
 * "Lanjut ke iterasi berikutnya."
 *
 * Karena break hanya membutuhkan tujuan untuk keluar, maka
 * break dapat digunakan pada:
 *
 * - Loop.
 * - Switch.
 * - Block berlabel.
 *
 * Sedangkan continue membutuhkan loop karena harus berpindah
 * menuju iterasi berikutnya.
 *
 * ==========================================================
 *              CONTOH BREAK PADA BLOCK LABEL
 * ==========================================================
 *
 * Contoh valid:
 *
 *     test: {
 *
 *         int x = 10;
 *
 *         if (x == 10) {
 *             break test;
 *         }
 *
 *         System.out.println("Tidak tampil");
 *     }
 *
 * Ketika:
 *
 *     break test;
 *
 * dijalankan, program langsung keluar dari block test.
 *
 * ==========================================================
 *              PERBANDINGAN BREAK DAN CONTINUE
 * ==========================================================
 *
 * break:
 *
 * Fungsi:
 * - Keluar dari statement.
 *
 * Target:
 * - Loop.
 * - Switch.
 * - Block berlabel.
 *
 *
 * continue:
 *
 * Fungsi:
 * - Melanjutkan ke iterasi berikutnya.
 *
 * Target:
 * - Hanya loop.
 *
 * ==========================================================
 *                  RINGKASAN ATURAN JAVA
 * ==========================================================
 *
 * Target Label        break        continue
 *
 * Loop                Bisa         Bisa
 * Block {}            Bisa         Tidak
 * Switch              Bisa         Tidak
 *
 *
 * Kesimpulan:
 *
 * continue = hanya untuk melanjutkan loop.
 *
 * break = untuk keluar dari statement.
 *
 * Labeled statement merupakan fitur Java yang jarang digunakan,
 * tetapi penting dipahami terutama ketika bekerja dengan nested
 * loop atau kode kompleks yang membutuhkan kontrol alur lebih
 * spesifik.
 *
 * ==========================================================
 */

public class Label {
    public static void main(String[] args) {
        
        boolean t = true;

        first: {
            second: {
                third: {

                    System.out.println("Before the break.");

                    if (t) // jika t true
                        break second; // break, keluar dari label second

                    System.out.println("This won't execute"); // artinya ini tidak akan dieksekusi
                }
                System.out.println("This won't execute"); // ini juga tidak akan dieksekusi, karena berada di blok second
            }
            System.out.println("This is after second block."); // ini tetep dieksekusi, karena bukan bagian dari blok second
        }

        System.out.println();

        /**
         * Output:
         * 
         * Before the break.
         * This is after second block.
         *
         * Cara berpikir programnya
         * Struktur blok:
         *
         * first
         *  └── second
         *       └── third
         *
         * Program jalan seperti ini:
         * Before the break.
         * if(t) break second
         *
         * Karena t = true, maka:
         * break second
         * Program lompat keluar dari blok second.
         * Semua kode di dalam second dilewati.
         * Program lanjut ke:
         * This is after second block.
         */

        // Labeled Break pada Nested Loop
        outer: for (int i = 0; i < 3; i++) {
            System.out.print("Pass " + i + ": ");
            for (int j = 0; j < 100; j++) {
                if (j == 10)
                    break outer;
                System.out.print(j + " ");
            }
            System.out.println("This will not print");
        }
        System.out.println("Loops complete.");

        /**
         * Output:
         * 
         * Pass 0: 0 1 2 3 4 5 6 7 8 9
         * Loops complete.
         *
         * Kenapa outer loop berhenti?
         * Struktur loop:
         * outer loop (i)
         *    inner loop (j)
         *
         * Normalnya:
         * i = 0
         * i = 1
         * i = 2
         *
         * Tapi ketika:
         * j == 10
         * break outer
         * Program keluar dari outer loop juga.
         * Jadi kedua loop langsung berhenti.
         *
         * Visual
         * outer loop
         *    inner loop
         *       j = 0..9
         *       j = 10 → break outer
         *
         * Program langsung lompat ke:
         * Loops complete.
         */

        // Nested label tanpa block (paling umum)

        outer:
        for (int i = 0; i < 3; i++) {

            inner:
            for (int j = 0; j < 3; j++) {

                if (j == 1) break outer;

                System.out.println(i + " " + j);
            }
        }

        /**
         * Label meskipun kita membuat dengan nama yang sama namun tidak bermasalah
         * selama scopenya berbeda,
         * artinya kita boleh membuat nama label yang sama hanya jika scopenya berbeda.
         * namun tidak boleh membuat nama label yang sama di dalam scope yang sama.
         */
    }
}
