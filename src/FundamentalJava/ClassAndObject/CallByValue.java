package FundamentalJava.ClassAndObject;

/**
 * ---------------------------------------------------------------------------
 * PASSING ARGUMENT TO METHOD (PENGIRIMAN ARGUMENT KE METHOD)
 * ---------------------------------------------------------------------------
 *
 * Saat sebuah method dipanggil, nilai yang diberikan pada method
 * tersebut disebut argument..
 *
 * Contoh:
 *
 * sum(10, 20);
 *
 * Nilai:
 *
 * 10 dan 20
 *
 * merupakan argument yang akan diterima oleh parameter method.
 *
 * Dalam dunia pemrograman secara umum, terdapat dua mekanisme
 * utama untuk mengirim argument ke subroutine atau method.
 *
 * - Call-by-Value
 * - Call-by-Reference
 *
 * Namun, Java hanya menggunakan satu mekanisme:
 *
 * Call-by-Value
 *
 * Ini merupakan salah satu topik yang paling sering disalahpahami
 * oleh programmer pemula.
 *
 * ---------------------------------------------------------------------------
 * CALL-BY-VALUE
 * ---------------------------------------------------------------------------
 *
 * Pada Call-by-Value, nilai argument akan disalin (copy) ke
 * parameter method.
 *
 * Artinya:
 *
 * - Method menerima salinan nilai.
 * - Method tidak menerima variabel asli.
 * - Perubahan parameter tidak mengubah variabel asal.
 *
 * Flow:
 *
 * Argument Asli
 * -> Copy Nilai
 * -> Parameter Method
 *
 * ---------------------------------------------------------------------------
 * CALL-BY-REFERENCE
 * ---------------------------------------------------------------------------
 *
 * Pada Call-by-Reference, yang dikirim adalah referensi langsung
 * ke variabel asli.
 *
 * Artinya:
 *
 * - Method bekerja pada data asli.
 * - Perubahan parameter langsung mempengaruhi data asal.
 *
 * Flow:
 *
 * Variabel Asli
 * -> Reference Langsung
 * -> Parameter Method
 * -> Perubahan Mempengaruhi Data Asli
 *
 * ---------------------------------------------------------------------------
 * JAVA SELALU CALL-BY-VALUE
 * ---------------------------------------------------------------------------
 *
 * Hal yang wajib diingat:
 *
 * Java tidak mendukung Call-by-Reference.
 *
 * Semua argument di Java dikirim menggunakan:
 *
 * Call-by-Value
 *
 * Tidak peduli apakah tipe datanya:
 *
 * - Primitive.
 * - Object.
 *
 * Keduanya tetap menggunakan Call-by-Value.
 *
 * Perbedaannya hanya terletak pada apa yang disalin.
 *
 * ---------------------------------------------------------------------------
 * PERILAKU BERDASARKAN TIPE DATA
 * ---------------------------------------------------------------------------
 *
 * Primitive Type:
 *
 * -> Yang disalin adalah nilai (value).
 *
 * Object Type:
 *
 * -> Yang disalin adalah reference.
 *
 * Ringkasan:
 *
 * Primitive
 * -> Copy Value
 *
 * Object
 * -> Copy Reference
 *
 * ---------------------------------------------------------------------------
 * PRIMITIVE TYPE -> PASSED BY VALUE
 * ---------------------------------------------------------------------------
 *
 * Jika parameter bertipe primitive, Java akan membuat salinan
 * nilai dari argument yang dikirim.
 *
 * Contoh:
 *
 * int x = 10;
 *
 * change(x);
 *
 * Method:
 *
 * void change(int value) {
 * value = 100;
 * }
 *
 * Hasil:
 *
 * x tetap bernilai 10.
 *
 * Mengapa?
 *
 * Karena:
 *
 * x
 * -> Copy Nilai
 * -> value
 *
 * value hanya salinan, bukan variabel asli.
 *
 * ---------------------------------------------------------------------------
 * VISUALISASI MEMORY (PRIMITIVE)
 * ---------------------------------------------------------------------------
 *
 * Sebelum Method Dipanggil:
 *
 * x = 10
 *
 * Setelah Dipanggil:
 *
 * value = 10
 *
 * Flow:
 *
 * x = 10
 * -> Copy
 * -> value = 10
 *
 * Jika:
 *
 * value = 100;
 *
 * Maka:
 *
 * x tetap 10.
 *
 * ---------------------------------------------------------------------------
 * OBJECT SEBAGAI PARAMETER
 * ---------------------------------------------------------------------------
 *
 * Ketika object dikirim ke method, banyak programmer mengira
 * Java berubah menjadi Call-by-Reference.
 *
 * Ini tidak benar.
 *
 * Java tetap menggunakan:
 *
 * Call-by-Value
 *
 * Tetapi yang disalin bukan object-nya.
 *
 * Yang disalin adalah:
 *
 * Reference Object
 *
 * ---------------------------------------------------------------------------
 * APA ITU REFERENCE?
 * ---------------------------------------------------------------------------
 *
 * Variabel object sebenarnya tidak menyimpan object secara
 * langsung.
 *
 * Variabel object menyimpan reference yang menunjuk ke object
 * di memory.
 *
 * Contoh:
 *
 * Test ob = new Test(15, 20);
 *
 * Secara konseptual:
 *
 * ob
 * -> Reference
 * -> Object Test
 *
 * ---------------------------------------------------------------------------
 * VISUALISASI MEMORY (OBJECT)
 * ---------------------------------------------------------------------------
 *
 * Sebelum Method Dipanggil:
 *
 * ob
 * -> Object
 * -> a = 15
 * -> b = 20
 *
 * Saat Method Dipanggil:
 *
 * method(ob);
 *
 * Java menyalin reference:
 *
 * ob
 * -> Copy Reference
 * -> o
 *
 * Hasil:
 *
 * ob dan o menunjuk object yang sama.
 *
 * Flow:
 *
 * ob
 * -> Object
 *
 * o
 * -> Object yang Sama
 *
 * ---------------------------------------------------------------------------
 * MENGAPA OBJECT BISA BERUBAH?
 * ---------------------------------------------------------------------------
 *
 * Karena:
 *
 * - Reference disalin.
 * - Tetapi kedua reference menunjuk object yang sama.
 *
 * Jika method mengubah isi object:
 *
 * o.a = 100;
 *
 * Maka object yang dilihat oleh ob juga berubah.
 *
 * Flow:
 *
 * Copy Reference
 * -> Object yang Sama
 * -> Perubahan Object
 * -> Terlihat Dari Semua Reference
 *
 * ---------------------------------------------------------------------------
 * HAL YANG TIDAK BISA DILAKUKAN
 * ---------------------------------------------------------------------------
 *
 * Banyak yang mengira kode berikut dapat mengganti object asli:
 *
 * void change(Test o) {
 * o = new Test();
 * }
 *
 * Ini salah.
 *
 * Mengapa?
 *
 * Karena yang berubah hanya salinan reference milik parameter.
 *
 * Reference asli tetap tidak berubah.
 *
 * Flow:
 *
 * ob
 * -> Object Lama
 *
 * o
 * -> Object Baru
 *
 * Setelah method selesai:
 *
 * o hilang
 * ob tetap menunjuk object lama
 *
 * ---------------------------------------------------------------------------
 * KESALAHPAHAMAN YANG SERING TERJADI
 * ---------------------------------------------------------------------------
 *
 * Pernyataan berikut salah:
 *
 * "Java menggunakan Call-by-Reference untuk object."
 *
 * Yang benar:
 *
 * Java selalu menggunakan Call-by-Value.
 *
 * Untuk object:
 *
 * - Yang dicopy adalah reference.
 * - Bukan object.
 *
 * Karena reference hasil copy menunjuk object yang sama,
 * perubahan isi object tetap terlihat dari luar method.
 *
 * ---------------------------------------------------------------------------
 * CARA MENCEGAH OBJECT BERUBAH
 * ---------------------------------------------------------------------------
 *
 * Dalam beberapa kasus, programmer tidak ingin object asli
 * berubah ketika dikirim ke method.
 *
 * Solusi yang umum digunakan:
 *
 * - Copy Constructor.
 * - Clone Object.
 * - Immutable Object.
 *
 * Flow:
 *
 * Object Asli
 * -> Salinan Baru
 * -> Method Bekerja Pada Salinan
 * -> Object Asli Tetap Aman
 *
 * ---------------------------------------------------------------------------
 * JAVA MODERN (PRAKTIK TERBAIK)
 * ---------------------------------------------------------------------------
 *
 * Pada Java modern, pendekatan yang paling disukai adalah
 * menggunakan Immutable Object.
 *
 * Contohnya:
 *
 * - String
 * - LocalDate
 * - LocalDateTime
 * - BigDecimal
 *
 * Karena object immutable tidak dapat diubah setelah dibuat,
 * risiko perubahan tidak sengaja menjadi jauh lebih kecil.
 *
 * ---------------------------------------------------------------------------
 * KESIMPULAN
 * ---------------------------------------------------------------------------
 *
 * Java selalu menggunakan Call-by-Value.
 *
 * Untuk Primitive:
 *
 * - Yang disalin adalah nilai.
 * - Perubahan parameter tidak mempengaruhi variabel asli.
 *
 * Untuk Object:
 *
 * - Yang disalin adalah reference.
 * - Reference hasil copy tetap menunjuk object yang sama.
 * - Perubahan isi object akan terlihat dari luar method.
 *
 * Hal yang wajib diingat:
 *
 * Java BUKAN Call-by-Reference.
 *
 * Java adalah:
 *
 * Call-by-Value
 * -> Primitive = Copy Value
 * -> Object = Copy Reference
 *
 * Memahami konsep ini sangat penting karena sering muncul saat:
 *
 * - OOP.
 * - Collection Framework.
 * - Spring Framework.
 * - Technical Interview Java.
 */

// CONTOH PRIMITIVE
class CallValuePrimitive {

    void meth(int i, int j) {
        i *= 2;
        j /= 2;

        System.out.println(i);
        System.out.println(j);
    }
}

// CONTOH OBJECT
class CallValueObject {

    int a, b;

    CallValueObject(int i, int j) {
        this.a = i;
        this.b = j;
    }

    // OBJECT AS PARAMETER
    void meth(CallValueObject o) {
        o.a *= 2;
        o.b /= 2;

        System.out.println(o.a);
        System.out.println(o.b);
    }
}

public class CallByValue {
    public static void main(String[] args) {

        // CONTOH PRIMITIVE
        CallValuePrimitive typePrimitive = new CallValuePrimitive();

        int a = 15, b = 20;
        // Before call the method meth()
        System.out.println(a + " " + b); // a 15 b 20

        // After call the method meth()
        typePrimitive.meth(a, b); // a 30 b 10

        // Panggil lagi a dan b setelah method dipanggil
        // Nilai asli tidak berubah
        System.out.println(a + " " + b); // a 15 b 20

        /**
         * Output
         * 15 20
         * 30
         * 10
         * 15 20
         *
         * Penjelasan Kode
         * Method:
         * void meth(int i, int j)
         * Parameter:
         * i
         * j
         * 
         * Ketika dipanggil:
         * ob.meth(a,b);
         *
         * Java membuat copy nilai:
         * i = 15
         * j = 20
         *
         * Alur Program
         * Nilai awal
         * a = 15
         * b = 20
         *
         * Method dipanggil
         * i = 15
         * j = 20
         *
         * Operasi di dalam method
         * i *= 2 → 30
         * j /= 2 → 10
         *
         * Tetapi yang berubah hanya:
         * i dan j
         * Bukan:
         * a dan b
         *
         * Setelah method selesai
         * Nilai asli tetap:
         * a = 15
         * b = 20
         */

        System.out.println("-----------------------------");

        // CONTOH OBJECT
        CallValueObject typeObject = new CallValueObject(15, 20);

        // Sebelum panggil method meth()
        System.out.println(typeObject.a + " " + typeObject.b); // a 15 b 20

        // Panggil method
        typeObject.meth(typeObject); // a 30 b 10

        // Sesudah method meth() dipanggil
        // Nilai asli berubah
        System.out.println(typeObject.a + " " + typeObject.b); // a 30 b 10

        /**
         * Output
         * 15 20
         * 30
         * 10
         * 30 10
         *
         * Alur Program
         * Membuat object
         * typeObject → object
         * a = 15
         * b = 20
         *
         * Memanggil method
         * typeObject.meth(ob)
         *
         * Java copy reference.
         * Jadi parameter:
         * o → menunjuk object yang sama
         *
         * Di dalam method
         * o.a *= 2 → 30
         * o.b /= 2 → 10
         *
         * Karena o menunjuk object yang sama dengan objek.
         * Maka object asli berubah.
         *
         * Setelah method selesai
         * typeObject.a = 30
         * typeObject.b = 10
         */
    }
}
