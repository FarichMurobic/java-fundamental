package FundamentalJava.JumpStatements;

/* ==========================================================
 *                          RETURN
 * ==========================================================
 *
 * return adalah salah satu jump statement di Java yang digunakan
 * untuk keluar dari sebuah method secara langsung.
 *
 * Ketika statement return dijalankan:
 *
 * - Eksekusi method langsung berhenti.
 * - Program kembali ke bagian kode yang memanggil method tersebut.
 * - Nilai dapat dikembalikan kepada pemanggil method jika method
 *   memiliki return type selain void.
 *
 * Karena return menyebabkan perpindahan alur eksekusi program,
 * maka return termasuk dalam kategori jump statement.
 *
 * ==========================================================
 *                  CARA KERJA RETURN
 * ==========================================================
 *
 * Secara normal, sebuah method akan selesai ketika seluruh
 * statement di dalam method telah dieksekusi.
 *
 * Namun dengan return, method dapat dihentikan lebih awal.
 *
 * Contoh:
 *
 *     public void process() {
 *
 *         System.out.println("Mulai");
 *
 *         return;
 *
 *         System.out.println("Selesai");
 *     }
 *
 * Statement setelah return tidak akan pernah dijalankan karena
 * method sudah berhenti terlebih dahulu.
 *
 * ==========================================================
 *                  JENIS-JENIS RETURN
 * ==========================================================
 *
 * Dalam Java terdapat dua bentuk penggunaan return:
 *
 * 1. Return tanpa nilai
 *
 * Digunakan pada method dengan tipe void.
 *
 * Contoh:
 *
 *     public void stopProcess() {
 *
 *         return;
 *     }
 *
 * Fungsinya hanya untuk menghentikan method.
 *
 *
 * 2. Return dengan nilai
 *
 * Digunakan pada method yang memiliki return type tertentu.
 *
 * Contoh:
 *
 *     public int calculate() {
 *
 *         return 100;
 *     }
 *
 * Nilai tersebut dikirim kembali kepada pemanggil method.
 *
 * ==========================================================
 *           RETURN PADA METHOD void
 * ==========================================================
 *
 * Kesalahan yang sering terjadi adalah menganggap return selalu
 * harus mengembalikan nilai.
 *
 * Faktanya:
 *
 * Method dengan tipe void tetap dapat menggunakan return.
 *
 * Pada method void:
 *
 *     return;
 *
 * hanya berfungsi untuk menghentikan eksekusi method.
 *
 * Contoh:
 *
 *     public static void printMessage(String message) {
 *
 *         if (message == null) {
 *             return;
 *         }
 *
 *         System.out.println(message);
 *     }
 *
 * Jika message bernilai null, method langsung berhenti dan kode
 * setelahnya tidak dijalankan.
 *
 * ==========================================================
 *              RETURN TIDAK HARUS DI AKHIR METHOD
 * ==========================================================
 *
 * return tidak harus selalu berada di baris terakhir method.
 *
 * Return dapat digunakan di mana saja selama masih berada dalam
 * method tersebut.
 *
 * Pola ini sering digunakan dalam pengembangan aplikasi modern
 * untuk membuat kode lebih sederhana dan mudah dibaca.
 *
 * Contoh:
 *
 *     if (error) {
 *         return;
 *     }
 *
 * Pendekatan ini sering disebut sebagai early return.
 *
 * ==========================================================
 *                    EARLY RETURN
 * ==========================================================
 *
 * Early return adalah teknik menghentikan method lebih awal
 * ketika kondisi tertentu sudah terpenuhi.
 *
 * Keuntungan:
 *
 * - Mengurangi nested if yang terlalu dalam.
 * - Membuat alur kode lebih mudah dibaca.
 * - Memisahkan kondisi gagal sebelum menjalankan proses utama.
 *
 * Teknik ini banyak digunakan pada kode profesional.
 *
 * ==========================================================
 *              CONTOH PENGGUNAAN NYATA
 * ==========================================================
 *
 * Contoh validasi input:
 *
 *     public static void login(String password) {
 *
 *         if (password == null) {
 *             System.out.println("Password kosong");
 *             return;
 *         }
 *
 *         System.out.println("Login diproses...");
 *     }
 *
 * Alur program:
 *
 * password == null
 *        |
 *        v
 * tampilkan pesan error
 *        |
 *        v
 * return
 *        |
 *        v
 * method selesai
 *
 * Jika password tidak kosong, program akan melanjutkan proses
 * login.
 *
 * ==========================================================
 *              PERBEDAAN break, continue, return
 * ==========================================================
 *
 * Ketiga statement ini sama-sama mengubah alur program, tetapi
 * memiliki tujuan yang berbeda.
 *
 * break:
 *
 * - Keluar dari loop atau switch.
 * - Eksekusi dilanjutkan setelah statement tersebut.
 *
 *
 * continue:
 *
 * - Melewati sisa kode pada iterasi saat ini.
 * - Melanjutkan ke iterasi loop berikutnya.
 *
 *
 * return:
 *
 * - Keluar dari method.
 * - Kembali ke pemanggil method.
 *
 * ==========================================================
 *                       MENTAL MODEL
 * ==========================================================
 *
 * Bayangkan:
 *
 * break:
 * "Keluar dari perulangan."
 *
 * continue:
 * "Lewati yang sekarang, lanjutkan yang berikutnya."
 *
 * return:
 * "Selesai dari fungsi ini, kembali ke pemanggil."
 *
 * ==========================================================
 *                  PENGGUNAAN RETURN
 * ==========================================================
 *
 * return sering digunakan untuk:
 *
 * - Menghentikan method lebih cepat.
 * - Validasi kondisi awal.
 * - Mengembalikan hasil perhitungan.
 * - Menghindari proses yang tidak diperlukan.
 * - Membuat kode lebih bersih dengan early return.
 *
 * ==========================================================
 *                       KESIMPULAN
 * ==========================================================
 *
 * return adalah jump statement yang digunakan untuk keluar dari
 * sebuah method.
 *
 * Fungsi utama return:
 *
 * - Menghentikan eksekusi method.
 * - Mengembalikan nilai kepada pemanggil method.
 * - Mengontrol alur program melalui early return.
 *
 * Pemahaman terhadap return sangat penting karena hampir semua
 * aplikasi Java menggunakan method sebagai unit utama untuk
 * membangun logika program.
 *
 * ==========================================================
 */

public class Return {
    public static void main(String[] args) {
        
        // Contoh program sederhana
        boolean t = true;
        System.out.println("Before the return.");

        if(t)
            return; // kembali ke pemanggil method

        System.out.println("This won't execute.");

        /**
         * Output:
         * Before the return.
         *
         * Cara Kerja Program Contoh
         * Kode:
         * System.out.println("Before the return.");
         * if(t) return;
         * System.out.println("This won't execute.");
         *
         * Langkah program
         * Step 1
         * print Before the return.
         *
         * Output:
         * Before the return.
         *
         * Step 2
         * if(t)
         * Karena:
         * t = true
         * maka:
         * return
         *
         * Step 3
         * Method langsung berhenti.
         * Baris ini:
         * System.out.println("This won't execute.");
         * tidak dijalankan.
         */

    }
}
