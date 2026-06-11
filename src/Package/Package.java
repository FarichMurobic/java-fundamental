package Package;

    /**
     * Packages adalah wadah untuk class.
     * Mereka digunakan untuk menjaga agar nama-nama class tidak tabrakan.
     *
     * Contoh:
     * Lu bisa bikin class bernama List di package lu sendiri, tanpa takut bentrok dengan List milik library lain.
     *
     * Packages disusun secara hierarki (bertingkat) dan harus di-import secara eksplisit ke dalam class lain.
     *
     * Package = Lemari / Folder
     * Bayangin lu punya banyak file:
     *
     * Tanpa folder:
     * List.java
     * User.java
     * Order.java
     * List.java (lagi tabrakan)
     *
     * Dengan package:
     * com.app.data.List
     * com.app.user.User
     * com.lib.collection.List
     *
     * Jadi aman, gak tabrakan nama
     *
     * Package itu:
     * Mekanisme untuk membagi namespace
     * Biar lebih terorganisir
     *
     * Selain itu, package juga:
     * Mengatur visibility (akses)
     *
     * Lu bisa:
     *
     * Bikin class yang tidak bisa diakses dari luar package
     * Bikin member (variable/method) yang hanya bisa diakses dalam package yang sama
     *
     * Jadi:
     *
     * Class dalam satu package bisa "saling kenal dalam"
     * Tapi tidak membuka semuanya ke dunia luar
     *
     * Package = Folder di Sistem
     * Biasanya struktur folder:
     *
     * com/
     *  └── app/
     *       ├── user/
     *       │    └── User.java
     *       └── admin/
     *            └── User.java
     *
     * Contoh Kode Package
     * Membuat Package
     * package com.app.user; // mendefinisikan package
     *
     * public class User {
     *
     *     String nama;
     *
     *     void tampilkan() {
     *         System.out.println("Nama: " + nama);
     *     }
     * }
     *
     * 🔹 Menggunakan Package (Import)
     * import com.app.user.User; // import class dari package lain
     *
     * public class Main {
     *     public static void main(String[] args) {
     *
     *         User u = new User(); // pakai class dari package
     *         u.nama = "Farich";
     *         u.tampilkan();
     *     }
     * }
     *
     * ---------------------------------------------
     * 
     * Visibility dalam Package (INI PENTING BANGET)
     *
     * Java punya level akses:
     *
     * Modifier	            Akses
     * public	            Bisa diakses dari mana saja
     * private	            Hanya dalam class itu sendiri
     * (default)	        Hanya dalam package yang sama
     * protected	        Package + subclass
     *
     * Kesimpulan
     * Yang wajib lu pegang:
     *
     * package harus di baris paling atas
     * Package = folder di sistem
     * Nama package harus sama dengan folder
     * Bisa multi-level (pakai titik)
     * Banyak file bisa dalam satu package
     * Untuk run:
     * harus pakai package.ClassName
     *
     * Khusus untuk Class (INI PENTING!)
     *
     * Class cuma punya 2 akses:
     * 1. public class
     * public class Main {
     * }
     *
     * Bisa diakses dari mana saja
     *
     * 2. default class
     * class Helper {
     * }
     *
     * Hanya bisa diakses dalam package yang sama
     *
     * Aturan Penting
     *
     * Kalau class public:
     * Nama file HARUS sama
     * Main.java → public class Main
     *
     * Ini error:
     * File: Test.java
     * public class Main // 
     */

public class Package {
    public static void main(String[] args) {
     
        System.out.println("Hii Janeraa.");
        System.out.println("Hi Farich");
    }
}
