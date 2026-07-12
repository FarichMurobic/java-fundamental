package FundamentalJava.Varargs;

/**
 * ------------------------------------------------------------------------
 * OVERLOADING VARARGS METHOD
 * ------------------------------------------------------------------------
 * 
 * Kita bisa melakukan overload pada method yang menggunakan varargs.
 * 
 * Artinya:
 * - Nama method SAMA
 * - Tapi parameter BERBEDA
 * 
 * ------------------------------------------------------------------------
 * CARA OVERLOAD VARARGS
 * ------------------------------------------------------------------------
 * 
 * Cara 1: Beda tipe parameter varargs
 * 
 *     static void test(int ... a) {
 *         System.out.println("int varargs");
 *     }
 * 
 *     static void test(boolean ... a) {
 *         System.out.println("boolean varargs");
 *     }
 * 
 *     // test(1, 2, 3)  → int varargs
 *     // test(true, false) → boolean varargs
 * 
 * Cara 2: Tambah parameter biasa
 * 
 *     static void test(String msg, int ... a) {
 *         System.out.println(msg + " - int varargs");
 *     }
 * 
 *     static void test(int ... a) {
 *         System.out.println("int varargs tanpa msg");
 *     }
 * 
 * ------------------------------------------------------------------------
 * JEBATAN PALING BERBAHAYA
 * ------------------------------------------------------------------------
 * 
 * AMBIGUOUS CALL (panggilan ambigu)
 * 
 *     static void test(int ... a) {
 *         System.out.println("Varargs 1");
 *     }
 * 
 *     static void test(int x, int ... a) {
 *         System.out.println("Varargs 2");
 *     }
 * 
 *     // Panggilan ini:
 *     test(10);  // ERROR! Ambiguous
 * 
 * Java bingung:
 * - test(10) → masuk ke test(int ... a) ?
 * - test(10) → masuk ke test(int x, int ... a) ?
 * 
 * Keduanya valid untuk test(10)!
 * Hasilnya: COMPILE ERROR!
 * 
 * ------------------------------------------------------------------------
 * CONTOH AMBIGUOUS LAIN
 * ------------------------------------------------------------------------
 * 
 *     static void test(int ... a) { }
 *     static void test(int x, int y, int ... a) { }
 * 
 *     test(1, 2); // Ambiguous! Bisa ke kedua method
 * 
 * ------------------------------------------------------------------------
 * VARARGS vs NON-VARARGS
 * ------------------------------------------------------------------------
 * 
 *     static void test(int x) {
 *         System.out.println("Non-varargs");
 *     }
 * 
 *     static void test(int ... x) {
 *         System.out.println("Varargs");
 *     }
 * 
 *     // Panggilan:
 *     test(10);     // ✅ Non-varargs (lebih spesifik)
 *     test(1, 2, 3); // ✅ Varargs
 * 
 * Java akan memilih method yang PALING SPESIFIK.
 * 
 * ------------------------------------------------------------------------
 * PRIORITAS PEMILIHAN METHOD DI JAVA
 * ------------------------------------------------------------------------
 * 
 * Urutan pemilihan method (dari prioritas tertinggi ke terendah):
 * 
 * 1. Exact match (paling spesifik)
 *    test(int x) → test(10) tepat
 * 
 * 2. Overload biasa
 *    test(int x, int y) → test(10, 20)
 * 
 * 3. Varargs (paling terakhir)
 *    test(int ... x) → test(10, 20, 30)
 * 
 * ------------------------------------------------------------------------
 * CONTOH LENGKAP
 * ------------------------------------------------------------------------
 * 
 *     public class VarargsOverload {
 * 
 *         // Non-varargs
 *         static void show(int x) {
 *             System.out.println("show(int): " + x);
 *         }
 * 
 *         // Varargs
 *         static void show(int ... x) {
 *             System.out.print("show(int...): ");
 *             for (int n : x) {
 *                 System.out.print(n + " ");
 *             }
 *             System.out.println();
 *         }
 * 
 *         // Varargs dengan tipe beda
 *         static void show(String msg, int ... x) {
 *             System.out.print(msg + ": ");
 *             for (int n : x) {
 *                 System.out.print(n + " ");
 *             }
 *             System.out.println();
 *         }
 * 
 *         // Varargs dengan tipe lain
 *         static void show(String ... x) {
 *             System.out.print("String...: ");
 *             for (String s : x) {
 *                 System.out.print(s + " ");
 *             }
 *             System.out.println();
 *         }
 * 
 *         public static void main(String[] args) {
 *             show(10);              // show(int): 10 (lebih spesifik)
 *             show(1, 2, 3);         // show(int...): 1 2 3
 *             show("Angka", 5, 6);   // Angka: 5 6
 *             show("A", "B", "C");   // String...: A B C
 *         }
 *     }
 * 
 * ------------------------------------------------------------------------
 * ATURAN OVERLOAD VARARGS
 * ------------------------------------------------------------------------
 * 
 * 1. Boleh overload dengan tipe varargs berbeda
 *    void test(int ... a) vs void test(double ... a)
 * 
 * 2. Boleh overload dengan parameter biasa
 *    void test(int ... a) vs void test(String msg, int ... a)
 * 
 * 3. HINDARI overload yang ambigu
 *    void test(int ... a) vs void test(int x, int ... a)
 *    → test(10) ambiguous!
 * 
 * 4. Prioritaskan method non-varargs jika ada konflik
 *    void test(int x) vs void test(int ... x)
 *    → test(10) pilih non-varargs
 * 
 * ------------------------------------------------------------------------
 * RINGKASAN SUPER PADAT
 * ------------------------------------------------------------------------
 * 
 * - Varargs bisa di-overload
 * - Beda tipe → boleh
 * - Tambah parameter → boleh
 * - Tapi HATI-HATI ambigu!
 * - Java pilih yang PALING SPESIFIK dulu
 * - Varargs = pilihan TERAKHIR
 * - Ambiguous call = COMPILE ERROR
 * 
 * ------------------------------------------------------------------------
 */
     
public class VarargsOveload {

    // versi 1 → int
    static void vaTest(int ... v) {
        System.out.print("vaTest(int ...): " +
                "Number of args: " + v.length +
                " Contents: ");
        for (int x : v)
            System.out.print(x + " ");

        System.out.println();
    }

    // versi 2 → boolean
    static void vaTest(boolean ... v) {
        System.out.print("vaTest(boolean ...): " +
                "Number of args: " + v.length +
                " Contents: ");
        for (boolean x : v)
            System.out.print(x + " ");

        System.out.println();
    }

    // versi 3 → ada parameter tambahan
    static void vaTest(String msg, int ... v) {
        System.out.print("vaTest(String, int ...): " +
                msg + v.length +
                " Contents: ");
        for (int x : v)
            System.out.print(x + " ");

        System.out.println();
    }

    public static void main(String[] args) {

        vaTest(1,2,3); // int
        vaTest("Testing", 10,20); // string + int
        vaTest(true, false, false); // boolean

        /**
         * Kadang overloading + varargs bisa bikin error karena ambiguity (membingungkan compiler).
         * 
         * Java gak bisa menentukan method mana yang harus dipanggil.
         *
         * static void vaTest(int ... v) {
         *         System.out.println("int version");
         *     }
         *
         *     static void vaTest(boolean ... v) {
         *         System.out.println("boolean version");
         *     }
         *
         * vaTest(1, 2, 3);            // jelas int
         * vaTest(true, false, false); // jelas boolean
         * vaTest(); // ERROR (AMBIGUOUS)
         *
         * KENAPA ERROR?
         * Panggilan ini:
         * vaTest();
         * 
         * artinya:
         * gak ada argumen
         *
         * Java mikir:
         * Bisa jadi:
         * → vaTest(int ...)
         * → vaTest(boolean ...)
         *
         * dua-duanya valid karena:
         * varargs boleh kosong
         * int... bisa kosong
         * boolean... juga bisa kosong
         * Java bingung → ERROR
         *
         * KONSEP DALAM (INI KUNCI)
         * Varargs bisa kosong
         * int ... v
         * bisa jadi:
         * int[] v = {}
         * 
         * Jadi:
         * vaTest();
         * bisa jadi:
         * vaTest(new int[]{});
         * vaTest(new boolean[]{});
         * dua-duanya valid 
         *
         * CONTOH AMBIGUITY KE-2 (LEBIH TRICKY)
         * 
         * static void vaTest(int ... v)
         * static void vaTest(int n, int ... v)
         * 
         * Panggilan:
         * vaTest(1);
         * 
         * Java mikir:
         * Kemungkinan 1:
         * vaTest(int ... v)
         * 
         * → v = {1}
         * Kemungkinan 2:
         * vaTest(int n, int ... v)
         * → n = 1
         * → v = {}
         *
         * Dua-duanya valid → ERROR
         *
         * JENIS-JENIS AMBIGUITY
         * 1. Kosong (no argument)
         * test(int...)
         * test(boolean...)
         * test() 
         *
         * 2. Overlap parameter
         * test(int...)
         * test(int, int...)
         *
         * 3. Banyak kemungkinan interpretasi
         * Java gak bisa pilih yang “paling benar”
         *
         * KENAPA JAVA GAK MILIH SENDIRI?
         * Karena:
         * Java harus deterministic (jelas & pasti)
         * gak boleh nebak
         *
         * CARA MENGATASI
         * Cara 1: Jangan overload varargs yang mirip
         * Hindari:
         * test(int...)
         * test(boolean...)
         *
         * Cara 2: Pakai nama method beda
         * testInt(int... v)
         * testBool(boolean... v)
         *
         * Cara 3: Tambah parameter pembeda
         * test(String type, int... v)
         *
         * Cara 4: Hindari kombinasi berbahaya
         * Jangan:
         * test(int...)
         * test(int, int...)
         *
         * RULE OF THUMB (BIAR GAK ERROR)
         * Ingat ini:
         * Kalau ada lebih dari satu cara interpretasi → pasti error
         *
         * KESALAHAN UMUM
         * Kesalahan	                        Kenapa salah
         * Overload varargs beda tipe	        bisa ambiguous
         * Varargs + parameter mirip	        overlap
         * Panggil tanpa argumen	            bisa masuk ke semua method
         *
         * INTI PALING PENTING
         * Varargs fleksibel → tapi berbahaya
         * Ambiguity = Java bingung pilih method
         *
         * Terjadi kalau:
         * argumen kosong
         * parameter overlap
         *
         * Solusi:
         * beda method name
         * desain lebih jelas
         */
    }
}
