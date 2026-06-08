package ClassAndObject;

    /**
     * Returning Objects
     * Sebuah method dapat mengembalikan tipe data apa pun, termasuk class yang kita buat sendiri.
     * Sebagai contoh, pada program berikut, method incrByTen() mengembalikan sebuah object yang
     * nilai a-nya 10 lebih besar dibandingkan object yang memanggil method tersebut.
     *
     * Konsep Penting yang Dijelaskan Buku
     * Setiap kali method dipanggil:
     * incrByTen()
     * 
     * Java membuat object baru.
     * Jadi alurnya seperti ini:
     * ob1 → a=2
     * incrByTen()
     * temp → a=12
     * return temp
     *
     * -------------------------------------------------------
     * 
     * Konsep Memory yang Penting
     * 
     * Buku juga menjelaskan sesuatu yang sangat penting:
     * Semua object di Java dibuat dengan:
     * new
     * 
     * Artinya object dibuat secara dynamic di heap memory.
     * Contoh:
     * Test temp = new Test(a+10);
     * Object berada di heap.
     *
     * Selama masih ada reference:
     * temp
     * ob1
     * ob2
     *
     * object tetap hidup.
     *
     * Jika tidak ada reference lagi:
     * object tidak digunakan
     * maka JVM akan menghapusnya melalui:
     * Garbage Collector
     *
     * Contoh Visualisasi Memory
     * Awalnya:
     * ob1 → object
     *        a=2
     *
     * Setelah pemanggilan method:
     * ob1 → object
     *        a=2
     *
     * ob2 → object baru
     *        a=12
     *
     * Setelah pemanggilan kedua:
     * ob1 → object
     *        a=2
     *
     * ob2 → object baru
     *        a=22
     *
     * Object lama:
     * a=12
     *
     * tidak memiliki reference lagi → nanti dihapus oleh Garbage Collector.
     *
     * ---------------------------------------------
     * 
     * Ringkasan Konsep
     * Method Java bisa mengembalikan:
     * primitive
     * object
     * array
     * interface
     * class
     *
     * Dalam contoh ini:
     * return object Test
     * Setiap pemanggilan:
     * object baru dibuat
     * dan:
     * reference dikembalikan ke pemanggil
     */

public class ReturnObject {

    // Instance variabe;
    int a;

    // Constructor
    ReturnObject(int i) {
        this.a = i;
    }

    // Method return Objek
    ReturnObject incrByTen() {

        // Buat objek di dalam method
        ReturnObject temp = new ReturnObject(this.a + 10);
        return temp;
    }

    public static void main(String[] args) {
        
        ReturnObject ob1 = new ReturnObject(2);
        ReturnObject ob2;

        // Memanggil method objek
        ob2 = ob1.incrByTen();

        System.out.println("ob1.a: " + ob1.a); // 2
        System.out.println("ob2.a: " + ob2.a); // 12

        ob2 = ob2.incrByTen();
        System.out.println("ob.2.a after second increase: " + ob2.a); // 22

        /**
         * Output
         * ob1.a: 2
         * ob2.a: 12
         * ob2.a after second increase: 22
         *
         * Penjelasan Konsep
         * Di program ini:
         * Method:
         * incrByTen()
         * mengembalikan object bertipe ReturnObject.
         * 
         * Perhatikan deklarasi methodnya:
         * ReturnObject incrByTen()
         * 
         * Artinya:
         * method ini mengembalikan object ReturnObject
         *
         * Analisis Method incrByTen()
         * Isi method:
         * ReturnObject temp = new ReturnObject(a + 10);
         * 
         * Object baru dibuat dengan nilai:
         * a + 10
         *
         * Misalnya object awal punya:
         * a = 2
         *
         * Maka object baru:
         * a = 12
         *
         * Kemudian method mengembalikan object tersebut:
         * return temp;
         *
         * Yang dikembalikan sebenarnya adalah reference object temp.
         *
         * --------------------------------------------------
         * 
         * Alur Program Saat Dijalankan
         * 
         * 1️ Membuat object pertama
         * ReturnObject ob1 = new ReturnObject(2);
         * 
         * Isi object:
         * ob1
         * a = 2
         *
         * 2️ Memanggil method
         * ob2 = ob1.incrByTen();
         * 
         * Java menjalankan:
         * incrByTen()
         * 
         * Langkah di dalam method:
         * temp = new ReturObject(2 + 10)
         * 
         * Object baru dibuat:
         * temp
         * a = 12
         * 
         * Kemudian:
         * return temp
         * Sehingga:
         * ob2 → object baru
         * a = 12
         *
         * 3️ Print nilai
         * ob1.a: 2
         * ob2.a: 12
         *
         * Perhatikan:
         * ob1 tidak berubah
         * Karena method membuat object baru.
         *
         * 4️ Pemanggilan kedua
         * ob2 = ob2.incrByTen();
         * Sekarang:
         * ob2.a = 12
         * 
         * Method membuat object baru:
         * 12 + 10 = 22
         * Object baru:
         * a = 22
         */
    }
}
