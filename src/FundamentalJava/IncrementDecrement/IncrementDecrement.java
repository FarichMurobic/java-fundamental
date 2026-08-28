package FundamentalJava.IncrementDecrement;

/* ============================================================
 *               INCREMENT (++) DAN DECREMENT (--)
 * ============================================================
 *
 * Operator increment (++) dan decrement (--) digunakan
 * untuk menambah atau mengurangi nilai suatu variabel
 * sebanyak satu.
 *
 * Increment (++)  → menambah nilai variabel sebesar 1.
 * Decrement (--)  → mengurangi nilai variabel sebesar 1.
 *
 * Kedua operator ini hanya dapat digunakan pada variabel
 * yang nilainya dapat diubah (mutable variable), seperti
 * tipe data numerik dan char..
 */

/* ------------------------------------------------------------
 * Bentuk Penulisan
 * ------------------------------------------------------------
 *
 * Operator increment dan decrement memiliki dua bentuk:
 *
 * Postfix
 * x++
 * x--
 *
 * Operator ditulis setelah variabel.
 *
 * Prefix
 * ++x
 * --x
 *
 * Operator ditulis sebelum variabel.
 */

/* ------------------------------------------------------------
 * Penggunaan sebagai Statement
 * ------------------------------------------------------------
 *
 * Jika operator digunakan sebagai statement tersendiri,
 * tidak ada perbedaan hasil akhir antara prefix dan postfix.
 *
 * Contoh:
 *
 * x++;
 *
 * ++x;
 *
 * Keduanya sama-sama menambah nilai x sebesar satu.
 *
 * Hal yang sama juga berlaku untuk operator decrement:
 *
 * x--;
 *
 * --x;
 *
 * Keduanya sama-sama mengurangi nilai x sebesar satu.
 */

/* ------------------------------------------------------------
 * Penggunaan di Dalam Ekspresi
 * ------------------------------------------------------------
 *
 * Perbedaan antara prefix dan postfix muncul ketika
 * operator digunakan sebagai bagian dari suatu ekspresi.
 *
 * Prefix (++x atau --x)
 *
 * Variabel diubah terlebih dahulu,
 * kemudian nilai barunya digunakan dalam ekspresi.
 *
 * Postfix (x++ atau x--)
 *
 * Nilai lama digunakan terlebih dahulu dalam ekspresi,
 * kemudian variabel diperbarui setelah ekspresi selesai
 * dievaluasi.
 */

/* ------------------------------------------------------------
 * Ringkasan
 * ------------------------------------------------------------
 *
 * Prefix:
 *
 * 1. Ubah nilai variabel.
 * 2. Gunakan nilai yang baru.
 *
 * Postfix:
 *
 * 1. Gunakan nilai saat ini.
 * 2. Ubah nilai variabel setelahnya.
 */

/* ------------------------------------------------------------
 * Insight
 * ------------------------------------------------------------
 *
 * Prefix dan postfix menghasilkan nilai akhir variabel
 * yang sama apabila masing-masing dieksekusi satu kali.
 *
 * Perbedaannya hanya terletak pada urutan evaluasi ketika
 * operator tersebut menjadi bagian dari suatu ekspresi.
 *
 * Memahami urutan evaluasi ini sangat penting untuk
 * menghindari kesalahan logika serta membuat kode lebih
 * mudah dipahami dan dipelihara.
 */

public class IncrementDecrement {
    public static void main(String[] args) {

        int prefix = 5;
        int hasilPrefix = ++prefix;
        System.out.println(prefix); // 6 variabel diubah dahulu, baru digunakan di ekspresi hasil
        System.out.println(hasilPrefix); // 6

        int postfix = 5;
        int hasilPosfix = postfix++;
        System.out.println(postfix); // 6
        System.out.println(hasilPosfix); // 5 nilai lama digunakan dahulu, baru variabel diubah

        int x = 10;
        int y = ++x;
        System.out.println(y);
        System.out.println(x);

        x = 10;
        y = x++;
        System.out.println(y);
        System.out.println(x);

        // Demo application

        int i, j, k;
        j = 65;
        k = 10;

        // pre increment : ++j (j dinaikkan dulu baru digunakan)
        ++j;
        i = j * k;
        System.out.println("Pre-increment (++j): i = " + i + ", j = " + j); // // i = 66 * 10 = 660

        // reset nilai
        j = 65;
        k = 10;

        // Post-increment: j++ (j digunakan dulu, baru dinaikkan)
        i = j * k;
        j++;
        System.out.println("Post-increment (j++): i = " + i + ", j = " + j); // i = 65 * 10 = 650

        // reset nilai
        j = 65;
        k = 10;

        // Pre-decrement: --j (j diturunkan dulu, lalu digunakan)
        --j;
        i = j * k;
        System.out.println("Pre-decrement (--j): i = " + i + ", j = " + j); // i = 64 * 10 = 640

        // Reset nilai
        j = 65;
        k = 10;

        // Post-decrement: j-- (j digunakan dulu, baru diturunkan)
        i = j * k;
        j--;
        System.out.println("Post-decrement (j--): i = " + i + ", j = " + j); // i = 65 * 10 = 650

        // Penjelasan output
        // Pre-increment (++j): i = 660, j = 66
        // Post-increment (j++): i = 650, j = 66
        // Pre-decrement (--j): i = 640, j = 64
        // Post-decrement (j--): i = 650, j = 64

        int coba = 5;
        int cobacoba = coba++ + ++coba;
        System.out.println(cobacoba);

    }

}
