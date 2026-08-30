package FundamentalJava.TypeWrappers;

/**
 * ------------------------------------------------------------------------
 * KONSEP INTI: AUTOBOXING DI METHOD
 * ------------------------------------------------------------------------
 * 
 * Autoboxing dan auto-unboxing tidak hanya terjadi saat assignment..
 * 
 * Mereka juga terjadi saat:
 * - Mengirim parameter ke method
 * - Mengembalikan nilai (return) dari method
 * 
 * Intinya:
 * - Kalau method butuh object → primitive akan di-autobox
 * - Kalau method butuh primitive → object akan di-auto-unbox
 * 
 * ------------------------------------------------------------------------
 * CONTOH: AUTOBOXING PADA PARAMETER METHOD
 * ------------------------------------------------------------------------
 * 
 * // Method yang menerima Integer (object)
 * static void tampilkanInteger(Integer i) {
 * System.out.println("Nilai: " + i);
 * }
 * 
 * public static void main(String[] args) {
 * int angka = 42; // primitive
 * tampilkanInteger(angka); // Autoboxing!
 * 
 * // int 42 otomatis dibungkus menjadi Integer
 * }
 * 
 * ------------------------------------------------------------------------
 * CONTOH: AUTO-UNBOXING PADA PARAMETER METHOD
 * ------------------------------------------------------------------------
 * 
 * // Method yang menerima int (primitive)
 * static void tampilkanInt(int i) {
 * System.out.println("Nilai: " + i);
 * }
 * 
 * public static void main(String[] args) {
 * Integer angka = 42; // object wrapper
 * tampilkanInt(angka); // Auto-unboxing!
 * 
 * // Integer 42 otomatis di-unbox menjadi int
 * }
 * 
 * ------------------------------------------------------------------------
 * CONTOH: AUTOBOXING PADA RETURN VALUE
 * ------------------------------------------------------------------------
 * 
 * // Method mengembalikan Integer (object)
 * static Integer getInteger() {
 * int nilai = 100; // primitive
 * return nilai; // Autoboxing!
 * 
 * // int 100 otomatis dibungkus menjadi Integer
 * }
 * 
 * public static void main(String[] args) {
 * Integer hasil = getInteger(); // Sudah berupa Integer
 * }
 * 
 * ------------------------------------------------------------------------
 * CONTOH: AUTO-UNBOXING PADA RETURN VALUE
 * ------------------------------------------------------------------------
 * 
 * // Method mengembalikan int (primitive)
 * static int getInt() {
 * Integer nilai = 100; // object wrapper
 * return nilai; // Auto-unboxing!
 * 
 * // Integer 100 otomatis di-unbox menjadi int
 * }
 * 
 * public static void main(String[] args) {
 * int hasil = getInt(); // Sudah berupa int
 * }
 * 
 * ------------------------------------------------------------------------
 * INISIGHT LEVEL LANJUT: DI MANA AUTOBOXING TERJADI?
 * ------------------------------------------------------------------------
 * 
 * Autoboxing dan auto-unboxing terjadi di:
 * 
 * 1. ASSIGNMENT (penugasan)
 * 
 * Integer i = 10; // Autoboxing
 * int x = i; // Auto-unboxing
 * 
 * 2. PARAMETER METHOD (parameter method)
 * 
 * method(10); // Autoboxing jika method butuh Integer
 * method(i); // Auto-unboxing jika method butuh int
 * 
 * 3. RETURN VALUE (nilai balik method)
 * 
 * return 10; // Autoboxing jika return type Integer
 * return i; // Auto-unboxing jika return type int
 * 
 * 4. OPERASI MATEMATIKA
 * 
 * Integer a = 10;
 * Integer b = 20;
 * Integer c = a + b; // Unboxing + Boxing
 * 
 * ------------------------------------------------------------------------
 * CONTOH KOMPLEKS: AUTOBOXING DALAM EKSPRESI
 * ------------------------------------------------------------------------
 * 
 * Integer a = 10; // Autoboxing
 * Integer b = 20; // Autoboxing
 * 
 * // Operasi matematika dengan wrapper
 * Integer hasil = a + b; // Auto-unboxing (a,b) + Autoboxing (hasil)
 * 
 * // Proses di belakang layar:
 * // 1. a di-unbox menjadi int (10)
 * // 2. b di-unbox menjadi int (20)
 * // 3. 10 + 20 = 30 (int)
 * // 4. 30 di-box menjadi Integer (30)
 * 
 * System.out.println(hasil); // Output: 30
 * 
 * ------------------------------------------------------------------------
 * CONTOH DENGAN GENERICS & COLLECTION
 * ------------------------------------------------------------------------
 * 
 * // Collection hanya bisa menyimpan object, bukan primitive
 * List<Integer> list = new ArrayList<>();
 * 
 * // Autoboxing: int → Integer
 * list.add(10); // int 10 otomatis jadi Integer
 * list.add(20); // int 20 otomatis jadi Integer
 * 
 * // Auto-unboxing: Integer → int
 * int total = 0;
 * for (Integer nilai : list) {
 * total += nilai; // nilai di-unbox menjadi int
 * }
 * 
 * System.out.println(total); // Output: 30
 * 
 * ------------------------------------------------------------------------
 * PERINGATAN: NULL DI AUTO-UNBOXING
 * ------------------------------------------------------------------------
 * 
 * Integer i = null;
 * int x = i; // NullPointerException!
 * 
 * Kenapa?
 * - i adalah null (tidak punya nilai)
 * - Auto-unboxing mencoba memanggil i.intValue()
 * - i.intValue() gagal karena i null
 * 
 * ------------------------------------------------------------------------
 * PERINGATAN: PERFORMANCE OVERHEAD
 * ------------------------------------------------------------------------
 * 
 * // Buruk - boxing berulang dalam loop
 * Integer total = 0;
 * for (int i = 0; i < 1000000; i++) {
 * total += i; // Unboxing + Boxing setiap iterasi
 * }
 * 
 * // Lebih baik - pakai primitive
 * int totalPrimitive = 0;
 * for (int i = 0; i < 1000000; i++) {
 * totalPrimitive += i; // Tidak ada boxing
 * }
 * 
 * ------------------------------------------------------------------------
 * RINGKASAN AUTOBOXING DI METHOD
 * ------------------------------------------------------------------------
 * 
 * Lokasi | Autoboxing (Primitive → Object) | Auto-unboxing (Object → Primitive)
 * -----------------------|------------------------------------|-------------------------------------
 * Parameter method | int → Integer | Integer → int
 * Return value | int → Integer | Integer → int
 * Assignment | int → Integer | Integer → int
 * Operasi matematika | int → Integer (hasil) | Integer → int (operand)
 * 
 * ------------------------------------------------------------------------
 * KESIMPULAN BESAR
 * ------------------------------------------------------------------------
 * 
 * Autoboxing membuat coding lebih simpel.
 * 
 * Tapi di balik layar:
 * - Banyak proses terjadi tanpa disadari
 * - Java sering melakukan primitive ⇄ object secara otomatis
 * 
 * WAJIB HATI-HATI:
 * 1. NULL → NullPointerException
 * 2. PERFORMANCE → Overhead di loop besar
 * 3. PERBANDINGAN → Gunakan .equals() bukan ==
 * 
 * ------------------------------------------------------------------------
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
