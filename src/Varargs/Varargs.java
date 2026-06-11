package Varargs;

    /**
     * Mulai dari JDK 5, 
     * Java punya fitur untuk membuat method yang bisa menerima jumlah parameter yang tidak tetap (bebas).
     * 
     * Ini disebut varargs (variable-length arguments)
     * 
     * Penjelasan simpel
     * Biasanya method:
     * method(1, 2)
     * method(1, 2, 3)
     * jumlah argumen beda
     * 
     * Varargs bikin ini jadi:
     * method(1)
     * method(1, 2, 3)
     * method()
     * semua valid
     *
     * MASALAH SEBELUM VARARGS
     * Cara lama 1: Overloading
     * void test(int a)
     * void test(int a, int b)
     * void test(int a, int b, int c)
     * ribet & gak scalable
     *
     * Cara lama 2: Pakai Array
     * void test(int v[])
     * Tapi harus:
     * int arr[] = {1,2,3};
     * test(arr);
     * ribet manual bikin array
     *
     * VARARGS (CARA MODERN)
     * Syntax:
     * int ... v
     * 
     * artinya:
     * bisa 0 atau lebih argumen
     * otomatis jadi array
     *
     * ALUR DI BELAKANG LAYAR
     * Misal:
     * vaTest(1,2,3);
     * Java otomatis ubah jadi:
     * int[] v = {1,2,3};
     *
     * HAL PENTING BANGET
     * 
     * Varargs = ARRAY
     * Di dalam method:
     * v.length
     * v[0]
     * semua kayak array biasa
     *
     * VARARGS + PARAMETER BIASA
     * Boleh:
     * static void test(String msg, int ... v)
     *
     * ATURAN KERAS (WAJIB HAFAL)
     * 1. Varargs HARUS di terakhir
     * Salah:
     * int test(int ... v, int x)
     *
     * 2. Cuma boleh satu varargs
     * Salah:
     * int test(int ... v, double ... x)
     *
     * 3. Bisa kosong
     * vaTest(); // valid
     *
     * KAPAN DIPAKAI?
     * 
     * Varargs dipakai kalau:
     * jumlah input tidak pasti
     * bikin API fleksibel
     * contoh nyata:
     * printf()
     * logging
     * utility method
     *
     * INTI PALING PENTING
     * int ... v = banyak argumen
     * sebenarnya = array
     * bisa 0 atau lebih
     * harus di parameter terakhir
     * cuma boleh 1 varargs
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
    static void test(int ... v) {
        System.out.print("Number Args: " + v.length + " Contens");
        for (int x : v)
            System.out.print(x + " ");

        System.out.println();
    }

    static int jumlah(int ... angka) {
        int total = 0;
        for (int a : angka)
            total += a;
        return total;
    }

    public static void main(String[] args) {

        // Cara lama harus buat array argument dulu
        int n1[] = {10};
        int n2[] = {1,2,3};
        int n3[] = { };

        vaTest(n1);
        vaTest(n2);
        vaTest(n3);

        // Cara baru Varargs
        test(10);
        test(1,2,3);
        test();

        System.out.println(jumlah(1,2,3));
        System.out.println(jumlah(10,20));
        System.out.println(jumlah());

    }
}
