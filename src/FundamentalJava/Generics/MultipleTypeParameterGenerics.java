package FundamentalJava.Generics;

/**
 * Apa yang berubah?
 *
 * Kalau sebelumnya:
 * class Gen<T>
 *
 * Sekarang:
 * class TwoGen<T, V>
 *
 * Artinya:
 * kita punya 2 parameter tipe
 * bukan cuma satu
 *
 * Cara nulisnya
 * Kalau lebih dari satu:
 * pakai koma
 * <T, V>
 *
 * Artinya
 * T = tipe pertama
 * V = tipe kedua
 *
 * ------------------------------------------
 * 
 * HAL PENTING YANG WAJIB LU PAHAM
 * 
 * 1. Jumlah parameter = jumlah tipe
 * TwoGen<T, V>
 * berarti harus isi 2:
 * TwoGen<Integer, String>
 *
 * 2. Boleh beda tipe
 * TwoGen<Integer, String>
 *
 * 3. Boleh juga sama tipe
 * TwoGen<String, String> x =
 * new TwoGen<String, String>("A", "B");
 * ini valid
 *
 * 4. Tapi kalau selalu sama?
 * mending pakai 1 type aja
 *
 * KESIMPULAN SUPER JELAS
 * Intinya:
 *
 * Generics bisa punya lebih dari satu tipe
 *
 * Keuntungan:
 * Bisa simpan banyak tipe berbeda
 * Lebih fleksibel
 * Tetap aman (type-safe)
 *
 * Hal penting:
 * jumlah <T, V> harus sesuai
 * urutan penting!
 */

class GenMul<T, V> {
    T ob1;
    V ob2;

    GenMul(T a, V b) {
        ob1 = a;
        ob2 = b;
    }

    void show() {
        System.out.println("Type of T is: " + ob1.getClass().getName());
        System.out.println("Type of V is: " + ob2.getClass().getName());
    }

    T getOb1() {
        return ob1;
    }

    V getOb2() {
        return ob2;
    }
}

public class MultipleTypeParameterGenerics {
    public static void main(String[] args) {
        
    GenMul<Integer, String> genMul1 = new GenMul<Integer, String>(88, "Generics");

        // menampilkan tipe data
        genMul1.show();

        // mengambil dan menampilkan nilai
        int v = genMul1.getOb1();
        System.out.println("value: " + v);

        String string = genMul1.getOb2();
        System.out.println("value: " + string);

        /**
         * BEDAH KODE 
         * 
         * 1. Deklarasi Class
         * class TwoGen<T, V>
         *
         * Ini artinya:
         * class punya 2 tipe fleksibel
         * T dan V bisa beda
         *
         * 2. Variabel
         * T ob1;
         * V ob2;
         *
         * Artinya:
         * ob1 → tipe T
         * ob2 → tipe V
         *
         * 3. Constructor
         * TwoGen(T o1, V o2)
         *
         * Input:
         * parameter pertama → T
         * parameter kedua → V
         *
         * 4. Method get
         * T getob1()
         * V getob2()
         *
         * Return sesuai tipe masing-masing
         *
         * 5. showTypes()
         * ob1.getClass().getName()
         *
         * ambil tipe asli saat runtime
         *
         * -------------------------------------
         * 
         * DI MAIN (INI BAGIAN PENTING)
         * 
         * Object dibuat
         * TwoGen<Integer, String> tgObj =
         *   new TwoGen<Integer, String>(88, "Generics");
         *
         * Apa yang terjadi?
         * Parameter	Diganti jadi
         * T	        Integer
         * V	        String
         *
         * Jadi:
         * ob1 → Integer (88)
         * ob2 → String ("Generics")
         *
         * Ambil nilai
         * int v = tgObj.getob1();
         * langsung Integer → int (auto-unboxing)
         *
         * String str = tgObj.getob2();
         * langsung String
         *
         * OUTPUT
         * Type of T is java.lang.Integer
         * Type of V is java.lang.String
         * value: 88
         * value: Generics
         */
    }
}
