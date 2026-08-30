package FundamentalJava.Varargs;

/**
 * ------------------------------------------------------------------------
 * VARARGS (VARIABLE-LENGTH ARGUMENTS)
 * ------------------------------------------------------------------------
 * 
 * Mulai dari JDK 5, Java memiliki fitur untuk membuat method yang bisa
 * menerima jumlah parameter yang TIDAK TETAP (bebas)..
 * 
 * Ini disebut varargs (variable-length arguments).
 * 
 * ------------------------------------------------------------------------
 * PENJELASAN SIMPEL
 * ------------------------------------------------------------------------
 * 
 * Biasanya method:
 * method(1, 2)
 * method(1, 2, 3)
 * 
 * Jumlah argumen berbeda → harus bikin method berbeda (overloading).
 * 
 * Varargs membuat ini jadi:
 * method(1)
 * method(1, 2, 3)
 * method()
 * 
 * Semua VALID dengan SATU method!
 * 
 * ------------------------------------------------------------------------
 * MASALAH SEBELUM VARARGS
 * ------------------------------------------------------------------------
 * 
 * Cara lama 1: Overloading
 * 
 * void test(int a)
 * void test(int a, int b)
 * void test(int a, int b, int c)
 * void test(int a, int b, int c, int d)
 * // Ribet! Dan tidak scalable
 * 
 * Cara lama 2: Pakai Array
 * 
 * void test(int[] v)
 * 
 * // Tapi harus:
 * int[] arr = {1, 2, 3};
 * test(arr); // Ribet manual bikin array
 * 
 * ------------------------------------------------------------------------
 * VARARGS (CARA MODERN)
 * ------------------------------------------------------------------------
 * 
 * Syntax:
 * int ... v
 * 
 * Artinya:
 * - Bisa menerima 0 atau lebih argumen
 * - Otomatis menjadi array
 * 
 * Contoh:
 * 
 * static void vaTest(int ... v) {
 * System.out.println("Jumlah argumen: " + v.length);
 * for (int x : v) {
 * System.out.print(x + " ");
 * }
 * System.out.println();
 * }
 * 
 * public static void main(String[] args) {
 * vaTest(1, 2, 3); // 3 argumen
 * vaTest(10, 20); // 2 argumen
 * vaTest(); // 0 argumen (valid!)
 * }
 * 
 * ------------------------------------------------------------------------
 * ALUR DI BELAKANG LAYAR
 * ------------------------------------------------------------------------
 * 
 * Misal:
 * vaTest(1, 2, 3);
 * 
 * Java otomatis mengubah menjadi:
 * int[] v = {1, 2, 3};
 * 
 * ------------------------------------------------------------------------
 * HAL PENTING BANGET
 * ------------------------------------------------------------------------
 * 
 * Varargs = ARRAY
 * 
 * Di dalam method, semua operasi array berlaku:
 * 
 * static void vaTest(int ... v) {
 * v.length; // Jumlah argumen
 * v[0]; // Argumen pertama
 * for (int x : v) { } // Bisa pakai for-each
 * }
 * 
 * ------------------------------------------------------------------------
 * VARARGS + PARAMETER BIASA
 * ------------------------------------------------------------------------
 * 
 * Boleh menggabungkan varargs dengan parameter biasa.
 * 
 * static void test(String msg, int ... v) {
 * System.out.print(msg + ": ");
 * for (int x : v) {
 * System.out.print(x + " ");
 * }
 * System.out.println();
 * }
 * 
 * public static void main(String[] args) {
 * test("Angka", 1, 2, 3);
 * test("Kosong");
 * }
 * 
 * // Output:
 * // Angka: 1 2 3
 * // Kosong:
 * 
 * ------------------------------------------------------------------------
 * ATURAN KERAS (WAJIB HAFAL!)
 * ------------------------------------------------------------------------
 * 
 * 1. VARARGS HARUS DI PARAMETER TERAKHIR
 * 
 * // BENAR
 * static void test(String msg, int ... v) { }
 * 
 * // SALAH (compile error)
 * static void test(int ... v, String msg) { }
 * 
 * 2. CUMAN BOLEH SATU VARARGS
 * 
 * // BENAR
 * static void test(int ... v) { }
 * 
 * // SALAH (compile error)
 * static void test(int ... v, double ... x) { }
 * 
 * 3. BISA KOSONG (0 argumen)
 * 
 * vaTest(); // Valid! v.length = 0
 * 
 * ------------------------------------------------------------------------
 * KAPAN DIPAKAI?
 * ------------------------------------------------------------------------
 * 
 * Varargs dipakai ketika:
 * - Jumlah input TIDAK PASTI
 * - Membuat API yang FLEKSIBEL
 * 
 * Contoh nyata:
 * - System.out.printf()
 * - Logging framework
 * - Utility method (concat, sum, dll)
 * 
 * ------------------------------------------------------------------------
 * CONTOH LAIN: SUM DENGAN VARARGS
 * ------------------------------------------------------------------------
 * 
 * static int sum(int ... numbers) {
 * int total = 0;
 * for (int n : numbers) {
 * total += n;
 * }
 * return total;
 * }
 * 
 * public static void main(String[] args) {
 * System.out.println(sum(1, 2, 3)); // 6
 * System.out.println(sum(10, 20, 30, 40)); // 100
 * System.out.println(sum()); // 0
 * }
 * 
 * ------------------------------------------------------------------------
 * CONTOH: CONCATENATE STRING
 * ------------------------------------------------------------------------
 * 
 * static String concat(String separator, String ... strings) {
 * StringBuilder result = new StringBuilder();
 * for (int i = 0; i < strings.length; i++) {
 * result.append(strings[i]);
 * if (i < strings.length - 1) {
 * result.append(separator);
 * }
 * }
 * return result.toString();
 * }
 * 
 * public static void main(String[] args) {
 * System.out.println(concat(", ", "A", "B", "C"));
 * System.out.println(concat(" - ", "Java", "Kotlin"));
 * }
 * 
 * // Output:
 * // A, B, C
 * // Java - Kotlin
 * 
 * ------------------------------------------------------------------------
 * PERBANDINGAN DENGAN ARRAY BIASA
 * ------------------------------------------------------------------------
 * 
 * Array Biasa | Varargs
 * ---------------------|------------------------------------------
 * int[] arr | int ... v
 * Harus bikin array | Bisa langsung tulis argumen
 * test(new int[]{1,2}) | test(1, 2)
 * 
 * ------------------------------------------------------------------------
 * INTI PALING PENTING
 * ------------------------------------------------------------------------
 * 
 * 1. int ... v = banyak argumen
 * 2. Sebenarnya = ARRAY (int[] v)
 * 3. Bisa 0 atau lebih argumen
 * 4. HARUS di parameter TERAKHIR
 * 5. CUMAN boleh SATU varargs
 * 6. Di dalam method, perlakukan sebagai array biasa
 * 
 * ------------------------------------------------------------------------
 */

public class Varargs {

    // CONTOH CARA LAMA
    static void vaTest(int v[]) {
        System.out.print("Number of args: " + v.length + " Contens: ");

        for (int x : v)
            System.out.print(x + " ");

        System.out.println();
    }

    // CARA BARU PAKE VARARGS
    static void test(int... v) {
        System.out.print("Number Args: " + v.length + " Contens");
        for (int x : v)
            System.out.print(x + " ");

        System.out.println();
    }

    static int jumlah(int... angka) {
        int total = 0;
        for (int a : angka)
            total += a;
        return total;
    }

    public static void main(String[] args) {

        // Cara lama harus buat array argument dulu
        int n1[] = { 10 };
        int n2[] = { 1, 2, 3 };
        int n3[] = {};

        vaTest(n1);
        vaTest(n2);
        vaTest(n3);

        // Cara baru Varargs
        test(10);
        test(1, 2, 3);
        test();

        System.out.println(jumlah(1, 2, 3));
        System.out.println(jumlah(10, 20));
        System.out.println(jumlah());

    }
}
