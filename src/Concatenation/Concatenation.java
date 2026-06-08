package Concatenation;

    /**
     * Concatenation (Penyambungan) dan Panjang String
     * Concatenation adalah operasi biner (melibatkan dua operan) yang menyambungkan String kedua setelah String pertama.
     *
     * Java menggunakan operator + sebagai operator concatenation.
     * Operator concatenation (+) juga bisa digunakan untuk menggabungkan sebuah String dengan
     * nilai numerik atau karakter. Dalam kasus tersebut, Java pertama-tama akan mengkonversi nilai
     * numerik atau karakter tersebut menjadi sebuah String, lalu barulah menggunakan operator
     * concatenation (+) untuk menyambungkannya.
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
