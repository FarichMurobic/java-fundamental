package FundamentalJava.StructurePerulangann;

public class ForEachLOOP {
    public static void main(String[] args) {

        /**
         * Mulai dari JDK 5, Java menambahkan bentuk kedua dari for, yaitu for-each loop.
         * 
         * Konsep for-each sebenarnya sudah populer di banyak bahasa pemrograman modern.
         * Tujuan loop ini adalah:
         * Mengambil setiap elemen dari sebuah collection (misalnya array) secara berurutan dari awal sampai akhir.
         *
         * Beberapa bahasa seperti C# menggunakan keyword khusus:
         * foreach
         *
         * Tapi Java tidak menambah keyword baru.
         * Java hanya memperluas syntax for yang sudah ada.
         * Karena itu for-each sering disebut:
         * enhanced for loop
         *
         * Bentuk Umum for-each
         *
         * Strukturnya:
         *
         * for(type variable : collection){
         *     statement
         * }
         *
         * Penjelasan:
         * Bagian	            Fungsi
         * type	                tipe data elemen
         * variable	            variabel sementara untuk menyimpan elemen
         * collection	        array atau kumpulan data
         *
         * Cara Kerja for-each
         * Misalnya ada array:
         * int nums[] = {1,2,3,4,5};
         *
         * Loop:
         * for(int x : nums){
         *     System.out.println(x);
         * }
         *
         * Prosesnya kira-kira seperti ini:
         * Iterasi	x
         * 1	    1
         * 2	    2
         * 3	    3
         * 4	    4
         * 5	    5
         *
         * Jadi Java otomatis mengambil elemen satu per satu dari array.
         * Kita tidak perlu pakai index.
         *
         * Perbandingan dengan for biasa
         * Cara lama (traditional for)
         * int nums[] = {1,2,3,4,5};
         * int sum = 0;
         *
         * for(int i = 0; i < nums.length; i++){
         *     sum += nums[i];
         * }
         *
         * Di sini kita harus:
         * 1-buat counter i
         * 2-tentukan batas nums.length
         * 3-akses array pakai nums[i]
         *
         * Menggunakan for-each
         * int nums[] = {1,2,3,4,5};
         * int sum = 0;
         *
         * for(int x : nums){
         *     sum += x;
         * }
         *
         * Lebih simpel karena:
         * tidak perlu index
         * tidak perlu batas array
         * tidak bisa out-of-bounds error
         *
         * Menghentikan for-each dengan break
         * Walaupun for-each biasanya membaca semua elemen, kita tetap bisa menghentikannya dengan break.
         *
         * Hal Penting: Variabel Iterasi Bersifat Read-Only
         * Contoh
         * for(int x : nums){
         *     x = x * 10;
         * }
         *
         * Kelihatannya kita mengubah nilai array.
         * Tapi sebenarnya tidak.
         * Kenapa?
         * Karena:
         * x hanyalah copy dari elemen array
         * Bukan referensi ke elemen array.
         *
         * Kapan Menggunakan for-each
         * Gunakan for-each kalau:
         * hanya membaca data
         * tidak perlu index
         * tidak perlu mengubah array
         *
         * Contoh:
         * print array
         * jumlahkan array
         * loop collection
         *
         * Kapan Tidak Boleh Pakai for-each
         * Jangan pakai for-each jika:
         * 1️- perlu index
         * nums[i]
         * 2️- perlu mengubah array
         * nums[i] = ...
         * 3️- perlu iterasi sebagian
         * start dari index tertentu
         *
         * Perbandingan Singkat
         * Loop	        Digunakan Untuk
         * for	        kontrol penuh
         * while	    kondisi tidak pasti
         * do-while	    minimal 1 kali
         * for-each	    iterasi collection
         *
         * Kesimpulan
         * for-each adalah cara paling sederhana untuk membaca array atau collection secara berurutan tanpa perlu index.
         *
         * for-each sebenarnya disembunyikan oleh compiler.
         * Compiler Java secara internal mengubahnya menjadi loop biasa atau iterator.
         *
         * Makanya:
         * for-each = syntax yang dipermudah
         */

        // Contoh program sederhana
        int nums[] = {1,2,3,4,5,6,7,8,9,10};
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
         *     x = x * 10;
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
         * Karena for-each hanya bisa berjalan melalui array secara berurutan dari awal sampai akhir,
         * mungkin kamu berpikir penggunaannya terbatas. Tapi sebenarnya tidak.
         * Banyak algoritma justru membutuhkan cara seperti ini.
         * Salah satu contoh paling umum adalah mencari suatu nilai (searching) di dalam array.
         * Program berikut menggunakan for-each loop untuk mencari suatu nilai dalam array yang tidak terurut.
         * Loop akan berhenti jika nilai tersebut ditemukan.
         */

        int numbers[] = {6,8,3,7,5,6,1,4};
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
         * Iterasi	x
         * 1	    6
         * 2	    8
         * 3	    3
         * 4	    7
         * 5	    5 ← ketemu
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
         * for-each ini jadi sangat penting nanti ketika belajar Java Collections seperti:
         * ArrayList
         * HashSet
         * HashMap
         * karena hampir semua iterasi di Java modern pakai for-each.
         */

    }
}
