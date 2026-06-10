package Lambda;

/**
 * Beberapa Contoh Lambda Expression
 *
 * Dengan penjelasan sebelumnya, sekarang kita lihat contoh sederhana.
 * Contoh ini menggabungkan:
 * functional interface
 * lambda expression
 * assignment
 * eksekusi
 *
 * 1. Ini alur yang terjadi
 * MyNumber myNum;
 *
 * Lo bikin “wadah” (interface reference)
 *
 * myNum = () -> 123.45;
 *
 * Yang terjadi:
 * Java bikin object secara otomatis
 * implement MyNumber
 * isi getValue() dengan lambda
 *
 * Secara konsep setara dengan:
 * // Versi manual (tanpa lambda)
 * MyNumber myNum = new MyNumber() {
 *     @Override
 *     public double getValue() {
 *         return 123.45;
 *     }
 * };
 *
 * 2. Kenapa random beda-beda?
 * myNum = () -> Math.random() * 100;
 *
 * Setiap kali:
 * myNum.getValue();
 *
 * Lambda dijalankan ulang
 *
 * Makanya:
 * hasil beda terus
 *
 * 3. Kenapa yang String error?
 * // myNum = () -> "123.03";
 *
 * Karena:
 * getValue() harus return double
 * lambda return String
 *
 * Tidak cocok → ERROR
 *
 * ----------------------------------------------
 * 
 * Ini aturan penting banget:
 * Lambda HARUS sesuai dengan method di interface
 *
 * Insight Mentor (Ini yang bikin lo naik level)
 * 1. Lambda itu bukan sekali jalan
 *
 * Dia dieksekusi setiap kali method dipanggil
 *
 * 2. Lambda bisa diganti-ganti
 * myNum = () -> 123.45;
 * myNum = () -> Math.random() * 100;
 *
 * Behavior object bisa berubah
 *
 * 3. Ini konsep powerful:
 * “Object dengan behavior dinamis”
 *
 * 4. Ini awal dari:
 * Strategy pattern versi simpel
 * Functional programming style di Java
 *
 * -----------------------------------------
 * 
 * Kesimpulan Super Sederhana
 * 1. Lambda jadi isi method
 * myNum = () -> 123.45;
 *
 * 2. Setiap call = lambda dijalankan
 * myNum.getValue();
 *
 * 3. Harus cocok tipe
 * return type harus sama
 * parameter harus sama
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
