package FundamentalJava.Methods.MethodReference;

/*
 * ============================================================
 * Comparator dan Method Reference Pada Java
 * ============================================================
 *
 * Ketika kita ingin mencari nilai terbesar atau melakukan sorting
 * pada collection yang berisi object, Java membutuhkan aturan
 * bagaimana object tersebut dibandingkan..
 *
 * Untuk tujuan tersebut Java menyediakan interface:
 *
 * Comparator<T>
 *
 * Comparator digunakan untuk menentukan cara membandingkan dua
 * object.
 *
 * ------------------------------------------------------------
 * Collections.max()
 * ------------------------------------------------------------
 *
 * Method:
 *
 * Collections.max()
 *
 * digunakan untuk mencari object dengan nilai terbesar dalam
 * sebuah collection.
 *
 * Contoh:
 *
 * Collections.max(list, comparator);
 *
 *
 * Parameter kedua membutuhkan:
 *
 * Comparator<T>
 *
 *
 * Karena Java perlu tahu:
 *
 * "Bagaimana cara menentukan object mana yang lebih besar?"
 *
 * ------------------------------------------------------------
 * Apa Itu Comparator?
 * ------------------------------------------------------------
 *
 * Comparator adalah functional interface yang digunakan untuk
 * membandingkan dua object.
 *
 * Bentuk method utamanya:
 *
 * int compare(T a, T b)
 *
 *
 * Method ini harus mengembalikan nilai integer.
 *
 * Aturan return:
 *
 * Jika:
 *
 * a.compareTo(b) < 0
 *
 * Artinya:
 *
 * a dianggap lebih kecil dari b.
 *
 *
 * Jika:
 *
 * a.compareTo(b) == 0
 *
 * Artinya:
 *
 * a dianggap sama dengan b.
 *
 *
 * Jika:
 *
 * a.compareTo(b) > 0
 *
 * Artinya:
 *
 * a dianggap lebih besar dari b.
 *
 *
 * Jadi:
 *
 * nilai negatif  -> a lebih kecil
 * nilai nol      -> sama
 * nilai positif  -> a lebih besar
 *
 * ------------------------------------------------------------
 * Cara Lama Sebelum Java 8
 * ------------------------------------------------------------
 *
 * Sebelum Java 8, biasanya kita membuat class Comparator sendiri.
 *
 * Contoh:
 *
 * class MyComparator implements Comparator<MyClass> {
 *
 *     @Override
 *     public int compare(MyClass a, MyClass b) {
 *         return a.value - b.value;
 *     }
 * }
 *
 *
 * Kemudian:
 *
 * Collections.max(list, new MyComparator());
 *
 *
 * Kekurangan:
 *
 * - Banyak kode tambahan.
 * - Harus membuat class baru.
 * - Kurang praktis untuk perbandingan sederhana.
 *
 * ------------------------------------------------------------
 * Cara Modern Java 8+
 * ------------------------------------------------------------
 *
 * Java 8 memperkenalkan:
 *
 * - Lambda expression.
 * - Method reference.
 *
 *
 * Sehingga Comparator dapat dibuat lebih singkat.
 *
 * Contoh:
 *
 * Collections.max(
 *     list,
 *     MyClass::compareMC
 * );
 *
 *
 * Method reference:
 *
 * MyClass::compareMC
 *
 *
 * secara otomatis digunakan sebagai implementasi Comparator.
 *
 * ------------------------------------------------------------
 * Kenapa Method Reference Bisa Menjadi Comparator?
 * ------------------------------------------------------------
 *
 * Karena Comparator adalah functional interface.
 *
 * Comparator memiliki satu abstract method:
 *
 * compare(T a, T b)
 *
 *
 * Jika kita memiliki method dengan bentuk:
 *
 * static int compareMC(MyClass a, MyClass b)
 *
 *
 * Maka:
 *
 * MyClass::compareMC
 *
 *
 * cocok dengan:
 *
 * (a, b) -> MyClass.compareMC(a, b)
 *
 *
 * Sehingga Java dapat menggunakannya sebagai Comparator.
 *
 * ------------------------------------------------------------
 * Insight Penting
 * ------------------------------------------------------------
 *
 * Dahulu:
 *
 * Membuat class Comparator manual.
 *
 *
 * Sekarang:
 *
 * Gunakan lambda atau method reference.
 *
 *
 * Contoh:
 *
 * Comparator<MyClass> comparator =
 *         MyClass::compareMC;
 *
 *
 * Lebih:
 *
 * - Singkat.
 * - Mudah dibaca.
 * - Mengurangi boilerplate code.
 *
 * ------------------------------------------------------------
 * Cara Modern Yang Lebih Sering Dipakai
 * ------------------------------------------------------------
 *
 * Dalam project nyata, biasanya kita tidak membuat method
 * compare sendiri.
 *
 * Java sudah menyediakan:
 *
 * Comparator.comparing()
 *
 *
 * Contoh:
 *
 * MyClass max =
 *     Collections.max(
 *         list,
 *         Comparator.comparing(MyClass::getVal)
 *     );
 *
 *
 * Artinya:
 *
 * "Bandingkan object berdasarkan nilai yang dikembalikan oleh
 * getVal()."
 *
 *
 * Lambda yang setara:
 *
 * (a, b) ->
 *     a.getVal().compareTo(b.getVal())
 *
 *
 * Untuk object angka:
 *
 * Comparator.comparingInt(MyClass::getVal)
 *
 * lebih disarankan.
 *
 * ------------------------------------------------------------
 * Menggunakan Stream API
 * ------------------------------------------------------------
 *
 * Pada Java modern, sering digunakan bersama Stream API.
 *
 * Contoh:
 *
 * MyClass max =
 *     list.stream()
 *         .max(
 *             Comparator.comparing(MyClass::getVal)
 *         )
 *         .orElse(null);
 *
 *
 * Alur:
 *
 * List
 *  |
 *  v
 * Stream
 *  |
 *  v
 * max()
 *  |
 *  v
 * Comparator menentukan object terbesar
 *
 * ------------------------------------------------------------
 * Contoh Dunia Nyata
 * ------------------------------------------------------------
 *
 * Misalnya terdapat list User:
 *
 * List<User> users;
 *
 *
 * Mencari user dengan umur terbesar:
 *
 * User oldest =
 *     users.stream()
 *          .max(
 *              Comparator.comparing(User::getAge)
 *          )
 *          .orElse(null);
 *
 *
 * Java akan:
 *
 * - Memanggil getAge() setiap object.
 * - Membandingkan hasilnya.
 * - Mengambil object dengan nilai terbesar.
 *
 * ------------------------------------------------------------
 * Kesimpulan
 * ------------------------------------------------------------
 *
 * Comparator adalah aturan untuk membandingkan object.
 *
 * Konsep penting:
 *
 * - Collections.max() membutuhkan Comparator.
 * - Comparator menentukan object mana yang lebih besar.
 * - Method reference dapat digunakan sebagai Comparator karena
 *   Comparator adalah functional interface.
 * - Java 8+ mengurangi kebutuhan membuat class Comparator manual.
 * - Comparator.comparing() adalah gaya yang umum digunakan dalam
 *   project modern.
 *
 * Prinsip sederhana:
 *
 * "Berikan Java cara membandingkan object,
 * lalu Java yang menangani proses pencarian atau sorting."
 *
 */

import java.util.*;

// Class data (model)
class MyClass {
    private int val;

    public MyClass(int v) {
        this.val = v;
    }

    public int getVal() {
        return val;
    }
}

public class MethodReferenceWithComparator {

    // Method pembanding (Comparator logic)
    static int compareMc(MyClass a, MyClass b) {
        // Jika a > b → positif
        // Jika a < b → negatif
        return a.getVal() - b.getVal();
    }

    public static void main(String[] args) {

        // Buat list
        ArrayList<MyClass> list = new ArrayList<>();
        list.add(new MyClass(1));
        list.add(new MyClass(4));
        list.add(new MyClass(2));
        list.add(new MyClass(9));
        list.add(new MyClass(3));

        // METHOD REFERENCE DIGUNAKAN DI SINI
        MyClass max = Collections.max(list, MethodReferenceWithComparator::compareMc);
        System.out.println("Nilai terbesar: " + max.getVal());

    }
}
