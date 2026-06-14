package FundamentalJava.Static;

    /**
     * Understanding static
     *
     * Ada kalanya kamu ingin membuat member class yang dapat digunakan tanpa harus membuat object 
     * dari class tersebut.
     * Biasanya, member dari class hanya bisa diakses melalui object dari class itu.
     * Namun, Java memungkinkan kita membuat member yang bisa digunakan secara langsung tanpa object.
     *
     * Untuk membuat member seperti ini, kita menggunakan keyword:
     * static
     *
     * Jika sebuah member dideklarasikan sebagai static, maka:
     * member tersebut bisa diakses sebelum object dibuat
     * dan bisa digunakan tanpa reference ke object
     *
     * Baik method maupun variable bisa dibuat static.
     * Contoh paling umum dari static member adalah method main().
     * Method main() dibuat static karena harus dipanggil sebelum ada object yang dibuat.
     *
     * Static Variable
     * Jika sebuah instance variable dibuat static, maka variabel itu pada dasarnya menjadi
     * seperti global variable untuk class tersebut.
     *
     * Ketika object dari class dibuat:
     * tidak dibuat salinan baru dari static variable
     * Sebaliknya:
     * semua object berbagi satu static variable yang sama
     *
     * Pembatasan Method Static
     * Method yang dideklarasikan sebagai static memiliki beberapa batasan:
     * -Method static hanya bisa langsung memanggil method static lain
     * -Method static hanya bisa langsung mengakses data static
     * -Method static tidak bisa menggunakan this atau super
     *
     * Static Block
     * Jika kamu perlu melakukan perhitungan atau proses tertentu untuk menginisialisasi static variable,
     * kamu bisa menggunakan static block.
     * Static block akan dijalankan sekali saja saat class pertama kali dimuat oleh JVM.
     *
     * Static Bisa Dipanggil Tanpa Object
     * Biasanya method dipanggil seperti ini:
     * object.method();
     *
     * Tapi kalau static:
     * ClassName.method();
     *
     * Perbedaan Static vs Non Static
     * Fitur	                Static	                Non Static
     * Milik	                Class	                Object
     * Butuh object	            Tidak	                Ya
     * Jumlah di memori	        1 saja	                tiap object punya
     * Cara akses	            ClassName.member	    object.member
     *
     * Kesimpulan Penting
     * Keyword static berarti:
     * member tersebut milik class
     * bukan milik object
     *
     * Karakteristik:
     * bisa diakses tanpa object
     * hanya ada satu di memori
     * shared oleh semua object
     * dieksekusi saat class load
     */

public class Static {

    // Demonstrasi static variable, method, dan block
    // static instance variabel
    static int a = 3;
    static int b;
    int c = 10;

    // contoh error karena mengakses c yang bukan static oleh methode static
    static void tampilkan() {
    //    c = 0; ini akan error, karena c bukan static
    }

    // methode static
    static void meth(int x) {

        System.out.println("x = " + x);
        System.out.println("x = " + a);
        System.out.println("x = " + b);
    }

    // static block
    static {

        System.out.println("Static block initialized.");
        b = a * 4;
    }

    public static void main(String[] args) {

        // memanggil methode static
        meth(42); // bisa dipanggil tanpa objek di buat

        /**
         * Penjelasan Kode (Baris demi Baris)
         * static int a = 3;
         * Variable a adalah static variable.
         * Artinya:
         * milik class
         * bukan milik object
         *
         * static int b;
         * Variable static lain.
         * Belum diberi nilai.
         *
         * static void meth(int x)
         * Method static.
         * Bisa dipanggil tanpa object.
         *
         * static {
         *    System.out.println("Static block initialized.");
         *    b = a * 4;
         * }
         * 
         * Ini disebut static initialization block.
         * Block ini akan dijalankan:
         * sekali saja
         * ketika class pertama kali di-load oleh JVM
         *
         * main() juga static.
         * Karena JVM harus bisa menjalankannya tanpa membuat object terlebih dahulu.
         *
         * Alur Eksekusi Program
         * Urutan yang terjadi saat program dijalankan:
         * 1-Class di-load oleh JVM
         * Semua static dieksekusi.
         *
         * 2-Static variable diinisialisasi
         * a = 3
         *
         * 3-Static block dijalankan
         * Static block initialized.
         *
         * lalu
         * b = a * 4
         * b = 12
         *
         * 4-Method main() dipanggil
         * meth(42)
         *
         * 5-Method meth() berjalan
         * Output:
         * x = 42
         * a = 3
         * b = 12
         *
         * Output Program
         * Static block initialized.
         * x = 42
         * a = 3
         * b = 12
         */

        /**
         * Contoh Penting Supaya Benar-Benar Paham
         *
         * Misalnya kita punya class Mahasiswa.
         * class Mahasiswa {
         *
         *     String nama;
         *     static String kampus = "Universitas Indonesia";
         *
         * }
         *
         * Program:
         * Mahasiswa m1 = new Mahasiswa();
         * Mahasiswa m2 = new Mahasiswa();
         * m1.nama = "Andi";
         * m2.nama = "Budi";
         *
         * Memory:
         * m1.nama = Andi
         * m2.nama = Budi
         *
         * kampus = Universitas Indonesia
         * kampus hanya satu untuk semua object.
         */
    }
}
