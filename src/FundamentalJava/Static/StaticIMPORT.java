package FundamentalJava.Static;

/**
 * ------------------------------------------------------------------------
 * STATIC IMPORT
 * ------------------------------------------------------------------------
 * 
 * Java memiliki fitur yang disebut static import.
 * 
 * Fungsinya:
 * Memungkinkan kita menggunakan member static (method/variabel)
 * tanpa harus menuliskan nama class-nya.
 * 
 * ------------------------------------------------------------------------
 * MASALAH TANPA STATIC IMPORT
 * ------------------------------------------------------------------------
 * 
 * Tanpa static import, kita selalu harus menulis nama class:
 * 
 *     Math.sqrt(25.0)
 *     Math.pow(2.0, 3.0)
 *     Math.PI
 * 
 * Jika digunakan berulang kali:
 *     double akar = Math.sqrt(25.0);
 *     double pangkat = Math.pow(2.0, 3.0);
 *     double luas = Math.PI * Math.pow(jariJari, 2.0);
 * 
 * Kode menjadi lebih panjang dan berulang.
 * 
 * ------------------------------------------------------------------------
 * BENTUK STATIC IMPORT
 * ------------------------------------------------------------------------
 * 
 * 1. Import SATU member static
 * 
 *     import static package.Class.member;
 * 
 *     import static java.lang.Math.sqrt;
 *     import static java.lang.Math.PI;
 * 
 *     // Langsung pakai tanpa Math.
 *     double hasil = sqrt(25.0);
 *     double keliling = 2 * PI * jariJari;
 * 
 * 2. Import SEMUA member static
 * 
 *     import static package.Class.*;
 * 
 *     import static java.lang.Math.*;
 * 
 *     // Semua member Math bisa dipakai langsung
 *     double akar = sqrt(25.0);
 *     double pangkat = pow(2.0, 3.0);
 *     double sin = sin(radian);
 * 
 * ------------------------------------------------------------------------
 * CONTOH LENGKAP
 * ------------------------------------------------------------------------
 * 
 * Tanpa static import:
 * 
 *     public class Main {
 *         public static void main(String[] args) {
 *             double x = 9.0;
 *             double y = 16.0;
 * 
 *             double sqrtX = Math.sqrt(x);
 *             double sqrtY = Math.sqrt(y);
 *             double max = Math.max(x, y);
 *             double min = Math.min(x, y);
 * 
 *             System.out.println("√x = " + sqrtX);
 *             System.out.println("√y = " + sqrtY);
 *             System.out.println("Max = " + max);
 *             System.out.println("Min = " + min);
 *         }
 *     }
 * 
 * Dengan static import:
 * 
 *     import static java.lang.Math.sqrt;
 *     import static java.lang.Math.max;
 *     import static java.lang.Math.min;
 * 
 *     public class Main {
 *         public static void main(String[] args) {
 *             double x = 9.0;
 *             double y = 16.0;
 * 
 *             double sqrtX = sqrt(x);    // Tanpa Math.
 *             double sqrtY = sqrt(y);    // Tanpa Math.
 *             double max = max(x, y);    // Tanpa Math.
 *             double min = min(x, y);    // Tanpa Math.
 * 
 *             System.out.println("√x = " + sqrtX);
 *             System.out.println("√y = " + sqrtY);
 *             System.out.println("Max = " + max);
 *             System.out.println("Min = " + min);
 *         }
 *     }
 * 
 * ------------------------------------------------------------------------
 * RISIKO STATIC IMPORT
 * ------------------------------------------------------------------------
 * 
 * 1. Namespace Conflict (Tabrakan Nama)
 * 
 * Jika ada class lain yang memiliki method dengan nama yang sama:
 * 
 *     import static java.lang.Math.sqrt;
 *     import static com.utility.Calculator.sqrt;
 * 
 *     // ERROR! Ambiguous reference: sqrt() tidak jelas mana yang dipakai
 * 
 * Solusi:
 * - Hanya import salah satu
 * - Gunakan fully qualified name untuk yang lain
 * 
 * 2. Kode Menjadi Kurang Jelas
 * 
 * Saat membaca kode:
 * 
 *     double hasil = sqrt(25.0);
 * 
 * Pembaca kode mungkin bingung:
 * sqrt() dari mana? Math? Utilitas lain?
 * 
 * 3. Overuse (Penggunaan Berlebihan)
 * 
 * Terlalu banyak static import membuat kode sulit dilacak
 * dan sumber method/variabel menjadi tidak jelas.
 * 
 * ------------------------------------------------------------------------
 * KAPAN MENGGUNAKAN STATIC IMPORT?
 * ------------------------------------------------------------------------
 * 
 * COCOK digunakan untuk:
 * 
 * 1. Operasi matematika intensif
 *    - sqrt(), pow(), sin(), cos(), PI, dll
 * 
 * 2. Utility method yang sering dipakai
 *    - Collections.sort(), Arrays.asList()
 * 
 * 3. Konstanta yang sering digunakan
 *    - Color.RED, Color.BLUE
 * 
 * HINDARI untuk:
 * 
 * 1. System.out (println, print)
 *    - Terlalu umum, membuat kode ambigu
 * 
 * 2. Hal yang membuat kode sulit dibaca
 *    - Jika sumber method tidak jelas dari konteks
 * 
 * 3. Jika berpotensi menyebabkan conflict
 *    - Nama method yang sama dari package berbeda
 * 
 * ------------------------------------------------------------------------
 * KESIMPULAN SINGKAT
 * ------------------------------------------------------------------------
 * 
 * Static import = menghilangkan kebutuhan menulis nama class
 * 
 * Kelebihan:
 * - Kode lebih pendek
 * - Kode lebih clean
 * - Mengurangi penulisan berulang
 * 
 * Kekurangan:
 * - Potensi tabrakan nama
 * - Sumber method/variabel kurang jelas
 * - Bisa disalahgunakan
 * 
 * Aturan:
 * - Pakai jika sering dipakai berulang
 * - Jangan pakai berlebihan
 * - Gunakan import satu per satu jika perlu kejelasan
 * 
 * ------------------------------------------------------------------------
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
