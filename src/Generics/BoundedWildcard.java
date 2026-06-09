package Generics;

/**
 * INTI KONSEP BESAR
 *
 * Sebelumnya lu udah tau:
 * Stats<?>
 *
 * artinya:
 * bebas tipe apa aja
 *
 * Masalahnya:
 * Kadang kita gak mau terlalu bebas
 *
 * kita mau:
 * fleksibel 
 * tapi tetap dibatasi 
 *
 * Solusi:
 * Bounded Wildcard
 *
 * CONTOH STRUKTUR KELAS DIBAWAH
 * 
 * Artinya:
 * TwoD → x, y
 * ThreeD → x, y, z
 * FourD → x, y, z, t
 *
 * GENERIC CLASS
 * Artinya:
 * T minimal harus TwoD
 * atau turunannya
 *
 * METHOD PERTAMA (WILDCARD BIASA)
 * 
 * Kenapa ini aman?
 * Karena:
 * semua turunan TwoD pasti punya:
 * X, Y
 *
 * Jadi:
 * Coords<TwoD> 
 * Coords<ThreeD> 
 * Coords<FourD> 
 *
 * MASALAH BARU
 * Kita mau bikin:
 * tampilkan X, Y, Z
 *
 * Masalah:
 * TwoD gak punya z
 *
 * Jadi gak bisa pakai:
 * Coords<?>
 *
 * SOLUSI: BOUNDED WILDCARD (extends)
 * Artinya:
 * <? extends ThreeD>
 *
 * "boleh tipe apa aja ASAL:
 * ThreeD
 * atau turunannya"
 *
 * Jadi yang boleh:
 * Coords<ThreeD> 
 * Coords<FourD> 
 *
 * Yang gak boleh:
 * Coords<TwoD> 
 *
 * METHOD PALING SPESIFIK
 * hanya:
 * Coords<FourD> 
 *
 * INTI PALING PENTING (WAJIB NGENA)
 * 
 * 1. ? extends X
 *
 * artinya:
 * X atau turunannya
 *
 * 2. Digunakan saat:
 * kita mau AKSES data (read)
 *
 * 3. Semakin ke bawah:
 * makin spesifik
 * makin terbatas
 *
 * Method	    Batas	    Bisa pakai
 * showXY	    bebas	    semua
 * showXYZ	    ThreeD	    3D & 4D
 * showAll	    FourD	    hanya 4D
 *
 * -----------------------------------------------------
 * 
 * ANALOGI PALING GAMPANG
 *
 * Bayangin:
 * Tanpa batas
 * semua koordinat
 *
 * extends ThreeD
 * hanya koordinat yang punya Z
 *
 * extends FourD
 * hanya koordinat yang punya T
 *
 * KESIMPULAN 
 * 
 * 1. Wildcard bisa dibatasi
 * 2. Upper bound:
 *    <? extends Class>
 *    ambil data (read)
 *
 * 3. Lower bound:
 *    <? super Class>
 *    isi data (write)
 *
 * 4. Ini dipakai di dunia kerja banget
 * Contoh real:
 * List<? extends Number>
 * List<? super Integer>
 */

// CONTOH PENGGUNAAN BOUNDED WILDCARD
// Koordinat 2 dimensi
class TwoD {
    int x, y;

    TwoD(int a, int b) {
        this.x = a;
        this.y = b;
    }
}

// Koordinat 3 dimensi - turunan dari TwoD
class ThreeD extends TwoD {
    int z;

    ThreeD(int a, int b, int c) {
        super(a, b);
        this.z = c;
    }
}

// Koordinat 4 dimensi - turunan dari ThreeD
class FourD extends ThreeD {
    int t;

    FourD(int a, int b, int c, int d) {
        super(a, b, c);
        this.t = d;
    }
}

// Class generic untuk menyimpan array koordinat
// EXTENDS TwoD
class Coords<T extends TwoD> {
    T[] coords;

    // konstruktor menerima array kordinat
    Coords(T[] o) {
        coords = o;
    }
}

public class BoundedWildcard {

    // Menampilkan koordinat X dan Y (semua tipe boleh)
    static void showXY(Coords<?> c) {
        System.out.println("X Y Coordinates:");
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println(c.coords[i].x + " " +
                               c.coords[i].y);
        }
        System.out.println();
    }

    // Menampilkan koordinat X, Y, Z (minimal ThreeD)
    static void showXYZ(Coords<? extends ThreeD> c) { // BOUNDED WILDCARD
        System.out.println("X Y Z Coordinates:");
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println(c.coords[i].x + " " +
                               c.coords[i].y + " " +
                               c.coords[i].z);
        }
        System.out.println();
    }

    // Menampilkan semua koordinat (X, Y, Z, T) (hanya FourD)
    static void showAll(Coords<? extends FourD> c) { // BOUNDED WILDCARD
        System.out.println("X Y Z T Coordinates:");
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println(c.coords[i].x + " " +
                               c.coords[i].y + " " +
                               c.coords[i].z + " " +
                               c.coords[i].t);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Data TwoD
        TwoD twoD[] = {
                new TwoD(0,0),
                new TwoD(7,9),
                new TwoD(18,4),
                new TwoD(-1,-23)
        };

        Coords<TwoD> tdlocs = new Coords<TwoD>(twoD);

        System.out.println("Contens of tdlocs.");
        showXY(tdlocs);
        // showXYZ(tdlocs); // error tidak punya z
        // showAll(tdlocs); // error tidak punya t

        // Data FourD
        FourD fourD[] = {
                new FourD(1,2,3,4),
                new FourD(6,8,14,8),
                new FourD(22,9,4,9),
                new FourD(3,-2,-23,17)
        };

        Coords<FourD> fdlocs = new Coords<FourD>(fourD);

        System.out.println("Contens of fdlocs.");
        // SEMUA VALID
        showXY(fdlocs);
        showXYZ(fdlocs);
        showAll(fdlocs);

    }

}
