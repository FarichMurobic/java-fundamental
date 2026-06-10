package Methods;

    /**
     * Method adalah sekumpulan kode yang menjalankan tugas tertentu.
     * 
     * Arti void
     * 
     * void artinya:
     * method tersebut tidak mengembalikan nilai apa pun
     * Jadi method hanya menjalankan aksi.
     * 
     * Contoh:
     * void sayHello() {
     *     System.out.println("Hello");
     * }
     *
     * Ketika dipanggil:
     * sayHello();
     * Output:
     * Hello
     * Tapi method ini tidak menghasilkan nilai.
     *
     * Inti Penting Method Void
     * Method void:
     * menjalankan aksi
     * tidak mengembalikan nilai
     * bisa punya parameter
     * bisa memakai return untuk keluar dari method (return di sini hanya menghentikan method, bukan mengembalikan nilai.)
     *
     * Rule gampangnya:
     * void = melakukan sesuatu
     * return type = menghasilkan sesuatu
     */

public class MethodVoid {

    String nama;
    int usia;
    String noHp;

    // Contoh methode void
    void identitas() {
        nama = "Farich Murobic";
        usia = 22;
        noHp = "085795488106";
        System.out.println("Nama: " + nama + " " + "\nUsia: " + usia + "\nNo hp: " + noHp);
    }

    /**
     * Perbedaan Method void vs Method yang Mengembalikan Nilai
     * 
     * Method void
     * 
     * void sayHello() {
     *     System.out.println("Hello");
     * }
     * 
     * Pemanggilan:
     * sayHello();
     * Tidak bisa:
     * int x = sayHello(); // ERROR
     * Karena tidak ada nilai yang dikembalikan.
     *
     * Method yang Mengembalikan Nilai
     * 
     * int tambah(int a, int b) {
     *     return a + b;
     * }
     * 
     * Pemanggilan:
     * int hasil = tambah(5, 3);
     * Output:
     * hasil = 8
     *
     * ------------------------------------
     * 
     * Cara Kerja Method Void di Memory
     * Alur eksekusi:
     * Program start
     *      ↓
     * main() dijalankan
     *      ↓
     * object t dibuat
     *      ↓
     * t.sayHello() dipanggil
     *      ↓
     * method sayHello() dijalankan
     *      ↓
     * print "Hello"
     *      ↓
     * method selesai
     *      ↓
     * kembali ke main()
     *
     * Karena void, method tidak mengembalikan nilai.
     *
     * ----------------------------------------------
     * 
     * Kapan Menggunakan Method void
     *
     * Gunakan void ketika method hanya melakukan aksi.
     *
     * Contoh aksi:
     * mencetak sesuatu
     * mengubah nilai variable
     * menyimpan data
     * memproses sesuatu tanpa perlu hasil
     */

    public static void main(String[] args) {

        // membuat objek dari kelas metode void
        MethodVoid identity = new MethodVoid();

        // memanggil methode identitas
        identity.identitas();

        // memberi nilai baru pada objek
        identity.nama = "Januar Elvira";
        identity.usia = 30;
        identity.noHp = "-";

        // Bukti void tidak mengembalikan nilai
        // String mahasiswa = identitas(); // ini akan error, karena methode identitas() tidak punya nilai dikembalikan.

        System.out.println();

        // mencetak data objek identitas baru
        System.out.println("Nama: " + identity.nama + "\nUsia: " + identity.usia + "\nNo Hp: " + identity.noHp);

        
    }

}
