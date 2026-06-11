package Varargs;

    /**
     * Kita bisa overload method yang pakai varargs.
     *
     * Artinya:
     * Nama method sama
     * Tapi parameter beda
     *
     * CARA OVERLOAD VARARGS
     * Cara 1: beda tipe
     * test(int ... a)
     * test(boolean ... a)
     *
     * Cara 2: tambah parameter biasa
     * test(String msg, int ... a)
     *
     * JEBakan PALING BERBAHAYA
     * Ambiguous call (bikin error)
     * static void test(int ... a)
     * static void test(int x, int ... a)
     *
     * Kalau lo panggil:
     * test(10);
     * Java bingung:
     * ini masuk ke method mana?
     * ERROR
     *
     * VARARGS vs NON-VARARGS
     * Contoh:
     * static void test(int x)
     * static void test(int ... x)
     * Kalau:
     * test(10);
     *
     * Java pilih:
     * test(int x) // lebih spesifik
     * 
     * Kalau:
     * test(1,2,3);
     * Java pilih:
     * test(int ... x)
     *
     * PRIORITAS JAVA
     * Urutan pemilihan method:
     * Exact match (paling spesifik)
     * Overload biasa
     * Varargs (paling terakhir)
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
