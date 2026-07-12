package FundamentalJava.Lambda;

/* ==========================================================
 *              VARIABLE ACCESS DALAM LAMBDA EXPRESSION
 * ==========================================================
 *
 * Lambda Expression dapat mengakses variable yang berada di
 * luar dirinya (enclosing scope).
 *
 * Konsep ini disebut:
 *
 *     Variable Capture
 *
 * Artinya:
 *
 * Lambda dapat "membawa" data dari scope luar dan menggunakannya
 * ketika lambda dijalankan.
 *
 *
 * Lambda dapat mengakses beberapa jenis variable:
 *
 * - Local variable.
 * - Instance variable.
 * - Static variable.
 *
 * Namun setiap jenis variable memiliki aturan yang berbeda.
 *
 * ==========================================================
 *              LOCAL VARIABLE DALAM LAMBDA
 * ==========================================================
 *
 * Contoh:
 *
 *     public void test() {
 *
 *         int num = 10;
 *
 *         MyNumber value = () -> num;
 *
 *     }
 *
 *
 * Lambda dapat membaca variable num karena num berada di
 * enclosing scope.
 *
 * Tetapi ada aturan penting:
 *
 * Local variable yang digunakan oleh lambda harus:
 *
 *     effectively final
 *
 * ==========================================================
 *              APA ITU EFFECTIVELY FINAL?
 * ==========================================================
 *
 * Effectively final adalah variable yang nilainya tidak pernah
 * berubah setelah diberikan nilai awal.
 *
 * Contoh:
 *
 *     int num = 10;
 *
 *
 * Variable num dianggap:
 *
 *     effectively final
 *
 *
 * Karena setelah dibuat:
 *
 *     num = 10;
 *
 * Tidak ada perubahan nilai lagi.
 *
 *
 * Maka valid digunakan dalam lambda:
 *
 *     MyNumber value = () -> num;
 *
 *
 * ----------------------------------------------------------
 *
 * Contoh tidak valid:
 *
 *     int num = 10;
 *
 *     num = 20;
 *
 *     MyNumber value = () -> num;
 *
 *
 * Error karena:
 *
 * num sudah tidak effectively final.
 *
 * Java tidak mengizinkan lambda menangkap local variable yang
 * nilainya berubah.
 *
 * ==========================================================
 *              KENAPA LOCAL VARIABLE HARUS FINAL?
 * ==========================================================
 *
 * Lambda dapat hidup lebih lama daripada method tempat variable
 * tersebut dibuat.
 *
 * Contoh kasus:
 *
 * - Lambda dikirim ke thread.
 * - Lambda disimpan untuk digunakan nanti.
 * - Lambda dipakai dalam Stream API.
 *
 *
 * Jika local variable boleh berubah bebas, maka akan muncul
 * masalah konsistensi data.
 *
 *
 * Dengan aturan effectively final:
 *
 * Lambda selalu bekerja dengan nilai yang stabil.
 *
 * ==========================================================
 *              PERBEDAAN LOCAL, INSTANCE, STATIC VARIABLE
 * ==========================================================
 *
 * Ini adalah bagian yang sangat penting.
 *
 * ----------------------------------------------------------
 *
 * 1. Local Variable
 *
 * Contoh:
 *
 *     void test() {
 *
 *         int num = 10;
 *
 *         lambda -> num;
 *
 *     }
 *
 *
 * Aturan:
 *
 * HARUS effectively final.
 *
 * Tidak boleh:
 *
 *     num = 20;
 *
 *
 * ----------------------------------------------------------
 *
 * 2. Instance Variable
 *
 * Contoh:
 *
 *     class Test {
 *
 *         int num = 10;
 *
 *         void method() {
 *
 *             MyNumber value = () -> num;
 *
 *         }
 *     }
 *
 *
 * Instance variable BOLEH diubah.
 *
 * Contoh:
 *
 *     num = 20;
 *
 *
 * Mengapa?
 *
 * Karena instance variable berada di dalam object, bukan di
 * stack local method.
 *
 * Lambda mengaksesnya melalui reference object.
 *
 * ----------------------------------------------------------
 *
 * 3. Static Variable
 *
 * Contoh:
 *
 *     class Test {
 *
 *         static int num = 10;
 *
 *     }
 *
 *
 * Static variable juga BOLEH diubah.
 *
 * Contoh:
 *
 *     Test.num = 20;
 *
 *
 * Karena static variable dimiliki oleh class, bukan local scope.
 *
 * ==========================================================
 *                       TENTANG KEYWORD THIS
 * ==========================================================
 *
 * Salah satu perbedaan penting antara Lambda dan Anonymous Class
 * adalah penggunaan keyword this.
 *
 *
 * Di dalam Lambda:
 *
 *     this
 *
 * mengacu kepada:
 *
 * object dari class luar (enclosing class).
 *
 *
 * Lambda TIDAK membuat object baru untuk this.
 *
 *
 * Berbeda dengan Anonymous Class:
 *
 * Anonymous class memiliki:
 *
 *     this
 *
 * sendiri yang mengacu kepada object anonymous class tersebut.
 *
 *
 * Contoh konsep:
 *
 * Lambda:
 *
 *     this -> object class luar
 *
 *
 * Anonymous class:
 *
 *     this -> object anonymous class
 *
 * ==========================================================
 *                    LAMBDA SEBAGAI CLOSURE
 * ==========================================================
 *
 * Kemampuan lambda membawa code dan data dari luar disebut:
 *
 *     Closure
 *
 *
 * Lambda tidak hanya menyimpan instruksi:
 *
 *     "apa yang harus dilakukan"
 *
 *
 * Tetapi juga dapat membawa:
 *
 *     "data yang dibutuhkan"
 *
 *
 * Contoh:
 *
 *     int multiplier = 10;
 *
 *     x -> x * multiplier;
 *
 *
 * Lambda membawa nilai multiplier dari scope luar.
 *
 * ==========================================================
 *                    INSIGHT PENTING
 * ==========================================================
 *
 * 1. Lambda bukan scope baru seperti method biasa.
 *
 * Lambda menggunakan scope dari luar.
 *
 *
 * Artinya:
 *
 * Lambda "menumpang" pada enclosing scope.
 *
 *
 * ----------------------------------------------------------
 *
 * 2. Restriction effectively final dibuat untuk keamanan.
 *
 * Terutama pada:
 *
 * - Multithreading.
 * - Stream processing.
 * - Parallel processing.
 *
 *
 * ----------------------------------------------------------
 *
 * 3. Variable capture sering digunakan pada:
 *
 * - Stream API.
 * - filter().
 * - map().
 * - forEach().
 *
 *
 * Contoh:
 *
 *     int limit = 100;
 *
 *     list.stream()
 *         .filter(x -> x > limit);
 *
 *
 * Lambda menggunakan variable limit dari luar.
 *
 * ==========================================================
 *                       KESIMPULAN
 * ==========================================================
 *
 * Lambda Expression dapat mengakses variable dari luar dirinya,
 * tetapi aturan tergantung jenis variable.
 *
 *
 * Ringkasan:
 *
 * 1. Lambda dapat mengakses enclosing scope.
 *
 * 2. Local variable harus effectively final.
 *
 * 3. Local variable tidak boleh berubah setelah digunakan lambda.
 *
 * 4. Instance variable dan static variable boleh berubah.
 *
 * 5. Lambda memiliki konsep variable capture atau closure.
 *
 *
 * Mental model:
 *
 * Lambda =
 * Code + Data dari enclosing scope
 *
 *
 * Tetapi:
 *
 * Local variable
 * -> harus stabil (effectively final)
 *
 * Instance / Static variable
 * -> dapat berubah karena berada di object/class scope.
 *
 * ==========================================================
 */

// functional interface
interface Nomor {
    // methode menerima int
    int nomor(int n);
}
public class VariableCaptureClosure {
    public static void main(String[] args) {

        int num = 10;
        int num2 = 20;
        num2 = 50;

        Nomor myLambda = (n) -> {
            // ini boleh
            int v = num + n;

            // ini tidak boleh
            // Ini TIDAK BOLEH (modifikasi variable luar)
            // num = 20;

            // ini tidak boleh
            // Ini TIDAK BOLEH (modifikasi variable luar)
            // num++;

            // ini tidak boleh
            // Ini TIDAK BOLEH (modifikasi variable luar)
            // v = num + num2;

            return v;
        };

        // ini juga tidak boleh, meski diluar block lambda
        // karena mengubah num setelah dipakai lambda
        // num = 100;

        /**
         * 1. Variable capture itu apa?
         * int num = 10;
         *
         * (n) -> num + n
         * Lambda “mengambil” num dari luar
         *
         * ini disebut:
         * Variable Capture
         *
         * 2. Kenapa harus effectively final?
         * Karena:
         * Java mau jaga konsistensi data
         * biar gak terjadi bug aneh saat runtime
         *
         * Analogi:
         * Bayangin:
         * lambda “foto” variable saat dibuat
         *
         * kalau variable berubah:
         * “foto” jadi gak valid
         *
         * 3. Ini yang BOLEH
         * int num = 10;
         *
         * (n) -> num + n;
         * cuma baca → aman
         *
         * 4. Ini yang TIDAK BOLEH
         * int num = 10;
         *
         * (n) -> {
         *     num++; // ERROR
         *     return num + n;
         * };
         *
         * 5. Ini juga ERROR
         * int num = 10;
         *
         * MyFunc f = (n) -> num + n;
         *
         * num = 20; // ERROR
         *
         * walaupun di luar lambda
         * tetap bikin num gak final
         */
    }
}
