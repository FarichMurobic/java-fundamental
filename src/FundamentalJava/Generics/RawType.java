package FundamentalJava.Generics;

/* ============================================================
 *                          RAW TYPE
 * ============================================================
 *
 * Raw type adalah penggunaan generic class tanpa
 * menyertakan type argument.
 *
 * Contoh:
 *
 * Gen raw = new Gen(98.6);
 *
 * Pada deklarasi tersebut, Gen digunakan sebagai
 * raw type karena tidak memiliki type argument.
 *
 * Sebaliknya, penulisan yang direkomendasikan adalah:
 *
 * Gen<Double> obj = new Gen<>(98.6);
 *
 * Dengan cara ini, compiler mengetahui bahwa object
 * hanya boleh bekerja dengan tipe Double.
 */


/* ------------------------------------------------------------
 * Apa yang Terjadi pada Raw Type?
 * ------------------------------------------------------------
 *
 * Ketika generic class digunakan sebagai raw type,
 * compiler memperlakukannya seolah-olah seluruh type
 * parameter dihapus.
 *
 * Misalnya:
 *
 * class Gen<T>
 *
 * digunakan sebagai:
 *
 * Gen raw
 *
 * Maka seluruh penggunaan T diperlakukan seperti Object.
 *
 * Akibatnya, manfaat utama generics seperti type safety
 * menjadi berkurang.
 */


/* ------------------------------------------------------------
 * Mengapa Raw Type Ada?
 * ------------------------------------------------------------
 *
 * Raw type disediakan untuk menjaga kompatibilitas
 * dengan kode Java yang ditulis sebelum generics
 * diperkenalkan.
 *
 * Sebelum JDK 5, Java belum memiliki generic sehingga
 * banyak API menggunakan Object sebagai tipe umum.
 *
 * Ketika generics diperkenalkan pada JDK 5,
 * Java tetap harus dapat menjalankan dan mengompilasi
 * kode lama tanpa perubahan besar.
 *
 * Oleh karena itu, raw type menjadi mekanisme
 * backward compatibility.
 */


/* ------------------------------------------------------------
 * Dampak Menggunakan Raw Type
 * ------------------------------------------------------------
 *
 * Penggunaan raw type menyebabkan compiler kehilangan
 * informasi mengenai type argument.
 *
 * Akibatnya:
 *
 * - Type safety berkurang.
 * - Compile-time checking menjadi terbatas.
 * - Compiler biasanya menghasilkan
 *   "unchecked warning".
 * - Risiko ClassCastException saat runtime meningkat.
 *
 * Oleh karena itu, raw type sebaiknya dihindari
 * pada kode Java modern.
 */


/* ------------------------------------------------------------
 * Raw Type Bukan Deprecated
 * ------------------------------------------------------------
 *
 * Raw type masih merupakan bagian dari bahasa Java
 * dan belum dihapus maupun ditandai sebagai deprecated.
 *
 * Namun, penggunaannya tidak lagi direkomendasikan
 * pada pengembangan aplikasi baru.
 *
 * Compiler akan memberikan peringatan (warning)
 * apabila penggunaan raw type berpotensi menyebabkan
 * operasi yang tidak aman (unchecked operation).
 *
 * Sebaiknya selalu gunakan parameterized type,
 * misalnya:
 *
 * List<String>
 * Map<String, Integer>
 * Gen<Double>
 *
 * agar type safety tetap terjaga.
 */


/* ------------------------------------------------------------
 * Hubungan dengan Type Erasure
 * ------------------------------------------------------------
 *
 * Raw type berkaitan erat dengan mekanisme
 * type erasure.
 *
 * Setelah proses kompilasi, informasi generic memang
 * dihapus oleh compiler.
 *
 * Namun pada compile-time, parameterized type tetap
 * memberikan pemeriksaan tipe yang tidak dimiliki
 * oleh raw type.
 *
 * Inilah alasan mengapa parameterized type jauh lebih
 * aman dibandingkan raw type.
 */


/* ------------------------------------------------------------
 * Ringkasan
 * ------------------------------------------------------------
 *
 * - Raw type adalah generic class tanpa type argument.
 *
 * - Raw type disediakan untuk menjaga backward
 *   compatibility dengan kode Java sebelum JDK 5.
 *
 * - Penggunaan raw type mengurangi manfaat utama
 *   generics, terutama type safety.
 *
 * - Compiler biasanya menghasilkan unchecked warning
 *   saat raw type digunakan.
 *
 * - Raw type tidak deprecated, tetapi penggunaannya
 *   tidak direkomendasikan pada kode Java modern.
 *
 * - Sebaiknya selalu gunakan parameterized type
 *   agar compiler dapat melakukan pemeriksaan tipe
 *   secara maksimal.
 */


/* ------------------------------------------------------------
 * Insight
 * ------------------------------------------------------------
 *
 * Saat mempelajari atau memelihara aplikasi Java lama,
 * Anda masih dapat menemukan penggunaan raw type,
 * terutama pada proyek yang dibuat sebelum generics
 * diperkenalkan.
 *
 * Pada pengembangan Java modern, praktik terbaik adalah
 * selalu menggunakan parameterized type dan menghindari
 * raw type kecuali benar-benar diperlukan untuk menjaga
 * kompatibilitas dengan API lama (legacy code).
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
