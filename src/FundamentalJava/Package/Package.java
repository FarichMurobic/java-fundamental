package FundamentalJava.Package;

/**
 * ------------------------------------------------------------------------
 * PACKAGES
 * ------------------------------------------------------------------------
 * 
 * Packages adalah wadah untuk class-class di Java.
 * 
 * Fungsi utama package:
 * 1. Menjaga agar nama-nama class tidak bertabrakan (namespace management)
 * 2. Mengorganisir kode agar lebih terstruktur
 * 3. Mengatur visibility (tingkat akses) antar class
 * 
 * ------------------------------------------------------------------------
 * ANALOGI PACKAGE
 * ------------------------------------------------------------------------
 * 
 * Package = Lemari / Folder
 * 
 * Tanpa folder (package):
 *     List.java
 *     User.java
 *     Order.java
 *     List.java (tabrakan nama!)
 * 
 * Dengan package:
 *     com.app.data.List
 *     com.app.user.User
 *     com.app.order.Order
 *     com.lib.collection.List
 * 
 * Jadi aman, tidak tabrakan nama.
 * 
 * ------------------------------------------------------------------------
 * STRUKTUR HIERARKI PACKAGE
 * ------------------------------------------------------------------------
 * 
 * Package disusun secara hierarki (bertingkat) menggunakan titik (.)
 * 
 * Struktur folder di sistem:
 * 
 *     com/
 *     └── app/
 *          ├── user/
 *          │    └── User.java
 *          ├── admin/
 *          │    └── Admin.java
 *          └── util/
 *               └── Helper.java
 * 
 * Nama package:
 *     com.app.user
 *     com.app.admin
 *     com.app.util
 * 
 * ------------------------------------------------------------------------
 * MEMBUAT PACKAGE
 * ------------------------------------------------------------------------
 * 
 * Deklarasi package harus berada di baris PALING ATAS dari file.
 * 
 *     package com.app.user;
 * 
 *     public class User {
 *         String nama;
 * 
 *         void tampilkan() {
 *             System.out.println("Nama: " + nama);
 *         }
 *     }
 * 
 * Aturan:
 * - package harus di baris paling atas (sebelum import)
 * - Hanya boleh ada satu deklarasi package per file
 * - Nama package harus sesuai dengan struktur folder
 * 
 * ------------------------------------------------------------------------
 * MENGGUNAKAN PACKAGE (IMPORT)
 * ------------------------------------------------------------------------
 * 
 * Untuk menggunakan class dari package lain, gunakan import.
 * 
 *     import com.app.user.User;     // import satu class
 *     import com.app.user.*;        // import semua class dalam package
 * 
 *     public class Main {
 *         public static void main(String[] args) {
 *             User u = new User();
 *             u.nama = "Farich";
 *             u.tampilkan();
 *         }
 *     }
 * 
 * ------------------------------------------------------------------------
 * VISIBILITY DALAM PACKAGE (INI PENTING BANGET)
 * ------------------------------------------------------------------------
 * 
 * Java memiliki 4 level akses (access modifier):
 * 
 * Modifier     | Akses
 * -------------|-----------------------------------------------------------
 * public       | Bisa diakses dari mana saja (dunia luar)
 * private      | Hanya dalam class itu sendiri
 * (default)    | Hanya dalam package yang sama (tanpa modifier)
 * protected    | Dalam package yang sama + subclass di luar package
 * 
 * ------------------------------------------------------------------------
 * ATURAN KHUSUS UNTUK CLASS
 * ------------------------------------------------------------------------
 * 
 * Class hanya memiliki 2 level akses:
 * 
 * 1. public class
 * 
 *     public class Main {
 *         // ...
 *     }
 * 
 *    Bisa diakses dari mana saja.
 *    Nama file HARUS sama dengan nama class.
 * 
 * 2. default class (tanpa modifier)
 * 
 *     class Helper {
 *         // ...
 *     }
 * 
 *    Hanya bisa diakses dalam package yang sama.
 * 
 * ------------------------------------------------------------------------
 * ATURAN PENTING
 * ------------------------------------------------------------------------
 * 
 * 1. Jika class public:
 *    Nama file HARUS sama dengan nama class.
 * 
 *    File: Main.java
 *    public class Main { ... }    // BENAR
 * 
 *    File: Test.java
 *    public class Main { ... }    // ERROR! Nama file harus Main.java
 * 
 * 2. Satu file bisa memiliki banyak class,
 *    tapi hanya satu yang boleh public.
 * 
 * 3. Nama package harus menggunakan huruf kecil (konvensi Java).
 * 
 * ------------------------------------------------------------------------
 * KONVENSI PENAMAAN PACKAGE
 * ------------------------------------------------------------------------
 * 
 * - Gunakan huruf kecil semua
 * - Gunakan domain perusahaan terbalik (reverse domain)
 * 
 * Contoh:
 *     com.perusahaan.app.module
 *     org.organisasi.proyek.submodul
 *     id.saya.aplikasi.utility
 * 
 * ------------------------------------------------------------------------
 * CONTOH LENGKAP
 * ------------------------------------------------------------------------
 * 
 * File: com/app/user/User.java
 * 
 *     package com.app.user;
 * 
 *     public class User {
 *         private String nama;
 *         int umur; // default, hanya bisa diakses dalam package yang sama
 * 
 *         public User(String nama, int umur) {
 *             this.nama = nama;
 *             this.umur = umur;
 *         }
 * 
 *         public void tampilkan() {
 *             System.out.println("Nama: " + nama + ", Umur: " + umur);
 *         }
 *     }
 * 
 * File: com/app/admin/Admin.java
 * 
 *     package com.app.admin;
 * 
 *     import com.app.user.User; // import dari package lain
 * 
 *     public class Admin {
 *         public void kelolaUser(User u) {
 *             // u.nama = "Budi"; // ERROR! private tidak bisa diakses
 *             u.umur = 30; // BISA! default, tapi beda package? TIDAK BISA!
 *             // Karena default hanya bisa diakses dalam package yang sama
 *         }
 *     }
 * 
 * ------------------------------------------------------------------------
 * KESIMPULAN WAJIB
 * ------------------------------------------------------------------------
 * 
 * - package harus di baris paling atas
 * - Package = folder di sistem
 * - Nama package harus sama dengan struktur folder
 * - Bisa multi-level (pakai titik)
 * - Banyak file bisa dalam satu package
 * - Untuk menjalankan: java package.ClassName
 * - Class public → nama file harus sama
 * - Class default → hanya dalam package yang sama
 * 
 * ------------------------------------------------------------------------
 */

public class Package {
    public static void main(String[] args) {
     
        System.out.println("Hii Janeraa.");
        System.out.println("Hi Farich");
    }
}
