package FundamentalJava.Annotasi;

/**
 * Konsep utama
 * Sebelum JDK 8 → annotation cuma bisa di declaration (class, method, field)
 * Setelah JDK 8 → annotation bisa dipakai di TYPE (tipe data)
 *
 * Ini disebut:
 * Type Annotation
 *
 * Bedanya:
 * Dulu:
 * @Anno
 * public void method() {}
 *
 * cuma nempel ke method
 *
 * Sekarang:
 * public @Anno String method() {}
 *
 * nempel ke:
 * String (TIPE)
 *
 * SYARAT WAJIB
 * Annotation harus punya:
 * @Target(ElementType.TYPE_USE)
 *
 * artinya:
 * boleh dipakai di semua penggunaan tipe
 *
 * TEMPAT-TEMPAT TYPE ANNOTATION
 * Ini penting banget bro
 *
 * 1. Return Type
 * public @TypeAnno Integer f2(int a, int b)
 *
 * annotation ke:
 * Integer (tipe return)
 *
 * 2. Throws
 * void test() throws @TypeAnno NullPointerException
 *
 * 3. Cast
 * y = (@TypeAnno Integer) x;
 *
 * 4. Generic
 * TypeAnnoDemo<@TypeAnno Integer> ob;
 *
 * 5. Object creation
 * new @TypeAnno TypeAnnoDemo<Integer>()
 *
 * 6. Array
 * String @MaxLen(10) [] @NotZeroLen [] w;
 * level array bisa beda annotation
 *
 * 7. Inheritance
 * class A extends @TypeAnno B {}
 *
 * 8. THIS (receiver)
 * public int f(@TypeAnno MyClass this, int x)
 * advanced banget ini
 *
 * -----------------------------------------------------------------
 * 
 * HAL PENTING BANGET
 * 1. Target menentukan arti
 * Ini:
 * @TypeAnno String str;
 * annotasi ke:
 * String (tipe)
 *
 * Ini:
 * @EmptyOK String test;
 * annotasi ke:
 * field test
 *
 * beda karena:
 * @Target(TYPE_USE)
 * @Target(FIELD)
 *
 * PERBEDAAN KRUSIAL (SERING BANGET SALAH)
 * Case penting:
 * public @TypeAnno Integer f2()
 * annotate:
 * RETURN TYPE
 *
 * public @Recommended Integer f3()
 * annotate:
 * METHOD
 *
 * walaupun posisinya sama 
 *
 * BATASAN
 * Tidak bisa:
 * public @TypeAnno void test()
 *
 * karena:
 * void bukan tipe yang bisa dianotasi
 *
 * ------------------------------------------------------------
 * 
 * KESIMPULAN
 * Type annotation = annotation di tipe
 *
 * Butuh:
 * @Target(TYPE_USE)
 * Bisa dipakai di:
 * return type
 * cast
 * generic
 * array
 * throws
 * inheritance
 * Arti tergantung @Target
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
