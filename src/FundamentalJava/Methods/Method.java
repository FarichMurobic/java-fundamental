package FundamentalJava.Methods;

        /**
         * Apa itu Method?
         *
         * Method adalah sekumpulan kode yang melakukan suatu tugas tertentu.
         * Contoh analogi:
         * class = mesin
         * method = tombol fungsi pada mesin
         *
         * Misalnya:
         * Mesin kopi memiliki tombol:
         * buatKopi()
         * buatTeh()
         * buatCoklat()
         *
         * Di Java:
         * method = aksi yang bisa dilakukan object
         * Contoh:
         * mybox.volume()
         *
         * Artinya:
         * Object mybox menjalankan fungsi volume().
         *
         * Bentuk umum sebuah method adalah sebagai berikut:
         * type name(parameter-list) {
         *     // body of method
         * }
         *
         * Di sini:
         * -type menentukan tipe data yang dikembalikan oleh method.
         * -Tipe ini bisa berupa tipe data apa saja yang valid, termasuk class yang kamu buat sendiri.
         * -Jika method tidak mengembalikan nilai, maka tipe kembalian harus void.
         *
         * name adalah nama method. Nama ini bisa berupa identifier yang valid, selama tidak sama dengan nama lain yang sudah ada dalam scope tersebut.
         * parameter-list adalah daftar parameter yang dipisahkan oleh koma.
         * Parameter pada dasarnya adalah variabel yang menerima nilai dari argumen ketika method dipanggil.
         * Jika method tidak memiliki parameter, maka daftar parameter akan kosong.
         *
         * Struktur Method
         * Contoh struktur:
         * int tambah(int a, int b) {
         *     return a + b;
         * }
         * 
         * --------------------------------------------------
         *
         * Penjelasan:
         * Bagian	            Arti
         * int	                tipe data yang dikembalikan
         * tambah	            nama method
         * (int a, int b)	    parameter
         * {}	                isi method
         *
         * -----------------------------------------------------
         * 
         * Return Statement
         * Method yang memiliki tipe kembalian selain void akan mengembalikan nilai ke pemanggil method menggunakan bentuk berikut:
         * return value;
         *
         * Di mana value adalah nilai yang dikembalikan.
         * Contoh
         * int tambah(int a, int b) {
         *     return a + b;
         * }
         *
         * Pemanggilan:
         * int hasil = tambah(5,3);
         *
         * Alur:
         * 5 + 3
         * ↓
         * 8
         * ↓
         * return 8
         *
         * --------------------------------------------------
         * 
         * Aturan Penting (Yang Sering Bikin Bingung)
         *
         * Jika mengakses instance variable dari luar class
         * harus pakai object.
         * Contoh:
         * mybox1.width = 10;
         *
         * Jika dari dalam class yang sama
         * boleh langsung:
         * width
         * height
         * depth
         */

// This program includes a method inside the box class.
class Box {
    double panjang; // instance variabel
    double lebar; // instance variabel
    double tinggi; // instance variabel
    String nama; // instance variabel

    // jika ingin mengakses instance variabel dari luar class, harus menggunakan objek
    // contoh: myBox1.panjang = 10;

    // methode menampilkan string
    void sayHello() {
        nama = "\tFarich \n\t\tMurobiq";
        System.out.println(nama);
    }

    // method untuk menampilkan volume box
    void volume() {
        System.out.print("Volume is ");
        System.out.println(panjang * lebar * tinggi);
    }
}

public class Method {
    public static void main(String[] args) {
        
        // membuat objek dari kelas box
        Box myBox1 = new Box(); // membuat object box pertama
        Box myBox2 = new Box(); // membuat object box kedua

        // memberikan nilai pada objek pertama
        myBox1.panjang = 10;
        myBox1.lebar = 20;
        myBox1.tinggi = 15;

        // memberikan nilai pada objek kedua
        myBox2.panjang = 3;
        myBox2.lebar = 6;
        myBox2.tinggi = 9;

        // memanggil metode volume untuk objek pertana
        myBox1.volume();
        // memanggil metode volume untuk objek pertana
        myBox2.volume();

        /**
         * Output Program
         * Volume is 3000.0
         * Volume is 162.0
         *
         * Perhitungan:
         * 10 × 20 × 15 = 3000
         * 3 × 6 × 9 = 162
         *
         * Cara Memanggil Method
         * Baris penting:
         * mybox1.volume();
         * mybox2.volume();
         *
         * Artinya:
         * object.method() atau mybox1 menjalankan method volume()
         *
         * Operator . disebut:
         * Dot Operator
         * Digunakan untuk mengakses member dari object
         *
         * Contoh:
         * object.variable
         * object.method()
         *
         * ------------------------------------
         * 
         * Alur Eksekusi Program
         * Ketika program dijalankan:
         * Step 1
         * Object dibuat
         * Box mybox1 = new Box();
         * Box mybox2 = new Box();
         *
         * Memory kira-kira:
         * mybox1 → object Box
         * mybox2 → object Box
         *
         * Step 2
         * Isi data object
         * mybox1
         * width = 10
         * height = 20
         * depth = 15
         * mybox2
         * width = 3
         * height = 6
         * depth = 9
         *
         * Step 3
         * Method dipanggil
         * mybox1.volume();
         *
         * Java:
         * pindah ke method volume()
         * jalankan kode
         * width * height * depth
         * tampilkan hasil
         *
         * Step 4
         * Kembali ke main method.
         */

        // membuat objek
        Box nameBox = new Box();
        nameBox.sayHello();

    }
}
