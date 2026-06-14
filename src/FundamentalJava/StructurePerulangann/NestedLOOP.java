package FundamentalJava.StructurePerulangann;

public class NestedLOOP {
    public static void main(String[] args) {

        /**
         * Nested Loops
         *
         * Seperti bahasa pemrograman lainnya, Java mengizinkan loop di dalam loop. Ini disebut nested loop.
         * Artinya:
         * satu loop berada di dalam loop lain
         *
         * while dan do-while juga bisa di-nested.
         * Semua jenis loop di Java bisa dimasukkan ke dalam loop lain.
         *
         * Struktur Nested Loop
         * Ada 2 loop.
         * Loop luar
         * Loop dalam
         *
         * Semua loop bisa di nested di java
         * Rule Sederhana Supaya Mudah Ingat
         * Loop	        Bisa Nested
         * for	        YA
         * for-each	    YA
         * while	    YA
         * do-while	    YA
         *
         * Semua bisa di-nested.
         * Yang membuat nested loop bukan jenis loopnya, tapi struktur logikanya:
         *
         * loop luar → mengontrol siklus besar
         * loop dalam → mengontrol detail di dalamnya
         *
         * Misalnya:
         * baris × kolom
         * hari × jam
         * player × item
         * matrix × element
         */

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
         * i	    j mulai	    jumlah titik
         * 0	    0	        10
         * 1	    1	        9
         * 2	    2	        8
         * 3	    3	        7
         * 4	    4	        6
         * 5	    5	        5
         * 6	    6	        4
         * 7	    7	        3
         * 8	    8	        2
         * 9	    9	        1
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
