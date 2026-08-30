package FundamentalJava.TransientAndVolatile;

/**
 * ------------------------------------------------------------------------
 * THE transient AND volatile MODIFIERS
 * ------------------------------------------------------------------------
 * 
 * Java memiliki dua modifier yang cukup unik:
 * transient dan volatile
 * 
 * Modifier ini dipakai untuk kondisi khusus..
 * 
 * PENTING:
 * transient dan volatile
 * HANYA bisa dipakai di variabel (field / instance variable)
 * 
 * TIDAK BISA dipakai di:
 * - Class
 * - Method
 * - Constructor
 * 
 * Kenapa transient hanya di variabel?
 * Karena transient berkaitan dengan penyimpanan object (serialization).
 * Jadi hanya masuk akal untuk data (variabel).
 * 
 * Kenapa volatile hanya di variabel?
 * Karena volatile berkaitan dengan perubahan nilai variabel di multithread.
 * Jadi hanya relevan untuk variabel.
 * 
 * ------------------------------------------------------------------------
 * TRANSIENT
 * ------------------------------------------------------------------------
 * 
 * transient artinya: "Jangan disimpan"
 * 
 * Jika sebuah instance variable diberi transient, maka:
 * nilainya TIDAK akan disimpan saat object disimpan (diserialisasi).
 * 
 * Contoh:
 * 
 *     class UserData implements Serializable {
 *         transient String password;    // Tidak ikut disimpan
 *         String username;              // Ikut disimpan
 *         int age;                      // Ikut disimpan
 *     }
 * 
 * Artinya:
 * - password tidak ikut disimpan ke file/database
 * - username dan age ikut disimpan
 * 
 * KEGUNAAN TRANSIENT:
 * 
 * Bayangkan:
 * Kamu punya object → mau disimpan ke file / database
 * Tapi ada data yang TIDAK PENTING disimpan
 * 
 * Contoh real:
 * - Password sementara (tidak aman disimpan)
 * - Cache data (bisa di-rebuild)
 * - Session data (tidak perlu permanen)
 * - Data yang bisa dihitung ulang
 * 
 * ------------------------------------------------------------------------
 * VOLATILE
 * ------------------------------------------------------------------------
 * 
 * volatile artinya: "Selalu pakai data terbaru"
 * 
 * volatile memberi tahu compiler:
 * "Variabel ini bisa berubah secara tiba-tiba oleh bagian lain program"
 * 
 * Biasanya terjadi di:
 * MULTITHREADING
 * 
 * MASALAH TANPA VOLATILE:
 * 
 * Dalam program multithread:
 * - Beberapa thread bisa menggunakan variabel yang sama
 * - Setiap thread bisa memiliki salinan sendiri (private copy)
 * - Salinan ini bisa TIDAK SINKRON
 * 
 * Bayangkan:
 * Thread A ubah nilai menjadi 10
 * Thread B masih baca nilai lama (misal 5)
 * 
 * Hasilnya KACAU!
 * 
 * SOLUSI DENGAN VOLATILE:
 * 
 * Jika pakai volatile:
 * - Semua thread harus pakai versi ASLI (master copy)
 * - Atau: jika ada salinan → harus selalu update ke versi asli
 * - Akses ke variabel volatile harus sesuai urutan (tidak boleh kacau)
 * 
 * ------------------------------------------------------------------------
 * PERBANDINGAN VISUAL
 * ------------------------------------------------------------------------
 * 
 * TANPA volatile:
 * 
 *     Thread 1 → baca dari cache (mungkin nilai lama)
 *     Thread 2 → ubah di memory utama
 *     
 *     Keduanya tidak ketemu (data tidak sinkron)
 * 
 * DENGAN volatile:
 * 
 *     Thread 1 → baca dari memory utama (nilai terbaru)
 *     Thread 2 → tulis ke memory utama (update langsung)
 *     
 *     Sinkron! Semua thread lihat data terbaru
 * 
 * ------------------------------------------------------------------------
 * ANALOGI BIAR KEBAYANG
 * ------------------------------------------------------------------------
 * 
 * transient:
 * Kayak catatan di papan tulis
 * - Ditulis → ada
 * - Dihapus / disimpan → hilang
 * 
 * volatile:
 * Kayak papan skor LIVE
 * - Semua orang lihat data yang SAMA dan TERBARU
 * - Tidak boleh ada versi lama
 * 
 * ------------------------------------------------------------------------
 * INSIGHT PENTING: volatile ≠ synchronized
 * ------------------------------------------------------------------------
 * 
 * volatile                    | synchronized
 * ----------------------------|---------------------------------------------
 * Cuma jaga VISIBILITY        | Jaga VISIBILITY + LOCKING
 * (semua thread lihat update) | (hanya 1 thread akses dalam satu waktu)
 * Tidak ada locking           | Ada locking (mutual exclusion)
 * Lebih ringan                | Lebih berat (overhead)
 * 
 * volatile menjamin:
 * 1. VISIBILITY (Keterlihatan)
 *    - Semua thread melihat nilai terbaru
 * 
 * 2. ORDER (Urutan Eksekusi)
 *    - Tidak diacak oleh compiler / CPU
 *    - Operasi baca/tulis terjadi secara berurutan
 * 
 * ------------------------------------------------------------------------
 * CONTOH KODE VOLATILE
 * ------------------------------------------------------------------------
 * 
 *     class SharedData {
 *         private volatile boolean running = true;
 * 
 *         public void stop() {
 *             running = false;  // Thread lain akan langsung melihat perubahan
 *         }
 * 
 *         public void run() {
 *             while (running) {
 *                 // Lakukan sesuatu...
 *             }
 *         }
 *     }
 * 
 * Tanpa volatile, thread yang menjalankan run()
 * mungkin tidak pernah melihat perubahan running menjadi false
 * karena thread tersebut bisa menyimpan salinan running di cache-nya.
 * 
 * ------------------------------------------------------------------------
 * KESIMPULAN
 * ------------------------------------------------------------------------
 * 
 * TRANSIENT:
 * - Dipakai untuk serialization
 * - Data TIDAK ikut disimpan
 * - Cocok untuk: password sementara, cache, data sementara
 * 
 * VOLATILE:
 * - Dipakai di multithreading
 * - Semua thread lihat data TERBARU
 * - Hindari bug aneh karena data tidak sinkron
 * - BUKAN pengganti synchronized!
 * 
 * ------------------------------------------------------------------------
 */

import java.io.*;

// contoh kode transient
class User implements Serializable {
    String username;
    transient String password; // tidak disimpan

    User(String u, String p) {
        username = u;
        password = p;
    }
}

// contoh kode volatile
class ShareData {
    volatile boolean running = true;
}

public class TransientAndVolatile {
    public static void main(String[] args) throws Exception {

        User user = new User("Farich", "12345");

        // simpan object ke file
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.dat"));
        out.writeObject(user);
        out.close();

        // ambil lagi dari file
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("user.dat"));
        User result = (User) in.readObject();
        in.close();

        System.out.println("Username: " + result.username);
        System.out.println("Password: " + result.password); // null

        /**
         * Output:
         * Username: Farich
         * Password: null
         *
         * Kenapa password null?
         * Karena transient → gak ikut disimpan
         */

        System.out.println();

        ShareData data = new ShareData();

        // Thread 1
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 mulai...");
            while (data.running) {
                // loop terus
            }
            System.out.println("Thread 1 berhenti!");
        });

        // Thread 2
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }
            data.running = false;
            System.out.println("Thread 2 menghentikan Thread 1");
        });

        thread1.start();
        thread2.start();

        /**
         * Penjelasan
         * running = true → thread 1 loop terus
         * thread 2 ubah jadi false
         * karena volatile:
         * thread 1 langsung lihat perubahan
         *
         * Kalau gak pakai volatile:
         * thread 1 bisa ngeloop selamanya
         *
         * Kenapa?
         * Thread 1 baca running dari cache sendiri
         * Dia pikir nilainya masih true
         * Jadi loop selamanya
         *
         * Ini bug real di dunia multithread
         */
    }
}
