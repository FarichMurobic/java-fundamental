package FundamentalJava.Lambda;

/**
 * Block Lambda Expressions
 *
 * Di contoh sebelumnya:
 * lambda cuma 1 baris → disebut expression lambda
 *
 * Expression Lambda
 *
 * Contoh:
 * (n) -> n % 2 == 0
 *
 * Cuma 1 ekspresi
 * otomatis return
 *
 * Masalahnya…
 * Kadang kita butuh:
 * banyak baris kode
 * loop
 * kondisi
 * variabel
 *
 * Nah di sinilah kita pakai block lambda
 *
 * Block Lambda
 * Lambda dengan body berupa blok kode {}
 *
 * Ciri-ciri:
 * pakai { }
 * bisa banyak statement
 * bisa:
 * variabel
 * loop
 * if/switch
 * HARUS pakai return (kalau ada nilai balik)
 *
 * 1. Block lambda = mini method
 *
 * Ini udah kayak method beneran:
 * ada variable
 * ada loop
 * ada logic kompleks
 *
 * 2. Kapan pakai?
 *
 * Gunakan block lambda kalau:
 * logic panjang
 * butuh lebih dari 1 baris
 * butuh kontrol alur
 *
 * 3. Ini sering dipakai di:
 *
 * Stream API kompleks
 * Data processing
 * Business logic kecil
 *
 * 4. Ini perbedaan besar:
 * Expression Lambda	    Block Lambda
 * 1 baris	                banyak baris
 * auto return	            wajib return
 * simpel	                kompleks
 *
 * ----------------------------------------------
 * 
 * Kesimpulan Super Sederhana
 * 
 * 1. Block lambda pakai {}
 * (n) -> {
 *     return n * 2;
 * }
 * 
 * 2. Bisa banyak statement
 * variabel
 * loop
 * kondisi
 * 
 * 3. HARUS pakai return
 * 4. Dipakai untuk logic kompleks
 */

/**
 * Penjelasan tambahan dari buku
 *
 * Di contoh sebelumnya:
 * block lambda bisa punya:
 * variabel (result)
 * loop (for)
 * return
 *
 * Intinya:
 * Block lambda mirip banget sama isi method biasa
 *
 * Hal penting banget:
 * return di dalam lambda
 * cuma keluar dari lambda
 * BUKAN keluar dari method utama (main)
 *
 * Contoh baru: Membalik String
 *
 * Program ini:
 * membalik karakter string
 *
 * Contoh:
 * "Lambda" → "adbmaL"
 */

interface Faktorial {
    // METHOD MENERIMA INT DAN RETURN INT
    int fak(int n);
}

interface StringFunc {
    String func(String n);
}

public class BlockLambdaExpression {
    public static void main(String[] args) {

        // BLOCK LAMBDA MENGHITUNG FAKTORIAL
        Faktorial faktorial = (n) -> {
            // variabel untuk menyimpan hasil
            int result = 1;

            // loop dari 1 sampai n
            for (int i = 1; i <= n; i++) {
                // perkalian bertahap
                result = i * result;
            }
            // WAJIB RETURN KARENA PAKE BLOCK
            return result;
        }; // WAJIB TITIK KOMA

        // memanggil lambda
        System.out.println("The factorial of 3 is " + faktorial.fak(3));
        System.out.println("The factorial of 10 is " + faktorial.fak(10));

        /**
         * 1. Perhatikan ini:
         * (n) -> {
         *
         * Ini tanda:
         * Kita pakai block lambda
         *
         * 2. Isi block
         * int result = 1;
         *
         * Kita bisa bikin variabel
         * (ini gak bisa di expression lambda)
         *
         * for (int i = 1; i <= n; i++)
         * Bisa pakai loop
         *
         * 3. WAJIB pakai return
         * return result;
         *
         * Kenapa?
         * Karena:
         * ini bukan 1 ekspresi
         * Java gak bisa auto-return
         *
         * Perbandingan penting
         * Expression lambda:
         * (n) -> n * 2
         *
         * auto return
         *
         * Block lambda:
         * (n) -> {
         *     return n * 2;
         * }
         *
         * HARUS pakai return
         */

        System.out.println();

        // CONTOH KEDUA
        StringFunc stringFunc = (str) -> {
            // variabel untuk menyimpan hasil balik
            String result = "";
            int i;

            // loop dari index terakhir ke awal
            for (i = str.length() - 1; i >= 0; i-- ) {
                // ambil karakter per karakter lalu gabungkan
                result += str.charAt(i);
            }
            // wajib return, mengembalikan hasil string yang dibalik
            return result;
        };

        // memanggil lambda
        System.out.println("Lambda reversed is " + stringFunc.func("Lambda"));
        System.out.println("Expression reversed is " + stringFunc.func("Expression"));

        /**
         * Penjelasan Mendalam
         * 1. Functional Interface
         * String func(String n);
         *
         * Artinya:
         * input: String
         * output: String
         *
         * 2. Lambda
         * (str) -> { ... }
         *
         * str otomatis dianggap String
         *
         * Kenapa?
         * Karena Java lihat:
         *
         * String func(String n);
         * ini namanya type inference
         *
         * 3. Cara kerja membalik string
         * Misal:
         * "Lambda"
         * Loop:
         * for (i = str.length() - 1; i >= 0; i--)
         *
         * mulai dari belakang
         *
         * Ambil karakter:
         * str.charAt(i)
         * Gabung:
         * result += str.charAt(i);
         * Hasil:
         * "adbmaL"
         *
         * 4. Tentang charAt()
         * str.charAt(i)
         *
         * method milik String
         * bisa dipakai karena:
         * Java tau str itu String
         *
         * 5. Tentang return di lambda
         * return result;
         * ini cuma keluar dari:
         * lambda
         *
         * bukan keluar dari:
         * main()
         */

        /**
         * Insight Mentor
         * 
         * 1. Lambda sekarang udah kayak method full
         *
         * Di sini lo udah pakai:
         * loop
         * variable
         * logic kompleks
         *
         * ini bukan lagi “shortcut”, tapi logic engine kecil
         *
         * 2. Type inference itu powerful
         * (str) -> ...
         *
         * tanpa nulis:
         * (String str) -> ...
         *
         * 3. Ini konsep penting:
         * Lambda bisa handle object (bukan cuma angka)
         *
         * 4. Ini bakal kepake di:
         * manipulasi string
         * data processing
         * parsing data
         *
         * 5. Ini sebenarnya bisa diganti method biasa:
         * // Versi method biasa
         * String reverse(String str) {
         *     String result = "";
         *     for (int i = str.length() - 1; i >= 0; i--) {
         *         result += str.charAt(i);
         *     }
         *     return result;
         * }
         *
         * Lambda = versi ringkasnya
         *
         * ---------------------------------------------
         * 
         * Kesimpulan Super Sederhana
         * 
         * 1. Block lambda bisa handle logic kompleks
         * loop
         * variable
         * string
         *
         * 2. return hanya keluar dari lambda
         *
         * 3. Type parameter otomatis terdeteksi
         * (str) -> ...
         *
         * 4. Bisa manipulasi object (String, dll)
         */
    }
}
