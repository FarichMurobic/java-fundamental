package Methods.MethodOverriding;

/**
     * Dynamic Method Dispatch
     *
     * Contoh sebelumnya cuma nunjukin cara override, tapi belum nunjukin kekuatannya.
     * Kalau override cuma sekadar “nama method sama”, ya itu gak terlalu berguna.
     * Tapi kenyataannya:
     * Override itu jadi dasar dari konsep super penting di Java:
     * Dynamic Method Dispatch
     *
     * Apa itu?
     * Dynamic Method Dispatch adalah:
     * Mekanisme di mana pemanggilan method yang dioverride ditentukan saat runtime (saat program berjalan), bukan saat compile.
     *
     * Kenapa penting?
     * Karena ini adalah cara Java menjalankan:
     * Polymorphism (banyak bentuk saat runtime)
     *
     * Prinsip penting
     * Reference superclass bisa menunjuk ke object subclass
     *
     * Cara kerjanya
     * Kalau kita panggil method lewat reference superclass:
     * Java akan lihat object aslinya
     * Bukan tipe referencenya
     *
     * Intinya:
     * Yang menentukan method mana yang dipanggil adalah
     * TIPE OBJECT, bukan tipe variabel
     *
     * “Object menentukan behavior, bukan reference”
     *
     * Contoh Simpel
     * A r;
     * r = new B();
     * r.callme();
     *
     * Walaupun r bertipe A
     * Tapi objectnya B
     * Maka yang dipanggil = method milik B
     */

// class A (parent)
class AA {

    void callMe() {
        System.out.println("Inside A's callme method");
    }
}

// class B turunan dari class A
class BB extends AA {

    @Override
    void callMe() {
        System.out.println("Inside B's callme method");
    }
}

// class C turunan dari class A
class CC extends AA {

    @Override
    void callMe() {
        System.out.println("Inside C's callme method");
    }
}

public class DynamicMethodDispatch {
    public static void main(String[] args) {

        // membuat objek dari berbagai class
        AA a = new AA();
        BB b = new BB();
        CC c = new CC();

        // mendeklarasikan variabel class (reference) dari class A (Parent)
        AA r;

        r = a;
        r.callMe();

        r = b;
        r.callMe();

        r = c;
        r.callMe();

        /**
         * Output
         * Inside A's callme method
         * Inside B's callme method
         * Inside C's callme method
         *
         * Bedah Step-by-Step
         * 1. Class A
         * void callme()
         * method default
         *
         * 2. Class B & C
         * void callme()
         * override method dari A
         *
         * 3. Ini Bagian Penting
         * A r;
         * reference bertipe A
         *
         * 4. Kasus 1
         * r = a;
         * r.callme();
         * object = A
         * output:
         * Inside A's callme method
         *
         * 5. Kasus 2
         * r = b;
         * r.callme();
         *
         * reference = A
         * object = B
         * output:
         * Inside B's callme method
         *
         * 6. Kasus 3
         * r = c;
         * r.callme();
         * output:
         * Inside C's callme method
         */

        /**
         * Kenapa Ini Powerful?
         *
         * Bayangin tanpa dynamic dispatch:
         * Semua bakal manggil method A
         * Override jadi gak ada gunanya
         *
         * Tapi dengan ini:
         * Satu reference bisa punya banyak behavior
         *
         * Kenapa Disebut “Dynamic”?
         * Karena:
         * Diputuskan saat program jalan (runtime)
         * Bukan saat compile
         *
         * Hubungan ke Polymorphism
         * Dynamic Dispatch = implementasi:
         * Runtime Polymorphism
         *
         * Kesimpulan Inti (WAJIB NGENA)
         * Override → bikin versi baru method
         * Dynamic dispatch → milih method saat runtime
         * Yang menentukan = object
         * Ini dasar dari polymorphism
         */

    }
}
