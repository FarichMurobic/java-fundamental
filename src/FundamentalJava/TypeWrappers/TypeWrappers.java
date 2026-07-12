package FundamentalJava.TypeWrappers;

/**
 * ------------------------------------------------------------------------
 * KONSEP DASAR: TYPE WRAPPERS
 * ------------------------------------------------------------------------
 * 
 * Java memiliki tipe data primitif (simple types) seperti:
 * - int
 * - double
 * - boolean
 * - char
 * - dll
 * 
 * Tipe ini BUKAN object.
 * Tujuannya: supaya lebih cepat (performanya tinggi).
 * 
 * Kalau semua pakai object:
 * - Ada overhead (beban tambahan memori & proses)
 * - Bahkan perhitungan sederhana jadi lambat
 * 
 * Makanya:
 * - Primitive bukan bagian dari Object
 * - Primitive tidak mewarisi (inherit) Object
 * 
 * ------------------------------------------------------------------------
 * ANALOGI BIAR KEBAYANG
 * ------------------------------------------------------------------------
 * 
 * Tipe           | Ibarat
 * ---------------|------------------------------------------
 * int            | Angka polos (tanpa bungkus)
 * Integer        | Angka tapi dibungkus kotak (object)
 * 
 * Primitive = cepat, ringan
 * Object = fleksibel, bisa masuk ke sistem Java yang berbasis object
 * 
 * ------------------------------------------------------------------------
 * MASALAH YANG MUNCUL
 * ------------------------------------------------------------------------
 * 
 * Kadang kita BUTUH object, contohnya:
 * 
 * 1. Primitive tidak bisa dikirim by reference ke method
 * 2. Struktur data Java (seperti ArrayList) hanya bisa menyimpan object
 * 3. Generic hanya bekerja dengan object, bukan primitive
 * 
 * ------------------------------------------------------------------------
 * SOLUSI: TYPE WRAPPER
 * ------------------------------------------------------------------------
 * 
 * Type wrapper adalah class yang membungkus (encapsulate)
 * tipe primitif menjadi object.
 * 
 * Contoh:
 * int → Integer
 * double → Double
 * 
 * ------------------------------------------------------------------------
 * DAFTAR WRAPPER
 * ------------------------------------------------------------------------
 * 
 * Primitive     | Wrapper Class
 * --------------|------------------------------------------
 * int           | Integer
 * double        | Double
 * float         | Float
 * long          | Long
 * short         | Short
 * byte          | Byte
 * char          | Character
 * boolean       | Boolean
 * 
 * ------------------------------------------------------------------------
 * NUMERIC WRAPPERS
 * ------------------------------------------------------------------------
 * 
 * Wrapper angka:
 * - Byte
 * - Short
 * - Integer
 * - Long
 * - Float
 * - Double
 * 
 * Semua turunan dari class:
 * Number
 * 
 * ------------------------------------------------------------------------
 * METHOD PENTING DI NUMERIC WRAPPERS
 * ------------------------------------------------------------------------
 * 
 * Semua wrapper numerik memiliki method untuk konversi:
 * 
 *     byteValue()      → byte
 *     doubleValue()    → double
 *     floatValue()     → float
 *     intValue()       → int
 *     longValue()      → long
 *     shortValue()     → short
 * 
 * Contoh:
 * 
 *     Integer i = new Integer(10);
 *     double d = i.doubleValue();   // 10.0
 *     float f = i.floatValue();     // 10.0f
 *     long l = i.longValue();       // 10L
 * 
 * ------------------------------------------------------------------------
 * CONSTRUCTOR WRAPPER
 * ------------------------------------------------------------------------
 * 
 * Setiap wrapper memiliki constructor:
 * 
 * Integer:
 *     Integer(int num)
 *     Integer(String str)
 * 
 * Double:
 *     Double(double num)
 *     Double(String str)
 * 
 * Contoh:
 * 
 *     Integer i1 = new Integer(100);
 *     Integer i2 = new Integer("200");
 * 
 *     Double d1 = new Double(3.14);
 *     Double d2 = new Double("3.14");
 * 
 * ERROR PENTING!
 * 
 *     Integer i = new Integer("abc");  // NumberFormatException!
 * 
 * ------------------------------------------------------------------------
 * CHARACTER WRAPPER
 * ------------------------------------------------------------------------
 * 
 * Character adalah wrapper untuk char.
 * 
 * Constructor:
 *     Character(char ch)
 * 
 * Method:
 *     char charValue()
 * 
 * Contoh:
 * 
 *     Character c = new Character('A');
 *     char huruf = c.charValue();   // 'A'
 * 
 * ------------------------------------------------------------------------
 * BOOLEAN WRAPPER
 * ------------------------------------------------------------------------
 * 
 * Boolean adalah wrapper untuk boolean.
 * 
 * Constructor:
 *     Boolean(boolean boolValue)
 *     Boolean(String boolString)
 * 
 * Aturan String ke boolean:
 * - "true" → true (case insensitive)
 * - Selain "true" → false
 * 
 * Method:
 *     boolean booleanValue()
 * 
 * Contoh:
 * 
 *     Boolean b1 = new Boolean(true);
 *     Boolean b2 = new Boolean("true");
 *     Boolean b3 = new Boolean("false");
 *     Boolean b4 = new Boolean("TRUE");   // true
 *     Boolean b5 = new Boolean("abc");    // false
 * 
 *     System.out.println(b1.booleanValue()); // true
 *     System.out.println(b2.booleanValue()); // true
 *     System.out.println(b3.booleanValue()); // false
 * 
 * ------------------------------------------------------------------------
 * toString() OVERRIDE
 * ------------------------------------------------------------------------
 * 
 * Semua wrapper meng-override method toString().
 * 
 * Jadi bisa langsung di-print tanpa convert manual.
 * 
 * Contoh:
 * 
 *     Integer i = new Integer(100);
 *     System.out.println(i);  // Otomatis jadi "100"
 * 
 * ------------------------------------------------------------------------
 * BOXING DAN UNBOXING (MANUAL)
 * ------------------------------------------------------------------------
 * 
 * Proses         | Arti
 * ---------------|------------------------------------------
 * Boxing         | Primitive → Object (manual)
 * Unboxing       | Object → Primitive (manual)
 * 
 * Contoh (cara lama):
 * 
 *     // Boxing
 *     Integer iOb = new Integer(100);   // int → Integer
 * 
 *     // Unboxing
 *     int i = iOb.intValue();           // Integer → int
 * 
 * ------------------------------------------------------------------------
 * CONTOH LENGKAP
 * ------------------------------------------------------------------------
 * 
 *     public class TypeWrapperDemo {
 *         public static void main(String[] args) {
 *             // Boxing - primitive ke wrapper
 *             Integer iOb = new Integer(42);
 *             Double dOb = new Double(3.14);
 *             Character cOb = new Character('A');
 *             Boolean bOb = new Boolean(true);
 * 
 *             // Unboxing - wrapper ke primitive
 *             int i = iOb.intValue();
 *             double d = dOb.doubleValue();
 *             char c = cOb.charValue();
 *             boolean b = bOb.booleanValue();
 * 
 *             System.out.println("int: " + i);
 *             System.out.println("double: " + d);
 *             System.out.println("char: " + c);
 *             System.out.println("boolean: " + b);
 * 
 *             // Konversi antar tipe
 *             double fromInt = iOb.doubleValue();
 *             long fromDouble = dOb.longValue();
 * 
 *             System.out.println("int → double: " + fromInt);
 *             System.out.println("double → long: " + fromDouble);
 *         }
 *     }
 * 
 * ------------------------------------------------------------------------
 * KENAPA WRAPPER PENTING?
 * ------------------------------------------------------------------------
 * 
 * Wrapper digunakan di:
 * - ArrayList<Integer>
 * - HashMap<String, Integer>
 * - Collection Framework lainnya
 * - Generics
 * 
 * Karena:
 * Collection Java hanya menerima OBJECT, bukan PRIMITIVE.
 * 
 * ------------------------------------------------------------------------
 * INSIGHT PENTING (LEVEL UP)
 * ------------------------------------------------------------------------
 * 
 * Primitive    | Wrapper
 * -------------|------------------------------------------
 * Cepat        | Fleksibel
 * Ringan       | Bisa digunakan di Collection
 * Bukan object | Adalah object (turunan Object)
 * 
 * ------------------------------------------------------------------------
 * KESIMPULAN BESAR
 * ------------------------------------------------------------------------
 * 
 * 1. Primitive = cepat, tapi terbatas
 * 2. Wrapper = versi object dari primitive
 * 3. Digunakan saat butuh fleksibilitas OOP
 * 4. Ada konsep:
 *    - Boxing (primitive → object)
 *    - Unboxing (object → primitive)
 * 5. Ini adalah dasar sebelum autoboxing (Java 5+)
 * 
 * ------------------------------------------------------------------------
 */

public class TypeWrappers {
    public static void main(String[] args) {

        // Integer iob = new Integer(100); // cara lama, udah gak bisa sejak jdk 9

        // cara baru boxing
        // Membungkus (boxing) nilai 100 ke dalam object Integer
        Integer a = 100;

        // Mengambil nilai dari object (unboxing)
        int i = a.intValue();

        // i = 100 (primitive)
        // iOb = 100 (object, tapi auto jadi string)
        System.out.println(i + " " + a);

        System.out.println();

        Integer angkaObj = 50;
        System.out.println("Object angka: " + angkaObj);

        int angkaPrim = angkaObj.intValue();
        System.out.println("Primitive angka: " + angkaPrim);

    }
}
