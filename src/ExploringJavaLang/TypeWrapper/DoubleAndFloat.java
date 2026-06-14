package ExploringJavaLang.TypeWrapper;

/**
 * Double dan Float
 * Float = wrapper untuk float
 * Double = wrapper untuk double
 *
 * Insight penting (ini konsep besar Java modern)
 * Sejak Java 5+:
 * Java dorong penggunaan autoboxing + factory method (valueOf)
 *
 * Dan sejak Java 9:
 * Constructor wrapper class (Integer, Double, dll) → deprecated
 *
 * // DEPRACTED CONSTRUCTOR!
 * Constructor Float
 * Constructor	            Deskripsi
 * Float(double num)	    Buat object dari nilai double
 * Float(float num)	Buat    object dari nilai float
 * Float(String str)	    Parse string jadi float
 *
 * Constructor Double
 * Constructor	            Deskripsi
 * Double(double num)	    Buat object dari nilai double
 * Double(String str)	    Parse string jadi double
 *
 * CONSTANTS (Float & Double)
 * Ini sangat penting di real case
 *
 * Constant	                Deskripsi
 * BYTES	                Ukuran dalam byte
 * SIZE	                    Ukuran dalam bit
 * MAX_VALUE	            Nilai maksimum
 * MIN_VALUE	            Nilai minimum
 * MIN_NORMAL	            Nilai minimum normal
 * MAX_EXPONENT	            Eksponen maksimum
 * MIN_EXPONENT	            Eksponen minimum
 * NaN	                    Not a Number
 * POSITIVE_INFINITY	    Tak hingga positif
 * NEGATIVE_INFINITY	    Tak hingga negatif
 * TYPE	Class object
 */

/**
 * TABEL METHOD Float (FULL + DESKRIPSI)
 * Method	                    Deskripsi
 * byteValue()	                Konversi ke byte
 * compare(float a, float b)	Bandingkan 2 float
 * compareTo(Float f)	        Bandingkan dengan object
 * doubleValue()	            Konversi ke double
 * equals(Object o)	            Cek kesamaan
 * floatToIntBits(float)	    Konversi ke bit IEEE
 * floatToRawIntBits(float)	    Sama tapi NaN tetap
 * floatValue()	                Ambil nilai float
 * hashCode()	                Hash object
 * hashCode(float)	            Hash dari nilai
 * intBitsToFloat(int)	        Bit → float
 * intValue()	                Konversi ke int
 * isFinite(float)	            Cek bukan infinity & bukan NaN
 * isInfinite()	                Cek infinity
 * isInfinite(float)	        Static version
 * isNaN()	                    Cek NaN
 * isNaN(float)	                Static version
 * longValue()	                Konversi ke long
 * max(a, b)	                Nilai terbesar
 * min(a, b)	                Nilai terkecil
 * parseFloat(String)	        String → float
 * shortValue()	                Konversi ke short
 * sum(a, b)	                Penjumlahan
 * toHexString(float)	        Float → hex
 * toString()	                Object → string
 * toString(float)	            Value → string
 * valueOf(float)	            float → Float
 * valueOf(String)	            String → Float
 */

/**
 * TABEL METHOD Double
 * Method	                        Deskripsi
 * byteValue()	                    Konversi ke byte
 * compare(double a, double b)	    Bandingkan
 * compareTo(Double d)	            Bandingkan object
 * doubleToLongBits(double)	        Konversi ke bit
 * doubleToRawLongBits(double)	    Sama (NaN tetap)
 * doubleValue()	                Ambil double
 * equals(Object)	                Cek kesamaan
 * floatValue()	                    Konversi ke float
 * hashCode()	                    Hash object
 * hashCode(double)	                Hash dari nilai
 * intValue()	                    Konversi ke int
 * isFinite(double)	                Cek finite
 * isInfinite()	                    Cek infinity
 * isInfinite(double)	            Static version
 * isNaN()	                        Cek NaN
 * isNaN(double)	                Static version
 * longBitsToDouble(long)	        Bit → double
 * longValue()	                    Konversi ke long
 * max(a, b)	                    Nilai terbesar
 * min(a, b)	                    Nilai terkecil
 * parseDouble(String)	            String → double
 * shortValue()	                    Konversi ke short
 * sum(a, b)	                    Penjumlahan
 * toHexString(double)	            Double → hex
 * toString()	                    Object → string
 * toString(double)	                Value → string
 * valueOf(double)	                double → Double
 * valueOf(String)	                String → Double
 */

/**
 * Yang WAJIB lo inget:
 *
 * Bisa parsing string
 * Banyak method utility
 * Punya constant penting (NaN, Infinity)
 * Banyak konversi bisa bikin:
 *
 * hilang presisi
 * rounding error
 *
 * REAL TALK (BACKEND)
 * Di dunia nyata:
 * Double sering dipakai di:
 * API response
 * JSON
 * database mapping
 *
 * Best Practice penting
 * Jangan pakai float untuk uang
 * Jangan pakai double untuk uang
 *
 * pakai:
 * BigDecimal (nanti bakal lo temuin)
 */

public class DoubleAndFloat {
    public static void main(String[] args) {

        // since jdk versi 9 is depracted
        // Double d1 = new Double(3.14159);
        // Double d2 = new Double("314159E-5");
        // Double d4 = "314159E-5";

        Double d3 = 3.14159;

        // Parsing string ke double
        double d = Double.parseDouble("10.5");
        // Parsing string ke float
        float f = Float.parseFloat("5.5");

        System.out.println("Double: " + d);
        System.out.println("Float: " + f);

        // Cek NaN
        double nan = 0.0 / 0.0;
        System.out.println("Is NaN: " + Double.isNaN(nan)); // true

        // Cek Infinity
        double inf = 1.0 / 0.0;
        System.out.println("Is Infinite: " + Double.isInfinite(inf)); // true

        /**
         * Memahami isInfinite() dan isNaN()
         *
         * Class Float dan Double menyediakan method:
         * isInfinite()
         * isNaN()
         *
         * Method ini membantu saat kita memanipulasi dua nilai spesial dalam floating-point:
         * Infinity (tak hingga)
         * NaN (Not a Number / bukan angka)
         *
         * Kedua nilai ini berasal dari standar IEEE floating-point.
         *
         * Fungsi masing-masing:
         * isInfinite()
         * ➜ mengembalikan true jika nilai sangat besar atau sangat kecil hingga dianggap tak hingga
         *
         * isNaN()
         * ➜ mengembalikan true jika nilai bukan angka
         *
         * Baris ini:
         * Double d1 = new Double(1 / 0.0);
         *
         * karena ada .0
         * Java pakai floating-point division
         *
         * hasil:
         * Infinity
         *
         * Baris ini:
         * Double d2 = new Double(0 / 0.0);
         *
         * hasil:
         * NaN
         *
         * Output:
         * Infinity: true, false
         * NaN: false, true
         *
         * 1. Infinity itu valid di Java
         * double x = 1.0 / 0.0;
         *
         * gak error
         * hasil: Infinity
         *
         * 2. NaN itu juga valid
         * double x = 0.0 / 0.0;
         *
         * hasil: NaN
         *
         * 3. NaN itu “aneh banget” (WAJIB PAHAM)
         * double x = 0.0 / 0.0;
         *
         * System.out.println(x == x); // false
         * NaN tidak sama dengan dirinya sendiri
         *
         * Intinya:
         * isInfinite() → cek tak hingga
         * isNaN() → cek bukan angka
         */

        // Membuat nilai Infinity
        // 1 dibagi 0.0 = Infinity (double)
        Double dobel1 = 1 / 0.0;
        // Membuat nilai NaN
        // 0 dibagi 0.0 = NaN
        Double dobel2 = 0 / 0.0;

        // Cek apakah d1 infinite atau NaN
        System.out.println("dobel1: " + dobel1.isInfinite() + ", " + dobel1.isNaN()); // true, false
        // Cek apakah d2 infinite atau NaN
        System.out.println("dobel2: " + dobel2.isInfinite() + ", " + dobel2.isNaN()); // false, true

        double x = 0.0 / 0.0; // isNan
        double a = 10.0 / 0.0; // Infinity

        // Jangan pakai ini:
        // gak akan pernah true
        System.out.println(x == x); // false
        System.out.println(Double.isNaN(x)); // true
        System.out.println(Double.isInfinite(a)); // true

        // cek max dan min Double
        System.out.println(Double.MIN_VALUE); // 4.9E-324
        System.out.println(Double.MAX_VALUE); // 1.7976931348623157E308

    }
}
