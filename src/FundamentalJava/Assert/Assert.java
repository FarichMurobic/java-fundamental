package FundamentalJava.Assert;

/**
 * ---------------------------------------------------------------------------
 * ASSERT (JAVA ASSERTION)
 * ---------------------------------------------------------------------------
 *
 * Assert adalah keyword di Java yang digunakan untuk memverifikasi
 * bahwa suatu kondisi yang dianggap benar oleh programmer memang
 * benar saat program dijalankan..
 *
 * Assert umumnya digunakan selama proses:
 *
 * - Development.
 * - Testing.
 * - Debugging.
 * - Validasi asumsi internal program.
 *
 * Jika kondisi yang diperiksa bernilai:
 *
 * - true -> Program berjalan normal.
 * - false -> JVM melempar AssertionError.
 *
 * Flow:
 * Assert Dijalankan
 * -> Kondisi Diperiksa
 * -> true -> Program Lanjut
 * -> false -> AssertionError
 *
 * ---------------------------------------------------------------------------
 * TUJUAN ASSERT
 * ---------------------------------------------------------------------------
 *
 * Assert digunakan untuk memeriksa asumsi yang seharusnya selalu
 * benar menurut logika program.
 *
 * Contoh:
 *
 * Sebuah method seharusnya selalu menghasilkan angka positif.
 *
 * assert result > 0;
 *
 * Jika ternyata result bernilai negatif, berarti terdapat bug
 * atau kondisi yang tidak sesuai dengan asumsi programmer.
 *
 * ---------------------------------------------------------------------------
 * BENTUK ASSERT
 * ---------------------------------------------------------------------------
 *
 * Java menyediakan dua bentuk assert.
 *
 * ---------------------------------------------------------------------------
 * 1. ASSERT SEDERHANA
 * ---------------------------------------------------------------------------
 *
 * Sintaks:
 *
 * assert condition;
 *
 * Contoh:
 *
 * assert n > 0;
 *
 * Jika kondisi bernilai false:
 *
 * Exception in thread "main"
 * java.lang.AssertionError
 *
 * ---------------------------------------------------------------------------
 * 2. ASSERT DENGAN PESAN
 * ---------------------------------------------------------------------------
 *
 * Sintaks:
 *
 * assert condition : message;
 *
 * Contoh:
 *
 * assert n > 0 : "n is negative!";
 *
 * Jika kondisi bernilai false:
 *
 * Exception in thread "main"
 * java.lang.AssertionError: n is negative!
 *
 * Bentuk ini lebih disukai karena memberikan informasi tambahan
 * saat assertion gagal.
 *
 * ---------------------------------------------------------------------------
 * ASSERT TIDAK AKTIF SECARA DEFAULT
 * ---------------------------------------------------------------------------
 *
 * Hal yang sangat penting untuk dipahami:
 *
 * Assertion di Java secara default dalam keadaan NONAKTIF
 * (disabled).
 *
 * Artinya:
 *
 * Seluruh pernyataan assert akan diabaikan oleh JVM kecuali
 * diaktifkan secara eksplisit.
 *
 * Contoh:
 *
 * java MyApp
 *
 * Hasil:
 *
 * Semua assert diabaikan.
 *
 * ---------------------------------------------------------------------------
 * MENGAKTIFKAN ASSERTION
 * ---------------------------------------------------------------------------
 *
 * Untuk mengaktifkan assertion:
 *
 * java -ea MyApp
 *
 * atau:
 *
 * java -enableassertions MyApp
 *
 * Keterangan:
 *
 * -ea = Enable Assertions
 *
 * Hasil:
 *
 * Seluruh assert dalam program akan dijalankan.
 *
 * ---------------------------------------------------------------------------
 * SEBELUM ADA ASSERT
 * ---------------------------------------------------------------------------
 *
 * Sebelum menggunakan assert, programmer sering menulis:
 *
 * if (n < 0) {
 * System.out.println("n is negative!");
 * return;
 * }
 *
 * Dengan assert:
 *
 * assert n > 0;
 *
 * Kode menjadi:
 *
 * - Lebih singkat.
 * - Lebih jelas.
 * - Fokus pada asumsi yang ingin diverifikasi.
 *
 * ---------------------------------------------------------------------------
 * ASSERT BUKAN PENGGANTI IF
 * ---------------------------------------------------------------------------
 *
 * Salah satu kesalahan yang sering dilakukan pemula adalah
 * menggunakan assert sebagai pengganti logika program.
 *
 * Ini tidak disarankan.
 *
 * Assert digunakan untuk:
 *
 * - Memeriksa asumsi internal developer.
 * - Menemukan bug.
 * - Validasi saat development.
 *
 * Bukan untuk:
 *
 * - Validasi input user.
 * - Business logic.
 * - Penanganan error aplikasi.
 *
 * ---------------------------------------------------------------------------
 * PERBEDAAN ASSERT, IF, DAN EXCEPTION
 * ---------------------------------------------------------------------------
 *
 * Assert:
 * -> Memeriksa asumsi internal programmer.
 *
 * If:
 * -> Menjalankan logika program berdasarkan kondisi tertentu.
 *
 * Exception:
 * -> Menangani kondisi error yang dapat terjadi saat runtime.
 *
 * Flow:
 *
 * Assert
 * -> Cek Asumsi Internal
 *
 * If
 * -> Cek Logika Program
 *
 * Exception
 * -> Tangani Error Runtime
 *
 * ---------------------------------------------------------------------------
 * ANALOGI SEDERHANA
 * ---------------------------------------------------------------------------
 *
 * Bayangkan programmer membuat sebuah mesin.
 *
 * Programmer yakin bahwa:
 *
 * "Gear utama harus selalu berputar."
 *
 * Maka programmer menambahkan:
 *
 * assert gearIsMoving;
 *
 * Jika gear berhenti:
 *
 * -> Alarm berbunyi (AssertionError)
 * -> Menunjukkan ada masalah pada desain atau implementasi
 *
 * ---------------------------------------------------------------------------
 * ENABLE DAN DISABLE ASSERTION
 * ---------------------------------------------------------------------------
 *
 * Java memberikan kontrol penuh terhadap assertion saat program
 * dijalankan.
 *
 * Assertion dapat:
 *
 * - Diaktifkan untuk seluruh program.
 * - Dimatikan untuk seluruh program.
 * - Diaktifkan per package.
 * - Dimatikan per package.
 * - Diaktifkan per class.
 *
 * ---------------------------------------------------------------------------
 * DISABLE SEMUA ASSERTION
 * ---------------------------------------------------------------------------
 *
 * Sintaks:
 *
 * java -da ClassName
 *
 * atau:
 *
 * java -disableassertions ClassName
 *
 * Keterangan:
 *
 * -da = Disable Assertions
 *
 * Hasil:
 *
 * Semua assert tidak dijalankan.
 *
 * ---------------------------------------------------------------------------
 * ENABLE ASSERTION PER PACKAGE
 * ---------------------------------------------------------------------------
 *
 * Sintaks:
 *
 * java -ea:com.app.service... MyApp
 *
 * Hasil:
 *
 * Assertion aktif hanya untuk:
 *
 * com.app.service
 * dan seluruh subpackage di bawahnya.
 *
 * Flow:
 *
 * com.app.service
 * -> user
 * -> product
 * -> security
 * -> dll
 *
 * Semuanya ikut aktif.
 *
 * ---------------------------------------------------------------------------
 * DISABLE ASSERTION PER PACKAGE
 * ---------------------------------------------------------------------------
 *
 * Sintaks:
 *
 * java -da:com.app.service... MyApp
 *
 * Hasil:
 *
 * Semua class dalam package tersebut tidak menjalankan assert.
 *
 * ---------------------------------------------------------------------------
 * ENABLE ASSERTION PER CLASS
 * ---------------------------------------------------------------------------
 *
 * Sintaks:
 *
 * java -ea:AssertDemo
 *
 * Hasil:
 *
 * Hanya class AssertDemo yang menjalankan assertion.
 *
 * ---------------------------------------------------------------------------
 * URUTAN PRIORITAS
 * ---------------------------------------------------------------------------
 *
 * JVM membaca opsi assertion dari kiri ke kanan.
 *
 * Contoh:
 *
 * java -ea -da:MyPack... -ea:MyPack.Test
 *
 * Artinya:
 *
 * - Seluruh assertion diaktifkan.
 * - Package MyPack dimatikan.
 * - Class MyPack.Test diaktifkan kembali.
 *
 * Hasil akhir:
 *
 * MyPack.Test -> Aktif
 * Class lain di MyPack -> Nonaktif
 *
 * ---------------------------------------------------------------------------
 * CONTOH SKENARIO
 * ---------------------------------------------------------------------------
 *
 * Misal:
 *
 * assert x > 0;
 *
 * Case 1:
 *
 * java MyApp
 *
 * Hasil:
 *
 * Assert tidak dijalankan.
 *
 * ---------------------------------------------------------------------------
 *
 * Case 2:
 *
 * java -ea MyApp
 *
 * Hasil:
 *
 * Seluruh assert dijalankan.
 *
 * ---------------------------------------------------------------------------
 *
 * Case 3:
 *
 * java -ea:com.app.service... MyApp
 *
 * Hasil:
 *
 * Hanya package tersebut yang menjalankan assertion.
 *
 * ---------------------------------------------------------------------------
 *
 * Case 4:
 *
 * java -da:com.app.service...
 * -ea:com.app.service.UserService
 * MyApp
 *
 * Hasil:
 *
 * - Seluruh service nonaktif.
 * - UserService aktif kembali.
 *
 * ---------------------------------------------------------------------------
 * INSIGHT JAVA MODERN
 * ---------------------------------------------------------------------------
 *
 * Dalam pengembangan aplikasi modern, assertion relatif jarang
 * digunakan dibandingkan:
 *
 * - Unit Test (JUnit).
 * - Validation Framework.
 * - Exception Handling.
 *
 * Namun assertion tetap berguna untuk:
 *
 * - Debugging.
 * - Memastikan invariant object.
 * - Memverifikasi asumsi internal program.
 *
 * Framework seperti Spring Boot umumnya lebih mengandalkan:
 *
 * - IllegalArgumentException
 * - IllegalStateException
 * - Bean Validation
 *
 * daripada assert untuk validasi aplikasi.
 *
 * ---------------------------------------------------------------------------
 * KESIMPULAN
 * ---------------------------------------------------------------------------
 *
 * Assert adalah mekanisme debugging yang digunakan untuk
 * memverifikasi bahwa suatu kondisi yang dianggap benar oleh
 * programmer memang benar saat runtime.
 *
 * Jika kondisi gagal:
 *
 * -> JVM melempar AssertionError.
 *
 * Hal yang wajib diingat:
 *
 * - Assert default-nya OFF.
 * - Harus diaktifkan menggunakan -ea.
 * - Tidak boleh digunakan untuk business logic.
 * - Tidak boleh digunakan untuk validasi input user.
 * - Bukan pengganti if atau exception.
 *
 * Gunakan assert untuk:
 *
 * - Debugging.
 * - Testing internal.
 * - Memverifikasi asumsi program.
 * - Menemukan bug lebih cepat saat development.
 */

public class Assert {

    static int val = 3;

    static int getNum() {
        return val--;
    }

    public static void main(String[] args) {

        int n;

        for (int i = 0; i < 10; i++) {
            n = getNum();
            assert n > 0 : "n is negative"; // akan gagal saat n = 0
            System.out.println("n is: " + n);
        }

        System.out.println();

        // CEK STATUS ASSERT
        boolean statusAssert = false;
        assert statusAssert = true;
        System.out.println("Assert aktif? " + statusAssert);
    }
}
