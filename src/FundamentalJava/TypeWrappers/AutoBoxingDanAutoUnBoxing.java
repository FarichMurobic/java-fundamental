package FundamentalJava.TypeWrappers;

/**
 * ------------------------------------------------------------------------
 * AUTOBOXING DAN AUTO-UNBOXING
 * ------------------------------------------------------------------------
 * 
 * Mulai dari JDK 5, Java menambahkan dua fitur penting:
 * 1. Autoboxing
 * 2. Auto-Unboxing
 * 
 * Autoboxing:
 * Proses dimana tipe primitive OTOMATIS dibungkus menjadi Object (wrapper)
 * tanpa perlu new..
 * 
 * Auto-unboxing:
 * Proses dimana object wrapper OTOMATIS diambil nilainya menjadi primitive
 * tanpa perlu .intValue(), .doubleValue(), dll.
 * 
 * ------------------------------------------------------------------------
 * PERBANDINGAN DULU VS SEKARANG
 * ------------------------------------------------------------------------
 * 
 * Zaman dulu (Java lama):
 * 
 * Integer i = new Integer(10); // Ribet!
 * int x = i.intValue(); // Ribet!
 * 
 * Sekarang (Java modern):
 * 
 * Integer i = 10; // Autoboxing
 * int x = i; // Auto-unboxing
 * 
 * Java mengerjakan semuanya di belakang layar!
 * 
 * ------------------------------------------------------------------------
 * CARA KERJA AUTOBOXING
 * ------------------------------------------------------------------------
 * 
 * Tidak perlu lagi membuat object pakai new.
 * 
 * Integer iOb = 100; // Autoboxing
 * 
 * Sebenarnya di belakang layar, Java melakukan:
 * 
 * Integer iOb = Integer.valueOf(100);
 * 
 * Jadi:
 * Integer iOb = 100;
 * 
 * SAMA DENGAN:
 * Integer iOb = Integer.valueOf(100); // versi modern
 * Integer iOb = new Integer(100); // versi lama (deprecated)
 * 
 * ------------------------------------------------------------------------
 * CARA KERJA AUTO-UNBOXING
 * ------------------------------------------------------------------------
 * 
 * Untuk mengambil nilai primitive:
 * 
 * int i = iOb; // Auto-unboxing
 * 
 * Sebenarnya di belakang layar, Java melakukan:
 * 
 * int i = iOb.intValue();
 * 
 * ------------------------------------------------------------------------
 * KENAPA AUTOBOXING PENTING?
 * ------------------------------------------------------------------------
 * 
 * 1. Mengurangi kode yang membosankan (manual boxing/unboxing)
 * 2. Mengurangi error (lupa panggil .intValue())
 * 3. Penting untuk Generics
 * 4. Mempermudah kerja dengan Collection Framework
 * 
 * Contoh penting dengan Collection:
 * 
 * ArrayList<Integer> list = new ArrayList<>();
 * list.add(10); // Autoboxing! int 10 otomatis jadi Integer
 * 
 * 10 itu int, tapi:
 * otomatis dibungkus menjadi Integer oleh Java.
 * 
 * ------------------------------------------------------------------------
 * CONTOH AUTOBOXING DI BERBAGAI SITUASI
 * ------------------------------------------------------------------------
 * 
 * 1. Assignment
 * 
 * Integer i = 42; // Autoboxing
 * int x = i; // Auto-unboxing
 * 
 * 2. Method Parameter
 * 
 * void print(Integer i) {
 * System.out.println(i);
 * }
 * 
 * print(100); // Autoboxing! int 100 jadi Integer
 * 
 * 3. Return Value
 * 
 * Integer getNumber() {
 * return 50; // Autoboxing!
 * }
 * 
 * 4. Operasi Matematika
 * 
 * Integer a = 10;
 * Integer b = 20;
 * Integer c = a + b; // Auto-unboxing (a,b) + Autoboxing (hasil)
 * 
 * // Proses:
 * // a dan b di-unbox menjadi int
 * // 10 + 20 = 30
 * // 30 di-box menjadi Integer
 * 
 * ------------------------------------------------------------------------
 * TABEL WRAPPER DAN PRIMITIVE
 * ------------------------------------------------------------------------
 * 
 * Primitive | Wrapper Class
 * --------------|------------------------------------------
 * byte | Byte
 * short | Short
 * int | Integer
 * long | Long
 * float | Float
 * double | Double
 * char | Character
 * boolean | Boolean
 * 
 * ------------------------------------------------------------------------
 * RISIKO AUTOBOXING (HARUS TAHU!)
 * ------------------------------------------------------------------------
 * 
 * 1. NullPointerException
 * 
 * Integer i = null;
 * int x = i; // NullPointerException!
 * 
 * Karena i null, tidak bisa di-unbox.
 * 
 * 2. Performa (Overhead)
 * 
 * Autoboxing menciptakan object baru.
 * Jika terjadi dalam loop besar, bisa boros memory.
 * 
 * // Buruk - boxing berulang kali
 * for (int i = 0; i < 1000000; i++) {
 * Integer x = i; // Buat object baru setiap iterasi
 * }
 * 
 * // Lebih baik - pakai primitive
 * for (int i = 0; i < 1000000; i++) {
 * int x = i; // Tidak buat object
 * }
 * 
 * 3. Perbandingan dengan == (HATI-HATI!)
 * 
 * Integer a = 100;
 * Integer b = 100;
 * System.out.println(a == b); // true (karena cache)
 * 
 * Integer c = 200;
 * Integer d = 200;
 * System.out.println(c == d); // false! (beda object)
 * 
 * Untuk perbandingan, gunakan .equals():
 * 
 * System.out.println(c.equals(d)); // true
 * 
 * ------------------------------------------------------------------------
 * RINGKASAN SUPER PADAT
 * ------------------------------------------------------------------------
 * 
 * Konsep | Arti
 * ------------------|-----------------------------------------------------
 * Autoboxing | Primitive → Object (otomatis)
 * Auto-unboxing | Object → Primitive (otomatis)
 * Keuntungan | Kode lebih clean, lebih aman
 * Risiko | NullPointerException, overhead performa
 * 
 * ------------------------------------------------------------------------
 * KESIMPULAN
 * ------------------------------------------------------------------------
 * 
 * Autoboxing adalah fitur yang:
 * - Kelihatannya kecil
 * - Tapi IMPACT-nya BESAR
 * 
 * Karena:
 * - Membuat kode lebih simpel
 * - Wajib untuk ArrayList, HashMap, dan Collection lainnya
 * - Sering muncul tanpa disadari
 * - Memudahkan kerja dengan Generics
 * 
 * ------------------------------------------------------------------------
 */

public class AutoBoxingDanAutoUnBoxing {
    public static void main(String[] args) {

        // autoboxing: int 100 → Integer object
        Integer i = 100;

        // auto-unboxing: Integer → int
        int ii = i;

        // ii = primitive
        // i = object (tapi bisa langsung di-print)
        System.out.println(i + " " + ii);

        // Contoh lagi
        Integer angka = 20; // autoboxing
        // angka di-unbox dulu → jadi int
        // lalu ditambah
        int hasil = angka + 10;
        System.out.println(hasil); // 30

        /**
         * Jebakan Pemula (WAJIB TAU)
         * 1. NullPointerException (bahaya banget)
         * Integer i = null;
         * int x = i; // ERROR
         *
         * Kenapa?
         * Java mau auto-unbox
         * tapi object-nya null
         *
         * 2. Perbandingan Salah (== vs equals)
         * Integer a = 100;
         * Integer b = 100;
         *
         * System.out.println(a == b); // kadang true, kadang false
         * Gunakan:
         * a.equals(b); // benar
         *
         * 3. Overhead Tersembunyi
         * Integer sum = 0;
         *
         * for(int i = 0; i < 1000; i++){
         * sum += i; // banyak autoboxing terjadi
         * }
         *
         * Ini bisa lebih lambat dari:
         * int sum = 0;
         */

        // contoh keren
        Integer angka1 = 10; // unbox
        Integer angka2 = 20; // unbox
        Integer angka3 = angka1 + angka2; // autoboxing lagi
        System.out.println(angka3);

        /**
         * Kenapa a + b harus di-unbox?
         *
         * Kode lu:
         * Integer a = 10;
         * Integer b = 20;
         * Integer c = a + b;
         *
         * Jawaban inti:
         * Karena operator + di Java cuma bisa dipakai untuk primitive, bukan object.
         *
         * Operator + itu kerja di primitive
         * Java itu gak pernah nambah object langsung.
         *
         * Yang bisa dijumlah:
         * int + int
         * double + double
         *
         * Yang gak bisa:
         * Integer + Integer (langsung)
         *
         * Apa yang terjadi di belakang layar?
         * Baris ini:
         * Integer c = a + b;
         *
         * Sebenarnya diubah oleh Java jadi:
         * int temp1 = a.intValue(); // unboxing
         * int temp2 = b.intValue(); // unboxing
         * int hasil = temp1 + temp2; // operasi primitive
         * Integer c = Integer.valueOf(hasil); // autoboxing lagi
         *
         * Alur lengkapnya
         * a → di-unbox → jadi int
         * b → di-unbox → jadi int
         * dijumlah → hasil int
         * hasil → di-box lagi → jadi Integer
         *
         * Kenapa Java gak langsung support object?
         * Karena:
         * Object = kompleks (punya method, reference, dll)
         * Operasi matematika = harus cepat & simpel
         *
         * Makanya Java:
         * selalu convert ke primitive dulu
         */

    }
}
