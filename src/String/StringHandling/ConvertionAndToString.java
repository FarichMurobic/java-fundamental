package String.StringHandling;

/**
 * String Conversion dan toString()
 *
 * Ketika Java mengubah data menjadi bentuk string saat melakukan concatenation,
 * Java melakukannya dengan memanggil method valueOf() dari class String.
 *
 * Method valueOf():
 *
 * punya banyak versi (overloaded)
 * mendukung semua tipe primitif dan juga Object
 *
 * Untuk tipe primitif:
 * valueOf() mengembalikan string yang bisa dibaca manusia dari nilai tersebut
 *
 * Untuk object:
 * valueOf() akan memanggil method toString() pada object tersebut
 *
 * Setiap class di Java punya method toString() karena diwarisi dari class dasar Object.
 * Namun, implementasi default toString() biasanya tidak berguna.
 * Maka dari itu, untuk class yang kita buat sendiri, kita biasanya override toString().
 *
 * Bentuk umum method:
 *
 * String toString()
 *
 * Untuk mengimplementasikannya:
 * cukup return string yang menjelaskan object tersebut secara jelas
 *
 * Dengan override toString():
 * object bisa dipakai di print() / println()
 * bisa dipakai di concatenation (+)
 *
 * -----------------------------------
 * 
 * Kesimpulan Simpel
 *
 * valueOf() digunakan saat konversi ke String
 * Untuk object → panggil toString()
 *
 * Semua class punya toString()
 * Tapi default-nya jelek 
 *
 * Harus override kalau:
 * class buatan sendiri
 * object penting
 *
 * toString() otomatis dipanggil saat:
 * println()
 * concatenation (+)
 *
 * --------------------------------------------
 * 
 * Insight Backend (INI YANG REAL BANGET)
 * Logging
 * log.info("User: " + user);
 *
 * kalau gak override:
 * User: User@1a2b3c
 *
 * useless
 *
 * Kalau override:
 * User: id=1, name=Farich
 *
 * langsung jelas
 *
 * Debugging
 * System.out.println(order);
 *
 * kalau bagus:
 * cepat ngerti state object
 *
 * API / DTO
 *
 * Kadang:
 * object di-print
 * object di-log
 *
 * toString() bantu banget
 *
 * INTI DALAM
 *
 * toString() = cara object “berbicara ke manusia”
 * Override = wajib untuk class penting
 * Ini bikin code lo:
 *
 * lebih readable
 * lebih debuggable
 * lebih profesional
 */

// Override toString() for Box class.
class Box {
    double width;
    double height;
    double depth;

    Box(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    @Override
    public String toString() {
        return "Dimension are " + width + " by " + depth + " by " + height + ".";
    }
}

public class ConvertionAndToString {
    public static void main(String[] args) {

        Box boxB = new Box(10, 12, 14);

        String string = "Box b: " + boxB; // concatenate Box object
        // Sama dengan
        String str = "Box B: " + boxB.toString();


        System.out.println(boxB); // convert Box to string
        // Sama dengan
        System.out.println(boxB.toString());
        System.out.println(string);
        // Sama dengan
        System.out.println(string.toString());

        // Penjelasan:
        // Java otomatis memanggil b.toString()

        /**
         * 1. Alur di balik layar (INI PENTING BANGET)
         *
         * Misal:
         * System.out.println(b);
         *
         * Java ubah jadi:
         * System.out.println(b.toString());
         *
         * Atau:
         * "Box: " + b
         *
         * Java ubah jadi:
         * "Box: " + b.toString()
         *
         * 2. valueOf() → toString()
         * "Hello " + obj
         *
         * Java lakukan:
         * String.valueOf(obj)
         * → obj.toString()
         *
         * 3. Default toString() jelek
         *
         * Kalau lo gak override:
         * class Box {}
         * System.out.println(new Box());
         *
         * output:
         * Box@1a2b3c
         *
         * itu:
         * nama class
         * hashcode
         *
         * gak berguna buat manusia
         *
         * 4. Override = bikin object “bermakna”
         * public String toString() {
         *     return "Box ukuran: " + width;
         * }
         *
         * sekarang object punya representasi yang jelas
         *
         * 5. Kenapa ini penting di backend?
         * karena object sering:
         * di-log
         * dikirim ke response
         * di-debug
         *
         * Kalau gak override:
         * lo bakal bingung lihat output
         *
         * 6. toString() = representasi manusia
         *
         * Bukan untuk:
         * logic
         * parsing
         *
         * tapi untuk:
         * debugging
         * display
         */
    }
}
