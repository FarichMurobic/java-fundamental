package Generics;

/**
     * Type Parameter GAK BISA DI-INSTANTIATE
     * 
     * Kode salah
     * class Gen<T> {
     *   T ob;
     *
     *   Gen() {
     *     ob = new T(); // ERROR
     *   }
     * }
     *
     * Kenapa?
     *
     * Karena:
     * T = ??? (unknown saat compile)
     *
     * Java gak tau harus bikin:
     * new Integer() ?
     * new String() ?
     * new Double() ?
     *
     * Hubungannya sama ERASURE
     *
     * Setelah compile:
     * T → Object
     *
     * Jadi:
     * ob = new Object(); // SALAH secara logika
     *
     * karena harusnya T, bukan sembarang Object
     *
     * SOLUSI (real world)
     * Kirim object dari luar
     * 
     * class Gen<T> {
     *   T ob;
     *
     *   Gen(T ob) {
     *     this.ob = ob;
     *   }
     * }
     *
     * Pakai Reflection (advanced)
     * class Gen<T> {
     *   T ob;
     *
     *   Gen(Class<T> clazz) throws Exception {
     *     ob = clazz.getDeclaredConstructor().newInstance();
     *   }
     * }
     *
     * -----------------------------------------------
     * 
     * STATIC GAK BOLEH PAKE T
     * 
     * Salah
     * class Wrong<T> {
     *   static T ob; // ERROR
     *
     *   static T getob() { // ERROR
     *     return ob;
     *   }
     * }
     *
     * Kenapa?
     *
     * Karena:
     * static itu milik class (bukan object)
     *
     * Sedangkan:
     * T itu milik object
     * Contoh biar kebayang
     * Wrong<Integer>
     * Wrong<String>
     *
     * Class-nya sama
     * Tapi T beda
     *
     * Jadi:
     * static T ob; // T yang mana??
     *
     * ambiguity → gak boleh
     *
     * SOLUSI
     * Pakai static generic method
     * 
     * class Test {
     *   static <T> void print(T data) {
     *     System.out.println(data);
     *   }
     * }
     *
     * ini boleh karena:
     * <T> milik method, bukan class
     *
     * --------------------------------------------------
     * 
     * ARRAY GENERIC GAK BOLEH DIBUAT LANGSUNG
     * 
     * Salah
     * T vals[] = new T[10]; // ERROR
     *
     * Kenapa?
     * Array di Java:
     * punya type info saat runtime
     *
     * Generics:
     * hilang saat runtime (erasure)
     *
     * Konflik
     * T[] → gak jelas tipe runtime
     *
     * Java butuh tipe nyata:
     * Integer[]
     * String[]
     *
     * BOLEH (cara aman)
     * T vals[];
     *
     * Gen(T[] nums) {
     *   vals = nums; // OK
     * }
     *
     * karena array sudah punya tipe nyata dari luar
     *
     * ------------------------------------------------------
     * 
     * ARRAY OF GENERIC TYPE SPESIFIK
     * 
     * Salah
     * Gen<Integer>[] arr = new Gen<Integer>[10]; // ERROR
     *
     * Kenapa?
     *
     * Karena ini bisa bikin type safety rusak
     * Bayangin:
     * Object[] o = arr;
     * o[0] = new Gen<String>(); // masuk!
     *
     * padahal harusnya Gen<Integer>
     *
     * SOLUSI
     * Gen<?>[] arr = new Gen<?>[10]; // OK
     *
     * wildcard lebih aman
     *
     * ----------------------------------------------------
     * 
     * GENERIC TIDAK BISA JADI EXCEPTION
     * Salah
     * class MyException<T> extends Exception { } // ERROR
     *
     * Kenapa?
     *
     * Exception di Java:
     * harus bisa ditangkap berdasarkan tipe saat runtime
     *
     * Contoh:
     * catch (MyException<Integer> e)
     *
     * MUSTAHIL karena:
     * <MyException<Integer>> → hilang saat runtime
     *
     * Jadi JVM gak bisa bedain:
     * MyException<String>
     * MyException<Integer>
     *
     * SOLUSI
     *
     * Gunakan:
     * class MyException extends Exception {
     * }
     *
     * RANGKUMAN CEPAT (WAJIB NANCEP)
     * Kasus	            Status	        Kenapa
     * new T()	            tidak           tipe gak diketahui
     * static T	            tidak           T milik object
     * new T[]	            tidak           array butuh tipe runtime
     * Gen<Integer>[]	    tidak           bisa rusak type safety
     * Gen<?>[]	            ya              aman
     * generic exception	tidak           runtime gak tau tipe
     *
     * POLA BESAR (INI KUNCI SEMUA)
     *
     * Semua batasan ini berasal dari:
     * GENERICS = COMPILE-TIME ONLY
     * RUNTIME = TANPA TIPE (ERASURE)
     */

public class SomeGenericRestriction {

}
