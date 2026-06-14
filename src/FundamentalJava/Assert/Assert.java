package FundamentalJava.Assert;

/*

Assert adalah keyword di Java yang harus dipakai saat development untuk:
memastikan suatu kondisi HARUS BENAR.

Contoh:
Misalnya:
sebuah method harus selalu return angka positif

kita bisa cek:
assert hasil > 0;

Cara kerja:
Kalau kondisi true → program lanjut biasa 
Kalau kondisi false → muncul error:
AssertionError

Biasanya dipakai untuk:
testing
debugging
validasi internal

JARANG DIPAKAI DI KODE PRODUCTION

----------------------------------------------------------

Bentuk assert 

1. Bentuk sederhana
assert condition;

contoh:
assert n > 0;

2. Dengan pesan
assert condition : message;

contoh:
assert n > 0 : "n is negative!";

Kalau gagal:
AssertionError: n is negative!

--------------------------------------------

Cara menjalankan (PENTING BANGET)

Secara default:
assert itu MATI (Disabled)

Aktifkan pakai:
java -ea AssertDemo

-ea = enable assertion

versi dengan pesan
assert n > 0 : "n is negative!"

output:
Exception in thread "main" java.lang.AssertionError: n is negative!

sebelum ada assert (cara lama)

if (n < 0) {
    System.out.println("n is negative!");
    return;
}

Dengan assert 
assert n > 0;

Lebih singkat, bersih, dan fokus.

----------------------------------------------------

Analogi Biar Nempel
assert itu kayak:
“Cek internal developer”

Misal:
lu bikin mesin
lu cek:
"gear harus muter"

Kalau gak:
alarm bunyi (AssertionError)

--------------------------------------------

Kesimpulan

assert = alat buat ngecek kondisi saat development
Kalau gagal → AssertionError

Default:
mati
harus diaktifkan manual

RULE PENTING
Jangan taruh logic penting di assert
Jangan andalkan assert di production

Gunakan assert untuk:
debugging
testing internal
validasi asumsi

Insight Level Programmer
assert bukan pengganti if atau exception

BEDANYA:
FITUR       TUJUAN
assert      cek internal dev
if          logic program
exception   handle error user

*/

/**
 * Assertion Enabling and Disabling Options
 *
 * Saat menjalankan program Java:
 * Lu bisa:
 * mematikan semua assertion
 * mengaktifkan assertion tertentu (per package / class)
 *
 * 1. Disable Semua Assertion
 * java -da ClassName
 * -da = disable assertions
 *
 * Artinya:
 * semua assert di program tidak dijalankan
 *
 * 2. Enable / Disable per Package
 * Enable package
 * java -ea:MyPack... ClassName
 *
 * Disable package
 * java -da:MyPack... ClassName
 *
 * Penjelasan:
 * MyPack...
 *
 * artinya:
 * package MyPack
 * semua subpackage di dalamnya
 *
 * Contoh struktur:
 * MyPack
 *  ├── A
 *  ├── B
 *  └── subpack
 *       └── C
 *
 * Kalau:
 * -ea:MyPack...
 * ✔ semua class di atas kena
 *
 * Enable per Class
 * Contoh:
 * java -ea:AssertDemo
 *
 * cuma class itu aja yang aktif assert-nya
 *
 * Urutan Prioritas (PENTING)
 *
 * Kalau lu campur:
 * java -ea -da:MyPack... -ea:MyPack.Test
 *
 * artinya:
 * semua aktif
 * MyPack dimatikan
 * Test dihidupkan lagi
 *
 * Java baca dari kiri ke kanan
 *
 * Contoh Nyata (Biar Kebayang)
 *
 * Misal:
 * assert x > 0;
 * Case 1:
 * java MyApp
 *
 * assert mati
 *
 * Case 2:
 * java -ea MyApp
 *
 * semua assert aktif
 *
 * Case 3:
 * java -ea:com.app.service... MyApp
 * cuma package itu yang aktif
 *
 * Case 4:
 * java -da:com.app.service... -ea:com.app.service.UserService MyApp
 *
 * hasil:
 * semua service mati
 * kecuali UserService hidup
 *
 * Insight Penting
 * Kenapa Java bikin sistem ini?
 *
 * Karena:
 * assert = alat debug, bukan logic utama
 *
 * Jadi:
 * Dev bisa aktifin saat testing
 * Production bisa matiin biar:
 * lebih cepat
 * lebih ringan
 *
 * Kesimpulan Santai
 * -ea → enable assertion
 * -da → disable assertion
 *
 * Bisa diatur:
 * seluruh program
 * per package (...)
 * per class
 *
 * Rule penting:
 *
 * assert default = OFF
 * harus diaktifkan manual
 *
 * Insight Level Atas
 * Di dunia kerja:
 * assert dipakai saat testing/debugging
 *
 * production:
 * hampir selalu dimatikan
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
