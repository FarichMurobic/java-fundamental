package FundamentalJava.Package.Package2;

import FundamentalJava.Package.Package1.Protection;

// class biasa beda package bukan subclass, mencoba akses Protection.
public class BedaPackage {
    public BedaPackage() {
        Protection p = new Protection();

        // mencoba akses variabel Protection
        System.out.println();
        // System.out.println(p.defaultVariabel); // default, error
        // System.out.println(p.privateVariabel); // private, error
        // System.out.println(p.protectedVariabel); // protected, error
        System.out.println(p.publicVariabel); // public bisa

        // mencoba akses methode
        // p.methodeDefault(); // error
        // p.methodePrivate(); // error
        // p.methodeProtected(); // error
        p.methodePublic(); // error

        /**
         * beda package bukan subclass
         *
         * default tidak bisa
         * private tidak bisa
         * protected tidak bisa
         * public bisa
         */

    }
}
