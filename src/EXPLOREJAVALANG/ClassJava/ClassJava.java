package ExploreJavaLang.ClassJava;

/**
 * Class
 *
 * Class, Class digunakan untuk:
 * merepresentasikan informasi sebuah class atau interface saat runtime
 *
 * Penting
 * Object Class dibuat otomatis oleh JVM saat class di-load
 * Lo tidak bisa membuat object Class secara manual
 *
 * Cara dapat object Class
 * obj.getClass()
 *
 * method ini berasal dari Object
 *
 * Generic
 * class Class<T>
 *
 * T = tipe class yang direpresentasikan
 *
 * Load Class
 * Method	                Fungsi
 * forName(String name)	    Load class berdasarkan nama
 *
 * Annotation
 * Method	                Fungsi
 * getAnnotation()	        Ambil annotation
 * getAnnotations()	        Ambil semua annotation
 *
 * Constructor
 * Method	                Fungsi
 * getConstructor()	        Ambil constructor tertentu
 * getConstructors()	    Ambil semua constructor public
 *
 * Field (Variable)
 * Method	                Fungsi
 * getField()	            Field public
 * getFields()	            Semua field public
 * getDeclaredFields()	    Semua field (termasuk private)
 *
 * Method
 * Method	                Fungsi
 * getMethod()	            Method public
 * getMethods()	            Semua method public
 * getDeclaredMethods()	    Semua method
 *
 * Info Class
 * Method	                Fungsi
 * getName()	            Nama class
 * getSuperclass()	        Parent class
 * getInterfaces()	        Interface yang diimplementasi
 * isInterface()	        Cek interface
 *
 * Instance
 * Method	                Fungsi
 * newInstance()	        Buat object baru
 *
 * --------------------------------------------
 * 
 * Apa itu Class Object?
 * Ini adalah “metadata” dari class
 *
 * Contoh:
 * String s = "Hello";
 *
 * lo bisa tanya:
 * ini class apa?
 * punya method apa?
 * punya field apa?
 *
 * -------------------------------
 * 
 * Inilah Reflection
 *
 * kemampuan Java:
 * melihat struktur class saat runtime
 * bahkan manipulasi
 *
 * Insight Penting (INI LEVEL ADVANCE)
 * 1. Reflection = powerful tapi berbahaya
 *
 * Bisa:
 * akses private field
 * invoke method
 * create object dynamic
 *
 * 2. Dipakai di framework besar
 *
 * contoh:
 * Spring Boot
 * Hibernate
 * Jackson
 *
 * 3. newInstance() (HATI-HATI)
 * clObj.newInstance();
 *
 * butuh:
 * constructor default
 * tidak abstract
 *
 * sekarang sudah deprecated (Java modern)
 *
 * Analogi
 *
 * Bayangin:
 * class = blueprint rumah 
 * object = rumah jadi
 *
 * Class = blueprint inspector 
 * bisa lihat semua detail
 *
 * ----------------------------------------
 * 
 * Relevansi Backend (INI YANG LO HARUS TAU)
 *
 * Dipakai di:
 * Dependency Injection (Spring)
 * ORM (Hibernate)
 * JSON mapping (Jackson)
 * Annotation processing
 *
 * tanpa ini → framework modern gak jalan
 *
 * -------------------------------------------
 * 
 * Kesimpulan Simpel
 * Class = representasi class saat runtime
 *
 * bisa:
 * lihat struktur class
 * ambil method/field
 * cek inheritance
 *
 * didapat dari:
 * obj.getClass()
 *
 * ini dasar dari:
 * Reflection API
 */

// class X
class X {
    int a;
    float b;
}

// CLASS Y extends X
class Y extends X {
    double c;
}
public class ClassJava {
    public static void main(String[] args) {
        
        // MEMBAUT OBJEK
        X x = new X();
        Y y = new Y();

        // Variable untuk menyimpan class object
        Class<?> classObject;

        // Ambil class dari object X
        classObject = x.getClass();
        System.out.println("X is object type of type: " + classObject.getName());
        // X is object type of type: EXPLOREJAVALANG.ClassJava.X

        // Ambil class dari object Y
        classObject = y.getClass();
        System.out.println("Y is object type of type: " + classObject.getName());
        // Y is object type of type: EXPLOREJAVALANG.ClassJava.Y

        // Ambil superclass dari Y
        classObject = classObject.getSuperclass();
        System.out.println(classObject.getName());
        // EXPLOREJAVALANG.ClassJava.X

        // Ambil superclass dari Y
        classObject = y.getClass().getSuperclass();
        System.out.println("Y's superclass is: " + classObject.getName());
        // Y's superclass is: EXPLOREJAVALANG.ClassJava.X

        
        /**
         * Penjelasan 
         * 
         * Ambil class dari object
         * classObject = x.getClass();
         *
         * hasil:
         * X
         *
         * Ambil nama class
         * classObject.getName();
         * 
         * Ambil parent class
         * clObj.getSuperclass();
         *
         * dari Y → X
         */
    }
}
