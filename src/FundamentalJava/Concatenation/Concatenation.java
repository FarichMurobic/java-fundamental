package FundamentalJava.Concatenation;

/**
 * CONCATENATION (PENYAMBUNGAN STRING)
 * ------------------------------------------------------------
 *
 * Concatenation adalah proses menggabungkan dua atau lebih String
 * menjadi satu String baru.
 *
 * Di Java, operasi concatenation menggunakan operator:
 *
 * +
 *
 * Operator ini akan menyambungkan String yang berada di sebelah
 * kiri dengan String yang berada di sebelah kanan.
 *
 * ------------------------------------------------------------
 * CONTOH DASAR CONCATENATION
 * ------------------------------------------------------------
 *
 * String s1 = "Hello";
 * String s2 = " World";
 *
 * String hasil = s1 + s2;
 *
 * Hasil:
 *
 * Hello World
 *
 * Flow:
 *
 * "Hello"
 * + " World"
 * -> "Hello World"
 *
 * ------------------------------------------------------------
 * CONCATENATION DENGAN TIPE DATA LAIN
 * ------------------------------------------------------------
 *
 * Operator concatenation (+) tidak hanya dapat digunakan
 * untuk menggabungkan String dengan String.
 *
 * Java juga mengizinkan penggabungan String dengan:
 *
 * - int
 * - long
 * - float
 * - double
 * - char
 * - boolean
 * - Object
 *
 * Sebelum proses penggabungan dilakukan, Java akan mengubah
 * nilai tersebut menjadi String secara otomatis.
 *
 * Contoh:
 *
 * int umur = 20;
 *
 * String info = "Umur: " + umur;
 *
 * Hasil:
 *
 * Umur: 20
 *
 * Flow:
 *
 * int 20
 * -> dikonversi menjadi String "20"
 * -> digabung dengan "Umur: "
 * -> "Umur: 20"
 *
 * ------------------------------------------------------------
 * CONCATENATION DENGAN CHARACTER
 * ------------------------------------------------------------
 *
 * Character juga akan dikonversi menjadi String sebelum
 * proses concatenation dilakukan.
 *
 * Contoh:
 *
 * char grade = 'A';
 *
 * String hasil = "Nilai: " + grade;
 *
 * Hasil:
 *
 * Nilai: A
 *
 * Flow:
 *
 * char 'A'
 * -> String "A"
 * -> Concatenation
 * -> "Nilai: A"
 *
 * ------------------------------------------------------------
 * URUTAN EVALUASI OPERATOR +
 * ------------------------------------------------------------
 *
 * Ketika operator + digunakan bersama angka dan String,
 * urutan evaluasi menjadi sangat penting.
 *
 * Contoh:
 *
 * System.out.println(10 + 20 + " Java");
 *
 * Hasil:
 *
 * 30 Java
 *
 * Flow:
 *
 * 10 + 20
 * -> 30
 *
 * 30 + " Java"
 * -> "30 Java"
 *
 * Contoh lain:
 *
 * System.out.println("Java " + 10 + 20);
 *
 * Hasil:
 *
 * Java 1020
 *
 * Flow:
 *
 * "Java " + 10
 * -> "Java 10"
 *
 * "Java 10" + 20
 * -> "Java 1020"
 *
 * Karena setelah String muncul, operator + akan dianggap
 * sebagai operator concatenation.
 *
 * ------------------------------------------------------------
 * PANJANG STRING (STRING LENGTH)
 * ------------------------------------------------------------
 *
 * Untuk mengetahui jumlah karakter yang dimiliki sebuah String,
 * digunakan method:
 *
 * length()
 *
 * Bentuk umum:
 *
 * stringObject.length()
 *
 * Method ini mengembalikan jumlah karakter yang terdapat
 * di dalam String.
 *
 * Contoh:
 *
 * String str = "Java";
 *
 * int panjang = str.length();
 *
 * Hasil:
 *
 * 4
 *
 * Karena String "Java" memiliki:
 *
 * J -> 1 karakter
 * a -> 1 karakter
 * v -> 1 karakter
 * a -> 1 karakter
 *
 * Total:
 *
 * 4 karakter
 *
 * ------------------------------------------------------------
 * KARAKTER SPASI JUGA DIHITUNG
 * ------------------------------------------------------------
 *
 * Method length() menghitung seluruh karakter yang ada
 * di dalam String, termasuk spasi.
 *
 * Contoh:
 *
 * String str = "Hello World";
 *
 * System.out.println(str.length());
 *
 * Hasil:
 *
 * 11
 *
 * Karena:
 *
 * H e l l o _ W o r l d
 *
 * Spasi (_) juga dihitung sebagai karakter.
 *
 * ------------------------------------------------------------
 * ISTILAH PENTING
 * ------------------------------------------------------------
 *
 * String
 * -> Kumpulan karakter yang merepresentasikan teks.
 *
 * Concatenation
 * -> Proses menggabungkan dua atau lebih String.
 *
 * Operator +
 * -> Operator yang digunakan untuk concatenation String.
 *
 * Automatic Type Conversion
 * -> Konversi otomatis tipe data menjadi String saat
 *    proses concatenation.
 *
 * length()
 * -> Method untuk mendapatkan jumlah karakter dalam String.
 *
 * ------------------------------------------------------------
 * KESIMPULAN
 * ------------------------------------------------------------
 *
 * Concatenation adalah proses menyambungkan String menggunakan
 * operator (+).
 *
 * Java dapat melakukan concatenation antara String dan tipe data
 * lain dengan cara mengonversi nilai tersebut menjadi String
 * secara otomatis.
 *
 * Flow:
 *
 * Data Lain
 * -> Konversi ke String
 * -> Concatenation
 * -> String Baru
 *
 * Untuk mengetahui jumlah karakter dalam String digunakan:
 *
 * length()
 *
 * Method ini menghitung seluruh karakter yang ada di dalam
 * String, termasuk spasi.
 */

public class Concatenation {
    public static void main(String[] args) {

        String a = "Hello";
        String b = "World";
        String c = a + " " + b;
        String d = "" + 22;
        System.out.println(c + "\n");

        System.out.println("--------------------");

        System.out.println("\n\tHello");
        System.out.println("This line concatenates" + " two strings");
        System.out.println("This " + "line " + "Concatenation " + "4 Strings");
        System.out.println("\n\n\n\tBye Now");

        // Operator penggabungan (+) juga dapat digunakan untuk menggabungkan sebuah String dengan nilai numerik atau karakter.

        int umur = 26;
        System.out.println("Umur saya adalah: " + umur + "\n");

        System.out.println("--------------------\n");

        // Penjelasan: Java otomatis mengubah 25 menjadi "25" sebelum digabung dengan String lainnya.

        // Operator + dalam Java dapat digunakan bukan hanya untuk penjumlahan angka, tapi juga untuk menggabungkan (concatenate) String.

        // String + Int
        System.out.println("Total = " + 10); // Total = 10
        // String + Char
        System.out.println("Grade = " + 'A'); // Grade A

        // Integer + Integer + String
        System.out.println(10 + 10 + " Units"); // 20 Units
        System.out.println("Units = " + 5 + 500); // Units 5500
        System.out.println("Units = " + (5 + 500)); // Units 505

        /**
         * Kesimpulan:
         * Operator + menggabungkan String, dan angka/karakter otomatis dikonversi ke String jika digunakan bersama String.
         * Perhatikan urutan evaluasi. Gunakan tanda kurung jika ingin angka dijumlahkan dulu sebelum digabungkan ke String.
         */

        System.out.println("\n-----------------------------\n");

        // Demonstration of concatenation operation in mixed mode

        System.out.println("(1)\t 1600 + \" Pensylvania Avenue\" is ");
        System.out.println(1600 + " Pensylvania Avenue");
        System.out.print("(2)\t \"Pensylvania Avenue \" + 1600 is ");
        System.out.println("Pensylvania Avenue " + 1600);
        System.out.print("(3)\t 563 + 34 is ");
        System.out.println( 563 + 34);
        System.out.print("(4)\t \"Victoria, NE \" + 563 + 34 is ");
        System.out.println("Victoria, NE " + 563 + 34);
        System.out.print("(5)\t 563 + 34 + \" Victoria, NE \" is ");
        System.out.println(563 + 34 + " Victoria, NE ");
        System.out.print("(6)\t \"Victoria, NE \" + (563 + 34) is ");
        System.out.println("Victoria, NE " + (563 + 34));
        System.out.print("(7)\t \"Victoria, \" + \'N\' + \'E\' + \' \' + 56334 is ");
        System.out.println("Victoria, " + 'N' + 'E' + ' ' + 56334);
        System.out.print("(8)\t 563 * 34 is ");
        System.out.println( 563 * 34);
        System.out.print("(9)\t \"Victoria, NE \" + 563 * 34 is ");
        System.out.println("Victoria, NE " + 563 * 34 );
        System.out.print("(10)\t 563 * 34 + \" Victoria, NE \" is ");
        System.out.println(563 * 34 + " Victoria, NE ");
        System.out.print("(11)\t \"Victoria, NE \" + (563 * 34) is ");
        System.out.println("Victoria, NE " + (563 * 34));

        System.out.println("\n--------------------\n");

        System.out.print("(1)\t 1 + 1 adalah = ");
        System.out.println(1 + 1 + ", " + "2 " + "Adalah operasi \"1 + 1 =\"");
        System.out.print("(2)\t 2 + 2 Adalah " + (2 + 2) + ", ");
        System.out.println(2 + 2 + " is value of \"2 + 2\"");
        System.out.println("(3)\t \"Value loyalti above all else\"");
    }
}
