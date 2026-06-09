package Generics;

/**
 * Generic Constructor itu:
 * Constructor yang punya type parameter sendiri
 *
 * Walaupun:
 * class GenCons
 *
 * class-nya bukan generic
 *
 * Tapi:
 * <T extends Number> GenCons(T arg)
 *
 * constructornya generic
 *
 * Baris paling penting:
 * <T extends Number> GenCons(T arg)
 *
 * Artinya:
 * constructor punya type sendiri (T)
 * T harus:
 * Number
 * atau turunannya
 *
 * Jadi bisa terima:
 * Integer 
 * Float 
 * Double 
 *
 * Tidak bisa:
 * String 
 *
 * ------------------------------------------------------
 * 
 * APA YANG TERJADI DI DALAM?
 * 
 * Ini:
 * GenCons test = new GenCons(100);
 *
 * Java ubah jadi:
 * T = Integer
 *
 * Ini:
 * GenCons test2 = new GenCons(123.5F);
 * Java ubah jadi:
 * T = Float
 *
 * Semua otomatis (type inference)
 *
 * KENAPA HARUS GENERIC CONSTRUCTOR?
 * 
 * Tujuan utama:
 * fleksibel input
 *
 * Tanpa generic:
 * GenCons(Number arg)
 * juga bisa sih…
 *
 * Bedanya?
 * Generic constructor:
 *
 * lebih fleksibel di compile-time
 * bisa enforce rule lebih kuat
 * sering dipakai di framework
 *
 * -------------------------------------------
 * 
 * KESIMPULAN 
 * 
 * 1. Constructor bisa generic
 * 2. Ditulis sebelum nama constructor
 *    <T> NamaConstructor(...)
 * 3. Bisa pakai bound
 *    <T extends Number>
 * 4. Class tidak harus generic
 * 5. Dipakai untuk:
 * fleksibel input
 * enforce type safety
 */

// Class bukan generic
class GenCons {
    private double val;

    // Constructor Generic 
    // Menerima semua tipe turunan NUMBER
    <T extends Number> GenCons(T arg) { 
        val = arg.doubleValue();
    }

    void showVal() {
        System.out.println("Val: " + val);
    }
}

public class GenericConstructor {
    public static void main(String[] args) {
        
        // Test kirim integer
        GenCons test = new GenCons(180);
        
        // Test kirim float
        GenCons testing = new GenCons(10.0F);

        // TAMPILKAN
        test.showVal();
        testing.showVal();


        // Testing String
        // ERROR WKWK
        // GenCons testString = new GenCons("JANERA"); // UNDEFINED

        // Test char
        // ERROR 
        // GenCons cons = new GenCons('J'); // UNDEFINED
    }

}
