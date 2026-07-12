package FundamentalJava.Methods;

/*
 * ============================================================
 * Pemanggilan Method Dalam Class Yang Sama
 * ============================================================
 *
 * Pada Java, sebuah method dapat memanggil method lain yang
 * berada dalam class yang sama selama:
 *
 * - Method tersebut memiliki akses yang diperbolehkan.
 * - Tidak melanggar aturan static dan non-static context.
 *
 * Contoh:
 *
 * class Person {
 *
 *     void sapa() {
 *         System.out.println("Hello");
 *     }
 *
 *     void mulai() {
 *         sapa();
 *     }
 * }
 *
 * Pada contoh di atas:
 *
 * Method mulai() dapat langsung memanggil method sapa()
 * karena keduanya berada dalam class Person yang sama.
 *
 * ------------------------------------------------------------
 * Kenapa Method Bisa Dipanggil Langsung?
 * ------------------------------------------------------------
 *
 * Karena method tersebut merupakan bagian dari object yang sama.
 *
 * Ketika instance method dipanggil tanpa menuliskan object atau
 * this, Java secara otomatis memahami bahwa method tersebut
 * berasal dari object yang sedang aktif.
 *
 * Contoh:
 *
 * sapa();
 *
 * Sebenarnya sama dengan:
 *
 * this.sapa();
 *
 * Keyword this mengacu kepada object saat ini (current object).
 *
 * Pada instance method, penggunaan this dapat ditulis secara
 * eksplisit, tetapi biasanya tidak wajib jika tidak ada konflik
 * nama.
 *
 * ------------------------------------------------------------
 * Contoh Dengan this
 * ------------------------------------------------------------
 *
 * class Calculator {
 *
 *     void hitung() {
 *         this.tambah();
 *     }
 *
 *     void tambah() {
 *         System.out.println("Menambahkan nilai");
 *     }
 * }
 *
 * Pemanggilan:
 *
 * this.tambah();
 *
 * memiliki arti:
 *
 * "Panggil method tambah() milik object yang sedang digunakan."
 *
 * ------------------------------------------------------------
 * Access Modifier Pada Pemanggilan Method
 * ------------------------------------------------------------
 *
 * Method dapat saling memanggil selama aturan akses terpenuhi.
 *
 * Contoh access modifier:
 *
 * public
 * - Dapat diakses dari class mana saja.
 *
 * protected
 * - Dapat diakses dalam package yang sama dan subclass.
 *
 * default (tanpa modifier)
 * - Hanya dapat diakses dalam package yang sama.
 *
 * private
 * - Hanya dapat diakses di dalam class itu sendiri.
 *
 * Contoh:
 *
 * class User {
 *
 *     private void validasi() {
 *         System.out.println("Validasi data");
 *     }
 *
 *     void simpan() {
 *         validasi();
 *     }
 * }
 *
 * Method private tetap dapat dipanggil oleh method lain selama
 * masih berada dalam class yang sama.
 *
 * ------------------------------------------------------------
 * Hubungan Antar Method
 * ------------------------------------------------------------
 *
 * Method dapat:
 *
 * - Memanggil method lain.
 * - Mengirim nilai melalui parameter.
 * - Menerima nilai return dari method lain.
 * - Menggunakan hasil proses method lain.
 *
 * Contoh:
 *
 * int hitungTotal() {
 *     return ambilHarga() + 100;
 * }
 *
 * int ambilHarga() {
 *     return 500;
 * }
 *
 * Alur:
 *
 * hitungTotal()
 *       |
 *       v
 * ambilHarga()
 *       |
 *       v
 * return 500
 *       |
 *       v
 * hasil akhir = 600
 *
 * ------------------------------------------------------------
 * Method Call Dan Call Stack
 * ------------------------------------------------------------
 *
 * Ketika method dipanggil, JVM menyimpan informasi eksekusi
 * method tersebut ke dalam memory yang disebut call stack.
 *
 * Setiap pemanggilan method akan membuat stack frame baru.
 *
 * Contoh:
 *
 * main()
 *   |
 *   v
 * proses()
 *   |
 *   v
 * hitung()
 *
 * JVM akan menjalankan method dari bagian paling atas stack.
 *
 * Setelah method selesai dijalankan, stack frame akan dihapus
 * dan program kembali ke method sebelumnya.
 *
 * ------------------------------------------------------------
 * Static Method vs Instance Method
 * ------------------------------------------------------------
 *
 * Salah satu hal yang perlu diperhatikan adalah perbedaan:
 *
 * Instance Method:
 *
 * - Dimiliki oleh object.
 * - Dapat menggunakan keyword this.
 * - Dapat langsung mengakses instance variable.
 *
 * Contoh:
 *
 * object.method();
 *
 *
 * Static Method:
 *
 * - Dimiliki oleh class.
 * - Tidak membutuhkan object.
 * - Tidak memiliki keyword this.
 *
 * Contoh:
 *
 * ClassName.method();
 *
 *
 * Karena perbedaan context tersebut:
 *
 * Instance method dapat memanggil static method.
 *
 * Tetapi static method tidak dapat langsung memanggil instance
 * method tanpa membuat object terlebih dahulu.
 *
 * ------------------------------------------------------------
 * Method Overloading
 * ------------------------------------------------------------
 *
 * Java mengizinkan beberapa method memiliki nama yang sama
 * selama parameter yang dimiliki berbeda.
 *
 * Konsep ini disebut method overloading.
 *
 * Contoh:
 *
 * void cetak(int angka) {
 * }
 *
 * void cetak(String teks) {
 * }
 *
 * Kedua method memiliki nama sama, tetapi parameter berbeda.
 *
 * ------------------------------------------------------------
 * Perhatian: Recursive Method
 * ------------------------------------------------------------
 *
 * Method dapat memanggil dirinya sendiri. Konsep ini disebut
 * recursion.
 *
 * Contoh:
 *
 * void hitung(int angka) {
 *
 *     if (angka == 0) {
 *         return;
 *     }
 *
 *     hitung(angka - 1);
 * }
 *
 * Recursive method harus memiliki kondisi berhenti
 * (stop condition).
 *
 * Jika tidak memiliki kondisi berhenti, method akan terus
 * memanggil dirinya sendiri dan dapat menyebabkan StackOverflowError.
 *
 * ------------------------------------------------------------
 * Kesimpulan
 * ------------------------------------------------------------
 *
 * Method dalam class yang sama dapat saling memanggil secara
 * langsung selama aturan akses dan context Java terpenuhi.
 *
 * Hal penting yang harus dipahami:
 *
 * - Pemanggilan method tanpa this sebenarnya menggunakan object
 *   saat ini secara implisit.
 * - Keyword this hanya tersedia pada instance context.
 * - Method private tetap dapat dipanggil dalam class yang sama.
 * - Static dan instance method memiliki aturan pemanggilan berbeda.
 * - JVM menggunakan call stack untuk mengatur proses pemanggilan
 *   method.
 *
 * Pemahaman konsep ini menjadi dasar untuk membuat:
 *
 * - Modular code.
 * - Clean code.
 * - Reusable logic.
 *
 */

public class MethodChaining {

    // Contoh
    // Methode pertama
    void sapa() {
        System.out.println("Halo bro!.");
    }

    // Methode kedua
    void mulai() {
        this.sapa(); // manggil methode sapa
    }

    // cara lebih real
    void hitungTotal(int harga, int jumlah) {
        int total = harga * jumlah;
        tampilkanTotal(total); // panggil methode tampilkanTotal
    }

    void tampilkanTotal(int total) {
        System.out.println("Total bayar: " + total);
    }

    /**
     * Penjelasan
     * 
     * hitungTotal() → tugasnya ngitung
     * tampilkanTotal() → tugasnya nampilin
     *
     * Ini namanya:
     * Separation of responsibility (pemisahan tugas)
     *
     * Ini yang bikin code:
     * lebih rapi
     * lebih reusable
     * lebih gampang di-debug
     */

    /**
     * Bedain Static vs Non-Static (INI PENTING BANGET)
     *
     * Salah (bakal error)
     * class Test {
     *     void a() {
     *         System.out.println("A");
     *     }
     *
     *     static void b() {
     *         a(); // ERROR
     *     }
     * }
     *
     * Kenapa error?
     *
     * b() itu static
     * a() itu non-static
     * Static gak bisa langsung akses non-static
     *
     * Static vs Non-Static (Lebih Dalam)
     * 
     * Rule penting:
     * Dari	            Bisa panggil
     * non-static	    non-static + static
     * static	        hanya static
     *
     * Contoh error
     * class Test {
     *
     *     void a() {}
     *
     *     static void b() {
     *         a(); // ERROR
     *     }
     * }
     * 
     * Kenapa?
     * Karena:
     * static = milik class
     * non-static = milik object
     *
     * static gak punya this
     */

    // cara benerin
    // cara 1, pakai objek

    void a() {
        System.out.println("A");
    }

    static void b() {
        // this.a(); ini akan error, karena a bukan static
        // Static gak bisa langsung akses non-static
        // cara akses non static, buat objek
        MethodChaining obj = new MethodChaining();
        obj.a(); // ini aman, panggil methode non static
        c(); // panggil methode static juga
    }

    // Cara 2: Jadikan sama-sama static
    static void c() {
        System.out.println("C");
    }

    // Overloading + Method Call
    // Method bisa dipanggil berdasarkan parameter:
    void tambah(int a, int b) {
        System.out.println(a + b);
    }

    void tambah(double a, double b) {
        System.out.println(a + b);
    }

    void pertambahan() {
        this.tambah(2,3); // int version
        this.tambah(2.5, 2.6); // double version
    }

    /**
     * Java pilih method berdasarkan:
     * jumlah parameter
     * tipe parameter
     */

    // Method Memanggil Method + Return Value
    int tambahDong(int a, int b) {
        return a + b;
    }

    void tampilkanDong() {
        int hasil = tambahDong(5,3);
        System.out.println("Hasil: " + hasil);
    }

    /**
     * Flow:
     * 
     * tampilkan() → manggil tambah()
     * tambah() → balikin nilai
     * dipakai lagi di tampilkan()
     */

    public static void main(String[] args) {

        MethodChaining mc = new MethodChaining();
        mc.mulai(); // panggil methode kedua

        mc.hitungTotal(5000, 20);

        /**
         * Alur program:
         * 
         * Program mulai dari main
         * Buat object: obj
         * Panggil obj.mulai()
         * Di dalam mulai() → dia manggil sapa()
         * sapa() jalan → print: Halo bro!
         */

        // panggil methode static b
        b();

        // panggil methode pertambahan
        mc.pertambahan();
        // panggil methode tampilkanDong return value
        mc.tampilkanDong();

    }
}
