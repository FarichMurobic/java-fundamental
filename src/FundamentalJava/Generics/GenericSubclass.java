package FundamentalJava.Generics;

/**
 * Class biasa (non-generic) BOLEH jadi parent dari class generic
 *
 * Artinya:
 * Parent: biasa aja (gak ada <T>)
 * Child: boleh generic (<T>)
 *
 * Ini kebalik dari sebelumnya (yang parent generic)
 *
 * ---------------------------------------------
 * 
 * PENJELASAN DALAM 
 * 
 * Struktur class
 * NonGen   (biasa)
 *    ↑
 * Gen<T>   (generic)
 *
 * Parent: gak tau apa-apa soal generics
 * Child: punya generic sendiri
 *
 * Perhatikan ini:
 * class Gen<T> extends NonGen
 *
 * Kenapa gak ada <T> di NonGen?
 *
 * Karena:
 * NonGen bukan generic
 * Jadi gak bisa dikasih tipe
 *
 * Ini beda sama kasus sebelumnya:
 * class Gen2<T> extends Gen<T>
 *
 * ALUR DATA DI OBJECT
 * Gen<String> w = new Gen<>("Hello", 47);
 *
 * Maka:
 * T = String
 * ob = "Hello"
 * num = 47
 *
 * Saat dipanggil:
 * w.getob()   → "Hello"
 * w.getnum()  → 47
 *
 * KENAPA INI VALID?
 *
 * Karena:
 * Generic cuma milik class itu sendiri
 *
 * Parent:
 * gak peduli tipe apa
 *
 * Child:
 * bebas punya generic sendiri
 *
 * ------------------------------------------
 * 
 * PERBEDAAN DUA KASUS (WAJIB PAHAM)
 *
 * CASE 1: Parent Generic
 * class A<T>
 * class B<T> extends A<T>
 *
 * WAJIB terusin <T>
 *
 * CASE 2: Parent NON-Generic
 * class A
 * class B<T> extends A
 *
 * GAK PERLU <T> di parent
 *
 * ------------------------------------------------
 * 
 * KESIMPULAN 
 * 
 * Generic class bisa turunan dari class biasa
 * Parent gak perlu tau soal <T>
 * Generic cuma berlaku di subclass
 * Inheritance tetap jalan normal
 *
 * REAL DI DUNIA KERJA
 * Ini sering banget bro
 *
 * Contoh real:
 * class BaseEntity { int id; }
 *
 * class Response<T> extends BaseEntity {
 *     T data;
 * }
 *
 * Parent: common data
 * Child: flexible data (generic)
 */

// superclass biasa
class Father {
    int num;

    Father(int i) {
        num = i;
    }

    int ambilNilai() {
        return num;
    }
}

// subclass Generic
class Son<T> extends Father {
    T ob;

    Son(T a, int i) {
        super(i);
        ob = a;
    }

    T ambilT() {
        return ob;
    }
}

public class GenericSubclass {
    public static void main(String[] args) {
        
        // T STRING
        Son<String> object1 = new Son<String>("Janera Farich M.u", 22);

        System.out.println(object1.ambilT()); // DARI SON
        System.out.println(object1.ambilNilai()); // DARI FATHER

    }
}
