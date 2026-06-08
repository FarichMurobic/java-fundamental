package Casting;

/*

Konversi Tipe dan Casting

Seringkali kita perlu memberikan nilai dari satu tipe data ke variabel tipe data lain. Jika kedua
tipe tersebut kompatibel, Java akan melakukan konversi secara otomatis. Contohnya, dari
int ke long. Namun, jika tidak kompatibel (misal dari double ke byte), Java tidak akan
melakukannya secara otomatis. Untuk itu, lo harus menggunakan Cast (konversi eksplisit).

Konversi Otomatis Java
Terjadi jika dua syarat terpenuhi:
1. Kedua tipe data kompatibel.
2. Tipe tujuan punya kapasitas lebih besar dari tipe asal (Widening Conversion).
Contoh: int ke double itu otomatis karena double lebih besar.

Casting Tipe yang Tidak Kompatibel
Jika lo mau memasukkan nilai dari tipe besar ke tipe yang lebih kecil (Narrowing Conversion),
lo harus pakai Cast. Bentuk umumnya: (target-type) nilai.

Ada dua hal yang perlu diwaspadai saat casting:
1. Truncation (Pemotongan): Mengubah desimal (double/float) ke angka bulat (int).
   Bagian komanya bakal langsung dibuang (bukan dibulatkan).
2. Modulo (Sisa Bagi): Jika angka terlalu besar untuk ditampung tipe tujuan, 
   angkanya akan "berputar" sesuai jangkauan tipe tersebut.

*/

public class Casting {
    public static void main(String[] args) {
        
        byte b;
        int i = 257;
        double d = 323.142;

        System.out.println("\nKonversi dari int ke byte.");
        // Angka 257 terlalu besar untuk byte (maks 127).
        // Hasilnya adalah sisa bagi: 257 % 256 = 1.
        b = (byte) i;
        System.out.println("Nilai i dan b: " + i + " " + b);

        System.out.println("\nKonversi dari double ke int.");
        // Bagian desimal (.142) akan dibuang (truncation).
        i = (int) d;
        System.out.println("Nilai d dan i: " + d + " " + i);

        System.out.println("\nKonversi dari double ke byte.");
        // Desimal dibuang, lalu angka 323 dicari sisa baginya terhadap 256.
        // 323 % 256 = 67.
        b = (byte) d;
        System.out.println("Nilai d dan b: " + d + " " + b);

        // Narrowing atau Penyempitan Casting (secara manual) - mengubah tipe yang lebih besar menjadi tipe ukuran yang lebih kecil.
        // double-> float-> long-> int-> char-> short->byte

        double castingBro = 100;
        System.out.println("Nilai awal masih bertipe Double: " + castingBro);
        float casting1 =
                (float) castingBro;
        System.out.println("Nilai Double menjadi Float: " + casting1);
        long casting2 =
                (long) casting1;
        System.out.println("Nilai Float menjadi Long: " + casting2);
        int casting3 =
                (int) casting2;
        System.out.println("Nilai Long menjadi Integer: " + casting3);
        short casting4 =
                (short) casting3;
        System.out.println("Nilai Integer menjadi Short: " + casting4);
        byte casting5 =
                (byte) casting4;
        System.out.println("Nilai Short menjadi Byte: " + casting5);

        System.out.println("-------------------");

        double doubelKu = 100;
        System.out.println(doubelKu);
        float floatKu = (float) doubelKu;
        System.out.println(floatKu);
        long longKu = (long) floatKu;
        System.out.println(longKu);
        int integerKu = (int) longKu;
        System.out.println(integerKu);
        short shortKu = (short) integerKu;
        System.out.println(shortKu);
        byte byteKu = (byte) shortKu;

        double bro = 50;
        System.out.println("Narrowing Casting: " +
                "Double: " + (double) (bro) + " => " +
                "Float: " +  (float) (bro) + " => " +
                "Long: " + (long) (bro) + " => " +
                "Integer: " +  (int) (bro) + " => " +
                "Short: " +  (short) (bro) + " => " +
                "Byte: " +  (byte) (bro));

        System.out.println("\n");
        System.out.println("--- Widening Casting (Otomatis) ---");

        byte byte1 = 40;
        byte byte2 = 50;
        byte byte3 = 100;
        int int1 = byte1 * byte2 / byte3;
        System.out.println(int1);

        /**
         * The code is attempting to store 50 * 2, a perfectly valid byte value, back into a byte
         * variable. However, because the operands were automatically promoted to int when the
         * expression was evaluated, the result has also been promoted to int. Thus, the result of the
         * expression is now of type int, which cannot be assigned to a byte without the use of a cast.
         * This is true even if, as in this particular case, the value being assigned would still fit in the
         * target type.
         * In cases where you understand the consequences of overflow, you should use an explicit
         * cast, such as
         */

        byte thisByte = 50;
        // thisByte = thisByte * 2; // Error!
        thisByte = (byte) (thisByte * 2);
        System.out.println(thisByte);

        byte iniByte = 100;
        System.out.println("Nilai awal masih bertipe Byte: " + iniByte);
        short iniShort = iniByte;
        System.out.println("Nilai Byte menjadi Short: " + iniShort);
        int iniInt = iniShort;
        System.out.println("Nilai Short menjadi Integer: " + iniInt);
        long iniLong = iniInt;
        System.out.println("Nilai Int eger menjadi Long: " + iniLong);
        float iniFloat = iniLong;
        System.out.println("Nilai Long menjadi Float: " + iniFloat);
        double iniDoule = iniFloat;
        System.out.println("Nilai Float menjadi Double: " + iniDoule);

        System.out.println("-------------------");

        // Casting dalam Println bro hehehe, meskipun otomatis tetep masukin tanda kurung bro!

        byte iniByte1 = 50;
        System.out.println((short) (iniByte1));
        System.out.println((int) (iniByte1));
        System.out.println((long) (iniByte1));
        System.out.println((float) (iniByte1));
        System.out.println((double) (iniByte1));

        byte iniByte2 = 10;
        System.out.println("Widening Casting: " +
                "Byte: " + (byte) (iniByte2) + " => " +
                "Short: " +  (short) (iniByte2) + " => " +
                "Integer: " + (int) (iniByte2) + " => " +
                "Long: " +  (long) (iniByte2) + " => " +
                "Float: " +  (float) (iniByte2) + " => " +
                "Double: " +  (double) (iniByte2));

        System.out.println("\n");
        System.out.println("--- The Promotion Rules ---");

        /**
         * The Type Promotion Rules
         * Java defines several type promotion rules that apply to expressions. They are as follows: First,
         * all byte, short, and char values are promoted to int, as just described. Then, if one operand
         * is a long, the whole expression is promoted to long. If one operand is a float, the entire
         * expression is promoted to float. If any of the operands are double, the result is double.
         * The following program demonstrates how each value in the expression gets promoted
         * to match the second argument to each binary operator:
         */

        byte byteAwal = 42;
        char charAwal = 'a';
        short shortAwal = 1024;
        int intAwal = 50000;
        float floatAwal = 5.67f;
        double doubleAwal = .1234;
        double hasilAkhir = (floatAwal * byteAwal) + (intAwal / charAwal) - (doubleAwal * shortAwal);
        System.out.println((floatAwal * byteAwal) + " + " + (intAwal / charAwal) + " - " + (doubleAwal * shortAwal));
        System.out.println("Hasil = " + hasilAkhir);

        /**
         * Let’s look closely at the type promotions that occur in this line from the program:
         * double result = (f * b) + (i / c) - (d * s);
         * In the first subexpression, f * b, b is promoted to a float and the result of the subexpression
         * is float. Next, in the subexpression i/c, c is promoted to int, and the result is of type int.
         * Then, in d * s, the value of s is promoted to double, and the type of the subexpression is
         * double. Finally, these three intermediate values, float, int, and double, are considered. The
         * outcome of float plus an int is a float. Then the resultant float minus the last double is
         * promoted to double, which is the type for the final result of the expression.
         */

        System.out.println("\n");
        System.out.println("--- Casting Char Integer Type dan Floating Point Type ---");

        // Casting antara char, integer dan double

        char    karakter1 = 'J', karakter7  = 'F',
                karakter2 = 'A', karakter8  = 'A',
                karakter3 = 'N', karakter9  = 'R',
                karakter4 = 'E', karakter10 = 'B',
                karakter5 = 'R', karakter11 = 'I',
                karakter6 = 'A', karakter12 = 'C';

        System.out.print ("" + // Ingat kalo gak ada String yang di cetak langsung int broo
                karakter1 + karakter2 + karakter3 +
                karakter4 + karakter5 + karakter6 +
                karakter7 + karakter8 + karakter9 +
                karakter10 +
                karakter11 +
                karakter12 +
                "\n");

        // HELLO WORLD WKWK

        byte charByte = (byte) karakter1;
        System.out.println(charByte);
        short charShort = (short) karakter2;
        System.out.println(charShort);
        int charInt = (int) karakter3;
        System.out.println(charInt);
        long charLong = (long) karakter4;
        System.out.println(charLong);
        float charFloat = karakter5;
        System.out.println(charFloat);
        double charDouble = (double) karakter6;
        System.out.println(charDouble);

        System.out.println((byte) karakter7);
        System.out.println((short) karakter8);
        System.out.println((int) karakter9);
        System.out.println((long) karakter10);
        System.out.println((float) karakter11);
        System.out.println((double) karakter12);

        System.out.println("-------------------");

        // Angka ke Char juga bisa broooooooo

        int intToChar = 50;
        System.out.println((char) (intToChar));
        double doubleToChar = 10.0;
        System.out.println((char) (doubleToChar)); // Kayaknya jadi character spasi atau enter kosong gitu dehh wkwkwk

        System.out.println("-------------------\n");

        double myDouble1 = 9.78d;
        int myInt1 = (int) myDouble1; // Manual casting: double to int

        System.out.println(myDouble1);   // Outputs 9.78
        System.out.println(myInt1);      // Outputs 9

        System.out.println("--- Casting Char Integer Type dan Floating Point Type ---");

        // Contoh Kehidupan Nyata

        int maxScore = 1000;
        int userScore = 823;
        float percentage = maxScore / userScore * 200.0f;

        System.out.println("User's score : " + percentage);

        int angka = 100;
        double hasil = angka; // Implisit casting / otomatis
        System.out.println("Implicit casting (int to double): " + hasil);

        double desimal = 99.99;
        int bulat = (int) desimal; // Explicit casting
        System.out.println("Explicit casting (double to int): " + bulat);

    }
}
