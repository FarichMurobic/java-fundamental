package FundamentalJava.Package.Package2;

import FundamentalJava.Package.Package1.Protection;

public class SubclassBedaPackage extends Protection {

    SubclassBedaPackage() {

        // karena kelas turunan kita gak perlu buat objek

        // System.out.println(defaultVariabel); error
        // System.out.println(privateVariabel); error
        System.out.println(protectedVariabel); // bisa
        System.out.println(publicVariabel); // bisa

        System.out.println();

        // methodeDefault(); error
        // methodePrivate(); error
        methodeProtected(); // error
        methodePublic(); // error

        System.out.println();

        // atau gunakan this
        System.out.println(this.protectedVariabel);
        System.out.println(this.publicVariabel);
        this.methodeProtected();
        this.methodePublic();

        // Namun jika kita membuat object Protection, protected tidak bisa diakses
        Protection protection = new Protection();

        // System.out.println(protection.protectedVariabel); melalui referensi ini akan error
        System.out.println(protection.publicVariabel);

    }
}
