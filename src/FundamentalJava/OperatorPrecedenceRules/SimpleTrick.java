package FundamentalJava.OperatorPrecedenceRules;

public class SimpleTrick {
    public static void main(String[] args) {

        /**
         * Aturan prioritas adalah aturan yang menentukan urutan pengerjaan operasi dalam sebuah ekspresi.
         * 
         * -operator assignment adalah yang paling lemah - paling terakhir dikerjakan
         * -operator logika biner lebih lemah dari relational dan aritmetika
         * -operator relational lebih lemah dari aritmetik
         * -operator aritmetik lebih tinggi - operator yang pertama di kerjakan
         *
         * Trik cepat
         * aritmatika
         * relational
         * logika
         * assignent
         *
         * Kalo kita pakai tanda kurung (), tanda kurung selalu punya prioritas paling tinggi
         */

        boolean workCompleted = true;
        boolean errorFound = false;
        char letter = 'J';
        int num1 = 7, num2 = 9, num3 = 20;
        double value1 = 2.25, value2 = 0.452;

        System.out.println("!errorFound is " + (!errorFound));
        // ! (not) punya prioritas tinggi, jadi ifalse = true
        System.out.println("workCompleted && !errorFound is " + (workCompleted && !errorFound));
        // ! lebih tinggi dari &&, jadi (!errorFound) dulu, baru && jadi hasilnya true
        System.out.println("workCompleted || letter == 'P' is " + (workCompleted || letter == 'P'));
        // == lebih tinggi dari ||. jadi (letter == 'P') dulu, baru ||
        System.out.println("num1 + num2 < 15 is " + (num1 + num2 < 15));
        // + lebih tinggi dari <, jadi num1 + num2 duly baru <
        System.out.println("num1 >= 0 && num1 <= 9 is " + (num1 >= 0 && num1 <= 9));
        // >= dan <= lebih tinggi dari &&, jadi dikerjakan dulu
        System.out.println("letter >= 'a' && letter <= 'z' is " + (letter >= 'a' && letter <= 'z'));
        // sama dengan sebelumnya.

        // ini bagian paling penting: perhatikan 2 baris dibawah ini
        System.out.println("value1 < 7.75 || value2 > 0.25 && value2 < 0.45 is " + (value1 < 7.75 || value2 > 0.25 && value2 < 0.45));
        System.out.println("(value1 < 7.75 || value2 > 0.25) && value2 < 0.45) is " + ((value1 < 7.75 || value2 > 0.25) && value2 < 0.45));

        /**
         * penjelasan
         * baris pertama tanpa kurung, && punya prioritas lebih tinggi dari ||, jadi (value2 > 0.25 && value2 < 0.45) dikerjakan duluan
         * hasilnya: true || (true && false) -> true || false -> true.
         * baris kedua pakai tanda kurung. tanda kurung memaksa || dikerjakan duluan,
         * hasilnya: (true || true) && false -> true && false -> false
         */

        /**
         * SINTAKSIS
         * lo tau kan kalau ekspresi (letter >= 'a' && letter <= 'z') dan ('a' <= letter && letter <= 'z') ini sama dan benar
         * tapi lu gak bisa nuis ('a' <= letter <= 'z'), lu butuh operator && buat nentuin nilai ekspresinya
         * intinya operator relational menghasilkan nilai boolean,
         * lu gak bisa menggunakan nilai boolean itu sebagai input untuk operator relational yang lain.
         */

    }
}
