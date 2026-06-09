package Generics;

/**
 * APA ITU GENERIC METHOD?
 *
 * Intinya:
 * Method yang punya type parameter sendiri
 *
 * Bedanya:
 * Generic class
 * class Box<T> { }
 * T berlaku untuk seluruh class
 *
 * Generic method
 * <T> void method(T x) { }
 * T hanya berlaku di method itu saja
 *
 * ---------------------------------------------
 * 
 * KENAPA HARUS RIBET BEGINI?
 * 
 * Tanpa generic method:
 * gak aman
 *
 * Dengan ini:
 * Java memastikan:
 * tipe cocok 
 * gak bisa salah 
 * error ditangkap saat compile 
 *
 * CONTOH PROSES DI BELAKANG LAYAR
 * 
 * Ini:
 * isIn(2, nums)
 *
 * Java otomatis:
 * T = Integer
 * V = Integer
 *
 * Ini:
 * isIn("two", strs)
 *
 * Java otomatis:
 * T = String
 * V = String
 *
 * Ini ERROR:
 * isIn("two", nums)
 *
 * karena:
 * T = String
 * V = Integer 
 *
 * --------------------------------------------------
 * 
 * TYPE INFERENCE (INI KEREN BANGET)
 * 
 * Java otomatis tebak tipe
 *
 * Lu gak perlu nulis:
 * GenMethDemo.<Integer, Integer>isIn(2, nums);
 *
 * cukup:
 * isIn(2, nums);
 *
 * ini namanya:
 * Type Inference
 *
 * ANALOGI BIAR NGERTI
 *
 * Bayangin:
 * Tanpa generic method
 * fungsi cuma bisa satu tipe
 *
 * Dengan generic method
 * fungsi bisa:
 * cari Integer 
 * cari String 
 * cari Object 
 *
 * ---------------------------------------------------
 * 
 * SYNTAX UMUM (WAJIB HAFAL)
 * 
 * <type-param> returnType methodName(parameters)
 * Contoh:
 * <T> void print(T x)
 *
 * Multiple:
 * <T, V> void method(T a, V b)
 *
 * KESIMPULAN 
 * 
 * 1. Generic method = method punya type sendiri
 * 2. Ditulis sebelum return type
 *    <T> void method()
 * 3. Bisa pakai bound
 *    <T extends Something>
 * 4. Bisa lebih dari satu tipe
 *    <T, V>
 * 5. Type otomatis ditebak (type inference)
 * 6. Keuntungan:
 * reusable
 * aman
 * fleksibel
 *
 * Generic method bikin:
 * 1 method → bisa semua tipe
 */

class GenericMethods {

    // 1
    // Method generic untuk mengecek apakah suatu method ada di dalam array
    static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
        for (int i = 0; i < y.length; i++) {
            if (x.equals(y[i])) {
                return true;
            }
        }
        return false;
    }

    // SINGLE WKWKWK
    static <T> void print(T data) {
        System.out.println(data);
    }

    // 2 
    // Buat method:  balikin nilai terbesar dari 2 angka
    // pakai comparable
    // method generic untuk mencari nilai terbesar
    static <T extends Comparable<T>> T max(T a, T b) {
        if (a.compareTo(b) > 0) {
            return a;
        } else {
            return b;
        }
    }

    // 3 (ARRAY)
    // Buat method: cek apakah suatu value ada di array
    // Method generic untuk cek apakah value ada di array
    static <T> boolean contains(T x, T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (x.equals(arr[i])) {
                return true;
            }
        }
        return false;
    }

    // 4 (DUA TYPE PARAMETER)
    // Buat method: print 2 data dengan tipe berbeda
    // Method generic dengan dua tipe
    static <T, V> void printDuaData(T a, V b) {
        System.out.println(a);
        System.out.println(b);
    }

    // 5
    // Buat method: cek apakah value ada di array, tapi array boleh subtype dari value
    // Method generic dengan hubungan antar tipe
    static <T, V extends T> boolean isIn(T x, V[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (x.equals(arr[i])) {
                return true;
            }
        }
        return false;
    }

    // 6
    // Buat method: cari nilai terkecil dari array
    // Method generic untuk mencari nilai terkecil
    static <T extends Comparable<T>> T min(T[] arr) {
        T min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(min) < 0) {
                min = arr[i];
            }
        }
        return min;
    }
}

public class GenericMethod {
    public static void main(String[] args) {
        
        // Menggunakan isIn untuk Integer
        Integer[] nums = {1,2,3,4,5};

        if (GenericMethods.isIn(2, nums)) {
            System.out.println("2 ada di nums!");
        }

        if (!GenericMethods.isIn(7, nums)) {
            System.out.println("7 tidak ada di nums");
        }

        System.out.println();

        // Menggunakan isIn() untuk String
        String strs[] = {"one", "two", "three", "four", "five"};

        if (GenericMethods.isIn("two", nums)) {
            System.out.println("two ada di strs");
        }

        if (!GenericMethods.isIn("seven", nums)) {
            System.out.println("seven tidak ada di strs");
        }

        /**
         * if(GenericsMethods.isIn("two", nums)) {
         * System.out.println("two ada di nums");
         * }
         *
         * ini akan error - data tidak kompatibel
         *
         * OUTPUT
         * 2 ada di nums
         * 7 tidak ada di nums
         *
         * two ada di strs
         * seven tidak ada di strs
         */

        /**
         * BEDAH PALING PENTING (INI INTI BANGET)
         * 
         * Method ini:
         * static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y)
         *
         * Pecah satu-satu:
         * 1. <T extends Comparable<T>>
         *
         * Artinya:
         * T harus bisa dibandingkan
         *
         * Contoh:
         * Integer (punya equals & Comparable)
         * String 
         * Object biasa 
         *
         * 2. <V extends T>
         *
         * Artinya:
         * V harus:
         * sama dengan T
         * atau turunan dari T
         *
         * Jadi:
         * T = String
         * V = String 
         * V = Integer 
         *
         * 3. Parameter method
         * T x      // nilai yang dicari
         * V[] y    // array tempat mencari
         */

        System.out.println();
        
        GenericMethods.print("Data");
        GenericMethods.print(22);
        GenericMethods.print("Janera " + 22);

        System.out.println();

        int nilaiInteger = GenericMethods.max(10, 20);
        System.out.println(nilaiInteger);
        double nilaiDouble = GenericMethods.max(3.5,2.1);
        System.out.println(nilaiDouble);

        System.out.println();

        Integer dataArray[] = {1,2,3,4,5};
        String dataString[] = {"apel", "jeruk", "mangga"};

        boolean hasil;
        hasil = GenericMethods.contains(3, dataArray);
        System.out.println(hasil);
        hasil = GenericMethods.contains(7, dataArray);
        System.out.println(hasil);
        hasil = GenericMethods.contains("semangka", dataString);
        System.out.println(hasil);
        hasil = GenericMethods.contains("jeruk", dataString);
        System.out.println(hasil);
        hasil = GenericMethods.contains("Jeruk", dataString);
        System.out.println(hasil);

        System.out.println();

        GenericMethods.printDuaData("Januar June", 22);

        System.out.println();

        Integer angka[] = {25,24,65,74,65};
        boolean apakahAda;
        apakahAda = GenericMethods.isIn(41, angka);
        System.out.println(apakahAda);
        apakahAda = GenericMethods.isIn(25, angka);
        System.out.println(apakahAda);

        System.out.println();
        int nilaiMax = GenericMethods.min(angka);
        System.out.println(nilaiMax);

    }
}
