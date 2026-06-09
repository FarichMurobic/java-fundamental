package Generics;

/**
 * Generic Class Hierarchies
 *
 * Class generic bisa ikut sistem pewarisan (inheritance) kayak class biasa.
 *
 * Artinya:
 * Generic class bisa jadi parent (superclass)
 * Bisa juga jadi child (subclass)
 * 
 * Perbedaan penting:
 * Kalau parent-nya generic →
 * child WAJIB nerusin type parameter ke atas
 *
 * Ini bagian paling penting:
 * class Gen2<T> extends Gen<T>
 *
 * Artinya:
 * Gen2 punya <T>
 * dan dia meneruskan T ke Gen
 *
 * Jadi:
 * Kalau lu buat:
 *
 * Gen2<Integer> num = new Gen2<Integer>(100);
 *
 * Maka:
 * T = Integer
 * otomatis di Gen juga jadi Integer
 * 
 * KENAPA HARUS DITERUSKAN?
 *
 * Karena:
 * Parent (Gen<T>) butuh tau tipe data apa
 *
 * Kalau child gak kasih:
 * Compiler bakal bingung
 * ERROR
 *
 * Struktur Otaknya
 * Gen<T>
 *    ↑
 * Gen2<T, V>
 *
 * Artinya:
 * Gen cuma punya 1 tipe (T)
 * Gen2 punya 2 tipe:
 * T → dikirim ke parent
 * V → milik sendiri
 * 
 * Pas bikin object:
 * Gen2<String, Integer> x = new Gen2<>("Value is: ", 99);
 *
 * Maka:
 * T = String
 * V = Integer
 *
 * Di dalam object:
 * ob (dari Gen) = "Value is: "
 * ob2 (dari Gen2) = 99
 *
 * -------------------------------------------------------
 * 
 * KONSEP PENTING YANG WAJIB DIPAHAMI
 * 
 * 1. Generic tetap ikut inheritance
 * Sama kayak class biasa:
 * class A {}
 * class B extends A {}
 *
 * 2. Type parameter HARUS diteruskan
 * class Gen2<T> extends Gen<T>
 *
 * Kalau gak:
 * ERROR
 *
 * 3. Subclass boleh nambah tipe
 * class Gen2<T, V>
 * ini sering banget dipakai di dunia kerja
 *
 * Contoh real:
 * Pair<K, V>
 * Map<K, V>
 *
 * 4. Parent & child nyatu tipe-nya
 * Kalau:
 * Gen2<Integer, String>
 *
 * maka:
 * parent = Integer
 * child tambahan = String
 *
 * ---------------------------------------------------
 * 
 * KESIMPULAN
 * 
 * Generic bisa diwarisin (inheritance)
 * Subclass WAJIB terusin type ke parent
 * Subclass boleh tambah type baru
 * Semua tetap type-safe (aman dari error)
 *
 * REAL DI DUNIA KERJA
 *
 * Ini kepake banget bro, contoh:
 * class Response<T>
 * class ApiResponse<T, E>
 * class Pair<K, V>
 * class Map<K, V>
 *
 * Framework kayak:
 * Spring Boot
 * Hibernate
 * Android
 *
 * semuanya pake konsep ini
 */

// Class generics 
class Parent<T> {
    T objek;

    Parent(T o) {
        objek = o;
    }

    T getObjek() {
        return objek;
    }
}

// Subclass dari Parent yang generic
// Wajib nerusin (Child<T> extends Parent<T>)
class Child<T> extends Parent<T> {

    Child(T o) {
        super(o); // Kirim Parent
    }
}

// Subclass Parent dengan type tambahan V
class Child2<T, V> extends Parent<T> {
    V ob2;

    Child2(T a, V b) {
        super(a);
        ob2 = b;
    }

    V getOb2() {
        return ob2;
    }
}

public class GenericClassHierarchies {
    public static void main(String[] args) {
        
        Child<String> name = new Child("Farich Murobic");
        System.out.println(name.getObjek());

        Child2<String, Integer> biodata = new Child2("JaneRa F.M", 22);
        System.out.println(biodata.getObjek()); // Dari Parent
        System.out.println(biodata.getOb2());   // Dari Child2
    }

}
