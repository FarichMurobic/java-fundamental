package FundamentalJava.Lambda;

/**
 * Contoh Lambda dengan Parameter
 *
 * Contoh ini nunjukin lambda yang punya parameter.
 *
 * Interface baru:
 * interface NumericTest {
 *     boolean test(int n);
 * }
 *
 * Artinya:
 * method test(int n)
 * return boolean
 *
 * Lambda pertama: cek genap
 * (n) -> (n % 2) == 0
 *
 * Artinya:
 * kalau n genap → true
 * kalau ganjil → false
 *
 * Lambda kedua: cek non-negatif
 * (n) -> n >= 0
 *
 * Artinya:
 * kalau n ≥ 0 → true
 * kalau < 0 → false
 *
 * ------------------------------------------
 * 
 * Penjelasan Mendalam
 * 
 * 1. Perhatikan ini:
 * NumericTest isEven = (n) -> (n % 2) == 0;
 *
 * Artinya:
 * NumericTest = target type
 * test(int n) = method target
 * lambda = isi method itu
 *
 * 2. Type inference (ini penting banget)
 * (n) -> (n % 2) == 0
 *
 * Kenapa gak ada int n?
 *
 * Karena Java nebak otomatis dari:
 * boolean test(int n);
 *
 * Jadi:
 * n = int
 * return = boolean
 *
 * Versi eksplisit:
 * (int n) -> (n % 2) == 0
 *
 * Ini juga valid
 *
 * 3. Lambda bisa beda behavior
 * NumericTest isEven
 * NumericTest isNonNeg
 *
 * Dua lambda beda:
 * satu cek genap
 * satu cek positif
 *
 * Tapi:
 * Keduanya tetap bisa dipakai karena:
 * sama-sama cocok dengan test(int n)
 *
 * Insight penting:
 * 1 interface → bisa dipakai banyak lambda berbeda
 *
 * 4. Cara eksekusi
 * isEven.test(10)
 *
 * Yang jalan:
 * lambda (n) -> (n % 2) == 0
 *
 * 5. Parentheses opsional
 * (n) -> ...
 *
 * bisa jadi:
 * n -> ...
 *
 * Tapi:
 * kalau lebih dari 1 parameter → WAJIB pakai ()
 *
 * Insight Mentor (Ini bikin lo naik level)
 * 1. Lambda = behavior
 * isEven
 * isNonNeg
 *
 * bukan data
 * tapi aksi/logika
 *
 * 2. Functional interface reusable
 * Satu interface:
 * boolean test(int n);
 *
 * bisa:
 * cek genap
 * cek negatif
 * cek > 100
 * dll
 *
 * 3. Ini konsep powerful banget:
 * "Passing logic sebagai variable"
 *
 * 4. Ini bakal kepake di:
 * filter data
 * validasi input
 * stream API
 *
 * ---------------------------------
 * 
 * Kesimpulan Super Sederhana
 * 
 * 1. Lambda bisa punya parameter
 *    (n) -> n >= 0
 * 2. Tipe bisa di-skip (auto infer)
 *    (n) -> ...
 * 3. Bisa banyak lambda untuk 1 interface
 *    isEven
 *    isNonNeg
 * 4. Bisa dipanggil lewat method
 *    isEven.test(10)
 * 5. Kurung opsional (1 parameter)
 *    n -> n % 2 == 0
 */

/**
 * Lambda dengan Dua Parameter
 *
 * Contoh ini nunjukin lambda yang punya 2 parameter.
 *
 * Interface:
 * interface NumericTest2 {
 *   boolean test(int n, int d);
 * }
 *
 * Artinya:
 * method test punya 2 input
 * n
 * d
 * return boolean
 *
 * Lambda:
 * (n, d) -> (n % d) == 0
 *
 * Artinya:
 * cek apakah n habis dibagi d
 * kalau iya → true
 * kalau tidak → false
 *
 * Penjelasan Mendalam
 * 1. Perhatikan method di interface
 * boolean test(int n, int d);
 *
 * Ini penting banget:
 * ada 2 parameter
 * maka lambda juga harus punya 2 parameter
 *
 * 2. Bentuk lambda
 * (n, d) -> (n % d) == 0
 *
 * Penjelasan:
 * n = angka utama
 * d = pembagi
 * % = sisa bagi
 *
 * Logika:
 * Kalau:
 * 10 % 2 == 0 
 * 10 % 3 != 0 
 *
 * 3. Cara kerja eksekusi
 * isFactor.test(10, 2);
 *
 * Yang terjadi:
 * n = 10
 * d = 2
 * lambda jalan → hasil true
 *
 * 4. Aturan multiple parameter
 * Kalau lebih dari 1 parameter:
 * (n, d) -> ...
 *
 * WAJIB:
 * pakai tanda kurung ()
 * dipisah koma
 *
 * 5. Aturan tipe data (INI PENTING BANGET)
 * Benar:
 * (int n, int d) -> (n % d) == 0
 * Salah:
 * (int n, d) -> (n % d) == 0
 *
 * Kenapa salah?
 * Karena:
 * kalau 1 parameter dikasih tipe
 * semua parameter harus dikasih tipe
 *
 * Rule penting:
 * "Kalau mau eksplisit, harus semuanya eksplisit"
 *
 * ==========================================
 * 
 * Insight Mentor (Level Up)
 * 
 * 1. Lambda sekarang udah kayak function real
 * (n, d) -> ...
 *
 * Ini udah:
 * punya input
 * punya output
 * punya logic
 *
 * 2. Bisa bikin logic reusable
 * NumericTest2 isFactor
 *
 * bisa dipakai di mana aja:
 * validasi
 * filter
 * kalkulasi
 *
 * 3. Ini fondasi ke:
 * BiPredicate (Java built-in)
 * Stream API (filter dengan 2 kondisi)
 * Functional programming style
 *
 * 4. Ini konsep penting:
 * “Passing multiple inputs ke behavior”
 *
 * Kesimpulan Super Sederhana
 * Inti:
 * 1. Lambda bisa punya banyak parameter
 *    (n, d) -> ...
 *
 * 2. Harus sesuai dengan method interface
 *    boolean test(int n, int d);
 *
 * 3. Kalau eksplisit → semua harus diketik
 *    (int n, int d) -> ...
 *    Tidak boleh campur
 *    (int n, d) -> ... // ERROR
 *
 * 4. Wajib pakai kurung kalau >1 parameter
 */

interface Something {
    boolean test(int n); // with parameter
}

interface NumericTest {

    // methode menerima 2 parameter
    // mengembalikan boolean
    boolean test(int n, int d);
}

public class LambdaWithParameters {
    public static void main(String[] args) {

        // Lambda 1 cek bilangan genap

        // Lambda ini akan menjadi implementasi method test(int n)
        // nama (n) disini bisa bebas, tidak harus sama dengan nama parameter method
        Something genap = (n) -> (n % 2) == 0;

        System.out.println(genap.test(4)); // true
        System.out.println(genap.test(3)); // false

        // memanggil lambda melalui method test(int n)
        if (genap.test(10))
            System.out.println("10 is even."); // true
        if (genap.test(9))
            System.out.println("9 is not even."); // false

        System.out.println();

        // Lambda 2 cek bilangan negatif
        Something nonNegatif = (n) -> n >= 0;

        System.out.println(nonNegatif.test(5));
        System.out.println(nonNegatif.test(-200));

        // memanggil lambda melalui methode test(int n)
        if (nonNegatif.test(1))
            System.out.println("1 is non negatif"); // true
        if (nonNegatif.test(-1))
            System.out.println("-1 is negatif"); // false

        System.out.println();
        
        // Mehtode dengan 2 parameters

        // Lambda cek faktor
        // lambda ini mengecek apakah dia adalah faktor dari n
        NumericTest isFactor = (n, d) -> (n % d) == 0;

        System.out.println(isFactor.test(10,1)); // true
        System.out.println(isFactor.test(10,2)); // true
        System.out.println(isFactor.test(10,3)); // false

        // cek apakah 2 adalah faktor dari 10
        if (isFactor.test(10,2))
            System.out.println("2 is a factor of 10"); // true

        // cek apakah 3 adalah factor dari 10
        if (isFactor.test(10, 3))
            System.out.println("3 is a factor of 10"); // false

        if (!isFactor.test(10,3))
            System.out.println("3 is a not factor of 10");

    }
}
