package Lambda;

/**
 * Lambda Expressions
 *
 * Selama perkembangan Java dari versi awal 1.0, banyak fitur baru ditambahkan.
 * Tapi ada dua yang benar-benar mengubah cara kita nulis kode Java secara fundamental:
 * Generics (ditambahkan di JDK 5)
 * Lambda Expressions (topik di bab ini, ditambahkan di JDK 8)
 *
 * Kenapa Lambda Expression penting?
 *
 * Lambda expressions meningkatkan Java karena 2 alasan utama:
 *
 * 1. Syntax baru (lebih ringkas & kuat)
 * Nambah cara penulisan baru
 * Bikin kode jadi lebih singkat
 * Mempermudah implementasi pola coding yang sering dipakai
 *
 * 2. Nambah kemampuan baru di API Java
 * Beberapa kemampuan baru:
 * Mendukung parallel processing (multi-core CPU)
 * Mempermudah operasi model for-each
 * Memperkenalkan Stream API (olah data seperti pipeline)
 *
 * ------------------------------------------------------------------
 * 
 * Efek domino dari Lambda:
 *
 * Lambda juga memicu fitur lain:
 * default method → method default di interface
 * method reference → refer ke method tanpa langsung ngejalanin
 *
 * Tren global
 *
 * Lambda bukan cuma di Java:
 * Ada juga di C#
 * Ada di C++
 *
 * Artinya: ini konsep penting di dunia programming modern
 *
 * Kesimpulan dari buku:
 * Seperti generics dulu mengubah Java, sekarang lambda juga melakukan hal yang sama.
 *
 * Semua programmer Java bakal kena impact-nya.
 */

/**
 * Ada 2 konsep utama:
 * 
 * 1. Lambda Expression
 * 2. Functional Interface
 *
 * A. Apa itu Lambda Expression?
 * Lambda expression = method tanpa nama (anonymous method)
 *
 * Tapi hati-hati bro…
 * Dia bukan method biasa
 * Dia gak berdiri sendiri
 *
 * Dia dipakai untuk mengisi method dari interface
 * 
 * Analogi:
 * Bayangin lo punya interface:
 *
 * interface Aksi {
 *     void lakukan();
 * }
 *
 * Biasanya:
 *
 * Aksi a = new Aksi() {
 *     public void lakukan() {
 *         System.out.println("Halo");
 *     }
 * };
 *
 * Dengan lambda:
 * Aksi a = () -> System.out.println("Halo");
 *
 * Lebih singkat banget kan?
 *
 * Intinya:
 *
 * Lambda itu:
 * Fungsi tanpa nama
 * Dipakai buat isi method
 * Biasanya buat ganti anonymous class
 *
 * ------------------------------------
 * 
 * Istilah lain:
 * Lambda juga disebut:
 * Closure
 *
 * B. Apa itu Functional Interface?
 * Interface yang cuma punya 1 method abstract
 *
 * Contoh:
 * interface Runnable {
 *     void run();
 * }
 *
 * Kenapa ini functional interface?
 * Karena cuma punya 1 method abstract
 *
 * Penting:
 * Functional interface:
 * Harus hanya 1 abstract method
 * Boleh punya method lain (default/static)
 *
 * Peran penting:
 * Functional interface = target type dari lambda
 *
 * Artinya:
 * Lambda gak bisa berdiri sendiri
 * Dia butuh "wadah" (interface ini)
 *
 * Contoh hubungan:
 * Runnable r = () -> System.out.println("Jalan");
 * Runnable → functional interface
 * run() → method target
 * lambda → isi dari method itu
 *
 * --------------------------------------------------------------------------
 * 
 * Aturan penting banget:
 * Lambda hanya bisa dipakai kalau ada target type (functional interface)
 *
 * Istilah tambahan:
 * Functional interface juga disebut:
 * SAM (Single Abstract Method)
 *
 * NOTE penting dari buku:
 * Functional interface boleh punya method dari Object seperti:
 * equals()
 * toString()
 *
 * Itu gak dihitung sebagai abstract method tambahan
 *
 * Kenapa?
 * Karena:
 * Itu otomatis ada dari class Object
 * Semua object Java punya itu
 *
 * Insight Penting (Gaya Mentor)
 * Bro, ini bagian penting banget, dengerin:
 *
 * Lambda itu bukan sekadar syntax baru
 * Ini perubahan mindset coding
 *
 * Dulu:
 * Banyak boilerplate
 * Banyak class kecil
 *
 * Sekarang:
 * Lebih fokus ke logic
 * Lebih mirip functional programming
 *
 * -----------------------------------------
 * 
 * Kesimpulan Super Sederhana
 * Inti yang harus lo inget:
 *
 * 1. Lambda Expression
 * Method tanpa nama
 * Dipakai buat isi method interface
 * Lebih singkat dari anonymous class
 *
 * 2. Functional Interface
 * Interface dengan 1 method abstract
 * Jadi "target" dari lambda
 *
 * 3. Hubungan mereka
 * Lambda BUTUH functional interface
 * Gak bisa berdiri sendiri
 *
 * 4. Kenapa penting?
 * Bikin kode lebih singkat
 * Support parallel processing
 * Dasar Stream API
 * Dipakai di banyak fitur modern Java
 */

/**
 * LAMBDA EXPRESSION FUNDAMENTAL
 * 
 * Dasar-Dasar Lambda Expression
 * Lambda expression memperkenalkan:
 * syntax baru
 * dan operator baru di Java
 *
 * Operator baru: -> (arrow operator)
 *
 * Operator ini disebut:
 * lambda operator
 * atau arrow operator
 *
 * Fungsinya:
 * Membagi lambda jadi 2 bagian:
 *
 * Kiri (sebelah kiri ->)
 * Berisi parameter
 * Kalau gak ada → pakai ()
 *
 * Kanan (sebelah kanan ->)
 * Berisi isi logic (body)
 * Apa yang dilakukan lambda
 *
 * Cara bacanya:
 * -> bisa dibaca:
 * "menjadi"
 * "menuju ke"
 *
 * 2 Jenis Body Lambda
 * Java punya 2 jenis lambda body:
 * Single expression (1 baris)
 * Block code {} (banyak baris)
 *
 * Contoh 1: Lambda paling sederhana
 * () -> 123.45
 *
 * Penjelasan:
 * () → tidak ada parameter
 * 123.45 → nilai yang dikembalikan
 *
 * Artinya:
 * Lambda ini cuma ngasih nilai 123.45
 *
 * Versi method biasa:
 * // Method biasa yang setara dengan lambda di atas
 * double myMeth() {
 *     return 123.45; // Mengembalikan nilai konstan
 * }
 *
 * ---------------------------------------------------------
 * 
 * Insight:
 * Lambda = method tanpa nama
 * Tapi tetap punya return value
 *
 * Contoh 2: Pakai operasi
 * () -> Math.random() * 100
 *
 * Penjelasan:
 * Math.random() → angka random 0.0 - 1.0
 * dikali 100 → jadi 0 - 100
 *
 * Artinya:
 * Lambda ini:
 * generate angka random
 * langsung return hasilnya
 *
 * Insight:
 * Lambda bisa langsung isi logic tanpa {} kalau cuma 1 baris
 *
 * Contoh 3: Lambda dengan parameter
 * (n) -> (n % 2) == 0
 *
 * Penjelasan:
 * n = parameter input
 * (n % 2) == 0 = cek genap
 *
 * Artinya:
 * Lambda ini:
 * return true kalau n genap
 * return false kalau n ganjil
 *
 * Versi method biasa:
 * // Method biasa untuk cek bilangan genap
 * boolean isEven(int n) {
 *     return (n % 2) == 0; // true jika n habis dibagi 2
 * }
 *
 * Tentang tipe parameter
 * Bisa ditulis:
 * (int n) -> (n % 2) == 0
 *
 * Tapi biasanya gak perlu.
 * Kenapa?
 * Karena Java bisa infer (nebak otomatis) tipe datanya.
 *
 * Banyak parameter
 * Lambda bisa punya banyak parameter juga:
 * Contoh:
 * (a, b) -> a + b
 *
 * Ini yang harus lo nangkep:
 * 1. Lambda itu super ringkas
 *
 * Dari:
 * boolean isEven(int n) {
 *     return n % 2 == 0;
 * }
 *
 * Jadi:
 * (n) -> n % 2 == 0
 *
 * 2. Kalau cuma 1 ekspresi:
 * gak perlu {}
 * gak perlu return
 *
 * otomatis return
 *
 * 3. Lambda = function mini
 * Lo bisa anggap:
 * Lambda itu function kecil yang bisa langsung dipassing
 *
 * 4. Ini bakal kepake di:
 * Stream API
 * forEach
 * filter
 * map
 *
 * Jadi ini fondasi ke depan
 *
 * -----------------------------------------
 * 
 * Kesimpulan Super Sederhana
 * 
 * 1. Operator lambda
 * ->
 * Kiri = parameter
 * Kanan = logic
 *
 * 2. Bentuk dasar
 * (parameter) -> expression
 *
 * 3. Contoh penting
 * Tanpa parameter:
 * () -> 123
 * Dengan parameter:
 * (n) -> n % 2 == 0
 *
 * 4. Aturan penting
 * 1 baris → auto return
 * Tipe parameter bisa di-skip
 * Bisa punya banyak parameter
 */

/**
 * FUNCTIONAL INTERFACE
 * 
 * Functional Interfaces
 *
 * Seperti yang sudah dijelaskan:
 * Functional interface = interface yang hanya punya 1 method abstract
 *
 * Perubahan sejak JDK 8
 * Dulu (sebelum JDK 8):
 * Semua method di interface = abstract
 *
 * Sekarang (JDK 8 ke atas):
 * Interface bisa punya:
 * default method (punya isi)
 * method biasa (abstract)
 *
 * Artinya:
 * Method di interface dianggap abstract hanya jika TIDAK punya body
 *
 * Catatan:
 * Gak wajib tulis abstract
 * Karena sudah otomatis dianggap abstract
 *
 * Contoh Functional Interface
 * interface MyNumber {
 *   double getValue();
 * }
 *
 * Penjelasan:
 * getValue() = abstract
 * cuma ada 1 method
 *
 * Jadi ini adalah functional interface
 *
 * Hubungan dengan Lambda
 * Lambda tidak jalan sendiri
 *
 * Tapi:
 * Dia jadi implementasi method di functional interface
 *
 * ------------------------------------
 * 
 * Aturan penting:
 * Lambda cuma bisa dipakai kalau ada:
 * target type (functional interface)
 *
 * Contoh penggunaan (assignment)
 * 1. Buat reference:
 * // Membuat referensi ke interface MyNumber
 * MyNumber myNum;
 *
 * 2. Assign lambda:
 * // Assign lambda ke MyNumber
 * myNum = () -> 123.45;
 *
 * Yang terjadi di belakang layar:
 * Java otomatis:
 * bikin object
 * implement interface MyNumber
 * isi method getValue() pakai lambda
 *
 * Jadi ini sebenarnya setara dengan:
 * MyNumber myNum = new MyNumber() {
 *
 *     @Override
 *     public double getValue() {
 *         return 123.45;
 *     }
 * };
 *
 * Tapi lambda bikin jauh lebih simpel
 *
 * Eksekusi Lambda
 * System.out.println(myNum.getValue());
 *
 * Output:
 * 123.45
 *
 * Kenapa?
 * Karena:
 * getValue() diisi lambda
 * lambda return 123.45
 *
 * ----------------------------------------------------
 * 
 * Insight penting:
 * Lambda = cara mengubah kode jadi object
 *
 * Target Type Context
 * Lambda bisa dipakai di beberapa tempat:
 * assignment (contoh tadi)
 * inisialisasi variable
 * return method
 * parameter method
 *
 * Aturan Kecocokan (Compatibility Rules)
 * Ini penting banget bro
 *
 * Lambda HARUS cocok dengan method di interface:
 *
 * 1. Jumlah parameter harus sama
 * Kalau method:
 * int sum(int a, int b);
 *
 * Lambda:
 * (a, b) -> a + b
 *
 * 2. Tipe parameter harus cocok
 * Bisa eksplisit:
 * (int a, int b) -> a + b
 * Atau implicit:
 * (a, b) -> a + b
 *
 * 3. Return type harus cocok
 * Kalau method return double
 * lambda juga harus return double
 *
 * 4. Exception harus sesuai
 * Kalau method gak izinkan exception tertentu
 * lambda juga gak boleh lempar sembarangan
 *
 * Kesimpulan Super Sederhana
 * Ringkasan:
 *
 * Functional Interface
 * Interface dengan 1 method abstract
 * Jadi target lambda
 *
 * Lambda Expression
 * Isi method dari interface
 * Tidak berdiri sendiri
 *
 * Cara kerja
 * Buat interface
 * Buat reference
 * Assign lambda
 * Panggil method → lambda jalan
 *
 * Aturan penting
 * Parameter harus cocok
 * Return type harus cocok
 * Harus ada target type
 *
 * Lambda expression = implementasi dari abstract method di functional interface
 * Jadi hubungan yang benar:
 * Functional Interface → tempat / wadah (punya 1 abstract method)
 * Lambda Expression → isi / implementasi method itu
 *
 * Analogi biar nempel:
 * Bayangin:
 * Functional Interface = kontrak kerja
 * Abstract method = tugas
 * Lambda = cara ngerjain tugas itu
 *
 * Lambda expression adalah implementasi dari abstract method dalam functional interface
 */

// Functional interface (wadah)
interface MyNum {
    double getValue(); // abstract method (tugas)
}

interface MyNumber {
    int getValue();
}

public class Lambda {
    public static void main(String[] args) {

        // Lambda = implementasi tugasnya
        MyNum myNum = () -> 123.45;
        System.out.println(myNum.getValue());

        /**
         * Artinya:
         * getValue() diisi oleh lambda
         * lambda = isi logic method
         */

        // Lambda ini menghasilkan angka random lalu dikali 100
        myNum = () -> Math.random() * 100;
        // Setiap pemanggilan akan menghasilkan nilai berbeda
        System.out.println("A random value: " + myNum.getValue());
        System.out.println("Another random value: " + myNum.getValue());

        // CONTOH ERROR (tidak boleh)
        // Ini ERROR karena return String, bukan double
        // myNum = () -> "123.03";

        // Membuat reference ke MyNumber
        MyNumber myNumber;

        // Assign lambda expression ke myNum
        // Lambda ini akan menjadi isi dari method getValue()
        myNumber = () -> 22;

        // Memanggil method getValue()
        // Sebenarnya yang dijalankan adalah lambda tadi
        System.out.println(myNumber.getValue());
    }
}
