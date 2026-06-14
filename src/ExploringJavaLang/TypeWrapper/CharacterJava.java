package ExploringJavaLang.TypeWrapper;

/**
 * Apa itu Character?
 * Character adalah wrapper sederhana untuk tipe char.
 *
 * DEPRACTED! USANG
 * Constructor:
 * Character(char ch)
 * ch = karakter yang mau dibungkus
 *
 * Ambil nilai char
 * char charValue()
 *
 * Mengembalikan nilai char dari object
 *
 * Konstanta penting
 * Konstanta	    Deskripsi
 * BYTES	        Ukuran char dalam byte
 * MAX_RADIX	    Basis terbesar
 * MIN_RADIX	    Basis terkecil
 * MAX_VALUE	    Nilai char terbesar
 * MIN_VALUE	    Nilai char terkecil
 * TYPE	Class       object untuk char
 *
 * Fungsi utama Character
 *
 * Buat:
 * validasi input
 * parsing manual string
 * cek tipe karakter
 *
 * Method penting (WAJIB HAFAL)
 * Method	            Fungsi
 * isDigit()	        cek angka
 * isLetter()	        cek huruf
 * isLetterOrDigit()	huruf / angka
 * isUpperCase()	    huruf besar
 * isLowerCase()	    huruf kecil
 * isWhitespace()	    spasi
 *
 * TABEL METHOD
 * Method	                                Deskripsi
 * isDefined(char ch)	                    true jika ada di Unicode
 * isDigit(char ch)	                        true jika angka
 * isIdentifierIgnorable(char ch)	        true jika diabaikan dalam identifier
 * isISOControl(char ch)	                true jika karakter kontrol
 * isJavaIdentifierPart(char ch)	        valid sebagai bagian nama variable
 * isJavaIdentifierStart(char ch)	        valid sebagai awal nama variable
 * isLetter(char ch)	                    true jika huruf
 * isLetterOrDigit(char ch)	                huruf atau angka
 * isLowerCase(char ch)	                    huruf kecil
 * isUpperCase(char ch)	                    huruf besar
 * isWhitespace(char ch)	                spasi
 * isSpaceChar(char ch)	                    karakter spasi Unicode
 * isTitleCase(char ch)	                    huruf TitleCase
 * isUnicodeIdentifierPart(char ch)	        bagian identifier Unicode
 * isUnicodeIdentifierStart(char ch)	    awal identifier Unicode
 * isMirrored(char ch)	                    karakter mirror (RTL text)
 * toLowerCase(char ch)	                    ke huruf kecil
 * toUpperCase(char ch)	                    ke huruf besar
 * toTitleCase(char ch)	                    ke TitleCase
 *
 * Konversi digit ↔ angka
 * forDigit()
 * char c = Character.forDigit(10, 16);
 * hasil:
 * a
 *
 * digit()
 * int x = Character.digit('A', 16);
 * hasil:
 * 10
 *
 * KESIMPULAN SEDERHANA
 * Intinya:
 * Character = wrapper untuk char
 * Dipakai buat cek & manipulasi karakter
 *
 * WAJIB LO INGAT:
 * isDigit() → angka
 * isLetter() → huruf
 * isWhitespace() → spasi
 * toUpperCase() / toLowerCase()
 * digit() & forDigit()
 *
 * REAL TALK
 * Di backend:
 * dipakai buat:
 * validasi input user
 * parsing string manual
 * filter karakter
 *
 * Kesalahan umum:
 * lupa cek digit sebelum parse
 * salah handling huruf besar/kecil
 */

/**
 * Penambahan pada Character untuk Unicode
 * Baru-baru ini (sejak JDK 5), class Character ditingkatkan untuk mendukung Unicode 32-bit.
 *
 * Dulu vs Sekarang
 * Dulu:
 * char = 16-bit
 * Range:
 * 0 sampai FFFF
 *
 * semua karakter muat di 1 char
 *
 * Sekarang:
 * Unicode berkembang → butuh lebih banyak karakter
 * Range sekarang:
 * 0 sampai 10FFFF
 *
 *
 * KONSEP PENTING (WAJIB LO PAHAM)
 * 1. Code Point
 * Code point = representasi angka dari karakter
 *
 * Contoh:
 * 'A' = 65
 *
 * Range:
 * 0 sampai 10FFFF
 *
 * 2. BMP (Basic Multilingual Plane)
 * Range:
 * 0 sampai FFFF
 *
 * ini masih bisa ditampung oleh:
 * char
 *
 * 3. Supplemental Character
 * Karakter di atas:
 * FFFF
 * TIDAK muat di char
 *
 * MASALAH BESAR DI JAVA
 * char c;
 * cuma 16-bit
 * gak bisa nampung karakter Unicode baru
 *
 * SOLUSI JAVA
 *
 * 1. Pakai 2 char (SURROGATE PAIR)
 *
 * Jenis	        Fungsi
 * High surrogate	bagian pertama
 * Low surrogate	bagian kedua
 *
 * Jadi 1 karakter = 2 char
 *
 * 2. Pakai int untuk code point
 * karena:
 * int
 *
 * cukup besar untuk:
 * 0 sampai 10FFFF
 *
 * METHOD BARU (OVERLOAD)
 * Sekarang method Character ada versi:
 * Versi lama (char)
 * Character.isDigit('5');
 *
 * Versi baru (int code point)
 * Character.isDigit(53);
 *
 * Contoh method
 * Method	                Deskripsi
 * isDigit(int cp)	        cek digit
 * isLetter(int cp)	        cek huruf
 * toLowerCase(int cp)	    ke huruf kecil
 */

public class CharacterJava {
    public static void main(String[] args) {

        // Array karakter
        char a[] = {'a', 'b', '5', '?', 'A', ' '};

        for (int i = 0; i < a.length; i++) {
            // Cek apakah digit
            if (Character.isDigit(a[i]))
                System.out.println(a[i] + " adalah digit.");

            // Cek huruf
            if (Character.isLetter(a[i]))
                System.out.println(a[i] + " adalah huruf.");

            // Cek spasi
            if (Character.isWhitespace(a[i]))
                System.out.println(a[i] + " adalah space.");

            // Cek huruf besar
            if (Character.isUpperCase(a[i]))
                System.out.println(a[i] + " huruf besar.");

            // Cek huruf kecil
            if (Character.isLowerCase(a[i]))
                System.out.println(a[i] + " huruf kecil.");
        }

        System.out.println("------------------");

        char c = 'a';

        // Konversi case
        System.out.println(Character.toLowerCase(c)); // a
        System.out.println(Character.toUpperCase(c)); // A

        // Cek tipe
        System.out.println(Character.isDigit(c)); // false
        System.out.println(Character.isLetter(c)); // true

        // Digit conversion
        System.out.println(Character.forDigit(c, 16));
        System.out.println(Character.digit(c,16)); // 10


        System.out.println("------------------------");

        // CHAR NORMAL (BMP)
        char char1 = 'A';

        System.out.println("Char: " + char1); // A
        System.out.println("is letter: " + Character.isLetter(char1)); // true

        // CODE POINT
        int codePoint = 65; // 'A'
        System.out.println("Code point: " + codePoint); // 65
        System.out.println("is letter (int): " + Character.isLetter(codePoint)); // true

        // SUPPLEMENTAL CHARACTER
        int smiley = 0x1f600; // 😀

        // Convert ke String
        String string = new String(Character.toChars(smiley));

        System.out.println("Emoji: " + string); // 😀
        System.out.println("Code point: " + smiley); // 128512

        /**
         * Kenapa emoji butuh 2 char?
         * Contoh:
         * 😀 = 0x1F600
         *
         * lebih besar dari:
         * FFFF
         *
         * jadi:
         * butuh 2 char
         *
         * Kenapa Java pakai int?
         * Karena:
         * int
         *
         * bisa simpan:
         * seluruh Unicode
         *
         * CONTOH REAL PROBLEM
         * Salah (pakai char)
         * char c = '😀'; // ERROR / aneh
         *
         * Benar
         * int cp = 0x1F600;
         * String s = new String(Character.toChars(cp));
         *
         * KESIMPULAN SEDERHANA
         *
         * Intinya:
         * Unicode sekarang > 16-bit
         * char gak cukup
         * Java pakai:
         * 2 char (surrogate pair)
         * atau int (code point)
         *
         * WAJIB LO INGAT:
         * char = 16-bit
         * Unicode sekarang = 21-bit
         * int dipakai untuk semua karakter
         * emoji = butuh 2 char
         */


    }
}
