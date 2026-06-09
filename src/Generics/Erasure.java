package Generics;

/**
 * APA ITU ERASURE?
 * Intinya:
 * Semua informasi generic DIHAPUS saat compile
 *
 * Jadi pas program jalan (runtime):
 * TIDAK ADA lagi <T>, <Integer>, dll
 * Java cuma lihat Object / tipe bound
 *
 * ---------------------------
 * 
 * PROSESNYA GIMANA?
 * Misalnya lu punya kode:
 * class Box<T> {
 *     T data;
 *
 *     Box(T data) {
 *         this.data = data;
 *     }
 *
 *     T getData() {
 *         return data;
 *     }
 * }
 *
 * Setelah di-compile (ERASURE)
 * Kurang lebih jadi gini:
 *
 * class Box {
 *     Object data;
 *
 *     Box(Object data) {
 *         this.data = data;
 *     }
 *
 *     Object getData() {
 *         return data;
 *     }
 * }
 *
 * Lihat?
 * T hilang 
 * diganti jadi Object
 *
 * TERUS KOK BISA BALIK JADI INTEGER / STRING?
 *
 * Jawabannya:
 * Compiler nambahin CAST otomatis
 *
 * Contoh:
 * Box<Integer> box = new Box<>(10);
 * Integer val = box.getData();
 * Setelah erasure:
 * Box box = new Box(10);
 * Integer val = (Integer) box.getData(); // otomatis ditambah compiler
 *
 * -------------------------------------------
 * 
 * Nah ini penting:
 * Generic itu cuma bantu di compile-time
 * Runtime tetap pakai cast
 *
 * KENAPA JAVA PAKE ERASURE?
 *
 * Karena:
 * Backward Compatibility
 *
 * Artinya:
 * Code Java lama (sebelum generics) tetap jalan
 * JVM gak perlu diubah
 *
 * KESIMPULAN SUPER PENTING
 * Generics = compile-time feature
 * Runtime = tidak tahu generic
 * Semua <T> → dihapus (erased)
 * Diganti:
 * Object
 * atau bound (misalnya Number)
 * Compiler otomatis nambah:
 * cast
 * pengecekan type safety
 */

// ini contoh kode BRIDGE METHOD
class BapakKucing<T> {
    T ob;

    BapakKucing(T ob) {
        this.ob = ob;
    }

    // methode generic
    T getOb() {
        System.out.println("Bapak kucing getOb()");
        return ob;
    }
}

// subclass spesific string
class Kucing extends BapakKucing<String> {

    Kucing(String o) {
        super(o);
    }

    // override versi string
    @Override
    String getOb() {
        System.out.println("Gen2 getOb()");
        return ob;
    }
}

public class Erasure {
    public static void main(String[] args) {
        
        Kucing g2 = new Kucing("Hello");

        // panggil langsung
        String s = g2.getOb();
        System.out.println("value dari s: " + s);

        System.out.println();

        // polymorphism (INI KUNCI NYA)
        BapakKucing ref = g2; // RAW TYPE SENGAJA
        Object o = ref.getOb();
        System.out.println("value dari ref: " + o);
    }

}
