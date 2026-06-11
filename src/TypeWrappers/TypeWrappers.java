package TypeWrappers;

    /**
     * Konsep Dasar: Type Wrappersn
     *
     * Java punya tipe data primitif (simple types) seperti:
     * int
     * double
     * dll
     *
     * Tipe ini bukan object, tujuannya supaya lebih cepat (performanya tinggi).
     *
     * Kalau semua pakai object:
     * bakal ada overhead (beban tambahan memori & proses)
     * bahkan perhitungan sederhana jadi lambat
     *
     * Makanya:
     * Primitive bukan bagian dari Object
     * Primitive tidak mewarisi (inherit) Object
     *
     * Bayangin gini bro:
     * Tipe	        Ibarat
     * int	        angka polos
     * Integer	    angka tapi dibungkus kotak (object)
     *
     * Primitive = cepat, ringan
     * Object = fleksibel, bisa masuk ke sistem Java yang berbasis object
     *
     * Masalah yang Muncul
     *
     * Kadang kita BUTUH object, contohnya:
     * Primitive gak bisa dikirim by reference ke method
     * Struktur data Java (kayak ArrayList) cuma bisa simpan object
     *
     * Solusinya: Type Wrapper
     *
     * Apa Itu Type Wrapper?
     * Type wrapper adalah class yang membungkus (encapsulate) tipe primitif menjadi object.
     *
     * Contoh:
     * int → Integer
     * double → Double
     * dll
     *
     * Daftar Wrapper
     * Primitive	        Wrapper
     * int	                Integer
     * double	            Double
     * float	            Float
     * long	                Long
     * short	            Short
     * byte	                Byte
     * char	                Character
     * boolean	            Boolean
     *
     * Intinya
     * Wrapper = versi object dari primitive
     *
     * Character Wrapper
     * Character adalah wrapper untuk char.
     *
     * Constructor:
     * Character(char ch)
     *
     * Ambil nilainya:
     * char charValue()
     *
     * Contoh
     * Character c = new Character('A'); // bungkus char jadi object
     * char huruf = c.charValue();       // ambil lagi isi dalamnya
     *
     * Boolean Wrapper
     * Constructor:
     * Boolean(boolean boolValue)
     * Boolean(String boolString)
     *
     * Kalau pakai String:
     * "true" → true
     * selain itu → false
     *
     * Ambil nilai:
     * boolean booleanValue()
     *
     * Contoh
     * Boolean b1 = new Boolean(true);
     * Boolean b2 = new Boolean("true");
     * Boolean b3 = new Boolean("false");
     *
     * System.out.println(b1.booleanValue()); // true
     *
     * Numeric Wrappers
     * Wrapper angka:
     * Byte
     * Short
     * Integer
     * Long
     * Float
     * Double
     *
     * Semua turunan dari class:
     * Number
     *
     * Method Penting
     *
     * Semua wrapper punya method:
     * byteValue()
     * doubleValue()
     * floatValue()
     * intValue()
     * longValue()
     * shortValue()
     *
     * Buat ubah isi object ke tipe tertentu
     *
     * Contoh
     * Integer i = new Integer(10);
     * double d = i.doubleValue(); // jadi double
     *
     * Constructor Wrapper
     *
     * Contoh Integer:
     * Integer(int num)
     * Integer(String str)
     *
     * Error Penting
     * Integer i = new Integer("abc"); // ERROR
     * Akan muncul:
     * NumberFormatException
     *
     * toString() Override
     * Semua wrapper override toString()
     *
     * Jadi bisa langsung di-print tanpa convert
     *
     * Contoh
     * Integer i = new Integer(100);
     * System.out.println(i); // otomatis jadi string
     *
     * Boxing & Unboxing
     * Proses	    Arti
     * Boxing	    primitive → object
     * Unboxing	    object → primitive
     *
     * Contoh
     * Integer iOb = new Integer(100); // boxing
     * int i = iOb.intValue();         // unboxing
     *
     * sekarang lebih baik:
     * Integer i = 10; // autoboxing (modern)
     *
     * Insight Penting (Biar Level Naik)
     *
     * Kenapa wrapper penting?
     * Dipakai di:
     * ArrayList<Integer>
     * HashMap
     * Collection lainnya
     *
     * Karena:
     * Collection Java = hanya menerima object
     *
     * Kesimpulan Besar
     * Primitive = cepat, tapi terbatas
     * Wrapper = object version dari primitive
     * Digunakan saat butuh fleksibilitas OOP
     * Ada konsep:
     * Boxing
     * Unboxing
     * Ini dasar sebelum masuk ke autoboxing (modern Java)
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
