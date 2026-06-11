package StructurePerulangann;

public class ForEachMultidimensiArray {
    public static void main(String[] args) {

        /**
         * Iterasi pada Multidimensional Array
         *
         * Versi enhanced for (for-each) juga bisa digunakan pada array multidimensi.
         * Tapi ingat: di Java, multidimensional array sebenarnya adalah array yang berisi array.
         * Contoh:
         * int[][] nums
         * Artinya:
         * nums -> array
         * yang isinya -> array lagi
         *
         * Jadi ketika kita melakukan iterasi menggunakan for-each,
         * setiap iterasi tidak langsung mengambil satu elemen, tapi mengambil array berikutnya.
         *
         * Contoh pada 2D array:
         * int[][] nums
         * Maka setiap iterasi pertama akan mengambil:
         * nums[0]
         * nums[1]
         * nums[2]
         * Yang semuanya adalah array 1 dimensi.
         * Karena itu variabel iterasi harus bertipe array juga.
         * Contoh:
         * for(int x[] : nums)
         * x adalah array 1 dimensi.
         * Lalu kita perlu loop lagi untuk mengambil elemen di dalamnya.
         *
         * Bayangin array 2D seperti tabel.
         * nums =
         * 1   2   3   4   5
         * 2   4   6   8   10
         * 3   6   9   12  15
         *
         * Struktur sebenarnya di Java:
         *
         * nums
         *  ├── nums[0] -> [1,2,3,4,5]
         *  ├── nums[1] -> [2,4,6,8,10]
         *  └── nums[2] -> [3,6,9,12,15]
         *
         * Jadi loop pertama mengambil:
         * nums[0]
         * nums[1]
         * nums[2]
         *
         * Baru loop kedua mengambil:
         * 1 2 3 4 5
         *
         * Istilah Penting
         * Multidimensional Array
         * Array yang punya lebih dari 1 dimensi.
         * Contoh:
         * int[][] matrix
         *
         * Nested Loop
         * Loop di dalam loop.
         *
         * for(){
         *    for(){
         *    }
         * }
         *
         * Biasanya dipakai untuk:
         * matrix
         * tabel
         * grid
         * game map
         *
         * Orang sering kira:
         * for(int x : nums)
         * akan mengambil elemen langsung.
         * Padahal tidak.
         * Karena nums adalah:
         * int[][]
         * jadi yang diambil adalah:
         * int[]
         *
         * Kalau tulis ini:
         * for(int x : nums)
         * akan error.
         * Karena tipe tidak cocok.
         * Harus:
         * for(int[] x : nums)
         *
         * Cara Mudah Mengingatnya
         * Rule sederhana:
         *
         * Array	For-each
         * int[]	for(int x : arr)
         * int[][]	for(int[] x : arr)
         * int[][][]	for(int[][] x : arr)
         *
         * Dimensi berkurang 1 setiap iterasi.
         */

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
