package FundamentalJava.Static;

/**
 * Static Import
 *
 * Java punya fitur:
 * static import
 *
 * Fungsinya:
 * biar kita bisa pakai member static (method/variabel) tanpa nulis nama class-nya
 *
 * Masalah Tanpa Static Import
 *
 * Contoh:
 * Math.sqrt(...)
 * Math.pow(...)
 *
 * Harus selalu nulis:
 * Math.
 *
 * Kalau sering dipakai:
 * jadi ribet & panjang
 *
 * ----------------------------
 * 
 * Bentuk Static Import
 * 1. Import satu member
 * import static package.Class.member;
 *
 * Contoh:
 * import static java.lang.Math.sqrt;
 *
 * 2. Import SEMUA member
 * import static package.Class.*;
 *
 * Contoh:
 * import static java.lang.Math.*;
 *
 * bisa pakai:
 * sqrt()
 * pow()
 * sin()
 * dll
 *
 * Risiko Static Import
 * 1. Namespace conflict
 *
 * Kalau ada:
 * sqrt() di class lain
 *
 * bisa tabrakan
 *
 * Kesimpulan Santai
 * static import = hapus kebutuhan nulis nama class
 *
 * Bikin kode:
 * lebih pendek
 * lebih clean
 *
 * Tapi:
 * jangan dipakai berlebihan
 *
 * pakai kalau:
 * sering dipakai berulang
 *
 * Insight Level Pro
 *
 * Gunakan static import untuk:
 * operasi math intensif
 * utility static yang sering dipakai
 *
 * Hindari untuk:
 * System.out
 * hal yang bikin kode ambigu
 */

// STATIC IMPORT
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.System.out;

public class StaticIMPORT {
    public static void main(String[] args) {

        double side1, side2;
        double hypot;

        side1 = 3.0;
        side2 = 4.0;

        // dengan static import, lebih pendek.
        hypot = sqrt(pow(side1, 2) + pow(side2, 2));

        /**
         * Hasilnya:
         * sqrt(pow(...))
         *
         * lebih:
         * pendek
         * bersih
         * enak dibaca
         */

        System.out.println("Given sides of length " + side1 + " and " + side2 +
                " the hypotenusa is " + hypot);

        System.out.println();

        // CONTOH TANPA STATIC IMPORT
        hypot = Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2));

        /**
         * Masalahnya:
         * Math.sqrt(Math.pow(...) + Math.pow(...))
         *
         * terlalu banyak Math.
         */

        System.out.println("Given sides of length " + side1 + " and " + side2 +
                " the hypotenusa is " + hypot);

        out.println();

        // CONTOH LAIN
        out.println("Hello Broo");

    }
}
