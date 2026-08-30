package FundamentalJava.Methods;

/*
 * ============================================================
 * Returning a Value (Method yang Mengembalikan Nilai)
 * ============================================================
 *
 * Method return value adalah method yang menghasilkan sebuah nilai
 * dan mengirimkan nilai tersebut kembali kepada kode yang
 * memanggil method tersebut..
 *
 * Nilai yang dikembalikan dapat berupa:
 *
 * - Primitive type seperti int, double, boolean.
 * - Reference type seperti String atau object dari sebuah class.
 *
 * Berbeda dengan method void, method return value dapat digunakan
 * kembali dalam operasi lain karena menghasilkan sebuah nilai.
 *
 * ------------------------------------------------------------
 * Cara Memanggil Method yang Mengembalikan Nilai
 * ------------------------------------------------------------
 *
 * Contoh:
 *
 * double vol = myBox.volume();
 *
 * Alur proses:
 *
 * 1. Object myBox memanggil method volume().
 * 2. Method volume() menjalankan proses perhitungan.
 * 3. Hasil perhitungan dikembalikan menggunakan return.
 * 4. Nilai tersebut disimpan ke dalam variable vol.
 *
 * Flow:
 *
 * myBox.volume()
 *        |
 *        v
 * perhitungan volume
 *        |
 *        v
 * return nilai
 *        |
 *        v
 * variable vol menerima hasil
 *
 * ------------------------------------------------------------
 * Aturan Return Value
 * ------------------------------------------------------------
 *
 * 1. Return Type Harus Sesuai
 *
 * Tipe nilai yang dikembalikan oleh return harus sesuai dengan
 * return type yang ditentukan pada method.
 *
 * Contoh:
 *
 * double volume() {
 *     return 10.5;
 * }
 *
 * Method tersebut harus mengembalikan nilai bertipe double.
 *
 * Contoh salah:
 *
 * int angka() {
 *     return "Hello";
 * }
 *
 * Error:
 *
 * String tidak dapat dikembalikan oleh method yang memiliki
 * return type int.
 *
 * Karena:
 *
 * int != String
 *
 * ------------------------------------------------------------
 *
 * 2. Variable Penerima Harus Kompatibel
 *
 * Nilai return harus dapat disimpan oleh variable yang menerima.
 *
 * Contoh benar:
 *
 * double volume() {
 *     return 100.5;
 * }
 *
 * double hasil = volume();
 *
 * Karena:
 *
 * return type  -> double
 * variable     -> double
 *
 *
 * Contoh widening conversion:
 *
 * int jumlah() {
 *     return 10;
 * }
 *
 * double nilai = jumlah();
 *
 * Java dapat melakukan konversi otomatis dari int ke double.
 *
 * Tetapi kebalikannya tidak diperbolehkan tanpa casting.
 *
 * ------------------------------------------------------------
 * Return Value Tanpa Variable Penampung
 * ------------------------------------------------------------
 *
 * Nilai return tidak selalu harus disimpan ke variable.
 *
 * Method dapat langsung digunakan sebagai bagian dari ekspresi.
 *
 * Contoh:
 *
 * System.out.println(myBox.volume());
 *
 * Alur:
 *
 * println()
 *      |
 *      v
 * myBox.volume()
 *      |
 *      v
 * width * height * depth
 *      |
 *      v
 * nilai dikirim ke println()
 *
 * Java menjalankan method volume() terlebih dahulu, kemudian
 * menggunakan hasil return sebagai parameter println().
 *
 * ------------------------------------------------------------
 * Kenapa Return Value Lebih Fleksibel?
 * ------------------------------------------------------------
 *
 * Contoh menggunakan void:
 *
 * void volume() {
 *     System.out.println(width * height * depth);
 * }
 *
 * Masalah:
 *
 * Hasil hanya dicetak dan tidak dapat digunakan kembali oleh
 * program.
 *
 * ------------------------------------------------------------
 *
 * Contoh menggunakan return value:
 *
 * double volume() {
 *     return width * height * depth;
 * }
 *
 * Sekarang hasil dapat digunakan dalam berbagai kebutuhan.
 *
 * Contoh:
 *
 * double hasil = box.volume();
 *
 * Atau:
 *
 * System.out.println(box.volume());
 *
 * Atau:
 *
 * double total = box1.volume() + box2.volume();
 *
 * Return value membuat method lebih reusable dan fleksibel.
 *
 * ------------------------------------------------------------
 * Return Menghentikan Eksekusi Method
 * ------------------------------------------------------------
 *
 * Ketika keyword return dijalankan, method langsung berhenti
 * dan mengirimkan nilai kembali kepada pemanggil.
 *
 * Contoh:
 *
 * int cekNilai(int angka) {
 *
 *     if (angka > 10) {
 *         return 1;
 *     }
 *
 *     return 0;
 * }
 *
 * Jika angka lebih besar dari 10:
 *
 * - return 1 dijalankan.
 * - Method langsung selesai.
 * - Baris setelah return tidak akan dieksekusi.
 *
 * ------------------------------------------------------------
 * Method Dengan Berbagai Return Type
 * ------------------------------------------------------------
 *
 * Java memungkinkan method mengembalikan berbagai jenis data.
 *
 * Contoh:
 *
 * int:
 *
 * int umur() {
 *     return 25;
 * }
 *
 *
 * double:
 *
 * double luas() {
 *     return 3.14 * 10 * 10;
 * }
 *
 *
 * boolean:
 *
 * boolean sudahDewasa(int usia) {
 *     return usia >= 18;
 * }
 *
 *
 * String:
 *
 * String nama() {
 *     return "Java";
 * }
 *
 *
 * Object:
 *
 * Box buatBox() {
 *     return new Box();
 * }
 *
 * ------------------------------------------------------------
 * Return Langsung Tanpa Variable Sementara
 * ------------------------------------------------------------
 *
 * Return dapat langsung mengembalikan hasil ekspresi.
 *
 * Contoh:
 *
 * int tambah(int a, int b) {
 *     return a + b;
 * }
 *
 * Atau menggunakan variable:
 *
 * int tambah(int a, int b) {
 *
 *     int hasil = a + b;
 *
 *     return hasil;
 * }
 *
 * Kedua cara tersebut menghasilkan output yang sama.
 *
 * Pemilihan cara tergantung kebutuhan:
 *
 * - Return langsung lebih ringkas.
 * - Variable sementara dapat membantu debugging atau membuat
 *   kode lebih mudah dibaca.
 *
 * ------------------------------------------------------------
 * Method Return Dapat Digunakan Oleh Method Lain
 * ------------------------------------------------------------
 *
 * Sebuah method dapat menggunakan hasil return dari method lain.
 *
 * Contoh:
 *
 * int tambah(int a, int b) {
 *     return a + b;
 * }
 *
 * int kaliTambah(int x, int y) {
 *     return tambah(x, y) * 2;
 * }
 *
 * Alur:
 *
 * kaliTambah()
 *       |
 *       v
 * tambah()
 *       |
 *       v
 * return hasil
 *       |
 *       v
 * dikalikan 2
 *
 * ------------------------------------------------------------
 * Aturan Compiler Java Pada Return
 * ------------------------------------------------------------
 *
 * Jika sebuah method memiliki return type selain void, maka
 * semua jalur eksekusi yang memungkinkan harus menghasilkan
 * nilai return.
 *
 * Contoh salah:
 *
 * int cek(int nilai) {
 *
 *     if (nilai > 10) {
 *         return 1;
 *     }
 *
 * }
 *
 * Compiler akan memberikan error karena ketika kondisi tidak
 * terpenuhi, method tidak mengembalikan nilai apapun.
 *
 * Perbaikan:
 *
 * int cek(int nilai) {
 *
 *     if (nilai > 10) {
 *         return 1;
 *     }
 *
 *     return 0;
 * }
 *
 * ------------------------------------------------------------
 * Ringkasan Penting
 * ------------------------------------------------------------
 *
 * Method return value:
 *
 * - Menghasilkan sebuah nilai.
 * - Mengirimkan nilai tersebut kembali ke pemanggil method.
 * - Dapat digunakan kembali dalam operasi lain.
 *
 * Struktur dasar:
 *
 * returnType methodName(parameter) {
 *     return value;
 * }
 *
 * Perbedaan utama:
 *
 * void:
 *
 * - Tidak menghasilkan nilai.
 * - Biasanya digunakan untuk melakukan suatu aksi.
 *
 *
 * return value:
 *
 * - Menghasilkan nilai.
 * - Nilainya dapat disimpan atau digunakan kembali.
 *
 * ------------------------------------------------------------
 * Kesimpulan
 * ------------------------------------------------------------
 *
 * Return value adalah konsep penting dalam Java karena membuat
 * method lebih fleksibel dan reusable.
 *
 * Dengan return value, sebuah method tidak hanya melakukan aksi,
 * tetapi juga dapat menghasilkan data yang dapat diproses oleh
 * bagian program lainnya.
 *
 */

public class MethodReturnValue {

    double width;
    double height;
    double depth;
    int sisi;

    // Methode return value (mengembalikan nilai)
    double volume() {
        return width * height * depth;
    }

    // Contoh Lebih Sederhana
    int luas() {
        return sisi * sisi;
    }

    public static void main(String[] args) {

        MethodReturnValue box1 = new MethodReturnValue();
        MethodReturnValue box2 = new MethodReturnValue();

        double vol; // variabel untuk menyimpan hasil volume

        // memberi nilai pada objek pertama
        box1.width = 10;
        box1.height = 20;
        box1.depth = 15;

        // memberi nilai pada objek kedua
        box2.width = 3;
        box2.height = 6;
        box2.depth = 9;

        // mengambil vol box pertama
        vol = box1.volume();
        System.out.println("Volume is " + vol);

        // mengambil vol box kedua
        vol = box2.volume();
        System.out.println("Volume is " + vol);

        /**
         * Penjelasan Konsep Penting
         * 
         * Perbedaan Program Sebelumnya
         * Program lama:
         * 
         * void volume() {
         * System.out.println(width * height * depth);
         * }
         *
         * Program baru:
         * double volume() {
         * return width * height * depth;
         * }
         *
         * Perbedaannya:
         * Program lama Program baru
         * langsung print mengembalikan nilai
         * void double
         * tidak fleksibel lebih fleksibel
         *
         * Kenapa lebih fleksibel?
         * Karena hasilnya bisa dipakai untuk banyak hal:
         *
         * double v = mybox1.volume();
         * atau
         * if(mybox1.volume() > 1000)
         * atau
         * totalVolume += mybox1.volume();
         */

        MethodReturnValue persegi = new MethodReturnValue();
        persegi.sisi = 5;
        int hasil = persegi.luas();
        System.out.println(hasil);

        /**
         * Insight Penting dari Materi Ini
         *
         * Di OOP yang baik:
         * Object tidak hanya menyimpan data, tetapi juga mengolah datanya sendiri.
         *
         * Contoh:
         *
         * Box
         * ├ width
         * ├ height
         * ├ depth
         * └ volume()
         *
         * Artinya:
         * Box tahu cara menghitung volumenya sendiri.
         *
         * Ini adalah konsep besar OOP:
         * Encapsulation
         * data + behavior dalam satu class
         */

    }
}
