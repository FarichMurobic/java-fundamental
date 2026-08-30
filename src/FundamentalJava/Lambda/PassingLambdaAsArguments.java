package FundamentalJava.Lambda;

/* ==========================================================
 *            MENGIRIM LAMBDA SEBAGAI ARGUMENT METHOD
 * ==========================================================
 *
 * Lambda Expression dapat digunakan di berbagai tempat selama
 * terdapat target type yang sesuai..
 *
 * Target type tersebut biasanya berupa Functional Interface.
 *
 * Salah satu penggunaan Lambda yang paling penting adalah:
 *
 * Mengirim Lambda sebagai argument method.
 *
 * Artinya:
 *
 * Kita dapat mengirim sebuah logic atau behavior ke dalam
 * sebuah method sebagai parameter.
 *
 * Konsep ini sering disebut:
 *
 * "Passing behavior as parameter"
 *
 * ==========================================================
 *              KONSEP DASAR METHOD ARGUMENT LAMBDA
 * ==========================================================
 *
 * Contoh:
 *
 *     method(lambda);
 *
 *
 * Artinya:
 *
 * - Lambda dibuat.
 * - Lambda dikirim sebagai parameter.
 * - Method menjalankan lambda tersebut ketika diperlukan.
 *
 * Namun ada satu syarat utama:
 *
 * Parameter method harus menggunakan Functional Interface yang
 * kompatibel dengan bentuk lambda tersebut.
 *
 * ==========================================================
 *              CONTOH FUNCTIONAL INTERFACE
 * ==========================================================
 *
 * Contoh:
 *
 *     @FunctionalInterface
 *     interface StringFunc {
 *
 *         String func(String str);
 *
 *     }
 *
 * Interface ini mendefinisikan kontrak:
 *
 * Input:
 *     String
 *
 * Output:
 *     String
 *
 * Maka lambda yang digunakan harus menerima String dan
 * menghasilkan String.
 *
 * ==========================================================
 *              METHOD YANG MENERIMA LAMBDA
 * ==========================================================
 *
 * Contoh:
 *
 *     static String stringOp(
 *             StringFunc sf,
 *             String s) {
 *
 *         return sf.func(s);
 *
 *     }
 *
 *
 * Penjelasan parameter:
 *
 * StringFunc sf:
 *
 * Parameter pertama adalah Functional Interface.
 *
 * Karena StringFunc merupakan functional interface, maka
 * parameter ini dapat menerima Lambda Expression.
 *
 *
 * String s:
 *
 * Data yang akan diproses oleh lambda.
 *
 * ==========================================================
 *              CARA KERJA DI DALAM METHOD
 * ==========================================================
 *
 * Perhatikan:
 *
 *     return sf.func(s);
 *
 *
 * Yang terjadi:
 *
 * 1. Method memanggil abstract method func().
 *
 * 2. Implementasi func() berasal dari lambda yang dikirim.
 *
 * 3. Nilai s menjadi input untuk lambda.
 *
 * 4. Hasil lambda dikembalikan oleh method.
 *
 * Alur:
 *
 * Lambda
 *    |
 *    v
 * StringFunc
 *    |
 *    v
 * sf.func(s)
 *    |
 *    v
 * Hasil dikembalikan
 *
 * ==========================================================
 *              MENGIRIM LAMBDA SECARA LANGSUNG
 * ==========================================================
 *
 * Contoh:
 *
 *     String result =
 *         stringOp(
 *             str -> str.toUpperCase(),
 *             "hello"
 *         );
 *
 *
 * Yang terjadi:
 *
 * 1. Java membuat object lambda.
 *
 * 2. Object tersebut dikirim sebagai argument pertama.
 *
 * 3. Method stringOp menerima object tersebut melalui
 *    parameter StringFunc.
 *
 * 4. Method menjalankan:
 *
 *        sf.func(s)
 *
 *
 * Hasil:
 *
 *     HELLO
 *
 * ==========================================================
 *              BLOCK LAMBDA SEBAGAI ARGUMENT
 * ==========================================================
 *
 * Lambda yang dikirim sebagai argument juga dapat menggunakan
 * block lambda.
 *
 * Contoh:
 *
 *     stringOp(
 *
 *         str -> {
 *
 *             String result =
 *                 str.toUpperCase();
 *
 *             return result;
 *
 *         },
 *
 *         "hello"
 *     );
 *
 *
 * Konsepnya sama:
 *
 * Lambda menjadi implementasi dari method func().
 *
 * ==========================================================
 *              MASALAH BLOCK LAMBDA PANJANG
 * ==========================================================
 *
 * Walaupun valid, block lambda yang terlalu panjang dapat
 * membuat pemanggilan method sulit dibaca.
 *
 * Contoh masalah:
 *
 *     stringOp(
 *         str -> {
 *             banyak;
 *             sekali;
 *             logic;
 *         },
 *         input
 *     );
 *
 *
 * Jika logic semakin kompleks, lebih baik dipisahkan.
 *
 * ==========================================================
 *              SOLUSI: SIMPAN LAMBDA KE VARIABLE
 * ==========================================================
 *
 * Lambda dapat disimpan terlebih dahulu ke variable.
 *
 * Contoh:
 *
 *     StringFunc reverse =
 *
 *         str -> {
 *
 *             return new StringBuilder(str)
 *                     .reverse()
 *                     .toString();
 *
 *         };
 *
 *
 * Kemudian dikirim:
 *
 *     stringOp(reverse, input);
 *
 *
 * Keuntungan:
 *
 * - Kode lebih mudah dibaca.
 * - Lambda dapat digunakan ulang.
 * - Pemisahan logic menjadi lebih jelas.
 *
 * ==========================================================
 *              INLINE VS VARIABLE LAMBDA
 * ==========================================================
 *
 * Lambda pendek:
 *
 * Gunakan inline.
 *
 * Contoh:
 *
 *     stringOp(
 *         str -> str.toUpperCase(),
 *         input
 *     );
 *
 *
 * Lambda panjang:
 *
 * Simpan ke variable.
 *
 * Contoh:
 *
 *     StringFunc processor = str -> {
 *         ...
 *     };
 *
 *     stringOp(processor, input);
 *
 * ==========================================================
 *                    INSIGHT PENTING
 * ==========================================================
 *
 * Konsep ini merupakan salah satu perubahan besar dari Lambda.
 *
 * Sebelumnya:
 *
 * Method hanya menerima data.
 *
 * Sekarang:
 *
 * Method juga dapat menerima behavior atau logic.
 *
 *
 * Contoh:
 *
 *     stringOp(...)
 *
 * Satu method dapat memiliki banyak perilaku:
 *
 * - Uppercase.
 * - Lowercase.
 * - Reverse.
 * - Remove whitespace.
 * - Validasi string.
 *
 *
 * Method tetap sama.
 *
 * Yang berubah hanya logic yang dikirim.
 *
 * ==========================================================
 *              DASAR FEATURE JAVA MODERN
 * ==========================================================
 *
 * Passing lambda sebagai parameter menjadi dasar dari:
 *
 * - Stream API.
 * - filter().
 * - map().
 * - Callback mechanism.
 * - Event handling.
 *
 * Konsep ini juga mirip dengan bahasa lain:
 *
 * JavaScript:
 * function sebagai parameter.
 *
 * Python:
 * first-class function.
 *
 * ==========================================================
 *              HUBUNGAN DENGAN DESIGN PATTERN
 * ==========================================================
 *
 * Penggunaan Lambda seperti ini memiliki konsep yang mirip
 * dengan Strategy Pattern.
 *
 * Perbedaannya:
 *
 * Strategy Pattern tradisional membutuhkan class terpisah.
 *
 * Lambda dapat memberikan strategy secara langsung dengan
 * kode yang lebih sederhana.
 *
 * ==========================================================
 *                       KESIMPULAN
 * ==========================================================
 *
 * Lambda Expression dapat dikirim sebagai argument method
 * selama parameter method menggunakan Functional Interface yang
 * sesuai.
 *
 * Poin penting:
 *
 * - Lambda dapat menjadi parameter method.
 * - Functional Interface menjadi target type lambda.
 * - Lambda dapat dikirim langsung (inline).
 * - Lambda panjang lebih baik disimpan dalam variable.
 * - Konsep ini memungkinkan passing behavior sebagai parameter.
 *
 * Mental model:
 *
 * Data:
 *     method(data)
 *
 * Lambda:
 *     method(logic)
 *
 * Java modern tidak hanya mengirim data,
 * tetapi juga dapat mengirim perilaku program.
 *
 * ==========================================================
 */

// Functional interface
interface Kata {
    // method menerima string dan return string
    String func(String n);
}

public class PassingLambdaAsArguments {
    // method yang menerima lambda sebagai parameter
    static String stringOp(Kata kata, String s) {
        // memanggil method dari interface
        // lambda akan di eksekusi disini
        return kata.func(s);
    }

    public static void main(String[] args) {

        String inStr = "Lambdas add power to Java";
        String outStr;

        System.out.println("here is input string: " + inStr);

        // 1. Lambda langsung (expression lambda)

        // mengubah string menjadi uppercase
        outStr = stringOp((str) -> str.toUpperCase(), inStr); // parameter kedua di methode stringOp(Kata kata, String
                                                              // s)
        System.out.println("The string in uppercase: " + outStr);

        // 2. Block Lambda (hapus spasi)
        outStr = stringOp((str) -> {
            String result = "";
            int i;

            // kalau bukan spasi tambahkan ke result
            for (i = 0; i < str.length(); i++) {
                if (str.charAt(i) != ' ')
                    result += str.charAt(i);
            }
            return result;
        }, inStr); // parameter kedua di methode stringOp(Kata kata, String s)

        System.out.println("The string with spaces removed: " + outStr);

        // 3. Lambda disimpan dulu ke variable

        Kata reverse = (str) -> {
            String result = "";
            int i;

            for (i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        };

        System.out.println("The string reversed: " + stringOp(reverse, inStr));
    }
}
