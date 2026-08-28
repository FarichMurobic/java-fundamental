package FundamentalJava.Comparable;

/**
 * COMPARABLE INTERFACE
 * ------------------------------------------------------------
 *
 * Comparable adalah interface bawaan Java yang digunakan untuk
 * mendefinisikan aturan perbandingan (natural ordering) suatu
 * object terhadap object lain yang memiliki tipe yang sama.
 *
 * Dengan Comparable, sebuah class dapat menentukan sendiri
 * bagaimana object-objectnya dibandingkan, diurutkan (sorting),
 * atau dievaluasi berdasarkan nilai tertentu..
 *
 * Interface Comparable berada dalam package:
 *
 * java.lang
 *
 * Bentuk sederhananya:
 *
 * public interface Comparable<T> {
 *     int compareTo(T o);
 * }
 *
 * ------------------------------------------------------------
 * TUJUAN COMPARABLE
 * ------------------------------------------------------------
 *
 * Comparable digunakan ketika Java membutuhkan aturan urutan
 * antar object.
 *
 * Contoh penggunaan:
 *
 * - Sorting array object.
 * - Sorting collection (List, Set, dll).
 * - TreeSet.
 * - TreeMap.
 * - Priority Queue.
 * - Sistem ranking.
 * - Sistem prioritas.
 *
 * Tanpa Comparable, Java tidak mengetahui bagaimana cara
 * menentukan object mana yang lebih kecil, sama, atau lebih besar.
 *
 * ------------------------------------------------------------
 * METHOD compareTo()
 * ------------------------------------------------------------
 *
 * Method utama pada Comparable adalah:
 *
 * int compareTo(T o)
 *
 * Method ini membandingkan object saat ini (this)
 * dengan object lain yang diterima sebagai parameter.
 *
 * Bentuk umum:
 *
 * this.compareTo(o)
 *
 * ------------------------------------------------------------
 * ATURAN NILAI RETURN
 * ------------------------------------------------------------
 *
 * Hasil compareTo() memiliki arti sebagai berikut:
 *
 * - Return < 0
 *   -> Object saat ini lebih kecil dari object pembanding.
 *
 * - Return 0
 *   -> Kedua object dianggap sama.
 *
 * - Return > 0
 *   -> Object saat ini lebih besar dari object pembanding.
 *
 * Flow:
 *
 * this.compareTo(o)
 * -> Nilai Negatif
 * -> this < o
 *
 * this.compareTo(o)
 * -> Nilai Nol
 * -> this == o
 *
 * this.compareTo(o)
 * -> Nilai Positif
 * -> this > o
 *
 * ------------------------------------------------------------
 * CONTOH PADA CLASS INTEGER
 * ------------------------------------------------------------
 *
 * Integer a = 10;
 * Integer b = 20;
 *
 * System.out.println(a.compareTo(b));
 *
 * Hasil:
 *
 * -1
 *
 * Karena:
 *
 * 10 < 20
 *
 * Maka:
 *
 * a.compareTo(b) < 0
 *
 * ------------------------------------------------------------
 * HUBUNGAN DENGAN GENERICS
 * ------------------------------------------------------------
 *
 * Comparable sering digunakan bersama Generics.
 *
 * Contoh:
 *
 * <T extends Comparable<T>>
 *
 * Artinya:
 *
 * T harus mengimplementasikan Comparable.
 *
 * Dengan demikian compiler menjamin bahwa object bertipe T
 * memiliki method compareTo().
 *
 * Flow:
 *
 * T
 * -> Implements Comparable<T>
 * -> Memiliki compareTo()
 * -> Bisa Dibandingkan
 * -> Bisa Diurutkan
 *
 * ------------------------------------------------------------
 * IMPLEMENTASI COMPARABLE PADA CLASS SENDIRI
 * ------------------------------------------------------------
 *
 * Contoh:
 *
 * class Mahasiswa implements Comparable<Mahasiswa> {
 *
 *     int umur;
 *
 *     @Override
 *     public int compareTo(Mahasiswa m) {
 *         return Integer.compare(this.umur, m.umur);
 *     }
 * }
 *
 * Pada contoh tersebut:
 *
 * - Mahasiswa diurutkan berdasarkan umur.
 * - Semakin kecil umur -> semakin kecil nilai urutan.
 *
 * ------------------------------------------------------------
 * CARA LAMA VS CARA MODERN
 * ------------------------------------------------------------
 *
 * Cara lama yang sering ditemukan:
 *
 * return this.umur - m.umur;
 *
 * Walaupun terlihat sederhana, cara ini memiliki risiko
 * overflow pada nilai integer yang sangat besar.
 *
 * Contoh modern yang direkomendasikan:
 *
 * return Integer.compare(this.umur, m.umur);
 *
 * Atau:
 *
 * return Long.compare(this.id, m.id);
 *
 * Atau:
 *
 * return Double.compare(this.nilai, m.nilai);
 *
 * Pendekatan ini lebih aman dan menjadi praktik yang lebih
 * direkomendasikan pada Java modern.
 *
 * ------------------------------------------------------------
 * COMPARABLE VS COMPARATOR
 * ------------------------------------------------------------
 *
 * Comparable:
 *
 * - Aturan perbandingan berada di dalam class.
 * - Hanya memiliki satu aturan utama (natural ordering).
 * - Menggunakan method compareTo().
 *
 * Comparator:
 *
 * - Aturan perbandingan berada di luar class.
 * - Dapat memiliki banyak versi sorting.
 * - Menggunakan method compare().
 *
 * Flow:
 *
 * Comparable
 * -> Aturan Default Di Dalam Class
 *
 * Comparator
 * -> Aturan Tambahan Di Luar Class
 *
 * ------------------------------------------------------------
 * PENGGUNAAN DI DUNIA KERJA
 * ------------------------------------------------------------
 *
 * Comparable sering digunakan untuk:
 *
 * - Sorting data pengguna.
 * - Ranking nilai.
 * - Sistem prioritas.
 * - Pengurutan data bisnis.
 * - Struktur data TreeSet.
 * - Struktur data TreeMap.
 * - Collections API.
 *
 * Framework dan library Java juga sering memanfaatkan
 * Comparable ketika membutuhkan natural ordering suatu object.
 *
 * ------------------------------------------------------------
 * ISTILAH PENTING
 * ------------------------------------------------------------
 *
 * Comparable
 * -> Interface untuk mendefinisikan aturan perbandingan object.
 *
 * compareTo()
 * -> Method utama untuk melakukan perbandingan.
 *
 * Natural Ordering
 * -> Urutan bawaan/default suatu object.
 *
 * Sorting
 * -> Proses pengurutan data.
 *
 * Generics
 * -> Mekanisme parameterisasi tipe data.
 *
 * ------------------------------------------------------------
 * KESIMPULAN
 * ------------------------------------------------------------
 *
 * Comparable adalah interface yang digunakan untuk menentukan
 * bagaimana suatu object dibandingkan dengan object lain yang
 * bertipe sama.
 *
 * Method utamanya adalah:
 *
 * compareTo()
 *
 * Dengan aturan:
 *
 * - Negatif -> lebih kecil.
 * - Nol -> sama.
 * - Positif -> lebih besar.
 *
 * Comparable merupakan dasar berbagai fitur pengurutan pada
 * Java seperti Collections API, TreeSet, TreeMap, dan berbagai
 * algoritma sorting lainnya.
 *
 * Dalam Java modern, lebih disarankan menggunakan:
 *
 * Integer.compare()
 * Long.compare()
 * Double.compare()
 *
 * dibandingkan pengurangan langsung untuk menghindari risiko
 * overflow dan menghasilkan kode yang lebih aman.
 */

import java.util.Arrays;

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
