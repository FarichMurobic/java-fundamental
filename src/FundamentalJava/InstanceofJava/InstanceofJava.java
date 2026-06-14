package FundamentalJava.InstanceofJava;

/**
 * Using instanceof
 *
 * Kadang kita perlu tahu:
 * tipe asli object saat program berjalan (runtime)
 *
 * Contoh:
 * Thread A bikin berbagai object
 * Thread B nerima & proses object itu
 *
 * Thread B perlu tahu:
 * “ini object tipe apa sih?”
 *
 * Masalah Casting
 *
 * Di Java:
 * Casting yang salah = error saat runtime
 *
 * Contoh:
 * Ada superclass: A
 * Subclass: B dan C
 *
 * Legal:
 * B → A
 * C → A
 *
 * Tidak legal:
 * B → C
 * C → B
 *
 * Problemnya:
 * Kalau kita punya:
 * A obj;
 *
 * Kita gak tahu:
 * ini A asli?
 * atau B?
 * atau C?
 *
 * Kalau langsung dipaksa cast:
 * C c = (C) obj;
 *
 * Bisa error 
 *
 * Solusinya: instanceof
 * Digunakan untuk cek:
 * object ini bisa jadi tipe tertentu atau tidak
 *
 * Bentuk Umum
 * objref instanceof Type
 *
 * Hasil:
 * true → bisa jadi tipe itu
 * false → tidak bisa
 *
 * Kenapa instanceof Penting?
 *
 * Dipakai kalau:
 * Object datang dari luar (API, thread, input)
 * Lu gak yakin tipe aslinya
 * Mau casting dengan aman
 *
 * Contoh Aman
 * if(obj instanceof C) {
 *     C c = (C) obj; // aman
 * }
 *
 * Tanpa ini:
 * C c = (C) obj; // bisa error
 *
 * ---------------------------------------
 * 
 * Kesimpulan Santai
 * instanceof = cek tipe object saat runtime
 * Dipakai buat:
 * hindari error casting
 * ngecek tipe object dinamis
 * Penting di:
 * polymorphism
 * OOP kompleks
 * multithread / generic system
 *
 * Insight Level Atas
 * Semua object di Java adalah turunan:
 * Object
 *
 * Makanya:
 * a instanceof Object // selalu true
 */

class A {
    int i, j;
}

class B {
    int i, j;
}

class C extends A {
    int k;
}

class D extends A {
    int k;
}

public class InstanceofJava {
    public static void main(String[] args) {
        
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();

        if (a instanceof A)
            System.out.println("a is instcanceof A");

        if (b instanceof B)
            System.out.println("b is instanceof B");

        if (c instanceof C)
            System.out.println("c is instanceof C");

        if (c instanceof A)
            System.out.println("c can be cast to A");

        System.out.println();

        // compare types of derived types
        A ob;

        ob = d; // A reference ke D
        System.out.println("ob now refers to d");

        if (ob instanceof D)
            System.out.println("ob is instance of D");

        System.out.println();

        ob = c; // A reference ke C
        System.out.println("ob now refers to c");

        if (ob instanceof D) {
            System.out.println("ob can be cast to D");
        } else {
            System.out.println("ob cannot be cast to D");
        }

        if (ob instanceof A)
            System.out.println("ob can be cast to A");

        System.out.println();

        // semua objek turunan Object
        if (a instanceof Object)
            System.out.println("a may be cast to Object");
        if (b instanceof Object)
            System.out.println("b may be cast to Object");
        if (c instanceof Object)
            System.out.println("c may be cast to Object");
        if (d instanceof Object)
            System.out.println("d may be cast to Object");

        /**
         * Penjelasan (Bagian Penting)
         *
         * 1. Basic Check
         * if(c instanceof A)
         *
         * Kenapa TRUE?
         * Karena:
         * C adalah turunan A
         *
         * Jadi:
         * C bisa dianggap sebagai A
         *
         * 2. Ini FALSE
         * if(a instanceof C)
         *
         * Kenapa?
         * A bukan turunan C
         *
         * Jadi gak bisa
         *
         * Bagian Paling Penting (Polymorphism)
         * A ob;
         * ob = d;
         *
         * Ini:
         * tipe variabel: A
         * isi sebenarnya: D
         *
         * Cek:
         * if(ob instanceof D)
         *
         * TRUE
         * karena isi aslinya memang D
         *
         * Ganti:
         * ob = c;
         *
         * sekarang isi: C
         *
         * Cek:
         * if(ob instanceof D)
         *
         * FALSE
         * karena sekarang bukan D lagi
         *
         * -----------------------------------
         * 
         * Kenapa instanceof Penting?
         *
         * Dipakai kalau:
         * Object datang dari luar (API, thread, input)
         * Lu gak yakin tipe aslinya
         * Mau casting dengan aman
         *
         * Contoh Aman
         * if(obj instanceof C) {
         *     C c = (C) obj; // aman
         * }
         *
         * Tanpa ini:
         * C c = (C) obj; // bisa error
         *
         * Kesimpulan Santai
         * instanceof = cek tipe object saat runtime
         * Dipakai buat:
         * hindari error casting
         * ngecek tipe object dinamis
         * Penting di:
         * polymorphism
         * OOP kompleks
         * multithread / generic system
         */

    }

}
