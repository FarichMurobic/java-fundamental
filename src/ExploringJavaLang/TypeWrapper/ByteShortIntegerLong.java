package ExploringJavaLang.TypeWrapper;

/**
 * Byte, Short, Integer, dan Long
 *
 * Class:
 * Byte
 * Short
 * Integer
 * Long
 *
 * adalah wrapper untuk tipe:
 * byte
 * short
 * int
 * long
 *
 * DEPRACTED (SUDAH USANG SEJAK JAVA VERSI 9)
 * Constructor
 * Class	            Constructor	            Deskripsi
 * Byte	                Byte(byte num)	        Dari nilai byte
 * Byte	                Byte(String str)	    Dari string
 * Short	            Short(short num)	    Dari nilai short
 * Short	            Short(String str)	    Dari string
 * Integer	            Integer(int num)	    Dari nilai int
 * Integer	            Integer(String str)	    Dari string
 * Long	                Long(long num)	        Dari nilai long
 * Long	                Long(String str)	    Dari string
 *
 * Intinya:
 * Semua wrapper ini bisa dibuat dari:
 * angka langsung
 * string angka
 *
 * PENJELASAN DALAM
 * Fungsi utama class ini:
 * Bungkus primitive jadi object
 * Parsing string → angka
 * Konversi angka → string
 *
 * Support berbagai basis angka (radix)
 * Radix (INI PENTING BANGET)
 * Radix	Sistem
 * 2	    Binary
 * 8	    Oktal
 * 10	    Desimal
 * 16	    Hexadecimal
 *
 * Contoh:
 * Integer.parseInt("1010", 2); // binary → decimal
 * hasil: 10
 *
 * CONSTANTS (SEMUA CLASS INI PUNYA)
 * Constant	        Deskripsi
 * BYTES	        Ukuran dalam byte
 * SIZE	            Ukuran dalam bit
 * MIN_VALUE	    Nilai minimum
 * MAX_VALUE	    Nilai maksimum
 * TYPE	            Class object
 *
 * Contoh:
 * System.out.println(Integer.MAX_VALUE);
 *
 * METHOD UTAMA (DIGENERALISASI)
 * Parsing & Conversion
 * Method	                    Deskripsi
 * parseInt(String)	            String → int
 * parseInt(String, radix)	    String → int (dengan basis)
 * parseLong(String)	        String → long
 * valueOf(String)	            String → object
 * toString(int)	            int → String
 *
 * Comparison
 * Method	            Deskripsi
 * compare(a, b)	    Bandingkan 2 angka
 * compareTo()	        Bandingkan object
 * equals()	            Cek kesamaan
 *
 * Conversion antar tipe
 * Method	        Deskripsi
 * intValue()	    jadi int
 * longValue()	    jadi long
 * byteValue()	    jadi byte
 * shortValue()	    jadi short
 *
 * Utility (JDK 8+)
 * Method	    Deskripsi
 * sum(a, b)	Penjumlahan
 * max(a, b)	Nilai terbesar
 * min(a, b)	Nilai terkecil
 *
 * ERROR YANG SERING TERJADI
 * Integer.parseInt("abc"); // NumberFormatException
 *
 * Solusi aman:
 * try {
 *     int x = Integer.parseInt("abc");
 * } catch (NumberFormatException e) {
 *     System.out.println("Input bukan angka!");
 * }
 *
 * Ini dipakai di:
 * Request parameter (?id=10)
 * JSON parsing
 * Database mapping
 * Validation
 *
 * Best Practice penting
 * Jangan pakai constructor (deprecated style)
 * new Integer(10); // 
 * Pakai ini:
 * Integer.valueOf(10); // 
 *
 * KESIMPULAN SEDERHANA
 *
 * Intinya:
 * Byte, Short, Integer, Long = wrapper angka bulat
 * Bisa dibuat dari:
 * angka
 * string
 *
 * Yang WAJIB lo inget:
 * Bisa parsing string
 * Support radix (binary, hex, dll)
 * Punya constant penting
 * Bisa error kalau parsing gagal
 *
 * REAL TALK
 * Kalau lo jadi backend dev:
 * Integer & Long = paling sering dipakai
 * ID database
 * pagination
 * request param
 */

/**
 * TABEL LENGKAP METHOD Byte (Table 17-3)
 * Method	                                            Deskripsi
 * byte byteValue()	                                    Mengembalikan nilai object sebagai tipe byte
 * static int compare(byte num1, byte num2)	            Membandingkan dua nilai byte. Return: 0 jika sama, negatif jika num1 < num2, positif jika num1 > num2
 * int compareTo(Byte b)	                            Membandingkan nilai object dengan object b. Return: 0 (sama), negatif (lebih kecil), positif (lebih besar)
 * static Byte decode(String str)	                    Mengubah string menjadi object Byte. Mendukung format angka seperti desimal, hexa (0x), dll
 * double doubleValue()	                                Mengubah nilai object menjadi double
 * boolean equals(Object ByteObj)	                    Mengembalikan true jika nilai sama dengan object lain
 * float floatValue()	                                Mengubah nilai object menjadi float
 * int hashCode()	                                    Menghasilkan hash code dari object
 * static int hashCode(byte num)	                    Menghasilkan hash code dari nilai byte (JDK 8+)
 * int intValue()	                                    Mengubah nilai object menjadi int
 * long longValue()	                                    Mengubah nilai object menjadi long
 * static byte parseByte(String str)	                Mengubah string menjadi byte (basis 10)
 * static byte parseByte(String str, int radix)	        Mengubah string menjadi byte dengan basis tertentu (binary, hex, dll)
 * short shortValue()	                                Mengubah nilai object menjadi short
 * String toString()	                                Mengubah object menjadi string
 * static String toString(byte num)	                    Mengubah nilai byte menjadi string
 * static int toUnsignedInt(byte val)	                Mengubah byte ke int tanpa tanda (unsigned)
 * static long toUnsignedLong(byte val)	                Mengubah byte ke long tanpa tanda
 * static Byte valueOf(byte num)	                    Membuat object Byte dari nilai byte
 * static Byte valueOf(String str)	                    Membuat object Byte dari string
 * static Byte valueOf(String str, int radix)	        Membuat object Byte dari string dengan basis tertentu
 *
 * Method paling sering dipakai di dunia nyata
 * Parsing (WAJIB)
 * byte x = Byte.parseByte("10");
 * valueOf (LEBIH MODERN)
 * Byte x = Byte.valueOf("10");
 * compare (buat sorting / logic)
 * Byte.compare((byte)5, (byte)10);
 *
 * decode() (jarang tapi powerful)
 * Byte b = Byte.decode("0xA"); // hex → 10
 * Bisa handle:
 * 0x → hex
 * 0 → octal
 * normal → decimal
 *
 * UNSIGNED (INI ADVANCED)
 * Java byte itu:
 * -128 sampai 127
 *
 * Tapi kadang butuh:
 * 0 sampai 255
 *
 * pakai:
 * int x = Byte.toUnsignedInt((byte)-1);
 *
 * hasil:
 * 255
 */

/**
 * TABEL LENGKAP METHOD Short
 * Method	                                                    Deskripsi
 * byte byteValue()	                                            Mengembalikan nilai object sebagai byte
 * static int compare(short num1, short num2)	                Membandingkan dua nilai short. Return: 0 (sama), negatif (num1 < num2), positif (num1 > num2)
 * int compareTo(Short s)	                                    Membandingkan nilai object dengan object s
 * static Short decode(String str)	                            Mengubah string menjadi object Short (support hex, octal, dll)
 * double doubleValue()	                                        Mengubah nilai object menjadi double
 * boolean equals(Object ShortObj)	                            Mengembalikan true jika nilai sama
 * float floatValue()	                                        Mengubah nilai object menjadi float
 * int hashCode()	                                            Menghasilkan hash code dari object
 * static int hashCode(short num)	                            Menghasilkan hash code dari nilai short (JDK 8+)
 * int intValue()	                                            Mengubah nilai object menjadi int
 * long longValue()	                                            Mengubah nilai object menjadi long
 * static short parseShort(String str)	                        Mengubah string menjadi short (basis 10)
 * static short parseShort(String str, int radix)	            Mengubah string menjadi short dengan basis tertentu
 * static short reverseBytes(short num)	                        Membalik urutan byte (high & low byte ditukar)
 * short shortValue()	                                        Mengembalikan nilai sebagai short
 * String toString()	                                        Mengubah object menjadi string
 * static String toString(short num)	                        Mengubah nilai short menjadi string
 * static int toUnsignedInt(short val)	                        Mengubah short ke int tanpa tanda (unsigned)
 * static long toUnsignedLong(short val)	                    Mengubah short ke long tanpa tanda
 * static Short valueOf(short num)	                            Membuat object Short dari nilai
 * static Short valueOf(String str)	                            Membuat object Short dari string
 * static Short valueOf(String str, int radix)	                Membuat object Short dari string dengan basis tertentu
 *
 * 1. Short itu apa?
 *
 * Wrapper untuk:
 * short (-32,768 sampai 32,767)
 *
 * Lebih besar dari byte, lebih kecil dari int
 */

/**
 * TABEL LENGKAP METHOD Integer (Table 17-5)
 * Method	                                                            Deskripsi
 * static int bitCount(int num)	                                        Menghitung jumlah bit bernilai 1 dalam num
 * byte byteValue()	                                                    Mengubah nilai object menjadi byte
 * static int compare(int num1, int num2)	                            Membandingkan dua nilai int
 * int compareTo(Integer i)	                                            Membandingkan object dengan object lain
 * static int compareUnsigned(int num1, int num2)	                    Membandingkan tanpa tanda (unsigned)
 * static Integer decode(String str)	                                Mengubah string menjadi Integer (support hex, dll)
 * static int divideUnsigned(int dividend, int divisor)	                Pembagian unsigned
 * double doubleValue()	                                                Konversi ke double
 * boolean equals(Object obj)	                                        Cek kesamaan
 * float floatValue()	                                                Konversi ke float
 * static Integer getInteger(String propertyName)	                    Ambil nilai dari system property
 * static Integer getInteger(String propertyName, int default)	        Ambil property, fallback ke default
 * static Integer getInteger(String propertyName, Integer default)	    Sama seperti di atas (object)
 * int hashCode()	                                                    Hash dari object
 * static int hashCode(int num)	                                        Hash dari nilai
 * static int highestOneBit(int num)	                                Ambil bit 1 paling kiri
 * int intValue()	                                                    Ambil nilai int
 * long longValue()	                                                    Konversi ke long
 * static int lowestOneBit(int num)	                                    Ambil bit 1 paling kanan
 * static int max(int a, int b)	                                        Nilai terbesar
 * static int min(int a, int b)	                                        Nilai terkecil
 * static int numberOfLeadingZeros(int num)	                            Hitung nol di depan (bit kiri)
 *
 * Bagian 2
 * Method	                                                            Deskripsi
 * static int numberOfTrailingZeros(int num)	                        Hitung nol di belakang (bit kanan)
 * static int parseInt(String str)	                                    String → int
 * static int parseInt(String str, int radix)	                        String → int dengan basis
 * static int parseUnsignedInt(String str)	                            String → unsigned int
 * static int parseUnsignedInt(String str, int radix)	                String → unsigned int (basis tertentu)
 * static int remainderUnsigned(int a, int b)	                        Sisa pembagian unsigned
 * static int reverse(int num)	                                        Membalik semua bit
 * static int reverseBytes(int num)	                                    Membalik byte
 * static int rotateLeft(int num, int n)	                            Rotasi bit ke kiri
 * static int rotateRight(int num, int n)	                            Rotasi bit ke kanan
 * short shortValue()	                                                Konversi ke short
 * static int signum(int num)	                                        -1 (negatif), 0, 1 (positif)
 * static int sum(int a, int b)	                                        Penjumlahan
 * static String toBinaryString(int num)	                            int → binary
 * static String toHexString(int num)	                                int → hex
 * static String toOctalString(int num)	                                int → octal
 * String toString()	                                                object → string
 * static String toString(int num)	                                    int → string
 * static String toString(int num, int radix)	                        int → string (basis tertentu)
 * static long toUnsignedLong(int val)	                                int → unsigned long
 * static String toUnsignedString(int val)	                            int → string unsigned
 * static String toUnsignedString(int val, int radix)	                int → string unsigned (basis)
 * static Integer valueOf(int num)	                                    int → Integer
 * static Integer valueOf(String str)	                                String → Integer
 * static Integer valueOf(String str, int radix)	                    String → Integer (basis tertentu)
 *
 * KESIMPULAN SEDERHANA
 * Intinya:
 * Integer = wrapper paling penting
 * Punya:
 * parsing
 * conversion
 * bit operation
 * unsigned support
 *
 * WAJIB LO INGAT:
 * parseInt() → paling sering
 * valueOf() → best practice
 * toString() → convert
 * bitCount() → bit logic
 * toBinaryString() → debugging
 */

/**
 * TABEL LENGKAP METHOD Long
 * Method	                                                        Deskripsi
 * static int bitCount(long num)	                                Menghitung jumlah bit bernilai 1 dalam num
 * byte byteValue()	                                                Mengubah nilai object menjadi byte
 * static int compare(long num1, long num2)	                        Membandingkan dua nilai long
 * int compareTo(Long l)	                                        Membandingkan object dengan object lain
 * static int compareUnsigned(long num1, long num2)	                Membandingkan tanpa tanda (unsigned)
 * static Long decode(String str)	                                Mengubah string menjadi object Long (support hex, dll)
 * static long divideUnsigned(long dividend, long divisor)	        Pembagian unsigned
 * double doubleValue()	                                            Konversi ke double
 * boolean equals(Object obj)	                                    Cek kesamaan
 * float floatValue()	                                            Konversi ke float
 * static Long getLong(String propertyName)	                        Ambil nilai dari system property
 * static Long getLong(String propertyName, long default)	        Ambil property, fallback ke default
 * static Long getLong(String propertyName, Long default)	        Versi object
 * int hashCode()	                                                Hash dari object
 * static int hashCode(long num)	                                Hash dari nilai
 * static long highestOneBit(long num)	                            Ambil bit 1 paling kiri
 * int intValue()	                                                Konversi ke int
 * long longValue()	                                                Ambil nilai long
 * static long lowestOneBit(long num)	                            Ambil bit 1 paling kanan
 * static long max(long a, long b)	                                Nilai terbesar
 * static long min(long a, long b)	                                Nilai terkecil
 * static int numberOfLeadingZeros(long num)	                    Hitung nol di depan (bit kiri)
 * static int numberOfTrailingZeros(long num)	                    Hitung nol di belakang (bit kanan)
 * static long parseLong(String str)	                            String → long
 * static long parseLong(String str, int radix)	                    String → long (basis tertentu)
 * static long parseUnsignedLong(String str)	                    String → unsigned long
 * static long parseUnsignedLong(String str, int radix)	            String → unsigned long (basis)
 * static long remainderUnsigned(long a, long b)	                Sisa pembagian unsigned
 * static long reverse(long num)	                                Membalik semua bit
 * static long reverseBytes(long num)	                            Membalik byte
 * static long rotateLeft(long num, int n)	                        Rotasi bit ke kiri
 * static long rotateRight(long num, int n)	                        Rotasi bit ke kanan
 * short shortValue()	                                            Konversi ke short
 * static int signum(long num)	                                    -1 (negatif), 0, 1 (positif)
 * static long sum(long a, long b)	                                Penjumlahan
 * static String toBinaryString(long num)	                        long → binary
 * static String toHexString(long num)	                            long → hex
 * static String toOctalString(long num)	                        long → octal
 * String toString()	                                            object → string
 * static String toString(long num)	                                long → string
 * static String toString(long num, int radix)	                    long → string (basis tertentu)
 * static String toUnsignedString(long val)	                        long → string unsigned
 * static String toUnsignedString(long val, int radix)	            long → string unsigned (basis)
 * static Long valueOf(long num)	                                long → Long
 * static Long valueOf(String str)	                                String → Long
 * static Long valueOf(String str, int radix)	                    String → Long (basis tertentu)
 *
 * Long itu apa?
 * Wrapper untuk:
 * long (-2^63 sampai 2^63-1)
 *
 * Dipakai kalau:
 * Integer gak cukup besar
 * ID besar (database, timestamp, dll)
 */

public class ByteShortIntegerLong {
    public static void main(String[] args) {

        // 'Integer(java.lang.String)' is deprecated since version 9 and marked for removal
        // Integer integer1 = new Integer("holla");
        // Integer integer2 = new Integer(20);

        Integer integer1 = 200;
        Integer integer2 = Integer.parseInt("200");

        System.out.println(integer1); // 200
        System.out.println(integer2); // 200

        int x = Integer.parseInt("200");
        System.out.println(x); // 200

        String input = "123";
        int value = Integer.parseInt(input);
        System.out.println(value);

        // Contoh 2: Radix (INI PENTING BANGET)
        // binary ke decimal
        int binary = Integer.parseInt("1010", 2); // basis 2
        // octal ke decimal
        int octal = Integer.parseInt("12", 8); // basis 8
        // hex ke decimal
        int hexaDecimal = Integer.parseInt("A", 16); // basis 16

        System.out.println("binary 1010: " + binary); // 10
        System.out.println("octal 12: " + octal); // 10
        System.out.println("hexadecimal A: " + hexaDecimal); // 10

        // Contoh 3: Constant
        System.out.println("Integer Max: " + Integer.MAX_VALUE);
        System.out.println("Integer Min: " + Integer.MIN_VALUE);

        System.out.println("Long Max: " + Long.MAX_VALUE);
        System.out.println("Long Min: " + Long.MIN_VALUE);

        // Contoh 4: Utility Method
        int a = 10;
        int b = 20;

        System.out.println("Max: " + Integer.max(a, b)); // 20
        System.out.println("Min: " + Integer.min(a, b)); // 10
        System.out.println("Sum: " + Integer.sum(a, b)); // 30

        System.out.println("----------------------------------");
        // BYTE
        // VALUEOF (buat object)
        Byte byte1 = Byte.valueOf((byte) 10);
        // Dari string
        Byte byte2 = Byte.valueOf("20");

        System.out.println(byte1); // 10
        System.out.println(byte2); // 20

        // PARSE
        byte byteParse = Byte.parseByte("30");
        System.out.println(byteParse); // 30

        // RADIX (binary)
        byte binaryByte = Byte.parseByte("1010", 2); // 10
        System.out.println(binaryByte);

        // COMPARE
        int result = Byte.compare((byte) 5, (byte) 10);
        System.out.println("compare 5 vs 10: " + result); // -5

        // UNSIGNED
        byte negative = -1;
        int unsignedValue = Byte.toUnsignedInt(negative);
        System.out.println("Unsigned dari -1: " + unsignedValue); // 255

        // CONVERSION
        Byte konversion = Byte.valueOf( (byte) 10);
        Byte konversion2 = Byte.valueOf("10");

        System.out.println("ke int: " + konversion.intValue()); // 10
        System.out.println("ke double: " + konversion.doubleValue()); // 10.0

        // EQUALS
        System.out.println(konversion.equals(konversion2)); // true

        /**
         * Case penting:
         * byte b = -1;
         * int x = Byte.toUnsignedInt(b);
         *
         * -1 dalam binary:
         * 11111111
         *
         * dibaca unsigned:
         * 255
         *
         * KESIMPULAN SEDERHANA
         *
         * Intinya:
         * Byte = wrapper untuk byte
         * Bisa:
         * parsing
         * convert
         * compare
         * handle unsigned
         *
         * WAJIB LO INGAT:
         * parseByte() → string → byte
         * valueOf() → best practice
         * compare() → buat logic
         * byte bisa overflow
         * toUnsignedInt() → advanced use
         */

    }
}
