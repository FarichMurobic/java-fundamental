package ExploringJavaLang.Void;

/**
 * Apa itu Void?
 *
 * Class Void hanya memiliki satu field, yaitu:
 * TYPE
 *
 * Field ini menyimpan referensi ke Class object untuk tipe void.
 *
 * Catatan penting
 * Kamu tidak bisa membuat object dari Void
 *
 * 1. void vs Void
 * Tipe	        Penjelasan
 * void	        tipe primitive (tidak ada nilai)
 * Void	        class wrapper
 *
 * 2. Kenapa Void ada?
 * Padahal:
 * void method()
 *
 * gak return apa-apa
 * Jawabannya:
 * dipakai untuk:
 * reflection
 * generic
 * framework (Spring, dll)
 *
 * 3. Void.TYPE
 * Void.TYPE
 *
 * sama dengan:
 * void.class
 *
 * 4. Kenapa gak bisa bikin object?
 * Void v = new Void(); // ERROR
 *
 * karena:
 * tidak ada constructor publik
 * memang tidak didesain untuk instansiasi
 *
 * 5. Contoh REAL CASE (ADVANCED)
 * Generic method
 * 
 * public Void doSomething() {
 *     // gak return apa-apa
 *     return null;
 * }
 *
 * ini dipakai kalau:
 * method harus return object
 * tapi sebenarnya gak ada nilai
 *
 * Future / Async (contoh real backend)
 * CompletableFuture<Void>
 *
 * artinya:
 * proses async tanpa return value
 *
 * PERBANDINGAN
 * Case	                    Gunakan
 * Method biasa	            void
 * Generic / framework	    Void
 *
 * --------------------------
 * 
 * KESIMPULAN SEDERHANA
 *
 * Intinya:
 * Void = wrapper untuk void
 * cuma punya TYPE
 * gak bisa dibuat object
 *
 * REAL TALK
 * Di backend (Spring Boot dll):
 * sering ketemu:
 * ResponseEntity<Void>
 *
 * artinya:
 * response tanpa body
 */

public class VoidJava {
    public static void main(String[] args) {

        Class<?> c1 = Void.TYPE;
        Class<?> c2 = void.class;

        System.out.println(c1 == c2); // true
        System.out.println("Class: " + c1.getName()); // void
    }
}
