package FundamentalJava.Package.Package1;

import FundamentalJava.Package.Package2.BedaPackage;

public class MainApps {
    public static void main(String[] args) {

        System.out.println("--- Test di package yang sama berbeda class dan bukan subclass ---");
        // DALAM PACKAGE YANG SAMA.
        // buat objek class Protection
        // semuanya bisa dipanggil karena ada di dalam constructor class Protection
        Protection protection = new Protection();

        System.out.println();

        // Namun jika mengakses langsung dari clas yang berbeda, ini yang terjadi
        // panggil variabel instance dari clas Protection
        System.out.println(protection.defaultVariabel); // default bisa
        // System.out.println(protection.privateVariabel); // private error
        System.out.println(protection.protectedVariabel); // protected bisa
        System.out.println(protection.publicVariabel); // public bisa

        System.out.println();

        // panggil methode dari class Protection
        protection.methodeDefault(); // default bisa
        // protection.methodePrivate(); // private error
        protection.methodeProtected(); // protected bisa
        protection.methodePublic(); // public bisa

        System.out.println();

        System.out.println("--- Test di package yang sama tapi subclass ---");

    }
}
