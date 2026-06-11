package String.StringBuffer;

/**
 * append()
 *
 * Method append() menggabungkan representasi string dari tipe data lain ke bagian akhir objek StringBuffer yang memanggilnya.
 * Method ini memiliki beberapa versi (overloading). Berikut beberapa bentuknya:
 * StringBuffer append(String str)
 * StringBuffer append(int num)
 * StringBuffer append(Object obj)
 *
 * Representasi string dari setiap parameter akan diambil, biasanya dengan memanggil String.valueOf().
 * Hasilnya kemudian ditambahkan ke objek StringBuffer saat ini.
 *
 * 1. Apa itu append()?
 * Fungsi:
 * Nambahin data ke akhir StringBuffer
 *
 * Contoh simpel:
 * StringBuffer sb = new StringBuffer("Hello");
 * sb.append(" World");
 *
 * Hasil:
 * "Hello World"
 *
 * 2. Bisa nerima banyak tipe data
 * sb.append("Hello");  // String
 * sb.append(10);       // int
 * sb.append(3.14);     // double
 * sb.append(true);     // boolean
 * sb.append(obj);      // object
 *
 * Semua akan diubah jadi string otomatis
 *
 * Di balik layar
 * Java melakukan ini:
 * String.valueOf(data)
 *
 * Jadi:
 * sb.append(42);
 *
 * sebenarnya:
 * sb.append("42");
 *
 * 3. Method Chaining (INI YANG KEREN)
 * Karena append() return:
 * StringBuffer
 *
 * lo bisa nulis:
 * sb.append("A").append("B").append("C");
 *
 * hasil:
 * "ABC"
 *
 * Kenapa pakai toString()?
 *
 * Karena:
 * StringBuffer ≠ String
 * Kalau mau jadi string biasa → pakai:
 * sb.toString();
 *
 * Kenapa append() penting banget?
 *
 * Bandingin:
 * String biasa:
 * String s = "";
 * s = s + "Hello";
 * s = s + " World";
 *
 * bikin object baru terus
 *
 * StringBuffer:
 * StringBuffer sb = new StringBuffer();
 * sb.append("Hello");
 * sb.append(" World");
 *
 * 1 object aja 
 *
 * Kesimpulan (versi nempel keras)
 * append() = nambah data ke akhir buffer
 * Bisa nerima banyak tipe data
 * Return object sendiri → bisa chaining
 * Lebih efisien dari String
 *
 * Inti banget:
 * append() = cara paling cepat & efisien buat bangun string di Java
 */

public class Append {
    public static void main(String[] args) {

        // Membuat string biasa
        String string;
        int a = 42;

        // Membuat StringBuffer dengan kapasitas 40
        StringBuffer stringBuffer = new StringBuffer(40);

        // append chaining - berantai
        // Method chaining:
        // 1. append("a = ")
        // 2. append(a) → otomatis jadi "42"
        // 3. append("!")
        // 4. toString() → ubah ke String biasa
        string = stringBuffer.append("a = ").append(a).append("!").toString();

        System.out.println(string); // a = 42!

        System.out.println("------------------");

        StringBuffer sb = new StringBuffer();
        sb.append("Nama: ")
                .append("Farich")
                .append(", Umur: ")
                .append(20)
                .append(", Status: ")
                .append(true);
        System.out.println(sb.toString());

    }
}
