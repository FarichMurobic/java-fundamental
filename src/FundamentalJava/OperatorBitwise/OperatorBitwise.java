package FundamentalJava.OperatorBitwise;

        /**
         * Bitwise Operators
         * Java memiliki beberapa operator bitwise yang bisa digunakan pada tipe integer:
         * -long
         * -int
         * -short
         * -char
         * -byte
         *
         * Operator ini bekerja pada setiap bit individu dari operandnya.
         * Berikut daftar operatornya:
         * Operator	    Fungsi
         * ~	        Bitwise unary NOT
         * &	        Bitwise AND
         * |	        Bitwise OR
         * ^	        Bitwise XOR
         * >>	        Shift right
         * >>>	        Shift right zero fill
         * <<	        Shift left
         * &=	        Bitwise AND assignment
         * |=	        Bitwise OR assignment
         * ^=	        Bitwise XOR assignment
         * >>=	        Shift right assignment
         * >>>=	        Shift right zero fill assignment
         * <<=	        Shift left assignment
         *
         * Karena operator bitwise memanipulasi bit dalam integer, penting untuk memahami:
         * Bagaimana Java menyimpan nilai integer.
         * Bagaimana Java merepresentasikan angka negatif.
         */

public class OperatorBitwise {
    public static void main(String[] args) {
        int a = 5;   // 0101
        int b = 3;   // 0011

        System.out.println("Nilai awal:");
        System.out.println("a = " + a + " (" + toBinary(a) + ")");
        System.out.println("b = " + b + " (" + toBinary(b) + ")");
        System.out.println();

        // AND
        int and = a & b;
        System.out.println("a & b = " + and + " (" + toBinary(and) + ")");

        // OR
        int or = a | b;
        System.out.println("a | b = " + or + " (" + toBinary(or) + ")");

        // XOR
        int xor = a ^ b;
        System.out.println("a ^ b = " + xor + " (" + toBinary(xor) + ")");

        // NOT
        int not = ~a;
        System.out.println("~a = " + not + " (" + toBinary(not) + ")");

        System.out.println();

        // LEFT SHIFT
        int leftShift = a << 1;
        System.out.println("a << 1 = " + leftShift + " (" + toBinary(leftShift) + ")");

        // RIGHT SHIFT
        int rightShift = a >> 1;
        System.out.println("a >> 1 = " + rightShift + " (" + toBinary(rightShift) + ")");

        // UNSIGNED RIGHT SHIFT
        int unsignedShift = a >>> 1;
        System.out.println("a >>> 1 = " + unsignedShift + " (" + toBinary(unsignedShift) + ")");

        System.out.println();

        // Compound assignments
        int c = a;

        c &= b;
        System.out.println("c &= b -> " + c + " (" + toBinary(c) + ")");

        c = a;
        c |= b;
        System.out.println("c |= b -> " + c + " (" + toBinary(c) + ")");

        c = a;
        c ^= b;
        System.out.println("c ^= b -> " + c + " (" + toBinary(c) + ")");

        c = a;
        c <<= 2;
        System.out.println("c <<= 2 -> " + c + " (" + toBinary(c) + ")");

        c = a;
        c >>= 1;
        System.out.println("c >>= 1 -> " + c + " (" + toBinary(c) + ")");

        c = a;
        c >>>= 1;
        System.out.println("c >>>= 1 -> " + c + " (" + toBinary(c) + ")");

        System.out.println("-----------------------------------------------");

        byte byteA, byteB, byteC;
        String bitsA, bitsB, bitsC;

        // Bitwise NOT (~) / Negasi
        // Operator NOT (~) membalik semua bit.
        // Artinya: 1 jadi 0, dan 0 jadi 1, bukan membalikan angka
        // 00011000 = 24 menjadi 11100111 = -25

        System.out.println("--- Bitwise Not (~) ---");
        byteA = 24;
        byteB = (byte) (~byteA); // ini operatornya
        bitsA = String.format("%8s", Integer.toBinaryString(byteA)).replace(' ', '0');
        System.out.printf("%s = %d \n", bitsA, byteA);
        bitsB = String.format("%8s", Integer.toBinaryString(byteB).substring(24));
        System.out.printf("%s = %d \n", bitsB, byteB);

        // Bitwise AND (&)
        // Operator AND (&) menghasilkan 1 hanya jika kedua bit bernilai 1.
        // contph:
        // 00101010 = 42
        // 00001111 = 15
        // 00001010 = 10 hasilnya adalah 10.

        System.out.println("--- Bitwise AND (&) ---");
        byteA = 42;
        bitsA = String.format("%8s", Integer.toBinaryString(byteA)).replace(' ', '0');
        System.out.printf("%s = %d \n", bitsA, byteA);
        byteB = 15;
        bitsB = String.format("%8s", Integer.toBinaryString(byteB)).replace(' ', '0');
        System.out.printf("%s = %d \n", bitsB, byteB);
        byteC = (byte) (byteA & byteB); // ini operatornya
        bitsC = String.format("%8s", Integer.toBinaryString(byteC)).replace(' ', '0');
        System.out.printf("%s = %d \n", bitsC, byteC);

        // Bitwise OR (|)
        // Operator OR (|) menghasilkan 1 jika salah satu bit bernilai 1.
        // Contoh:
        // 00101010 = 42
        // 00001111 = 15
        // 00101111 = 47 hasilnya 47

        System.out.println("--- Bitwise OR (|) ---");
        byteA = 42;
        bitsA = String.format("%8s", Integer.toBinaryString(byteA)).replace(' ', '0');
        System.out.printf("%s = %d \n", bitsA, byteA);
        byteB = 15;
        bitsB = String.format("%8s", Integer.toBinaryString(byteB)).replace(' ', '0');
        System.out.printf("%s = %d \n", bitsB, byteB);
        byteC = (byte) (byteA | byteB); // ini operatornya
        bitsC = String.format("%8s", Integer.toBinaryString(byteC)).replace(' ', '0');
        System.out.printf("%s = %d \n", bitsC, byteC);

        // Bitwise XOR (^)
        // Operator XOR menghasilkan 1 jika bit berbeda.
        // Contoh:
        // 00101010 = 42
        // 00001111 = 15
        // 00100101 = 37 hasilnya 37, dia akan menampilkan 1 jika bit berbeda, jika sama akan 0

        System.out.println("--- Bitwise XOR (^) ---");
        byteA = 42;
        bitsA = String.format("%8s", Integer.toBinaryString(byteA)).replace(' ', '0');
        System.out.printf("%s = %d \n", bitsA, byteA);
        byteB = 15;
        bitsB = String.format("%8s", Integer.toBinaryString(byteB)).replace(' ', '0');
        System.out.printf("%s = %d \n", bitsB, byteB);
        byteC = (byte) (byteA ^ byteB); // ini operatornya
        bitsC = String.format("%8s", Integer.toBinaryString(byteC)).replace(' ', '0');
        System.out.printf("%s = %d \n", bitsC, byteC);

        // Operator Shift left
        // Operator left shift (<<) menggeser semua bit dalam sebuah nilai ke kiri sejumlah tertentu.

        System.out.println("--- Shift Left (<<) ---");
        byteA = 2;
        bitsA = String.format("%8s", Integer.toBinaryString(byteA)).replace(' ', '0');
        System.out.printf("%s = %d \n", bitsA, byteA);
        byteB = (byte) (byteA << 3);
        bitsB = String.format("%8s", Integer.toBinaryString(byteB)).replace(' ', '0');
        System.out.printf("%s = %d \n", bitsB, byteB);

        // Operator shift right
        // Operator right shift (>>) menggeser semua bit dalam suatu nilai ke kanan sejumlah tertentu.

        System.out.println("--- Shift Right (>>) ---");
        byteA = 16;
        bitsA = String.format("%8s", Integer.toBinaryString(byteA)).replace(' ', '0');
        System.out.printf("%s = %d \n", bitsA, byteA);
        byteB = (byte) (byteA >> 2);
        bitsB = String.format("%8s", Integer.toBinaryString(byteB)).replace(' ', '0');
        System.out.printf("%s = %d \n", bitsB, byteB);

    }

    // Fungsi bantu untuk menampilkan binary
    static String toBinary(int x) {
        return String.format("%8s", Integer.toBinaryString(x)).replace(' ', '0');
    }
}
