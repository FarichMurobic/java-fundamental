package FundamentalJava.Methods.MethodOverloading;

    /**
     * Di Java, kita bisa mendefinisikan dua atau lebih method dalam class yang sama dengan nama yang sama, 
     * selama parameter mereka berbeda.
     * 
     * Jika hal ini terjadi, maka method tersebut disebut overloaded, dan prosesnya disebut method overloading.
     * 
     * Method overloading adalah salah satu cara Java mendukung polymorphism.
     *
     * Apa itu Method Overloading?
     * Method overloading = method dengan nama sama tetapi parameter berbeda
     * Contoh:
     * print()
     * print(int a)
     * print(int a, int b)
     *
     * Semua method namanya print, tetapi parameter berbeda.
     * Java bisa membedakan mana yang dipanggil.
     *
     * Aturan Method Overloading
     * Java menentukan method mana yang dipanggil berdasarkan:
     * 1. Jumlah parameter
     * 2. Tipe parameter
     *
     * Contoh:
     * test()
     * test(int a)
     * test(int a, int b)
     * test(double a)
     *
     * Semua method bernama test, tetapi parameternya berbeda.
     *
     * Return type tidak menentukan overloading
     * Artinya ini TIDAK BOLEH
     * int test(int a)
     * double test(int a)
     *
     * Karena parameternya sama.
     *
     * Automatic Type Conversion dalam Overloading
     * Kadang Java melakukan konversi tipe otomatis.
     * Contoh dari buku:
     * int i = 88;
     * ob.test(i);
     *
     * Tetapi method test(int) tidak ada.
     * Yang ada hanya:
     * test(double)
     * Maka Java melakukan:
     * int -> double
     * Sehingga method yang dipanggil:
     * test(double)
     * Output:
     * Inside test(double) a: 88
     *
     * Penjelasan Istilah Penting
     * Method Overloading
     * Beberapa method dengan nama sama tetapi parameter berbeda.
     *
     * Parameter
     * Variabel yang menerima nilai saat method dipanggil.
     * Contoh:
     * void test(int a)
     * a adalah parameter.
     *
     * Argument
     * Nilai yang dikirim ke method.
     * Contoh:
     * test(10)
     *
     * 10 adalah argument.
     *
     * Polymorphism
     * Konsep OOP dimana satu nama method bisa memiliki banyak bentuk.
     * Contoh:
     * test()
     * test(int)
     * test(double)
     *
     * Konsep Penting dari Materi Ini
     * 
     * Hal paling penting dari bagian ini:
     * Method bisa punya nama sama
     * Harus beda parameter
     * Java memilih method berdasarkan parameter
     * Return type tidak berpengaruh
     * Mendukung konsep polymorphism
     */

public class MethodOverloading {

    void test() { // no parameter
        System.out.println("Tanpa parameter.");
    }

    void test(int a) { // dengan parameter int a
        System.out.println("a: " + a);
    }

    void  test(int a, int b) { // dengan parameter int a dan b
        System.out.println("a dan b" + a + " " + b);
    }

    double test(double a) { // dengan parameter double a
        System.out.println("double a: " + a);
        return a;
    }

    public static void main(String[] args) {

        MethodOverloading overload = new MethodOverloading();
        double hasil;

        // Memanggil semua versi methode. ini yang disebut (Methode Overloading)
        overload.test(); // Methode tanpa parameter
        overload.test(10); // Methode dengan parameter int a
        overload.test(10, 20); // Methode dengan parameter int a dan b
        // Return value double
        hasil = overload.test(1000.0);

    }
}
