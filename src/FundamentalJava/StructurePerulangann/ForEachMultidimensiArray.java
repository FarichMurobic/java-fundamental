package FundamentalJava.StructurePerulangann;

/**
 * ------------------------------------------------------------------------
 * ITERASI PADA MULTIDIMENSIONAL ARRAY
 * ------------------------------------------------------------------------
 * 
 * Versi enhanced for (for-each) juga bisa digunakan pada array multidimensi.
 * 
 * Tapi ingat: di Java, multidimensional array sebenarnya adalah
 * array yang berisi array.
 * 
 * Contoh:
 *     int[][] nums
 * 
 * Artinya:
 * - nums adalah array
 * - yang isinya adalah array lagi (array of arrays)
 * 
 * ------------------------------------------------------------------------
 * STRUKTUR MULTIDIMENSIONAL ARRAY
 * ------------------------------------------------------------------------
 * 
 * Bayangkan array 2D seperti tabel:
 * 
 *     nums =
 *     [
 *         [1, 2, 3, 4, 5],    // nums[0]
 *         [2, 4, 6, 8, 10],   // nums[1]
 *         [3, 6, 9, 12, 15]   // nums[2]
 *     ]
 * 
 * Struktur sebenarnya di Java:
 * 
 *     nums
 *      ├── nums[0] -> [1, 2, 3, 4, 5]
 *      ├── nums[1] -> [2, 4, 6, 8, 10]
 *      └── nums[2] -> [3, 6, 9, 12, 15]
 * 
 * Jadi:
 * - nums adalah array yang berisi 3 buah array
 * - Setiap elemen nums adalah array 1 dimensi
 * 
 * ------------------------------------------------------------------------
 * ITERASI PERTAMA: MENGAMBIL ARRAY
 * ------------------------------------------------------------------------
 * 
 * Ketika kita melakukan iterasi menggunakan for-each pada array 2D,
 * setiap iterasi pertama TIDAK mengambil elemen integer,
 * tapi mengambil ARRAY (baris).
 * 
 *     int[][] nums = {
 *         {1, 2, 3, 4, 5},
 *         {2, 4, 6, 8, 10},
 *         {3, 6, 9, 12, 15}
 *     };
 * 
 *     for (int[] baris : nums) {  // ← baris adalah int[]
 *         // baris adalah nums[0], nums[1], nums[2]
 *         // yang merupakan array 1 dimensi
 *     }
 * 
 * Proses iterasi:
 * 
 * Iterasi 1: baris = nums[0] = [1, 2, 3, 4, 5]
 * Iterasi 2: baris = nums[1] = [2, 4, 6, 8, 10]
 * Iterasi 3: baris = nums[2] = [3, 6, 9, 12, 15]
 * 
 * ------------------------------------------------------------------------
 * ITERASI KEDUA: MENGAMBIL ELEMEN
 * ------------------------------------------------------------------------
 * 
 * Setelah mendapatkan array (baris), kita perlu loop lagi
 * untuk mengambil elemen di dalamnya.
 * 
 *     int[][] nums = {
 *         {1, 2, 3, 4, 5},
 *         {2, 4, 6, 8, 10},
 *         {3, 6, 9, 12, 15}
 *     };
 * 
 *     for (int[] baris : nums) {
 *         for (int nilai : baris) {  // ← nilai adalah int
 *             System.out.print(nilai + " ");
 *         }
 *         System.out.println();
 *     }
 * 
 *     // Output:
 *     // 1 2 3 4 5
 *     // 2 4 6 8 10
 *     // 3 6 9 12 15
 * 
 * Ini disebut NESTED LOOP (loop di dalam loop).
 * 
 * ------------------------------------------------------------------------
 * KESALAHAN UMUM
 * ------------------------------------------------------------------------
 * 
 * Orang sering kira:
 * 
 *     int[][] nums = { ... };
 * 
 *     // SALAH! Error: type mismatch
 *     for (int x : nums) {  // ERROR!
 *         System.out.println(x);
 *     }
 * 
 * Kenapa error?
 * Karena:
 * - nums adalah int[][]
 * - Elemen nums adalah int[]
 * - x harusnya int[]
 * 
 * Perbaikan:
 * 
 *     // BENAR
 *     for (int[] x : nums) {  // x adalah int[]
 *         // ...
 *     }
 * 
 * ------------------------------------------------------------------------
 * CARA MUDAH MENGINGAT
 * ------------------------------------------------------------------------
 * 
 * Rule sederhana:
 * 
 * Array          | For-each
 * ---------------|------------------------------------------
 * int[]          | for (int x : arr)
 * int[][]        | for (int[] x : arr)
 * int[][][]      | for (int[][] x : arr)
 * 
 * Dimensi BERKURANG 1 setiap iterasi.
 * 
 * ------------------------------------------------------------------------
 * CONTOH ARRAY 3 DIMENSI
 * ------------------------------------------------------------------------
 * 
 *     int[][][] data3D = {
 *         {
 *             {1, 2},
 *             {3, 4}
 *         },
 *         {
 *             {5, 6},
 *             {7, 8}
 *         }
 *     };
 * 
 *     // Loop level 1: ambil array 2D
 *     for (int[][] layer : data3D) {
 * 
 *         // Loop level 2: ambil array 1D
 *         for (int[] baris : layer) {
 * 
 *             // Loop level 3: ambil elemen
 *             for (int nilai : baris) {
 *                 System.out.print(nilai + " ");
 *             }
 *             System.out.println();
 *         }
 *         System.out.println("---");
 *     }
 * 
 *     // Output:
 *     // 1 2
 *     // 3 4
 *     // ---
 *     // 5 6
 *     // 7 8
 *     // ---
 * 
 * ------------------------------------------------------------------------
 * ISTILAH PENTING
 * ------------------------------------------------------------------------
 * 
 * Multidimensional Array
 * Array yang punya lebih dari 1 dimensi.
 * Contoh: int[][] matrix, int[][][] cube
 * 
 * Nested Loop
 * Loop di dalam loop.
 * 
 *     for () {
 *         for () {
 *             // loop dalam
 *         }
 *     }
 * 
 * Biasanya dipakai untuk:
 * - Matriks
 * - Tabel
 * - Grid
 * - Game map
 * - Citra digital (pixel)
 * 
 * ------------------------------------------------------------------------
 * KESIMPULAN WAJIB
 * ------------------------------------------------------------------------
 * 
 * 1. Multidimensional array di Java = array of arrays
 * 2. For-each pada array 2D mengambil array 1D per iterasi
 * 3. Butuh nested loop untuk mengakses elemen sebenarnya
 * 4. Tipe variabel harus sesuai: int[] untuk array 2D
 * 5. Setiap level dimensi mengurangi 1 tingkat array
 * 
 * ------------------------------------------------------------------------
 */

public class ForEachMultidimensiArray {
    public static void main(String[] args) {

        int sum = 0;
        // Membuat array:
        int nums[][] = new int[3][5]; // 3 baris, 5 kolom

        // Mengisi Array
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 5; j++)
                nums[i][j] = (i + 1) * (j + 1);

        /**
         * Nilainya menjadi:
         * 1 2 3 4 5
         * 2 4 6 8 10
         * 3 6 9 12 15
         */

        // Bagian Paling Penting
        for (int x[] : nums) { // ambil setiap array di dalam nums
            for (int y : x) { // ambil setiap elemen di array x
                System.out.println("Value is: " + y);
                sum += y;
            }
        }

        System.out.println("Summation: " + sum);

        /**
         * Output
         * Value is: 1
         * Value is: 2
         * Value is: 3
         * Value is: 4
         * Value is: 5
         * Value is: 2
         * Value is: 4
         * Value is: 6
         * Value is: 8
         * Value is: 10
         * Value is: 3
         * Value is: 6
         * Value is: 9
         * Value is: 12
         * Value is: 15
         * Summation: 90
         *
         * Penjelasan Alur Program
         * 1️. Membuat array
         * int nums[][] = new int[3][5];
         *
         * Artinya:
         * 3 baris
         * 5 kolom
         *
         * Strukturnya di memori kira-kira:
         * nums
         *  ├── [ ?, ?, ?, ?, ? ]
         *  ├── [ ?, ?, ?, ?, ? ]
         *  └── [ ?, ?, ?, ?, ? ]
         *
         * 2️. Mengisi array
         * Loop ini:
         * nums[i][j] = (i + 1) * (j + 1);
         * menghasilkan:
         * 1 2 3 4 5
         * 2 4 6 8 10
         * 3 6 9 12 15
         *
         * 3️. Loop pertama (for-each)
         * for (int x[] : nums)
         * Artinya:
         * x = nums[0]
         * x = nums[1]
         * x = nums[2]
         *
         * Isi x misalnya:
         * [1,2,3,4,5]
         *
         * 4️. Loop kedua
         * for (int y : x)
         * Artinya:
         * ambil setiap angka dari array x
         * Iterasi:
         * y = 1
         * y = 2
         * y = 3
         * y = 4
         * y = 5
         *
         * 5️. Menjumlahkan
         * sum += y;
         * Total akhirnya:
         * 1+2+3+4+5
         * +2+4+6+8+10
         * +3+6+9+12+15
         * = 90
         */

    }
}
