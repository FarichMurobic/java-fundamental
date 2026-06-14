package FundamentalJava.String.StringBuffer;

/**
 * Additional StringBuffer Methods
 * Berikut tabel method tambahan pada StringBuffer:
 *
 * Method	                                                        Deskripsi
 * StringBuffer appendCodePoint(int ch)	                            Menambahkan Unicode code point ke akhir StringBuffer. Return object yang sama (bisa chaining).
 * int codePointAt(int i)	                                        Mengambil Unicode code point pada index ke-i.
 * int codePointBefore(int i)	                                    Mengambil Unicode code point sebelum index i.
 * int codePointCount(int start, int end)	                        Menghitung jumlah Unicode code point dari index start sampai end-1.
 * int indexOf(String str)	                                        Mencari kemunculan pertama str. Return index atau -1 kalau tidak ditemukan.
 * int indexOf(String str, int startIndex)	                        Sama seperti indexOf, tapi mulai pencarian dari index tertentu.
 * int lastIndexOf(String str)	                                    Mencari kemunculan terakhir str.
 * int lastIndexOf(String str, int startIndex)	                    Mencari kemunculan terakhir str mulai dari index tertentu.
 * int offsetByCodePoints(int start, int num)	                    Mengembalikan index berdasarkan pergeseran sejumlah code point dari posisi awal.
 * CharSequence subSequence(int startIndex, int stopIndex)	        Mengambil substring dalam bentuk CharSequence (mirip substring).
 * void trimToSize()	                                            Mengecilkan kapasitas buffer agar sesuai dengan panjang isi sekarang (hemat memory).
 *
 * Insight Penting (biar naik level)
 * indexOf & lastIndexOf → PALING SERING DIPAKAI
 * codePoint* → buat Unicode (emoji, dll)
 * trimToSize() → optimasi memory
 * subSequence() → versi fleksibel dari substring
 *
 * KESIMPULAN SUPER PADAT
 * Semua method ini bikin StringBuffer:
 * bisa cari 
 * bisa hitung 
 * bisa optimasi 
 * bisa handle Unicode 
 *
 * INTI PALING DALAM:
 * StringBuffer bukan cuma buat ubah string, tapi juga tool lengkap buat manipulasi & analisis teks
 */

public class AdditionalMethodsStringBuffer {

    public static void main(String[] args) {

        
        // SETUP AWAL
        StringBuffer sb = new StringBuffer("Hello World Hello");

        System.out.println("Awal: " + sb);

        // 1. appendCodePoint(int ch)
        // Menambahkan karakter berdasarkan Unicode code point
        sb.appendCodePoint(33); // 33 = '!'
        System.out.println("\nappendCodePoint(33): " + sb);

        // 2. codePointAt(int i)
        int cpAt = sb.codePointAt(1); // ambil code point di index 1
        System.out.println("\ncodePointAt(1): " + cpAt + " (char: " + (char) cpAt + ")");

        // 3. codePointBefore(int i)
        int cpBefore = sb.codePointBefore(1); // sebelum index 1
        System.out.println("codePointBefore(1): " + cpBefore + " (char: " + (char) cpBefore + ")");

        // 4. codePointCount(int start, int end)
        int count = sb.codePointCount(0, sb.length());
        System.out.println("\ncodePointCount(0, length): " + count);

        // 5. indexOf(String str)
        int firstIndex = sb.indexOf("Hello");
        System.out.println("\nindexOf(\"Hello\"): " + firstIndex);

        // 6. indexOf(String str, int startIndex)
        int indexFrom = sb.indexOf("Hello", 5);
        System.out.println("indexOf(\"Hello\", 5): " + indexFrom);

        // 7. lastIndexOf(String str)
        int lastIndex = sb.lastIndexOf("Hello");
        System.out.println("\nlastIndexOf(\"Hello\"): " + lastIndex);

        // 8. lastIndexOf(String str, int startIndex)
        int lastFrom = sb.lastIndexOf("Hello", 10);
        System.out.println("lastIndexOf(\"Hello\", 10): " + lastFrom);

        // 9. offsetByCodePoints(int start, int num)
        int offset = sb.offsetByCodePoints(0, 5);
        System.out.println("\noffsetByCodePoints(0, 5): " + offset);

        // 10. subSequence(int startIndex, int stopIndex)
        CharSequence subSeq = sb.subSequence(0, 5);
        System.out.println("\nsubSequence(0,5): " + subSeq);

        // 11. trimToSize()
        StringBuffer sb2 = new StringBuffer(100); // kapasitas besar
        sb2.append("Java");

        System.out.println("\nSebelum trimToSize:");
        System.out.println("Length: " + sb2.length());
        System.out.println("Capacity: " + sb2.capacity());

        // Mengurangi kapasitas agar sesuai isi
        sb2.trimToSize();

        System.out.println("\nSetelah trimToSize:");
        System.out.println("Length: " + sb2.length());
        System.out.println("Capacity: " + sb2.capacity());
    }
}
