package ExploreJavaLang.ClassJava;

/**
 * ClassLoader
 *
 * Class abstract ClassLoader mendefinisikan bagaimana class di-load ke dalam JVM.
 *
 * Aplikasi lo bisa membuat subclass dari ClassLoader
 * dan meng-override method-nya
 *
 * Tujuannya:
 * load class dengan cara custom (tidak default JVM)
 *
 * Tapi:
 * ini jarang banget dilakukan di aplikasi biasa
 *
 * ----------------------------------------
 * 
 * Apa itu ClassLoader?
 * 
 * Saat lo bikin class:
 * class A {}
 *
 * JVM gak langsung tau class itu
 *
 * ClassLoader yang:
 * baca file .class
 * load ke memory
 * bikin bisa dipakai
 *
 * Flow Class Loading (WAJIB PAHAM)
 * .class file → ClassLoader → JVM Memory → jadi Class object
 *
 * -------------------------------------
 * 
 * Jenis ClassLoader (REAL DI JVM)
 * 1. Bootstrap ClassLoader
 * load core Java
 * contoh:
 * java.lang.*
 * String, Object
 *
 * 2. Extension ClassLoader
 * load library tambahan
 *
 * 3. Application ClassLoader
 * load class dari project lo
 *
 * Kenapa ClassLoader itu penting?
 * Karena:
 * Java itu dynamic loading
 *
 * class bisa:
 * diload saat runtime
 * bukan cuma compile time
 *
 * ------------------------------------------
 * 
 * Insight Penting (INI LEVEL DALAM)
 * 1. ClassLoader = security layer
 *
 * mencegah:
 * class berbahaya
 * override class core
 *
 * 2. ClassLoader Isolation
 * tiap classloader bisa punya namespace sendiri
 *
 * makanya:
 * di server (Tomcat, Spring Boot)
 * tiap app bisa punya dependency beda
 *
 * 3. Dipakai di Framework Besar
 * Contoh:
 * Spring Boot
 * Tomcat
 * OSGi
 *
 * buat:
 * hot reload
 * plugin system
 * dynamic module
 *
 * Kenapa Jarang Dipakai?
 *
 * Karena:
 * kompleks
 * rawan bug
 * butuh ngerti JVM dalam
 *
 * Analogi
 * Bayangin:
 * .class = buku 
 * ClassLoader = petugas perpustakaan 
 *
 * dia yang:
 * ambil buku
 * masukin ke rak (memory)
 * biar bisa dibaca program
 *
 * -----------------------------------
 * 
 * Relevansi Backend
 *
 * Dipakai di:
 * plugin system
 * dynamic module
 * framework (Spring Boot)
 * class reloading
 *
 * ----------------------------------------------
 * 
 * Kesimpulan Simpel
 *
 * ClassLoader = mekanisme load class ke JVM
 *
 * bisa:
 * custom cara load class
 * kontrol class behavior
 *
 * tapi:
 * jarang dipakai langsung
 * lebih sering dipakai oleh framework
 */

public class ClassLoaderJava {
    public static void main(String[] args) {
        
        // Ambil ClassLoader dari class ni
        ClassLoader classLoader = ClassLoaderJava.class.getClassLoader();

        // Cetak class Loader
        System.out.println(classLoader);
        // jdk.internal.loader.ClassLoaders$AppClassLoader@33909752

        System.out.println();

        // Contoh Advanced (Load Class Manual)
        try {
            // Load class secara dynamic
            Class<?> cls = Class.forName("java.lang.String");
            System.out.println("Class loaded: " + cls.getName());
            // Class loaded: java.lang.String

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
