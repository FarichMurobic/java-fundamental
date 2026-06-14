package FundamentalJava.Comparable;
import java.util.Arrays;

/**
 * APA ITU Comparable?
 * Definisi simpel:
 * Comparable = interface buat ngebandingin object
 *
 * Bentuk aslinya:
 * 
 * public interface Comparable<T> {
 *   int compareTo(T o);
 * }
 *
 * Intinya:
 * lu kasih tau Java:
 * “Gimana cara nentuin object ini lebih besar / kecil dari object lain?”
 * 
 * ------------------------------------------------------
 * 
 * CARA KERJA compareTo()
 * Method utama:
 * int compareTo(T o)
 *
 * Aturan return:
 * Nilai        return	Arti
 * < 0	        this < o
 * 0	        this == o
 * > 0	        this > o
 *
 * Contoh sederhana:
 * Integer a = 10;
 * Integer b = 20;
 *
 * System.out.println(a.compareTo(b)); // -1
 *
 * karena 10 < 20
 *
 * -----------------------------------------------
 * 
 * KENAPA HARUS Comparable?
 * Karena Java butuh aturan urutan
 * Contoh:
 * sorting array
 * sorting list
 * TreeSet / TreeMap
 *
 * tanpa Comparable, Java gak tau:
 * mana lebih besar?
 *
 * HUBUNGAN DENGAN GENERICS
 * Ini yang lu lihat tadi:
 * <T extends Comparable<T>>
 *
 * Artinya:
 * T harus bisa dibandingkan
 *
 * Kenapa penting?
 * Karena di dalam kode ada:
 * compareTo()
 *
 * kalau gak ada Comparable → ERROR
 * 
 * --------------------------------------------
 *
 * VERSI SINGKAT (PRO CODING)
 * Biasanya ditulis gini:
 * return this.umur - m.umur;
 *
 * tapi hati-hati:
 * bisa overflow (jarang sih)
 *
 * PERBEDAAN Comparable vs Comparator
 * Comparable:
 * aturan ada di dalam class
 * default behavior
 *
 * Comparator:
 * aturan di luar class
 * bisa banyak versi sorting
 *
 * -----------------------------------------
 * 
 * REAL USE DI DUNIA KERJA
 * Dipakai di:
 * sorting data user
 * ranking
 * priority system
 * database result ordering (kadang di layer Java)
 *
 * Framework:
 * Spring Boot
 * Hibernate
 * Collections API
 *
 * ----------------------------------------------
 * 
 * MINDSET PALING PENTING
 * Comparable itu bukan cuma syntax
 * tapi aturan logika urutan
 *
 * "Gimana cara object dibandingin?"
 *
 * KESIMPULAN
 * 1. Comparable = alat buat bandingin object
 *
 * 2. method utama:
 * compareTo()
 *
 * 3. return:
 * negatif
 * nol
 * positif
 *
 * 4. dipakai di:
 * sorting
 * generics
 * collections
 */

class Mahasiswa implements Comparable<Mahasiswa> {

    String nama;
    int umur;

    Mahasiswa(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }

    public int compareTo(Mahasiswa mahasiswa) {
        System.out.println("Bandingin: " + this.umur + " sama " + mahasiswa.umur);

        // Bandingkan berdasarkan umur
        if (this.umur < mahasiswa.umur) {
            return -1;
        } else if (this.umur > mahasiswa.umur) {
            return 1;
        } else {
            return 0;
        }      
    }
}

public class ComparableJava {
    public static void main(String[] args) {
        
        // Buat objek array
        Mahasiswa[] data = {
            new Mahasiswa("Janera", 20),
            new Mahasiswa("J.E Murobic", 25),
            new Mahasiswa("Farich M.e.J", 21)
        };

        Arrays.sort(data);

        // Cetak semua data
        for (Mahasiswa x : data) {
            System.out.println(x.nama + " " + x.umur);
        }

        /**
         * OUTPUT
         * Bandingin: 25 sama 20
         * Bandingin: 21 sama 25
         * Bandingin: 21 sama 25
         * Bandingin: 21 sama 20
         * Janera 20
         * Farich M.e.J 21
         * J.E Murobic 25
         * 
         * otomatis ke-sort karena Comparable
         */
    }
}
