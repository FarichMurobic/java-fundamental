package ClassAndObject;

        /**
         * Assigning Object Reference Variables
         *
         * Variable reference object berperilaku berbeda dari yang biasanya kita bayangkan ketika dilakukan assignment.
         * Contoh:
         * Box b1 = new Box();
         * Box b2 = b1;
         *
         * Banyak orang berpikir bahwa:
         * b2 mendapatkan salinan object dari b1
         * 
         * Sehingga:
         * b1 → object A
         * b2 → object B (copy) 
         *
         * Tetapi itu salah.
         *
         * Yang sebenarnya terjadi adalah:
         * b1 → object A
         * b2 → object A
         *
         * Artinya:
         * b1 dan b2 menunjuk object yang sama
         *
         * Assignment tersebut:
         * -tidak membuat object baru
         * -tidak menyalin object
         * -hanya menyalin reference
         *
         * Misalnya kita buat object:
         * Box b1 = new Box();
         *
         * Memory kira-kira seperti ini:
         * b1 ───► [ Box Object ]
         *
         * Sekarang kita lakukan:
         * Box b2 = b1;
         *
         * Memory berubah menjadi:
         * b1 ──►
         *        [ Box Object ]
         * b2 ──►
         *
         * Jadi:
         * b1 dan b2 menunjuk object yang sama
         *
         * Ini disebut:
         * reference sharing atau aliasing
         *
         * ----------------------------------------------
         * 
         * Buku menekankan:
         * ketika reference object di-assign,
         * yang disalin adalah reference,
         * bukan object
         *
         * atau dengan kata lain:
         * copy reference
         * bukan copy object
         *
         * Kesimpulan Penting
         *
         * Kalau object:
         * b2 = b1
         * yang dicopy adalah:
         * reference
         * bukan object.
         *
         * Sedangkan primitive:
         * b = a
         *
         * yang dicopy adalah:
         * value
         *
         * object hanya hilang jika tidak ada reference yang menunjuknya.
         * Nanti Java garbage collector yang membersihkan.
         *
         * --------------------------------------------------------------
         * 
         * Inti Penting Bagian Ini :
         * 1️ Object variable adalah reference
         * 2️ Assignment object menyalin reference
         * 3️ Tidak ada copy object
         * 4️ Dua reference bisa menunjuk object yang sama
         * 5️ null berarti tidak menunjuk object
         */

class ReferenceObject {
    String nama;
    String usia;
    String city;

    ReferenceObject(String nama, String usia, String city) {
        this.nama = nama;
        this.usia = usia;
        this.city = city;
    }

    void biodata() {
        System.out.println("Nama: " + nama);
        System.out.println("Usia: " + usia);
        System.out.println("City: " + city);
    }
}

public class VariableReferenceObject {
    public static void main(String[] args) {

        // Membuat reference object1
        ReferenceObject object1 = new ReferenceObject("Farich Murobic", "27", "California");
        object1.biodata();

        // Membaut reference object2
        // Reference object2 dan object1 menunjuk ke object yang sama di memory
        ReferenceObject object2 = object1;

        // CEK REFERENCE
        // cek object1
        if (object1 instanceof ReferenceObject) // TRUE
            System.out.println("True");
        else {
            System.out.println("False");
        }

        // cek object2
        if (object2 instanceof ReferenceObject) { // TRUE
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        // Karena menunjuk ke memory yang sama
        // hasilnya sama dengan object1
        object2.biodata();

        System.out.println("-----------------");

        object1.nama = "JANERA";
        System.out.println(object1.nama); // JANERA
        System.out.println(object2.nama); // JANERA

        /**
         * Output:
         * JANERA
         *
         * Kenapa? Karena:
         * object1 dan object2 = object yang sama
         */

        // Mengubah Lewat Reference object2
        object2.nama = "Murobic";
        System.out.println(object1.nama); // Murobic
        System.out.println(object2.nama); // Murobic

        // Ketika Reference Diputus
        object1 = null;
        // System.out.println(object1.nama); // Exception in thread "main" java.lang.NullPointerException
        System.out.println(object2.nama); // object2 Masih aman

        // Cek object1
        // Sekarang false
        // Karena null
        if (object1 instanceof ReferenceObject) { 
            System.out.println(true);
        } else {
            System.out.println(false);
        }

         /**
         * Kenapa object2 Masih Bisa Dipakai
         * Karena memory masih seperti ini:
         * 
         * Memory menjadi:
         * object1 → null
         * object2 ───► [ Box Object ]
         *
         * Artinya:
         * object1 tidak lagi menunjuk object
         * tetapi object masih ada
         * karena object2 masih menunjuknya
         *
         * Jadi:
         * System.out.println(object2.nama);
         * masih aman.
         *
         * -------------------------------------
         * 
         * Apa Itu null
         * null artinya:
         * tidak menunjuk object apa pun
         *
         * Contoh:
         * Box b1 = null;
         *
         * Artinya:
         * b1 → tidak menunjuk object
         *
         * Jika kita lakukan:
         * b1.width = 10;
         *
         * akan terjadi error:
         * NullPointerException
         */

         System.out.println("----------------------------");

         // Perbandingan dengan primitive
         int a = 10;
         int b = a;

         System.out.println(a); // 10
         System.out.println(b); // 10

         b = 20;
         System.out.println(a); // 10
         System.out.println(b); // 20

         /**
         * Primitive
         * int a = 10;
         * int b = a;
         *
         * Memory:
         * a = 10
         * b = 10
         *
         * Jika:
         * b = 20;
         *
         * hasilnya:
         * a = 10
         * b = 20
         *
         * Karena primitive benar-benar di-copy.
         * atau membuat object baru
         */
        
    }
}
