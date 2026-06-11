package TransientAndVolatile;

/**
 * The transient and volatile Modifiers
 *
 * Java punya dua modifier yang cukup unik:
 * transient dan volatile
 *
 * Modifier ini dipakai untuk kondisi khusus.
 *
 * transient dan volatile
 * HANYA bisa dipakai di variabel (field / instance variable)
 *
 * Tidak bisa dipakai di:
 * class
 * method
 * constructor
 *
 * Kenapa?
 * Karena transient cuma berkaitan dengan penyimpanan object (serialization)
 * Jadi cuma masuk akal buat data (variabel)
 *
 * Kenapa?
 * Karena volatile cuma berkaitan dengan:
 * perubahan nilai variabel di multithread
 * Jadi cuma relevan buat variabel
 *
 * transient
 * Kalau sebuah instance variable dikasih transient, maka:
 * nilainya tidak akan disimpan saat object disimpan (diserialisasi)
 *
 * Contoh:
 * class T {
 *   transient int a; // tidak akan disimpan
 *   int b; // akan disimpan
 * }
 *
 * Artinya:
 * a tidak ikut disimpan
 * b ikut disimpan
 *
 * volatile
 * volatile memberi tahu compiler:
 * variabel bisa berubah secara tiba-tiba oleh bagian lain program
 *
 * Biasanya terjadi di:
 * multithreading
 *
 * Dalam program multithread:
 * Beberapa thread bisa pakai variabel yang sama
 * Setiap thread bisa punya salinan sendiri (private copy)
 *
 * Masalahnya:
 * salinan ini bisa tidak sinkron 
 *
 * Solusinya:
 * Kalau pakai volatile:
 * semua thread harus pakai versi asli (master copy)
 * Atau:
 * kalau ada salinan → harus selalu update ke versi asli
 *
 * Tambahan penting:
 * Akses ke variabel volatile harus sesuai urutan (tidak boleh kacau)
 *
 * 1. transient = "Jangan disimpan"
 *
 * Bayangin:
 * Lu punya object → mau disimpan ke file / database
 * Tapi ada data yang gak penting disimpan
 *
 * Contoh real:
 * password sementara
 * cache
 * session data
 *
 * 2. volatile = "Selalu pakai data terbaru"
 *
 * Ini penting banget di multithreading
 * Masalah Tanpa volatile
 *
 * Bayangin:
 * Thread A ubah nilai jadi 10
 * Thread B masih baca nilai lama (misal 5)
 *
 * Jadi kacau 
 *
 * Analogi Biar Kebayang
 * transient
 * Kayak catatan di papan tulis
 * ditulis → ada
 * dihapus / disimpan → hilang
 *
 * volatile
 * Kayak papan skor live
 * semua orang lihat data yang sama dan terbaru
 * gak boleh ada versi lama
 *
 * Kesimpulan Santai
 * transient
 * Dipakai buat serialization
 * Data tidak ikut disimpan
 * Cocok untuk:
 * password
 * cache
 * data sementara
 *
 * volatile
 * Dipakai di multithreading
 * Biar semua thread lihat data terbaru
 * Hindari bug aneh karena data gak sinkron
 *
 * Insight Penting (Level Naik)
 * volatile ≠ synchronized
 * volatile → cuma jaga visibility
 * synchronized → jaga safety + locking
 *
 * Bedah Perbedaannya
 * Tanpa volatile
 * Thread 1 → baca dari cache
 * Thread 2 → ubah di memory utama
 *
 * gak ketemu
 * 
 * Dengan volatile
 * Thread 1 → baca dari memory utama
 * Thread 2 → nulis ke memory utama
 *
 * sinkron
 *
 * Insight Penting (INI YANG DALAM)
 * volatile menjamin:
 * Visibility (keterlihatan)
 * Semua thread lihat nilai terbaru
 * Order (urutan eksekusi)
 * Tidak diacak sama compiler / CPU
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
            } catch (Exception e) {}
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
