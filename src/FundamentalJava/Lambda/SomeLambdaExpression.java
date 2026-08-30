package FundamentalJava.Lambda;

/* ==========================================================
 *              CONTOH-CONTOH LAMBDA EXPRESSION
 * ==========================================================
 *
 * Setelah memahami Functional Interface dan konsep dasar Lambda,
 * sekarang kita dapat melihat bagaimana Lambda digunakan dalam
 * program nyata..
 *
 * Contoh ini menggabungkan beberapa konsep utama:
 *
 * - Functional Interface.
 * - Lambda Expression.
 * - Assignment ke interface reference.
 * - Eksekusi method melalui lambda.
 *
 * ==========================================================
 *              CONTOH FUNCTIONAL INTERFACE
 * ==========================================================
 *
 * Misalkan terdapat interface:
 *
 *     @FunctionalInterface
 *     interface MyNumber {
 *
 *         double getValue();
 *
 *     }
 *
 *
 * Penjelasan:
 *
 * Method:
 *
 *     getValue()
 *
 * memiliki:
 *
 * Input:
 *     tidak ada parameter
 *
 * Output:
 *     double
 *
 *
 * Maka lambda yang digunakan harus:
 *
 * - Tidak memiliki parameter.
 * - Menghasilkan nilai double.
 *
 * ==========================================================
 *                  ASSIGN LAMBDA KE VARIABLE
 * ==========================================================
 *
 * Contoh:
 *
 *     MyNumber myNum;
 *
 *
 * Pada kode tersebut:
 *
 * myNum adalah reference variable dengan tipe MyNumber.
 *
 * Namun saat ini:
 *
 * myNum belum memiliki implementasi.
 *
 *
 * Kemudian:
 *
 *     myNum = () -> 123.45;
 *
 *
 * Yang terjadi:
 *
 * - Lambda diberikan kepada reference myNum.
 * - Java membuat object yang mengimplementasikan MyNumber.
 * - Method getValue() diisi menggunakan lambda tersebut.
 *
 *
 * Secara konsep, kode tersebut sama dengan:
 *
 *     MyNumber myNum = new MyNumber() {
 *
 *         @Override
 *         public double getValue() {
 *             return 123.45;
 *         }
 *
 *     };
 *
 *
 * Perbedaannya:
 *
 * Anonymous class membutuhkan banyak kode.
 *
 * Lambda memberikan cara yang lebih singkat untuk menulis
 * implementasi method tersebut.
 *
 * ==========================================================
 *                  MENJALANKAN LAMBDA
 * ==========================================================
 *
 * Ketika dipanggil:
 *
 *     myNum.getValue();
 *
 *
 * Java menjalankan:
 *
 *     () -> 123.45
 *
 *
 * Hasil:
 *
 *     123.45
 *
 *
 * Lambda bukan hanya disimpan sebagai data.
 *
 * Lambda berisi behavior atau logic yang akan dijalankan ketika
 * method abstract interface dipanggil.
 *
 * ==========================================================
 *                  LAMBDA DENGAN RANDOM VALUE
 * ==========================================================
 *
 * Contoh:
 *
 *     myNum = () -> Math.random() * 100;
 *
 *
 * Berbeda dengan:
 *
 *     () -> 123.45
 *
 * Lambda ini tidak mengembalikan nilai tetap.
 *
 * Setiap kali:
 *
 *     myNum.getValue();
 *
 * dipanggil, lambda akan dieksekusi ulang.
 *
 *
 * Alurnya:
 *
 * getValue()
 *      |
 *      v
 * Jalankan lambda
 *      |
 *      v
 * Math.random()
 *      |
 *      v
 * Hasil baru
 *
 *
 * Karena Math.random() menghasilkan nilai berbeda setiap
 * eksekusi, maka hasil yang dikembalikan juga berbeda.
 *
 * ==========================================================
 *              BEHAVIOR OBJECT DAPAT BERUBAH
 * ==========================================================
 *
 * Perhatikan:
 *
 *     myNum = () -> 123.45;
 *
 * Kemudian:
 *
 *     myNum = () -> Math.random() * 100;
 *
 *
 * Reference myNum tetap sama.
 *
 * Tetapi behavior yang dimilikinya berubah.
 *
 * Sebelumnya:
 *
 * Mengembalikan nilai tetap.
 *
 * Setelah diganti:
 *
 * Menghasilkan nilai random.
 *
 *
 * Ini menunjukkan bahwa Lambda memungkinkan object memiliki
 * behavior yang dinamis.
 *
 * ==========================================================
 *                 LAMBDA HARUS SESUAI TYPE
 * ==========================================================
 *
 * Contoh salah:
 *
 *     myNum = () -> "123.03";
 *
 *
 * Mengapa error?
 *
 * Karena:
 *
 * Interface:
 *
 *     double getValue();
 *
 *
 * Membutuhkan return:
 *
 *     double
 *
 *
 * Tetapi lambda memberikan:
 *
 *     String
 *
 *
 * Maka terjadi ketidaksesuaian tipe.
 *
 * Compiler akan menolak kode tersebut.
 *
 * ==========================================================
 *              ATURAN KOMPATIBILITAS LAMBDA
 * ==========================================================
 *
 * Lambda HARUS cocok dengan abstract method pada Functional
 * Interface.
 *
 * Yang harus sesuai:
 *
 * 1. Jumlah parameter.
 *
 * 2. Tipe parameter.
 *
 * 3. Return type.
 *
 * 4. Aturan exception.
 *
 *
 * Contoh:
 *
 * Interface:
 *
 *     double getValue();
 *
 *
 * Valid:
 *
 *     () -> 100.5
 *
 *
 * Tidak valid:
 *
 *     () -> "Hello"
 *
 *
 * Karena return type berbeda.
 *
 * ==========================================================
 *                    INSIGHT PENTING
 * ==========================================================
 *
 * 1. Lambda bukan kode yang langsung dijalankan saat dibuat.
 *
 * Lambda baru berjalan ketika abstract method dipanggil.
 *
 *
 * Contoh:
 *
 *     myNum = () -> Math.random();
 *
 *
 * Belum menjalankan Math.random().
 *
 * Baru berjalan saat:
 *
 *     myNum.getValue();
 *
 *
 * ----------------------------------------------------------
 *
 * 2. Lambda dapat diganti-ganti
 *
 * Satu reference dapat memiliki behavior berbeda.
 *
 * Contoh:
 *
 *     myNum = () -> 123.45;
 *
 *     myNum = () -> Math.random() * 100;
 *
 *
 * Reference sama.
 *
 * Behavior berbeda.
 *
 *
 * ----------------------------------------------------------
 *
 * 3. Lambda adalah object dengan behavior dinamis
 *
 * Lambda memungkinkan object memiliki kemampuan untuk mengganti
 * logic tanpa membuat class baru.
 *
 * Konsep ini menjadi dasar:
 *
 * - Functional programming style.
 * - Strategy pattern sederhana.
 * - Callback mechanism.
 *
 * ==========================================================
 *              HUBUNGAN DENGAN STRATEGY PATTERN
 * ==========================================================
 *
 * Strategy Pattern tradisional:
 *
 * Membuat beberapa class berbeda untuk setiap behavior.
 *
 * Contoh:
 *
 *     AdditionStrategy
 *     SubtractionStrategy
 *     MultiplicationStrategy
 *
 *
 * Dengan Lambda:
 *
 * Behavior dapat dikirim langsung.
 *
 * Contoh:
 *
 *     calculate(a, b, (x, y) -> x + y);
 *
 *
 * Lebih sederhana dan fleksibel.
 *
 * ==========================================================
 *                       KESIMPULAN
 * ==========================================================
 *
 * Lambda Expression adalah implementasi dari abstract method
 * pada Functional Interface.
 *
 * Poin penting:
 *
 * - Lambda dapat diberikan ke interface reference.
 * - Lambda dijalankan ketika method dipanggil.
 * - Lambda dapat diganti dengan behavior berbeda.
 * - Return type dan parameter harus sesuai dengan interface.
 * - Lambda membuat object memiliki behavior yang fleksibel.
 *
 * Mental model:
 *
 * Functional Interface
 *          |
 *          v
 * Menentukan kontrak method
 *          |
 *          v
 * Lambda Expression
 *          |
 *          v
 * Memberikan implementasi behavior
 *
 * ==========================================================
 */

interface Number {
    int numberOne();

    // kalo lebih dari satu method akan error
    // double numberTwo();
}

public class SomeLambdaExpression {
    public static void main(String[] args) {

        Number number;

        // SATU OBJEK BISA BERUBAH UBAH BEHAVIOR
        number = () -> 10 * 10;
        System.out.println(number.numberOne());
        number = () -> 10 + 5;
        System.out.println(number.numberOne());
        number = () -> 10;
        System.out.println(number.numberOne());

        // ini error
        // number = () -> 10.0; karena double, harus casting
        number = () -> (int) 10.0; // ini masih bisa
        System.out.println(number.numberOne());

        // ini tidak bisa dan tidak boleh
        // number = () -> "Samson";
        // karena sudah bukan number, tapi string.

    }
}
