package FundamentalJava.Lambda;

/* ==========================================================
 *                    LAMBDA EXPRESSIONS
 * ==========================================================
 *
 * Lambda Expression adalah salah satu fitur penting yang
 * diperkenalkan pada Java 8.
 *
 * Fitur ini membawa perubahan besar dalam cara programmer Java
 * menulis kode karena memungkinkan penggunaan konsep
 * functional programming.
 *
 * Sebelum Lambda Expression diperkenalkan, Java lebih banyak
 * menggunakan pendekatan Object-Oriented Programming (OOP)
 * dengan banyak anonymous class untuk membuat implementasi
 * sederhana.
 *
 * Lambda Expression membuat kode menjadi:
 *
 * - Lebih ringkas.
 * - Lebih mudah dibaca.
 * - Mengurangi boilerplate code.
 * - Lebih cocok digunakan untuk pemrosesan data modern.
 *
 * ==========================================================
 *              FITUR BESAR DALAM PERKEMBANGAN JAVA
 * ==========================================================
 *
 * Selama perkembangan Java, banyak fitur baru ditambahkan.
 *
 * Namun terdapat beberapa fitur yang memberikan perubahan
 * besar terhadap cara penulisan kode Java:
 *
 * 1. Generics (Java 5)
 *
 * Generics memperkenalkan kemampuan untuk membuat kode yang
 * aman terhadap tipe data (type-safe) dan lebih reusable.
 *
 *
 * 2. Lambda Expression (Java 8)
 *
 * Lambda Expression memperkenalkan cara baru dalam menulis
 * fungsi secara lebih sederhana menggunakan functional interface.
 *
 * Kedua fitur ini menjadi bagian penting dari perkembangan
 * Java modern.
 *
 * ==========================================================
 *              MENGAPA LAMBDA EXPRESSION PENTING?
 * ==========================================================
 *
 * Lambda Expression meningkatkan kemampuan Java melalui dua
 * perubahan besar.
 *
 * ----------------------------------------------------------
 * 1. Syntax Baru yang Lebih Ringkas
 * ----------------------------------------------------------
 *
 * Lambda memberikan cara baru untuk menulis implementasi
 * function tanpa harus membuat class anonim secara manual.
 *
 * Keuntungannya:
 *
 * - Mengurangi jumlah kode yang harus ditulis.
 * - Membuat logic sederhana lebih mudah dibaca.
 * - Mempermudah penggunaan callback pattern.
 *
 *
 * Contoh sebelum Lambda:
 *
 *     Runnable task = new Runnable() {
 *
 *         public void run() {
 *             System.out.println("Running");
 *         }
 *     };
 *
 *
 * Dengan Lambda:
 *
 *     Runnable task = () ->
 *         System.out.println("Running");
 *
 *
 * Implementasi menjadi lebih pendek dan fokus pada logic.
 *
 * ----------------------------------------------------------
 * 2. Kemampuan Baru pada Java API
 * ----------------------------------------------------------
 *
 * Lambda menjadi dasar dari banyak fitur Java modern seperti:
 *
 * - Stream API.
 * - Functional Interface.
 * - Method Reference.
 * - Parallel Processing.
 *
 * Dengan Lambda, Java dapat melakukan pemrosesan data dengan
 * pendekatan pipeline yang lebih deklaratif.
 *
 * ==========================================================
 *                  EFEK DOMINO DARI LAMBDA
 * ==========================================================
 *
 * Setelah Lambda diperkenalkan, Java juga menambahkan beberapa
 * fitur pendukung:
 *
 * 1. Default Method
 *
 * Method dengan implementasi default di dalam interface.
 *
 * Tujuannya:
 * memungkinkan interface berkembang tanpa merusak implementasi
 * class lama.
 *
 *
 * 2. Method Reference
 *
 * Cara singkat untuk mereferensikan method yang sudah ada tanpa
 * langsung menjalankannya.
 *
 * Contoh:
 *
 *     System.out::println
 *
 *
 * Lambda menjadi salah satu fondasi utama yang membuat fitur-
 * fitur tersebut dapat digunakan dengan baik.
 *
 * ==========================================================
 *                  LAMBDA DALAM DUNIA PROGRAMMING
 * ==========================================================
 *
 * Konsep Lambda bukan hanya terdapat pada Java.
 *
 * Bahasa pemrograman modern lain juga menggunakan konsep serupa,
 * seperti:
 *
 * - C#
 * - C++
 * - Kotlin
 * - JavaScript
 *
 * Hal ini menunjukkan bahwa Lambda merupakan konsep penting
 * dalam perkembangan programming modern.
 *
 * ==========================================================
 *                       KONSEP UTAMA
 * ==========================================================
 *
 * Lambda Expression memiliki dua konsep utama:
 *
 * 1. Lambda Expression
 * 2. Functional Interface
 *
 * Keduanya selalu berhubungan.
 *
 * Lambda tidak dapat berdiri sendiri.
 *
 * Lambda membutuhkan functional interface sebagai tempat untuk
 * menentukan bentuk function yang harus diimplementasikan.
 *
 * ==========================================================
 *                       KESIMPULAN
 * ==========================================================
 *
 * Lambda Expression merupakan fitur Java 8 yang mengubah cara
 * programmer menulis kode Java.
 *
 * Inti manfaat Lambda:
 *
 * - Mengurangi boilerplate code.
 * - Menulis logic lebih sederhana.
 * - Mendukung functional programming.
 * - Menjadi dasar Stream API dan pemrosesan data modern.
 *
 * Konsep ini menjadi salah satu kemampuan wajib bagi programmer
 * Java modern karena banyak digunakan pada framework dan API
 * terbaru.
 *
 * ==========================================================
 */

/* ==========================================================
 *                  FUNCTIONAL INTERFACE
 * ==========================================================
 *
 * Functional Interface adalah interface yang hanya memiliki satu
 * abstract method.
 *
 * Functional Interface menjadi konsep utama yang memungkinkan
 * penggunaan Lambda Expression di Java.
 *
 * Lambda tidak dapat berdiri sendiri karena membutuhkan target
 * type berupa functional interface untuk menentukan bentuk
 * method yang harus diimplementasikan.
 *
 * ==========================================================
 *              PERUBAHAN INTERFACE SEJAK JAVA 8
 * ==========================================================
 *
 * Sebelum Java 8:
 *
 * - Semua method di dalam interface secara default adalah
 *   abstract.
 *
 * Setelah Java 8:
 *
 * - Interface dapat memiliki method dengan implementasi.
 *
 * Jenis method yang dapat dimiliki interface modern:
 *
 * - Abstract method
 *   Method tanpa body yang harus diimplementasikan oleh class.
 *
 * - Default method
 *   Method yang memiliki implementasi bawaan menggunakan keyword
 *   default.
 *
 * - Static method
 *   Method yang dimiliki oleh interface itu sendiri.
 *
 * - Private method (Java 9+)
 *   Method helper yang hanya dapat digunakan di dalam interface.
 *
 * ==========================================================
 *              KAPAN METHOD DIANGGAP ABSTRACT?
 * ==========================================================
 *
 * Sebuah method pada interface dianggap abstract apabila:
 *
 * - Tidak memiliki body.
 *
 * Contoh:
 *
 *     interface Example {
 *
 *         void execute();
 *
 *     }
 *
 * Method execute() otomatis dianggap:
 *
 *     public abstract void execute();
 *
 * Keyword abstract tidak wajib ditulis karena Java sudah
 * menentukannya secara otomatis.
 *
 * ==========================================================
 *              CONTOH FUNCTIONAL INTERFACE
 * ==========================================================
 *
 * Contoh:
 *
 *     interface MyNumber {
 *
 *         double getValue();
 *
 *     }
 *
 * Penjelasan:
 *
 * - getValue() tidak memiliki body.
 * - Hanya terdapat satu abstract method.
 *
 * Maka MyNumber memenuhi aturan sebagai Functional Interface.
 *
 * Biasanya developer menambahkan annotation:
 *
 *     @FunctionalInterface
 *
 * Contoh:
 *
 *     @FunctionalInterface
 *     interface MyNumber {
 *
 *         double getValue();
 *
 *     }
 *
 * Annotation ini membantu compiler memastikan bahwa interface
 * tersebut benar-benar hanya memiliki satu abstract method.
 *
 * ==========================================================
 *                 HUBUNGAN DENGAN LAMBDA
 * ==========================================================
 *
 * Lambda Expression membutuhkan Functional Interface sebagai
 * target type.
 *
 * Hubungannya:
 *
 * Functional Interface:
 * Tempat atau wadah yang menentukan bentuk method.
 *
 * Lambda Expression:
 * Implementasi dari abstract method tersebut.
 *
 * ==========================================================
 *              CONTOH ASSIGNMENT LAMBDA
 * ==========================================================
 *
 * Membuat reference interface:
 *
 *     MyNumber myNum;
 *
 *
 * Mengisi reference dengan lambda:
 *
 *     myNum = () -> 123.45;
 *
 *
 * Yang terjadi secara konsep:
 *
 * Java membuat object yang mengimplementasikan MyNumber dan
 * menggunakan lambda sebagai isi dari method getValue().
 *
 * Kode lambda tersebut setara dengan anonymous class:
 *
 *     MyNumber myNum = new MyNumber() {
 *
 *         @Override
 *         public double getValue() {
 *             return 123.45;
 *         }
 *
 *     };
 *
 * Perbedaannya:
 *
 * Lambda menyediakan cara penulisan yang jauh lebih singkat
 * dan fokus pada logic yang dibutuhkan.
 *
 * ==========================================================
 *                    EKSEKUSI LAMBDA
 * ==========================================================
 *
 * Contoh:
 *
 *     System.out.println(myNum.getValue());
 *
 * Output:
 *
 *     123.45
 *
 * Alasannya:
 *
 * - Method getValue() telah diisi oleh lambda.
 * - Lambda mengembalikan nilai 123.45.
 *
 * ==========================================================
 *                 TARGET TYPE CONTEXT
 * ==========================================================
 *
 * Lambda selalu membutuhkan konteks yang menentukan tipe
 * interface tujuan.
 *
 * Konteks tersebut disebut:
 *
 * Target Type Context
 *
 * Lambda dapat digunakan pada beberapa tempat:
 *
 * - Assignment variable.
 * - Inisialisasi variable.
 * - Return value method.
 * - Parameter method.
 *
 * Contoh:
 *
 *     calculate(() -> 100);
 *
 * Lambda dapat digunakan karena parameter method calculate()
 * memiliki tipe functional interface.
 *
 * ==========================================================
 *            ATURAN KECocokan LAMBDA
 * ==========================================================
 *
 * Lambda harus sesuai dengan abstract method yang terdapat pada
 * functional interface.
 *
 * Terdapat beberapa aturan penting:
 *
 * ----------------------------------------------------------
 * 1. Jumlah Parameter Harus Sama
 * ----------------------------------------------------------
 *
 * Jika interface:
 *
 *     int sum(int a, int b);
 *
 *
 * Maka lambda:
 *
 *     (a, b) -> a + b
 *
 * valid.
 *
 * Lambda dengan jumlah parameter berbeda akan menyebabkan error.
 *
 * ----------------------------------------------------------
 * 2. Tipe Parameter Harus Sesuai
 * ----------------------------------------------------------
 *
 * Parameter dapat ditulis secara eksplisit:
 *
 *     (int a, int b) -> a + b
 *
 *
 * Atau menggunakan type inference:
 *
 *     (a, b) -> a + b
 *
 *
 * Java dapat menentukan tipe data secara otomatis berdasarkan
 * functional interface.
 *
 * ----------------------------------------------------------
 * 3. Return Type Harus Sesuai
 * ----------------------------------------------------------
 *
 * Jika abstract method mengembalikan:
 *
 *     double calculate();
 *
 *
 * Maka lambda harus menghasilkan nilai yang kompatibel dengan
 * double.
 *
 * Contoh:
 *
 *     () -> 10.5
 *
 * valid.
 *
 * ----------------------------------------------------------
 * 4. Exception Harus Sesuai
 * ----------------------------------------------------------
 *
 * Jika abstract method tidak mendeklarasikan checked exception,
 * maka lambda tidak boleh melempar checked exception tersebut.
 *
 * Lambda harus mengikuti aturan exception dari method interface.
 *
 * ==========================================================
 *                       CARA KERJA LAMBDA
 * ==========================================================
 *
 * Urutan konsep:
 *
 * 1. Membuat Functional Interface.
 *
 * 2. Interface memiliki satu abstract method.
 *
 * 3. Membuat reference dengan tipe interface tersebut.
 *
 * 4. Mengisi reference menggunakan lambda.
 *
 * 5. Memanggil method interface.
 *
 * 6. Logic lambda dijalankan.
 *
 * ==========================================================
 *                       ANALOGI
 * ==========================================================
 *
 * Bayangkan:
 *
 * Functional Interface = kontrak kerja.
 *
 * Abstract Method = tugas yang harus dilakukan.
 *
 * Lambda Expression = cara mengerjakan tugas tersebut.
 *
 * Contoh:
 *
 * Kontrak:
 *
 *     "Harus bisa menghitung nilai."
 *
 * Abstract method:
 *
 *     calculate()
 *
 * Lambda:
 *
 *     "Cara menghitungnya menggunakan rumus tertentu."
 *
 * ==========================================================
 *                       KESIMPULAN
 * ==========================================================
 *
 * Functional Interface adalah interface dengan tepat satu
 * abstract method yang menjadi target dari Lambda Expression.
 *
 * Inti konsep:
 *
 * - Functional Interface adalah wadah lambda.
 * - Lambda Expression adalah implementasi abstract method.
 * - Lambda tidak dapat digunakan tanpa target type.
 * - Parameter lambda harus sesuai dengan method interface.
 * - Return type harus sesuai.
 * - Exception harus mengikuti aturan method interface.
 *
 * Hubungan yang harus selalu diingat:
 *
 * Functional Interface
 *          |
 *          v
 * Menentukan kontrak method
 *          |
 *          v
 * Lambda Expression
 *          |
 *          v
 * Mengisi implementasi method tersebut
 *
 * ==========================================================
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
