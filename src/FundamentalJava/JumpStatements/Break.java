package FundamentalJava.JumpStatements;

public class Break {
    public static void main(String[] args) {
        
         /**
         * Break
         *
         * Menggunakan break
         * Di Java, statement break memiliki tiga kegunaan:
         * Mengakhiri rangkaian statement di dalam switch statement.
         * Digunakan untuk keluar dari loop.
         * Digunakan sebagai bentuk goto yang lebih aman.
         *
         * ------------------------------------
         * 
         * Apa itu Jump Statement?
         * Jump statement adalah perintah yang membuat program "lompat" ke tempat lain.
         * Biasanya program berjalan baris demi baris dari atas ke bawah.
         *
         * Program berjalan urut.
         * Tapi dengan jump statement, kita bisa mengubah jalur program.
         *
         * Misalnya:
         * keluar dari loop lebih cepat
         * melewati sebagian kode
         * langsung keluar dari method
         *
         * Menggunakan break untuk Keluar dari Loop
         * Dengan menggunakan break, kamu bisa langsung menghentikan loop, tanpa peduli kondisi loopnya masih benar atau tidak.
         *
         * Artinya:
         * kondisi loop tidak dicek lagi
         * sisa kode di dalam loop dilewati
         * Ketika break dijalankan di dalam loop:
         * loop langsung berhenti
         * program lanjut ke baris setelah loop
         */

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
