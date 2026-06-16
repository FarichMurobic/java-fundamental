package FundamentalJava.Array;

/**
 * ---------------------------------------------------------------------------
 * ARRAY DI JAVA
 * ---------------------------------------------------------------------------
 *
 * Array adalah sekumpulan variabel yang memiliki tipe data yang
 * sama dan dikelompokkan di bawah satu nama.
 *
 * Setiap data yang disimpan di dalam array disebut elemen
 * (element).
 *
 * Untuk mengakses elemen tertentu digunakan nomor indeks
 * (index).
 *
 * Java mendukung:
 *
 * - Array satu dimensi (One-Dimensional Array)
 * - Array multidimensi (Multi-Dimensional Array)
 *
 * Flow:
 * Array -> Menyimpan Banyak Data Bertipe Sama
 * -> Akses Menggunakan Indeks
 *
 * ---------------------------------------------------------------------------
 * INDEKS ARRAY
 * ---------------------------------------------------------------------------
 *
 * Hal yang sangat penting untuk diingat:
 *
 * Semua indeks array di Java dimulai dari 0, bukan 1.
 *
 * Contoh:
 *
 * int[] angka = {10, 20, 30};
 *
 * Indeks:
 *
 * angka[0] -> 10
 * angka[1] -> 20
 * angka[2] -> 30
 *
 * Flow:
 * Elemen Pertama -> Indeks 0
 * Elemen Kedua -> Indeks 1
 * Elemen Ketiga -> Indeks 2
 *
 * ---------------------------------------------------------------------------
 * DEKLARASI ARRAY
 * ---------------------------------------------------------------------------
 *
 * Java menyediakan dua bentuk sintaks deklarasi array yang
 * memiliki arti yang sama.
 *
 * Bentuk 1:
 *
 * tipedata namaArray[];
 *
 * Contoh:
 *
 * int month_days[];
 *
 * Bentuk ini mirip dengan sintaks yang digunakan pada bahasa
 * C dan C++.
 *
 * ---------------------------------------------------------------------------
 *
 * Bentuk 2:
 *
 * tipedata[] namaArray;
 *
 * Contoh:
 *
 * int[] month_days;
 *
 * Bentuk ini lebih umum digunakan dalam kode Java modern karena
 * dianggap lebih konsisten dan lebih mudah dibaca.
 *
 * ---------------------------------------------------------------------------
 * DEKLARASI DAN PEMBUATAN ARRAY
 * ---------------------------------------------------------------------------
 *
 * Kedua contoh berikut memiliki arti yang sama:
 *
 * int month_days[] = new int[12];
 *
 * int[] month_days = new int[12];
 *
 * Keterangan:
 *
 * - int -> Tipe data elemen array.
 * - month_days -> Nama variabel array.
 * - new int[12] -> Membuat array berukuran 12 elemen.
 *
 * Flow:
 * Deklarasi Array -> Alokasi Memori -> Array Siap Digunakan
 *
 * ---------------------------------------------------------------------------
 * MENGAPA BENTUK int[] LEBIH DISUKAI?
 * ---------------------------------------------------------------------------
 *
 * Bentuk:
 *
 * int[] namaArray;
 *
 * sering dianggap lebih modern karena:
 *
 * - Lebih konsisten secara visual.
 * - Lebih mudah dibaca.
 * - Memperjelas bahwa tipe datanya adalah array of int.
 * - Lebih aman saat mendeklarasikan banyak variabel sekaligus.
 *
 * Contoh:
 *
 * int[] nums, nums2, nums3;
 *
 * Ketiga variabel di atas bertipe:
 *
 * int[]
 *
 * ---------------------------------------------------------------------------
 * PERBEDAAN YANG SERING MEMBINGUNGKAN
 * ---------------------------------------------------------------------------
 *
 * Contoh:
 *
 * int[] a, b;
 *
 * Hasil:
 *
 * a -> int[]
 * b -> int[]
 *
 * ---------------------------------------------------------------------------
 *
 * Contoh:
 *
 * int a[], b;
 *
 * Hasil:
 *
 * a -> int[]
 * b -> int
 *
 * Karena tanda [] melekat pada nama variabel, bukan pada tipe
 * data.
 *
 * Inilah salah satu alasan mengapa gaya:
 *
 * int[] namaArray;
 *
 * lebih direkomendasikan dalam Java modern.
 *
 * ---------------------------------------------------------------------------
 * KESIMPULAN
 * ---------------------------------------------------------------------------
 *
 * Array adalah struktur data yang digunakan untuk menyimpan
 * sekumpulan data dengan tipe yang sama di bawah satu nama.
 *
 * Karakteristik utama array:
 *
 * - Semua elemen memiliki tipe data yang sama.
 * - Diakses menggunakan indeks.
 * - Indeks dimulai dari 0.
 * - Dapat memiliki satu atau lebih dimensi.
 *
 * Java menyediakan dua bentuk deklarasi array:
 *
 * - int namaArray[]
 * - int[] namaArray
 *
 * Meskipun keduanya valid, bentuk:
 *
 * int[] namaArray
 *
 * lebih umum digunakan dan lebih direkomendasikan dalam praktik
 * Java modern karena lebih konsisten dan mengurangi potensi
 * kebingungan saat deklarasi banyak variabel.
 */

public class Array {
    public static void main(String[] args) {

        /**
         * ---------------------------------------------------------------------------
         * ARRAY SATU DIMENSI (ONE-DIMENSIONAL ARRAY)
         * ---------------------------------------------------------------------------
         *
         * Array satu dimensi adalah kumpulan elemen dengan tipe data yang
         * sama yang disimpan secara berurutan di dalam memori dan
         * dikelompokkan di bawah satu nama.
         *
         * Setiap elemen diakses menggunakan nomor indeks.
         *
         * Flow:
         * Array -> Menyimpan Banyak Data Bertipe Sama
         * -> Diakses Menggunakan Indeks
         *
         * ---------------------------------------------------------------------------
         * LANGKAH 1 - DEKLARASI VARIABEL ARRAY
         * ---------------------------------------------------------------------------
         *
         * Sebelum menggunakan array, kita harus mendeklarasikan variabel
         * yang akan mereferensikan array tersebut.
         *
         * Sintaks:
         *
         * tipe_data nama_variabel_array[];
         *
         * Contoh:
         *
         * int month_days[];
         *
         * Pada tahap ini:
         *
         * - Variabel month_days sudah dibuat.
         * - Array sebenarnya belum dibuat.
         * - Belum ada memori yang dialokasikan untuk elemen array.
         *
         * Dengan kata lain, kita baru membuat referensi yang nantinya
         * akan menunjuk ke sebuah object array.
         *
         * ---------------------------------------------------------------------------
         * LANGKAH 2 - ALOKASI MEMORI ARRAY
         * ---------------------------------------------------------------------------
         *
         * Setelah variabel array dideklarasikan, langkah berikutnya adalah
         * mengalokasikan memori menggunakan operator new.
         *
         * Sintaks:
         *
         * nama_variabel_array = new tipe_data[ukuran_array];
         *
         * Contoh:
         *
         * month_days = new int[12];
         *
         * Pada tahap ini:
         *
         * - Java membuat object array berukuran 12 elemen.
         * - Memori dialokasikan untuk seluruh elemen array.
         * - Referensi month_days menunjuk ke object array tersebut.
         *
         * Flow:
         * Deklarasi Referensi
         * -> new
         * -> Alokasi Memori
         * -> Object Array Dibuat
         * -> Referensi Menunjuk Ke Array
         *
         * ---------------------------------------------------------------------------
         * DEKLARASI DAN ALOKASI DALAM SATU BARIS
         * ---------------------------------------------------------------------------
         *
         * Kedua langkah tersebut biasanya digabung menjadi satu baris:
         *
         * int[] month_days = new int[12];
         *
         * Bentuk ini lebih umum digunakan dalam Java modern karena lebih
         * ringkas dan mudah dibaca.
         *
         * ---------------------------------------------------------------------------
         * NILAI DEFAULT ARRAY
         * ---------------------------------------------------------------------------
         *
         * Setelah array dibuat, seluruh elemen akan otomatis memperoleh
         * nilai default sesuai tipe datanya.
         *
         * Tipe Numerik:
         *
         * - byte -> 0
         * - short -> 0
         * - int -> 0
         * - long -> 0L
         * - float -> 0.0f
         * - double -> 0.0
         *
         * Boolean:
         *
         * - boolean -> false
         *
         * Karakter:
         *
         * - char -> '\u0000'
         *
         * Tipe Referensi:
         *
         * - String
         * - Object
         * - Class lain
         *
         * Akan bernilai:
         *
         * - null
         *
         * ---------------------------------------------------------------------------
         * CONTOH
         * ---------------------------------------------------------------------------
         *
         * int[] numbers = new int[5];
         *
         * Isi awal array:
         *
         * numbers[0] -> 0
         * numbers[1] -> 0
         * numbers[2] -> 0
         * numbers[3] -> 0
         * numbers[4] -> 0
         *
         * Karena seluruh elemen int secara otomatis diinisialisasi
         * dengan nilai default 0.
         *
         * ---------------------------------------------------------------------------
         * KESIMPULAN
         * ---------------------------------------------------------------------------
         *
         * Array satu dimensi digunakan untuk menyimpan banyak data
         * bertipe sama di bawah satu nama.
         *
         * Untuk membuat array diperlukan dua langkah:
         *
         * - Deklarasi variabel array.
         * - Alokasi memori menggunakan operator new.
         *
         * Setelah array dibuat:
         *
         * - Java mengalokasikan memori sesuai ukuran array.
         * - Setiap elemen memperoleh nilai default sesuai tipe datanya.
         * - Elemen dapat diakses menggunakan indeks yang dimulai dari 0.
         */

        System.out.println("----- Array Satu Dimensi -----");

        // Demonstrasi array 1 dimensi
        int month_Days[] = new int[12]; // Mengalokasikan memori

        // Jumlah 12 data array, index pertama dimulai dari 0.
        month_Days[0] = 31; // inisialisasi index
        month_Days[1] = 28; // inisialisasi index
        month_Days[2] = 31; // inisialisasi index
        month_Days[3] = 30; // inisialisasi index
        month_Days[4] = 31; // inisialisasi index
        month_Days[5] = 30; // inisialisasi index
        month_Days[6] = 31; // inisialisasi index
        month_Days[7] = 31; // inisialisasi index
        month_Days[8] = 30; // inisialisasi index
        month_Days[9] = 31; // inisialisasi index
        month_Days[10] = 30; // inisialisasi index
        month_Days[11] = 31; // inisialisasi index

        // Panggil index array ke 5 (Bulan June)
        System.out.println("Jumlah hari di bulan June (6): " + month_Days[5]);

        /**
         * ---------------------------------------------------------------------------
         * INISIALISASI LANGSUNG ARRAY
         * ---------------------------------------------------------------------------
         *
         * Selain membuat array menggunakan proses deklarasi dan alokasi
         * memori secara terpisah, Java juga menyediakan cara yang lebih
         * ringkas untuk membuat array.
         *
         * Dengan teknik ini, array dapat:
         *
         * - Dideklarasikan.
         * - Dialokasikan memorinya.
         * - Diinisialisasi nilainya.
         *
         * dalam satu pernyataan sekaligus.
         *
         * Java akan secara otomatis menentukan ukuran array berdasarkan
         * jumlah elemen yang diberikan.
         *
         * ---------------------------------------------------------------------------
         * CONTOH
         * ---------------------------------------------------------------------------
         *
         * int[] monthDays = {
         * 31, 28, 31, 30, 31, 30,
         * 31, 31, 30, 31, 30, 31
         * };
         *
         * Pada contoh di atas:
         *
         * - Java membuat object array secara otomatis.
         * - Ukuran array ditentukan dari jumlah elemen yang diberikan.
         * - Seluruh elemen langsung diinisialisasi saat array dibuat.
         *
         * Flow:
         * Deklarasi Array -> Alokasi Memori
         * -> Inisialisasi Nilai -> Array Siap Digunakan
         *
         * ---------------------------------------------------------------------------
         * KELEBIHAN INISIALISASI LANGSUNG
         * ---------------------------------------------------------------------------
         *
         * Teknik ini lebih disukai karena:
         *
         * - Lebih ringkas.
         * - Lebih mudah dibaca.
         * - Mengurangi jumlah kode yang ditulis.
         * - Cocok ketika seluruh nilai sudah diketahui sejak awal.
         *
         * Oleh karena itu, cara ini menjadi salah satu bentuk pembuatan
         * array yang paling sering digunakan dalam pemrograman Java.
         *
         * ---------------------------------------------------------------------------
         * PENULISAN YANG DIREKOMENDASIKAN
         * ---------------------------------------------------------------------------
         *
         * Dalam Java modern, bentuk berikut lebih umum digunakan:
         *
         * int[] monthDays = {
         * 31, 28, 31, 30, 31, 30,
         * 31, 31, 30, 31, 30, 31
         * };
         *
         * Dibandingkan:
         *
         * int monthDays[] = {
         * 31, 28, 31, 30, 31, 30,
         * 31, 31, 30, 31, 30, 31
         * };
         *
         * Keduanya valid, tetapi penggunaan:
         *
         * int[] monthDays
         *
         * dianggap lebih konsisten dan lebih sesuai dengan gaya
         * penulisan Java modern.
         *
         * ---------------------------------------------------------------------------
         * KESIMPULAN
         * ---------------------------------------------------------------------------
         *
         * Inisialisasi langsung memungkinkan array dibuat dan diisi
         * sekaligus dalam satu pernyataan.
         *
         * Java akan otomatis menentukan ukuran array berdasarkan jumlah
         * elemen yang diberikan.
         *
         * Teknik ini merupakan cara yang paling umum digunakan karena
         * lebih ringkas, efisien, dan mudah dibaca dibandingkan proses
         * deklarasi dan inisialisasi yang dilakukan secara terpisah.
         */

        int monthDays[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        System.out.println("Lebih Professional: " + monthDays[0]);

        String namaBulan[] = { "January", "February", "Maret", "April", "Mei", "June",
                "July", "August", "September", "Oktober", "November", "Desember" };

        System.out.println(namaBulan[5]); // Bulan June

        System.out.println("--------------------------------------------------");

        // Contoh berikutnya menggunakan for untuk menghasilkan data di array.
        double numberDouble[] = { 10.1, 10.2, 10.3, 10.4, 10.5 };
        double hasilDouble = 0; // Nilai default

        for (int i = 0; i < numberDouble.length; i++) {
            hasilDouble += numberDouble[i]; // Jumlahkan semua nilai didalam array
        }

        System.out.println("Jumlah nilai di NumberDouble: " + hasilDouble);

        // Nilai default jika belum di inisialisasi 0
        int angka[] = new int[3];
        // Jika belum di inisialisasi nilai default 0
        System.out.println(angka[1]); // 0

        // Isi data
        angka[0] = 1;
        angka[1] = 2;
        angka[2] = 3;

        System.out.println(angka[1]); // 2
        System.out.println(angka.length); // 3

        // Cetak semua isi
        for (int o = 0; o < angka.length; o++)
            System.out.println("Number: " + angka[o]);

        /**
         * OUTPUT
         * 
         * Number: 1
         * Number: 2
         * Number: 3
         */

        System.out.println("-----------------------");

        /**
         * ---------------------------------------------------------------------------
         * SINTAKS ALTERNATIF DEKLARASI ARRAY
         * ---------------------------------------------------------------------------
         *
         * Java menyediakan dua bentuk sintaks yang dapat digunakan untuk
         * mendeklarasikan array.
         *
         * Bentuk pertama:
         *
         * type varName[];
         *
         * Contoh:
         *
         * int a1[] = new int[3];
         *
         * Pada bentuk ini, tanda kurung siku ([]) ditempatkan setelah
         * nama variabel.
         *
         * ---------------------------------------------------------------------------
         *
         * Bentuk kedua:
         *
         * type[] varName;
         *
         * Contoh:
         *
         * int[] a2 = new int[3];
         *
         * Pada bentuk ini, tanda kurung siku ([]) ditempatkan setelah
         * tipe data.
         *
         * ---------------------------------------------------------------------------
         * KEDUA BENTUK INI EKIVALEN
         * ---------------------------------------------------------------------------
         *
         * Contoh:
         *
         * int a1[] = new int[3];
         *
         * int[] a2 = new int[3];
         *
         * Kedua deklarasi tersebut memiliki arti yang sama.
         *
         * Keduanya membuat:
         *
         * - Variabel array bertipe int[].
         * - Array dengan ukuran 3 elemen.
         *
         * Perbedaannya hanya terletak pada gaya penulisan.
         *
         * ---------------------------------------------------------------------------
         * KEUNGGULAN BENTUK type[]
         * ---------------------------------------------------------------------------
         *
         * Bentuk:
         *
         * type[] varName;
         *
         * sering dianggap lebih baik karena hubungan antara tipe data
         * dan array terlihat lebih jelas.
         *
         * Contoh:
         *
         * int[] nums;
         *
         * Dapat dibaca sebagai:
         *
         * "nums adalah array dari int"
         *
         * sehingga lebih konsisten dengan cara Java mendefinisikan tipe.
         *
         * ---------------------------------------------------------------------------
         * DEKLARASI BANYAK ARRAY DALAM SATU BARIS
         * ---------------------------------------------------------------------------
         *
         * Salah satu keuntungan terbesar bentuk:
         *
         * type[] varName;
         *
         * adalah ketika mendeklarasikan beberapa array sekaligus.
         *
         * Contoh:
         *
         * int[] nums, nums2, nums3;
         *
         * Hasil:
         *
         * - nums bertipe int[]
         * - nums2 bertipe int[]
         * - nums3 bertipe int[]
         *
         * Seluruh variabel tersebut merupakan array int.
         *
         * ---------------------------------------------------------------------------
         * BENTUK YANG LEBIH LAMA
         * ---------------------------------------------------------------------------
         *
         * Alternatif lain yang juga valid:
         *
         * int nums[], nums2[], nums3[];
         *
         * Hasilnya tetap sama:
         *
         * - nums bertipe int[]
         * - nums2 bertipe int[]
         * - nums3 bertipe int[]
         *
         * Namun bentuk ini dianggap kurang praktis dan kurang jelas
         * dibandingkan pendekatan modern.
         *
         * ---------------------------------------------------------------------------
         * ALASAN BENTUK type[] LEBIH DIREKOMENDASIKAN
         * ---------------------------------------------------------------------------
         *
         * - Lebih konsisten dengan sistem tipe Java.
         * - Lebih mudah dibaca.
         * - Lebih jelas saat mendeklarasikan banyak variabel.
         * - Mengurangi potensi kebingungan pada deklarasi yang kompleks.
         *
         * Karena alasan tersebut, sebagian besar kode Java modern,
         * library Java, dan framework seperti Spring menggunakan gaya:
         *
         * type[] varName;
         *
         * ---------------------------------------------------------------------------
         * KESIMPULAN
         * ---------------------------------------------------------------------------
         *
         * Java mendukung dua bentuk deklarasi array:
         *
         * - type varName[]
         * - type[] varName
         *
         * Kedua bentuk tersebut sepenuhnya ekivalen dan menghasilkan
         * tipe data yang sama.
         *
         * Namun dalam praktik Java modern, bentuk:
         *
         * type[] varName
         *
         * lebih disukai karena lebih konsisten, lebih mudah dibaca,
         * dan lebih nyaman digunakan saat mendeklarasikan banyak array
         * dalam satu baris.
         */

        // A kuring siku di tipe data
        int[] a, b, c;
        // Hasilnya: a, b, c adalah int tipe array

        a = new int[5];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        a[3] = 4;
        a[4] = 5;

        b = new int[5];
        b[0] = 1;
        b[1] = 2;
        b[2] = 3;
        b[3] = 4;
        b[4] = 5;

        c = new int[5];
        c[0] = 1;
        c[1] = 2;
        c[2] = 3;
        c[3] = 4;
        c[4] = 5;

        // B kurung siku di nama variabel
        int i[], j, k;
        // Hasilnya: hanya i yang bertipe array, j dan k int biasa

        // I ARRAY
        i = new int[5];
        i[0] = 1;
        i[1] = 2;
        i[2] = 3;
        i[3] = 4;
        i[4] = 5;

        // J DAN K int biasa
        j = 10;
        k = 10;

    }
}
