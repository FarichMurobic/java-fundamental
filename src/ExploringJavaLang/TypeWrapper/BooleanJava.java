package ExploringJavaLang.TypeWrapper;

/**
 * Apa itu Boolean?
 * Boolean adalah wrapper sederhana untuk tipe boolean (true / false).
 *
 * Biasanya dipakai kalau:
 * butuh object (misalnya di Collection)
 * atau mau “pass by reference style”
 *
 * Konstanta penting
 * Konstanta	    Deskripsi
 * TRUE	            object Boolean true
 * FALSE	        object Boolean false
 * TYPE	            Class object untuk boolean
 *
 * Kenapa Boolean itu “thin wrapper”?
 *
 * Karena:
 * cuma bungkus true/false
 * gak banyak logic kompleks
 *
 * Kapan dipakai?
 *
 * Primitive:
 * boolean flag = true;
 *
 * Wrapper:
 * Boolean flag = Boolean.TRUE;
 *
 * dipakai kalau:
 * masuk ke List<Boolean>
 * return object
 * nullable (bisa null)
 *
 * Ini method buat handle Unicode 32-bit (emoji dll)
 * Method	                                        Deskripsi
 * charCount(int cp)	                                Return 1 kalau cukup 1 char, 2 kalau butuh 2 char
 * codePointAt(CharSequence, int loc)	                Ambil code point di posisi tertentu
 * codePointAt(char[], int loc)	                        Sama tapi dari array
 * codePointBefore(CharSequence, int loc)	        Ambil code point sebelum posisi
 * codePointBefore(char[], int loc)	                Versi array
 * isBmpCodePoint(int cp)	                        true jika di range BMP (0–FFFF)
 * isHighSurrogate(char ch)	                        true jika high surrogate
 * isLowSurrogate(char ch)	                        true jika low surrogate
 * isSupplementaryCodePoint(int cp)	                true jika karakter > FFFF
 * isSurrogatePair(char high, char low)	                true jika pasangan valid
 * isValidCodePoint(int cp)	                        true jika code point valid
 * toChars(int cp)	                                convert code point ke char[]
 * toChars(int cp, char[], int loc)	                simpan hasil ke array
 * toCodePoint(char high, char low)	                convert surrogate → code point
 *
 * Method	                                        Deskripsi
 * booleanValue()	                                Mengembalikan nilai boolean dari object
 * compare(boolean b1, boolean b2)	                Bandingkan dua boolean (true > false)
 * compareTo(Boolean b)	                                Bandingkan object Boolean
 * equals(Object obj)	                                true jika nilainya sama
 * getBoolean(String propertyName)	                Ambil nilai boolean dari system property
 * hashCode()	                                        Menghasilkan hash code
 * hashCode(boolean val)	                        Hash code dari boolean
 * logicalAnd(op1, op2)	                                Operasi AND
 * logicalOr(op1, op2)	                                Operasi OR
 * logicalXor(op1, op2)	                                Operasi XOR
 * parseBoolean(String str)	                        true jika "true"
 * toString()	                                        Convert ke string
 * toString(boolean val)	                        Convert boolean ke string
 * valueOf(boolean val)	                                Convert ke object Boolean
 * valueOf(String str)	                                true jika "true"
 *
 * 1. compare() & compareTo()
 * Aturan:
 * true > false
 *
 * Contoh:
 * Boolean.compare(true, false); // positif
 * Boolean.compare(false, true); // negatif
 *
 * 2. parseBoolean() vs valueOf()
 * Method	        Return
 * parseBoolean()	primitive boolean
 * valueOf()	    object Boolean
 *
 * 3. Logical method (JDK 8)
 * Ini alternatif dari:
 * &&, ||, ^
 *
 * getBoolean() (HATI-HATI)
 * Boolean.getBoolean("myProp");
 * ini bukan parsing string biasa
 * ini baca:
 * System Property
 *
 * sering bikin salah paham!
 *
 * KESIMPULAN SEDERHANA
 *
 * Intinya:
 * Boolean punya method untuk:
 * compare
 * parsing
 * logical operation
 *
 * WAJIB LO INGAT:
 * parseBoolean() → string → boolean
 * valueOf() → string → Boolean object
 * compare() → true > false
 * logicalAnd/Or/Xor() → alternatif operator
 */

public class BooleanJava {
    public static void main(String[] args) {

        Boolean b1 = true;
        Boolean b2 = Boolean.valueOf("true");
        Boolean b3 = Boolean.valueOf("false");
        Boolean b4 = Boolean.valueOf("random");

        System.out.println("b1: " + b1); // true
        System.out.println("b2: " + b2); // true
        System.out.println("b3: " + b3); // false
        System.out.println("b4: " + b4); // false

        // KONSTANTA
        Boolean boolean1 = Boolean.TRUE;
        Boolean boolean2 = Boolean.FALSE;

        System.out.println("TRUE: " + boolean1); // true
        System.out.println("FALSE: " + boolean2); // false

        // CONTOH KODE UNICODE (PENTING BANGET)
        int cp = 0x1F600; // 😀 emoji
        // CEK TYPE
        System.out.println("Is valid: " +
                Character.isValidCodePoint(cp)); // Is valid: true
        System.out.println("Is supplementary: " +
                Character.isSupplementaryCodePoint(cp)); // Is supplementary: true

        // CONVERT KE CHAR[]
        char[] chars = Character.toChars(cp);
        System.out.println("Jumlah char: " + chars.length); // Jumlah char: 2

        // BALIK KE CODE POINT
        int result = Character.toCodePoint(chars[0], chars[1]);
        System.out.println("Back to code point: " + result); // Back to code point: 128512

        System.out.println("-----------------------------");

        // booleanValue()
        Boolean b = Boolean.TRUE;
        System.out.println("booleanValue: " + b.booleanValue()); // true

        // compare()
        System.out.println("compare(true, false): " +
                Boolean.compare(true, false)); // 1

        // compareTo()
        System.out.println("compareTo: " +
                Boolean.TRUE.compareTo(Boolean.FALSE)); // 1

        // equals()
        System.out.println("equals: " +
                Boolean.TRUE.equals(Boolean.TRUE)); // true

        // parseBoolean()
        boolean p = Boolean.parseBoolean("true");
        System.out.println("parseBoolean: " + p); // true

        // valueOf()
        Boolean v = Boolean.valueOf("true"); // true
        System.out.println("valueOf: " + v);

        // logical operations
        System.out.println("AND: " +
                Boolean.logicalAnd(true, false)); // false

        System.out.println("OR: " +
                Boolean.logicalOr(true, false)); // true

        System.out.println("XOR: " +
                Boolean.logicalXor(true, false)); // true

        // toString()
        System.out.println("toString: " +
                Boolean.toString(true)); // true

        // hashCode()
        System.out.println("hashCode: " +
                Boolean.hashCode(true)); // 1231

    }
}
