package String.StringHandling;

/**
 * Character Extraction
 *
 * Class String menyediakan beberapa cara untuk mengambil karakter dari sebuah objek String.
 * Walaupun isi string tidak bisa diakses langsung seperti array (s[0]), banyak method String menggunakan index (offset).
 *
 * Sama seperti array:
 * index dimulai dari 0
 *
 * charAt()
 * Untuk mengambil 1 karakter, gunakan:
 *
 * char charAt(int where)
 * where = index karakter
 * harus ≥ 0 dan dalam range string
 *
 * Contoh:
 * char ch;
 * ch = "abc".charAt(1);
 * ch = 'b'
 *
 * getChars()
 * Untuk mengambil beberapa karakter sekaligus:
 * void getChars(int sourceStart, int sourceEnd, char target[], int targetStart)
 *
 * Penjelasan:
 * sourceStart → index awal
 * sourceEnd → 1 index setelah akhir (exclusive)
 * target[] → array tujuan
 * targetStart → mulai masuk ke index berapa di array target
 *
 * getBytes()
 * Alternatif dari getChars():
 * byte[] getBytes()
 *
 * mengubah string jadi array byte
 * pakai encoding default
 *
 * Biasanya dipakai untuk:
 * network
 * file
 * sistem non-Unicode
 *
 * toCharArray()
 * Untuk ubah seluruh string jadi array char:
 * char[] toCharArray()
 *
 * lebih simpel daripada getChars()
 *
 * --------------------------------------
 * 
 * Penjelasan Mendalam
 *
 * 1. Kenapa gak bisa s[0]?
 * Di Java:
 * String s = "abc";
 * s[0]; // ERROR
 *
 * karena String = object, bukan array
 *
 * 2. charAt() = cara paling dasar
 * char c = s.charAt(0);
 *
 * ambil 1 karakter
 *
 * Error kalau out of range:
 * s.charAt(10); // StringIndexOutOfBoundsException
 *
 * 3. getChars() = slicing manual
 * Mirip:
 * substring → tapi ke array
 * s.getChars(10, 14, buf, 0);
 *
 * ambil:
 * index 10 sampai 13 (14 tidak ikut)
 *
 * 4. sourceEnd itu exclusive
 *
 * Ini penting:
 * (10, 14)
 *
 * berarti:
 * 10, 11, 12, 13
 *
 * 5. getBytes() (BACKEND BANGET)
 * byte[] data = s.getBytes();
 *
 * dipakai untuk:
 * kirim data ke API
 * simpan file
 * komunikasi network
 *
 * masalah:
 * encoding default bisa beda
 *
 * 6. toCharArray() = shortcut
 * Daripada:
 * getChars(...)
 *
 * cukup:
 * char[] arr = s.toCharArray();
 *
 * 7. Perbandingan
 * Method	            Fungsi
 * charAt	            ambil 1 char
 * getChars	            ambil sebagian ke array
 * getBytes	            ubah ke byte[]
 * toCharArray	        ubah semua ke char[]
 *
 * Kesimpulan Simpel
 * String gak bisa diakses pakai [index]
 * pakai method
 * charAt() → ambil 1 karakter
 * getChars() → ambil sebagian
 * getBytes() → ubah ke byte[]
 * toCharArray() → ubah ke char[]
 *
 * Insight Backend (INI REAL BANGET)
 *
 * Parsing data
 * if (s.charAt(0) == '{') {
 *     // JSON
 * }
 * 
 * Validasi input
 * for (char c : s.toCharArray()) {
 *     if (!Character.isDigit(c)) {
 *         // invalid
 *     }
 * }
 * 
 * Network / File
 * byte[] data = s.getBytes(StandardCharsets.UTF_8);
 * Performance trick
 *
 * Loop karakter:
 * char[] arr = s.toCharArray();
 * lebih cepat daripada charAt() berulang
 *
 * INTI DALAM
 * String itu immutable → gak bisa akses langsung
 * Java kasih method untuk “ngintip” isi string
 *
 * Pilih method sesuai kebutuhan:
 * 1 char → charAt
 * banyak → toCharArray
 * byte → getBytes
 */

public class CharacterExtraction {
    public static void main(String[] args) {

        // 1. charAt()
        String string1 = "abc";
        // Ambil karakter di index 1
        char char1 = string1.charAt(1);
        System.out.println(char1);

        // Penjelasan:
        // index 1 = 'b'

        System.out.println();

        // 2. getChars()
        String string2 = "This is a demo of the getChars method.";
        int start = 10;
        int end = 14;

        // Buat array penampung
        char char2[] = new char[end - start];
        // Copy karakter dari string ke array
        string2.getChars(start, end, char2, 0);
        // Cetak hasil
        System.out.println(char2);

        // Penjelasan:
        // mengambil substring "demo"

        System.out.println();

        // 3. getBytes()

        String string3 = "Hello";
        // Convert ke byte array
        byte[] data = string3.getBytes();
        // Print byte satu-satu
        for (byte b : data) {
            System.out.print(b + " ");
        }

        // Penjelasan:
        // H = 72, e = 101, dll

        System.out.println();

        // 4. toCharArray()

        String string4 = "Java";
        // Convert ke char array
        char[] char3 = string4.toCharArray();
        // Print tiap karakter
        for (char c : char3) {
            System.out.print(c);
        }

        // Penjelasan:
        // Memecah string jadi karakter satu per satu


    }
}
