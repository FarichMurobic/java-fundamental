package FundamentalJava.Methods;

/*
 * ============================================================
 * Void Method (Method Tanpa Return Value)
 * ============================================================
 *
 * Method adalah sekumpulan instruksi atau blok kode yang dibuat
 * untuk menjalankan tugas tertentu..
 *
 * Sebuah method dapat:
 *
 * - Melakukan suatu proses.
 * - Menerima data melalui parameter.
 * - Mengembalikan nilai menggunakan return type.
 *
 * Salah satu jenis method pada Java adalah method dengan return
 * type void.
 *
 * ------------------------------------------------------------
 * Pengertian void
 * ------------------------------------------------------------
 *
 * void adalah keyword pada Java yang menunjukkan bahwa sebuah
 * method tidak mengembalikan nilai kepada pemanggilnya.
 *
 * Artinya:
 *
 * Method tersebut hanya menjalankan suatu aksi atau proses.
 *
 * Contoh:
 *
 * void sayHello() {
 *     System.out.println("Hello");
 * }
 *
 * Ketika dipanggil:
 *
 * sayHello();
 *
 * Output:
 *
 * Hello
 *
 * Method sayHello() menjalankan perintah mencetak teks, tetapi
 * tidak mengirimkan nilai kembali ke kode yang memanggilnya.
 *
 * ------------------------------------------------------------
 * Perbedaan void dan Return Value
 * ------------------------------------------------------------
 *
 * Method void:
 *
 * - Digunakan untuk melakukan suatu aksi.
 * - Tidak memiliki nilai yang dikembalikan.
 * - Tidak dapat disimpan ke dalam variable.
 *
 * Contoh:
 *
 * void tampilkanPesan() {
 *     System.out.println("Belajar Java");
 * }
 *
 *
 * Sedangkan method dengan return value:
 *
 * int tambah(int a, int b) {
 *     return a + b;
 * }
 *
 * Menghasilkan nilai yang dapat digunakan kembali.
 *
 * Contoh:
 *
 * int hasil = tambah(5, 3);
 *
 * ------------------------------------------------------------
 * Void Method Dengan Parameter
 * ------------------------------------------------------------
 *
 * Method void tetap dapat menerima parameter.
 *
 * Parameter digunakan untuk memberikan data yang dibutuhkan oleh
 * method saat dijalankan.
 *
 * Contoh:
 *
 * void sapa(String nama) {
 *     System.out.println("Hello " + nama);
 * }
 *
 * Pemanggilan:
 *
 * sapa("Java");
 *
 * Output:
 *
 * Hello Java
 *
 * Pada contoh tersebut:
 *
 * - String nama adalah parameter.
 * - Nilai "Java" adalah argument yang dikirim ketika method
 *   dipanggil.
 *
 * ------------------------------------------------------------
 * Menggunakan return Pada Method void
 * ------------------------------------------------------------
 *
 * Method void tidak boleh mengembalikan nilai.
 *
 * Contoh salah:
 *
 * void hitung() {
 *     return 10;
 * }
 *
 * Error karena method void tidak memiliki return value.
 *
 * ------------------------------------------------------------
 *
 * Namun, method void tetap dapat menggunakan keyword return
 * tanpa nilai.
 *
 * Fungsinya hanya untuk menghentikan eksekusi method lebih awal.
 *
 * Contoh:
 *
 * void cekUmur(int umur) {
 *
 *     if (umur < 0) {
 *         return;
 *     }
 *
 *     System.out.println("Umur valid");
 * }
 *
 * Jika kondisi umur < 0 terpenuhi:
 *
 * - return dijalankan.
 * - Method langsung berhenti.
 * - Baris setelah return tidak dieksekusi.
 *
 * ------------------------------------------------------------
 * Alur Sederhana Method void
 * ------------------------------------------------------------
 *
 * Pemanggilan:
 *
 * sayHello();
 *
 * Flow:
 *
 * sayHello()
 *      |
 *      v
 * menjalankan instruksi
 *      |
 *      v
 * selesai
 *
 * Tidak ada nilai yang dikirim kembali.
 *
 * ------------------------------------------------------------
 * Kesimpulan
 * ------------------------------------------------------------
 *
 * Method void digunakan ketika sebuah method hanya perlu
 * menjalankan sebuah proses tanpa menghasilkan nilai kembali.
 *
 * Karakteristik method void:
 *
 * - Menjalankan suatu aksi.
 * - Tidak mengembalikan nilai.
 * - Dapat memiliki parameter.
 * - Dapat menggunakan return tanpa nilai untuk keluar lebih awal.
 *
 * Rule sederhana:
 *
 * void
 * -> melakukan sesuatu.
 *
 * return type
 * -> menghasilkan sesuatu.
 *
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

    /*
     * ============================================================
     * Perbedaan Method void vs Method Return Value
     * ============================================================
     *
     * Dalam Java, method dapat dibedakan berdasarkan apakah method
     * tersebut mengembalikan nilai atau tidak.
     *
     * Terdapat dua jenis utama:
     *
     * - Method void
     * - Method dengan return value
     *
     * Perbedaan utama:
     *
     * void
     * -> menjalankan suatu aksi tanpa mengirimkan nilai kembali.
     *
     * return value
     * -> menjalankan proses dan mengirimkan hasil kembali kepada
     * pemanggil method.
     *
     * ------------------------------------------------------------
     * Method void
     * ------------------------------------------------------------
     *
     * Method void adalah method yang tidak mengembalikan nilai.
     *
     * Contoh:
     *
     * void sayHello() {
     * System.out.println("Hello");
     * }
     *
     * Pemanggilan:
     *
     * sayHello();
     *
     * Output:
     *
     * Hello
     *
     * Method tersebut menjalankan aksi mencetak teks, tetapi tidak
     * menghasilkan nilai yang dapat digunakan kembali.
     *
     * Contoh salah:
     *
     * int hasil = sayHello();
     *
     * Error:
     *
     * Karena method sayHello() memiliki return type void, sehingga
     * tidak ada nilai yang dapat dimasukkan ke variable hasil.
     *
     * ------------------------------------------------------------
     * Method Return Value
     * ------------------------------------------------------------
     *
     * Method return value adalah method yang menghasilkan nilai dan
     * mengirimkannya kembali menggunakan keyword return.
     *
     * Contoh:
     *
     * int tambah(int a, int b) {
     * return a + b;
     * }
     *
     * Pemanggilan:
     *
     * int hasil = tambah(5, 3);
     *
     * Proses:
     *
     * tambah(5, 3)
     * |
     * v
     * perhitungan 5 + 3
     * |
     * v
     * return 8
     * |
     * v
     * variable hasil menerima nilai 8
     *
     * Hasil:
     *
     * hasil = 8
     *
     * ------------------------------------------------------------
     * Perbedaan Dalam Penggunaan
     * ------------------------------------------------------------
     *
     * Method void:
     *
     * void tampilkanData() {
     * System.out.println("Data");
     * }
     *
     * Digunakan ketika program hanya membutuhkan aksi.
     *
     *
     * Method return value:
     *
     * String ambilNama() {
     * return "Java";
     * }
     *
     * Digunakan ketika program membutuhkan hasil dari proses yang
     * dilakukan oleh method.
     *
     * ------------------------------------------------------------
     * Cara Kerja Method void Pada Runtime
     * ------------------------------------------------------------
     *
     * Walaupun method void tidak mengembalikan nilai, JVM tetap
     * membuat proses pemanggilan method menggunakan call stack.
     *
     * Contoh alur eksekusi:
     *
     * Program dimulai
     * |
     * v
     * main() dijalankan
     * |
     * v
     * Object t dibuat
     * |
     * v
     * t.sayHello() dipanggil
     * |
     * v
     * Stack frame sayHello() dibuat
     * |
     * v
     * Instruksi sayHello() dijalankan
     * |
     * v
     * Mencetak "Hello"
     * |
     * v
     * Method selesai
     * |
     * v
     * Stack frame dihapus
     * |
     * v
     * Kembali ke main()
     *
     * Karena return type-nya void:
     *
     * - Tidak ada nilai yang dikirim kembali.
     * - Program hanya melanjutkan eksekusi setelah method selesai.
     *
     * ------------------------------------------------------------
     * Kapan Menggunakan Method void?
     * ------------------------------------------------------------
     *
     * Gunakan method void ketika method hanya bertugas melakukan
     * sebuah aksi dan hasil proses tidak perlu dikembalikan.
     *
     * Contoh penggunaan:
     *
     * 1. Mencetak informasi:
     *
     * void tampilkanPesan() {
     * System.out.println("Hello Java");
     * }
     *
     *
     * 2. Mengubah nilai object:
     *
     * void setNama(String nama) {
     * this.nama = nama;
     * }
     *
     *
     * 3. Menyimpan data:
     *
     * void simpanData() {
     * // proses penyimpanan
     * }
     *
     *
     * 4. Menjalankan proses tertentu:
     *
     * void prosesPembayaran() {
     * // logika pembayaran
     * }
     *
     * ------------------------------------------------------------
     * Kapan Menggunakan Return Value?
     * ------------------------------------------------------------
     *
     * Gunakan return value ketika hasil dari proses masih diperlukan
     * oleh bagian program lainnya.
     *
     * Contoh:
     *
     * double hitungTotal(double harga, int jumlah) {
     * return harga * jumlah;
     * }
     *
     * Hasilnya dapat:
     *
     * - Disimpan dalam variable.
     * - Ditampilkan.
     * - Digunakan dalam operasi lain.
     *
     * ------------------------------------------------------------
     * Ringkasan Perbandingan
     * ------------------------------------------------------------
     *
     * Method void:
     *
     * - Tidak mengembalikan nilai.
     * - Fokus melakukan aksi.
     * - Tidak dapat digunakan sebagai nilai dalam ekspresi.
     *
     *
     * Method return value:
     *
     * - Mengembalikan nilai menggunakan return.
     * - Hasil dapat digunakan kembali.
     * - Dapat menjadi bagian dari operasi lain.
     *
     *
     * Kesimpulan:
     *
     * void
     * -> "Kerjakan sesuatu."
     *
     * return value
     * -> "Kerjakan sesuatu dan berikan hasilnya."
     *
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
        // String mahasiswa = identitas(); // ini akan error, karena methode identitas()
        // tidak punya nilai dikembalikan.

        System.out.println();

        // mencetak data objek identitas baru
        System.out.println("Nama: " + identity.nama + "\nUsia: " + identity.usia + "\nNo Hp: " + identity.noHp);

    }

}
