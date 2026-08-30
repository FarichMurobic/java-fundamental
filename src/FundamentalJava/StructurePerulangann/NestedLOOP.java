package FundamentalJava.StructurePerulangann;

/**
 * ------------------------------------------------------------------------
 * NESTED LOOPS (LOOP BERSARANG)
 * ------------------------------------------------------------------------
 * 
 * Seperti bahasa pemrograman lainnya, Java mengizinkan loop di dalam loop.
 * Ini disebut nested loop..
 * 
 * Artinya:
 * Satu loop berada di dalam loop lain.
 * 
 * Semua jenis loop di Java bisa dimasukkan ke dalam loop lain:
 * - for di dalam for
 * - for di dalam while
 * - while di dalam do-while
 * - for-each di dalam for
 * - Dan kombinasi lainnya
 * 
 * ------------------------------------------------------------------------
 * SEMUA LOOP BISA DI-NESTED DI JAVA
 * ------------------------------------------------------------------------
 * 
 * Loop | Bisa Nested
 * -------------|------------------------------------------
 * for | YA
 * for-each | YA
 * while | YA
 * do-while | YA
 * 
 * Yang membuat nested loop bukan jenis loop-nya,
 * tapi struktur logikanya:
 * 
 * Loop LUAR → mengontrol siklus BESAR
 * Loop DALAM → mengontrol DETAIL di dalamnya
 * 
 * ------------------------------------------------------------------------
 * STRUKTUR NESTED LOOP
 * ------------------------------------------------------------------------
 * 
 * Ada 2 loop:
 * 1. Loop luar (outer loop)
 * 2. Loop dalam (inner loop)
 * 
 * Bentuk umum:
 * 
 * for (int i = 0; i < 5; i++) { // Loop LUAR
 * // ...
 * 
 * for (int j = 0; j < 3; j++) { // Loop DALAM
 * // ...
 * }
 * 
 * // ...
 * }
 * 
 * ------------------------------------------------------------------------
 * CARA KERJA NESTED LOOP
 * ------------------------------------------------------------------------
 * 
 * Urutan eksekusi:
 * 
 * 1. Loop luar: i = 0
 * 2. Loop dalam: j = 0, 1, 2 (sampai selesai)
 * 3. Loop luar: i = 1
 * 4. Loop dalam: j = 0, 1, 2 (sampai selesai)
 * 5. Loop luar: i = 2
 * 6. Loop dalam: j = 0, 1, 2 (sampai selesai)
 * 7. Dan seterusnya...
 * 
 * Intinya:
 * Setiap 1 iterasi loop luar,
 * loop dalam dijalankan dari awal sampai selesai.
 * 
 * ------------------------------------------------------------------------
 * CONTOH SEDERHANA
 * ------------------------------------------------------------------------
 * 
 * // Mencetak pola bintang persegi
 * for (int i = 0; i < 5; i++) { // Loop luar: baris
 * 
 * for (int j = 0; j < 5; j++) { // Loop dalam: kolom
 * System.out.print("* ");
 * }
 * 
 * System.out.println(); // Pindah baris
 * }
 * 
 * // Output:
 * // * * * * *
 * // * * * * *
 * // * * * * *
 * // * * * * *
 * // * * * * *
 * 
 * ------------------------------------------------------------------------
 * CONTOH SEGITIGA BINTANG
 * ------------------------------------------------------------------------
 * 
 * for (int i = 1; i <= 5; i++) { // Loop luar: baris
 * 
 * for (int j = 1; j <= i; j++) { // Loop dalam: kolom (sesuai baris)
 * System.out.print("* ");
 * }
 * 
 * System.out.println();
 * }
 * 
 * // Output:
 * // *
 * // * *
 * // * * *
 * // * * * *
 * // * * * * *
 * 
 * ------------------------------------------------------------------------
 * CONTOH TABEL PERKALIAN
 * ------------------------------------------------------------------------
 * 
 * for (int i = 1; i <= 10; i++) { // Loop luar: baris
 * 
 * for (int j = 1; j <= 10; j++) { // Loop dalam: kolom
 * System.out.printf("%4d", i * j);
 * }
 * 
 * System.out.println();
 * }
 * 
 * // Output (sebagian):
 * // 1 2 3 4 5 6 7 8 9 10
 * // 2 4 6 8 10 12 14 16 18 20
 * // 3 6 9 12 15 18 21 24 27 30
 * // ...
 * 
 * ------------------------------------------------------------------------
 * CONTOH DENGAN WHILE DAN DO-WHILE
 * ------------------------------------------------------------------------
 * 
 * 1. for di dalam while
 * 
 * int i = 0;
 * while (i < 3) {
 * System.out.println("Baris " + (i + 1));
 * 
 * for (int j = 0; j < 3; j++) {
 * System.out.print(" Kolom " + (j + 1));
 * }
 * 
 * System.out.println();
 * i++;
 * }
 * 
 * 2. do-while di dalam for
 * 
 * for (int i = 0; i < 3; i++) {
 * int j = 0;
 * do {
 * System.out.print(j + " ");
 * j++;
 * } while (j < 3);
 * System.out.println();
 * }
 * 
 * ------------------------------------------------------------------------
 * CONTOH KASUS NYATA
 * ------------------------------------------------------------------------
 * 
 * 1. Matriks (2D Array)
 * 
 * int[][] matrix = {
 * {1, 2, 3},
 * {4, 5, 6},
 * {7, 8, 9}
 * };
 * 
 * for (int i = 0; i < matrix.length; i++) { // Baris
 * for (int j = 0; j < matrix[i].length; j++) { // Kolom
 * System.out.print(matrix[i][j] + " ");
 * }
 * System.out.println();
 * }
 * 
 * 2. Mencari Duplikat di Array
 * 
 * int[] arr = {1, 2, 3, 2, 4, 5, 1};
 * 
 * for (int i = 0; i < arr.length; i++) {
 * for (int j = i + 1; j < arr.length; j++) {
 * if (arr[i] == arr[j]) {
 * System.out.println("Duplikat: " + arr[i]);
 * }
 * }
 * }
 * 
 * ------------------------------------------------------------------------
 * ISTILAH PENTING
 * ------------------------------------------------------------------------
 * 
 * Outer Loop = Loop yang berada di luar (loop utama)
 * Inner Loop = Loop yang berada di dalam (loop bawahan)
 * Nested Loop = Loop di dalam loop
 * 
 * ------------------------------------------------------------------------
 * KOMPLEKSITAS WAKTU (TIME COMPLEXITY)
 * ------------------------------------------------------------------------
 * 
 * Nested loop mempengaruhi performa program.
 * 
 * Jika loop luar berjalan n kali,
 * dan loop dalam berjalan m kali,
 * maka total iterasi = n × m
 * 
 * Contoh:
 * for (i = 0; i < 100; i++) { // 100 kali
 * for (j = 0; j < 100; j++) { // 100 kali
 * // total = 100 × 100 = 10.000 iterasi
 * }
 * }
 * 
 * Waspadai nested loop yang terlalu dalam,
 * bisa membuat program berjalan lambat.
 * 
 * ------------------------------------------------------------------------
 * RINGKASAN WAJIB
 * ------------------------------------------------------------------------
 * 
 * 1. Nested loop = loop di dalam loop
 * 2. Semua jenis loop bisa di-nested (for, while, do-while, for-each)
 * 3. Loop luar mengontrol siklus besar, loop dalam mengontrol detail
 * 4. Setiap 1 iterasi loop luar, loop dalam berjalan dari awal sampai selesai
 * 5. Total iterasi = iterasi luar × iterasi dalam
 * 6. Hati-hati dengan performa jika terlalu dalam
 * 
 * ------------------------------------------------------------------------
 */

public class NestedLOOP {
    public static void main(String[] args) {

        // Contoh program sederhana
        int i, j;

        for (i = 0; i < 10; i++) {
            for (j = i; j < 10; j++)
                System.out.print(".");
            System.out.println();
        }

        System.out.println(i); // nilai i sekarang menjadi 10
        // System.out.println(j); // error, karena j belum di inisialisasi

        /**
         * Output Program
         * ..........
         * .........
         * ........
         * .......
         * ......
         * .....
         * ....
         * ...
         * ..
         * .
         *
         * Struktur Nested Loop
         *
         * Ada 2 loop.
         * Loop luar
         * for(i = 0; i < 10; i++)
         *
         * Artinya:
         * loop berjalan 10 kali
         * Ini mengontrol jumlah baris.
         * Loop dalam
         * for(j = i; j < 10; j++)
         * Loop ini mencetak:
         * "."
         * Loop ini mengontrol jumlah titik per baris.
         *
         * Pola yang Terjadi
         * Setiap baris:
         * jumlah titik berkurang 1
         * Karena nilai awal j mengikuti i.
         *
         * i j mulai jumlah titik
         * 0 0 10
         * 1 1 9
         * 2 2 8
         * 3 3 7
         * 4 4 6
         * 5 5 5
         * 6 6 4
         * 7 7 3
         * 8 8 2
         * 9 9 1
         *
         * Kenapa Pakai println()
         * Baris ini:
         * System.out.println();
         * berfungsi untuk pindah baris setelah satu baris titik selesai.
         *
         * Cara Berpikir Programmer
         * Cara cepat memahami nested loop:
         * loop luar = baris
         * loop dalam = isi baris
         *
         * Dalam program ini:
         * loop luar -> jumlah baris
         * loop dalam -> jumlah titik
         *
         * Loop dalam selalu selesai dulu sebelum i naik.
         */

        // Contoh Nested while
        i = j = 0; // reset nilai
        System.out.println();

        while (i < 3) {
            j = 0;

            while (j < 5) {
                System.out.print("*");
                j++;
            }
            System.out.println();
            i++;
        }

        System.out.println(i); // nilai i menjadi 3
        System.out.println(j); // nilai j menjadi 5

        System.out.println();

        /**
         * Output:
         * *****
         * *****
         * *****
         *
         * Di sini:
         * while luar → baris
         * while dalam → kolom
         * Sama seperti for.
         */

        // Contoh Nested do-while
        i = j = 0; // reset nilai

        do {
            j = 0;
            do {
                System.out.print("#");
                j++;
            } while (j < 4); // inget titik koma khusus buat do while

            System.out.println();
            i++;
        } while (i < 3); // inget titik koma khusus buat do while

        System.out.println(i); // nilai i menjadi 3
        System.out.println(j); // nilai j menjadi 4

        System.out.println();

        /**
         * Output
         * ####
         * ####
         * ####
         */

        // Bahkan bisa di campur
        i = j = 0; // reset nilai

        for (i = 0; i < 3; i++) {
            j = 0;

            while (j < 5) {
                System.out.print("*");
                j++;
            }

            System.out.println();
        }

        System.out.println(i); // nilai i menjadi 3
        System.out.println(j); // nilai j menjadi 5

        System.out.println();

        // Bagaimana variabel ini bisa menghasilkan nilai setelah loop
        int x, y;

        for (x = 0; x < 5; x++) {
            for (y = 0; y < 5; y++)
                System.out.print(".");
            System.out.println();
        }

        System.out.println(x); // x sekarang bernilai 5
        // System.out.println(y); // kenapa ini error

        /**
         * x bisa diprint
         * y error
         *
         * Padahal dua-duanya dideklarasikan di atas.
         * Kenapa bisa begitu?
         *
         * Aturan Penting di Java
         * Di Java, local variable harus diinisialisasi sebelum dipakai.
         * Artinya compiler harus yakin 100% bahwa variabel sudah diberi nilai.
         *
         * Kenapa x Tidak Error
         * Di sini:
         * for (x = 0; x < 5; x++) {
         * x langsung diberi nilai:
         * x = 0
         * Setelah loop selesai:
         * x = 5
         * Jadi saat ini:
         * System.out.println(x);
         * aman.
         *
         * Kenapa y Error
         * Walaupun y digunakan di loop:
         * for (y = 0; y < 5; y++)
         *
         * compiler tidak menjamin bahwa loop itu pasti dijalankan.
         * Bayangkan kalau kondisi loop tidak pernah masuk.
         *
         * Contoh hipotetis:
         * for(y = 0; y < 5; y++)
         *
         * Jika x sudah ≥ 10, loop tidak jalan sama sekali.
         * Berarti:
         * y belum pernah dipakai
         * y belum pernah diberi nilai
         *
         * Karena itu compiler bilang:
         * variable y might not have been initialized
         *
         * Cara Memperbaikinya
         * Cara 1 (paling umum)
         * Inisialisasi dari awal.
         * int i, j = 0;
         *
         * atau
         * int i = 0, j = 0;
         *
         * Hal Penting yang Perlu Lu Tahu
         * Ini berlaku hanya untuk local variable.
         * karena local variabel tidak punya default value
         *
         * Rule sederhana:
         * field variable → ada default value
         * local variable → harus diinisialisasi sendiri
         */
    }
}
