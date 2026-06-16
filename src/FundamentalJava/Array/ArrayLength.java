package FundamentalJava.Array;

/**
 * ---------------------------------------------------------------------------
 * ARRAY ADALAH OBJECT
 * ---------------------------------------------------------------------------
 *
 * Di Java, array bukan sekadar kumpulan data seperti pada beberapa
 * bahasa pemrograman lainnya.
 *
 * Array merupakan object yang dibuat secara otomatis oleh JVM.
 *
 * Karena array adalah object, setiap array memiliki atribut dan
 * karakteristik tertentu yang dapat digunakan oleh program.
 *
 * Salah satu atribut yang paling sering digunakan adalah:
 *
 * length
 *
 * ---------------------------------------------------------------------------
 * PROPERTY length
 * ---------------------------------------------------------------------------
 *
 * Setiap array di Java memiliki property:
 *
 * length
 *
 * Property ini digunakan untuk mengetahui ukuran array atau jumlah
 * elemen yang dapat ditampung oleh array tersebut.
 *
 * Contoh:
 *
 * int[] numbers = new int[5];
 *
 * Maka:
 *
 * numbers.length -> 5
 *
 * Artinya array memiliki kapasitas untuk menyimpan 5 elemen.
 *
 * ---------------------------------------------------------------------------
 * KARAKTERISTIK length
 * ---------------------------------------------------------------------------
 *
 * Property length:
 *
 * - Dimiliki oleh semua array.
 * - Bertipe int.
 * - Bersifat read-only (tidak dapat diubah langsung).
 * - Menunjukkan ukuran array yang dibuat saat alokasi memori.
 * - Selalu tersedia selama object array masih ada.
 *
 * Flow:
 * Array Dibuat
 * -> JVM Menentukan Ukuran
 * -> Nilai length Disimpan
 * -> Dapat Diakses Menggunakan .length
 *
 * ---------------------------------------------------------------------------
 * PERBEDAAN KAPASITAS DAN JUMLAH DATA
 * ---------------------------------------------------------------------------
 *
 * Hal yang sangat penting untuk dipahami:
 *
 * length tidak menunjukkan jumlah elemen yang sedang digunakan.
 *
 * length hanya menunjukkan kapasitas array.
 *
 * Contoh:
 *
 * int[] a = new int[5];
 *
 * a[0] = 10;
 * a[1] = 20;
 *
 * Isi array:
 *
 * [10, 20, 0, 0, 0]
 *
 * Meskipun hanya dua elemen yang berisi nilai yang kita masukkan,
 * nilai:
 *
 * a.length
 *
 * tetap menghasilkan:
 *
 * 5
 *
 * karena ukuran array sejak awal memang 5 elemen.
 *
 * ---------------------------------------------------------------------------
 * CONTOH PENGGUNAAN length
 * ---------------------------------------------------------------------------
 *
 * Property length paling sering digunakan untuk melakukan
 * perulangan pada array.
 *
 * Contoh:
 *
 * for (int i = 0; i < numbers.length; i++) {
 *     System.out.println(numbers[i]);
 * }
 *
 * Keuntungan:
 *
 * - Tidak perlu menghafal ukuran array.
 * - Kode lebih fleksibel.
 * - Mengurangi risiko ArrayIndexOutOfBoundsException.
 *
 * ---------------------------------------------------------------------------
 * ARRAY DAN OBJECT
 * ---------------------------------------------------------------------------
 *
 * Karena array adalah object:
 *
 * - Array dibuat menggunakan operator new.
 * - Array memiliki referensi.
 * - Array disimpan di Heap Memory.
 * - Array memiliki property bawaan seperti length.
 *
 * Contoh:
 *
 * int[] data = new int[10];
 *
 * Flow:
 * new
 * -> Membuat Object Array
 * -> Disimpan Di Heap
 * -> Reference Variable Menunjuk Ke Object
 *
 * ---------------------------------------------------------------------------
 * ISTILAH PENTING
 * ---------------------------------------------------------------------------
 *
 * Array:
 * -> Struktur data yang menyimpan banyak nilai bertipe sama
 *    dalam satu object.
 *
 * length:
 * -> Property bawaan array yang menunjukkan ukuran atau
 *    kapasitas array.
 *
 * Capacity (Kapasitas):
 * -> Jumlah elemen maksimum yang dapat ditampung array.
 *
 * Overflow:
 * -> Kondisi ketika data yang ingin dimasukkan melebihi
 *    kapasitas yang tersedia.
 *
 * Underflow:
 * -> Kondisi ketika mengambil data dari struktur data yang
 *    kosong.
 *
 * Catatan:
 *
 * Istilah Overflow dan Underflow lebih umum digunakan pada
 * struktur data seperti Stack, Queue, atau Buffer.
 * Pada array Java, ketika mengakses indeks di luar batas,
 * yang biasanya terjadi adalah:
 *
 * ArrayIndexOutOfBoundsException
 *
 * ---------------------------------------------------------------------------
 * KESIMPULAN
 * ---------------------------------------------------------------------------
 *
 * Array di Java merupakan object yang dibuat oleh JVM.
 *
 * Karena array adalah object, setiap array memiliki property
 * bawaan bernama:
 *
 * length
 *
 * Property ini menunjukkan ukuran atau kapasitas array,
 * bukan jumlah elemen yang sedang digunakan.
 *
 * length sangat penting karena sering digunakan untuk:
 *
 * - Mengetahui ukuran array.
 * - Membuat perulangan yang aman.
 * - Menghindari akses indeks di luar batas array.
 *
 * Memahami bahwa array adalah object merupakan fondasi penting
 * sebelum mempelajari Collection Framework, Memory Management,
 * Reference Variable, dan struktur data yang lebih kompleks.
 */

public class ArrayLength {
    public static void main(String[] args) {
        
        int number[] = {1,2,3,4,5,6,7,8,9,10};

        System.out.println(number.length);

        // Tampilkan nilai array pake for biasa
        for (int i = 0; i < number.length; i++) {
            System.out.print(number[i]);
        }

        System.out.println();

        // Tampilkan nilai array pake for each
        // For each gak perlu pake .length
        for (int i : number) { 
            System.out.print(i);
        }
    }
}
