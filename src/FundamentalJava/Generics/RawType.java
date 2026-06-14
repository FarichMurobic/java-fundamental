package FundamentalJava.Generics;

/**
 * Intinya:
 *
 * Raw Type = Generic TANPA tipe
 * Contoh:
 * Gen raw = new Gen(98.6);
 *
 * harusnya:
 * Gen<Double> obj = new Gen<Double>(98.6);
 *
 * tapi ini:
 * Gen raw
 *
 * T-nya hilang → jadi Object
 *
 * KENAPA ADA RAW TYPE?
 * Karena sejarah Java
 *
 * sebelum JDK 5:
 * belum ada generics
 * semua pakai Object
 *
 * setelah generics muncul:
 * Java harus tetap support kode lama
 *
 * Jadi:
 * Raw type = jembatan antara kode lama & baru
 *
 * TAPI INI SEMUA SUDAH TIDAK BERLAKU SEJAK JAVA 9
 * DEPRACTED
 */

class GenericsA<T> {
    T ob; // menyimpan objek bertipe T

    GenericsA(T o) {
        ob = o;
    }

    // Methode mengembalikan nilai ob
    T getOb() {
        return ob;
    }
} 

public class RawType {
    public static void main(String[] args) {
        
        // Generic normal aman
        GenericsA<Integer> iob = new GenericsA<Integer>(88);
        GenericsA<String> sob = new GenericsA<String>("Farich JANERA");

        // Raw type (BAHAYA)
        // GenericsA raw = new GenericsA(new Double(98.6));
        // sejak java 9 sudah depracted. sudah gak bisa.

        // Harus casting manual
        // double d = (Double) raw.getob();
        // System.out.println("value: " + d);

        // ERROR runtime (salah casting)
        // int i = (Integer) raw.getob();

        // type safety rusak
        // strOb = raw;

        // String str = strOb.getob(); // runtime error

        // kebalik juga bahaya
        // raw = iOb;

        // d = (Double) raw.getob(); // runtime error

    }

}
