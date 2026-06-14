package ExploreJavaLang;

/**
 * Menjelajahi java.lang
 *
 * Bab ini membahas kelas-kelas dan interface yang ada di dalam java.lang.
 * Seperti yang sudah kamu tahu, java.lang secara otomatis di-import ke semua program Java.
 *
 * Package ini berisi kelas dan interface yang sangat fundamental untuk hampir semua pemrograman Java.
 * Bisa dibilang, ini adalah package yang paling sering digunakan di Java.
 *
 * java.lang mencakup kelas-kelas berikut:
 *
 * Boolean                          Enum                        Process                     String
 * Byte                             Float                       ProcessBuilder              StringBuffer
 * Character                        InheritableThreadLocal      ProcessBuilder.Redirect     StringBuilder
 * Character.Subset                 Integer                     Runtime                     System
 * Character.UnicodeBlock           Long                        RuntimePermission           Thread
 * Class                            Math                        SecurityManager             ThreadGroup
 * ClassLoader                      Number                      Short                       ThreadLocal
 * ClassValue                       Object                      StackTraceElement           Throwable
 * Compiler                         Package                     StrictMath                  Void
 * Double
 *
 * java.lang juga mendefinisikan interface berikut:
 *
 * Appendable       Cloneable     Readable
 * AutoCloseable    Comparable    Runnable
 * CharSequence     Iterable      Thread.UncaughtExceptionHandler
 *
 * Beberapa kelas di dalam java.lang memiliki method yang sudah deprecated (usang),
 * sebagian besar sejak Java 1.0. Method-method ini masih ada untuk mendukung kode lama (legacy),
 * tetapi tidak direkomendasikan untuk digunakan di kode baru. Karena itu, method deprecated tidak dibahas di sini.
 */

/**
 * Apa sih java.lang itu?
 *
 *  Ini package paling inti di Java.
 *
 * Semua hal dasar ada di sini:
 * String
 * Math
 * Thread
 * System
 * Object
 *
 * Dan yang paling penting:
 * Lo gak perlu import manual
 *
 * Kenapa bisa langsung dipakai?
 * Karena sebenarnya Java diam-diam melakukan ini:
 * import java.lang.*;
 *
 * Kenapa java.lang penting banget?
 * Karena hampir semua kode Java pasti pakai ini.
 *
 * Contoh real:
 *
 * Hal yang lo lakukan  	Class dari java.lang
 * Simpan text	            String
 * Hitung matematika	    Math
 * Print ke console	        System
 * Threading	            Thread
 * Semua object turunan	    Object
 *
 * Bahkan semua class di Java otomatis turunan dari Object
 *
 * -------------------------------------------------------
 * 
 * Insight penting
 * 1. Semua class di Java itu turunan dari:
 * Object
 *
 * Contoh:
 * public class Test {
 * }
 *
 * Sebenernya:
 * public class Test extends Object {
 * }
 *
 * Jadi semua object punya method seperti:
 * toString()
 * equals()
 * hashCode()
 *
 * 2. Banyak class yang lo sering pakai ada di sini
 * Contoh paling sering:
 * String
 * Untuk text
 *
 * StringBuilder & StringBuffer
 * Untuk manipulasi string (lebih advanced)
 *
 * Math
 * Untuk hitung matematika
 *
 * System
 * Untuk:
 * print (System.out.println)
 * akses waktu
 * dll
 *
 * 3. Interface penting juga ada di sini
 *
 * Contoh:
 * Comparable
 * Buat sorting
 *
 * Runnable
 * Buat thread
 *
 * CharSequence
 * Parent dari:
 * String
 * StringBuilder
 * StringBuffer
 *
 * --------------------------------------------------------
 * 
 * Deprecated Method (INI PENTING BANGET)
 * Deprecated = sudah usang / tidak disarankan dipakai
 *
 * Kenapa masih ada?
 * Untuk support kode lama (legacy system)
 *
 * Kenapa jangan dipakai?
 * Bisa dihapus di masa depan
 * Biasanya ada cara yang lebih baik
 * 
 * ---------------------------------------------------------
 *
 * KESIMPULAN SEDERHANA
 *
 * Intinya:
 * java.lang = jantungnya Java
 * Auto import (gak perlu ditulis manual)
 * Dipakai di hampir semua program
 *
 * Yang wajib lo inget:
 *
 * Semua class turunan dari Object
 * Class penting:
 * String
 * Math
 * System
 * Thread
 *
 * Interface penting:
 * Comparable
 * Runnable
 *
 * Deprecated:
 * Jangan dipakai di code baru
 */

public class JavaLangExploring {
    public static void main(String[] args) {

        // STRING (java.lang.String)
        String text = "Hello World";
        System.out.println("Text: " + text);

        // MATH (java.lang.Math)
        int max = Math.max(10, 20); // cari nilai terbesar
        System.out.println("Max: " + max);

        double sqrt = Math.sqrt(25); // akar kuadrat
        System.out.println("Sqrt: " + sqrt);

        // SYSTEM (java.lang.System)
        long currentTime = System.currentTimeMillis(); // waktu sekarang
        System.out.println("Time: " + currentTime);

        // STRING BUILDER
        StringBuilder sb = new StringBuilder();

        sb.append("Hello");
        sb.append(" ");
        sb.append("Java");

        System.out.println("StringBuilder: " + sb.toString());

        // OBJECT (semua turunan dari ini)
        JavaLangExploring obj = new JavaLangExploring();

        System.out.println("toString(): " + obj.toString()); // method dari Object
        System.out.println("hashCode(): " + obj.hashCode()); // method dari Object

        /**
         * Alur program:
         * 
         * Buat String
         * Pakai Math untuk hitung
         * Pakai System untuk print dan waktu
         * Pakai StringBuilder untuk gabung string
         * Gunakan method dari Object
         *
         * Insight penting:
         * StringBuilder dipakai buat:
         * efisiensi memory
         * manipulasi string banyak
         *
         * System.out.println:
         * System = class
         * out = object
         * println() = method
         *
         * KESIMPULAN SEDERHANA
         *
         * Intinya:
         * java.lang = jantungnya Java
         * Auto import (gak perlu ditulis manual)
         * Dipakai di hampir semua program
         */
    }

    /**
     * Number
     *
     * Class abstrak Number mendefinisikan superclass yang diimplementasikan oleh class-class yang membungkus tipe numerik seperti:
     * byte
     * short
     * int
     * long
     * float
     * double
     *
     * Number memiliki method abstrak yang mengembalikan nilai object dalam berbagai format angka.
     *
     * Contohnya:
     * doubleValue() → mengembalikan nilai sebagai double
     * floatValue() → mengembalikan nilai sebagai float
     * dan seterusnya
     *
     * Method-method tersebut adalah:
     * byte byteValue()
     * double doubleValue()
     * float floatValue()
     * int intValue()
     * long longValue()
     * short shortValue()
     *
     * Nilai yang dikembalikan oleh method ini bisa:
     * dibulatkan (rounded)
     * dipotong (truncated)
     * atau bahkan menghasilkan nilai “aneh” (garbage)
     *
     * Hal ini terjadi karena efek dari narrowing conversion (konversi ke tipe yang lebih kecil).
     *
     * Number memiliki subclass konkret yang menyimpan nilai dari masing-masing tipe numerik:
     * Double
     * Float
     * Byte
     * Short
     * Integer
     * Long
     *
     * ------------------
     * 
     * Inti konsepnya:
     * Semua angka di Java wrapper itu punya nenek moyang yang sama
     *
     * yaitu: Number
     *
     * Struktur pewarisan (INI PENTING BANGET)
     * Number (abstract)
     *    ↑
     *    ├── Integer
     *    ├── Double
     *    ├── Float
     *    ├── Long
     *    ├── Short
     *    └── Byte
     *
     * Kenapa Number dibuat?
     * Supaya semua angka bisa diperlakukan secara umum (generic)
     * Contoh real:
     * Number n;
     *
     * n bisa jadi:
     * Integer
     * Double
     * dll
     *
     * Ini kepake di dunia nyata banget
     * Contoh:
     * Collection
     * API generic
     * parsing data
     * framework (Spring, Hibernate)
     *
     * Method penting di Number
     * Semua wrapper numeric punya method ini:
     * Method	        Fungsi
     * intValue()	    jadi int
     * doubleValue()	jadi double
     * longValue()	    jadi long
     * dll
     *
     * Narrowing Conversion (INI RAWAN BUG)
     * Contoh:
     * double d = 10.9;
     * int i = (int) d;
     *
     * hasilnya:
     * i = 10
     * angka di belakang koma hilang
     *
     * ---------------------------------------------
     * 
     * KESIMPULAN SEDERHANA
     *
     * Intinya:
     * Number = parent class untuk semua angka
     * Semua wrapper numeric turunan dari Number
     * Punya method konversi ke berbagai tipe
     *
     * Yang WAJIB lo inget:
     * Number itu abstract
     * Wrapper numeric = subclass
     * Bisa convert antar tipe angka
     *
     * Bisa terjadi:
     * pembulatan
     * pemotongan
     * overflow
     *
     * ------------------------------
     * 
     * REAL TALK (LEVEL BACKEND)
     * Di dunia nyata:
     * Number sering dipakai buat:
     * generic API
     * parsing dynamic data
     * JSON mapping
     *
     * Contoh real case:
     * Misalnya API response:
     *
     * {
     *   "value": 10
     * }
     *
     * Kadang:
     * bisa Integer
     * bisa Double
     *
     * solusi:
     * Number value;
     *
     * BEST PRACTICE
     * Jangan asal convert!
     *
     * Bahaya:
     * int x = num.intValue();
     *
     * Kalau lo gak yakin tipe aslinya
     *
     * Lebih aman:
     * if (num instanceof Double) {
     *     System.out.println("Ini double");
     * }
     */

    public static class ClassNumber {
        public static void main(String[] args) {

            // Contoh 1: Pakai Number
            // Kita pakai reference Number
            Number number;

            // Assign Integer
            number = 10;  // Assign Integer

            System.out.println("Integer ke double: " + number.doubleValue());
            System.out.println("Integer ke long: " + number.longValue());

            // Assign Double
            number = 10.75;

            System.out.println("Double ke int: " + number.intValue()); // akan dipotong
            System.out.println("Double ke byte: " + number.byteValue()); // bisa overflow

            // Contoh 2: Semua Wrapper adalah Number
            // Array berisi berbagai tipe angka
            Number[] numbers = new Number[4];
            numbers[0] = 10;
            numbers[1] = 10.5;
            numbers[2] = 100L;
            numbers[3] = 5.5f;

            for (Number x : numbers) {
                // Semua bisa dipanggil method Number
                System.out.println("As int: " + x.intValue());
                System.out.println("As double: " + x.doubleValue());
                System.out.println("-----------------");
            }

            // Contoh 3: Narrowing Problem
            Number num = 123.99;

            // Konversi ke int
            int i = (int) num.intValue();
            // Konversi ke byte
            byte b = (byte) num.byteValue();

            System.out.println("Original: " + num);
            System.out.println("intValue(): " + i);   // 123 (dipotong)
            System.out.println("byteValue(): " + b);  // bisa jadi aneh (overflow)

            /**
             * BEDAH LOGIC
             * 
             * Contoh penting:
             * Number num = 10.75;
             * int x = num.intValue();
             *
             * Yang terjadi:
             * 10.75 disimpan sebagai Double
             * intValue() dipanggil
             * nilai dipotong jadi 10
             *
             * Kasus berbahaya:
             * Number num = 1000;
             * byte b = num.byteValue();
             *
             * byte range: -128 sampai 127
             * hasil bisa:
             *
             * -24
             *
             * ini yang disebut:
             * "garbage value" (overflow)
             */
        }
    }
}
