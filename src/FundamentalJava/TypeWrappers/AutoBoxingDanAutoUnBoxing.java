package FundamentalJava.TypeWrappers;

    /**
     * Mulai dari JDK 5, Java menambahkan:
     * Autoboxing
     * Auto-Unboxing
     *
     * Autoboxing - proses dimana primitive otomatis dibungkus jadi Object (wrapper)
     * tanpa perlu new
     * Auto-unboxing - proses dimana object wrapper otomatis diambil nilainya jadi primitive
     * tanpa perlu .intValue(), .doubleValue(), dll.
     *
     * Dulu java lama:
     * Integer i = new Integer(10);     // ribet
     * int x = i.intValue();            // ribet
     *
     * Sekarang java modern:
     * Integer i = 10;                  // autoboxing
     * int x = i;                       // auto unboxing
     *
     * Java ngerjain semuanya dibelakang layar!
     *
     * Kenapa autoboxing penting?
     * -mengurangi kode yang membosankan (manual boxing/unboxing)
     * -mengurangi erro
     * -penting untuk generics
     * -mempermudah kerja dengan collection framework
     *
     * Contoh penting:
     * ArrayList<Integer> list = new ArrayList<>();
     * list.add(10); // autoboxing
     *
     * 10 itu int, tapi:
     * otomatis jadi Integer
     *
     * Cara Kerja Autoboxing
     * Tidak perlu lagi bikin object pakai new
     * Integer iOb = 100; // autoboxing
     * Java otomatis bikin:
     * Integer iOb = Integer.valueOf(100); // sebenarnya di belakang layar
     *
     * Intinya
     * Integer iOb = 100;
     *
     * sama dengan:
     * Integer iOb = new Integer(100); // versi lama
     *
     * Cara Kerja Auto-Unboxing
     * Untuk mengambil nilai:
     * int i = iOb; // auto-unboxing
     *
     * Java otomatis:
     * int i = iOb.intValue();
     *
     * Insight Penting (LEVEL UP)
     *
     * Autoboxing terjadi di:
     * Assignment
     * Method parameter
     * Return value
     * Operasi matematika
     *
     * Ringkasan Super Padat
     * Konsep	            Arti
     * Autoboxing	        primitive → object otomatis
     * Auto-unboxing	    object → primitive otomatis
     * Keuntungan	        kode lebih clean
     * Risiko	            null error & performa
     *
     * Kesimpulan
     *
     * Autoboxing itu:
     * fitur kecil
     * tapi impact-nya BESAR
     *
     * Karena:
     * bikin kode lebih simpel
     * wajib buat ArrayList, HashMap, dll
     * sering muncul tanpa sadar
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
         *     sum += i; // banyak autoboxing terjadi
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
