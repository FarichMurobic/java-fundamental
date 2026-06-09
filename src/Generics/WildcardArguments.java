package Generics;

/**
 * MASALAH AWAL (KENAPA PERLU WILDCARD?)
 * Lu punya class:
 * class Stats<T extends Number>
 *
 * bisa dipakai:
 * Stats<Integer>
 * Stats<Double>
 * Stats<Float>
 *
 * Tujuan kita
 * Bikin method:
 * bandingin rata-rata 2 object Stats
 *
 * Contoh:
 * iob.sameAvg(dob)
 *
 * Integer vs Double
 *
 * PENDEKATAN SALAH (INI PENTING BANGET)
 * 
 * Kode ini KELIHATAN benar, tapi salah
 * // Ini tidak akan bekerja dengan benar
 * boolean sameAvg(Stats<T> ob) {
 *   if(average() == ob.average())
 *     return true;
 *   return false;
 * }
 *
 * Masalahnya
 *
 * Kalau:
 * Stats<Integer> iob;
 *
 * maka:
 * Stats<T> = Stats<Integer>
 *
 * Jadi method ini cuma bisa terima:
 * Stats<Integer>
 *
 * Tidak bisa:
 * Stats<Double>
 * Stats<Float>
 *
 * Jadi terlalu terbatas (tidak generic)
 *
 * SOLUSI: WILDCARD (?)
 * Konsepnya
 * Stats<?>
 *
 * Artinya:
 * "Stats dengan tipe APA AJA"
 *
 * Jadi kita pakai:
 * // Membandingkan rata-rata dengan wildcard
 * boolean sameAvg(Stats<?> ob) {
 *   if(average() == ob.average())
 *     return true;
 *   return false;
 * }
 *
 * Ini artinya:
 * ob bisa:
 * Stats<Integer>
 * Stats<Double>
 * Stats<Float>
 *
 * Jadi:
 * iob.sameAvg(dob)
 *
 * -valid
 * -fleksibel
 *
 * --------------------------------------------------
 * 
 * INTI KONSEP (WAJIB MASUK OTAK)
 * 
 * 1. ? = unknown type
 * Stats<?>
 *
 * artinya:
 * tipe tidak diketahui
 * tapi valid
 *
 * 2. Wildcard bikin fleksibel
 * Tanpa wildcard:
 * Stats<T>
 *
 * terlalu ketat
 *
 * Dengan wildcard:
 * Stats<?>
 *
 * bisa semua tipe
 *
 * 3. Wildcard TIDAK ubah aturan class
 * tetap:
 * <T extends Number>
 *
 * Jadi:
 * tetap hanya angka
 * wildcard cuma fleksibilitas parameter
 *
 * ANALOGI PALING GAMPANG
 * Tanpa wildcard
 * "kotak khusus Integer"
 * cuma bisa bandingin dengan Integer
 *
 * Dengan wildcard
 * "kotak angka bebas"
 *
 * bisa:
 * Integer
 * Double
 * Float
 *
 * ---------------------------------
 * 
 * KESIMPULAN 
 * 
 * 1. Wildcard = ?
 * artinya:
 * "tipe bebas"
 *
 * 2. Digunakan saat:
 * gak peduli tipe spesifik
 *
 * 3. Keuntungan:
 * fleksibel
 * tetap aman
 *
 * 4. Contoh penting:
 * boolean sameAvg(Stats<?> ob)
 *
 * 5. Tidak mengganti bounded type
 * tetap:
 * <T extends Number>
 */

class Statee<T extends Number> {
    T[] nums; // Array bertipe number atau turunannya

    // konstruktor menerima array Number atau turunannya
    Statee(T[] o) {
        this.nums = o;
    }

    // Menghitung rata-rata
    double average() {
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }

    // Membandingkan apakah dua rata-rata sama
    // Menggunakan wildcard
    boolean sameAvg(Statee<?> ob) {
        if (average() == ob.average()) {
            return true;
        }
        return false;
    }
}

public class WildcardArguments {
    public static void main(String[] args) {
        
        Integer inums[] = {1,2,3,4,5};
        Statee<Integer> iob = new Statee<Integer>(inums);

        double v = iob.average();
        System.out.println("iob average is: " + v);

        Double dnums[] = {1.1, 2.2, 3.3, 4.4, 5.5};
        Statee<Double> dob = new Statee<Double>(dnums);

        double w = dob.average();
        System.out.println("dob average is: " + w);

        Float fnums[] = {1.0f, 2.0f, 3.0f, 4.0f, 5.0f};
        Statee<Float> fob = new Statee<Float>(fnums);

        double x = fob.average();
        System.out.println("fob average is: " + x);

        // MEMBANDINGKAN RATA-RATA
        System.out.print("Average of iob and dob ");
        if (iob.sameAvg(dob)) {
            System.out.println("are the same");
        } else {
            System.out.println("differ");
        }

        System.out.print("Average of iob and fob ");
        if (iob.sameAvg(fob)) {
            System.out.println("are the same");
        } else {
            System.out.println("differ");
        }

        /**
         * OUTPUT
         * iob average is 3.0
         * dob average is 3.3
         * fob average is 3.0
         * Averages of iob and dob differ.
         * Averages of iob and fob are the same.
         */

    }
}
