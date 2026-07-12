package FundamentalJava.Generics;

/* ============================================================
 *                    WILDCARD (<?>)
 * ============================================================
 *
 * Wildcard digunakan ketika suatu operasi tidak bergantung
 * pada type argument tertentu, tetapi tetap ingin menerima
 * object generic dengan berbagai type argument.
 *
 * Wildcard ditulis menggunakan tanda:
 *
 * ?
 *
 * yang berarti "tipe tidak diketahui" (unknown type).
 */


/* ============================================================
 * Mengapa Wildcard Diperlukan?
 * ============================================================
 *
 * Misalkan terdapat generic class:
 *
 * class Stats<T extends Number>
 *
 * Class tersebut dapat digunakan dengan berbagai tipe angka,
 * misalnya:
 *
 * Stats<Integer>
 * Stats<Double>
 * Stats<Float>
 *
 * Seluruh type argument tersebut valid karena semuanya
 * merupakan subclass dari Number.
 */


/* ------------------------------------------------------------
 * Tujuan
 * ------------------------------------------------------------
 *
 * Misalnya ingin membuat method untuk membandingkan
 * nilai rata-rata dari dua object Stats.
 *
 * Contoh penggunaan:
 *
 * Stats<Integer> intStats = ...
 * Stats<Double> doubleStats = ...
 *
 * intStats.sameAvg(doubleStats);
 *
 * Method seharusnya dapat membandingkan kedua object,
 * meskipun type argument-nya berbeda.
 */


/* ============================================================
 * Pendekatan yang Kurang Tepat
 * ============================================================
 *
 * Contoh:
 *
 * boolean sameAvg(Stats<T> other)
 *
 * Pada generic class:
 *
 * class Stats<T extends Number>
 *
 * T mengacu pada type parameter milik object saat ini.
 *
 * Misalnya object bertipe:
 *
 * Stats<Integer>
 *
 * maka parameter method menjadi:
 *
 * Stats<Integer>
 *
 * Akibatnya, method hanya dapat menerima:
 *
 * Stats<Integer>
 *
 * dan tidak dapat menerima:
 *
 * Stats<Double>
 * Stats<Float>
 *
 * Padahal seluruh object tersebut tetap memenuhi
 * batasan T extends Number.
 */


/* ============================================================
 * Solusi: Wildcard
 * ============================================================
 *
 * Gunakan:
 *
 * boolean sameAvg(Stats<?> other)
 *
 * Wildcard menunjukkan bahwa parameter dapat berupa
 * Stats dengan type argument apa pun.
 *
 * Karena class Stats sudah memiliki batasan:
 *
 * T extends Number
 *
 * maka wildcard tersebut secara efektif dapat menerima:
 *
 * Stats<Integer>
 * Stats<Double>
 * Stats<Float>
 *
 * tanpa bergantung pada tipe angka tertentu.
 */


/* ------------------------------------------------------------
 * Cara Kerja
 * ------------------------------------------------------------
 *
 * Misalnya:
 *
 * Stats<Integer> intStats = ...
 * Stats<Double> doubleStats = ...
 *
 * intStats.sameAvg(doubleStats);
 *
 * Parameter method bertipe:
 *
 * Stats<?>
 *
 * sehingga object Stats dengan type argument apa pun
 * dapat diterima selama sesuai dengan deklarasi class.
 *
 * Hal ini membuat method menjadi jauh lebih fleksibel.
 */


/* ============================================================
 * Konsep Penting
 * ============================================================
 *
 * 1. Wildcard berarti "unknown type".
 *
 * Stats<?>
 *
 * menunjukkan bahwa type argument ada,
 * tetapi tidak diketahui secara spesifik.
 *
 *
 * 2. Wildcard meningkatkan fleksibilitas.
 *
 * Tanpa wildcard:
 *
 * Stats<T>
 *
 * parameter harus memiliki type argument yang sama.
 *
 * Dengan wildcard:
 *
 * Stats<?>
 *
 * parameter dapat menggunakan type argument
 * yang berbeda.
 *
 *
 * 3. Wildcard tidak mengubah batasan generic class.
 *
 * Jika class dideklarasikan sebagai:
 *
 * class Stats<T extends Number>
 *
 * maka wildcard tetap hanya berlaku
 * untuk type argument yang memenuhi batasan tersebut.
 *
 * Wildcard tidak menghilangkan constraint
 * yang sudah ditetapkan pada generic class.
 */


/* ============================================================
 * Analogi
 * ============================================================
 *
 * Tanpa wildcard:
 *
 * "Kotak Integer hanya dapat dibandingkan
 * dengan kotak Integer."
 *
 * Dengan wildcard:
 *
 * "Kotak angka dapat dibandingkan dengan
 * kotak angka lainnya."
 *
 * Selama seluruh kotak mengikuti aturan
 * T extends Number, operasi tetap aman dilakukan.
 */


/* ============================================================
 * Ringkasan
 * ============================================================
 *
 * - Wildcard ditulis menggunakan tanda ?.
 *
 * - ? berarti type argument tidak diketahui
 *   (unknown type).
 *
 * - Wildcard digunakan ketika operasi tidak
 *   bergantung pada type argument tertentu.
 *
 * - Wildcard membuat method dapat menerima
 *   berbagai parameterized type yang kompatibel.
 *
 * - Wildcard tidak mengubah batasan generic class;
 *   seluruh constraint yang telah ditentukan
 *   tetap berlaku.
 */


/* ============================================================
 * Insight
 * ============================================================
 *
 * Wildcard sangat sering digunakan pada Java Collections
 * Framework dan berbagai API Java.
 *
 * Contohnya:
 *
 * Collection<?>
 * List<?>
 * Iterable<?>
 *
 * Penggunaan wildcard memungkinkan API menjadi lebih
 * fleksibel tanpa mengorbankan type safety, sehingga
 * menjadi salah satu fitur terpenting dalam pemrograman
 * generic di Java.
 */

class Statee<T extends Number> {
    T[] nums; // Array bertipe number atau turunannya

    // konstruktor menerima array Number atau turunannya
    Statee(T[] o) {
        this.nums = o;
    }

    // Menghitung rata-rata
    double average() {
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }

    // Membandingkan apakah dua rata-rata sama
    // Menggunakan wildcard
    boolean sameAvg(Statee<?> ob) {
        if (average() == ob.average()) {
            return true;
        }
        return false;
    }
}

public class WildcardArguments {
    public static void main(String[] args) {
        
        Integer inums[] = {1,2,3,4,5};
        Statee<Integer> iob = new Statee<Integer>(inums);

        double v = iob.average();
        System.out.println("iob average is: " + v);

        Double dnums[] = {1.1, 2.2, 3.3, 4.4, 5.5};
        Statee<Double> dob = new Statee<Double>(dnums);

        double w = dob.average();
        System.out.println("dob average is: " + w);

        Float fnums[] = {1.0f, 2.0f, 3.0f, 4.0f, 5.0f};
        Statee<Float> fob = new Statee<Float>(fnums);

        double x = fob.average();
        System.out.println("fob average is: " + x);

        // MEMBANDINGKAN RATA-RATA
        System.out.print("Average of iob and dob ");
        if (iob.sameAvg(dob)) {
            System.out.println("are the same");
        } else {
            System.out.println("differ");
        }

        System.out.print("Average of iob and fob ");
        if (iob.sameAvg(fob)) {
            System.out.println("are the same");
        } else {
            System.out.println("differ");
        }

        /**
         * OUTPUT
         * iob average is 3.0
         * dob average is 3.3
         * fob average is 3.0
         * Averages of iob and dob differ.
         * Averages of iob and fob are the same.
         */

    }
}
