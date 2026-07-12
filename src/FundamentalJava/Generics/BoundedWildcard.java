package FundamentalJava.Generics;

/* ============================================================
 *                    BOUNDED WILDCARDS
 * ============================================================
 *
 * Sebelumnya kita telah mengenal wildcard:
 *
 * <?>
 *
 * Wildcard tanpa batas (unbounded wildcard) dapat merepresentasikan
 * generic dengan tipe apa pun.
 *
 * Contoh:
 *
 * Coords<TwoD>
 * Coords<ThreeD>
 * Coords<FourD>
 *
 * Seluruhnya dapat direferensikan sebagai:
 *
 * Coords<?>
 *
 * Wildcard biasa memberikan fleksibilitas yang sangat tinggi.
 * Namun, pada kondisi tertentu fleksibilitas tersebut terlalu luas,
 * karena kita hanya ingin menerima kelompok tipe tertentu.
 *
 * Untuk mengatasi kebutuhan tersebut, Java menyediakan
 * bounded wildcard.
 */


/* ------------------------------------------------------------
 * Upper Bounded Wildcard
 * ------------------------------------------------------------
 *
 * Bentuk umum:
 *
 * <? extends T>
 *
 * Artinya:
 *
 * Generic dapat menerima:
 * - T
 * - Seluruh subclass dari T
 *
 * Contoh:
 *
 * <? extends Number>
 *
 * Dapat menerima:
 *
 * Integer
 * Double
 * Float
 * Long
 *
 * Namun tidak dapat menerima:
 *
 * String
 * Object
 *
 * karena keduanya bukan turunan dari Number.
 */


/* ------------------------------------------------------------
 * Contoh Hierarki Class
 * ------------------------------------------------------------
 *
 * class TwoD {
 *     int x, y;
 * }
 *
 * class ThreeD extends TwoD {
 *     int z;
 * }
 *
 * class FourD extends ThreeD {
 *     int t;
 * }
 *
 * Generic:
 *
 * class Coords<T extends TwoD> {
 *     T[] coords;
 * }
 *
 * Batas:
 *
 * <T extends TwoD>
 *
 * menjamin bahwa seluruh object bertipe T minimal memiliki
 * seluruh member milik TwoD, yaitu:
 *
 * x
 * y
 *
 * Compiler dapat memverifikasi hal tersebut pada saat compile-time.
 */


/* ------------------------------------------------------------
 * Method showXY()
 * ------------------------------------------------------------
 *
 * Misalnya terdapat method:
 *
 * static void showXY(Coords<? extends TwoD> c)
 *
 * Method tersebut aman karena compiler mengetahui bahwa seluruh
 * object yang diterima minimal merupakan turunan TwoD.
 *
 * Artinya seluruh object pasti memiliki:
 *
 * x
 * y
 *
 * Oleh karena itu method dapat menerima:
 *
 * Coords<TwoD>
 * Coords<ThreeD>
 * Coords<FourD>
 *
 * dan seluruh field x serta y dapat diakses tanpa casting.
 */


/* ------------------------------------------------------------
 * Ketika Upper Bound Terlalu Umum
 * ------------------------------------------------------------
 *
 * Misalkan dibuat method:
 *
 * showXYZ()
 *
 * yang ingin mengakses:
 *
 * x
 * y
 * z
 *
 * Jika parameter masih menggunakan:
 *
 * <? extends TwoD>
 *
 * compiler tidak dapat menjamin bahwa field z tersedia,
 * karena class TwoD memang tidak memiliki field tersebut.
 *
 * Walaupun beberapa subclass memiliki field z,
 * compiler hanya mengetahui batas minimalnya, yaitu TwoD.
 */


/* ------------------------------------------------------------
 * Solusi: Upper Bound yang Lebih Spesifik
 * ------------------------------------------------------------
 *
 * Gunakan:
 *
 * <? extends ThreeD>
 *
 * Artinya parameter hanya dapat berupa:
 *
 * ThreeD
 * atau subclass dari ThreeD.
 *
 * Dengan demikian compiler mengetahui bahwa setiap object
 * pasti memiliki:
 *
 * x
 * y
 * z
 *
 * Method sekarang dapat menerima:
 *
 * Coords<ThreeD>
 * Coords<FourD>
 *
 * tetapi tidak dapat menerima:
 *
 * Coords<TwoD>
 *
 * karena TwoD belum memiliki field z.
 */


/* ------------------------------------------------------------
 * Method yang Lebih Spesifik
 * ------------------------------------------------------------
 *
 * Jika sebuah method membutuhkan seluruh field:
 *
 * x
 * y
 * z
 * t
 *
 * maka gunakan:
 *
 * <? extends FourD>
 *
 * Karena hanya FourD dan turunannya yang dijamin memiliki
 * seluruh field tersebut.
 *
 * Pada contoh hierarki ini, method hanya dapat menerima:
 *
 * Coords<FourD>
 */


/* ------------------------------------------------------------
 * Tingkat Spesifikasi Upper Bound
 * ------------------------------------------------------------
 *
 * Semakin spesifik upper bound yang digunakan,
 * semakin sedikit tipe generic yang dapat diterima.
 *
 * ------------------------------------------------------------
 * Method      Parameter                  Menerima
 * ------------------------------------------------------------
 * showXY()    <? extends TwoD>           TwoD, ThreeD, FourD
 * showXYZ()   <? extends ThreeD>         ThreeD, FourD
 * showAll()   <? extends FourD>          FourD
 * ------------------------------------------------------------
 */


/* ------------------------------------------------------------
 * Upper Bound Bersifat Producer (Read)
 * ------------------------------------------------------------
 *
 * Wildcard:
 *
 * <? extends T>
 *
 * umumnya digunakan ketika object hanya akan dibaca (read).
 *
 * Compiler mengetahui bahwa setiap elemen minimal bertipe T,
 * sehingga seluruh member milik T dapat diakses dengan aman.
 *
 * Sebaliknya, compiler tidak mengetahui tipe konkret dari object,
 * sehingga penambahan elemen baru tidak diperbolehkan
 * (kecuali null).
 *
 * Oleh karena itu:
 *
 * <? extends T>
 *
 * dikenal sebagai:
 *
 * Producer (Read Only)
 *
 * Artinya object menghasilkan (produce) data untuk dibaca,
 * bukan untuk diisi.
 */


/* ------------------------------------------------------------
 * Lower Bounded Wildcard
 * ------------------------------------------------------------
 *
 * Bentuk umum:
 *
 * <? super T>
 *
 * Artinya generic dapat menerima:
 *
 * T
 * atau superclass dari T.
 *
 * Contoh:
 *
 * <? super Integer>
 *
 * dapat menerima:
 *
 * List<Integer>
 * List<Number>
 * List<Object>
 *
 * tetapi tidak dapat menerima:
 *
 * List<Double>
 * List<String>
 *
 * karena keduanya bukan superclass dari Integer.
 */


/* ------------------------------------------------------------
 * Lower Bound Bersifat Consumer (Write)
 * ------------------------------------------------------------
 *
 * Wildcard:
 *
 * <? super T>
 *
 * biasanya digunakan ketika collection akan diisi (write).
 *
 * Compiler menjamin bahwa object bertipe T dapat dimasukkan
 * dengan aman ke dalam collection tersebut.
 *
 * Namun ketika membaca data kembali, compiler hanya dapat
 * menjamin bahwa hasilnya bertipe Object, karena tipe konkret
 * collection tidak diketahui.
 *
 * Oleh karena itu:
 *
 * <? super T>
 *
 * dikenal sebagai:
 *
 * Consumer (Write)
 *
 * Artinya object menerima (consume) data untuk disimpan.
 */


/* ------------------------------------------------------------
 * Prinsip PECS
 * ------------------------------------------------------------
 *
 * Dalam penggunaan generic terdapat prinsip yang sangat terkenal,
 * yaitu:
 *
 * PECS
 *
 * Producer Extends
 * Consumer Super
 *
 * Artinya:
 *
 * - <? extends T> digunakan ketika data hanya dibaca (read).
 *
 * - <? super T> digunakan ketika data akan ditulis (write).
 *
 * Prinsip ini merupakan best practice dalam merancang API
 * yang menggunakan generic di Java.
 */


/* ------------------------------------------------------------
 * Analogi
 * ------------------------------------------------------------
 *
 * Hierarki koordinat:
 *
 * TwoD
 * ├── x
 * └── y
 *
 * ThreeD
 * ├── x
 * ├── y
 * └── z
 *
 * FourD
 * ├── x
 * ├── y
 * ├── z
 * └── t
 *
 * Maka:
 *
 * <? extends TwoD>
 * menjamin minimal memiliki x dan y.
 *
 * <? extends ThreeD>
 * menjamin minimal memiliki x, y, dan z.
 *
 * <? extends FourD>
 * menjamin memiliki x, y, z, dan t.
 *
 * Semakin tinggi batas (bound), semakin banyak member yang dapat
 * digunakan secara aman oleh compiler.
 */


/* ------------------------------------------------------------
 * Ringkasan
 * ------------------------------------------------------------
 *
 * - Unbounded wildcard (<?>) menerima semua tipe generic.
 *
 * - Upper bounded wildcard (<? extends T>) menerima T beserta
 *   seluruh subclass-nya.
 *
 * - Lower bounded wildcard (<? super T>) menerima T beserta
 *   seluruh superclass-nya.
 *
 * - <? extends T> cocok digunakan untuk operasi membaca (read).
 *
 * - <? super T> cocok digunakan untuk operasi menulis (write).
 *
 * - Semakin spesifik upper bound, semakin sedikit tipe yang dapat
 *   diterima oleh generic.
 *
 * - Ingat prinsip PECS:
 *
 *      Producer Extends
 *      Consumer Super
 *
 * Prinsip ini merupakan pedoman utama dalam penggunaan bounded
 * wildcard di Java.
 */


// CONTOH PENGGUNAAN BOUNDED WILDCARD
// Koordinat 2 dimensi
class TwoD {
    int x, y;

    TwoD(int a, int b) {
        this.x = a;
        this.y = b;
    }
}

// Koordinat 3 dimensi - turunan dari TwoD
class ThreeD extends TwoD {
    int z;

    ThreeD(int a, int b, int c) {
        super(a, b);
        this.z = c;
    }
}

// Koordinat 4 dimensi - turunan dari ThreeD
class FourD extends ThreeD {
    int t;

    FourD(int a, int b, int c, int d) {
        super(a, b, c);
        this.t = d;
    }
}

// Class generic untuk menyimpan array koordinat
// EXTENDS TwoD
class Coords<T extends TwoD> {
    T[] coords;

    // konstruktor menerima array kordinat
    Coords(T[] o) {
        coords = o;
    }
}

public class BoundedWildcard {

    // Menampilkan koordinat X dan Y (semua tipe boleh)
    static void showXY(Coords<?> c) {
        System.out.println("X Y Coordinates:");
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println(c.coords[i].x + " " +
                               c.coords[i].y);
        }
        System.out.println();
    }

    // Menampilkan koordinat X, Y, Z (minimal ThreeD)
    static void showXYZ(Coords<? extends ThreeD> c) { // BOUNDED WILDCARD
        System.out.println("X Y Z Coordinates:");
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println(c.coords[i].x + " " +
                               c.coords[i].y + " " +
                               c.coords[i].z);
        }
        System.out.println();
    }

    // Menampilkan semua koordinat (X, Y, Z, T) (hanya FourD)
    static void showAll(Coords<? extends FourD> c) { // BOUNDED WILDCARD
        System.out.println("X Y Z T Coordinates:");
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println(c.coords[i].x + " " +
                               c.coords[i].y + " " +
                               c.coords[i].z + " " +
                               c.coords[i].t);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Data TwoD
        TwoD twoD[] = {
                new TwoD(0,0),
                new TwoD(7,9),
                new TwoD(18,4),
                new TwoD(-1,-23)
        };

        Coords<TwoD> tdlocs = new Coords<TwoD>(twoD);

        System.out.println("Contens of tdlocs.");
        showXY(tdlocs);
        // showXYZ(tdlocs); // error tidak punya z
        // showAll(tdlocs); // error tidak punya t

        // Data FourD
        FourD fourD[] = {
                new FourD(1,2,3,4),
                new FourD(6,8,14,8),
                new FourD(22,9,4,9),
                new FourD(3,-2,-23,17)
        };

        Coords<FourD> fdlocs = new Coords<FourD>(fourD);

        System.out.println("Contens of fdlocs.");
        // SEMUA VALID
        showXY(fdlocs);
        showXYZ(fdlocs);
        showAll(fdlocs);

    }

}
