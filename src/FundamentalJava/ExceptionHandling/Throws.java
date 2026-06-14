package FundamentalJava.ExceptionHandling;

    /**
     * throws
     *
     * Kalau sebuah method bisa menyebabkan exception tapi tidak menanganinya,
     * maka method itu harus memberi tahu ke pemanggilnya.
     *
     * Caranya:
     * pakai throws di deklarasi method
     *
     * Bentuk umum:
     * type namaMethod(parameter) throws Exception1, Exception2 {
     *     // isi method
     * }
     *
     * artinya:
     * “Method ini mungkin melempar exception ini, siap-siap ya”
     *
     * Aturan penting
     * Wajib untuk:
     * Exception selain RuntimeException dan Error
     * Tidak wajib untuk:
     * RuntimeException
     * Error
     * 
     * -----------------------------------------------------
     *
     * Kalau gak ditulis:
     * compile error
     *
     * Perbedaan    inti
     * Keyword	    Fungsi
     * throw	    Melempar exception
     * throws	    Mendeklarasikan kemungkinan exception
     *
     * Intinya
     *
     * throwOne() tidak handle error
     * dia “lempar tanggung jawab” ke main()
     *
     * Ini inti kerasnya:
     *
     * throw → aksi lempar error
     * throws → deklarasi method
     *
     * Rule penting:
     * Checked exception → WAJIB pakai throws atau try-catch
     * RuntimeException → tidak wajib
     * 
     * Pola umum:
     * method() throws Exception {
     *     throw new Exception();
     * }
     *
     * ----------------------------------------------
     * 
     * Real world
     *
     * Misalnya:
     * readFile() throws IOException
     *
     * method ini bilang:
     * “Kalau file gagal dibaca, itu urusan yang manggil gua”
     *
     * Cara pro
     * spesifik:
     * throws IOException
     *
     * bukan:
     * throws Exception
     *
     * Ringkasan SUPER SINGKAT
     * throw  → lempar error
     * throws → kasih tahu method bisa error
     * 
     * -------------------------------------------------------------
     *
     * throws itu digunakan di deklarasi method (atau constructor)
     * Bukan di dalam body kode biasa
     *
     * Di mana throws dipakai?
     * 1. Method
     * void method() throws Exception {
     *     // isi method
     * }
     * 
     * 2. Constructor (INI SERING GAK DISADARIN)
     * class Contoh {
     *
     *     Contoh() throws Exception {
     *         // constructor juga bisa lempar exception
     *     }
     * }
     *
     * constructor itu sebenarnya “method khusus”
     * jadi bisa pakai throws
     *
     * Kenapa cuma di method?
     *
     * Karena fungsi throws itu:
     * memberi tahu pemanggil method
     *
     * Contoh:
     * void bacaFile() throws IOException
     *
     * Artinya:
     * “Kalau lu manggil gua, siap-siap error ya”
     *
     * Jadi alurnya:
     * Method A (throws) → Method B (yang manggil) harus siap handle
     *
     * Contoh Alur Nyata
     * public class ContohThrows {
     *
     *     static void methodA() throws Exception {
     *         throw new Exception("Error dari A");
     *     }
     *
     *     public static void main(String[] args) {
     *
     *         try {
     *             methodA(); // harus siap handle
     *
     *         } catch (Exception e) {
     *             System.out.println("Ditangkap di main");
     *         }
     *     }
     * }
     *
     * Perbedaan PENTING
     * Keyword	        Letak	            Fungsi
     * throw	        dalam method	    lempar error
     * throws	        deklarasi method	kasih tahu bisa error
     *
     * -----------------------------------------------------
     * 
     * Insight (LEVEL UP)
     * Cara mikir yang benar
     * throws itu bukan buat jalanin program
     * tapi buat kontrak antar method
     *
     * Kesimpulan (WAJIB INGAT)
     *
     * Intinya:
     * throws hanya di:
     * method
     * constructor
     * Tidak bisa di dalam body kode
     * Fungsinya: kasih tahu caller tentang kemungkinan error
     *
     * HANDLE throws
     * TIDAK SELALU wajib pakai try-catch
     * Tapi WAJIB di-handle (dengan 2 cara)
     *
     * Kalau lu manggil method yang pakai throws:
     * Lu punya 2 pilihan:
     * 1. Handle di situ (try-catch) 
     * 2. Lempar lagi ke atas (throws lagi) 
     *
     * Ini yang paling umum
     * Error selesai di sini
     */

public class Throws {

    // Contoh salah tidak menggunakan throws
    static void throwOne() { // Harusnya throws dideklarasikan disini
        System.out.println("Inside throwOne");

        // ERROR tidak dideklarasikan di methode (oleh throws)
        // throw new NoSuchMethodException("Demo");

        /**
         * Error karena:
         * NoSuchMethodException = checked exception
         * Tidak pakai throws
         */
    }

    // Contoh benar menggunakan throws
    static void throwsDeklarasi() throws IllegalAccessException { // Using throws
        System.out.println("Inside Throws Deklarasi"); 
        // Membuat error checked Exception
        throw new IllegalAccessException("Demo");
    }

    // Cara 2 — Lempar Lagi (PAKAI throws)
    // Methode 1
    static void methodA() throws Exception {
        throw new Exception("Error");
    }

    // Method yang lempar lagi methodA()
    static void methodB() throws Exception {
        // Panggil methodA()
        methodA(); // Gak ditangkap tapi dilempari lagi
    }

    public static void main(String[] args) throws Exception { // Handle Jvm

        throwOne();

        // Cara 1 — Pakai try-catch (HANDLE LANGSUNG)
        // Ini yang paling umum
        // Error selesai di sini
        try {
            throwsDeklarasi();
        } catch (IllegalAccessException e) {
            // Menangkap exception
            System.out.println("Caught: " + e);
        }

        // Cara 2 — Lempar Lagi (PAKAI throws)
        // Cara 2 ada di methode main (JVM yang handle)
        methodB();

        /**
         * public static void main(String[] args) throws Exception
         * berarti:
         * Lu lempar error ke JVM → JVM yang handle
         *
         * Apa yang terjadi kalau JVM yang handle?
         * Kalau exception sampai ke JVM (tidak ditangani sama sekali):
         * JVM pakai default exception handler
         * 
         * Yang dilakukan JVM:
         * Print error message
         * Print stack trace
         * Program langsung berhenti
         *
         * Contoh
         * public class Main {
         *
         *     static void methodA() throws Exception {
         *         throw new Exception("Error dari methodA");
         *     }
         *
         *     public static void main(String[] args) throws Exception {
         *         methodA();
         *     }
         * }
         *
         * Output:
         * Exception in thread "main" java.lang.Exception: Error dari methodA
         *     at Main.methodA(Main.java:4)
         *     at Main.main(Main.java:8)
         *
         * Artinya apa?
         * throws di main itu sama dengan:
         * "Gua nyerah, JVM yang urus"
         *
         * -------------------------------------
         * 
         * Kasus lu:
         * karyawan: "Ada masalah!"
         * manager: "Gua gak urus (throws)"
         * bos: "YA UDAH STOP SEMUA!"
         *
         * Kapan boleh pakai throws di main?
         * Boleh kalau:
         * lagi belajar
         * debugging
         * program kecil
         *
         * Jangan di real app
         * Kenapa?
         * user bakal lihat:
         * stack trace aneh
         * bukan pengalaman yang bagus
         * 
         * ------------------------------------------------
         *
         * Rule penting:
         * Exception HARUS berhenti di suatu tempat
         *
         * Pilihan:
         * ditangani programmer (try-catch)
         * ditangani JVM (default handler) (last resort)
         *
         * Kesimpulan (WAJIB INGAT)
         *
         * Intinya:
         * throws di main → JVM yang handle
         * JVM:
         * print error
         * print stack trace
         * matikan program
         */

        /**
         * EFEKTIVITAS
         *
         * Method bawah → boleh lempar (throws)
         * Method atas  → WAJIB handle (try-catch)
         *
         * Jadi:
         * lempar-lempar = OK
         * tapi harus ada titik akhir yang handle
         *
         * Pola yang BENAR (Best Practice)
         * Arsitektur umum:
         * methodA() → throws
         * methodB() → throws
         * main()    → try-catch 
         *
         * Contoh ideal
         * public class Main {
         *
         *     static void methodA() throws Exception {
         *         throw new Exception("Error dari A");
         *     }
         *
         *     static void methodB() throws Exception {
         *         methodA(); // lempar lagi
         *     }
         *
         *     public static void main(String[] args) {
         *
         *         try {
         *             methodB(); // titik akhir
         *
         *         } catch (Exception e) {
         *             System.out.println("Error ditangani di main: " + e.getMessage());
         *         }
         *     }
         * }
         *
         * Kenapa ini bagus?
         * 1. Separation of Responsibility
         * method kecil → fokus logika
         * method atas → handle error
         *
         * 2. Kode lebih bersih
         * Bayangin kalau semua method pakai try-catch:
         * jadi berantakan
         * susah dibaca
         *
         * 3. Lebih fleksibel
         * Lu bisa:
         * ganti cara handle di atas
         * tanpa ubah method bawah
         *
         * Insight Level Pro
         * Dalam project besar:
         * Layer bawah (repository, service):
         * sering pakai throws
         * 
         * Layer atas (controller / main):
         * pakai try-catch
         *
         * Ringkasan Super Singkat
         * throws → lempar tanggung jawab
         * try-catch → ambil tanggung jawab
         *
         * best practice:
         * lempar di bawah, tangkap di atas
         */
        
    }

}
