package FundamentalJava.Rekursion;

    /**
     * Java mendukung recursion.
     * Recursion adalah proses mendefinisikan sesuatu menggunakan dirinya sendiri.
     * Dalam konteks pemrograman Java, recursion adalah kemampuan method untuk memanggil dirinya sendiri.
     * Method yang memanggil dirinya sendiri disebut recursive method.
     *
     * Contoh klasik dari recursion adalah menghitung factorial sebuah angka.
     * Factorial dari angka N adalah hasil perkalian semua bilangan bulat dari 1 sampai N.
     * Contoh:
     * 3! = 1 × 2 × 3 = 6
     * Berikut contoh program yang menghitung factorial menggunakan recursive method.
     *
     * Kapan Recursion Sangat Berguna
     * Recursion sering dipakai untuk:
     * Tree traversal
     * Graph algorithm
     * QuickSort
     * MergeSort
     * Backtracking
     * AI algorithms
     *
     * Inti Konsep Recursion (Ini yang Harus Lu Ingat)
     * Setiap recursive algorithm selalu punya 2 bagian:
     * Base Case
     * kondisi berhenti
     * if(n == 1)
     *    return 1;
     *
     * Recursive Case
     * memanggil diri sendiri
     * fact(n-1)
     * Kalau lu ingat dua hal ini:
     * BASE CASE
     * RECURSIVE CASE
     *
     * lu sudah ngerti 90% recursion.
     */

public class Rekursi {
    int fact(int n) {
        int result;
        // base case
        if (n == 1)
            return 1;
        // ini adalah rekursi
        result = fact(n - 1) * n; // rumus factorial
        return result;
    }

    // Contoh sederhana
    void hitung(int n) {
        // base case
        if (n == 0)
            return;
        System.out.println(n);
        // rekursi
        hitung(n - 1);
    }

    /**
     * int fact(int n)
     * Method fact():
     * menerima parameter n
     * bertipe int
     * mengembalikan hasil factorial.
     *
     * if(n == 1)
     *    return 1;
     * Ini disebut base case.
     *
     * Artinya:
     * Jika n = 1 maka berhenti dan kembalikan nilai 1.
     *
     * Kenapa?
     * Karena:
     * 1! = 1
     *
     * result = fact(n - 1) * n;
     * Ini bagian recursion.
     *
     * Artinya:
     * fact(n) = fact(n-1) × n
     *
     * Contoh:
     * fact(3) = fact(2) × 3
     * fact(2) = fact(1) × 2
     * fact(1) = 1
     *
     * return result;
     * Mengembalikan hasil factorial.
     */

    public static void main(String[] args) {

        Rekursi f = new Rekursi();

        System.out.println("factorial of 3 is: " + f.fact(3));
        System.out.println("factorial of 4 is: " + f.fact(4));
        System.out.println("factorial of 5 is: " + f.fact(5));
        
        Rekursi demo = new Rekursi();
        demo.hitung(10);

        /**
         * Visualisasi Recursion (Stack)
         * Saat program berjalan, method disimpan di stack memory.
         * fact(3)
         *   |
         *   v
         * fact(2)
         *   |
         *   v
         * fact(1)
         *
         * Setelah mencapai fact(1):
         * fact(1) = 1
         *
         * Stack mulai kembali:
         * fact(2) = 2
         * fact(3) = 6
         *
         * Ini yang dimaksud buku dengan istilah:
         * recursive methods “telescope” out and back.
         * Artinya:
         * method membuka ke bawah
         * lalu kembali ke atas.
         *
         * Kenapa Recursion Bisa Lebih Lambat
         * Buku bilang recursion bisa sedikit lebih lambat karena:
         * Setiap pemanggilan method membuat:
         * parameter baru
         * variabel lokal baru
         * stack frame baru
         *
         * Contoh:
         * fact(5)
         * fact(4)
         * fact(3)
         * fact(2)
         * fact(1)
         *
         * Ada 5 method call.
         * Sedangkan loop hanya satu method.
         *
         * Bahaya Recursion: Stack Overflow
         * Jika recursion tidak berhenti:
         * fact(n)
         * fact(n-1)
         * fact(n-2)
         * fact(n-3)
         * ...
         *
         * Stack akan terus bertambah sampai penuh.
         *
         * Akhirnya muncul error:
         * StackOverflowError
         */

        /**
         * Secara konsep recursion memang mirip loop, karena sama-sama melakukan pengulangan sampai kondisi berhenti terpenuhi.
         * Bedanya ada pada cara pengulangannya terjadi di memori dan cara program dieksekusi.
         * Sekarang kita bahas secara teknis dan detail kenapa recursion bisa terus berjalan sampai base case terpenuhi.
         * 1. Konsep Dasar Recursion
         * Recursion terjadi karena:
         * method memanggil dirinya sendiri
         * Contoh sederhana:
         *
         * int fact(int n){
         *     if(n == 1)
         *         return 1;
         *
         *     return fact(n - 1) * n;
         * }
         *
         * Saat method dipanggil:
         * fact(3)
         *
         * method tidak selesai langsung.
         * Dia malah memanggil dirinya sendiri lagi.
         *
         * 2. Kenapa Recursion Bisa Terus Berulang?
         * Jawaban teknisnya adalah:
         * karena setiap pemanggilan method membuat stack frame baru di call stack
         * Java menyimpan eksekusi method di struktur memori yang disebut:
         * Call Stack
         *
         * 3. Apa Itu Call Stack
         * Call stack adalah tempat menyimpan method yang sedang berjalan.
         * Setiap kali method dipanggil:
         * Java membuat stack frame baru
         * berisi:
         * parameter
         * variabel lokal
         * posisi eksekusi
         *
         * 4. Contoh Recursion fact(3)
         * Misalnya kita jalankan:
         * fact(3)
         *
         * Step 1
         * Program memanggil:
         * fact(3)
         * Stack:
         * fact(3)
         * Karena n != 1, maka:
         * return fact(2) * 3
         * Program harus menghitung fact(2) dulu.
         *
         * Step 2
         * Sekarang method baru dipanggil:
         * fact(2)
         * Stack:
         * fact(2)
         * fact(3)
         * Karena n != 1, maka:
         * return fact(1) * 2
         *
         * Step 3
         * Method dipanggil lagi:
         * fact(1)
         * Stack:
         * fact(1)
         * fact(2)
         * fact(3)
         *
         * Sekarang kondisi terpenuhi:
         *
         * if(n == 1)
         *     return 1
         *
         * 5. Sekarang Stack Mulai "Kembali"
         * Stack bekerja LIFO (Last In First Out).
         * Jadi:
         * Return ke fact(2)
         * fact(2) = 1 * 2
         *
         * hasil:
         * 2
         * Return ke fact(3)
         * fact(3) = 2 * 3
         * hasil:
         * 6
         *
         * 6. Kenapa Recursion Bisa Berhenti
         * Karena ada base case.
         * Contoh:
         *
         * if(n == 1)
         *     return 1;
         *
         * Saat kondisi ini terpenuhi:
         * method tidak memanggil dirinya lagi
         * method langsung return
         * stack mulai dikosongkan
         *
         * 7. Apa yang Terjadi Jika Tidak Ada Base Case
         * Contoh:
         *
         * int test(int n){
         *     return test(n-1);
         * }
         *
         * Yang terjadi:
         * test(5)
         * test(4)
         * test(3)
         * test(2)
         * test(1)
         * test(0)
         * test(-1)
         * test(-2)
         * ...
         *
         * Stack terus bertambah sampai penuh.
         * Akhirnya Java error:
         * StackOverflowError
         *
         * 8. Perbedaan Recursion vs Loop
         * Loop	                                    Recursion
         * Menggunakan for / while	                Method memanggil dirinya sendiri
         * Tidak membuat stack frame baru	        Setiap call membuat stack baru
         * Biasanya lebih cepat	                    Sedikit lebih lambat
         * Lebih hemat memori	                    Bisa stack overflow
         */

    }
}
