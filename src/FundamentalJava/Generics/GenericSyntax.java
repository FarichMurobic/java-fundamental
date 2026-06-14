package FundamentalJava.Generics;

/**
 * Deklarasi generic class
 * 
 * class class-name<type-param-list> { // …
 *
 * Artinya:
 * class-name = nama class
 * <type-param-list> = daftar parameter tipe (T, V, dll)
 *
 * Cara pakai (buat object)
 * 
 * class-name<type-arg-list> var-name =
 *     new class-name<type-arg-list>(cons-arg-list);
 *
 * Artinya:
 * type-arg-list = tipe asli (Integer, String, dll)
 * cons-arg-list = parameter constructor
 *
 * -----------------------------------------------
 * 
 * A. DEKLARASI CLASS
 * 
 * Bentuk umum:
 * // Deklarasi class generic dengan parameter tipe
 * class NamaClass<T> {
 * 
 * }
 * 
 *  Kalau lebih dari satu:
 * // Class generic dengan dua parameter tipe
 * class NamaClass<T, V> {
 *
 * }
 *
 * Penjelasan:
 * T, V = placeholder
 * nanti diganti tipe asli
 *
 * MEMBUAT OBJECT (INI KRUSIAL)
 * 
 * Bentuk umum:
 * // Membuat object dari class generic
 * NamaClass<TipeAsli> namaVariabel =
 *     new NamaClass<TipeAsli>(parameterConstructor);
 *
 * Contoh 1 (1 tipe)
 * // Membuat object dengan tipe Integer
 * Gen<Integer> obj = new Gen<Integer>(10);
 *
 * Artinya:
 * T → diganti Integer
 *
 * Contoh 2 (2 tipe)
 * // Membuat object dengan dua tipe: Integer dan String
 * TwoGen<Integer, String> obj =
 *     new TwoGen<Integer, String>(10, "Halo");
 *
 * Artinya:
 * T → Integer
 * V → String
 *
 * -------------------------------------------
 * 
 * POLA YANG HARUS LU HAFAL (INI PENTING)
 *
 * Pola dasar generics:
 * 1. Deklarasi
 * class Nama<T>
 *
 * 2. Pakai
 * Nama<Tipe> var = new Nama<Tipe>();
 *
 * Ini muncul terus di Java
 *
 * HAL PENTING YANG SERING BIKIN SALAH
 * 1. Tipe harus sama
 * // SALAH (beda tipe)
 * Gen<Integer> obj = new Gen<String>("Test");
 *
 * Harus sama:
 * // BENAR (tipe konsisten)
 * Gen<Integer> obj = new Gen<Integer>(10);
 *
 * --------------------------------------------
 * 
 * KESIMPULAN
 * 
 * 1. Generic class punya pola:
 * class Nama<T>
 *
 * 2. Object dibuat dengan:
 * Nama<Tipe> var = new Nama<Tipe>();
 *
 * 3. <T> = placeholder
 * diganti saat object dibuat
 *
 * 4. Jumlah & urutan tipe HARUS sesuai
 *
 * 5. Ini fondasi semua generics
 */

class Animal<F, U> {
    F inisial;
    U usia;

    Animal(F inisial, U usia) {
        this.inisial = inisial;
        this.usia = usia;
    }

    // SETTER
    public void setInisial() {
        System.out.println("Inisial " + inisial.getClass().getName()); 
        System.out.println("Usia " + usia.getClass().getName());
    }

    // GETTER
    public F getInisial() {
        return inisial;
    }

    // GETTER
    public U getUsia() {
        return usia;
    }
}

public class GenericSyntax {
    public static void main(String[] args) {
        
        Animal<String, Integer> name = new Animal<String, Integer>("Janera", 22);
        name.setInisial();

        String string = name.getInisial();
        System.out.println(string);

        int usia = name.getUsia();
        System.out.println(usia);
    }
}
