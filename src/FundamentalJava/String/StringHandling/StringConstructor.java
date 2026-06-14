package FundamentalJava.String.StringHandling;

/**
 * The String Constructors
 *
 * Class String mendukung beberapa constructor.
 *
 * Untuk membuat String kosong, gunakan constructor default. Contohnya:
 * String s = new String();
 * Ini akan membuat objek String yang tidak memiliki karakter (kosong).
 *
 * Sering kali, kamu ingin membuat string yang langsung punya nilai awal. Class String menyediakan berbagai constructor untuk itu.
 * Untuk membuat String dari array karakter, gunakan constructor berikut:
 * String(char chars[])
 *
 * Contoh:
 * char chars[] = { 'a', 'b', 'c' };
 * String s = new String(chars);
 *
 * Constructor ini akan menginisialisasi s dengan string "abc".
 *
 * Kamu juga bisa mengambil sebagian dari array karakter sebagai string dengan constructor berikut:
 * String(char chars[], int startIndex, int numChars)
 * startIndex → index mulai
 * numChars → jumlah karakter yang diambil
 *
 * Contoh:
 * char chars[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
 * String s = new String(chars, 2, 3);
 *
 * Ini akan menghasilkan string "cde".
 *
 * Kamu juga bisa membuat String dari String lain:
 * String(String strObj)
 *
 * Contoh:
 *
 * // Construct one String from another.
 * class MakeString {
 *   public static void main(String args[]) {
 *     char c[] = {'J', 'a', 'v', 'a'};
 *     String s1 = new String(c);
 *     String s2 = new String(s1);
 *     System.out.println(s1);
 *     System.out.println(s2);
 *   }
 * }
 *
 * Output:
 * Java
 * Java
 *
 * Artinya s1 dan s2 punya isi yang sama.
 *
 * 1. Kenapa ada banyak constructor?
 * Karena String bisa dibuat dari:
 * kosong
 * array char
 * sebagian array
 * string lain
 *
 * Java kasih fleksibilitas
 *
 * 2. new String() → jarang dipakai
 * String s = new String();
 * ini bikin string kosong ""
 *
 * Tapi di real world:
 * String s = "";
 *
 * lebih simpel + lebih optimal (pakai String Pool)
 *
 * 3. String dari char[]
 * char[] chars = {'a','b','c'};
 * String s = new String(chars);
 *
 * ini penting kalau:
 * lo proses data karakter (parser, tokenizer)
 * atau baca file char-by-char
 *
 * 4. Subrange (INI SERING BANGET DIPAKE LOGIKA)
 * String s = new String(chars, 2, 3);
 *
 * artinya:
 * mulai dari index 2 → 'c'
 * ambil 3 karakter → c d e
 *
 * Ini konsep penting buat:
 * parsing data
 * slicing string
 * backend processing
 *
 * 5. String dari String (Copy)
 * String s2 = new String(s1);
 *
 * Ini tricky:
 * dia bikin object baru
 * tapi isinya sama
 *
 * PERBEDAAN PENTING
 * String s1 = "Java";
 * String s2 = s1;
 *
 * ini TIDAK bikin object baru
 *
 * String s1 = "Java";
 * String s2 = new String(s1);
 *
 * ini bikin object baru di heap
 *
 * 6. Insight penting (Jarang diajarin)
 * Kalau lo pakai:
 * new String("Java");
 *
 * Java bikin 2 object:
 * "Java" di String Pool
 * object baru di heap
 *
 * ini boros
 *
 * Kesimpulan Simpel
 *
 * String punya banyak constructor
 * Bisa dibuat dari:
 *
 * kosong
 * char array
 * sebagian array
 * string lain
 *
 * new String() → jarang dipakai
 * new String("text") → boros memory 
 * Copy constructor bikin object baru (beda reference)
 *
 * Insight Backend (DALAM BANGET)
 * Di dunia backend:
 *
 * Hindari ini:
 * String s = new String("Hello");
 *
 * karena:
 * bikin object extra
 * gak efisien
 *
 * Gunakan ini:
 * String s = "Hello";
 *
 * Case real:
 * parsing request
 * slicing data
 * processing char buffer
 *
 * constructor char[] & subrange itu kepake banget
 */

import java.nio.charset.StandardCharsets;

/**
 * Meskipun tipe char di Java menggunakan 16-bit untuk merepresentasikan karakter Unicode,
 * format string yang umum digunakan di internet biasanya menggunakan array byte 8-bit yang berasal dari karakter ASCII.
 *
 * Karena string berbasis ASCII 8-bit sangat umum, 
 * class String menyediakan constructor yang bisa membuat string dari array byte.
 * 
 * Ada dua bentuk:
 * String(byte chrs[])
 * String(byte chrs[], int startIndex, int numChars)
 *
 * chrs → array byte
 * versi kedua → bisa ambil sebagian array
 *
 * Dalam constructor ini, konversi dari byte ke karakter dilakukan menggunakan default encoding dari platform.
 *
 * Versi lanjutan dari constructor ini memungkinkan kamu menentukan character encoding (misalnya UTF-8),
 * yang menentukan bagaimana byte dikonversi menjadi karakter.
 * Namun, seringnya kamu akan menggunakan encoding default dari sistem.
 *
 * CATATAN:
 * Isi array akan di-copy saat membuat String. 
 * Jika kamu mengubah isi array setelah String dibuat, maka String tidak akan berubah.
 *
 * Kamu juga bisa membuat String dari:
 * StringBuffer
 * StringBuilder
 *
 * Constructor:
 * String(StringBuffer strBufObj)
 * String(StringBuilder strBuildObj)
 *
 * Untuk Unicode yang lebih kompleks:
 * String(int codePoints[], int startIndex, int numChars)
 *
 * codePoints → array Unicode code point
 * String dibuat dari range tertentu
 *
 * Ada juga constructor yang bisa menggunakan Charset.
 *
 * Penjelasan Mendalam
 * 1. char vs byte (INI PENTING BANGET)
 *
 * char di Java:
 * 16-bit (2 byte)
 * pakai Unicode
 * bisa represent banyak bahasa
 *
 * byte:
 * 8-bit
 * biasanya ASCII / raw data
 *
 * Realita di dunia nyata:
 * Data dari:
 * internet (HTTP)
 * file
 * database
 * API
 *
 * biasanya datang sebagai byte[]
 *
 * Kenapa ada constructor dari byte[]?
 * Karena Java sering nerima data kayak:
 *
 * byte[] data = ... // dari network
 *
 * Lo harus ubah ke String:
 * String s = new String(data);
 *
 * Contoh ASCII
 * byte ascii[] = {65, 66, 67};
 *
 * ASCII:
 * 65 = A
 * 66 = B
 * 67 = C
 *
 * Subrange (lagi, ini penting banget)
 * String s2 = new String(ascii, 2, 3);
 *
 * artinya:
 * mulai index 2 → 67 (C)
 * ambil 3 → C D E
 *
 * Encoding (INI LEVEL BACKEND)
 * new String(byteArray);
 *
 * pakai default encoding OS
 *
 * Masalah:
 * beda OS → beda encoding 
 * bisa jadi karakter rusak (mojibake)
 *
 * Best Practice:
 * new String(byteArray, StandardCharsets.UTF_8);
 *
 * ini WAJIB di backend
 *
 * Array di-copy (SUPER PENTING)
 *
 * byte[] data = {65,66,67};
 * String s = new String(data);
 *
 * data[0] = 90;
 *
 * s tetap "ABC", bukan "ZBC"
 *
 * Kenapa?
 * String immutable
 * data di-copy
 *
 * String dari StringBuilder / Buffer
 * StringBuilder sb = new StringBuilder("Hello");
 * String s = new String(sb);
 *
 * bikin snapshot string dari builder
 *
 * CodePoints (Advanced Unicode)
 * int[] codePoints = {65, 66, 67};
 * String s = new String(codePoints, 0, 3);
 *
 * ini buat:
 * emoji
 * karakter kompleks
 * multilingual system
 *
 * Kesimpulan Simpel
 *
 * String bisa dibuat dari byte[]
 * Byte biasanya berasal dari:
 *
 * network
 * file
 * API
 *
 * Default encoding bisa berbahaya 
 * Gunakan UTF-8 untuk aman
 *
 * Array akan di-copy → String tetap immutable
 *
 * Bisa juga dari:
 * StringBuilder
 * StringBuffer
 * codePoints
 *
 * Insight Backend (INI YANG BIKIN LO NAIK LEVEL)
 * Di backend, ini sering banget:
 * InputStream → byte[] → String
 *
 * Kesalahan umum:
 * String s = new String(bytes);
 *
 * bug di encoding
 *
 * Cara benar:
 * String s = new String(bytes, StandardCharsets.UTF_8);
 *
 * Case nyata:
 * parsing JSON dari request
 * baca file upload
 * decode response API
 *
 * Kalau salah encoding:
 * data bisa rusak
 * emoji jadi aneh
 * bahasa non-English hancur
 */ 

public class StringConstructor {
    public static void main(String[] args) {

        // 1. Constructor Kosong

        // Membuat String kosong menggunakan constructor
        String s = new String();
        // Output (akan kosong)
        System.out.println(s);

        // Penjelasan:
        // s berisi string kosong ""
        // Tapi cara ini jarang dipakai di dunia nyata

        // 2. Dari Array Karakter

        // Membuat array karakter
        char chars[] = {'a', 'b', 'c'};
        // Membuat String dari array
        String s1 = new String(chars);
        // Output
        System.out.println(s1);

        // Penjelasan:
        // chars = {'a','b','c'}
        // String akan menjadi "abc"

        // 3. Subrange Array (PENTING)

        // Array karakter
        char chars1[] = {'a','b','c','d','e','f'};
        // Ambil dari index 2 sebanyak 3 karakter
        String s3 = new String(chars1, 2, 3);
        // Output
        System.out.println(s3);

        // Penjelasan:
        // index 2 = 'c'
        // ambil 3 karakter = c d e
        // hasil = "cde"

        // 4. Copy String

        // Array karakter
        char c[] = {'J', 'a', 'v', 'a'};
        // Membuat String dari array
        String s4 = new String(c);
        // Membuat String baru dari String lain
        String s5 = new String(s4);
        // Output
        System.out.println(s4);
        System.out.println(s5);

        // Penjelasan:
        // s1 dan s2 punya isi sama "Java"
        // Tapi mereka adalah object yang berbeda di memory

        System.out.println();

        // 1. Dari byte[]

        // String dari Array byte
        byte ascii[] = {65,66,67,68,69,70};
        String s6 = new String(ascii);
        System.out.println(s6);

        // 2. Subrange byte[]

        // Mulai dari index 2 (C), ambil 3 karakter
        String s7 = new String(ascii, 2, 3);
        System.out.println(s7);

        // Output:
        // ABCDEF
        // CDE

        // 3. Bukti Array Di-Copy

        // Mengubah isi array setelah String dibuat
        ascii[0] = 90; // 90 = Z
        System.out.println(s6);

        // Penjelasan:
        // s6 tetap "ABCDEF"
        // karena data sudah di-copy ke String

        System.out.println();

        // 4. Best Practice Encoding (WAJIB TAU)

        byte[] dataEncoding = {72,101,108,108,111}; // Hello

        // Menggunakan encoding default (tidak disarankan)
        String string1 = new String(dataEncoding);

        // Menggunakan UTF-8 (best practice)
        String string2 = new String(dataEncoding, StandardCharsets.UTF_8);

        System.out.println(string1); // Hello
        System.out.println(string2); // Hello

        // Penjelasan:
        // s2 lebih aman dan konsisten di semua platform

        System.out.println();

        // 5. Dari StringBuilder

        StringBuilder stringBuilder = new StringBuilder("Hello");
        // Membuat String dari StringBuilder
        String string3 = new String(stringBuilder);
        System.out.println(string3);

        // Penjelasan:
        // Membuat object String baru dari builder

    }
}
