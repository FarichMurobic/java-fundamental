package String.StringBuilder;

/**
 * StringBuilder
 *
 * Diperkenalkan pada JDK 5, StringBuilder adalah tambahan yang relatif baru dalam kemampuan pengolahan string di Java.
 * StringBuilder mirip dengan StringBuffer, kecuali satu perbedaan penting:
 * StringBuilder tidak disinkronisasi (not synchronized), yang berarti tidak thread-safe.
 * Keuntungan dari StringBuilder adalah performanya lebih cepat.
 * 
 * Namun, dalam kasus di mana string yang bisa diubah (mutable string) akan diakses oleh banyak thread,
 * dan tidak ada mekanisme sinkronisasi eksternal, maka kamu harus menggunakan StringBuffer, bukan StringBuilder.
 *
 * Inti Perbedaan PALING PENTING
 * Fitur	            StringBuffer	    StringBuilder
 * Thread-safe	        Ya	                Tidak
 * Synchronization	    Ada	                Tidak
 * Performa	            Lebih lambat	    Lebih cepat
 * Digunakan saat	    Multi-thread	    Single-thread
 *
 * Apa itu “synchronized”?
 *
 * Artinya:
 * Aman dipakai banyak thread
 * Ada “pengunci” (lock)
 *
 * Analogi:
 * StringBuffer = pintu pakai kunci (aman tapi lambat)
 * StringBuilder = pintu tanpa kunci (cepat tapi berisiko)
 *
 * Kenapa StringBuilder lebih cepat?
 *
 * Karena:
 * gak ada locking
 * gak ada overhead thread
 *
 * jadi lebih ringan
 *
 * -----------------------------------------
 * 
 * Kapan pakai masing-masing?
 * Pakai StringBuilder (90% kasus)
 * program biasa
 * single-thread
 * backend logic normal
 *
 * Pakai StringBuffer
 * multi-thread
 * shared data antar thread
 * butuh safety
 *
 * Insight Penting
 * Semua method yang lo pelajari di StringBuffer:
 * append, insert, delete, replace, reverse, dll
 * ADA JUGA di StringBuilder (sama persis)
 *
 * Jadi bedanya cuma ini:
 * StringBuffer = synchronized
 * StringBuilder = tidak
 *
 * Contoh Kasus Nyata
 * Salah (pakai StringBuilder di multi-thread)
 * // Bisa error atau data kacau
 * StringBuilder sb = new StringBuilder();
 * Benar
 * StringBuffer sb = new StringBuffer();
 *
 * Analogi biar nempel
 * Bayangin:
 * StringBuilder = jalan tol kosong (cepat)
 * StringBuffer = jalan dengan lampu merah (aman tapi lambat)
 *
 * Kesimpulan (versi nempel keras)
 * StringBuilder:
 * cepat
 * tidak thread-safe
 * StringBuffer:
 * aman (thread-safe)
 * lebih lambat
 *
 * Inti banget:
 * Pakai StringBuilder kalau gak butuh thread-safety
 * Pakai StringBuffer kalau butuh aman di multi-thread
 */

public class Stringbuilder {
    public static void main(String[] args) {

        // StringBuilder (FAST)
        // StringBuilder (tidak thread-safe, tapi cepat)
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Hello");
        stringBuilder.append(" ");
        stringBuilder.append("World");

        System.out.println(stringBuilder.toString());

        // StringBuffer (SAFE)
        // StringBuffer (thread-safe, tapi lebih lambat)
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("Hello");
        stringBuffer.append(" ");
        stringBuffer.append("World");

        System.out.println(stringBuffer.toString());

    }
}
