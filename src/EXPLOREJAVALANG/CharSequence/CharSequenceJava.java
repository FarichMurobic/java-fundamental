package EXPLOREJAVALANG.CharSequence;

/**
 * The CharSequence Interface
 *
 * Interface CharSequence mendefinisikan method-method yang memberikan akses 
 * read-only (hanya baca) ke sebuah urutan karakter (sequence of characters).
 * 
 * Method-method tersebut ditampilkan pada tabel (akan kita bahas lengkap di bawah).
 * 
 * Interface ini diimplementasikan oleh:
 * String
 * StringBuffer
 * StringBuilder
 * dan class lainnya
 *
 * Inti konsep
 * CharSequence =
 * representasi umum dari teks
 *
 * ------------------------------------
 * 
 * Artinya apa?
 *
 * Semua ini:
 * String
 * StringBuilder
 * StringBuffer
 *
 * punya “bentuk dasar” yang sama
 * yaitu: CharSequence
 *
 * Analogi
 * CharSequence = konsep "teks"
 *
 * String        = teks immutable
 * StringBuilder = teks mutable
 * StringBuffer  = teks thread-safe
 *
 * -----------------------------------
 * 
 * Kenapa dibuat?
 *
 * Supaya method bisa fleksibel:
 * void print(CharSequence text)
 *
 * Bisa terima:
 * String
 * StringBuilder
 * dll
 *
 * TABEL METHOD CharSequence (LENGKAP + PENJELASAN)
 * Method utama
 * Method	                                        Deskripsi
 * int length()	                                    Mengembalikan panjang karakter
 * char charAt(int index)	                        Mengambil karakter pada index tertentu
 * CharSequence subSequence(int start, int end)	    Mengambil sebagian teks
 * String toString()	                            Mengubah ke String
 *
 * Method tambahan (Java 8+)
 * Method	                                        Deskripsi
 * IntStream chars()	                            Stream karakter (UTF-16)
 * IntStream codePoints()	                        Stream Unicode
 *
 * 1. Read-only itu maksudnya?
 * Lo hanya bisa baca
 * Tidak bisa ubah
 *
 * 2. Kenapa penting?
 * Karena:
 * Banyak API Java pakai CharSequence
 *
 * Contoh:
 * Pattern.matches(regex, input)
 *
 * input = CharSequence
 *
 * 3. Flexibility (ini poin besar)
 * Kalau pakai:
 * String
 * hanya bisa String
 *
 * Kalau pakai:
 * CharSequence
 * bisa semua jenis teks
 *
 * ----------------------------------------
 * 
 * HAL PENTING
 * subSequence ≠ substring
 * subSequence() → return CharSequence
 * substring() → return String
 *
 * index mulai dari 0
 * text.charAt(0) // karakter pertama
 *
 * -----------------------------------------
 * 
 * KAITAN KE BACKEND
 * Dipakai di:
 * Regex
 * JSON processing
 * Logging
 * Validation
 *
 * Contoh real:
 * public boolean validate(CharSequence input)
 *
 * Lebih fleksibel dari String
 *
 * ---------------------------------------------
 * 
 * KESIMPULAN
 * 
 * Inti:
 * CharSequence = interface untuk teks
 * Bersifat read-only
 * Diimplementasi oleh:
 * String
 * StringBuilder
 * StringBuffer
 *
 * Method penting:
 * length()
 * charAt()
 * subSequence()
 * toString()
 *
 * Insight penting:
 * Gunakan CharSequence kalau butuh fleksibilitas
 * Gunakan String kalau butuh sederhana
 */


public class CharSequenceJava {

    // METHOD MENERIMA CHARSEQUENCE
    static void printText(CharSequence text) {

        // BISA AKSES KARAKTER
        for (int i = 0; i < text.length(); i++) 
            System.out.println("Char ke-" + i + ": " + text.charAt(i));
    }

    public static void main(String[] args) {
        
        // String
        String str = "Hello";

        // STRINGBUILDER
        StringBuilder stringBuilder = new StringBuilder("world");

        // KEDUANYA BISA DIPAKAI!
        // Panggil method
        printText(str); // Hello
        printText(stringBuilder); // world

        System.out.println();

        CharSequence text = "HelloWorld";

        // Ambil sebagian text
        CharSequence sub = text.subSequence(0, 5);
        
        // CETAK
        System.out.println(sub); // Hello
    }

}
