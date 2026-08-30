package FundamentalJava.OperatorLogika;

/**
 * ------------------------------------------------------------------------
 * EKSPRESI DAN OPERATOR LOGIKA
 * ------------------------------------------------------------------------
 * 
 * Ekspresi disebut LOGIKA jika hasil akhirnya hanya ada dua kemungkinan:
 * - true (benar)
 * - false (salah)
 * 
 * Java memiliki:
 * - Lima operator biner (membutuhkan dua input)
 * - Satu operator unary (membutuhkan satu input)
 * 
 * ------------------------------------------------------------------------
 * OPERATOR LOGIKA UNARY
 * ------------------------------------------------------------------------
 * 
 * Operator NOT (!)
 * 
 * Operator unary (hanya butuh satu input).
 * Fungsinya: membalikkan nilai boolean..
 * 
 * !true = false
 * !false = true
 * 
 * Contoh:
 * 
 * boolean sedangHujan = true;
 * boolean tidakHujan = !sedangHujan; // false
 * 
 * ------------------------------------------------------------------------
 * OPERATOR LOGIKA BINER
 * ------------------------------------------------------------------------
 * 
 * 1. Operator AND (&&)
 * 
 * Operator biner (butuh dua input).
 * Hasilnya true HANYA JIKA kedua operand bernilai true.
 * 
 * true && true = true
 * true && false = false
 * false && true = false
 * false && false = false
 * 
 * Analogi:
 * "Kamu bisa masuk jika kamu punya tiket DAN sudah daftar"
 * 
 * 2. Operator OR (||)
 * 
 * Operator biner (butuh dua input).
 * Hasilnya true jika SALAH SATU operand bernilai true.
 * Hasilnya false HANYA JIKA semua input bernilai false.
 * 
 * true || true = true
 * true || false = true
 * false || true = true
 * false || false = false
 * 
 * Analogi:
 * "Kamu bisa pesan makan jika kamu bayar CASH ATAU QRIS"
 * 
 * 3. Operator XOR (^)
 * 
 * Operator biner (butuh dua input).
 * Hasilnya true jika SALAH SATU input true, TAPI BUKAN KEDUANYA.
 * (Exclusive OR - eksklusif)
 * 
 * true ^ true = false
 * true ^ false = true
 * false ^ true = true
 * false ^ false = false
 * 
 * Catatan: Operator ini jarang digunakan untuk logika boolean,
 * tapi penting untuk diketahui.
 * 
 * ------------------------------------------------------------------------
 * PERBEDAAN PENTING: && vs & dan || vs |
 * ------------------------------------------------------------------------
 * 
 * && (Short Circuit AND)
 * - Jika kondisi pertama false, kondisi kedua TIDAK dicek
 * - Lebih efisien
 * - Ini yang paling umum digunakan di Java
 * 
 * & (Non Short Circuit AND)
 * - Tetap mengecek kedua sisi, meskipun kondisi pertama false
 * - Lebih lambat
 * - Jarang digunakan untuk logika boolean
 * 
 * || (Short Circuit OR)
 * - Jika kondisi pertama true, kondisi kedua TIDAK dicek
 * - Lebih efisien
 * - Ini yang paling umum digunakan di Java
 * 
 * | (Non Short Circuit OR)
 * - Tetap mengecek kedua sisi, meskipun kondisi pertama true
 * - Lebih lambat
 * - Jarang digunakan untuk logika boolean
 * 
 * Contoh Short Circuit:
 * 
 * // && - Jika false, tidak lanjut
 * if (umur >= 18 && hitungDataBerat()) {
 * // Jika umur < 18, hitungDataBerat() TIDAK dipanggil
 * }
 * 
 * // || - Jika true, tidak lanjut
 * if (sudahBayar || prosesPembayaran()) {
 * // Jika sudahBayar true, prosesPembayaran() TIDAK dipanggil
 * }
 * 
 * ------------------------------------------------------------------------
 * RULE PENTING DI JAVA
 * ------------------------------------------------------------------------
 * 
 * Biasanya programmer Java menggunakan:
 * - && dan || → untuk logika boolean (kondisi)
 * - & dan | → untuk bitwise operator (operasi bit)
 * 
 * ------------------------------------------------------------------------
 * TABEL KEBENARAN LENGKAP
 * ------------------------------------------------------------------------
 * 
 * A B A && B A || B A ^ B !A
 * ----- ----- ------ ------ ----- ---
 * true true true true false false
 * true false false true true false
 * false true false true true true
 * false false false false false true
 * 
 * ------------------------------------------------------------------------
 * PRECEDENCE (URUTAN PENGERJAAN)
 * ------------------------------------------------------------------------
 * 
 * Urutan pengerjaan operator logika (dari tertinggi ke terendah):
 * 
 * 1. ! (NOT)
 * 2. && (AND)
 * 3. || (OR)
 * 
 * PENTING: Gunakan tanda kurung () untuk memperjelas urutan pengerjaan.
 * 
 * Contoh:
 * 
 * // Tanpa kurung - ambigu
 * boolean hasil = a && b || c;
 * 
 * // Dengan kurung - jelas
 * boolean hasil1 = (a && b) || c;
 * boolean hasil2 = a && (b || c);
 * 
 * ------------------------------------------------------------------------
 * RINGKASAN SUPER PADAT
 * ------------------------------------------------------------------------
 * 
 * - Ekspresi logika = hasilnya true atau false
 * - ! = NOT (membalik nilai)
 * - && = AND (true jika semua true)
 * - || = OR (true jika salah satu true)
 * - ^ = XOR (true jika salah satu true, tapi tidak keduanya)
 * - && dan || adalah Short Circuit (lebih efisien)
 * - & dan | adalah Non Short Circuit (jarang dipakai untuk logika)
 * - Gunakan () untuk memperjelas urutan pengerjaan
 * 
 * ------------------------------------------------------------------------
 */

public class OperatorLogical {
    public static void main(String[] args) {

        // Demonstrate the boolean logical operators.
        boolean booleanA = true;
        boolean booleanB = false;
        boolean booleanC = booleanA | booleanB;
        boolean booleanD = booleanA & booleanB;
        boolean booleanE = booleanA ^ booleanB;
        boolean booleanF = (!booleanA & booleanB) | (booleanA & !booleanB);
        boolean booleanG = !booleanA;

        System.out.println(" booleanA = " + booleanA);
        System.out.println(" booleanB = " + booleanB);
        System.out.println(" booleanA | booleanB = " + booleanC);
        System.out.println(" booleanA & booleanB = " + booleanD);
        System.out.println(" booleanA ^ booleanB = " + booleanE);
        System.out.println("!booleanA & booleanB | booleanA & !booleanB = " + booleanF);
        System.out.println(" !booleanA = " + booleanG);

        /**
         * booleanA = true
         * booleanB = false
         * booleanA | booleanB = true
         * booleanA & booleanB = false
         * booleanA ^ booleanB = true
         * !booleanA & booleanB | booleanA & !booleanB = true
         * !booleanA = false
         */

        // Short circuit
        boolean a = true;
        boolean b = false;

        System.out.println("a && b = " + (a && b));
        System.out.println("a || b = " + (a || b));
        System.out.println("!a = " + (!a));
        System.out.println("!b = " + (!b));

        boolean trueValueOne = true;
        boolean trueValueTwo = true;
        boolean falseValueOne = false;
        boolean falseValueTwo = false;

        // Membalikan sebuah nilai boolean
        System.out.println("\nLogical Not (!) Operator");
        System.out.println("!false = " + (!falseValueOne));
        System.out.println("!true = " + (!trueValueOne));

        // Operator && (logika AND) akan menghasilkan true hanya jika kedua operandnya
        // bernilai true.
        System.out.println("\nLogical And (&&) Operator");
        System.out.println("false && false = " + (falseValueOne && falseValueTwo));
        System.out.println("true && false = " + (trueValueOne && falseValueTwo));
        System.out.println("false && true = " + (falseValueOne && trueValueTwo));
        System.out.println("true && true = " + (trueValueOne && trueValueTwo));

        // Operator || (logika OR) akan menghasilkan true jika salah satu operan
        // bernilai true
        System.out.println("\nLogical Or (||) Operator");
        System.out.println("false || false = " + (falseValueOne || falseValueTwo));
        System.out.println("true || false = " + (trueValueOne || falseValueTwo));
        System.out.println("false || true = " + (falseValueOne || trueValueTwo));
        System.out.println("true || true = " + (trueValueOne || trueValueTwo));

        // intinya operator ini akan menghasilkan true kalau salah satu inputnya true,
        // tapi bukan keduanya.
        System.out.println("\nLogical Xor (^) Operator");
        System.out.println("false ^ false = " + (falseValueOne ^ falseValueTwo));
        System.out.println("true ^ false = " + (trueValueOne ^ falseValueTwo));
        System.out.println("false ^ true = " + (falseValueOne ^ trueValueTwo));
        System.out.println("true ^ true = " + (trueValueOne ^ trueValueTwo));

    }
}
