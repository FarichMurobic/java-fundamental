package FundamentalJava.Methods;

        /**
         * Returning a Value (Method yang Mengembalikan Nilai)
         *
         * Method return value adalah method yang menghasilkan nilai lalu mengirimkannya kembali ke pemanggil method.
         * Cara Memanggil Method yang Mengembalikan Nilai
         *
         * Di program:
         * vol = mybox1.volume();
         *
         * Penjelasan:
         * 1. mybox1.volume() dijalankan
         * 2. method menghitung volume
         * 3. hasil dikembalikan
         * 4. disimpan ke vol
         *
         * Dua Aturan Penting Return Value
         * 1. Tipe return harus sesuai
         *
         * Jika method:
         * double volume()
         * Maka return harus double.
         *
         * 2. Variabel penerima harus cocok
         *
         * Contoh:
         * double volume()
         * Maka penerima harus kompatibel.
         * Benar
         * double v = mybox1.volume();
         * 
         * Masih benar (casting otomatis)
         * double v = mybox1.volume();
         *
         * ---------------------------------------------------------
         * 
         * Versi Lebih Efisien
         * Buku bilang sebenarnya variabel vol tidak diperlukan.
         * Program bisa langsung seperti ini:
         * System.out.println("Volume is " + mybox1.volume());
         *
         * Penjelasan:
         * Saat println dijalankan:
         * 1- Java memanggil mybox1.volume()
         * 2- method menghitung volume
         * 3- nilai dikirim ke println
         *
         * Alur di Memory
         * println()
         *    ↑
         * mybox1.volume()
         *    ↑
         * width * height * depth
         *
         * Kenapa Return Value Lebih Baik
         * Misalnya ada method ini:
         * Versi void
         * void volume() {
         *     System.out.println(panjang * lebar * tinggi);
         * }
         *
         * Masalahnya:
         * hasil tidak bisa dipakai lagi
         *
         * Versi return value
         * double volume() {
         *     return panjang * lebar * tinggi;
         * }
         *
         * Sekarang hasilnya bisa dipakai:
         * double v = box.volume();
         * atau
         * System.out.println(box.volume());
         * atau
         * double total = box1.volume() + box2.volume();
         * Jadi lebih fleksibel.
         *
         * Return Menghentikan Method
         * Ketika return dijalankan:
         * method langsung berhenti
         * Contoh:
         * int cek(int x) {
         *
         *     if(x > 10)
         *         return 1;
         *
         *     return 0;
         * }
         *
         * Kalau x > 10:
         * return 1
         * method selesai
         * Baris setelahnya tidak dijalankan.
         *
         * Return Harus Sesuai Tipe Data
         * Contoh benar:
         * int angka() {
         *     return 5;
         * }
         *
         * Contoh salah:
         * int angka() {
         *     return "hello"; // ERROR
         * }
         *
         * Karena:
         * int ≠ String
         *
         * Method Bisa Mengembalikan Banyak Tipe:
         * int
         * int umur() {
         *     return 22;
         * }
         *
         * double
         * double luas() {
         *     return 3.14 * 10 * 10;
         * }
         *
         * boolean
         * boolean dewasa(int usia) {
         *     return usia >= 18;
         * }
         *
         * String
         * String nama() {
         *     return "Farich";
         * }
         *
         * Object
         * Box buatBox() {
         *     return new Box();
         * }
         *
         * return Tanpa Variable
         * Return bisa langsung:
         * int tambah(int a, int b) {
         *     return a + b;
         * }
         *
         * Atau pakai variable:
         * int tambah(int a, int b) {
         *     int hasil = a + b;
         *     return hasil;
         * }
         *
         * Keduanya sama.
         *
         * Method Bisa Dipanggil Dalam Method Lain
         * Contoh:
         *
         * int tambah(int a, int b) {
         *     return a + b;
         * }
         *
         * int kaliTambah(int x, int y) {
         *     return tambah(x,y) * 2;
         * }
         *
         * ringkasan Penting
         * Method return value:
         * menghasilkan nilai
         * lalu mengirimkannya ke pemanggil
         *
         * Struktur:
         * tipeData method() {
         *     return nilai;
         * }
         *
         * Perbedaan utama:
         * void	                        return value
         * tidak menghasilkan nilai	    menghasilkan nilai
         * hanya aksi	                bisa dipakai di operasi lain
         *
         * Rule penting Java
         * Kalau method punya tipe selain void:
         * WAJIB ada return
         * Kalau tidak:
         * compiler error
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
         *     System.out.println(width * height * depth);
         * }
         *
         * Program baru:
         * double volume() {
         *     return width * height * depth;
         * }
         *
         * Perbedaannya:
         * Program lama	        Program baru
         * langsung print	    mengembalikan nilai
         * void	                double
         * tidak fleksibel	    lebih fleksibel
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
         *  ├ width
         *  ├ height
         *  ├ depth
         *  └ volume()
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
