package Generics;

/**
 * instanceof bisa dipakai di generic class
 * Tapi TIDAK bisa cek tipe spesifik generic (kayak <Integer>)
 *
 * PENJELASAN PALING PENTING (INI INTINYA)
 * 1. Kenapa pakai <?> ?
 * iOb2 instanceof Gen2<?>
 *
 * Artinya:
 * “Apakah iOb2 adalah Gen2 dengan tipe APAPUN?”
 *
 * Bisa Integer
 * Bisa String
 * Bisa Double
 *
 * Jadi wildcard = “gue gak peduli tipe dalamnya”
 *
 * Kenapa ini berhasil?
 * iOb2 instanceof Gen<?>
 *
 * Karena:
 * Gen2 itu turunan dari Gen
 * Jadi otomatis dia “juga Gen”
 *
 * ----------------------------------------------
 * 
 * KESIMPULAN 
 * instanceof cuma cek class-nya, bukan tipe generic
 * Gunakan <?> kalau mau cek generic
 * Generic info hilang saat runtime (type erasure)
 * Ini alasan kenapa Java generics beda sama C++
 *
 * REAL DI DUNIA KERJA
 * 
 * Ini sering kejadian:
 * if(obj instanceof List<?>) {
 *    // aman
 * }
 *
 * TAPI:
 * if(obj instanceof List<String>) // gak boleh
 *
 * INTI YANG HARUS NANCEP
 *
 * Generics itu:
 * kuat di compile-time
 * hilang di runtime
 */

class One<T> {
    T ob;

    One(T ob) {
        this.ob = ob;
    }

    T ambil() {
        return ob;
    }
}

class Two<T> extends One<T> {
    
    Two(T ob) {
        super(ob);
    }
}

public class InstanceOfGeneric {
    public static void main(String[] args) {

        One<Integer> ob1 = new One<>(20);
        Two<Integer> ob2 = new Two<>(50);

        Two<String> stringTwo = new Two<>("Test");

        // CEK APKAKAH OB2 ADALAH TWO (TIPE APAPUN)
        if (ob2 instanceof Two<?>) {
            System.out.println("ob2 is instance Two");
        }

        // CEK APKAKAH OB2 ADALAH ONE (TIPE APAPUN)
        if (ob2 instanceof One<?>) {
            System.out.println("ob2 is instance One");
        }

        System.out.println();

        // ob1 bukan Two
        if (ob1 instanceof Two<?>) // false
            System.out.println("ob1 adalah instance Two");

        if (ob1 instanceof One<?>) // true
            System.out.println("ob1 adalah instance One");

        if (ob2 instanceof Two<Integer>) // true
            System.out.println("ob2 adalah instance Two<Integer>");

        if (stringTwo instanceof Two<String>) // true
            System.out.println("stringtwo instance Two<String>");

        // INI AKAN ERROR
        // if (ob2 instanceof Two<String>) KARENA OB2 ADALAH INTEGER
        //    System.out.println("INI HARUSNYA GAK MASUK!");

    }
}
