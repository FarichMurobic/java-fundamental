package FundamentalJava.Package.Package1;

public class SubclassPackageSama extends Protection {

    SubclassPackageSama() {

        // kalo akses langsung.
        System.out.println(this.defaultVariabel);
        // System.out.println(this.privateVariabel); // error
        System.out.println(this.protectedVariabel);
        System.out.println(this.publicVariabel);

        // akses melalui objek
        Protection protection = new Protection();

        System.out.println(protection.defaultVariabel);
        // ystem.out.println(protection.privateVariabel); // error
        System.out.println(protection.protectedVariabel);
        System.out.println(protection.publicVariabel);

        /**
         * subclass package yang sama
         *
         * default bisa
         * private tidak bisa
         * protected bisa
         * public bisa
         */

    }
}
