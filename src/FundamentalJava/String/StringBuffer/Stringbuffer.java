package FundamentalJava.String.StringBuffer;

/**
 * StringBuffer
 *
 * StringBuffer mendukung string yang bisa dimodifikasi. Seperti yang sudah kamu tahu,
 * String merepresentasikan urutan karakter dengan panjang tetap dan tidak bisa diubah (immutable).
 * Sebaliknya, StringBuffer merepresentasikan urutan karakter yang bisa bertambah dan bisa ditulis ulang (growable dan writable).
 *
 * StringBuffer memungkinkan karakter dan substring disisipkan di tengah atau ditambahkan di akhir.
 * StringBuffer akan secara otomatis bertambah ukurannya untuk memberi ruang pada penambahan tersebut
 * dan sering kali sudah mengalokasikan kapasitas lebih besar dari yang dibutuhkan, agar ada ruang untuk pertumbuhan.
 *
 * 1. Perbedaan dasar: String vs StringBuffer
 * Konsep	        String	                                StringBuffer
 * Sifat	        Immutable (tidak bisa diubah)	        Mutable (bisa diubah)
 * Perubahan	    Buat objek baru	                        Ubah objek yang sama
 * Performa	        Lebih lambat kalau sering diubah	    Lebih cepat untuk modifikasi
 *
 * 2. Kenapa String itu masalah kalau sering diubah?
 * Misalnya:
 * String s = "Hello";
 * s = s + " World";
 *
 * Yang terjadi di balik layar:
 * "Hello" tetap ada
 * Dibuat object baru "Hello World"
 *
 * Jadi kalau lo ubah berkali-kali:
 * Memory boros
 * Performance turun
 *
 * 3. Nah di sinilah StringBuffer masuk
 * StringBuffer itu kayak:
 * kotak yang bisa dibuka-tutup dan diisi ulang
 * Lo gak bikin object baru tiap ubah — lo edit langsung isi dalamnya.
 *
 * 4. “Growable” itu maksudnya apa?
 *
 * Artinya:
 * Ukuran bisa nambah otomatis
 * Gak perlu lo atur manual
 *
 * Misalnya:
 * StringBuffer sb = new StringBuffer("Hello");
 * sb.append(" World");
 *
 * Dia otomatis:
 * Nambah kapasitas kalau kurang
 * Gak error walaupun panjang nambah
 *
 * 5. “Writable” itu maksudnya?
 * Lo bisa:
 * Tambah (append)
 * Sisipkan (insert)
 * Hapus (delete)
 * Ganti isi (replace)
 *
 * 6. “Preallocated capacity” (ini penting banget)
 * StringBuffer biasanya:
 * Nyediain ruang lebih dari isi sekarang
 *
 * Contoh:
 * StringBuffer sb = new StringBuffer();
 * Default capacity = 16 karakter
 *
 * Kenapa?
 * Biar:
 * Gak perlu resize terus-terusan
 * Lebih cepat saat append banyak data
 *
 * Kesimpulan (versi simpel & nempel)
 * String = tidak bisa diubah (immutable)
 * StringBuffer = bisa diubah (mutable)
 * StringBuffer cocok untuk:
 * Banyak modifikasi string
 * Operasi seperti append, insert, delete
 *
 * Intinya:
 * Kalau lo sering ubah string → pakai StringBuffer, bukan String
 */

public class Stringbuffer {
    public static void main(String[] args) {

        // Membuat StringBuffer dengan isi awal
        StringBuffer stringBuffer = new StringBuffer("Hello");

        // Menampilkan isi awal
        System.out.println("Awal " + stringBuffer); // Awal Hello

        // Menambahkan string ke akhir (append)
        stringBuffer.append(" World");
        System.out.println("Setelah append: " + stringBuffer); // Setelah append: Hello World

        // Menyisipkan string di tengah
        stringBuffer.insert(5, "java");
        System.out.println("Setelah insert: " + stringBuffer); // Setelah insert: Hellojava World

        // Mengganti sebagian string
        stringBuffer.replace(0, 5, "Hi");
        System.out.println("Setelah replace: " + stringBuffer); // Setelah replace: Hijava World

        // Menghapus sebagian string
        stringBuffer.delete(2, 7);
        System.out.println("Setelah delete: " + stringBuffer); // Setelah delete: HiWorld

        // Menampilkan panjang string
        System.out.println("Length: " + stringBuffer.length()); // Length: 7
        // Menampilkan kapasitas (ruang yang tersedia)
        System.out.println("Capacity: " + stringBuffer.capacity()); // Capacity: 21

        /**
         * Alur yang Terjadi di Kode
         *
         * "Hello" masuk ke StringBuffer
         * append → nambah tanpa bikin object baru
         * insert → nyelip di tengah
         * replace → ganti sebagian isi
         * delete → hapus sebagian
         * Semua perubahan terjadi di objek yang sama
         *
         */
    }
}
