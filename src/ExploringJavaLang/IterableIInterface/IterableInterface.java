package ExploringJavaLang.IterableIInterface;

/**
 * The Iterable Interface
 *
 * Interface Iterable harus diimplementasikan oleh class yang object-nya ingin digunakan dalam for-each loop.
 *
 * Artinya:
 * Supaya object bisa dipakai di:
 *
 * for (T item : object)
 *
 * class-nya harus implement Iterable
 *
 * Deklarasi
 * interface Iterable<T>
 *
 * Penjelasan:
 * T = tipe data yang di-iterasi
 *
 * Method utama
 * Iterator<T> iterator()
 *
 * Mengembalikan iterator untuk mengakses elemen
 *
 * Method tambahan (JDK 8+)
 * 1. forEach
 * default void forEach(Consumer<? super T> action)
 *
 * Menjalankan kode untuk setiap elemen
 *
 * 2. spliterator
 * default Spliterator<T> spliterator()
 *
 * Digunakan untuk iterasi advanced (parallel processing)
 *
 * Inti konsep
 *
 * Iterable =
 * object yang bisa di-loop satu per satu
 *
 * Analogi
 * Iterable = kotak berisi barang
 *
 * iterator() = tangan buat ambil satu-satu
 *
 * METHOD TAMBAHAN (JDK 8)
 * 1. forEach()
 * list.forEach(item -> System.out.println(item));
 *
 * pakai lambda
 *
 * 2. spliterator()
 * dipakai untuk:
 *
 * parallel processing
 * stream API
 *
 * HAL PENTING
 * Iterable ≠ Iterator
 * Iterable	                Iterator
 * container	            alat iterasi
 * punya iterator()	        punya next()
 *
 * Tidak semua object bisa di-loop
 *
 * Kalau tidak implement Iterable:
 * tidak bisa for-each
 *
 * USE CASE DI BACKEND
 * Dipakai di:
 * List
 * Set
 * Queue
 * Database result
 * JSON parsing
 *
 * Contoh real:
 * for (User user : userList)
 *
 * KAITAN KE STREAM API
 *
 * Iterable → Stream
 * list.stream().forEach(...)
 *
 * evolusi modern dari iteration
 *
 * KESIMPULAN
 * Inti:
 * Iterable = object yang bisa di-loop
 * Method utama:
 * iterator()
 *
 * Method tambahan:
 * forEach()
 * spliterator()
 *
 * Insight penting:
 * for-each loop = pakai Iterable
 * Iterable = fondasi semua collection Java
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MyCollection implements Iterable<Integer> {

    private int[] data = {1,2,3,4};

    @Override
    public Iterator<Integer> iterator() {
        
        // return iterator custom
        return new Iterator<Integer>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < data.length;
            }

            @Override
            public Integer next() {
                return data[index++];
            }
        };
    }
}

public class IterableInterface {
    public static void main(String[] args) {
        
        // CONTOH Iterable menggunakan ArrayList
        // ArrayList sudah implement Iterable
        List<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        // LOOPING
        for (String x : list) {
            System.out.println(x); // A B C
        }

        /**
         * Kenapa bisa for-each?
         *
         * Karena:
         * ArrayList implement Iterable
         *
         * CARA KERJA DI BELAKANG LAYAR
         *
         * Kode ini:
         * for (String x : list)
         *
         * Sebenarnya jadi:
         * Iterator<String> it = list.iterator();
         *
         * while (it.hasNext()) {
         *     String item = it.next();
         * }
         *
         * Insight penting
         * for-each = wrapper dari iterator
         */

        System.out.println();

        // Class custom yang implement Iterable
        MyCollection mycollection = new MyCollection();

        // Bisa pakai for-each
        for (int val : mycollection) {
            System.out.println(val); // 1 2 3 4 
        }

    }

}
