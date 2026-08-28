package FundamentalJava.Generics;

/* ============================================================
 *             CASTING PADA CLASS GENERIC
 * ============================================================
 *
 * Casting antar class generic diperbolehkan, tetapi terdapat aturan
 * yang harus dipenuhi agar tetap menjaga type safety.
 *
 * Dua syarat utama adalah:
 *
 * 1. Class harus memiliki hubungan inheritance.
 * 2. Type argument harus sama.
 *
 * Jika salah satu syarat tersebut tidak terpenuhi,
 * compiler akan menolak proses casting..
 */

/* ------------------------------------------------------------
 * Syarat 1 : Class Harus Compatible
 * ------------------------------------------------------------
 *
 * Misalnya terdapat hierarki berikut:
 *
 * Gen<T>
 *    ↑
 * Gen2<T>
 *
 * Karena Gen2 merupakan subclass dari Gen,
 * maka casting dari child ke parent diperbolehkan,
 * sama seperti inheritance pada class biasa.
 */

/* ------------------------------------------------------------
 * Syarat 2 : Type Argument Harus Sama
 * ------------------------------------------------------------
 *
 * Selain hubungan inheritance, type argument juga harus identik.
 *
 * Contoh:
 *
 * Gen2<Integer> obj = new Gen2<>(99);
 *
 * Maka object tersebut bertipe:
 *
 * Gen2<Integer>
 *
 * Bukan:
 *
 * Gen2<Long>
 * Gen2<Number>
 * Gen2<Object>
 */

/* ------------------------------------------------------------
 * Contoh Casting yang Valid
 * ------------------------------------------------------------
 *
 * Gen2<Integer> obj = new Gen2<>(99);
 *
 * Gen<Integer> ref = (Gen<Integer>) obj;
 *
 * Casting di atas valid karena:
 *
 * - Gen2 merupakan subclass dari Gen.
 * - Keduanya menggunakan type argument Integer.
 *
 * Secara konsep:
 *
 * Gen2<Integer>
 *        ↓
 * Gen<Integer>
 *
 * Sama seperti melakukan upcasting pada inheritance biasa.
 */

/* ------------------------------------------------------------
 * Contoh Casting yang Tidak Valid
 * ------------------------------------------------------------
 *
 * Gen2<Integer> obj = new Gen2<>(99);
 *
 * Gen<Long> ref = (Gen<Long>) obj;
 *
 * Casting tersebut tidak diperbolehkan karena:
 *
 * - Type argument sumber adalah Integer.
 * - Type argument tujuan adalah Long.
 *
 * Integer dan Long merupakan tipe yang berbeda sehingga
 * compiler akan menolak proses casting.
 *
 * Java menjaga agar type argument generic tidak dapat diubah
 * secara sembarangan.
 */

/* ------------------------------------------------------------
 * Mengapa Compiler Menolaknya?
 * ------------------------------------------------------------
 *
 * Compiler harus menjamin bahwa seluruh operasi generic
 * tetap type-safe.
 *
 * Jika casting seperti berikut diperbolehkan:
 *
 * Gen<Integer> → Gen<Long>
 *
 * maka program berpotensi menghasilkan kesalahan tipe data
 * yang sulit dideteksi.
 *
 * Oleh karena itu compiler menghentikan proses tersebut
 * sejak tahap compile-time.
 */

/* ------------------------------------------------------------
 * Hubungan dengan Type Erasure
 * ------------------------------------------------------------
 *
 * Mungkin muncul pertanyaan:
 *
 * "Bukankah generic dihapus saat runtime?"
 *
 * Jawabannya: benar.
 *
 * Java menerapkan type erasure sehingga informasi generic
 * tidak lagi tersedia pada sebagian besar proses runtime.
 *
 * Namun sebelum type erasure dilakukan,
 * compiler telah memverifikasi seluruh penggunaan generic.
 *
 * Artinya:
 *
 * - Compile-time mengetahui bahwa tipe adalah Integer.
 * - Runtime tidak lagi menyimpan informasi tersebut.
 *
 * Karena pengecekan dilakukan sebelum program dijalankan,
 * casting yang tidak valid sudah ditolak sejak proses kompilasi.
 */

/* ------------------------------------------------------------
 * Analogi
 * ------------------------------------------------------------
 *
 * Bayangkan terdapat dua kotak:
 *
 * Kotak<Integer>
 * Kotak<Long>
 *
 * Bentuk kedua kotak mungkin sama,
 * tetapi isi yang boleh disimpan berbeda.
 *
 * Kotak<Integer> tidak dapat dianggap sebagai
 * Kotak<Long>, meskipun keduanya berasal dari class yang sama.
 *
 * Generic menjaga agar isi setiap "kotak"
 * tetap sesuai dengan tipe yang telah ditentukan.
 */

/* ------------------------------------------------------------
 * Perbedaan dengan Casting Tanpa Generic
 * ------------------------------------------------------------
 *
 * Tanpa generic:
 *
 * Object obj = "Hello";
 * Integer value = (Integer) obj;
 *
 * Kode tersebut berhasil dikompilasi,
 * tetapi akan menghasilkan ClassCastException saat runtime.
 *
 * Dengan generic:
 *
 * Gen<Integer> a;
 * Gen<String> b;
 *
 * a = (Gen<Integer>) b;
 *
 * Compiler langsung menolak kode tersebut,
 * sehingga kesalahan dapat ditemukan lebih awal.
 *
 * Inilah salah satu keuntungan utama penggunaan generic,
 * yaitu mendeteksi kesalahan tipe sejak compile-time.
 */

/* ------------------------------------------------------------
 * Aturan Penting
 * ------------------------------------------------------------
 *
 * Diperbolehkan:
 *
 * Child<T> → Parent<T>
 *
 * Contoh:
 *
 * Gen2<Integer> → Gen<Integer>
 *
 * Tidak diperbolehkan:
 *
 * Child<Integer> → Parent<Long>
 *
 * meskipun class-nya masih memiliki hubungan inheritance.
 *
 * Type argument harus tetap sama.
 */

/* ------------------------------------------------------------
 * Contoh Lain
 * ------------------------------------------------------------
 *
 * Gen2<String> str = new Gen2<>("Hi");
 *
 * Valid:
 *
 * Gen<String> g1 = (Gen<String>) str;
 *
 * Tidak valid:
 *
 * Gen<Integer> g2 = (Gen<Integer>) str;
 *
 * Compiler menolak karena String dan Integer
 * merupakan type argument yang berbeda.
 */

/* ------------------------------------------------------------
 * Ringkasan
 * ------------------------------------------------------------
 *
 * Casting antar class generic hanya diperbolehkan jika:
 *
 * - Class memiliki hubungan inheritance.
 * - Type argument sama.
 *
 * Jika type argument berbeda,
 * compiler akan menghasilkan compile-time error.
 *
 * Aturan ini merupakan bagian dari mekanisme type safety
 * yang menjadi salah satu keunggulan utama generic di Java.
 */

/* ------------------------------------------------------------
 * Insight
 * ------------------------------------------------------------
 *
 * Aturan ini sangat sering dijumpai ketika bekerja dengan:
 *
 * - Java Collections Framework
 * - Generic API
 * - DTO dan Entity Mapping
 * - Framework seperti Spring dan Hibernate
 *
 * Dengan memverifikasi tipe sejak compile-time,
 * generic membantu mencegah banyak bug yang sebelumnya
 * baru diketahui ketika program dijalankan.
 */

class Satu<T> {
    T objek;

    Satu(T objek) {
        this.objek = objek;
    }

    T ambil() {
        return objek;
    }
}

class Dua<T> extends Satu<T> {

    Dua(T a) {
        super(a);
    }
}

public class Casting {
    public static void main(String[] args) {

        Satu<Integer> integerSatu = new Satu<>(20);
        Dua<Integer> integerDua = new Dua<>(22);

        // casting Amann
        Satu<Integer> casting = (Satu<Integer>) integerDua;

        // casting Error
        // Dua<Long> casting1 = (Dua<Long>) integerSatu;

        // Object biasa lolos compile tapi error runtime
        Object obj = "Hello";
        Integer x = (Integer) obj; // lolos compile, crash runtime
    }
}
