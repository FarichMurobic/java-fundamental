package FundamentalJava.Lambda;

/* ==========================================================
 *                  BLOCK LAMBDA EXPRESSIONS
 * ==========================================================
 *
 * Lambda expression di Java memiliki dua bentuk utama:
 *
 * 1. Expression Lambda
 * 2. Block Lambda
 *
 * Expression lambda digunakan ketika logic hanya terdiri dari
 * satu ekspresi sederhana.
 *
 * Sedangkan block lambda digunakan ketika logic membutuhkan
 * beberapa statement atau proses yang lebih kompleks.
 *
 * ==========================================================
 *                  EXPRESSION LAMBDA
 * ==========================================================
 *
 * Contoh:
 *
 *     n -> n % 2 == 0
 *
 * Karakteristik:
 *
 * - Hanya memiliki satu ekspresi.
 * - Tidak menggunakan tanda kurung kurawal {}.
 * - Return dilakukan secara otomatis.
 *
 * Contoh di atas secara konsep sama seperti:
 *
 *     (n) -> {
 *         return n % 2 == 0;
 *     }
 *
 * Karena hanya terdapat satu ekspresi, Java dapat langsung
 * mengetahui nilai yang harus dikembalikan.
 *
 * ==========================================================
 *                 KETERBATASAN EXPRESSION LAMBDA
 * ==========================================================
 *
 * Expression lambda cocok untuk operasi sederhana.
 *
 * Namun, terkadang sebuah fungsi membutuhkan:
 *
 * - Beberapa baris kode.
 * - Variabel sementara.
 * - Perulangan.
 * - Percabangan if/switch.
 * - Proses pengolahan data yang lebih kompleks.
 *
 * Untuk kebutuhan tersebut digunakan block lambda.
 *
 * ==========================================================
 *                    BLOCK LAMBDA
 * ==========================================================
 *
 * Block lambda adalah lambda expression yang memiliki body
 * berupa blok kode menggunakan tanda kurung kurawal {}.
 *
 * Bentuk umum:
 *
 *     parameter -> {
 *         statement;
 *         statement;
 *         return value;
 *     }
 *
 * Contoh:
 *
 *     n -> {
 *         int result = n * 2;
 *         return result;
 *     }
 *
 * ==========================================================
 *              KARAKTERISTIK BLOCK LAMBDA
 * ==========================================================
 *
 * Block lambda memiliki beberapa karakteristik:
 *
 * - Menggunakan {} sebagai body lambda.
 * - Dapat memiliki banyak statement.
 * - Dapat membuat variable lokal.
 * - Dapat menggunakan loop.
 * - Dapat menggunakan percabangan.
 * - Harus menggunakan return jika functional interface
 *   membutuhkan nilai balik.
 *
 * Berbeda dengan expression lambda yang melakukan return
 * secara otomatis.
 *
 * ==========================================================
 *                 BLOCK LAMBDA = MINI METHOD
 * ==========================================================
 *
 * Block lambda dapat dianggap sebagai method kecil yang dibuat
 * secara langsung.
 *
 * Di dalam block lambda kita dapat memiliki:
 *
 * - Variable.
 * - Perulangan.
 * - Kondisi.
 * - Proses pengolahan data.
 * - Return value.
 *
 * Contoh:
 *
 *     number -> {
 *
 *         int total = 0;
 *
 *         for (int i = 0; i < number; i++) {
 *             total += i;
 *         }
 *
 *         return total;
 *     }
 *
 * Struktur tersebut sudah menyerupai sebuah method biasa.
 *
 * ==========================================================
 *                   KAPAN MENGGUNAKAN?
 * ==========================================================
 *
 * Gunakan block lambda ketika:
 *
 * - Logic tidak cukup ditulis dalam satu ekspresi.
 * - Membutuhkan beberapa langkah proses.
 * - Membutuhkan variable tambahan.
 * - Membutuhkan kontrol alur seperti if atau loop.
 *
 * Expression lambda lebih cocok untuk logic pendek,
 * sedangkan block lambda cocok untuk logic yang lebih kompleks.
 *
 * ==========================================================
 *              PENGGUNAAN DALAM JAVA MODERN
 * ==========================================================
 *
 * Block lambda sering ditemukan pada:
 *
 * - Stream API.
 * - Pemrosesan collection.
 * - Filtering dan transformasi data.
 * - Business logic sederhana.
 * - Callback operation.
 *
 * Contoh:
 *
 *     list.stream()
 *         .map(item -> {
 *
 *             String result = item.toUpperCase();
 *
 *             return result;
 *         });
 *
 * ==========================================================
 *          PERBEDAAN EXPRESSION DAN BLOCK LAMBDA
 * ==========================================================
 *
 * Expression Lambda:
 *
 * - Satu baris.
 * - Satu ekspresi.
 * - Return otomatis.
 * - Cocok untuk logic sederhana.
 *
 *
 * Block Lambda:
 *
 * - Banyak baris.
 * - Menggunakan {}.
 * - Return harus ditulis secara eksplisit.
 * - Cocok untuk logic kompleks.
 *
 * ==========================================================
 *                ATURAN RETURN DALAM LAMBDA
 * ==========================================================
 *
 * Hal penting yang harus dipahami:
 *
 * return di dalam lambda hanya mengembalikan nilai dari lambda
 * tersebut.
 *
 * return TIDAK akan keluar dari method yang membungkus lambda.
 *
 * Contoh konsep:
 *
 *     public static void main(String[] args) {
 *
 *         process(() -> {
 *             return;
 *         });
 *
 *         System.out.println("Tetap berjalan");
 *     }
 *
 * Return tersebut hanya menghentikan eksekusi lambda, bukan
 * method main.
 *
 * ==========================================================
 *             CONTOH: MEMBALIK STRING
 * ==========================================================
 *
 * Block lambda dapat digunakan untuk melakukan proses yang
 * membutuhkan beberapa langkah.
 *
 * Contoh tujuan:
 *
 * Membalik karakter sebuah String.
 *
 * Input:
 *
 *     "Lambda"
 *
 * Output:
 *
 *     "adbmaL"
 *
 * Logic seperti ini membutuhkan:
 *
 * - Variable penampung hasil.
 * - Loop untuk membaca karakter.
 * - Return hasil akhir.
 *
 * Sehingga lebih cocok menggunakan block lambda dibanding
 * expression lambda.
 *
 * ==========================================================
 *                       KESIMPULAN
 * ==========================================================
 *
 * Block lambda adalah bentuk lambda expression yang digunakan
 * untuk menulis logic lebih kompleks menggunakan blok kode {}.
 *
 * Inti konsep:
 *
 * - Expression lambda = logic pendek dengan return otomatis.
 *
 * - Block lambda = mini method dengan banyak statement dan
 *   return eksplisit.
 *
 * Block lambda memberikan fleksibilitas lambda expression agar
 * dapat menangani proses yang lebih kompleks tanpa harus selalu
 * membuat method terpisah.
 *
 * ==========================================================
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
