package FundamentalJava.Annotasi;

/**
 * ---------------------------------------------------------------------------
 * TYPE ANNOTATION (JAVA 8+)
 * ---------------------------------------------------------------------------
 *
 * Sebelum Java 8, annotation umumnya hanya dapat digunakan pada
 * declaration (deklarasi) seperti:
 *
 * - Class
 * - Method
 * - Field
 * - Constructor
 * - Parameter
 *
 * Setelah Java 8, Java memperkenalkan fitur:
 *
 * Type Annotation
 *
 * Fitur ini memungkinkan annotation ditempelkan langsung pada
 * penggunaan tipe data (type usage), bukan hanya pada deklarasi.
 *
 * ---------------------------------------------------------------------------
 * PERBEDAAN SEBELUM DAN SESUDAH JAVA 8
 * ---------------------------------------------------------------------------
 *
 * Sebelum Java 8:
 *
 * @Anno
 * public void method() {}
 *
 * Annotation menempel pada method.
 *
 * Setelah Java 8:
 *
 * public @Anno String method() {}
 *
 * Annotation menempel pada:
 *
 * String -> Tipe Return (Return Type)
 *
 * Dengan kata lain, annotation tidak lagi terbatas pada deklarasi,
 * tetapi juga dapat digunakan pada berbagai penggunaan tipe data.
 *
 * ---------------------------------------------------------------------------
 * SYARAT MENGGUNAKAN TYPE ANNOTATION
 * ---------------------------------------------------------------------------
 *
 * Agar annotation dapat digunakan sebagai Type Annotation,
 * annotation tersebut harus memiliki target:
 *
 * @Target(ElementType.TYPE_USE)
 *
 * Artinya:
 *
 * Annotation boleh digunakan pada seluruh penggunaan tipe data.
 *
 * Contoh:
 *
 * @Target(ElementType.TYPE_USE)
 * @interface TypeAnno {
 * }
 *
 * ---------------------------------------------------------------------------
 * TEMPAT PENGGUNAAN TYPE ANNOTATION
 * ---------------------------------------------------------------------------
 *
 * Type Annotation dapat digunakan pada berbagai lokasi yang
 * melibatkan tipe data.
 *
 * ---------------------------------------------------------------------------
 * 1. RETURN TYPE
 * ---------------------------------------------------------------------------
 *
 * Contoh:
 *
 * public @TypeAnno Integer f2(int a, int b)
 *
 * Annotation menempel pada:
 *
 * Integer -> Tipe Return
 *
 * ---------------------------------------------------------------------------
 * 2. THROWS CLAUSE
 * ---------------------------------------------------------------------------
 *
 * Contoh:
 *
 * void test() throws @TypeAnno NullPointerException
 *
 * Annotation menempel pada:
 *
 * NullPointerException -> Tipe Exception
 *
 * ---------------------------------------------------------------------------
 * 3. CAST EXPRESSION
 * ---------------------------------------------------------------------------
 *
 * Contoh:
 *
 * y = (@TypeAnno Integer) x;
 *
 * Annotation menempel pada:
 *
 * Integer -> Tipe Hasil Cast
 *
 * ---------------------------------------------------------------------------
 * 4. GENERIC TYPE ARGUMENT
 * ---------------------------------------------------------------------------
 *
 * Contoh:
 *
 * TypeAnnoDemo<@TypeAnno Integer> ob;
 *
 * Annotation menempel pada:
 *
 * Integer -> Generic Type Argument
 *
 * ---------------------------------------------------------------------------
 * 5. OBJECT CREATION
 * ---------------------------------------------------------------------------
 *
 * Contoh:
 *
 * new @TypeAnno TypeAnnoDemo<Integer>();
 *
 * Annotation menempel pada:
 *
 * TypeAnnoDemo<Integer> -> Tipe Object Yang Dibuat
 *
 * ---------------------------------------------------------------------------
 * 6. ARRAY TYPE
 * ---------------------------------------------------------------------------
 *
 * Contoh:
 *
 * String @MaxLen(10) [] @NotZeroLen [] w;
 *
 * Annotation dapat ditempelkan pada level array yang berbeda.
 *
 * Hal ini memungkinkan setiap dimensi array memiliki annotation
 * yang berbeda.
 *
 * ---------------------------------------------------------------------------
 * 7. INHERITANCE
 * ---------------------------------------------------------------------------
 *
 * Contoh:
 *
 * class A extends @TypeAnno B {}
 *
 * Annotation menempel pada:
 *
 * B -> Tipe Superclass
 *
 * ---------------------------------------------------------------------------
 * 8. RECEIVER PARAMETER (this)
 * ---------------------------------------------------------------------------
 *
 * Contoh:
 *
 * public int f(@TypeAnno MyClass this, int x)
 *
 * Annotation menempel pada:
 *
 * MyClass -> Receiver Parameter (this)
 *
 * Fitur ini termasuk penggunaan yang lebih lanjut (advanced) dan
 * jarang digunakan dalam pemrograman sehari-hari.
 *
 * ---------------------------------------------------------------------------
 * HAL PENTING YANG HARUS DIPAHAMI
 * ---------------------------------------------------------------------------
 *
 * Arti sebuah annotation sangat dipengaruhi oleh @Target yang
 * dimilikinya.
 *
 * Contoh:
 *
 * @TypeAnno String str;
 *
 * Jika:
 *
 * @Target(ElementType.TYPE_USE)
 *
 * Maka annotation diterapkan pada:
 *
 * String -> Tipe Data
 *
 * ---------------------------------------------------------------------------
 *
 * Contoh lain:
 *
 * @EmptyOK String test;
 *
 * Jika:
 *
 * @Target(ElementType.FIELD)
 *
 * Maka annotation diterapkan pada:
 *
 * test -> Field
 *
 * Bukan pada tipe String.
 *
 * ---------------------------------------------------------------------------
 * PERBEDAAN KRUSIAL YANG SERING MEMBINGUNGKAN
 * ---------------------------------------------------------------------------
 *
 * Contoh:
 *
 * public @TypeAnno Integer f2()
 *
 * Annotation diterapkan pada:
 *
 * Integer -> Return Type
 *
 * Karena menggunakan:
 *
 * @Target(ElementType.TYPE_USE)
 *
 * ---------------------------------------------------------------------------
 *
 * Contoh:
 *
 * @Recommended
 * public Integer f3()
 *
 * Annotation diterapkan pada:
 *
 * Method f3()
 *
 * Karena menggunakan target deklarasi method.
 *
 * Meskipun posisi annotation terlihat mirip, target yang
 * sebenarnya berbeda sehingga maknanya juga berbeda.
 *
 * ---------------------------------------------------------------------------
 * BATASAN TYPE ANNOTATION
 * ---------------------------------------------------------------------------
 *
 * Contoh:
 *
 * public @TypeAnno void test()
 *
 * Tidak valid.
 *
 * Alasannya:
 *
 * void bukan tipe data yang dapat digunakan sebagai TYPE_USE
 * dalam konteks ini.
 *
 * Catatan:
 *
 * Pada praktiknya, Type Annotation digunakan pada tipe data
 * yang benar-benar merepresentasikan sebuah type.
 *
 * ---------------------------------------------------------------------------
 * ALUR KERJA TYPE ANNOTATION
 * ---------------------------------------------------------------------------
 *
 * Annotation Dengan TYPE_USE
 * -> Ditempel Pada Penggunaan Tipe
 * -> Compiler Menyimpan Metadata
 * -> Tools / Framework / Static Analyzer Membaca Metadata
 * -> Digunakan Untuk Validasi Atau Analisis Tambahan
 *
 * ---------------------------------------------------------------------------
 * KEGUNAAN TYPE ANNOTATION
 * ---------------------------------------------------------------------------
 *
 * Type Annotation banyak digunakan untuk:
 *
 * - Static Analysis.
 * - Validasi tambahan pada tipe data.
 * - Nullability Checking.
 * - Framework khusus yang memproses metadata tipe.
 * - Meningkatkan keamanan dan ketepatan kode.
 *
 * Contoh framework yang memanfaatkan konsep serupa:
 *
 * - Checker Framework
 * - Error Prone
 * - Berbagai static analysis tools
 *
 * ---------------------------------------------------------------------------
 * KESIMPULAN
 * ---------------------------------------------------------------------------
 *
 * Type Annotation adalah annotation yang diterapkan langsung pada
 * penggunaan tipe data (type usage).
 *
 * Fitur ini diperkenalkan sejak Java 8 melalui:
 *
 * @Target(ElementType.TYPE_USE)
 *
 * Type Annotation dapat digunakan pada:
 *
 * - Return Type
 * - Throws Clause
 * - Cast Expression
 * - Generic Type
 * - Object Creation
 * - Array Type
 * - Inheritance
 * - Receiver Parameter (this)
 *
 * Makna sebuah annotation ditentukan oleh target yang digunakan,
 * sehingga penting memahami perbedaan antara annotation pada
 * deklarasi dan annotation pada tipe data.
 */

import java.lang.annotation.*;

// CONTOH LENGKAP
// DEFINISI ANNOTATION

@Target(ElementType.TYPE_USE)
// Buat ke type data method
// Buat ke casting
@interface MyType {}

// Annotation untuk TYPE_PARAMETER (generic)
// Buat parameter class (Generic)
@Target(ElementType.TYPE_PARAMETER)
@interface InGeneric {
    String description();
}

// Marker annotation lain untuk TYPE_USE
// Buat constructor
// bUAT DI Creation object
@Target(ElementType.TYPE_USE)
@interface Unique {}

// Merker annotasi untuk type-use
// Buat type String 
// Buat ke THIS (Receiver)
// Buat ke RETURN TYPE
// Buat ke Throws 
// Buat ke Element type array
// Buat di Generic type argumen
// Buat di casting
// Buat di INHERITANCE + TYPE AND
@Target(ElementType.TYPE_USE)
@interface TypeAnno {}

// Annotation untuk FIELD
// Buat ke Field String test;
// @Target(ElementType.FIELD)
 @interface EmptyOk {}

 // Annotation untuk METHOD
 // Buat ke Method
@Target(ElementType.METHOD)
@interface Recomended {}

// Marker annotation lain untuk TYPE_USE
// Buat di array level
@Target(ElementType.TYPE_USE)
@interface NotZerolen {}

// Annotation dengan parameter untuk TYPE_USE
// Buat di array level
@Target(ElementType.TYPE_USE)
@interface Maxlen {
        int value();
}

public class TypeAnnotations<@InGeneric(description = "Generic data type") T> {

    // Constructor dengan type annotation
    public @Unique TypeAnnotations() {}

    // Annotation ke TYPE (String)
    @TypeAnno
    String string;

    // Annotation ke FIELD (bukan tipe)
    @EmptyOk
    String test;

    // Annotation ke THIS (receiver)
    public int f(@TypeAnno TypeAnnotations<T> this, int x) {
        return x * 2;
    }

    // Annotation ke RETURN TYPE
    public @TypeAnno Integer f2(int a, int b) {
        return a + b;
    }

    // Annotation ke METHOD
    @Recomended
    public Integer f3(String s) {
        return s.length();
    }

    // Annotation di throws
    public void f4() throws @TypeAnno NullPointerException {
        if (true)
            throw new NullPointerException("Contoh Exception");
    }

    // Annotation di ARRAY LEVEL
    String @Maxlen(10)[] @NotZerolen[] data;

    // Annotation ke ELEMENT TYPE array
    @TypeAnno
    Integer[] number;

    // Method static
    public static void myMeth(int i) {

        // Annotation di GENERIC TYPE ARGUMENT
        TypeAnnotations<@TypeAnno Integer> objct = new 
        TypeAnnotations<@TypeAnno Integer>();

        // Annotation di OBJECT CREATION
        @Unique TypeAnnotations<Integer> object2 = new 
        TypeAnnotations<>();

        Object x = Integer.valueOf(10);
        Integer y;

        // Annotation di cast
        y = (@TypeAnno Integer) x;
        System.out.println("Nilai y: " + y);
    }

    // Annotation ke tipe data method 
    public @MyType String test() {
        return "Hello";
    }

    public void run() {
        Object x = "Test";

        // cast dengan annotation
        String y = (@MyType String) x;
        System.out.println(y);
    }

    /**
     * ALUR KERJA (REALITY CHECK)
     *
     * Java compiler:
     * biasanya tidak ngecek ini
     *
     * Tool lain:
     * static analyzer
     * framework
     *
     * yang manfaatin:
     * Spring
     * Hibernate
     * Checker Framework
     * 
     * ---------------------------------
     *
     * INSIGHT LEVEL LANJUT
     * 
     * Kenapa ini ada?
     *
     * buat:
     * validasi tipe
     * keamanan
     * static analysis
     *
     * Contoh real:
     * @NonNull String name;
     *
     * tool bisa ngecek:
     * tidak boleh null
     */

    public static void main(String[] args) {
        
        // Method static
        myMeth(10);

        // Buat objek
        TypeAnnotations<Integer> demo = new TypeAnnotations<>();

        // Testing method biasa
        System.out.println("f2: " + demo.f2(5,3));
        System.out.println("f3: " + demo.f3("hello"));

        // Test exception
        try {
            demo.f4();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // INHERITANCE + TYPE AND
    class SomeClass extends @TypeAnno TypeAnnotations<Boolean> {}

}
