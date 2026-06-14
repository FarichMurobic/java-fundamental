package FundamentalJava.OperatorAritmatika;

/**
 * Aturan Evaluasi Ekspresi Campuran (Mixed Expressions)
 * Sebuah ekspresi yang memiliki operand (nilai yang dioperasikan) 
 * dari lebih dari satu tipe data numerik disebut ekspresi campuran (mixed expression).
 * Jadi, ekspresi campuran bisa berisi nilai int dan long, atau int dan double, dan sebagainya.
 *
 * Jika kedua operand memiliki tipe data yang sama, tidak ada yang perlu dilakukan pada langkah ini.
 * Jika operand memiliki tipe yang berbeda, Java akan mengonversi tipe data 
 * dengan rentang yang lebih kecil ke tipe data yang lebih besar
 * untuk tujuan evaluasi ekspresi ini. Ini sering disebut sebagai "promosi" atau "konversi implisit".
 *
 * Urutan konversi data adalah sebagai berikut (dari rentang terkecil ke terbesar): 
 * byte → short → int → long → float → double Atau kombinasi apa pun dari ini dalam arah yang sama.
 */

public class MIXEDExpression {
    public static void main(String[] args) {

        /**
         * Jika satu operand adalah int dan yang lainnya adalah double, nilai data int akan dipromosikan menjadi nilai double.
         * Dalam kasus ini, operasi floating point akan terjadi dan hasilnya akan bertipe double.
         * Demikian pula, jika satu operand adalah int dan yang lainnya adalah long, nilai data int akan dipromosikan menjadi nilai long.
         * dan hasilnya akan bertipe long.
         */

        System.out.println("--- Contoh Evaluasi Ekspresi Campuran ---");

        // Contoh 1: int / int + double
        // 1. 27 / 11 (int / int) -> hasilnya int 2
        // 2. 2 + 4.0 (int + double) -> int 2 dipromosikan jadi double 2.0
        // 3. 2.0 + 4.0 = 6.0
        double hasil1 = 27 / 11 + 4.0;
        System.out.println("27 / 11 + 4.0 = " + hasil1); // Output: 6.0

        // Contoh 2: int / double + int
        // 1. 27 / 11.0 (int / double) -> int 27 dipromosikan jadi double 27.0
        // 2. 27.0 / 11.0 = 2.4545454545454546 (double)
        // 3. 2.4545454545454546 + 4 (double + int) -> int 4 dipromosikan jadi double 4.0
        // 4. 2.4545454545454546 + 4.0 = 6.4545454545454546
        double hasil2 = 27 / 11.0 + 4;
        System.out.println("27 / 11.0 + 4 = " + hasil2); // Output: 6.4545454545454546

        // Contoh 3: long / int
        // 1. 31L / 2 (long / int) -> int 2 dipromosikan jadi long 2L
        // 2. 31L / 2L = 15L (hasilnya long)
        long hasil3 = 31L / 2;
        System.out.println("31L / 2 = " + hasil3); // Output: 15

        // Contoh 4: int + double
        // 1. 32 + 12.5 (int + double) -> int 32 dipromosikan jadi double 32.0
        // 2. 32.0 + 12.5 = 44.5
        double hasil4 = 32 + 12.5;
        System.out.println("32 + 12.5 = " + hasil4); // Output: 44.5

        // Contoh 5: float * long
        // 1. 18.723F * 234L (float * long) -> long 234L dipromosikan jadi float 234.0F
        // 2. 18.723F * 234.0F = 4381.182
        float hasil5 = 18.723F * 234L;
        System.out.println("18.723F * 234L = " + hasil5); // Output: 4381.182

        // Contoh 6: double - float
        // 1. 353.35 - 0.001F (double - float) -> float 0.001F dipromosikan jadi double 0.001
        // 2. 353.35 - 0.001 = 353.349
        double hasil6 = 353.35 - 0.001F;
        System.out.println("353.35 - 0.001F = " + hasil6); // Output: 353.349

        System.out.println("\n--- Contoh yang Lebih Kompleks (dari penjelasan sebelumnya) ---");

        // Contoh 7: Mengikuti alur 9 % 5 + 6 * 7 – 3.19
        // 1. 9 % 5 = 4 (int)
        // 2. 4 + 6 * 7 – 3.19 (lanjut perkalian)
        // 3. 6 * 7 = 42 (int)
        // 4. 4 + 42 – 3.19 (lanjut penjumlahan)
        // 5. 4 + 42 = 46 (int)
        // 6. 46 – 3.19 (int - double) -> int 46 dipromosikan jadi double 46.0
        // 7. 46.0 - 3.19 = 42.81
        double hasilKompleksLagi = 9 % 5 + 6 * 7 - 3.19;
        System.out.println("9 % 5 + 6 * 7 - 3.19 = " + hasilKompleksLagi); // Output: 42.81

    }

}
