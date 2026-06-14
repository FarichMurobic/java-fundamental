package ExploringJavaLang.System;

/**
 * System
 *
 * Class System berisi kumpulan:
 * method static
 * variabel static
 *
 * Artinya: lo gak perlu bikin object — langsung pakai
 *
 * Standard I/O
 *
 * Input, output, dan error di Java disimpan di:
 * in → input (keyboard)
 * out → output (console)
 * err → error output
 *
 * Security
 * Beberapa method bisa melempar SecurityException kalau:
 * tidak diizinkan oleh security manager
 *
 * Bagian 1
 * Method	                                                                                        Description
 * static void arraycopy(Object source, int sourceStart, Object target, int targetStart, int size)	Menyalin array
 * static String clearProperty(String which)	                                                    Menghapus property
 * static Console console()	                                                                        Mengambil console JVM
 * static long currentTimeMillis()	                                                                Waktu sejak 1 Jan 1970 (ms)
 * static void exit(int exitCode)	                                                                Menghentikan program
 * static void gc()	                                                                                Menjalankan garbage collector
 *
 * Bagian 2
 * Method	                                                    Description
 * static Map<String, String> getenv()	                        Ambil semua environment variable
 * static String getenv(String which)	                        Ambil environment variable tertentu
 * static Properties getProperties()	                        Ambil semua system properties
 * static String getProperty(String which)	                    Ambil property
 * static String getProperty(String which, String default)	    Ambil property dengan default
 * static SecurityManager getSecurityManager()	                Ambil security manager
 * static int identityHashCode(Object obj)	                    Hash code unik object
 * static Channel inheritedChannel()	                        Channel dari JVM
 * static String lineSeparator()	                            Karakter newline OS
 *
 * Bagian 3
 * Method	                                                    Description
 * static void load(String libraryFileName)	                    Load library (path lengkap)
 * static void loadLibrary(String libraryName)	                Load library berdasarkan nama
 * static String mapLibraryName(String lib)	                    Nama library sesuai OS
 * static long nanoTime()	                                    Waktu presisi tinggi (nano)
 * static void runFinalization()	                            Jalankan finalize()
 * static void setErr(PrintStream eStream)	                    Set error output
 * static void setIn(InputStream iStream)	                    Set input
 * static void setOut(PrintStream oStream)	                    Set output
 * static void setProperties(Properties)	                    Set system properties
 * static String setProperty(String which, String v)	        Set property
 * static void setSecurityManager(SecurityManager)	            Set security manager
 *
 * Apa itu System?
 * System = gateway ke OS + JVM basic tools
 *
 * Insight Penting
 * System vs Runtime
 * System	            Runtime
 * static utility	    instance
 * gampang dipakai	    lebih advanced
 * basic ops	        control JVM
 *
 * Jangan sering pakai:
 * System.gc()
 * System.exit()
 *
 * karena bisa ganggu flow program
 *
 * Real Use di Backend
 * Dipakai di:
 * logging
 * monitoring system
 * environment config
 * performance measurement
 * system integration
 *
 * Kesimpulan Simpel
 *
 * System = utility utama Java (akses ke OS & JVM dasar)
 *
 * paling sering:
 * System.out → print
 * System.in → input
 * System.err → error
 * currentTimeMillis() → waktu
 * getProperty() → info sistem
 *
 * keunggulan:
 * simple
 * langsung pakai
 * powerful buat basic system ops
 */

import java.util.Map;

public class SystemJava {
    public static void main(String[] args) {

        // OUTPUT
        System.out.println("Hello dari system.out"); // output biasa
        System.err.println("Ini error output"); // output error

        // WAKTU
        long millis = System.currentTimeMillis(); // waktu dalam milisecond
        long nano = System.nanoTime();  // waktu dalam nanosecond

        System.out.println("Milis: " + millis);
        System.out.println("Nano: " + nano);

        // SYSTEM PROPERTY
        String os = System.getProperty("os.name"); // nama OS
        System.out.println("Os: " + os);

        // ENVIRONMENT VARIABLE
        Map<String, String> env = System.getenv(); // semua env variable
        System.out.println("Path: " + env.get("PATH"));

        // ARRAY COPY
        int[] a = {1,2,3,4};
        int[] b = new int[4];

        // copy array dari a ke b
        System.arraycopy(a,0, b,0,4);

        for (int x : b) {
            System.out.print(x + " ");
        }

        // GC
        System.gc(); // request garbage collection

        // EXIT
        // System.exit(0); // (di-comment biar program gak langsung mati)

    }
}
