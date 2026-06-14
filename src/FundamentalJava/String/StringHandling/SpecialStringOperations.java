package FundamentalJava.String.StringHandling;

/**
 * Special String Operations
 *
 * Karena string adalah bagian yang sangat umum dan penting dalam pemrograman,
 * Java menyediakan dukungan khusus untuk beberapa operasi string langsung di dalam sintaks bahasa.
 *
 * Operasi ini meliputi:
 * pembuatan otomatis objek String dari string literal
 * penggabungan string menggunakan operator +
 * konversi tipe data lain menjadi string
 *
 * Sebenarnya ada method khusus untuk semua operasi ini,
 * tapi Java melakukannya secara otomatis untuk memudahkan programmer dan membuat kode lebih jelas.
 *
 * String Literals
 * Contoh sebelumnya menunjukkan bagaimana membuat String secara eksplisit menggunakan new.
 * Namun, ada cara yang lebih mudah yaitu menggunakan string literal.
 * Untuk setiap string literal dalam program, Java secara otomatis membuat objek String.
 *
 * Contoh:
 * char chars[] = { 'a', 'b', 'c' };
 * String s1 = new String(chars);
 * String s2 = "abc"; // string literal
 *
 * s1 dan s2 menghasilkan string yang sama.
 *
 * Karena string literal otomatis menjadi objek String, kamu bisa menggunakannya di mana saja seperti object biasa.
 * Contoh:
 * System.out.println("abc".length());
 *
 * Ini akan mencetak 3.
 *
 * Apa itu String Literal?
 * "Hello"
 *
 * ini bukan cuma teks
 * ini adalah object String yang dibuat otomatis oleh Java
 *
 * Perbedaan Besar: Literal vs new
 * Cara manual:
 * String s1 = new String("abc");
 * Cara literal:
 * String s2 = "abc";
 *
 * Perbedaan penting:
 * Cara	            Memory	            Efisiensi
 * new String()	    object baru	        boros
 * literal	        pakai String Pool	hemat
 *
 * String Pool (INI KUNCI)
 * String a = "abc";
 * String b = "abc";
 *
 * Java gak bikin 2 object
 * cuma 1 object di String Pool
 *
 * String c = new String("abc");
 * ini bikin object baru lagi 
 *
 * Kenapa literal lebih powerful?
 *
 * Karena:
 * otomatis dibuat
 * hemat memory
 * lebih cepat
 * readable
 *
 * Makanya di real-world:
 * hampir selalu pakai litera
 *
 * Method langsung ke literal (INI KEREN)
 * "abc".length()
 *
 * ini valid!
 *
 * Kenapa?
 * karena "abc" = object String
 *
 * Concatenation (+)
 * String s = "Hello" + " World";
 *
 * Java otomatis:
 * gabung string
 * bikin object baru
 *
 * Bahkan bisa gini:
 * String s = "Age: " + 20;
 *
 * 20 diubah jadi String otomatis
 *
 * Auto Conversion (PENTING)
 * int x = 10;
 * String s = "Value: " + x;
 *
 * hasil:
 * "Value: 10"
 *
 * Java diam-diam pakai:
 * String.valueOf(x)
 *
 * Kesimpulan Simpel
 * String literal = cara paling umum & efisien
 * Java otomatis bikin object dari literal
 * Literal disimpan di String Pool
 *
 * Bisa:
 * langsung panggil method
 * pakai operator +
 * auto convert tipe lain ke String
 *
 * Insight Backend (DALAM BANGET)
 * Real case:
 * Logging:
 * log.info("User ID: " + userId);
 * Response:
 * return "Success: " + data;
 *
 * Tapi hati-hati:
 * String s = "";
 * for(int i=0; i<1000; i++){
 *     s += i;
 * }
 *
 * ini bikin banyak object 
 *
 * Solusi:
 * StringBuilder sb = new StringBuilder();
 *
 * Intinya:
 * Literal → untuk data tetap
 * + → oke untuk sederhana
 * StringBuilder → untuk loop / heavy operation
 */

/**
 * String Concatenation
 *
 * Secara umum, Java tidak mengizinkan operator digunakan pada objek String.
 * Satu-satunya pengecualian adalah operator +, yang digunakan untuk menggabungkan (concatenate) dua string,
 * dan menghasilkan objek String sebagai hasilnya.
 * Operator + ini bisa digunakan berantai.
 *
 * Contoh:
 *
 * String age = "9";
 * String s = "He is " + age + " years old.";
 * System.out.println(s);
 *
 * Output:
 * He is 9 years old.
 *
 * Salah satu penggunaan praktis dari concatenation adalah untuk membuat string panjang tanpa harus menulis dalam satu baris panjang.
 *
 * String Concatenation dengan Tipe Data Lain
 * Kamu juga bisa menggabungkan string dengan tipe data lain.
 *
 * Contoh:
 * int age = 9;
 * String s = "He is " + age + " years old.";
 * System.out.println(s);
 *
 * Walaupun age adalah int, hasilnya tetap sama.
 *
 * Karena:
 * int otomatis dikonversi ke String
 * lalu digabungkan
 *
 * Perhatian: Operator Precedence
 * Contoh:
 * String s = "four: " + 2 + 2;
 * System.out.println(s);
 *
 * Output:
 * four: 22
 *
 * bukan:
 * four: 4
 *
 * Kenapa?
 * Karena:
 * "four: " + 2 dilakukan dulu → "four: 2"
 * lalu "four: 2" + 2 → "four: 22"
 *
 * Cara benar:
 * String s = "four: " + (2 + 2);
 *
 * Output:
 * four: 4
 *
 * 1. + di String itu “khusus”
 *
 * Normalnya:
 * 2 + 2 = 4
 *
 * Tapi kalau ada String:
 * "2" + 2 = "22"
 *
 * + berubah fungsi jadi penggabung string
 *
 * 2. Cara kerja di balik layar
 * String s = "A" + "B" + "C";
 *
 * sebenarnya Java ubah jadi:
 * new StringBuilder()
 *     .append("A")
 *     .append("B")
 *     .append("C")
 *     .toString();
 *
 * Ini penting:
 * + = syntactic sugar
 * di balik layar pakai StringBuilder
 *
 * 3. Chaining (+ berantai)
 * "He is " + age + " years old"
 *
 * urutannya:
 * "He is " + age
 * hasil + " years old"
 *
 * 4. Auto conversion (lagi, tapi penting)
 * "Age: " + 10
 *
 * jadi:
 * "Age: " + "10"
 *
 * 5. Operator precedence (INI SERING BANGET KENA)
 * "four: " + 2 + 2
 *
 * Java baca dari kiri ke kanan
 *
 * Breakdown:
 * "four: " + 2 → "four: 2"
 * "four: 2" + 2 → "four: 22"
 *
 * 6. Parentheses = kontrol urutan
 * "four: " + (2 + 2)
 *
 * jadi:
 * "four: " + 4 → "four: 4"
 *
 * 7. Concatenation vs Performance
 * String s = "";
 * for(int i=0; i<1000; i++){
 *     s += i;
 * }
 *
 * ini:
 * bikin object terus-terusan
 * lambat
 *
 * Solusi:
 * StringBuilder sb = new StringBuilder();
 *
 * Kesimpulan Simpel
 * + adalah satu-satunya operator untuk String
 * Bisa chaining (berantai)
 * Bisa auto convert tipe lain
 *
 * Hati-hati:
 * urutan operasi (precedence)
 * bisa bikin hasil tak terduga
 *
 * Gunakan () untuk kontrol hasil
 *
 * Insight Backend (INI YANG SERING KEJADIAN)
 * Logging bug:
 * log.info("Total: " + a + b);
 *
 * bisa jadi:
 * Total: 23
 *
 * padahal:
 * Total: 5
 *
 * Fix:
 * log.info("Total: " + (a + b));
 *
 * Query / Response bug:
 * return "Result: " + x + y;
 *
 * bisa salah hasil
 *
 * Performance:
 * Loop besar:
 * s += i;
 *
 * hindari
 *
 * Pakai:
 * StringBuilder
 */

public class SpecialStringOperations {
    public static void main(String[] args) {

        // 1. Literal vs Constructor

        // Cara manual (tidak efisien)
        char chars[] = {'a','b','c'};
        String string1 = new String(chars);

        // Cara literal (lebih direkomendasikan)
        String string2 = "abc";

        System.out.println(string1);
        System.out.println(string2);

        // Penjelasan:
        // s1 dan s2 punya isi sama
        // tapi s2 lebih efisien (pakai String Pool)

        // 2. Method langsung dari literal

        // Memanggil method langsung dari string literal
        int length = "abc".length();
        System.out.println(length);

        // Penjelasan:
        // "abc" adalah object String
        // jadi bisa langsung dipanggil methodnya

        // 3. Concatenation (+)
        String string3 = "Hallo" + " World";
        System.out.println(string3);

        // Penjelasan:
        // Java menggabungkan dua string
        // hasil: "Hello World"

        // 4. Auto Conversion
        int age = 20;

        // int otomatis diubah jadi String
        String string4 = "Age: " + age;
        System.out.println(string4);

        // Penjelasan:
        // age (int) di-convert ke String
        // hasil: "Age: 20"

        // 5. String Pool Proof
        String string5 = "abc";
        String string6 = "abc";

        // Bandingkan reference
        System.out.println(string5 == string6);

        // Penjelasan:
        // true karena keduanya menunjuk ke object yang sama di String Pool

        System.out.println();

        // CONCATENATION

        // 1. Basic Concatenation

        String age1 = "9";
        // Menggabungkan beberapa string
        String s = "He is " + age1 + " years old.";
        System.out.println(s);

        // Penjelasan:
        // String digabung menggunakan operator +
        // hasil: "He is 9 years old."

        // 2. String Panjang

        // Membagi string panjang jadi beberapa bagian
        String longStr = "This could have been " +
                "a very long line that would have " +
                "wrapped around. But string concatenation " +
                "prevents this.";

        System.out.println(longStr);

        // Penjelasan:
        // Ini membantu agar kode tetap rapi dan readable

        // 3. Dengan Tipe Data Lain

        int age2 = 9;
        // int otomatis dikonversi ke String
        String s1 = "He is " + age2 + " years old.";
        System.out.println(s1);

        // Penjelasan:
        // age (int) → "9"
        // lalu digabung

        // 4. Operator Precedence (BUG UMUM)

        String s3 = "four: " + 2 + 2;
        System.out.println(s3);

        // Penjelasan:
        // "four: " + 2 = "four: 2"
        // "four: 2" + 2 = "four: 22"

        // 5. Solusi dengan Parentheses
        String s4 = "four: " + (2 + 2);
        System.out.println(s4);

        // Penjelasan:
        // (2 + 2) dihitung dulu → 4
        // lalu digabung → "four: 4"
    }
}
