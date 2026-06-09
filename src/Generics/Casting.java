package Generics;

/**
 * Lu bisa casting antar generic class
 * TAPI dengan syarat:
 *
 * Syarat WAJIB:
 * Class-nya harus compatible (punya hubungan inheritance)
 * Type argument HARUS SAMA
 *
 * CONTOH 
 * VALID (boleh)
 * (Gen<Integer>) iOb2
 *
 * Kenapa boleh?
 *
 * Karena:
 * iOb2 adalah Gen2<Integer>
 * Gen2 itu turunan dari Gen
 * dan type-nya sama: Integer
 *
 * Jadi:
 * Gen2<Integer> → Gen<Integer> 
 *
 * TIDAK VALID
 * (Gen<Long>) iOb2
 *
 * Kenapa error?
 *
 * Karena:
 * iOb2 isinya Integer
 * lu maksa jadi Long
 *
 * Jadi:
 * Integer ≠ Long 
 *
 * -----------------------------------------
 * 
 * PENJELASAN 
 * 
 * Struktur class kita:
 * Gen<T>
 *    ↑
 * Gen2<T>
 *
 * Object:
 * Gen2<Integer> iOb2 = new Gen2<>(99);
 *
 * Maka:
 * T = Integer
 *
 * KASUS 1 (AMAN)
 * Gen<Integer> g = (Gen<Integer>) iOb2;
 *
 * Ini aman karena:
 * child → parent (boleh)
 * type sama (Integer)
 *
 * KASUS 2 (BAHAYA)
 * Gen<Long> g = (Gen<Long>) iOb2;
 *
 * Ini ditolak karena:
 * type beda
 * Java menjaga type safety
 *
 * -------------------------------------------
 * 
 * HUBUNGAN DENGAN ERASURE (DALAM BANGET)
 * 
 * Lu mungkin mikir:
 * "kan generic dihapus di runtime?"
 *
 * BETUL
 *
 * Tapi:
 * Compiler tetap ngecek di compile-time
 *
 * Jadi:
 * Runtime: gak tau <Integer>
 * Compile-time: tau banget
 *
 * Maka:
 * (Gen<Long>) iOb2
 *
 * ditolak dari awal (compile error)
 *
 * -------------------------------
 * 
 * ANALOGI BIAR NGERTI
 *
 * Bayangin:
 * Kotak<Integer>
 * Kotak<Long>
 *
 * Walaupun bentuknya sama
 * Tapi isi beda
 *
 * Lu gak bisa bilang:
 * Kotak apel → Kotak jeruk 
 *
 * PERBEDAAN DENGAN NON-GENERIC
 * 
 * Tanpa generics:
 * Object obj = "Hello";
 * Integer x = (Integer) obj; // lolos compile, crash runtime
 * bahaya
 *
 * Dengan generics:
 * Gen<Integer> a
 * Gen<String> b
 *
 * a = (Gen<Integer>) b; // compile error
 * aman dari awal
 *
 * RULE PALING PENTING
 * BOLEH:
 * Child<T> → Parent<T>
 * GAK BOLEH:
 * Child<Integer> → Parent<Long>
 *
 * -------------------------------------------
 * 
 * CONTOH TAMBAHAN BIAR NGENA
 * 
 * Gen2<String> str = new Gen2<>("Hi");
 *
 * // ini boleh
 * Gen<String> g1 = (Gen<String>) str;
 *
 * // ini ERROR
 * Gen<Integer> g2 = (Gen<Integer>) str;
 *
 * KESIMPULAN SUPER SIMPLE
 *
 * Casting generic hanya boleh kalau:
 *
 * class compatible ✔
 * type sama ✔
 *
 * Kalau type beda:
 * compile error (langsung ketangkep)
 *
 * Ini bikin generics:
 * type-safe banget
 *
 * REAL DI DUNIA KERJA
 *
 * Ini sering kejadian di:
 *
 * Collections
 * API response
 * DTO mapping
 *
 * Makanya generics:
 * mencegah bug sebelum program jalan
 */

class Satu<T> {
    T objek;

    Satu(T objek) {
        this.objek = objek;
    }

    T ambil() {
        return objek;
    }
}

class Dua<T> extends Satu<T> {

    Dua(T a) {
        super(a);
    }
}

public class Casting {
    public static void main(String[] args) {
        
        Satu<Integer> integerSatu = new Satu<>(20);
        Dua<Integer> integerDua = new Dua<>(22);

        // casting Amann
        Satu<Integer> casting = (Satu<Integer>) integerDua;

        // casting Error
        // Dua<Long> casting1 = (Dua<Long>) integerSatu;

        // Object biasa lolos compile tapi error runtime
        Object obj = "Hello";
        Integer x = (Integer) obj; // lolos compile, crash runtime
    }
}
