package Generics;

/**
 * Intinya apa sih?
 *
 * Dulu (Java lama), kalau bikin object generic itu ribet karena harus nulis tipe 2x.
 * Sekarang (Java 7+), compiler bisa nebak sendiri tipe datanya.
 * Ini disebut: Type Inference
 *
 * Cara Lama (Verbose / Ribet)
 * MyClass<Integer, String> mcOb =
 *     new MyClass<Integer, String>(98, "A String");
 *
 * Lu harus nulis:
 * <Integer, String> di kiri
 * <Integer, String> lagi di kanan
 *
 * Cara Baru (Modern - Diamond Operator)
 * MyClass<Integer, String> mcOb =
 *     new MyClass<>(98, "A String"); // compiler nebak otomatis
 *
 * Tanda <> ini disebut:
 * Diamond Operator
 *
 * Kenapa bisa?
 * Karena compiler lihat:
 * MyClass<Integer, String> mcOb
 *
 * Jadi dia tahu:
 * T = Integer
 * V = String
 *
 * Maka di kanan gak perlu ditulis lagi.
 *
 * ----------------------------------------------------
 * 
 * PENJELASAN
 * 
 * 1. Diamond Operator <>
 *
 * Artinya:
 * "Compiler, tolong tebak tipe datanya dari context"
 *
 * Type Inference gak cuma buat object
 * Bisa juga buat:
 * Parameter Method
 * obj1.isSame(new MyClass<>(10, "Hello"));
 *
 * Compiler tahu:
 * karena isSame(MyClass<T, V>)
 * maka otomatis T = Integer, V = String
 *
 * -----------------------------------------------
 * 
 * HAL PENTING 
 * 
 * Type inference cuma bantu compile-time
 *
 * Di runtime:
 * Java tetap gak tahu generic type (type erasure)
 *
 * Jangan overconfident
 * Kadang kalau terlalu kompleks:
 * var obj = new MyClass<>(10, "Hello"); // Java 10+
 *
 * Bisa bikin bingung kalau dibaca orang lain
 *
 * REAL DI DUNIA KERJA
 *
 * Ini sering banget dipakai di:
 * List<String> list = new ArrayList<>();
 * Map<String, Integer> map = new HashMap<>();
 *
 * Semua pakai <>
 *
 * KESIMPULAN
 * <> = Diamond Operator
 * Fungsinya: biar gak nulis tipe 2x
 * Compiler otomatis nebak dari kiri / context
 * Bikin kode:
 * lebih pendek
 * lebih clean
 * lebih readable
 */

class BedRoom<T, V> {
    T badroom1;
    V badroom2;

    BedRoom(T a, V b) {
        badroom1 = a;
        badroom2 = b;
    }

    // method untuk cek apakah isi method sama
    boolean isSame(BedRoom<T, V> o) {
        // bandingkan isi object
        if (badroom1.equals(o.badroom1) && badroom2.equals(o.badroom2)) {
            return true;
        }
        return false;
    }
}

public class TypeInference {
    public static void main(String[] args) {
        
        // Cara lama panjang
        BedRoom<Integer, String> objek1 = new BedRoom<Integer, String>(10, "Hello");
        // cara baru lebih clean
        BedRoom<Integer, String> objek2 = new BedRoom<>(10, "Hello"); // type inference

        // CEK apakah sama?
        if (objek1.isSame(objek2)) {
            System.out.println("objek sama");
        }

        // Langsung buat objek tanpa nulis tipe di kanan
        if (objek1.isSame(new BedRoom<>(10, "Hello"))) {
            System.out.println("object sama juga (langsung new)");
        }
    }
}
