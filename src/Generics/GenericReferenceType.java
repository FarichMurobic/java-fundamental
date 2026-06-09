package Generics;

/**
 * Saat kita pakai generics:
 * tipe yang dimasukin ke <T> harus reference type
 *
 * Tidak boleh:
 * int
 * char
 * double
 *
 * Contoh SALAH
 * Gen<int> intOb = new Gen<int>(53); // Error, tidak bisa pakai tipe primitive
 *
 * Ini error saat compile
 *
 * Kenapa?
 * Karena generics di Java:
 * cuma bekerja dengan object (class)
 *
 * Solusi
 * Pakai wrapper class:
 * Primitive	    Wrapper
 * int	            Integer
 * char	            Character
 * double	        Double
 *
 * Contoh BENAR
 * Gen<Integer> intOb = new Gen<Integer>(53);
 *
 * Kenapa gak masalah?
 * Karena ada:
 *
 * Autoboxing & Unboxing
 * new Gen<Integer>(53);
 *
 * 53 otomatis jadi Integer
 *
 * GENERIC BERBEDA = TIPE BERBEDA
 * 
 * Intinya
 * Walaupun sama-sama Gen<T>:
 * Gen<Integer> bukan Gen<String>
 *
 * Contoh ERROR
 * iOb = strOb; // Salah!
 *
 * Kenapa?
 *
 * iOb = Gen<Integer>
 * strOb = Gen<String>
 *
 * beda tipe → gak kompatibel
 *
 * Ini penting banget
 * Generics bikin Java jadi ketat (strict)
 *
 * -------------------------------------
 * 
 * KONSEP DALAM (WAJIB NGENA)
 * 
 * Generics = Mengubah Runtime Error → Compile Error
 *
 * Ini penting banget bro
 * Kenapa ini bagus?
 *
 * Karena:
 * bug ketahuan lebih cepat
 * gak bikin program crash di user
 *
 * KESIMPULAN SUPER JELAS
 * 1. Generics hanya untuk reference type
 * int
 * double
 * Integer
 * String
 *
 * 2. Generic beda = tipe beda
 * Gen<Integer> ≠ Gen<String>
 *
 * 3. Tanpa generics:
 * harus casting
 * rawan error runtime
 *
 * 4. Dengan generics:
 * gak perlu casting
 * aman
 * error ketahuan saat compile
 *
 * 5. Poin paling penting:
 * Generics = keamanan tipe (type safety)
 */

// CONTOH TANPA GENERICS
// class non generics secara fungsi sama seperti Gen
// tetapi tidak menggunakan generics
class NonGenerics {
    Object object; // object bertipe Object

    // konstruktor menerima object bertipe Object
    NonGenerics(Object object) {
        this.object = object;
    }

    // mengembalikan Object
    Object getObject() {
        return object;
    }

    // menampilkan tipe dari object
    void show() {
        System.out.println("Type of object is " + object.getClass().getName());
    }
}

public class GenericReferenceType {
    public static void main(String[] args) {
        
        NonGenerics ob;

        // MEMBAUT objek NonGenerics dan menyimpan Integer
        // autoboxing tetap terjadi
        ob = new NonGenerics(88);

        // MENAMPILKAN tipe data
        ob.show();

        // MENGAMBIL nilai harus casting
        int v = (Integer) ob.getObject();
        System.out.println("value " + v);

        System.out.println();

        // MEMBUAT object lain dan menyimpan string
        NonGenerics stringObjek = new NonGenerics("Non generics Test");

        // MENAMPILKAN tipe data
        stringObjek.show();

        // MENGAMBIL nilai harus casting
        String str = (String) stringObjek.getObject();
        System.out.println("value: " + str);

        // ini boleh secara syntaks, tapi salah secara konsep!
        ob = stringObjek;
        // ERROR saat runtime
        v = (Integer) ob.getObject();

        /**
         * BEDAH MASALAH (INI BAGIAN KRUSIAL)
         *
         * MASALAH 1: HARUS CASTING
         * int v = (Integer) iOb.getob();
         *
         * Kenapa?
         *
         * karena return = Object
         * Java gak tau isi aslinya
         *
         * MASALAH 2: RAWAN ERROR
         * Perhatikan ini:
         * iOb = strOb;
         *
         * Ini BOLEH di Java lama 
         *
         * Tapi isinya:
         * strOb → String
         * iOb → dianggap Integer
         *
         * Lalu ini:
         * v = (Integer) iOb.getob();
         *
         * BOOM! ERROR RUNTIME
         *
         * Kenapa bisa kejadian?
         *
         * Karena:
         * Semua dianggap Object
         *
         * Java gak bisa ngecek:
         * isi sebenarnya apa
         *
         * GENERICS MENYELESAIKAN INI
         *
         * Kalau pakai generics:
         * Gen<Integer> iOb;
         * Gen<String> strOb;
         *
         * iOb = strOb; // ERROR SAAT COMPILE
         * Langsung ditolak
         *
         * Ini keunggulan utama
         *
         * Tanpa generics
         * Error muncul saat:
         * program jalan (bahaya)
         *
         * Dengan generics
         * Error muncul saat:
         * compile (AMAN)
         */
    }
}
