package ExploringJavaLang.StackTraceImplementJava;

/**
 * StackTraceElement
 * Class StackTraceElement menggambarkan satu frame stack, yaitu satu elemen dari stack trace ketika terjadi exception.
 * Setiap stack frame merepresentasikan titik eksekusi (execution point), yang mencakup:
 * Nama class
 * Nama method
 * Nama file
 * Nomor baris kode
 *
 * Array dari StackTraceElement dikembalikan oleh method:
 * Throwable.getStackTrace()
 *
 * Constructor
 * StackTraceElement(String className, String methName, String fileName, int line)
 *
 * Penjelasan:
 * className → nama class
 * methName → nama method
 * fileName → nama file
 * line → nomor baris
 *
 * Catatan penting:
 * Kalau tidak ada nomor baris → pakai nilai negatif
 * Kalau line = -2 → berarti method native (kode C/C++ di JVM)
 *
 * Stack trace itu apa?
 *
 * Kalau program error:
 * Exception in thread "main"
 * at A.methodA(A.java:10)
 * at B.methodB(B.java:20)
 * at Main.main(Main.java:30)
 *
 * Itu disebut stack trace
 *
 * StackTraceElement itu apa?
 * Setiap baris itu = 1 object StackTraceElement
 *
 * Analogi
 * Stack trace = jejak langkah program
 * StackTraceElement = satu langkah
 *
 * TABEL METHOD (LENGKAP + PENJELASAN)
 * Method	                Deskripsi
 * equals(Object ob)	    Membandingkan dua StackTraceElement
 * getClassName()	        Nama class
 * getFileName()	        Nama file
 * getLineNumber()	        Nomor baris
 * getMethodName()	        Nama method
 * hashCode()	            Hash code
 * isNativeMethod()	        Apakah method native
 * toString()	            Representasi string
 *
 * Kenapa ini penting?
 *
 * Di backend:
 * Error = hal biasa
 *
 * Yang penting:
 * Bisa baca stack trace
 *
 * Cara baca stack trace (WAJIB)
 *
 * Baris pertama:
 * Lokasi error asli
 *
 * Baris bawah:
 * Jejak pemanggilan
 *
 * Contoh:
 * methodB → error
 * methodA → manggil methodB
 * main    → manggil methodA
 *
 * Insight penting
 * Baris paling atas = sumber masalah
 *
 * USE CASE DI DUNIA NYATA
 * Logging system
 * logger.error("Error", e);
 *
 * di belakang layar pakai:
 * StackTraceElement
 *
 * Debugging otomatis
 * Spring Boot
 * Logback
 * ELK Stack
 *
 * Monitoring system
 * Datadog
 * New Relic
 *
 * HAL PENTING
 * Jangan parse string stack trace
 * Salah:
 * e.toString()
 *
 * Benar:
 * e.getStackTrace()
 *
 * KESIMPULAN
 * Inti:
 * StackTraceElement = 1 frame dalam stack trace
 * Digunakan untuk:
 * debugging
 * logging
 * error tracking
 *
 * Method penting:
 * getClassName()
 * getMethodName()
 * getLineNumber()
 * getFileName()
 *
 * Insight backend
 * Kalau lo ngerti ini:
 * lo bisa baca error seperti engineer beneran
 */

public class StackTraceImplementJava {
    public static void main(String[] args) {
        try {
            // Memanggil method yang akan error
            methodA();

        } catch (Exception e) {

            // Mengambil semua stack trace
            StackTraceElement[] elements = e.getStackTrace();

            // Loop setiap frame
            for (StackTraceElement el : elements) {

                // Menampilkan detail setiap frame
                System.out.println("Class: " + el.getClassName());
                System.out.println("Method: " + el.getMethodName());
                System.out.println("File: " + el.getFileName());
                System.out.println("Line: " + el.getLineNumber());
                System.out.println("---------------------------");
            }
        }
    }

    /**
     * OUTPUT (KONSEP)
     * Class: StackTraceExample
     * Method: methodB
     * File: StackTraceExample.java
     * Line: 30
     * ---------------------------
     * Class: StackTraceExample
     * Method: methodA
     * File: StackTraceExample.java
     * Line: 25
     * ---------------------------
     * Class: StackTraceExample
     * Method: main
     * File: StackTraceExample.java
     * Line: 10
     */

    static void methodA() {
        methodB();
    }

    static void methodB() {
        // Membuat error
        int x = 10 / 0;

    }
}
