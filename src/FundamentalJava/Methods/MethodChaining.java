package FundamentalJava.Methods;

    /**
     * Di Java, method dalam satu class bisa saling panggil langsung selama:
     * Method-nya ada di class yang sama
     * Dan aksesnya memungkinkan (misalnya public, private, dll — nanti kita bahas lagi kalau perlu)
     *
     * Intinya:
     * Method = kumpulan instruksi
     * Jadi method bisa "nyuruh" method lain buat ngerjain sesuatu
     *
     * Kenapa Bisa Dipanggil Langsung?
     * Karena:
     * Mereka ada di class yang sama
     * Jadi Java otomatis tau referensinya dari object itu
     *
     * Ini sebenernya sama dengan:
     *
     * this.sapa();
     * Tapi this. biasanya boleh di-skip
     *
     * --------------------------------------
     * 
     * Kesimpulan Penting
     * Method dalam class yang sama bisa saling panggil langsung
     * Bisa pakai this. atau langsung nama method
     * Harus hati-hati dengan:
     * static vs non-static
     * Ini dipakai buat:
     * modular code
     * clean code
     * reusable logic
     *
     * Kesimpulan DALAM
     * Method dalam class yang sama dipanggil via this
     * Java pakai call stack
     * private tetap bisa diakses dalam class
     * Static vs non-static itu soal context (class vs object)
     * Method bisa:
     * manggil method lain
     * nerima return
     * overload
     * Hati-hati recursion tanpa stop condition
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
