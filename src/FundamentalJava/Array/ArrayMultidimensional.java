package FundamentalJava.Array;

/**
 * ---------------------------------------------------------------------------
 * ARRAY MULTIDIMENSI (MULTIDIMENSIONAL ARRAY)
 * ---------------------------------------------------------------------------
 *
 * Array multidimensi adalah array yang elemen-elemennya juga
 * berupa array.
 *
 * Dengan kata lain:
 *
 * Array Multidimensi
 * -> Array yang berisi Array
 *
 * Oleh karena itu, secara teknis array multidimensi di Java
 * sebenarnya adalah "array of arrays".
 *
 * Setiap dimensi tambahan ditandai dengan pasangan tanda
 * kurung siku ([]).
 *
 * ---------------------------------------------------------------------------
 * DEKLARASI ARRAY DUA DIMENSI
 * ---------------------------------------------------------------------------
 *
 * Contoh:
 *
 * int[][] twoD = new int[4][5];
 *
 * atau:
 *
 * int twoD[][] = new int[4][5];
 *
 * Kedua bentuk tersebut memiliki arti yang sama.
 *
 * Pada contoh di atas:
 *
 * - 4 menunjukkan jumlah baris (row).
 * - 5 menunjukkan jumlah kolom (column).
 *
 * Visualisasi:
 *
 * [ ][ ][ ][ ][ ]
 * [ ][ ][ ][ ][ ]
 * [ ][ ][ ][ ][ ]
 * [ ][ ][ ][ ][ ]
 *
 * Flow:
 * Array 2 Dimensi
 * -> 4 Baris
 * -> Setiap Baris Memiliki 5 Kolom
 *
 * ---------------------------------------------------------------------------
 * KONSEP BARIS DAN KOLOM
 * ---------------------------------------------------------------------------
 *
 * Saat bekerja dengan array dua dimensi, konsep terpenting yang
 * harus dipahami adalah:
 *
 * Baris (Row) dan Kolom (Column).
 *
 * Contoh:
 *
 * int[][] data = new int[3][4];
 *
 * Artinya:
 *
 * - 3 Baris
 * - 4 Kolom
 *
 * Indeks:
 *
 * data[0][0] -> Baris 0, Kolom 0
 * data[0][1] -> Baris 0, Kolom 1
 * data[1][2] -> Baris 1, Kolom 2
 * data[2][3] -> Baris 2, Kolom 3
 *
 * Flow:
 * data[baris][kolom]
 *
 * ---------------------------------------------------------------------------
 * ARRAY TIDAK BERATURAN (IRREGULAR ARRAY)
 * ---------------------------------------------------------------------------
 *
 * Karena array multidimensi di Java sebenarnya merupakan
 * array yang berisi array lainnya, setiap baris dapat memiliki
 * panjang yang berbeda.
 *
 * Kondisi ini disebut:
 *
 * Irregular Array
 *
 * atau sering juga disebut:
 *
 * Jagged Array
 *
 * Contoh:
 *
 * int[][] data = new int[3][];
 *
 * data[0] = new int[2];
 * data[1] = new int[5];
 * data[2] = new int[3];
 *
 * Hasil:
 *
 * Baris 0 -> 2 Kolom
 * Baris 1 -> 5 Kolom
 * Baris 2 -> 3 Kolom
 *
 * Flow:
 * Array Utama
 * -> Baris 0 (2 Kolom)
 * -> Baris 1 (5 Kolom)
 * -> Baris 2 (3 Kolom)
 *
 * ---------------------------------------------------------------------------
 * KEUNTUNGAN IRREGULAR ARRAY
 * ---------------------------------------------------------------------------
 *
 * Irregular Array dapat membantu menghemat memori ketika setiap
 * baris tidak membutuhkan jumlah kolom yang sama.
 *
 * Sangat berguna untuk:
 *
 * - Data yang tidak simetris.
 * - Struktur data bertingkat.
 * - Data sparse (banyak ruang kosong).
 *
 * Karena memori hanya dialokasikan sesuai kebutuhan masing-masing
 * baris.
 *
 * ---------------------------------------------------------------------------
 * INISIALISASI LANGSUNG ARRAY MULTIDIMENSI
 * ---------------------------------------------------------------------------
 *
 * Array multidimensi dapat langsung diisi menggunakan kurung
 * kurawal bersarang.
 *
 * Contoh:
 *
 * int[][] matrix = {
 *     {1, 2, 3, 4, 5},
 *     {6, 7, 8, 9, 10},
 *     {11, 12, 13, 14, 15},
 *     {16, 17, 18, 19, 20}
 * };
 *
 * Java akan secara otomatis:
 *
 * - Menentukan jumlah baris.
 * - Menentukan jumlah kolom setiap baris.
 * - Mengalokasikan seluruh memori yang dibutuhkan.
 *
 * ---------------------------------------------------------------------------
 * EKSPRESI DALAM INISIALISASI
 * ---------------------------------------------------------------------------
 *
 * Java juga mengizinkan penggunaan ekspresi saat inisialisasi.
 *
 * Contoh:
 *
 * int[][] table = {
 *     {1 * 1, 1 * 2, 1 * 3},
 *     {2 * 1, 2 * 2, 2 * 3},
 *     {3 * 1, 3 * 2, 3 * 3}
 * };
 *
 * Sebelum program dijalankan, hasil ekspresi akan dihitung dan
 * nilainya disimpan ke dalam array.
 *
 * ---------------------------------------------------------------------------
 * ARRAY MULTIDIMENSI SEBAGAI MATRIKS
 * ---------------------------------------------------------------------------
 *
 * Secara konseptual, array dua dimensi sering dibayangkan sebagai
 * sebuah matriks atau tabel.
 *
 * Contoh:
 *
 * int[][] matrix = new int[4][5];
 *
 * Visualisasi:
 *
 * Baris 0 -> [ ][ ][ ][ ][ ]
 * Baris 1 -> [ ][ ][ ][ ][ ]
 * Baris 2 -> [ ][ ][ ][ ][ ]
 * Baris 3 -> [ ][ ][ ][ ][ ]
 *
 * Namun perlu diingat:
 *
 * Secara teknis Java tidak menyimpan array multidimensi sebagai
 * matriks sungguhan.
 *
 * Java menyimpannya sebagai:
 *
 * Array
 * -> Array
 * -> Array
 * -> Array
 *
 * Inilah alasan mengapa setiap baris dapat memiliki panjang yang
 * berbeda.
 *
 * ---------------------------------------------------------------------------
 * KESIMPULAN
 * ---------------------------------------------------------------------------
 *
 * Array multidimensi adalah array yang berisi array lainnya.
 *
 * Konsep paling penting yang harus dipahami:
 *
 * - Baris (Row)
 * - Kolom (Column)
 *
 * Deklarasi umum:
 *
 * int[][] data = new int[baris][kolom];
 *
 * Array multidimensi di Java sebenarnya adalah:
 *
 * Array
 * -> Berisi Array
 * -> Berisi Data
 *
 * Karena itu Java mendukung Irregular Array (Jagged Array),
 * yaitu kondisi ketika setiap baris memiliki jumlah kolom yang
 * berbeda.
 *
 * Array multidimensi sangat sering digunakan untuk merepresentasikan:
 *
 * - Matriks.
 * - Tabel data.
 * - Peta (Map).
 * - Grid permainan.
 * - Struktur data bertingkat.
 */

public class ArrayMultidimensional {
    public static void main(String[] args) {

        // Alokasi baris dulu (5 baris), kolomnya masih kosong
        int duaDimensi[][] = new int[5][];

        // Alokasi kolom secara manual dengan ukuran berbeda tiap baris
        duaDimensi[0] = new int[1];
        duaDimensi[1] = new int[2];
        duaDimensi[2] = new int[3];
        duaDimensi[3] = new int[4];
        duaDimensi[4] = new int[5];

        int i, j, k = 0;

        // Mengisi data (perhatikan batas j < i + 1)
        for (i = 0; i < 5; i++) {
            for (j = 0; j < i + 1; j++) {
                duaDimensi[i][j] = k;
                k++;
            }
        }

        // Mencetak data
        for (i = 0; i < 5; i++) {
            for (j = 0; j < i + 1; j++) {
                System.out.print(duaDimensi[i][j] + " ");
            }
            System.out.println(); // pindah baris
        }

        /**
         * Kenapa j < i + 1? Karena jumlah kolom di setiap baris itu nggak sama, dan kebetulan
         * jumlah kolomnya mengikuti pola: Index Baris + 1.
         * 
         * SIMULASI:
         * - Putaran 1 (i = 0): j < 0 + 1 (j cuma bisa 0). Maka cuma ngisi duaDimensi[0][0].
         * - Putaran 2 (i = 1): j < 1 + 1 (j bisa 0 dan 1). Maka ngisi duaDimensi[1][0] dan duaDimensi[1][1].
         * - Putaran 3 (i = 2): j < 2 + 1 (j bisa 0, 1, 2). Maka ngisi 3 kolom.
         * ...dan seterusnya.
         *
         * Variabel k cuma jadi "counter" yang terus nambah tiap kali ada kotak yang diisi.
         * Kuncinya variabel i untuk baris sedangkan j untuk kolom.
         * 
         * OUTPUT
         * 0 
         * 1 2 
         * 3 4 5 
         * 6 7 8 9 
         * 10 11 12 13 14  
         */ 

        System.out.println();

        // LATIHAN LAGI
        int num[][] = new int[4][5];
        int num1, num2, num3 = 0;

        for (num1 = 0; num1 < 4; num1++)
            for (num2 = 0; num2 < 5; num2++) {
                num[num1][num2] = num3;
                num3++;
        }

        // Tampilkan
        for (num1 = 0; num1 < 4; num1++) {
            for (num2 = 0; num2 < 5; num2++) {
                System.out.print(num[num1][num2] + " ");
            }
            System.out.println(); // pindah baris
        }

        /**
         * OUTPUT
         * 0 1 2 3 4 
         * 5 6 7 8 9 
         * 10 11 12 13 14
         */

        System.out.println();

        // Matriks Perkalian (Inisialisasi Langsung)
        // Inisialisasi langsung dengan ekspresi matematika
        double m[][] = {{0*0, 1*0, 2*0, 3*0},
                        {0*1, 1*1, 2*1, 3*1},
                        {0*2, 1*2, 2*2, 3*2}, 
                        {0*3, 1*3, 2*3, 3*3}};

        int o, p;

        for (o = 0; o < 4; o++) {
            for (p = 0; p < 4; p++) {
                System.out.print(m[o][p] + " ");
            }
            System.out.println(); // pindah baris
        }

        /**
         * Output
         * 0.0 0.0 0.0 0.0
         * 0.0 1.0 2.0 3.0
         * 0.0 2.0 4.0 6.0
         * 0.0 3.0 6.0 9.0
         */

        System.out.println();

        // Array 3 dimensi
        int tigaDimensi[][][] = new int[3][4][5];

        int three1, three2, three3;

        // Mengisi data di ruang 3D
        for (three1 = 0; three1 < 3; three1++)
            for (three2 = 0; three2 < 4; three2++)
                for (three3 = 0; three3 < 5; three3++)
                    tigaDimensi[three1][three2][three3] = three1 * three2 * three3;

        // Mencetak data per 'halaman'
        for (three1 = 0; three1 < 3; three1++) {
            for (three2 = 0; three2 < 4; three2++) {
                for (three3 = 0; three3 < 5; three3++)
                    System.out.print(tigaDimensi[three1][three2][three3] + " ");
                System.out.println(); // ENTER: Pindah ke baris baru setelah 5 kolom tercetak
            }
            System.out.println(); // DOUBLE ENTER: Kasih jarak antar halaman
        }

        /**
         * Output
         * 0 0 0 0 0
         * 0 0 0 0 0
         * 0 0 0 0 0
         * 0 0 0 0 0
         *
         * 0 0 0 0 0
         * 0 1 2 3 4
         * 0 2 4 6 8
         * 0 3 6 9 12
         *
         * 0 0 0 0 0
         * 0 2 4 6 8
         * 0 4 8 12 16
         * 0 6 12 18 24
         *
         * Jangan bayangkan ini sebagai satu benda padat. Di Java, ini adalah:
         * Dimensi 1 ([3]): Ada 3 "Halaman" atau "Blok" utama.
         * Dimensi 2 ([4]): Di setiap Halaman, ada 4 "Baris".
         * Dimensi 3 ([5]): Di setiap Baris, ada 5 "Kolom".
         *
         * Total slot memorinya adalah 3 x 4 x 5 = 60 slot.
         * Semuanya otomatis diisi angka 0 oleh Java saat pertama kali dibuat.
         */

        System.out.println();

        // ARRAY 3 DIMENSI
        int[][][] arr = {

            { // layer ke-0 (array 2D)
                
                {1, 2, 3}, // baris ke-0 → array 1D (kolom)
                {4, 5, 6}  // baris ke-1 → array 1D (kolom)
            },

            { // layer ke-1 (array 2D)
                
                {7, 8, 9},     // baris ke-0 → array 1D (kolom)
                {10, 11, 12},  // baris ke-1 → array 1D (kolom)
                {13, 14, 15}   // baris ke-2 → array 1D (kolom)
            },

            { // layer ke-2 (array 2D)
                
                {0, 0, 0},  // baris ke-0 → array 1D (kolom)
                {0, 0, 0},  // baris ke-1 → array 1D (kolom)
                {0, 0, 10}, // baris ke-2 → array 1D (kolom)
                {0, 0, 10}  // baris ke-3 → array 1D (kolom)
            }
        };

        for (int ii = 0; ii < arr.length; ii++) {
            System.out.println("Layer ke-" + ii);
            for (int jj = 0; jj < arr[ii].length; jj++) {
                for (int kk = 0; kk < arr[ii][jj].length; kk++) {
                    System.out.print(arr[ii][jj][kk] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        /**
         * OUTPUT
         * 
         * Layer ke-0
         * 1 2 3 
         * 4 5 6 

         * Layer ke-1
         * 7 8 9 
         * 10 11 12 
         * 13 14 15 

         * Layer ke-2
         * 0 0 0 
         * 0 0 0 
         * 0 0 10 
         * 0 0 10          
         */

        // AKSES LANGSUNG
        System.out.println("Akses langsung");
        System.out.println("Array [2][3][2]: " + arr[2][3][2]);
        System.out.println("Array [1][1][0]: " + arr[1][1][0]);

        /**
         * Output
         * Akses langsung
         * Array [2][3][2]: 10
         * Array [1][1][0]: 10
         */
    }
}
