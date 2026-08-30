package FundamentalJava.Lambda;

/* ==========================================================
 *             LAMBDA EXPRESSION DENGAN PARAMETER
 * ==========================================================
 *
 * Lambda Expression tidak hanya dapat digunakan untuk method
 * tanpa parameter..
 *
 * Lambda juga dapat menerima parameter sebagai input untuk
 * menjalankan sebuah logic tertentu.
 *
 * Bentuk dasar:
 *
 *     parameter -> expression
 *
 * Parameter pada lambda harus sesuai dengan parameter yang
 * didefinisikan oleh abstract method pada Functional Interface.
 *
 * ==========================================================
 *              CONTOH LAMBDA SATU PARAMETER
 * ==========================================================
 *
 * Functional Interface:
 *
 *     @FunctionalInterface
 *     interface NumericTest {
 *
 *         boolean test(int n);
 *
 *     }
 *
 * Penjelasan:
 *
 * Method test():
 *
 * Input:
 *     int n
 *
 * Output:
 *     boolean
 *
 * Artinya:
 *
 * Lambda yang digunakan harus:
 *
 * - Menerima satu parameter bertipe int.
 * - Menghasilkan nilai boolean.
 *
 * ==========================================================
 *                  LAMBDA CEK BILANGAN GENAP
 * ==========================================================
 *
 * Contoh:
 *
 *     NumericTest isEven =
 *             (n) -> (n % 2) == 0;
 *
 * Penjelasan:
 *
 * n:
 * parameter input.
 *
 * n % 2:
 * menghitung sisa pembagian dengan 2.
 *
 * Jika hasilnya 0:
 * berarti angka tersebut genap.
 *
 * Contoh:
 *
 *     10 % 2 == 0
 *
 * hasil:
 *
 *     true
 *
 *
 *     7 % 2 == 0
 *
 * hasil:
 *
 *     false
 *
 * ==========================================================
 *             LAMBDA CEK NILAI NON-NEGATIF
 * ==========================================================
 *
 * Contoh:
 *
 *     NumericTest isNonNeg =
 *             (n) -> n >= 0;
 *
 * Logika:
 *
 * Jika:
 *
 *     n >= 0
 *
 * maka:
 *
 *     true
 *
 * Jika:
 *
 *     n < 0
 *
 * maka:
 *
 *     false
 *
 * ==========================================================
 *                  CARA MEMBACA LAMBDA
 * ==========================================================
 *
 * Contoh:
 *
 *     NumericTest isEven =
 *             (n) -> (n % 2) == 0;
 *
 *
 * Bagian-bagiannya:
 *
 * NumericTest:
 * Target type dari lambda.
 *
 * test(int n):
 * Method abstract yang akan diimplementasikan.
 *
 * (n) ->:
 * Parameter lambda.
 *
 * (n % 2) == 0:
 * Logic yang dijalankan.
 *
 * ==========================================================
 *                    TYPE INFERENCE
 * ==========================================================
 *
 * Perhatikan:
 *
 *     (n) -> (n % 2) == 0
 *
 * Tidak ada penulisan:
 *
 *     (int n)
 *
 * Mengapa?
 *
 * Karena Java dapat mengetahui tipe parameter dari Functional
 * Interface.
 *
 * Interface:
 *
 *     boolean test(int n);
 *
 * Memberitahu compiler bahwa:
 *
 * n adalah int.
 *
 * Kemampuan Java menebak tipe secara otomatis disebut:
 *
 * Type Inference.
 *
 * ==========================================================
 *             PENULISAN TIPE SECARA EKSPLISIT
 * ==========================================================
 *
 * Lambda juga dapat menulis tipe parameter secara langsung.
 *
 * Contoh:
 *
 *     (int n) -> (n % 2) == 0
 *
 * Kode ini valid.
 *
 * Namun dalam praktik Java modern, penulisan implicit lebih
 * sering digunakan karena lebih ringkas.
 *
 * ==========================================================
 *             SATU INTERFACE, BANYAK PERILAKU
 * ==========================================================
 *
 * Salah satu kekuatan Lambda adalah satu Functional Interface
 * dapat memiliki banyak implementasi berbeda.
 *
 * Contoh:
 *
 *     NumericTest isEven =
 *             n -> n % 2 == 0;
 *
 *
 *     NumericTest isNonNeg =
 *             n -> n >= 0;
 *
 *
 * Kedua lambda tersebut berbeda behavior:
 *
 * isEven:
 * mengecek angka genap.
 *
 * isNonNeg:
 * mengecek angka non-negatif.
 *
 * Tetapi keduanya tetap valid karena memiliki bentuk yang sama:
 *
 *     boolean test(int n)
 *
 * ==========================================================
 *                  EKSEKUSI LAMBDA
 * ==========================================================
 *
 * Ketika method dipanggil:
 *
 *     isEven.test(10);
 *
 * Yang terjadi:
 *
 * 10 masuk sebagai nilai parameter n.
 *
 * Lambda menjalankan:
 *
 *     (n) -> (n % 2) == 0
 *
 * Hasil:
 *
 *     true
 *
 * Lambda bekerja seperti implementasi method biasa.
 *
 * ==========================================================
 *              PARAMETER SATU DAN PARENTHESES
 * ==========================================================
 *
 * Untuk satu parameter, tanda kurung bersifat opsional.
 *
 * Contoh:
 *
 *     (n) -> n >= 0
 *
 * Sama dengan:
 *
 *     n -> n >= 0
 *
 * Keduanya valid.
 *
 * Namun jika parameter lebih dari satu, tanda kurung wajib
 * digunakan.
 *
 * ==========================================================
 *          LAMBDA DENGAN DUA PARAMETER
 * ==========================================================
 *
 * Functional Interface:
 *
 *     @FunctionalInterface
 *     interface NumericTest2 {
 *
 *         boolean test(int n, int d);
 *
 *     }
 *
 * Method test() memiliki:
 *
 * Parameter:
 *
 *     n
 *     d
 *
 * Return:
 *
 *     boolean
 *
 *
 * Maka lambda harus memiliki dua parameter.
 *
 * ==========================================================
 *              CONTOH LAMBDA DUA PARAMETER
 * ==========================================================
 *
 * Contoh:
 *
 *     NumericTest2 isFactor =
 *             (n, d) -> (n % d) == 0;
 *
 * Penjelasan:
 *
 * n:
 * angka utama.
 *
 * d:
 * angka pembagi.
 *
 * Operator %:
 * Menghasilkan sisa pembagian.
 *
 * Contoh:
 *
 *     10 % 2 == 0
 *
 * hasil:
 *
 *     true
 *
 *
 *     10 % 3 == 0
 *
 * hasil:
 *
 *     false
 *
 * ==========================================================
 *                  CARA EKSEKUSI
 * ==========================================================
 *
 * Ketika dipanggil:
 *
 *     isFactor.test(10, 2);
 *
 * Nilai parameter:
 *
 *     n = 10
 *     d = 2
 *
 * Lambda menjalankan:
 *
 *     (10 % 2) == 0
 *
 * Hasil:
 *
 *     true
 *
 * ==========================================================
 *              ATURAN MULTIPLE PARAMETER
 * ==========================================================
 *
 * Jika lambda memiliki lebih dari satu parameter:
 *
 *     (n, d) -> ...
 *
 * Maka:
 *
 * - Harus menggunakan tanda kurung.
 * - Parameter dipisahkan dengan koma.
 *
 * Tidak valid:
 *
 *     n, d -> ...
 *
 * ==========================================================
 *              ATURAN TIPE DATA PARAMETER
 * ==========================================================
 *
 * Jika ingin menulis tipe data secara eksplisit, semua
 * parameter harus diberikan tipe.
 *
 * Benar:
 *
 *     (int n, int d) ->
 *             (n % d) == 0
 *
 *
 * Salah:
 *
 *     (int n, d) ->
 *             (n % d) == 0
 *
 *
 * Alasannya:
 *
 * Java tidak mengizinkan pencampuran parameter typed dan
 * untyped dalam lambda.
 *
 * Rule:
 *
 * "Kalau satu parameter diberikan tipe, semua parameter harus
 * diberikan tipe."
 *
 * ==========================================================
 *                    INSIGHT PENTING
 * ==========================================================
 *
 * Lambda Expression dapat dianggap sebagai function kecil yang
 * memiliki:
 *
 * - Input.
 * - Logic.
 * - Output.
 *
 * Contoh:
 *
 *     (n, d) -> (n % d) == 0
 *
 * Input:
 *     n dan d
 *
 * Logic:
 *     operasi modulo
 *
 * Output:
 *     boolean
 *
 * ==========================================================
 *                 KONSEP LANJUTAN
 * ==========================================================
 *
 * Konsep lambda dengan parameter menjadi dasar untuk:
 *
 * - Predicate<T>.
 * - BiPredicate<T, U>.
 * - Stream API filter().
 * - Validasi data.
 * - Functional programming style.
 *
 * Konsep utamanya:
 *
 * "Passing behavior sebagai nilai."
 *
 * Artinya:
 *
 * Kita dapat mengirim logic sebagai object untuk digunakan
 * oleh bagian program lain.
 *
 * ==========================================================
 *                       KESIMPULAN
 * ==========================================================
 *
 * Lambda Expression dapat memiliki satu atau lebih parameter.
 *
 * Poin penting:
 *
 * - Parameter lambda harus sesuai dengan abstract method.
 * - Tipe parameter dapat ditentukan otomatis oleh Java.
 * - Satu Functional Interface dapat memiliki banyak lambda
 *   dengan behavior berbeda.
 * - Satu parameter boleh tanpa ().
 * - Lebih dari satu parameter wajib menggunakan ().
 * - Jika tipe parameter ditulis manual, semua parameter harus
 *   ditulis tipenya.
 *
 * Hubungan konsep:
 *
 * Functional Interface
 *          |
 *          v
 * Menentukan bentuk parameter dan return
 *          |
 *          v
 * Lambda Expression
 *          |
 *          v
 * Memberikan behavior atau logic
 *
 * ==========================================================
 */

interface Something {
    boolean test(int n); // with parameter
}

interface NumericTest {

    // methode menerima 2 parameter
    // mengembalikan boolean
    boolean test(int n, int d);
}

public class LambdaWithParameters {
    public static void main(String[] args) {

        // Lambda 1 cek bilangan genap

        // Lambda ini akan menjadi implementasi method test(int n)
        // nama (n) disini bisa bebas, tidak harus sama dengan nama parameter method
        Something genap = (n) -> (n % 2) == 0;

        System.out.println(genap.test(4)); // true
        System.out.println(genap.test(3)); // false

        // memanggil lambda melalui method test(int n)
        if (genap.test(10))
            System.out.println("10 is even."); // true
        if (genap.test(9))
            System.out.println("9 is not even."); // false

        System.out.println();

        // Lambda 2 cek bilangan negatif
        Something nonNegatif = (n) -> n >= 0;

        System.out.println(nonNegatif.test(5));
        System.out.println(nonNegatif.test(-200));

        // memanggil lambda melalui methode test(int n)
        if (nonNegatif.test(1))
            System.out.println("1 is non negatif"); // true
        if (nonNegatif.test(-1))
            System.out.println("-1 is negatif"); // false

        System.out.println();

        // Mehtode dengan 2 parameters

        // Lambda cek faktor
        // lambda ini mengecek apakah dia adalah faktor dari n
        NumericTest isFactor = (n, d) -> (n % d) == 0;

        System.out.println(isFactor.test(10, 1)); // true
        System.out.println(isFactor.test(10, 2)); // true
        System.out.println(isFactor.test(10, 3)); // false

        // cek apakah 2 adalah faktor dari 10
        if (isFactor.test(10, 2))
            System.out.println("2 is a factor of 10"); // true

        // cek apakah 3 adalah factor dari 10
        if (isFactor.test(10, 3))
            System.out.println("3 is a factor of 10"); // false

        if (!isFactor.test(10, 3))
            System.out.println("3 is a not factor of 10");

    }
}
