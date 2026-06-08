package AksesModifier;

/*

Introducing Access Control
Seperti yang sudah kita ketahui, encapsulation menghubungkan data dengan kode yang memanipulasinya.
Namun, encapsulation juga memberikan atribut penting lainnya yaitu access control (pengendalian akses).
Melalui encapsulation, kamu dapat mengontrol bagian mana dari program yang boleh mengakses member dari sebuah class.

Dengan mengontrol akses ini, kamu dapat mencegah penyalahgunaan.
Sebagai contoh, jika data hanya boleh diakses melalui sekumpulan method tertentu yang sudah ditentukan, 
maka penyalahgunaan data bisa dicegah.
Dengan demikian, jika diimplementasikan dengan benar, sebuah class akan menjadi seperti “black box”.

Artinya:
Class tersebut bisa digunakan dari luar
Tetapi cara kerja internalnya tidak bisa diutak-atik sembarangan

Apa itu Access Control?
Access Control adalah aturan siapa yang boleh mengakses variabel atau method di dalam class.

Access Modifier
Bagaimana suatu member dapat diakses ditentukan oleh access modifier yang ditempatkan pada deklarasinya.
Java menyediakan beberapa access modifier yang cukup lengkap.
Beberapa bagian dari access control berkaitan dengan:
Inheritance (pewarisan)
Package (pengelompokan class)

Package pada dasarnya adalah kumpulan class yang dikelompokkan bersama.

Access Modifier di Java
Java memiliki beberapa access modifier:
public
private
protected

Selain itu, Java juga memiliki default access level.
Modifier protected biasanya digunakan ketika inheritance terlibat.

*/

/**
 * Cara Menulis Access Modifier
 * Access modifier ditulis di depan tipe data pada deklarasi member.
 * 
 * Contoh:
 * public int i;
 * private double j;
 * private int myMethod(int a, char b) { ... }
 * 
 * Kesimpulan Penting
 * Access modifier mengontrol siapa yang boleh mengakses member class.
 * 
 * Modifier utama:
 * Modifier	        Akses
 * public	        bisa diakses semua
 * private	        hanya dalam class
 * protected	    untuk inheritance
 * default	        dalam package
 * 
 * Praktik OOP yang baik:
 * variable -> private
 * method -> public
 */

/*

Penjelasan public dan private

Jika member class menggunakan modifier public, maka member tersebut dapat diakses oleh kode apa pun.
Jika member menggunakan modifier private, maka member tersebut hanya dapat diakses oleh member dalam class yang sama.

Sekarang kita bisa mengerti kenapa method main() selalu diawali dengan public.
Karena main() dipanggil oleh Java runtime system, yaitu kode yang berada di luar program kita.

Jika sebuah member tidak memiliki access modifier, maka secara default:
Member tersebut bisa diakses dalam package yang sama
Tetapi tidak bisa diakses dari package lain.

*/

@Anotasi("Anotasi")
@interface Anotasi {
    String value();
}

@Anotasi("Deklarasi class")
class AksesKontrol {

    @Anotasi("Akses Modifier in variabel instance")
    // Contoh program public vs private
    int a; // default akses
    public int b; // public akses
    private int c; // private akses

    @Anotasi("Setter untuk set c (private)")
    // Method untuk mengubah nilai c
    void setC(int i) {
        c = i;
    }

    @Anotasi("Getter untuk ambil nilai c (private)")
    // Method untuk mengambil nilai c
    int getC() {
        return c;
    }
}

public class AksesModifier {
    public static void main(String[] args) {

        @Anotasi("Buat objek AksesKontrol")
        AksesKontrol akses = new AksesKontrol();

        // Mengakses variabel instance
        akses.a = 100;      // a bisa diakses karena default modifier
        akses.b = 500;      // b bida diakses karena public modifier
        // akses.c = 20 0;  // akan error, karena private modifier

        // Akses c harus melalui method
        akses.setC(20);
        
        System.out.println("a: " + akses.a + " b: " + akses.b + " c: " + akses.getC());
    
        /**
         * OUTPUT
         * a: 100 b: 500 c: 20
         */
    }
}
