package FundamentalJava.ExceptionHandling;

/*

EXCEPTION HANDLING

Bab ini membahas mekanisme penanganan exception di Java.
Exception adalah kondisi abnormal (tidak normal) yang terjadi 
dalam urutan kode saat program berjalan (runtime).
Dengan kata lain, exception adalah error yang terjadi saat program sedang dijalankan.

Dalam bahasa pemrograman yang tidak mendukung exception handling,
error harus dicek dan ditangani secara manual—biasanya menggunakan kode error, dan sebagainya.
Pendekatan ini rumit dan merepotkan.

Java menyediakan exception handling untuk menghindari masalah tersebut,
dan sekaligus membawa penanganan error ke dalam dunia object-oriented.

---------------------------------------------------------------------------------

Dasar Exception Handling
Exception di Java adalah sebuah objek yang menggambarkan kondisi error yang terjadi dalam kode.

Ketika error terjadi:
Sebuah objek exception dibuat
Lalu "dilempar" (throw) oleh method yang menyebabkan error

Method tersebut bisa:
Menangani sendiri error itu, atau
Meneruskannya ke method lain

Bagaimanapun juga, pada akhirnya exception akan "ditangkap" (caught) dan diproses.

----------------------------------------------------------------------------------

Exception bisa:
-Dibuat otomatis oleh Java (system-generated)
-Dibuat manual oleh programmer

Exception dari Java biasanya karena:
-Melanggar aturan bahasa Java
-Atau batasan environment (misalnya akses array di luar batas)

Exception buatan programmer biasanya untuk:
-Memberi tahu ada error ke pemanggil method

-------------------------------------------------------------

Keyword Penting Exception
Java punya 5 keyword utama:
try
catch
throw
throws
finally

Cara kerjanya:
try → tempat kode yang mau diawasi
catch → menangkap dan menangani error
throw → melempar exception secara manual
throws → deklarasi bahwa method bisa menghasilkan exception
finally → kode yang pasti dijalankan (apapun yang terjadi)

Bentuk Umum

try {
    // kode yang dipantau error
}
catch (ExceptionType1 exOb) {
    // handler untuk error tipe 1
}
catch (ExceptionType2 exOb) {
    // handler untuk error tipe 2
}
finally {
    // kode yang pasti dijalankan
}

*/

    /**
     * Exception Types
     *
     * Semua jenis exception adalah turunan (subclass) dari class bawaan bernama Throwable.
     * Jadi, Throwable adalah paling atas dalam hierarki exception.
     *
     * Di bawah Throwable, ada dua subclass utama yang membagi exception jadi dua cabang:
     * 
     * Cabang 1: Exception
     * Class ini digunakan untuk kondisi error yang seharusnya ditangani oleh program.
     * Class ini juga bisa:
     * diwariskan (inheritance)
     * untuk membuat custom exception sendiri
     *
     * Ada subclass penting dari Exception, yaitu RuntimeException.
     * Exception jenis ini:
     * otomatis ada di program Java
     * contoh:
     * pembagian dengan nol
     * akses array di luar index
     *
     * Cabang 2: Error
     * Class ini digunakan untuk error yang tidak diharapkan untuk ditangani oleh program.
     * Biasanya digunakan oleh Java runtime untuk menunjukkan error serius pada sistem.
     * Contoh:
     * stack overflow
     * memory full
     *
     * ----------------------------------------------------------------------
     * 
     * Bab ini tidak membahas Error, karena:
     * biasanya terjadi karena kegagalan fatal
     * tidak bisa ditangani oleh program biasa
     *
     * Bayangin struktur ini kayak pohon
     *
     * Throwable (ROOT)
     * │
     * ├── Exception (bisa ditangani)
     * │   └── RuntimeException (error umum saat coding)
     * │
     * └── Error (fatal, jangan diurus program)
     *
     * Bedanya yang HARUS LU PAHAM
     * Exception → Lu HANDLE
     *
     * Ini error yang:
     * masih masuk akal
     * masih bisa lu kontrol
     *
     * Contoh:
     * file gak ketemu
     * input salah
     * database gagal
     * Ini tugas lu sebagai programmer
     *
     * Error → Jangan lu sentuh
     * Ini error:
     * dari sistem
     * bukan salah logika program biasa
     * susah / gak mungkin di-handle
     *
     * Contoh:
     * memory habis
     * stack overflow
     * Ini bukan urusan lu, ini urusan JVM
     * 
     * -------------------------------------------------------------
     *
     * RuntimeException (Ini penting banget)
     * Ini anak dari Exception, tapi spesial:
     *
     * Gak wajib ditangkap (tidak dipaksa pakai try-catch)
     * Contoh:
     * int a = 10 / 0; // ArithmeticException
     * Kenapa?
     * Karena ini biasanya:
     * kesalahan logika programmer
     * harusnya diperbaiki, bukan ditangani
     *
     * Perbedaan penting:
     * Jenis	                Handle?	                Contoh
     * Exception	            Ya	                    File not found
     * RuntimeException	        Opsional	            /0, array index
     * Error	                Tidak	                Stack overflow
     *
     * ---------------------------------------------------------------
     * 
     * Insight Tambahan (Level Up)
     * Bro ini yang bikin lu beda:
     * Jangan asal bungkus semua dengan try-catch
     *
     * Karena:
     * RuntimeException → harusnya diperbaiki logika
     * bukan ditutupin pakai catch
     *
     * Pola pikir yang benar:
     * Error karena user → HANDLE 
     * Error karena logic lu → FIX 
     * Error sistem → BIARIN 
     */

public class ExceptionHandling {

    // Methode error dibagi dengan nol.
    static void subroutine() {
        int d = 0;
        int a = 10 / d; // Program berhenti disini

        // INI gak bakal di eksekusi!
        System.out.println(a);
    }

    public static void main(String[] args) {
        
        // INI CONTOH RUNTIMEEXCEPTION (UNCHECKED EXCEPTION)
        // BUKAN ERROR COMPILE
        // TAPI ERROR SAAT PROGRAM BERJALAN
        // BIASANYA LOGIKA PROGRAM BERMASALAH
        // (KESALAHAN PROGRAMER)

        try {
            int angka = 10;
            int hasil = angka / 0; // Error runtime (dibagi dengan nol)
            System.out.println("Hasil: " + hasil);
        } catch (ArithmeticException e) {
            // Menangkap error pembagian dengan 0 
            System.out.println("Terjadi error, tidak bisa dibagi dengan nol!");
        } finally {
            // Selalu dijalankan baik error maupun tidak
            System.out.println("Program selesai dijalankan.");
        }

        /**
         * Output
         * Terjadi error: tidak bisa dibagi dengan nol!
         * Program selesai dijalankan.
         *
         * Penjelasan Kode
         * try → tempat kode rawan error
         * angka / 0 → bikin exception
         * catch → nangkap error tersebut
         * finally → tetap dijalankan
         */

        /**
         * Jika program ini dijalankan tanpa exception handling
         *  int angka = 10;
         *         int hasil = angka / 0;
         *
         *         System.out.println(hasil);
         *
         * Akan menghasilkan error:
         * Exception in thread "main" java.lang.ArithmeticException: / by zero
         * 	at ExceptionHandling.ExceptionHandling.main(ExceptionHandling.java:101)
         */

        try {
            int[] data = {1,2,3};
            System.out.println(data[5]); // Error index tidak sampe 5
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index tidak tersedia.");
        }

        // Contoh pertama
        // Mengenal lebih dekat jika program tidak ditangani
        int angka = 6;
        int hasil = angka / 0;
        System.out.println(hasil);

        /**
         * Uncaught Exceptions (Exception yang Tidak Ditangani)
         * Sebelum belajar cara menangani exception, penting untuk melihat apa yang terjadi 
         * kalau exception tidak ditangani.
         * 
         * Program berikut sengaja membuat error pembagian dengan nol:
         *
         * int angka = 6;
         * int hasil = angka / 0;
         *
         * Ketika Java mendeteksi pembagian dengan nol:
         * Java membuat object exception baru
         * Lalu melempar (throw) exception tersebut
         *
         * Akibatnya:
         * Eksekusi program langsung berhenti
         * Karena exception harus segera ditangani
         *
         * Karena kita tidak membuat handler:
         * Exception ditangani oleh default handler dari Java
         *
         * Default handler akan:
         * Menampilkan pesan error
         * Menampilkan stack trace (alur error)
         * Menghentikan program
         *
         * Output Error
         * java.lang.ArithmeticException: / by zero
         *     at Exc0.main(Exc0.java:4)
         *
         * Informasi yang ditampilkan:
         * Nama class → Exc0
         * Method → main
         * File → Exc0.java
         * Baris → 4
         */

        // Contoh kedua dengan Methode
        // Method yang memicu error
        subroutine(); // Panggil method

        /**
         * Output:
         * java.lang.ArithmeticException: / by zero
         *     at Exc1.subroutine(Exc1.java:4)
         *     at Exc1.main(Exc1.java:7)
         *
         * Stack Trace
         * Stack trace menunjukkan:
         * urutan pemanggilan method sebelum error terjadi
         *
         * Dalam contoh:
         * main() memanggil subroutine()
         * error terjadi di subroutine()
         *
         * ----------------------------------------------
         * 
         * Apa itu Uncaught Exception?
         * Exception yang tidak lu tangkap pakai try-catch
         *
         * Akibatnya:
         * Java ambil alih
         * Program langsung CRASH
         *
         * Alur yang Terjadi
         * Kalau gak ditangani:
         * error → throw → (gak ada catch) → default handler → program mati
         *
         * Default Handler (Si Penyelamat Terakhir)
         * Kalau lu gak handle:
         * Java bilang:
         * "Yaudah gue yang handle, tapi program lu gue matiin"
         *
         * Yang dia lakukan:
         * print error
         * print stack trace
         * stop program
         *
         * -----------------------------------------------------
         * 
         * Stack Trace (INI PENTING BANGET)
         * Ini kayak jejak kejadian sebelum error.
         *
         * Contoh:
         * main() → subroutine() → ERROR
         *
         * Jadi bisa tahu:
         * error terjadi di mana
         * dipanggil dari mana
         *
         * Contoh Kode
         *
         * Contoh 1 (Tanpa Handler → Crash)
         *
         * public class Exc0 {
         *
         *     public static void main(String[] args) {
         *
         *         int d = 0;
         *         int a = 42 / d; // ERROR: pembagian nol
         *         // Program langsung berhenti di sini
         *     }
         * }
         *
         * Contoh 2 (Dengan Method → Lihat Stack Trace)
         *
         * public class Exc1 {
         *     static void subroutine() {
         *         int d = 0;
         *         int a = 10 / d; // ERROR terjadi di sini
         *     }
         *     public static void main(String[] args) {
         *         subroutine(); // method ini memicu error
         *     }
         * }
         *
         * Penjelasan Stack Trace
         * Exc1.main() → manggil subroutine()
         * subroutine() → error di line 4
         *
         * Jadi Java kasih tahu:
         * error asalnya dari mana
         * jalur lengkapnya
         *
         * Stack Trace = Alat Debugging
         * nunjukin urutan method
         * bantu cari bug dengan cepat
         *
         * Programmer jago itu:
         * gak panik lihat error
         * langsung baca:
         * jenis error
         * line number
         * alur method
         *
         * Cara bener:
         * Lihat error type → ArithmeticException
         * Lihat baris → line 4
         * Lihat alur → siapa manggil siapa
         */
    }
}
