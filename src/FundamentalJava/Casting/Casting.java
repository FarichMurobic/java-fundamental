package FundamentalJava.Casting;

/**
 * ---------------------------------------------------------------------------
 * KONVERSI TIPE DATA DAN CASTING (TYPE CONVERSION & CASTING)
 * ---------------------------------------------------------------------------
 *
 * Dalam pemrograman Java, sering kali kita perlu memindahkan nilai
 * dari satu tipe data ke tipe data lainnya..
 *
 * Contoh:
 *
 * int -> long
 * int -> double
 * double -> int
 * long -> byte
 *
 * Java menyediakan dua mekanisme utama:
 *
 * - Konversi Otomatis (Automatic Type Conversion)
 * - Casting (Explicit Type Conversion)
 *
 * Flow:
 * Nilai Tipe Asal
 * -> Konversi Otomatis atau Casting
 * -> Tipe Tujuan
 *
 * ---------------------------------------------------------------------------
 * KONVERSI OTOMATIS (AUTOMATIC TYPE CONVERSION)
 * ---------------------------------------------------------------------------
 *
 * Java akan melakukan konversi tipe secara otomatis apabila dua
 * syarat berikut terpenuhi:
 *
 * - Kedua tipe data kompatibel.
 * - Tipe tujuan memiliki kapasitas lebih besar daripada tipe asal.
 *
 * Proses ini disebut:
 *
 * Widening Conversion
 *
 * atau:
 *
 * Widening Casting
 *
 * Karena nilai dipindahkan ke tipe data yang lebih besar,
 * risiko kehilangan data sangat kecil atau tidak ada.
 *
 * ---------------------------------------------------------------------------
 * CONTOH WIDENING CONVERSION
 * ---------------------------------------------------------------------------
 *
 * int number = 100;
 * long data = number;
 *
 * Flow:
 * int
 * -> long
 *
 * Konversi dilakukan secara otomatis oleh Java.
 *
 * ---------------------------------------------------------------------------
 *
 * Contoh lain:
 *
 * int number = 100;
 * double result = number;
 *
 * Flow:
 * int
 * -> double
 *
 * Hasil:
 *
 * 100
 * -> 100.0
 *
 * Java otomatis menambahkan representasi desimal.
 *
 * ---------------------------------------------------------------------------
 * URUTAN WIDENING CONVERSION
 * ---------------------------------------------------------------------------
 *
 * byte
 * -> short
 * -> int
 * -> long
 * -> float
 * -> double
 *
 * serta:
 *
 * char
 * -> int
 * -> long
 * -> float
 * -> double
 *
 * Semakin ke kanan, kapasitas tipe data semakin besar.
 *
 * ---------------------------------------------------------------------------
 * CASTING (EXPLICIT TYPE CONVERSION)
 * ---------------------------------------------------------------------------
 *
 * Jika nilai dipindahkan dari tipe yang lebih besar ke tipe yang
 * lebih kecil, Java tidak akan melakukannya secara otomatis.
 *
 * Programmer harus melakukan konversi secara eksplisit menggunakan:
 *
 * Cast
 *
 * Sintaks:
 *
 * (targetType) value
 *
 * Contoh:
 *
 * double d = 100.45;
 * int i = (int) d;
 *
 * Flow:
 * double
 * -> cast
 * -> int
 *
 * Karena berpotensi menyebabkan kehilangan data, Java meminta
 * programmer untuk melakukannya secara sadar.
 *
 * ---------------------------------------------------------------------------
 * NARROWING CONVERSION
 * ---------------------------------------------------------------------------
 *
 * Konversi dari tipe besar ke tipe kecil disebut:
 *
 * Narrowing Conversion
 *
 * atau:
 *
 * Narrowing Casting
 *
 * Contoh:
 *
 * double
 * -> float
 * -> long
 * -> int
 * -> short
 * -> byte
 *
 * Semakin kecil tipe tujuan, semakin besar risiko kehilangan data.
 *
 * ---------------------------------------------------------------------------
 * TRUNCATION (PEMOTONGAN DESIMAL)
 * ---------------------------------------------------------------------------
 *
 * Salah satu efek yang paling sering terjadi saat casting adalah:
 *
 * Truncation
 *
 * yaitu pemotongan bagian desimal.
 *
 * Contoh:
 *
 * double d = 123.99;
 * int i = (int) d;
 *
 * Hasil:
 *
 * i = 123
 *
 * Perhatikan:
 *
 * 0.99 tidak dibulatkan.
 *
 * Bagian desimal langsung dibuang.
 *
 * Flow:
 * 123.99
 * -> cast ke int
 * -> 123
 *
 * ---------------------------------------------------------------------------
 * CASTING BUKAN PEMBULATAN
 * ---------------------------------------------------------------------------
 *
 * Banyak programmer pemula mengira casting akan membulatkan
 * angka.
 *
 * Ini salah.
 *
 * Contoh:
 *
 * double d = 9.99;
 * int i = (int) d;
 *
 * Hasil:
 *
 * i = 9
 *
 * Bukan:
 *
 * i = 10
 *
 * Karena casting melakukan pemotongan, bukan pembulatan.
 *
 * ---------------------------------------------------------------------------
 * MODULO (OVERFLOW SAAT CASTING)
 * ---------------------------------------------------------------------------
 *
 * Jika nilai yang dicasting melebihi jangkauan tipe tujuan,
 * maka sebagian informasi akan hilang.
 *
 * Nilai yang dihasilkan mengikuti representasi biner dari tipe
 * tujuan.
 *
 * Contoh:
 *
 * int i = 130;
 * byte b = (byte) i;
 *
 * Hasil:
 *
 * b = -126
 *
 * Mengapa?
 *
 * Karena byte hanya mampu menyimpan nilai:
 *
 * -128 sampai 127
 *
 * Nilai 130 berada di luar jangkauan tersebut sehingga terjadi
 * overflow dan hasil akhirnya "berputar" mengikuti representasi
 * biner byte.
 *
 * Flow:
 * 130
 * -> cast ke byte
 * -> overflow
 * -> -126
 *
 * ---------------------------------------------------------------------------
 * KEHILANGAN DATA SAAT CASTING
 * ---------------------------------------------------------------------------
 *
 * Narrowing Conversion dapat menyebabkan:
 *
 * - Hilangnya bagian desimal.
 * - Overflow.
 * - Underflow.
 * - Hilangnya presisi.
 *
 * Oleh karena itu, casting harus digunakan dengan hati-hati.
 *
 * ---------------------------------------------------------------------------
 * CONTOH GABUNGAN
 * ---------------------------------------------------------------------------
 *
 * double amount = 12345.67;
 *
 * int total = (int) amount;
 *
 * Hasil:
 *
 * total = 12345
 *
 * Bagian:
 *
 * .67
 *
 * hilang karena proses truncation.
 *
 * ---------------------------------------------------------------------------
 * ALUR KERJA KONVERSI TIPE
 * ---------------------------------------------------------------------------
 *
 * Widening Conversion
 * -> Tipe Kecil
 * -> Tipe Lebih Besar
 * -> Otomatis
 *
 * Narrowing Conversion
 * -> Tipe Besar
 * -> Tipe Lebih Kecil
 * -> Wajib Casting
 *
 * ---------------------------------------------------------------------------
 * KESIMPULAN
 * ---------------------------------------------------------------------------
 *
 * Java mendukung dua jenis konversi tipe data:
 *
 * - Automatic Type Conversion (Widening Conversion).
 * - Explicit Type Conversion / Casting (Narrowing Conversion).
 *
 * Widening Conversion terjadi secara otomatis ketika tipe tujuan
 * memiliki kapasitas lebih besar.
 *
 * Narrowing Conversion harus dilakukan menggunakan casting:
 *
 * (targetType) value
 *
 * Saat melakukan casting, programmer harus memperhatikan:
 *
 * - Truncation (pemotongan desimal).
 * - Overflow dan Underflow.
 * - Kehilangan presisi data.
 *
 * Karena itu, narrowing conversion harus digunakan secara sadar
 * dan hati-hati agar tidak menghasilkan nilai yang tidak
 * diharapkan.
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

                // Narrowing atau Penyempitan Casting (secara manual) - mengubah tipe yang lebih
                // besar menjadi tipe ukuran yang lebih kecil.
                // double-> float-> long-> int-> char-> short->byte

                double castingBro = 100;
                System.out.println("Nilai awal masih bertipe Double: " + castingBro);
                float casting1 = (float) castingBro;
                System.out.println("Nilai Double menjadi Float: " + casting1);
                long casting2 = (long) casting1;
                System.out.println("Nilai Float menjadi Long: " + casting2);
                int casting3 = (int) casting2;
                System.out.println("Nilai Long menjadi Integer: " + casting3);
                short casting4 = (short) casting3;
                System.out.println("Nilai Integer menjadi Short: " + casting4);
                byte casting5 = (byte) casting4;
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
                                "Float: " + (float) (bro) + " => " +
                                "Long: " + (long) (bro) + " => " +
                                "Integer: " + (int) (bro) + " => " +
                                "Short: " + (short) (bro) + " => " +
                                "Byte: " + (byte) (bro));

                System.out.println("\n");
                System.out.println("--- Widening Casting (Otomatis) ---");

                byte byte1 = 40;
                byte byte2 = 50;
                byte byte3 = 100;
                int int1 = byte1 * byte2 / byte3;
                System.out.println(int1);

                /**
                 * The code is attempting to store 50 * 2, a perfectly valid byte value, back
                 * into a byte
                 * variable. However, because the operands were automatically promoted to int
                 * when the
                 * expression was evaluated, the result has also been promoted to int. Thus, the
                 * result of the
                 * expression is now of type int, which cannot be assigned to a byte without the
                 * use of a cast.
                 * This is true even if, as in this particular case, the value being assigned
                 * would still fit in the
                 * target type.
                 * In cases where you understand the consequences of overflow, you should use an
                 * explicit
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

                // Casting dalam Println bro hehehe, meskipun otomatis tetep masukin tanda
                // kurung bro!

                byte iniByte1 = 50;
                System.out.println((short) (iniByte1));
                System.out.println((int) (iniByte1));
                System.out.println((long) (iniByte1));
                System.out.println((float) (iniByte1));
                System.out.println((double) (iniByte1));

                byte iniByte2 = 10;
                System.out.println("Widening Casting: " +
                                "Byte: " + (byte) (iniByte2) + " => " +
                                "Short: " + (short) (iniByte2) + " => " +
                                "Integer: " + (int) (iniByte2) + " => " +
                                "Long: " + (long) (iniByte2) + " => " +
                                "Float: " + (float) (iniByte2) + " => " +
                                "Double: " + (double) (iniByte2));

                System.out.println("\n");
                System.out.println("--- The Promotion Rules ---");

                /**
                 * The Type Promotion Rules
                 * Java defines several type promotion rules that apply to expressions. They are
                 * as follows: First,
                 * all byte, short, and char values are promoted to int, as just described.
                 * Then, if one operand
                 * is a long, the whole expression is promoted to long. If one operand is a
                 * float, the entire
                 * expression is promoted to float. If any of the operands are double, the
                 * result is double.
                 * The following program demonstrates how each value in the expression gets
                 * promoted
                 * to match the second argument to each binary operator:
                 */

                byte byteAwal = 42;
                char charAwal = 'a';
                short shortAwal = 1024;
                int intAwal = 50000;
                float floatAwal = 5.67f;
                double doubleAwal = .1234;
                double hasilAkhir = (floatAwal * byteAwal) + (intAwal / charAwal) - (doubleAwal * shortAwal);
                System.out.println((floatAwal * byteAwal) + " + " + (intAwal / charAwal) + " - "
                                + (doubleAwal * shortAwal));
                System.out.println("Hasil = " + hasilAkhir);

                /**
                 * Let’s look closely at the type promotions that occur in this line from the
                 * program:
                 * double result = (f * b) + (i / c) - (d * s);
                 * In the first subexpression, f * b, b is promoted to a float and the result of
                 * the subexpression
                 * is float. Next, in the subexpression i/c, c is promoted to int, and the
                 * result is of type int.
                 * Then, in d * s, the value of s is promoted to double, and the type of the
                 * subexpression is
                 * double. Finally, these three intermediate values, float, int, and double, are
                 * considered. The
                 * outcome of float plus an int is a float. Then the resultant float minus the
                 * last double is
                 * promoted to double, which is the type for the final result of the expression.
                 */

                System.out.println("\n");
                System.out.println("--- Casting Char Integer Type dan Floating Point Type ---");

                // Casting antara char, integer dan double

                char karakter1 = 'J', karakter7 = 'F',
                                karakter2 = 'A', karakter8 = 'A',
                                karakter3 = 'N', karakter9 = 'R',
                                karakter4 = 'E', karakter10 = 'B',
                                karakter5 = 'R', karakter11 = 'I',
                                karakter6 = 'A', karakter12 = 'C';

                System.out.print("" + // Ingat kalo gak ada String yang di cetak langsung int broo
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
                System.out.println((char) (doubleToChar)); // Kayaknya jadi character spasi atau enter kosong gitu dehh
                                                           // wkwkwk

                System.out.println("-------------------\n");

                double myDouble1 = 9.78d;
                int myInt1 = (int) myDouble1; // Manual casting: double to int

                System.out.println(myDouble1); // Outputs 9.78
                System.out.println(myInt1); // Outputs 9

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
