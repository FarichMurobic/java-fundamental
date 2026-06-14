package ExploringJavaLang.Package;

/**
 * Package
 *
 * Class Package digunakan untuk menyimpan informasi versi (version data) yang terkait dengan sebuah package.
 *
 * Informasi versi ini semakin penting karena:
 * Banyaknya jumlah package di Java
 * Program Java kadang perlu tahu versi package yang sedang digunakan
 *
 * PENJELASAN MENDALAM
 * Package itu apa di konteks ini?
 *
 * Biasanya lo ngerti package sebagai:
 * package com.example;
 * Tapi di sini beda bro 
 *
 * java.lang.Package =
 * object yang menyimpan metadata tentang package
 *
 * Metadata itu apa?
 *
 * Contoh:
 * Nama package
 * Versi
 * Vendor
 * Specification
 *
 * Kenapa penting?
 * Di dunia nyata:
 *
 * Lo pakai library:
 * Spring
 * Hibernate
 * Jackson
 *
 * Kadang lo perlu tahu:
 * Versinya berapa?
 * Compatible gak?
 *
 * TABEL METHOD PACKAGE (LENGKAP + PENJELASAN)
 * Annotation Methods
 * Method	                                    Deskripsi
 * getAnnotation(Class<A>)	                    Ambil annotation tertentu
 * getAnnotations()	                            Ambil semua annotation
 * getAnnotationsByType(Class<A>)	            Ambil annotation berulang (JDK 8+)
 * getDeclaredAnnotation(Class<A>)	            Ambil annotation tanpa inheritance
 * getDeclaredAnnotations()	                    Semua annotation yang dideklarasikan
 * getDeclaredAnnotationsByType(Class<A>)	    Annotation berulang tanpa inheritance
 *
 * Informasi Package
 * Method	                                    Deskripsi
 * getImplementationTitle()	                    Nama/judul implementasi
 * getImplementationVendor()	                Vendor pembuat
 * getImplementationVersion()	                Versi implementasi
 * getName()	                                Nama package
 *
 * Static Methods
 * Method	                                    Deskripsi
 * getPackage(String)	                        Ambil package berdasarkan nama
 * getPackages()	                            Ambil semua package
 *
 * Specification Info
 * Method	                                    Deskripsi
 * getSpecificationTitle()	                    Judul spesifikasi
 * getSpecificationVendor()	                    Pemilik spesifikasi
 * getSpecificationVersion()	                Versi spesifikasi
 *
 * Utility Methods
 * Method	                                    Deskripsi
 * hashCode()	                                Hash code package
 * isAnnotationPresent()	                    Cek apakah ada annotation
 * isCompatibleWith(String)	                    Cek kompatibilitas versi
 * isSealed()	                                Cek apakah package sealed
 * isSealed(URL)	                            Cek sealed relatif ke URL
 * toString()	                                Representasi string
 *
 * HAL PENTING
 * Kenapa banyak field null?
 *
 * Kalau lo jalankan:
 * Title: null
 * Vendor: null
 * Version: null
 *
 * Itu normal
 *
 * Kenapa bisa null?
 * Karena data ini:
 * Diambil dari MANIFEST.MF (JAR file)
 *
 * Kalau gak ada:
 * nilainya null
 *
 * KAITAN KE DUNIA NYATA (BACKEND)
 * Dipakai di:
 * Library management
 * Version checking
 * Plugin system
 * Framework (Spring, dll)
 *
 * Contoh real:
 *
 * Misalnya:
 * Cek versi dependency sebelum jalan
 *
 * Contoh cek versi
 * Package pkg = Package.getPackage("java.lang");
 *
 * if (pkg != null) {
 *     System.out.println(pkg.getImplementationVersion());
 * }
 *
 * KESIMPULAN
 * Inti:
 * Package = metadata package
 * Menyimpan info:
 * Nama
 * Versi
 * Vendor
 *
 * Yang paling penting:
 * getPackages() → ambil semua
 * getName() → nama package
 * getImplementationVersion() → versi
 *
 * Insight penting:
 * Data sering null → karena tidak ada di manifest
 * Lebih sering dipakai oleh framework daripada programmer biasa
 *
 * Mindset backend
 * Ini bagian dari:
 * Reflection & metadata system di Java
 */

public class PackageJava {
    public static void main(String[] args) {

        // Demonstrasi penggunaan class Package
        // Array untuk menampung semua package
        Package pkgs[];

        // Mengambil semua package yang dikenali oleh JVM
        pkgs = Package.getPackages();

        // Loop semua package
        for (int i = 0; i < pkgs.length; i++) {

            // Menampilkan informasi package
            System.out.println(
                    "Nama Package: " + pkgs[i].getName() + " | " +

                            // Judul implementasi (biasanya dari MANIFEST.MF)
                            "Title: " + pkgs[i].getImplementationTitle() + " | " +

                            // Vendor (pembuat)
                            "Vendor: " + pkgs[i].getImplementationVendor() + " | " +

                            // Versi
                            "Version: " + pkgs[i].getImplementationVersion());

        }
    }
}
