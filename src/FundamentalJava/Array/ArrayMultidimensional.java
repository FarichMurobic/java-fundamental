package FundamentalJava.Array;

/*

Array multidimensi 

Array multidimensi di Java sebenarnya adalah array dari array .
Setiap dimensi ditambahkan dengan sepasang tanda kurung siku [].

Lo bisa mendeklarasikannya seperti ini:
int twoD[][] = new int[4][5];
membuat tabel dengan 4 baris dan 5 kolom.

Array Tidak Beraturan (Irregular Arrays)
Karena ini adalah "array di dalam array", lo bisa menentukan panjang baris secara manual.
Tidak semua baris harus punya jumlah kolom yang sama. Ini berguna banget buat menghemat
memori kalau datanya nggak penuh (sparse).

Inisialisasi
Lo bisa langsung isi datanya pakai kurung kurawal bersarang {{...}, {...}}. Lo bahkan bisa
pakai ekspresi matematika (seperti 1*1) di dalamnya.

Kode ini membuat sebuah array 4x5, yang secara konseptual terlihat seperti matriks.
Array Multidimensi ini kuncinya antara baris dan kolom broo.

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
