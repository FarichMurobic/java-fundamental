package Generics;

/**
 * Generic Interface = interface yang punya type parameter
 *
 * Artinya:
 * method di dalam interface bisa kerja untuk banyak tipe data
 * tapi tetap aman (type-safe)
 *
 * BEDAH PELAN (INI INTI BANGET)
 * 1. Interface Generic
 * interface MinMax<T extends Comparable<T>>
 *
 * Artinya:
 * T = tipe data
 * harus punya kemampuan dibandingkan (Comparable)
 *
 * Kenapa Comparable?
 * Karena kita pakai:
 * compareTo()
 *
 * tanpa Comparable → ERROR
 *
 * --------------------------------------------------------
 * 
 * IMPLEMENTASI INTERFACE
 * Ini bagian penting:
 * class MyClass<T extends Comparable<T>> implements MinMax<T>
 *
 * Artinya:
 * MyClass juga harus generic
 * dan harus pakai constraint yang sama
 *
 * karena:
 * interface minta:
 * T extends Comparable<T>
 *
 * LOGIKA MIN & MAX
 * MIN:
 * if(vals[i].compareTo(v) < 0)
 *
 * artinya:
 * kalau lebih kecil → jadi min baru
 *
 * MAX:
 * if(vals[i].compareTo(v) > 0)
 *
 * artinya:
 * kalau lebih besar → jadi max baru
 *
 * KENAPA BISA UNTUK INTEGER & CHAR?
 * Ini kuncinya:
 * T extends Comparable<T>
 *
 * karena:
 * Integer  implement Comparable
 * Character  implement Comparable
 *
 * jadi bisa dipakai
 *
 * ERROR YANG SERING TERJADI
 * SALAH:
 * class MyClass implements MinMax<T>
 *
 * ERROR:
 * T gak dikenal
 *
 * SALAH:
 * implements MinMax<T extends Comparable<T>>
 *
 * gak boleh ulang constraint di sini
 *
 * SALAH:
 * MyClass<StringBuilder>
 *
 * ERROR:
 * StringBuilder gak implement Comparable
 *
 * -------------------------------------------
 * 
 * VERSI NON-GENERIC (BIAR NGERTI PERBEDAAN)
 * 
 * Tanpa generic:
 * harus pakai Object
 * harus casting
 * rawan error
 *
 * Dengan generic:
 * aman
 * rapi 
 * reusable
 *
 * KESIMPULAN 
 * 
 * 1. Generic interface = interface pakai type parameter
 *
 * 2. Bisa kasih batasan:
 * <T extends Something>
 *
 * 3. Class yang implement:
 * harus ikut generic juga
 * atau kasih tipe fix
 *
 * 4. Keuntungan:
 * reusable
 * type-safe
 * fleksibel
 */

interface MinMax<T extends Comparable<T>> {
    T min();
    T max();
}

class MyClass<T extends Comparable<T>> implements MinMax {

    T[] vals;

    MyClass(T[] o) {
        vals = o;
    }

    // Mengembalikan nilai minimum
    public T min() {
        T v = vals[0];
        for (int i = 1; i < vals.length; i++) {
            if (vals[1].compareTo(v) < 0) {
                v = vals[i];
            }
        }
        return v;
    }

    // Mengembalikan nilai maksimum
    public T max() {
        T v = vals[0];
        for (int i = 1; i < vals.length; i++) {
            if (vals[i].compareTo(v) > 0) {
                v = vals[i];
            }
        }
        return v;
    }
}

public class GenericInterface {
    public static void main(String[] args) {
        
        Integer inums[] = {9,6,3,2,5,8,7,1,4};
        Character chas[] = {'n', 'e', 'j', 'r', 'a'};

        MyClass<Integer> iob = new MyClass<Integer>(inums);
        MyClass<Character> cob = new MyClass<Character>(chas);

        System.out.println("Max value in inums: " + iob.max()); // 9
        System.out.println("Min value in inums: " + iob.min()); // 6

    }
}
