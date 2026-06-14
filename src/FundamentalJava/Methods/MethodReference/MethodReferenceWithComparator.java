package FundamentalJava.Methods.MethodReference;

/**
 * Intinya:
 *
 * Untuk cari nilai terbesar di collection → pakai Collections.max()
 * Tapi BUTUH:
 * Comparator<T>
 *
 * Comparator itu apa?
 * Interface buat ngebandingin 2 object
 *
 * Method-nya:
 * compare(a, b)
 *
 * Return:
 * 0 → a lebih besar
 * = 0 → sama
 * < 0 → b lebih besar
 *
 * Cara lama (sebelum Java 8)
 *
 * Harus:
 * bikin class implement Comparator
 * buat object
 * kirim ke max()
 *
 * Cara baru (Java 8+)
 *
 * cukup:
 * Collections.max(list, ClassName::method)
 *
 * langsung beres
 *
 * Insight DALAM
 * 1. Ini contoh nyata:
 * “Method reference otomatis jadi Comparator”
 *
 * 2. Lo gak perlu bikin class lagi
 *
 * Dulu:
 * class MyComparator implements Comparator<MyClass>
 *
 * Sekarang:
 * UseMethodRef::compareMC
 *
 * 3. Ini bikin code:
 * lebih pendek
 * lebih clean
 * lebih modern
 *
 * -------------------------
 * 
 * Versi Lebih Modern (REAL PROJECT)
 *
 * Biasanya di dunia kerja gak bikin method sendiri
 *
 * Pakai Comparator bawaan
 * MyClass max = Collections.max(list,
 *         Comparator.comparing(MyClass::getVal));
 *
 * Ini artinya:
 * (a, b) -> a.getVal() - b.getVal()
 *
 * Versi Stream (lebih modern lagi)
 * MyClass max = list.stream()
 *         .max(Comparator.comparing(MyClass::getVal))
 *         .orElse(null);
 *
 * ===============================================
 * 
 * Kesimpulan Super Sederhana
 * Inti:
 * Comparator = cara bandingin object
 * Collections.max() butuh comparator
 * Method reference bisa jadi comparator
 * Gak perlu bikin class manual lagi
 */

import java.util.*;

// Class data (model)
class MyClass {
    private int val;
    public MyClass(int v) {
        this.val = v;
    }

    public int getVal() {
        return val;
    }
}

public class MethodReferenceWithComparator {

    // Method pembanding (Comparator logic)
    static int compareMc(MyClass a, MyClass b) {
        // Jika a > b → positif
        // Jika a < b → negatif
        return a.getVal() - b.getVal();
    }

    public static void main(String[] args) {

        // Buat list
        ArrayList<MyClass> list = new ArrayList<>();
        list.add(new MyClass(1));
        list.add(new MyClass(4));
        list.add(new MyClass(2));
        list.add(new MyClass(9));
        list.add(new MyClass(3));

        // METHOD REFERENCE DIGUNAKAN DI SINI
        MyClass max = Collections.max(list, MethodReferenceWithComparator::compareMc);
        System.out.println("Nilai terbesar: " + max.getVal());

    }
}
