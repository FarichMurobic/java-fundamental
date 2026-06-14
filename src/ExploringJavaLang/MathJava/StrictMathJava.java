package ExploringJavaLang.MathJava;

/**
 * StrictMath
 *
 * Class StrictMath menyediakan:
 * kumpulan method matematika yang sama seperti Math
 *
 * Perbedaan utama:
 * StrictMath:
 * hasilnya DIJAMIN sama persis di semua platform Java
 *
 * Math:
 * boleh beda sedikit hasilnya
 * demi performa lebih cepat
 *
 * ------------------------------------
 * 
 * Penjelasan Inti (BIAR LO NANGKEP)
 * Masalahnya dimana?
 *
 * Java jalan di banyak OS:
 * Windows
 * Linux
 * Mac
 *
 * tiap sistem bisa punya:
 * CPU berbeda
 * implementasi floating-point berbeda
 *
 * Nah disini bedanya:
 * StrictMath
 *
 * pakai algoritma standar (biasanya dari FDLIBM)
 *
 * hasil:
 * SELALU SAMA
 *
 * Math
 * boleh pakai optimasi hardware
 *
 * hasil:
 * BISA SEDIKIT BERBEDA
 *
 * Perbandingan JELAS
 * Aspek	            Math	                    StrictMath
 * Kecepatan	        Lebih cepat 	            Lebih lambat
 * Konsistensi	        Bisa beda	                Sama di semua platform
 * Implementasi	        Optimized (hardware)	    Standar (software)
 * Use case	            Umum	                    Scientific / deterministik
 *
 * Kapan Pakai?
 * Pakai Math kalau:
 * aplikasi biasa
 * gak peduli beda 0.00000001
 * butuh performa
 *
 * Pakai StrictMath kalau:
 * butuh hasil identik di semua mesin
 * scientific computing
 * testing deterministik
 * 
 * ------------------------------------------
 *
 * Insight PRO LEVEL
 *
 * StrictMath biasanya:
 * implementasi pure Java
 * gak pakai hardware optimization
 *
 * Math:
 * bisa pakai native instruction CPU
 *
 * Kesimpulan Simpel
 * StrictMath = versi “ketat” dari Math
 *
 * perbedaan:
 * Math → cepat
 * StrictMath → konsisten
 *
 * default:
 * pakai Math aja dulu (99% kasus)
 */

public class StrictMathJava {
    public static void main(String[] args) {
        
        double angka = 2.0;

        // Menggunakan Math
        double hasilMath = Math.sqrt(angka);

        // Menggunakan StrictMath
        double hasilStrict = StrictMath.sqrt(angka);

        // Tampilkan hasil
        System.out.println("Math sqrt: " + hasilMath);
        // Math sqrt: 1.4142135623730951
        
        System.out.println("StrictMath sqrt: " + hasilStrict);
        // StrictMath sqrt: 1.4142135623730951

        /**
         * biasanya:
         *
         * Math sqrt: 1.4142135623730951
         * StrictMath sqrt: 1.4142135623730951
         *
         * terlihat sama
         * TAPI...
         *
         * 1. Perbedaan itu kecil banget
         *
         * biasanya di:
         * digit desimal jauh
         * edge case
         *
         * 2. StrictMath = deterministik
         *
         * cocok untuk:
         * simulasi ilmiah
         * game physics (butuh konsistensi)
         * distributed system
         *
         * 3. Math = performa
         *
         * cocok untuk:
         * aplikasi biasa
         * backend umum
         * web service
         *
         * Analogi
         *
         * Bayangin:
         * Math = kalkulator cepat 
         * StrictMath = kalkulator ilmiah standar 
         */
    }
}
