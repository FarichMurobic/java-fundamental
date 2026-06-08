package ClassAndObject;

/*

Secara umum, ada dua cara bahasa pemrograman mengirim argument ke subroutine (method).

1️ Call-by-Value
Nilai dari argument disalin (copy) ke parameter method.
Artinya:
perubahan pada parameter tidak mempengaruhi nilai asli.

2️ Call-by-Reference
Yang dikirim bukan nilainya, tetapi referensi ke argument tersebut.
Artinya:
perubahan pada parameter akan mempengaruhi nilai asli.

Namun di Java, semua argument sebenarnya dikirim menggunakan:
call-by-value

Tetapi efeknya berbeda tergantung tipe datanya:
Tipe Data	    Perilaku
Primitive	    benar-benar copy nilai
Object	        copy reference

Primitive Type → Passed by Value
Jika method menerima primitive type, maka Java membuat salinan nilai.

Sekarang: Object sebagai Parameter
Jika yang dikirim adalah object, situasinya berbeda.

Kenapa?

Karena variabel object sebenarnya menyimpan reference (alamat memory).

Contoh:
Test ob = new Test(15,20)
Variabel ob sebenarnya hanya menyimpan alamat object.

Java selalu call-by-value.

----------------------------------------------------------------------

Tapi ada dua kasus:

Primitive
Yang dicopy:
nilai

Contoh:
int x = 5

Object
Yang dicopy:
reference

Contoh:
Box ref → alamat object

Ketika reference object dikirim ke method, reference tersebut tetap dikirim menggunakan call-by-value.

Artinya:
reference dicopy
Tetapi karena copy tersebut menunjuk object yang sama:
object tetap berubah

Visualisasi Memory
Primitive
a = 15
b = 20

method dipanggil
i = 15
j = 20

i dan j adalah copy.

Object
ob ─────► object
           a=15
           b=20

Method dipanggil:
o ─────► object yang sama
Karena menunjuk object yang sama, perubahan terjadi pada object asli.

Ketika reference object dikirim ke method, reference tersebut tetap dikirim menggunakan call-by-value.
Artinya:
reference dicopy
Tetapi karena copy tersebut menunjuk object yang sama:
object tetap berubah

---------------------------------------------------------------

Tips penting untuk programmer Java
Kalau lu ingin object tidak berubah, biasanya digunakan:
copy constructor
immutable object
clone object

*/

// CONTOH PRIMITIVE
class CallValuePrimitive {

    void meth(int i, int j) {
        i *= 2;
        j /= 2;

        System.out.println(i);
        System.out.println(j);
    }
}

// CONTOH OBJECT
class CallValueObject {
    
    int a, b;

    CallValueObject(int i, int j) {
        this.a = i;
        this.b = j;
    }

    // OBJECT AS PARAMETER
    void meth(CallValueObject o) {
        o.a *= 2;
        o.b /= 2;

        System.out.println(o.a);
        System.out.println(o.b);
    }
}

public class CallByValue {
    public static void main(String[] args) {
        
        // CONTOH PRIMITIVE
        CallValuePrimitive typePrimitive = new CallValuePrimitive();

        int a = 15, b = 20;
        // Before call the method meth()
        System.out.println(a + " " + b); // a 15 b 20

        // After call the method meth()
        typePrimitive.meth(a, b); // a 30 b 10

        // Panggil lagi a dan b setelah method dipanggil
        // Nilai asli tidak berubah
        System.out.println(a + " " + b); // a 15 b 20

        /**
         * Output
         * 15 20
         * 30
         * 10
         * 15 20
         *
         * Penjelasan Kode
         * Method:
         * void meth(int i, int j)
         * Parameter:
         * i
         * j
         * 
         * Ketika dipanggil:
         * ob.meth(a,b);
         *
         * Java membuat copy nilai:
         * i = 15
         * j = 20
         *
         * Alur Program
         * Nilai awal
         * a = 15
         * b = 20
         *
         * Method dipanggil
         * i = 15
         * j = 20
         *
         * Operasi di dalam method
         * i *= 2 → 30
         * j /= 2 → 10
         *
         * Tetapi yang berubah hanya:
         * i dan j
         * Bukan:
         * a dan b
         *
         * Setelah method selesai
         * Nilai asli tetap:
         * a = 15
         * b = 20
         */

        System.out.println("-----------------------------");

        // CONTOH OBJECT
        CallValueObject typeObject = new CallValueObject(15, 20);

        // Sebelum panggil method meth()
        System.out.println(typeObject.a + " " + typeObject.b); // a 15 b 20

        // Panggil method
        typeObject.meth(typeObject); // a 30 b 10

        // Sesudah method meth() dipanggil
        // Nilai asli berubah
        System.out.println(typeObject.a + " " + typeObject.b); // a 30 b 10

        /**
         * Output
         * 15 20
         * 30
         * 10
         * 30 10
         *
         * Alur Program
         * Membuat object
         * typeObject → object
         * a = 15
         * b = 20
         *
         * Memanggil method
         * typeObject.meth(ob)
         *
         * Java copy reference.
         * Jadi parameter:
         * o → menunjuk object yang sama
         *
         * Di dalam method
         * o.a *= 2 → 30
         * o.b /= 2 → 10
         *
         * Karena o menunjuk object yang sama dengan objek.
         * Maka object asli berubah.
         *
         * Setelah method selesai
         * typeObject.a = 30
         * typeObject.b = 10
         */
    }
}
