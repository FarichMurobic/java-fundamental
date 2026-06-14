package ExploringJavaLang.System;

/**
 * Environment Properties
 *
 * Properti berikut tersedia di semua environment Java:
 * file.separator
 * java.class.path
 * java.class.version
 * java.compiler
 * java.ext.dirs
 * java.home
 * java.io.tmpdir
 * java.library.path
 * java.specification.name
 * java.specification.version
 * java.vendor
 * java.vendor.url
 * java.version
 * java.vm.name
 * java.vm.version
 * line.separator
 * os.arch
 * os.name
 * os.version
 * java.vm.specification.name
 * java.vm.specification.vendor
 * java.vm.specification.version
 * java.vm.vendor
 * java.specification.vendor
 * path.separator
 * user.dir
 * user.home
 * user.name
 *
 * Lo bisa mendapatkan nilai dari property tersebut dengan method:
 * System.getProperty()
 *
 * Apa itu Environment Properties?
 * Ini adalah informasi tentang sistem + JVM + user
 *
 * Cara akses
 * System.getProperty("nama_property");
 *
 * FILE & PATH
 * Property	        Arti
 * file.separator	pemisah folder (/ atau \)
 * path.separator	pemisah PATH (; atau :)
 *
 * JAVA INFO
 * Property	        Arti
 * java.version	    versi Java
 * java.home	    lokasi instalasi Java
 * java.class.path	classpath
 *
 * OS INFO
 * Property	        Arti
 * os.name	        nama OS
 * os.arch	        arsitektur (x86, amd64)
 * os.version	    versi OS
 *
 * USER INFO
 * Property	        Arti
 * user.name	    nama user
 * user.home	    home directory
 * user.dir	        current working directory
 *
 * JVM INFO
 * Property	        Arti
 * java.vm.name	    nama JVM
 * java.vm.version	versi JVM
 *
 * Insight Mendalam (WAJIB PAHAM)
 * Property vs Environment Variable
 * System.getProperty	    System.getenv
 * dari JVM	                dari OS
 * bisa di-set Java	        dari sistem
 * contoh: user.dir	        contoh: PATH
 *
 * Penting
 * Jangan hardcode path
 * Gunakan:
 *
 * System.getProperty("file.separator");
 * biar cross-platform
 *
 * Analogi
 *
 * Bayangin:
 * System.getProperty() = info dari dalam Java 
 * System.getenv() = info dari luar (OS) 
 *
 * Relevansi ke Backend
 *
 * Dipakai buat:
 * konfigurasi aplikasi
 * baca environment server
 * set path file
 * multi-platform support
 * deployment (Docker, Linux, Windows)
 *
 * Kesimpulan Simpel
 *
 * Environment properties = info penting tentang:
 * Java
 * OS
 * user
 * file system
 *
 * diakses pakai:
 * System.getProperty("key");
 *
 * penting buat:
 * config
 * portability
 * backend system
 */

public class EnvironmentProperties {
    public static void main(String[] args) {

        // Mengambil property "user.dir"
        // Ini biasanya adalah folder tempat program dijalankan
        String currentDir = System.getProperty("user.dir"); // D:\Java\Java Fundamental\Belajar Java Fundamental 2
        System.out.println(currentDir);

        // Contoh Lebih Lengkap (REAL USE)

        // OS INFO
        System.out.println("OS: " + System.getProperty("os.name"));
        System.out.println("OS Version: " + System.getProperty("os.version"));

        // JAVA INFO
        System.out.println("Java version: " + System.getProperty("java.version"));
        System.out.println("Java home: " + System.getProperty("java.home"));

        // USER INFO
        System.out.println("User: " + System.getProperty("user.name"));
        System.out.println("User home: " + System.getProperty("user.home"));
        System.out.println("Current dir: " + System.getProperty("user.dir"));

        // FILE SYSTEM
        System.out.println("File separator: " + System.getProperty("file.separator"));

    }
}
