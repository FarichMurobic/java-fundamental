package Generics;

/**
 * Kondisi awal
 *
 * Kita punya generic:
 * class Stats<T>
 *
 * Artinya:
 * T bisa jadi apa aja
 *
 * Masalah:
 * Lu mau bikin method:
 * hitung rata-rata angka
 *
 * Tapi
 * Kalau T bebas:
 * bisa Integer 
 * bisa Double 
 * bisa String (ini masalah)
 *
 * Java jadi bingung:
 * "ini T isinya angka atau bukan?"
 *
 * Kenapa error?
 * Baris ini:
 * nums[i].doubleValue();
 *
 * Java bilang:
 * "T gak punya method doubleValue()!"
 *
 * Padahal:
 * Integer punya doubleValue()
 * Double punya doubleValue()
 *
 * Tapi:
 * Java gak tau itu
 *
 * Karena:
 * T = bebas (bisa String juga)
 *
 * --------------------------------
 * 
 * SOLUSI: BOUNDED TYPES
 * 
 * Konsepnya
 *
 * Kita kasih batas:
 * "T cuma boleh tipe tertentu"
 *
 * Syntax
 * // T harus turunan dari superclass
 * <T extends SuperClass>
 *
 * Artinya:
 * T cuma boleh:
 * SuperClass
 * turunannya
 *
 * BEDAH PENTING (INI YANG HARUS MASUK OTAK)
 *
 * 1. Ini bagian kunci
 * class Stats<T extends Number>
 *
 * Artinya:
 * T HARUS:
 * Number atau turunannya
 *
 * Contoh valid:
 * Integer 
 * Double 
 * Float 
 *
 * Contoh tidak valid:
 * String 
 * Object 
 *
 * Kenapa sekarang bisa?
 * Karena:
 * Java tahu T pasti punya:
 * doubleValue()
 *
 * Bonus besar
 * Selain fix error:
 * juga mencegah salah tipe
 *
 * Ini sekarang ditolak:
 * Stats<String> obj = new Stats<>(...);
 *
 * OUTPUT
 * iob average is 3.0
 * dob average is 3.3
 *
 * --------------------------------------------------
 * 
 * KESIMPULAN 
 * 
 * 1. Bounded type = membatasi generic
 *
 * 2. Syntax:
 * <T extends Something>
 *
 * 3. Keuntungan:
 * bisa pakai method tertentu
 * lebih aman
 * mencegah error
 *
 * 4. Contoh penting:
 * <T extends Number>
 *
 * hanya angka
 *
 * 5. Bisa multi bound:
 * <T extends A & B>
 */

// KODE SALAH jika belum extends
// Kode benar jika sudah extend Number
class Stats<T extends Number> {

    T[] nums;

    Stats(T[] o) {
        this.nums = o;
    }

    // ALWAYS mengembalikan double
    double average() {
        double sum = 0.0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue(); // ERROR. kalo gak extends Number

            /**
             * Kenapa error?
             *
             * Baris ini:
             * nums[i].doubleValue();
             *
             * Java bilang:
             * "T gak punya method doubleValue()!"
             *
             * Padahal:
             * Integer punya doubleValue()
             * Double punya doubleValue()
             *
             * Tapi:
             * Java gak tau itu
             *
             * Karena:
             * T = bebas (bisa String juga)
             *
             * SOLUSI: BOUNDED TYPES
             * Konsepnya
             *
             * Kita kasih batas:
             * "T cuma boleh tipe tertentu"
             *
             * Syntax
             * // T harus turunan dari superclass
             * <T extends SuperClass>
             *
             * Artinya:
             * T cuma boleh:
             * SuperClass
             * turunannya
             */
        }
        return sum / nums.length;
    }

    // EAAAAAAHHHHHHHHHHHHHHHH
    int averageInteger() {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].intValue();
        }
        return sum / nums.length;
    }
}

public class BoundedTypes {
    public static void main(String[] args) {

        Integer integersnums[] = {1,2,3,4,5};
        Stats<Integer> iob = new Stats<Integer>(integersnums);

        // double
        double v = iob.average();
        System.out.println("iob average is " + v);

        int i = iob.averageInteger();
        System.out.println(i);

        Double doublenums[] = {1.1, 2.2, 3.3, 4.4, 5.5};
        Stats<Double> dob = new Stats<Double>(doublenums);

        double w = dob.average();
        System.out.println("dob average is " + w);

        int ww = dob.averageInteger();
        System.out.println(ww);

    }

}
