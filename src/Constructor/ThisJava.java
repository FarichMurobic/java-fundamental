package Constructor;

/**
     * This
     *
     * this adalah reference ke object yang sedang aktif.
     * Kadang-kadang sebuah method perlu merujuk pada objek yang memanggil method tersebut.
     * Untuk memungkinkan hal ini, Java menyediakan keyword this.
     * this dapat digunakan di dalam method mana pun untuk merujuk pada objek saat ini (current object).
     * Artinya, this selalu merupakan reference ke object yang memanggil method tersebut.
     * Kamu bisa menggunakan this di mana saja reference terhadap objek dari class yang sama diperbolehkan.
     *
     * Kapan this Menjadi Penting?
     * this sangat penting jika nama parameter sama dengan nama variabel instance.
     *
     * Kenapa harus pakai this?
     * Karena tanpa this, Java bingung.
     * Contoh salah:
     * width = width;
     *
     * Ini artinya:
     * width(parameter) = width(parameter)
     * Variabel instance tidak pernah diisi.
     *
     * Dengan this
     * this.width = width;
     * Artinya:
     * width(instance) = width(parameter)
     *
     * this Selalu Mengacu ke Object yang Memanggil Method
     *
     * Contoh:
     * Mahasiswa m1 = new Mahasiswa("Farich");
     * Mahasiswa m2 = new Mahasiswa("Budi");
     *
     * Saat method dipanggil:
     * m1.tampilkan()
     * this → m1
     * m2.tampilkan()
     * this → m2
     *
     * Ringkasan Konsep this
     * this adalah:
     * reference ke object saat ini
     *
     * Digunakan untuk:
     * mengakses instance variable
     * membedakan parameter dengan variabel class
     * memanggil constructor lain
     * mengirim object ke method lain
     */

public class ThisJava {

    double width;
    double height;
    double depth;

    /**
     * contoh program redudant.
     *
     * This(double w, double h, double d) {
     *
     * this menunjuk ke object yang sedang dibuat
     * this disini sebenarnya redudant, Tanpa this. Java tetap mengerti bahwa width adalah instance variable.
     * this.width = w;
     * this.height = h;
     * this.depth = d;
     * }
     */

    // Contoh this yang benar, saat nama variabel instance dan nama variabel parameter sama.
    ThisJava(double width, double height, double depth) {
        // artinya this disini merujuk instance. meskipun namanya sama dengan nama parameter
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    /**
     * Alur Eksekusi Program
     *
     * Misalnya kita jalankan:
     * Box box1 = new Box(5,6,7);
     * Saat constructor berjalan:
     * Parameter:
     * width  = 5
     * height = 6
     * depth  = 7
     *
     * this menunjuk ke object:
     * box1
     *
     * Eksekusi:
     * this.width  = width  → box1.width = 5
     * this.height = height → box1.height = 6
     * this.depth  = depth  → box1.depth = 7
     *
     * Object selesai dibuat.
     */


    double volume() {
        return width * height * depth;
    }

    public static void main(String[] args) {

        ThisJava objek1 = new ThisJava(20, 20, 50);
        System.out.println(objek1.volume());

        /**
         * Apa Arti this Sebenarnya?
         * 
         * this adalah reference ke object yang sedang aktif.
         * Misalnya kita punya:
         * Box mybox1 = new Box(10,20,30);
         * Saat constructor berjalan:
         * this → mybox1
         *
         * Jadi:
         * this.width = w;
         * artinya:
         * mybox1.width = w
         *
         * --------------------------------
         * 
         * Ilustrasi Memory Object
         * 
         * Ketika object dibuat:
         * Box mybox1 = new Box(10,20,30);
         *
         * Memory object:
         * mybox1
         *  ├── width  = 10
         *  ├── height = 20
         *  └── depth  = 30
         *
         * Saat constructor berjalan:
         * this → object mybox1
         */

    }
}
