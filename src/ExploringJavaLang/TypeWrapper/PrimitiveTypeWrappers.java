package ExploringJavaLang.TypeWrapper;

/**
 * Primitive Type Wrappers
 *
 * Seperti yang sudah disebutkan di bagian sebelumnya,
 * Java menggunakan tipe primitif seperti int dan char untuk alasan performa.
 *
 * Tipe data ini bukan bagian dari hirarki object. Mereka:
 * dikirim ke method dengan by value
 * tidak bisa langsung dikirim sebagai reference
 * tidak ada cara bagi dua method untuk merujuk ke instance int yang sama
 *
 * Namun, ada situasi di mana kamu perlu membuat representasi object dari tipe primitif.
 *
 * Contohnya:
 * Class collection (dibahas di Chapter 18) hanya bisa menyimpan object
 * Jadi kalau ingin menyimpan tipe primitif, kamu harus membungkusnya ke dalam object
 *
 * Untuk mengatasi hal ini, Java menyediakan class khusus untuk setiap tipe primitif.
 *
 * Class ini:
 * membungkus (encapsulate) tipe primitif ke dalam object
 * karena itu disebut type wrappers (wrapper class)
 *
 * Wrapper ini sudah diperkenalkan di Chapter 12, dan akan dibahas lebih detail di sini.
 *
 * Intinya dulu biar gak bingung:
 * Java punya 2 dunia:
 * 1. Primitive (cepat, ringan)
 * int a = 10;
 *
 * 2. Object (fleksibel, powerful)
 * Integer a = 10;
 *
 * Masalah besar primitive
 * Bukan object
 *
 * Artinya:
 * gak punya method
 * gak bisa masuk ke sistem yang butuh object
 * Gak bisa share reference
 *
 * Contoh:
 * int a = 10;
 * int b = a;
 *
 * b = 20;
 *
 * a tetap 10
 * karena copy value, bukan reference
 *
 * Kenapa butuh Wrapper?
 * CASE REAL: Collection
 *
 * Misalnya lo pakai:
 * ArrayList<int> list; //  ERROR
 * Gak bisa
 *
 * Harus:
 * ArrayList<Integer> list; 
 *
 * Wrapper Class itu apa?
 * Wrapper = bungkus primitive jadi object
 *
 * Mapping Primitive → Wrapper
 * Primitive	Wrapper
 * int	        Integer
 * double	    Double
 * char	        Character
 * boolean	    Boolean
 * byte	        Byte
 * short	    Short
 * long	        Long
 * float	    Float
 */

/**
 * BEDAH LOGIC (INI PENTING BANGET)
 * Banyak yang salah paham di sini
 * Wrapper ≠ selalu reference mutable
 *
 * Contoh:
 * Integer x = 10;
 * x = 20;
 *
 * Ini bukan ubah value
 * Tapi bikin object baru
 *
 * Kenapa?
 * Karena Integer itu immutable
 *
 * Autoboxing & Unboxing
 * Java otomatis convert:
 * Integer a = 10;  // autoboxing
 * int b = a;       // unboxing
 *
 * Real case bug (sering kejadian)
 * Integer a = null;
 * int b = a; // NullPointerException
 *
 * Karena unboxing dari null
 *
 * KESIMPULAN SEDERHANA
 *
 * Intinya:
 * Primitive:
 * cepat
 * ringan
 * bukan object
 * Wrapper:
 * versi object dari primitive
 * bisa masuk ke collection
 * punya method
 *
 * Yang WAJIB lo inget:
 * Collection cuma nerima object
 * Wrapper = solusi buat itu
 * Wrapper itu immutable
 * Ada autoboxing & unboxing
 *
 * Best Practice
 * Jangan asal pakai primitive!
 *
 * Gunakan:
 * int → kalau pasti ada nilai
 * Integer → kalau bisa null
 */

import java.util.ArrayList;

public class PrimitiveTypeWrappers {
    public static void main(String[] args) {

        // Contoh 1: Primitive vs Wrapper

        // PRIMITIVE
        int a = 10;

        // WRAPPER
        Integer b = 10;

        // OUTPUT
        System.out.println("Primitive int: " + a);
        System.out.println("Wrapper Integer: " + b);

        // Wrapper punya method!
        System.out.println("Max Integer: " + Integer.MAX_VALUE); // nilai maksimum int

        // Contoh 2: Kenapa Collection butuh Wrapper

        // ArrayList hanya bisa menyimpan OBJECT
        ArrayList<Integer> list = new ArrayList<>();

        // Autoboxing (primitive -> object otomatis)
        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("Isi list:");

        for (Integer value : list) {
            // Unboxing (object -> primitive otomatis)
            System.out.println(value);
        }

        // Contoh 3: Passing Value vs Reference
        
        int x = 10;
        changePrimitive(x);

        System.out.println("Setelah changePrimitive: " + x); // tetap 10

        Integer y = 10;
        changeWrapper(y);

        System.out.println("Setelah changeWrapper: " + y); // tetap 10 juga!
    }

    // Method untuk primitive
    static void changePrimitive(int num) {
        num = 50; // cuma ubah copy
    }

    // Method untuk wrapper
    static void changeWrapper(Integer num) {
        num = 50; // object baru dibuat (immutable)
    }
}
