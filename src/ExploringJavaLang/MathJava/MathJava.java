package ExploringJavaLang.MathJava;

/**
 * Math Class
 *
 * Class Math berisi:
 * fungsi matematika (geometri, trigonometri, dll)
 *
 * Konstanta penting
 * Konstanta	Nilai
 * Math.E	≈ 2.72
 * Math.PI	≈ 3.14
 *
 * TRIGONOMETRIC FUNCTIONS (FULL)
 *
 * Fungsi Trigonometri (input: radian)
 * Method	                    Deskripsi
 * sin(double arg)	            Mengembalikan nilai sinus dari sudut (radian)
 * cos(double arg)	            Mengembalikan nilai cosinus
 * tan(double arg)	            Mengembalikan nilai tangen
 *
 * Inverse Trigonometri (kebalikannya)
 * Method	                    Deskripsi
 * asin(double arg)	            Mengembalikan sudut dari nilai sinus
 * acos(double arg)	            Mengembalikan sudut dari nilai cosinus
 * atan(double arg)	            Mengembalikan sudut dari nilai tangen
 * atan2(double x, double y)	Mengembalikan sudut dari perbandingan x/y
 * 
 * Hyperbolic
 * Method	                    Deskripsi
 * sinh(double arg)	            Sinh (hyperbolic sine)
 * cosh(double arg)	            Cosh
 * tanh(double arg)	            Tanh
 *
 * EXPONENTIAL FUNCTIONS (FULL)
 * Method	                            Deskripsi
 * cbrt(double arg)	                    Akar pangkat 3
 * exp(double arg)	                    e^arg
 * expm1(double arg)	                e^arg - 1
 * log(double arg)	                    log natural (ln)
 * log10(double arg)	                log basis 10
 * log1p(double arg)	                ln(arg + 1)
 * pow(double y, double x)	            y pangkat x
 * scalb(double arg, int factor)	    arg × 2^factor
 * sqrt(double arg)	                    akar kuadrat
 *
 * ROUNDING FUNCTIONS (TABLE 17-16 FULL)
 * Absolute
 * Method	Deskripsi
 * abs(int/long/float/double)	Nilai absolut (hilangin minus)
 *
 * Pembulatan
 * Method	                            Deskripsi
 * ceil(double)	                        Bulat ke atas
 * floor(double)	                    Bulat ke bawah
 * round(float/double)	                Bulat ke terdekat
 *
 * Division & Mod (JDK 8)
 * Method	                            Deskripsi
 * floorDiv()	                        Pembagian dibulatkan ke bawah
 * floorMod()	                        Sisa pembagian versi floor
 *
 * Max / Min
 * Method	                            Deskripsi
 * max(x, y)	                        Ambil nilai terbesar
 * min(x, y)	                        Ambil nilai terkecil
 *
 * Next Value (floating precision)
 * Method	                            Deskripsi
 * nextAfter()	                        Nilai berikutnya ke arah tertentu
 * nextUp()	                            Nilai lebih besar
 * nextDown()	                        Nilai lebih kecil
 *
 * Lainnya
 * Method	                            Deskripsi
 * rint()	                            Pembulatan ke integer terdekat
 * ulp()	                            Jarak ke angka floating berikutnya
 *
 * MISC METHODS (TABLE 17-17 FULL)
 * Exact (AMAN dari overflow)
 * Method	                            Deskripsi
 * addExact()	                        Penjumlahan aman
 * subtractExact()	                    Pengurangan aman
 * multiplyExact()	                    Perkalian aman
 * incrementExact()	                    +1 aman
 * decrementExact()	                    -1 aman
 * negateExact()	                    Negatif aman
 *
 * Sign & Random
 * Method	                            Deskripsi
 * random()	                            Angka random (0–1)
 * signum()	                            Cek tanda (-1, 0, 1)
 *
 * Geometri
 * Method	                            Deskripsi
 * hypot(a, b)	                        Panjang sisi miring segitiga
 *
 * Conversion
 * Method	                            Deskripsi
 * toDegrees()	                        Radian → Derajat
 * toRadians()	                        Derajat → Radian
 *
 * Lainnya
 * Method	                            Deskripsi
 * copySign()	                        Copy tanda (+/-)
 * getExponent()	                    Ambil exponent
 * IEEEremainder()	                    Sisa pembagian IEEE
 * toIntExact()	                        Konversi long → int aman
 *
 * Insight Penting (INI YANG HARUS LO PAHAM)
 * 1. Math = static
 * gak perlu buat object
 * Math.sqrt(9);
 *
 * 2. Floating precision
 * hasil bisa gak 100% akurat (double)
 *
 * 3. Exact methods (JDK 8)
 * buat hindari overflow (penting di backend)
 *
 * Analogi
 * Bayangin:
 * Math = kalkulator super lengkap 
 * tinggal panggil fungsi
 *
 * Relevansi Backend
 * Dipakai di:
 * financial calculation
 * statistik
 * grafik
 * game logic
 * machine learning basic
 *
 * Kesimpulan Simpel
 * Math = kumpulan fungsi matematika di Java
 *
 * kategori:
 * trigonometri
 * logaritma
 * pembulatan
 * random
 * konversi
 *
 * semua method:
 * static
 * langsung pakai
 *
 * 1. Math itu low-level tool
 *
 * Framework gak banyak bantu di sini
 * lo harus ngerti sendiri
 *
 * 2. Presisi penting di backend
 *
 * finance → pakai BigDecimal
 * statistik → hati-hati double
 *
 * 3. Performa tinggi
 *
 * Math di Java:
 * optimized native
 *
 * Kapan dipakai di dunia nyata?
 *
 * sering di:
 *
 * game dev
 * grafik
 * simulasi
 * AI sederhana
 * perhitungan bisnis
 *
 * Kesimpulan Super Simpel
 * Math = kalkulator built-in Java
 *
 * kategori:
 * trigono
 * log/pangkat
 * rounding
 * random
 * geometri
 *
 * aturan penting:
 * pakai radian
 * hati-hati double precision
 * gunakan exact method kalau perlu aman
 */

public class MathJava {
    public static void main(String[] args) {

        // Demonstrasi toDegrees() dan toRadians()
        double theta = 120.0;

        // Konversi derajat ke radian
        System.out.println(theta + " degrees is " +
                Math.toRadians(theta) + " radians.");

        theta = 1.312;

        // Konversi radian ke derajat
        System.out.println(theta + " radians is " +
                Math.toDegrees(theta) + " degrees.");

        /*
            OUTPUT
            120.0 degrees is 2.0943951023931953 radians.
            1.312 radians is 75.17206272116401 degrees.

            Penjelasan Penting
            Radian vs Degree
            Java pakai radian default

            Rumus
            radian = degree × π / 180
            degree = radian × 180 / π
         */

        double sudut = 30;

        double rad = Math.toRadians(sudut);

        System.out.println("sin: " + Math.sin(rad));
        System.out.println("cos: " + Math.cos(rad));
        System.out.println("tan: " + Math.tan(rad));

        // Akar
        System.out.println("sqrt: " + Math.sqrt(25));

        // Pangkat
        System.out.println("pow: " + Math.pow(2, 3));

        // Log
        System.out.println("log: " + Math.log(10));

        // Trigonometri
        double rad1 = Math.toRadians(45);
        System.out.println("sin: " + Math.sin(rad1));

        // Pembulatan
        System.out.println("ceil: " + Math.ceil(2.3));
        System.out.println("floor: " + Math.floor(2.7));
        System.out.println("round: " + Math.round(2.5));

        // Random
        System.out.println("random: " + Math.random());

        // Hypot
        System.out.println("hypot: " + Math.hypot(3, 4));

    }
}

