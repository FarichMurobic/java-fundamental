package FundamentalJava.TipeDataPrimitif;

public class IntegerAndFloatingPoint {
    
    /**
     * Integers (Bilangan Bulat)
     * Java memiliki empat tipe data integer, semuanya bertanda (signed) yang berarti bisa
     * menyimpan nilai positif dan negatif. Java tidak memiliki tipe data integer tak bertanda (unsigned).
     *
     *  1, Byte      -128 to 127                                                 1 byte  (8 bits)
     *  2, Short     -32768 to 32767                                             2 bytes (16 bits)
     *  3, Int       -2,147,483,648 to 2,147,483,647                             4 bytes (32 bits)
     *  4, Long      -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807     8 bytes (64 bits)
     *
     *  Untuk membuat literal long, lo harus menambahkan L atau l di akhir angka, misalnya 9223372036854775807L
     *
     *  Secara default, setiap nilai bilangan bulat adalah literal int (32-bit). Lo bisa menuliskannya dalam berbagai basis:
     *
     *  1. Desimal (basis 10): Contohnya 10, 42.
     *  2. Oktal (basis 8): Ditandai dengan awalan 0 (nol). Contoh: 010 (sama dengan 8 dalam desimal).
     *     Angka 8 dan 9 tidak diizinkan dalam format ini.
     *  3. Heksadesimal (basis 16): Ditandai dengan awalan 0x atau 0X. Contoh:
     *     0x10 (sama dengan 16 dalam desimal). Angka 10-15 diwakili oleh huruf A-F.
     *  4. Biner (basis 2): Ditambahkan sejak JDK 7. Ditandai dengan awalan 0b atau 0B.
     *     Contoh: 0b1010 (sama dengan 10 dalam desimal).
     *
     * Floating-Point (Angka Desimal)
     * Tipe ini digunakan untuk angka dengan presisi pecahan.
     *
     * 1, Float         1.4e–045 to 3.4e+038        4 bytes (32 bits)
     * 2, Double        4.9e–324 to 1.8e+308        8 bytes (64 bits)
     *
     *  Pemakaian floating di berbagai number:
     *  1, Desimal - boleh
     *  2, Oktal - tidak bisa untuk floating point
     *  3, Heksadesimal - boleh, tapi hanya dengan p notation (scienfitic hex)
     *     formatnya: 0x bilangan heksa p (eksponen berbasis 2)
     *  4, Biner tidak bisa untuk floatijng point
     */

    public static void main(String[] args) {

        System.out.println("--- Tipe data Integer ---");

        // byte, Sangat kecil, cocok untuk data mentah dari file atau jaringan.
        byte iniByteMinus = -128;
        System.out.println("Ini byte batas minus: " + iniByteMinus);
        byte iniBytePlus = 127;
        System.out.println("Ini byte batas plus: " + iniBytePlus);

        // short, Jarang digunakan, biasanya digantikan oleh int karena promosi tipe.
        short iniShortMinus = -32768;
        System.out.println("Ini batas short minus: " + iniShortMinus);
        short iniShortPlus = 32767;
        System.out.println("Ini batas short plus: " + iniShortPlus);

        // int, Tipe integer yang paling sering digunakan. Sangat ideal untuk penghitung loop.
        int iniIntMinus = -2147483648;
        System.out.println("Ini int batas minus: " + iniIntMinus);
        int iniIntPlus = 2147483647;
        System.out.println("Ini int batas plus: " + iniIntPlus);

        // long, Digunakan saat int tidak cukup besar, seperti pada perhitungan jarak cahaya.
        long iniLongMinus = -9223372036854775808L; // Note diakhiri huruf L untuk setiap Long
        System.out.println("Ini batas long minus: " + iniLongMinus);
        long iniLongPlus = 9223372036854775807L; // Note diakhiri huruf L untuk setiap Long
        System.out.println("Ini batas long plus: " + iniLongPlus);

        System.out.println("\n--- Literal integer bilangan desimal basis 10 ---");
        /**
         * Desimal (basis 10): Contohnya 10, 42.
         * digit 0-9 (yang biasa kita pakai sehari-hari)
         */

        int desimal1 = 10;
        System.out.println(desimal1);
        int desimal2 = 42;
        System.out.println(desimal2);

        System.out.println("\n--- Literal integer bilangan oktal basis 8 ---");
        /**
         * Oktal (basis 8): Ditandai dengan awalan 0 (nol). Contoh: 010 (sama dengan 8 dalam desimal).
         * Angka 8 dan 9 tidak diizinkan dalam format ini.
         * digit 0-7
         * jadi kalau sebuah angka diawali nol (0) dan hanya pakai digit 0-7
         * java otomatis anggap itu oktal, bukan desimal
         */

        int oktal1 = 010; // 8 dalam desimal
        System.out.println(oktal1);
        int oktal2 = 011; // 9 dalam desimal
        System.out.println(oktal2);
        int oktal3 = 012; // 10 dalam desimal
        System.out.println(oktal3);
        int oktal4 = 077; // 63 dalam desimal
        System.out.println(oktal4);
        int oktalMinus = -012; // -10, minus -10 dalam desimal
        System.out.println(oktalMinus);
        // int oktal5 = 08; // ini akan error, karena angka 8 tidak ada di oktal
        // int oktal6 = 09; // ini akan error, karena angka 9 tidak ada di oktal

        System.out.println("\n--- Literal Heksadesimal basis 16 ---");
        /**
         * Heksadesimal (basis 16): Ditandai dengan awalan 0x atau 0X. Contoh: 0x10
         * 0x10 (sama dengan 16 dalam desimal). Angka 10-15 diwakili oleh huruf A-F.
         * digit 0-9, dan A-F (Case Sensitif)
         */

        int heksaDesimal1 = 0xA; // 10 desimal
        System.out.println(heksaDesimal1);
        int heksaDesimal2 = 0x1F; // 31 desimal
        System.out.println(heksaDesimal2);
        int heksaDesimal3 = 0x10; // 16 desimal
        System.out.println(heksaDesimal3);
        int heksaDesimalMinus = -0xA; // -10
        System.out.println(heksaDesimalMinus);
        // int heksaDesimal4 = 0xg; // akan error, karena g bukan digit valid heksadesimal (maksimum F)

        // Contoh lain heksadesimal
        int intHexa = 0xA132B;
        System.out.println(intHexa); // 660267
        long longHexa = 0xA132BL;
        System.out.println(longHexa); // 660267
        float floatHexa = 0xA132B;
        System.out.println(floatHexa); // 660267.0
        double doubleHexa = 0xA132B;
        System.out.println(doubleHexa); // 660267.0

        System.out.println("\n--- Literal biner basis 2 ---");
        /**
         * Biner (basis 2): Ditambahkan sejak JDK 7. Ditandai dengan awalan 0b atau 0B. Contoh:
         * 0b1010 (sama dengan 10 dalam desimal).
         */

        int biner1 = 0b1010; // biner 1010 = desimal 10
        System.out.println(biner1);
        int biner2 = 0b1111; // biner 1111 = desimal 15
        System.out.println(biner2);
        int biner3 = 0b100000; // biner 100000 = desimal 32

        /**
         * penjelasan perhitungan biner ke desimal
         * 0b1010 dihitung sebagai
         * (1 x 2^3) + (0 x 2^2) + (1 x 2^1) + (1 x 2^0) = 8 + 0 + 2 + 0 = 10 (desimal)
         * 0b1111 dihitung sebagai
         * (1 x 2^3) + (1 x 2^2) + (1 x 2^1) + (1 x 2^0) = 8 + 4 + 2 + 1 = 15
         * 0b100000
         * (1 x 2^5) + (0 x 2^4) + (0 x 2^3) + (0 x 2^2) + (0 x 2^1) + (0 x 2^0) = 32 + 0 + 0 + 0 + 0 = 32
         */

        // contoh lanjutan
        int intBinary = 0b10101010;
        System.out.println(intBinary);
        long longBinary = 0b10101010;
        System.out.println(longBinary);
        float floatBinary = 0b10101010;
        System.out.println(floatBinary);
        double doubleBinary = 0b10101010;
        System.out.println(doubleBinary);

        /**
         * Note : Seperti konversi dari Hexa dan Binary ke tipe data yang diatas,
         * mungkin byte dan short bisa kalau nilai dari hexa dan biner mencakup kapasitasnya.
         */

        System.out.println("\n--- Kode Underscore (_) untuk pemisah di input bukan output ---");

        // Kode Underscore
        int x = 0b1101_0101_0001_1010;
        System.out.println(x);

        byte byteUnderscore = 12_0;
        System.out.println(byteUnderscore);
        short shortUnderscore = 6_000;
        System.out.println(shortUnderscore);
        int intUnderscore = 6_000_000;
        System.out.println(intUnderscore);
        long longUnderscore = 6_000_000_000_000L;
        System.out.println(longUnderscore);
        float floatUnderscore = 6_00.0F;
        System.out.println(floatUnderscore);
        double doubleUnderscore = 6_000_000_000.0;
        System.out.println(doubleUnderscore);

        System.out.println("\n--- Tipe data Floating Point ---");

        // float, Presisi tunggal, lebih kecil. Cocok untuk data yang tidak memerlukan akurasi tinggi.
        float iniFloat = 10.10F; // Note diakhiri huruf F untuk setiap Float
        System.out.println("Ini float: " + iniFloat);
        System.out.println("Kapasitas Float: float Stores fractional numbers. Sufficient for storing 6 to 7 decimal digits");

        // double, Presisi ganda, lebih akurat. Ini adalah pilihan default untuk perhitungan matematis kompleks.
        double iniDouble = 10.10;
        System.out.println("Ini double: " + iniDouble);
        System.out.println("Kapasitas Double: Stores fractional numbers. Sufficient for storing 15 to 16 decimal digits");

        System.out.println("\n--- Floating Point desimal ---");
        double num = 9_423_497_862.0;
        System.out.println(num);
        double num1 = 9_423_497.1_0_9;
        System.out.println(num1);

        System.out.println("\n--- Floating Point heksadesimal ---");
        // catatan p artinya eksponen basis 2, bukan 10
        // jadi p3 = dikali 2^3
        double heksaFloat = 0x1.8p5; // 48.0 dalam desimal (p^5 = 2^5)
        double pi = 0x1.921fb54442d18p1; // 3.141592653589793 dalam desimal

        System.out.println(heksaFloat);
        System.out.println(pi);

    }
}
