package FundamentalJava.String.StringBuffer;

/**
 * ================================================================
 * STRINGBUFFER ADDITIONAL METHODS - JAVA MODERN (17+)
 * ================================================================
 * 
 * Materi ini mencakup method-method tambahan pada StringBuffer
 * yang jarang diketahui tapi sangat powerfull untuk manipulasi
 * dan analisis teks tingkat lanjut.
 * 
 * -----------------------------------------------------------------
 * 1. UNICODE CODE POINT OPERATIONS
 * -----------------------------------------------------------------
 * 
 * StringBuffer appendCodePoint(int ch)
 * - Menambahkan satu Unicode code point ke akhir buffer.
 * - Mengembalikan objek StringBuffer yang sama (mendukung method chaining).
 * - Cocok untuk menangani karakter di luar Basic Multilingual Plane (BMP),
 * seperti emoji atau aksara langka.
 * 
 * int codePointAt(int index)
 * - Mengambil Unicode code point pada posisi index yang diberikan.
 * - Index harus berada dalam rentang 0 sampai length() - 1.
 * 
 * int codePointBefore(int index)
 * - Mengambil Unicode code point tepat sebelum posisi index.
 * - Index tidak boleh 0 (karena tidak ada karakter sebelum posisi pertama).
 * 
 * int codePointCount(int beginIndex, int endIndex)
 * - Menghitung jumlah Unicode code point dalam rentang indeks
 * dari beginIndex sampai endIndex - 1.
 * - Berguna karena jumlah code point bisa berbeda dari jumlah char
 * pada karakter non-BMP (surrogate pairs).
 * 
 * int offsetByCodePoints(int startIndex, int codePointOffset)
 * - Mengembalikan indeks baru setelah bergeser sejumlah code point
 * dari posisi startIndex.
 * - Sangat membantu untuk navigasi karakter Unicode secara akurat.
 * 
 * -----------------------------------------------------------------
 * 2. PENCARIAN SUBSTRING (SEARCH OPERATIONS)
 * -----------------------------------------------------------------
 * 
 * int indexOf(String str)
 * - Mencari kemunculan pertama dari substring str di dalam buffer.
 * - Mengembalikan indeks posisi awal, atau -1 jika tidak ditemukan.
 * 
 * int indexOf(String str, int fromIndex)
 * - Sama seperti indexOf(String), tetapi pencarian dimulai dari
 * indeks fromIndex (inklusif).
 * 
 * int lastIndexOf(String str)
 * - Mencari kemunculan terakhir dari substring str di dalam buffer.
 * - Mengembalikan indeks posisi awal, atau -1 jika tidak ditemukan.
 * 
 * int lastIndexOf(String str, int fromIndex)
 * - Sama seperti lastIndexOf(String), tetapi pencarian dilakukan
 * mundur mulai dari indeks fromIndex.
 * 
 * -----------------------------------------------------------------
 * 3. EKSTRAKSI SUBSTRING (SUBSEQUENCE)
 * -----------------------------------------------------------------
 * 
 * CharSequence subSequence(int startIndex, int endIndex)
 * - Mengambil potongan karakter dari startIndex hingga endIndex - 1.
 * - Mengembalikan tipe CharSequence, bukan String.
 * - Lebih fleksibel dibanding substring() karena bisa dikonversi
 * ke berbagai tipe (String, StringBuilder, StringBuffer) nantinya.
 * 
 * -----------------------------------------------------------------
 * 4. OPTIMASI MEMORI
 * -----------------------------------------------------------------
 * 
 * void trimToSize()
 * - Mengecilkan kapasitas internal buffer agar sama persis dengan
 * panjang karakter yang sedang disimpan.
 * - Berguna untuk menghemat memori setelah banyak operasi append
 * atau delete yang membuat kapasitas buffer membengkak.
 * - Hanya direkomendasikan jika buffer sudah dalam kondisi final
 * dan tidak akan ditambah lagi isinya.
 * 
 * ================================================================
 * INSIGHT PENTING UNTUK LEVEL UP
 * ================================================================
 * 
 * 1. Method indexOf() dan lastIndexOf() adalah yang paling sering
 * digunakan dalam kode produksi untuk validasi, parsing, dan
 * pencarian data di dalam teks.
 * 
 * 2. Method dengan awalan codePoint* wajib digunakan jika aplikasi
 * berinteraksi dengan Unicode non-BMP (emoji, aksara Cina kuno,
 * simbol matematika khusus, dll). Jangan gunakan charAt() untuk
 * ini karena akan menghasilkan potongan surrogate pair yang rusak.
 * 
 * 3. trimToSize() adalah teknik mikro-optimasi. Hanya gunakan jika
 * buffer berukuran besar dan sudah tidak akan dimodifikasi lagi,
 * misalnya pada cache atau objek yang disimpan lama di memori.
 * 
 * 4. subSequence() memberikan abstraksi yang lebih generik
 * dibanding substring(), sehingga kode lebih mudah diadaptasi
 * bila tipe data diubah dari StringBuffer ke StringBuilder
 * atau CharSequence lainnya.
 * 
 * ================================================================
 * KESIMPULAN UTAMA
 * ================================================================
 * 
 * StringBuffer bukan sekadar kelas untuk mengubah string secara
 * mutable. Dengan method-method tambahan di atas, StringBuffer
 * menjelma menjadi toolkit lengkap untuk:
 * 
 * - Pencarian teks (indexOf / lastIndexOf)
 * - Analisis Unicode (codePoint* / offsetByCodePoints)
 * - Optimasi memori (trimToSize)
 * - Ekstraksi fleksibel (subSequence)
 * 
 * ================================================================
 * INTI PALING DALAM
 * ================================================================
 * 
 * StringBuffer adalah salah satu kelas paling mature di Java
 * yang menggabungkan kemampuan manipulasi, pencarian, dan
 * analisis teks dalam satu objek. Menguasai method-method ini
 * berarti Anda tidak perlu lagi bergantung pada kelas pembantu
 * terpisah untuk operasi teks tingkat menengah.
 * 
 * ================================================================
 * CATATAN TAMBAHAN (Java 17+)
 * ================================================================
 * 
 * Method-method ini bersifat backward compatible dan tetap
 * valid di semua versi Java mulai dari 1.0 hingga 17+.
 * 
 * Perbedaan utama StringBuffer vs StringBuilder dalam konteks
 * method ini adalah:
 * - StringBuffer -> thread-safe (synchronized)
 * - StringBuilder -> non-thread-safe tapi lebih cepat
 * 
 * Untuk lingkungan single-threaded, StringBuilder lebih disarankan.
 * Namun method-method yang dijelaskan di sini berlaku identik
 * untuk kedua kelas.
 * 
 * ================================================================
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
