package FundamentalJava.TypeWrappers;

    /**
     * Konsep Inti: Autoboxing di Method
     *
     * Autoboxing & auto-unboxing tidak cuma terjadi saat assignment, tapi juga saat:
     * kirim parameter ke method
     * return value dari method
     *
     * Intinya:
     * Kalau method butuh object → primitive akan di-autobox
     * Kalau butuh primitive → object akan di-auto-unbox
     *
     * Insight Level Lanjut
     * Autoboxing terjadi di:
     * Parameter method
     * Return value
     * Operasi matematika
     * Assignment
     *
     * Jadi Java sering banget:
     * primitive ⇄ object
     *
     * tanpa lu sadar 
     *
     * Kesimpulan Besar
     * Autoboxing bikin coding lebih simpel
     * Tapi di balik layar:
     * banyak proses terjadi
     * 
     * Wajib hati-hati:
     * null
     * performa
     */

public class InMethods {

    // Autoboxing/unboxing takes place with
    // method parameters and return values.

    // Method menerima Integer (object)
    // tapi return int (primitive)
    static int m(Integer v) {
        return v; // auto-unboxing terjadi disini
    }

    public static void main(String[] args) {

        Integer iob = m(100);
        // 100 (int) → autobox jadi Integer saat masuk ke method
        // return (int) → autobox lagi jadi Integer saat disimpan ke iOb

        System.out.println(iob);
    }
}
