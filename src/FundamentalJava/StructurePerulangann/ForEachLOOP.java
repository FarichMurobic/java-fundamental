package FundamentalJava.StructurePerulangann;

/**
 * ------------------------------------------------------------------------
 * FOR-EACH LOOP (ENHANCED FOR LOOP)
 * ------------------------------------------------------------------------
 * 
 * Mulai dari JDK 5, Java menambahkan bentuk kedua dari for, yaitu for-each
 * loop..
 * 
 * Konsep for-each sebenarnya sudah populer di banyak bahasa pemrograman modern.
 * Tujuan loop ini adalah:
 * Mengambil setiap elemen dari sebuah collection (misalnya array)
 * secara berurutan dari awal sampai akhir.
 * 
 * Beberapa bahasa seperti C# menggunakan keyword khusus: foreach
 * 
 * Tapi Java TIDAK menambah keyword baru.
 * Java hanya memperluas syntax for yang sudah ada.
 * Karena itu for-each sering disebut:
 * enhanced for loop
 * 
 * ------------------------------------------------------------------------
 * BENTUK UMUM FOR-EACH
 * ------------------------------------------------------------------------
 * 
 * for (tipeData variabel : collection) {
 * // statement
 * }
 * 
 * Penjelasan:
 * 
 * Bagian | Fungsi
 * ----------------|-----------------------------------------------------------
 * tipeData | Tipe data elemen dalam collection
 * variabel | Variabel sementara untuk menyimpan setiap elemen
 * collection | Array atau kumpulan data yang akan diiterasi
 * 
 * ------------------------------------------------------------------------
 * CARA KERJA FOR-EACH
 * ------------------------------------------------------------------------
 * 
 * Misalnya ada array:
 * int[] nums = {1, 2, 3, 4, 5};
 * 
 * Loop for-each:
 * for (int x : nums) {
 * System.out.println(x);
 * }
 * 
 * Prosesnya kira-kira seperti ini:
 * 
 * Iterasi | x | Keterangan
 * ------------|--------|------------------------------------------
 * 1 | 1 | Ambil elemen ke-0 (nums[0])
 * 2 | 2 | Ambil elemen ke-1 (nums[1])
 * 3 | 3 | Ambil elemen ke-2 (nums[2])
 * 4 | 4 | Ambil elemen ke-3 (nums[3])
 * 5 | 5 | Ambil elemen ke-4 (nums[4])
 * 
 * Jadi Java otomatis mengambil elemen satu per satu dari array.
 * Kita tidak perlu menggunakan index.
 * 
 * ------------------------------------------------------------------------
 * PERBANDINGAN DENGAN FOR BIASA
 * ------------------------------------------------------------------------
 * 
 * Cara lama (traditional for):
 * 
 * int[] nums = {1, 2, 3, 4, 5};
 * int sum = 0;
 * 
 * for (int i = 0; i < nums.length; i++) {
 * sum += nums[i];
 * }
 * 
 * Di sini kita harus:
 * 1. Buat counter i
 * 2. Tentukan batas nums.length
 * 3. Akses array pakai nums[i]
 * 
 * Menggunakan for-each:
 * 
 * int[] nums = {1, 2, 3, 4, 5};
 * int sum = 0;
 * 
 * for (int x : nums) {
 * sum += x;
 * }
 * 
 * Lebih simpel karena:
 * - Tidak perlu index
 * - Tidak perlu batas array
 * - Tidak mungkin out-of-bounds error
 * 
 * ------------------------------------------------------------------------
 * CONTOH FOR-EACH DENGAN ARRAY
 * ------------------------------------------------------------------------
 * 
 * String[] nama = {"Andi", "Budi", "Citra", "Dewi"};
 * 
 * for (String n : nama) {
 * System.out.println("Nama: " + n);
 * }
 * 
 * // Output:
 * // Nama: Andi
 * // Nama: Budi
 * // Nama: Citra
 * // Nama: Dewi
 * 
 * ------------------------------------------------------------------------
 * MENGHENTIKAN FOR-EACH DENGAN break
 * ------------------------------------------------------------------------
 * 
 * Walaupun for-each biasanya membaca semua elemen,
 * kita tetap bisa menghentikannya dengan break.
 * 
 * int[] nums = {10, 20, 30, 40, 50};
 * 
 * for (int x : nums) {
 * if (x == 30) {
 * break;
 * }
 * System.out.println(x);
 * }
 * 
 * // Output:
 * // 10
 * // 20
 * 
 * ------------------------------------------------------------------------
 * HAL PENTING: VARIABEL ITERASI BERSIFAT READ-ONLY
 * ------------------------------------------------------------------------
 * 
 * Perhatikan kode ini:
 * 
 * int[] nums = {1, 2, 3, 4, 5};
 * 
 * for (int x : nums) {
 * x = x * 10;
 * }
 * 
 * // Array nums TIDAK berubah!
 * // Nilai nums tetap {1, 2, 3, 4, 5}
 * 
 * Kenapa?
 * Karena:
 * x hanyalah COPY (salinan) dari elemen array,
 * BUKAN referensi ke elemen array.
 * 
 * Jadi mengubah x tidak mempengaruhi array asli.
 * 
 * ------------------------------------------------------------------------
 * KAPAN MENGGUNAKAN FOR-EACH?
 * ------------------------------------------------------------------------
 * 
 * Gunakan for-each jika:
 * - Hanya MEMBACA data dari array/collection
 * - Tidak perlu index
 * - Tidak perlu mengubah isi array/collection
 * 
 * Contoh kasus:
 * - Mencetak semua elemen array
 * - Menjumlahkan semua elemen
 * - Mencari nilai tertentu
 * - Iterasi collection (List, Set, dll)
 * 
 * ------------------------------------------------------------------------
 * KAPAN TIDAK BOLEH PAKAI FOR-EACH?
 * ------------------------------------------------------------------------
 * 
 * Jangan pakai for-each jika:
 * 
 * 1. Perlu INDEX
 * for (int i = 0; i < arr.length; i++) {
 * arr[i] = ...
 * }
 * 
 * 2. Perlu mengubah ELEMEN ARRAY
 * for (int i = 0; i < arr.length; i++) {
 * arr[i] = arr[i] * 2;
 * }
 * 
 * 3. Perlu iterasi SEBAGIAN (start dari index tertentu)
 * for (int i = 5; i < arr.length; i++) {
 * // ...
 * }
 * 
 * 4. Perlu iterasi MUNDUR (dari belakang)
 * for (int i = arr.length - 1; i >= 0; i--) {
 * // ...
 * }
 * 
 * ------------------------------------------------------------------------
 * FOR-EACH DENGAN MULTIDIMENSIONAL ARRAY
 * ------------------------------------------------------------------------
 * 
 * int[][] matrix = {
 * {1, 2, 3},
 * {4, 5, 6},
 * {7, 8, 9}
 * };
 * 
 * // Iterasi baris
 * for (int[] baris : matrix) {
 * // Iterasi kolom dalam setiap baris
 * for (int nilai : baris) {
 * System.out.print(nilai + " ");
 * }
 * System.out.println();
 * }
 * 
 * // Output:
 * // 1 2 3
 * // 4 5 6
 * // 7 8 9
 * 
 * ------------------------------------------------------------------------
 * FOR-EACH DENGAN COLLECTION (LIST, SET)
 * ------------------------------------------------------------------------
 * 
 * List<String> daftar = Arrays.asList("Apel", "Mangga", "Jeruk");
 * 
 * for (String buah : daftar) {
 * System.out.println("Buah: " + buah);
 * }
 * 
 * // Output:
 * // Buah: Apel
 * // Buah: Mangga
 * // Buah: Jeruk
 * 
 * ------------------------------------------------------------------------
 * PERBANDINGAN SINGKAT SEMUA LOOP
 * ------------------------------------------------------------------------
 * 
 * Loop | Digunakan Untuk
 * ------------|-----------------------------------------------------------
 * for | Kontrol penuh (index, batas, step)
 * while | Kondisi tidak pasti, bisa 0 kali
 * do-while | Minimal 1 kali eksekusi
 * for-each | Iterasi collection/array (hanya baca)
 * 
 * ------------------------------------------------------------------------
 * KESIMPULAN
 * ------------------------------------------------------------------------
 * 
 * for-each adalah cara paling sederhana untuk membaca array atau collection
 * secara berurutan tanpa perlu index.
 * 
 * for-each sebenarnya disembunyikan oleh compiler.
 * Compiler Java secara internal mengubahnya menjadi loop biasa atau iterator.
 * 
 * Makanya:
 * for-each = syntax yang dipermudah (syntactic sugar)
 * 
 * ------------------------------------------------------------------------
 */

public class ForEachLOOP {
    public static void main(String[] args) {

        // Contoh program sederhana
        int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int sum = 0;

        for (int x : nums) {
            System.out.println("Value is: " + x);
            sum += x; // menambahkan semua nilai array
        }

        System.out.println("Summation: " + sum);

        /**
         * Output
         * Value is: 1
         * Value is: 2
         * Value is: 3
         * Value is: 4
         * Value is: 5
         * Value is: 6
         * Value is: 7
         * Value is: 8
         * Value is: 9
         * Value is: 10
         * Summation: 55
         */

        // Menghentikan for-each dengan break
        for (int x : nums) {
            System.out.println(x);
            if (x == 5)
                break;
        }

        /**
         * Output
         * 1
         * 2
         * 3
         * 4
         * 5
         * Loop berhenti saat angka 5 ditemukan.
         */

        // Contoh Variabel Iterasi Bersifat Read-Only
        for (int x : nums) {
            x = x * 10; // keliatannya kita sedang merubah array
        }

        for (int x : nums) {
            System.out.print(x + " ");
        }

        /**
         * Output
         * 1 2 3 4 5 6 7 8 9 10
         *
         * Array tidak berubah
         */

        /**
         * Cara Benar Mengubah Isi Array
         * Kalau ingin mengubah array, gunakan for biasa.
         */

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * 10; // Ini baru array berubah menggunakan for biasa.
        }

        System.out.println("\nArray setelah diubah.");

        for (int x : nums) {
            System.out.print(x + " ");
        }

        /**
         * Output
         * Array setelah diubah.
         * 10 20 30 40 50 60 70 80 90 100
         *
         * Kenapa Tidak Bisa Pakai for-each
         * Kalau pakai ini:
         *
         * for(int x : nums){
         * x = x * 10;
         * }
         *
         * Yang berubah hanya variabel x, bukan arraynya.
         * Karena:
         * x hanya salinan nilai dari nums
         * Array tetap:
         * {1,2,3,4,5}
         *
         * Biasanya rule-nya sederhana:
         * Jika hanya membaca data
         * pakai: For-each
         *
         * Jika ingin mengubah data
         * pakai: for biasa
         */

        /**
         * Menerapkan Enhanced for (for-each)
         * 
         * Karena for-each hanya bisa berjalan melalui array secara berurutan dari awal
         * sampai akhir,
         * mungkin kamu berpikir penggunaannya terbatas. Tapi sebenarnya tidak.
         * Banyak algoritma justru membutuhkan cara seperti ini.
         * Salah satu contoh paling umum adalah mencari suatu nilai (searching) di dalam
         * array.
         * Program berikut menggunakan for-each loop untuk mencari suatu nilai dalam
         * array yang tidak terurut.
         * Loop akan berhenti jika nilai tersebut ditemukan.
         */

        int numbers[] = { 6, 8, 3, 7, 5, 6, 1, 4 };
        int value = 5;
        boolean ditemukan = false;

        // gunakan for-each untuk mencari value
        for (int x : numbers) {
            if (x == 5) {
                ditemukan = true;
                break;
            }
        }

        if (ditemukan)
            System.out.println("\nValue ditemukan!");

        /**
         * Konsep Utama Program
         *
         * Program ini melakukan Linear Search.
         * Artinya:
         * periksa satu per satu elemen array
         * Urutannya:
         * 6
         * 8
         * 3
         * 7
         * 5
         * 6
         * 1
         * 4
         *
         * Program berhenti ketika menemukan 5.
         *
         * Alur Eksekusi Program
         * Array:
         * nums = {6,8,3,7,5,6,1,4}
         * Loop berjalan:
         * Iterasi x
         * 1 6
         * 2 8
         * 3 3
         * 4 7
         * 5 5 ← ketemu
         *
         * Saat x == val:
         * found = true;
         * break;
         * Loop langsung berhenti.
         *
         * Peran Variabel
         * value
         * int value = 5;
         * nilai yang ingin dicari.
         * ditemukan
         * boolean ditemukan = false; // artinya nilai awal belum ditemukan
         * penanda apakah nilai ditemukan atau tidak.
         *
         * x
         * for(int x : nums)
         * variabel iterasi yang menerima setiap elemen array.
         * Kenapa Pakai break
         * Baris ini:
         * break;
         * berguna supaya program tidak mengecek sisa array lagi.
         * Kalau tidak ada break, loop tetap jalan sampai akhir array.
         *
         * Output Program
         * Karena 5 ditemukan, outputnya:
         * Value found!
         * Kalau misalnya:
         * int val = 100;
         * maka tidak ada output.
         *
         * Kenapa for-each Cocok Untuk Ini
         * Karena kita hanya perlu:
         * membaca setiap elemen
         * Tidak perlu:
         * index
         * mengubah array
         * mengakses posisi tertentu
         * Jadi for-each lebih sederhana dan aman.
         *
         * for-each ini jadi sangat penting nanti ketika belajar Java Collections
         * seperti:
         * ArrayList
         * HashSet
         * HashMap
         * karena hampir semua iterasi di Java modern pakai for-each.
         */

    }
}
