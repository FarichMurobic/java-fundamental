package FundamentalJava.String.StringBuffer;

/**
 * ================================================================
 * APPEND() METHOD - STRINGBUFFER CORE
 * ================================================================
 * 
 * Method append() adalah fondasi utama dari StringBuffer.
 * Fungsinya menggabungkan representasi string dari berbagai tipe
 * data ke bagian akhir objek StringBuffer yang memanggilnya.
 * 
 * -----------------------------------------------------------------
 * 1. OVERLOADING METHOD - BANYAK VARIAN
 * -----------------------------------------------------------------
 * 
 * Method append() hadir dalam beberapa versi overloading untuk
 * mendukung berbagai tipe data:
 * 
 * StringBuffer append(String str)
 * StringBuffer append(int num)
 * StringBuffer append(long num)
 * StringBuffer append(double num)
 * StringBuffer append(float num)
 * StringBuffer append(boolean bool)
 * StringBuffer append(char ch)
 * StringBuffer append(char[] charArray)
 * StringBuffer append(Object obj)
 * 
 * Setiap versi secara otomatis mengubah parameter menjadi string
 * menggunakan String.valueOf() di balik layar, lalu menambahkan
 * hasilnya ke akhir buffer..
 * 
 * -----------------------------------------------------------------
 * 2. CONTOH DASAR - PENGGUNAAN SEDERHANA
 * -----------------------------------------------------------------
 * 
 * StringBuffer sb = new StringBuffer("Hello");
 * sb.append(" World");
 * 
 * System.out.println(sb); // Output: "Hello World"
 * 
 * -----------------------------------------------------------------
 * 3. BERBAGAI TIPE DATA - FLEKSIBILITAS
 * -----------------------------------------------------------------
 * 
 * StringBuffer sb = new StringBuffer();
 * 
 * sb.append("Hello"); // String
 * sb.append(10); // int
 * sb.append(3.14); // double
 * sb.append(true); // boolean
 * sb.append('X'); // char
 * sb.append(new Object()); // object apapun
 * 
 * Semua parameter dikonversi ke string secara otomatis tanpa
 * perlu konversi manual terlebih dahulu.
 * 
 * -----------------------------------------------------------------
 * 4. MEKANISME INTERNAL - BAGAIMANA JAVA BEKERJA
 * -----------------------------------------------------------------
 * 
 * Di balik layar, setiap pemanggilan append() kurang lebih
 * dieksekusi seperti ini:
 * 
 * sb.append(42);
 * 
 * Sebenarnya sama dengan:
 * sb.append(String.valueOf(42)); // menjadi "42"
 * 
 * String.valueOf() menangani konversi null dengan aman
 * (menghasilkan "null"), sehingga tidak terjadi NullPointerException
 * pada parameter objek.
 * 
 * -----------------------------------------------------------------
 * 5. METHOD CHAINING - FLUENT INTERFACE
 * -----------------------------------------------------------------
 * 
 * Karena setiap append() mengembalikan objek StringBuffer yang sama
 * (return this), maka pemanggilan bisa dirantai:
 * 
 * sb.append("A").append("B").append("C");
 * 
 * Hasil akhir:
 * "ABC"
 * 
 * Teknik ini membuat kode lebih ringkas dan ekspresif, terutama
 * saat membangun string panjang atau query.
 * 
 * -----------------------------------------------------------------
 * 6. KONVERSI KE STRING - METHOD toString()
 * -----------------------------------------------------------------
 * 
 * Penting untuk dipahami:
 * StringBuffer bukanlah String.
 * 
 * StringBuffer sb = new StringBuffer("Java");
 * 
 * // sb adalah StringBuffer, BUKAN String
 * 
 * Untuk mendapatkan representasi String biasa:
 * String result = sb.toString();
 * 
 * Method toString() mengembalikan salinan isi buffer sebagai
 * objek String yang immutable.
 * 
 * -----------------------------------------------------------------
 * 7. EFISIENSI - KENAPA APPEND() LEBIH BAIK DARI KONKATENASI
 * -----------------------------------------------------------------
 * 
 * PERBANDINGAN DENGAN STRING BIASA:
 * 
 * // STRING (IMMUTABLE) - INEFFISIEN
 * String s = "";
 * s = s + "Hello"; // object String baru
 * s = s + " World"; // object String baru lagi
 * // Total: 3 objek String dibuat, memory tidak efisien
 * 
 * // STRINGBUFFER (MUTABLE) - EFFISIEN
 * StringBuffer sb = new StringBuffer();
 * sb.append("Hello");
 * sb.append(" World");
 * // Total: 1 objek StringBuffer, memory jauh lebih hemat
 * 
 * -----------------------------------------------------------------
 * 8. KAPASITAS DAN PERFORMANCE - TIPS OPTIMAL
 * -----------------------------------------------------------------
 * 
 * Saat menggunakan append() berulang kali, StringBuffer akan
 * secara otomatis memperbesar kapasitas internal jika diperlukan.
 * 
 * Untuk performa maksimal pada string yang sangat panjang:
 * 
 * // Prediksi kapasitas awal untuk menghindari resize berulang
 * StringBuffer sb = new StringBuffer(1000); // kapasitas 1000 char
 * 
 * // Atau gunakan ensureCapacity() jika sudah tahu panjang akhir
 * sb.ensureCapacity(2000);
 * 
 * -----------------------------------------------------------------
 * 9. PERBANDINGAN STRINGBUFFER VS STRINGBUILDER
 * -----------------------------------------------------------------
 * 
 * Method append() tersedia di kedua kelas dengan perilaku identik.
 * Perbedaan utama:
 * 
 * - StringBuffer : thread-safe (synchronized), lebih lambat
 * - StringBuilder : non-thread-safe, lebih cepat
 * 
 * Untuk lingkungan single-threaded (99% kasus), StringBuilder
 * adalah pilihan yang lebih baik karena performa lebih tinggi.
 * 
 * ================================================================
 * KESIMPULAN - VERSI PADAT
 * ================================================================
 * 
 * 1. append() adalah method utama untuk menambah data ke StringBuffer
 * 2. Menerima berbagai tipe data (String, int, double, boolean, Object)
 * 3. Mengembalikan objek yang sama → mendukung method chaining
 * 4. Jauh lebih efisien dibandingkan konkatenasi String (+)
 * 5. Gunakan toString() untuk mengubah ke String biasa
 * 6. Untuk single-threaded, preferensi ke StringBuilder
 * 
 * ================================================================
 * INTI PALING DALAM
 * ================================================================
 * 
 * append() adalah cara tercepat, paling efisien, dan paling
 * aman untuk membangun string dinamis di Java.
 * 
 * Tidak ada alasan untuk menggunakan konkatenasi String (+)
 * dalam loop atau operasi string berat ketika append() tersedia.
 * 
 * ================================================================
 * CATATAN JAVA MODERN (17+)
 * ================================================================
 * 
 * Sejak Java 9, compiler secara otomatis mengubah konkatenasi
 * String menjadi invokedynamic yang efisien untuk kasus sederhana.
 * 
 * Namun untuk loop, conditional concatenation, atau pembangunan
 * string kompleks, append() tetap menjadi pilihan terbaik
 * karena prediktabilitas dan kontrol penuh atas memori.
 * 
 * Method append() di Java 17+ mendukung semua tipe data yang sama
 * seperti versi awal, dengan tambahan optimasi internal untuk
 * karakter non-BMP (Unicode surrogate pairs).
 * 
 * ================================================================
 */

public class Append {
    public static void main(String[] args) {

        // Membuat string biasa
        String string;
        int a = 42;

        // Membuat StringBuffer dengan kapasitas 40
        StringBuffer stringBuffer = new StringBuffer(40);

        // append chaining - berantai
        // Method chaining:
        // 1. append("a = ")
        // 2. append(a) → otomatis jadi "42"
        // 3. append("!")
        // 4. toString() → ubah ke String biasa
        string = stringBuffer.append("a = ").append(a).append("!").toString();

        System.out.println(string); // a = 42!

        System.out.println("------------------");

        StringBuffer sb = new StringBuffer();
        sb.append("Nama: ")
                .append("Farich")
                .append(", Umur: ")
                .append(20)
                .append(", Status: ")
                .append(true);
        System.out.println(sb.toString());

    }
}
